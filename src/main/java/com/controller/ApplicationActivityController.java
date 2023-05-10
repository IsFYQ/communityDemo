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

import com.entity.ApplicationActivityEntity;
import com.entity.view.ApplicationActivityView;

import com.service.ApplicationActivityService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 申请参加
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@RestController
@RequestMapping("/shenqingcanjia")
public class ApplicationActivityController {
    @Autowired
    private ApplicationActivityService applicationActivityService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ApplicationActivityEntity shenqingcanjia,
                  HttpServletRequest request){

        EntityWrapper<ApplicationActivityEntity> ew = new EntityWrapper<ApplicationActivityEntity>();


		String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
		if(tableName.equals("xuesheng")) {
            ew.eq("shenqingxueshengzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
            ew.or();
            ew.eq("xueshengzhanghao", (String)request.getSession().getAttribute("username"));
		}
		PageUtils page = applicationActivityService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingcanjia), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ApplicationActivityEntity shenqingcanjia,
                  HttpServletRequest request){
        EntityWrapper<ApplicationActivityEntity> ew = new EntityWrapper<ApplicationActivityEntity>();

		PageUtils page = applicationActivityService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingcanjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ApplicationActivityEntity shenqingcanjia){
       	EntityWrapper<ApplicationActivityEntity> ew = new EntityWrapper<ApplicationActivityEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenqingcanjia, "shenqingcanjia")); 
        return R.ok().put("data", applicationActivityService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ApplicationActivityEntity shenqingcanjia){
        EntityWrapper<ApplicationActivityEntity> ew = new EntityWrapper<ApplicationActivityEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenqingcanjia, "shenqingcanjia")); 
		ApplicationActivityView shenqingcanjiaView =  applicationActivityService.selectView(ew);
		return R.ok("查询申请参加成功").put("data", shenqingcanjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ApplicationActivityEntity shenqingcanjia = applicationActivityService.selectById(id);
        return R.ok().put("data", shenqingcanjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ApplicationActivityEntity shenqingcanjia = applicationActivityService.selectById(id);
        return R.ok().put("data", shenqingcanjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ApplicationActivityEntity shenqingcanjia, HttpServletRequest request){
    	shenqingcanjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenqingcanjia);

        applicationActivityService.insert(shenqingcanjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ApplicationActivityEntity shenqingcanjia, HttpServletRequest request){
    	shenqingcanjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenqingcanjia);

        applicationActivityService.insert(shenqingcanjia);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ApplicationActivityEntity shenqingcanjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingcanjia);
        applicationActivityService.updateById(shenqingcanjia);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        applicationActivityService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ApplicationActivityEntity> wrapper = new EntityWrapper<ApplicationActivityEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = applicationActivityService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
