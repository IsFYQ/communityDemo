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

import com.entity.JoinClubEntity;
import com.entity.view.JoinClubView;

import com.service.JoinClubService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 加入社团
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@RestController
@RequestMapping("/jiarushetuan")
public class JoinClubController {
    @Autowired
    private JoinClubService joinClubService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, JoinClubEntity jiarushetuan,
                  HttpServletRequest request){

        EntityWrapper<JoinClubEntity> ew = new EntityWrapper<JoinClubEntity>();


		String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
		if(tableName.equals("xuesheng")) {
            ew.eq("jiaruxueshengzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
            ew.or();
            ew.eq("xueshengzhanghao", (String)request.getSession().getAttribute("username"));
		}
		PageUtils page = joinClubService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiarushetuan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, JoinClubEntity jiarushetuan,
                  HttpServletRequest request){
        EntityWrapper<JoinClubEntity> ew = new EntityWrapper<JoinClubEntity>();

		PageUtils page = joinClubService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiarushetuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JoinClubEntity jiarushetuan){
       	EntityWrapper<JoinClubEntity> ew = new EntityWrapper<JoinClubEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiarushetuan, "jiarushetuan")); 
        return R.ok().put("data", joinClubService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JoinClubEntity jiarushetuan){
        EntityWrapper<JoinClubEntity> ew = new EntityWrapper<JoinClubEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiarushetuan, "jiarushetuan")); 
		JoinClubView jiarushetuanView =  joinClubService.selectView(ew);
		return R.ok("查询加入社团成功").put("data", jiarushetuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JoinClubEntity jiarushetuan = joinClubService.selectById(id);
        return R.ok().put("data", jiarushetuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JoinClubEntity jiarushetuan = joinClubService.selectById(id);
        return R.ok().put("data", jiarushetuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JoinClubEntity jiarushetuan, HttpServletRequest request){
    	jiarushetuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiarushetuan);

        joinClubService.insert(jiarushetuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JoinClubEntity jiarushetuan, HttpServletRequest request){
    	jiarushetuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiarushetuan);

        joinClubService.insert(jiarushetuan);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JoinClubEntity jiarushetuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiarushetuan);
        joinClubService.updateById(jiarushetuan);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        joinClubService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JoinClubEntity> wrapper = new EntityWrapper<JoinClubEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = joinClubService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
