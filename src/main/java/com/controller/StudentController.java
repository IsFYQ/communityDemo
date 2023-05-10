package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.StudentEntity;
import com.entity.view.StudentView;

import com.service.StudentService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 学生
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@RestController
@RequestMapping("/xuesheng")
public class StudentController {
    @Autowired
    private StudentService studentService;

	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		StudentEntity u = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("xueshengzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(u.getId(), username,"xuesheng",  "学生" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	// 注册代码
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody StudentEntity xuesheng){
		// 注入studentService，以调用studentService中的方法
		// selectOne()继承自IService，获取一个学生类的包装类，这里用来查询xueshengzhanghao 字段等于 xuesheng.getXueshengzhanghao() 的记录，并将其放到u中。
    	StudentEntity u = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("xueshengzhanghao", xuesheng.getXueshengzhanghao()));
		// 如果u不为空，就是已经有这个账号了，将错误信息放入R类的msg中
    	if(u!=null) {
			return R.error("注册用户已存在");
		}

    	// 获取当前时间作为一个时间戳（具有唯一性）赋给学生的主键id
		Long uId = new Date().getTime();
		xuesheng.setId(uId);

		// 将数据插入到数据库中
		// insert()继承自IService，将xuesheng插入到student表中
        studentService.insert(xuesheng);

        return R.ok();
    }

	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        StudentEntity u = studentService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	StudentEntity u = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("xueshengzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
    	u.setMima("123456");
        studentService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, StudentEntity xuesheng,
                  HttpServletRequest request){

        EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();


		PageUtils page = studentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuesheng), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, StudentEntity xuesheng,
                  HttpServletRequest request){
        EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();

		PageUtils page = studentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuesheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( StudentEntity xuesheng){
       	EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuesheng, "xuesheng")); 
        return R.ok().put("data", studentService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(StudentEntity xuesheng){
        EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuesheng, "xuesheng")); 
		StudentView xueshengView =  studentService.selectView(ew);
		return R.ok("查询学生成功").put("data", xueshengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        StudentEntity xuesheng = studentService.selectById(id);
        return R.ok().put("data", xuesheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        StudentEntity xuesheng = studentService.selectById(id);
        return R.ok().put("data", xuesheng);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StudentEntity xuesheng, HttpServletRequest request){
    	xuesheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuesheng);
    	StudentEntity u = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("xueshengzhanghao", xuesheng.getXueshengzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}

		xuesheng.setId(new Date().getTime());
        studentService.insert(xuesheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody StudentEntity xuesheng, HttpServletRequest request){
    	xuesheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuesheng);
    	StudentEntity u = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("xueshengzhanghao", xuesheng.getXueshengzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}

		xuesheng.setId(new Date().getTime());
        studentService.insert(xuesheng);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody StudentEntity xuesheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuesheng);
        studentService.updateById(xuesheng);//全部更新
        return R.ok();
    }



    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        studentService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<StudentEntity> wrapper = new EntityWrapper<StudentEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = studentService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
