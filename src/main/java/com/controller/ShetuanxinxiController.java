package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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

import com.entity.ClubInformationEntity;
import com.entity.view.ClubInformationView;

import com.service.ClubInformationService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 社团信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@RestController
@RequestMapping("/shetuanxinxi")
public class ShetuanxinxiController {
    @Autowired
    private ClubInformationService clubInformationService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ClubInformationEntity shetuanxinxi,
                  HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			shetuanxinxi.setXueshengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ClubInformationEntity> ew = new EntityWrapper<ClubInformationEntity>();


		PageUtils page = clubInformationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ClubInformationEntity shetuanxinxi,
                  HttpServletRequest request){
        EntityWrapper<ClubInformationEntity> ew = new EntityWrapper<ClubInformationEntity>();

		PageUtils page = clubInformationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ClubInformationEntity shetuanxinxi){
       	EntityWrapper<ClubInformationEntity> ew = new EntityWrapper<ClubInformationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shetuanxinxi, "shetuanxinxi")); 
        return R.ok().put("data", clubInformationService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ClubInformationEntity shetuanxinxi){
        EntityWrapper<ClubInformationEntity> ew = new EntityWrapper<ClubInformationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shetuanxinxi, "shetuanxinxi")); 
		ClubInformationView shetuanxinxiView =  clubInformationService.selectView(ew);
		return R.ok("查询社团信息成功").put("data", shetuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ClubInformationEntity shetuanxinxi = clubInformationService.selectById(id);
		shetuanxinxi.setClicknum(shetuanxinxi.getClicknum()+1);
		shetuanxinxi.setClicktime(new Date());
		clubInformationService.updateById(shetuanxinxi);
        return R.ok().put("data", shetuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ClubInformationEntity shetuanxinxi = clubInformationService.selectById(id);
		shetuanxinxi.setClicknum(shetuanxinxi.getClicknum()+1);
		shetuanxinxi.setClicktime(new Date());
		clubInformationService.updateById(shetuanxinxi);
        return R.ok().put("data", shetuanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ClubInformationEntity shetuanxinxi, HttpServletRequest request){
    	shetuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shetuanxinxi);

        clubInformationService.insert(shetuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ClubInformationEntity shetuanxinxi, HttpServletRequest request){
    	shetuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shetuanxinxi);

        clubInformationService.insert(shetuanxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ClubInformationEntity shetuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shetuanxinxi);
        clubInformationService.updateById(shetuanxinxi);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        clubInformationService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ClubInformationEntity> wrapper = new EntityWrapper<ClubInformationEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xueshengzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = clubInformationService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params, ClubInformationEntity shetuanxinxi, HttpServletRequest request, String pre){
        EntityWrapper<ClubInformationEntity> ew = new EntityWrapper<ClubInformationEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = clubInformationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanxinxi), params), params));
        return R.ok().put("data", page);
    }









}
