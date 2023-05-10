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

import com.entity.DissolveClubEntity;
import com.entity.view.DissolveClubView;

import com.service.DissolveClubService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 解散社团
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@RestController
@RequestMapping("/jiesanshetuan")
public class DissolveClubController {
    @Autowired
    private DissolveClubService dissolveClubService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DissolveClubEntity jiesanshetuan,
                  HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			jiesanshetuan.setXueshengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DissolveClubEntity> ew = new EntityWrapper<DissolveClubEntity>();


		PageUtils page = dissolveClubService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiesanshetuan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DissolveClubEntity jiesanshetuan,
                  HttpServletRequest request){
        EntityWrapper<DissolveClubEntity> ew = new EntityWrapper<DissolveClubEntity>();

		PageUtils page = dissolveClubService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiesanshetuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DissolveClubEntity jiesanshetuan){
       	EntityWrapper<DissolveClubEntity> ew = new EntityWrapper<DissolveClubEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiesanshetuan, "jiesanshetuan")); 
        return R.ok().put("data", dissolveClubService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DissolveClubEntity jiesanshetuan){
        EntityWrapper<DissolveClubEntity> ew = new EntityWrapper<DissolveClubEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiesanshetuan, "jiesanshetuan")); 
		DissolveClubView jiesanshetuanView =  dissolveClubService.selectView(ew);
		return R.ok("查询解散社团成功").put("data", jiesanshetuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DissolveClubEntity jiesanshetuan = dissolveClubService.selectById(id);
        return R.ok().put("data", jiesanshetuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DissolveClubEntity jiesanshetuan = dissolveClubService.selectById(id);
        return R.ok().put("data", jiesanshetuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DissolveClubEntity jiesanshetuan, HttpServletRequest request){
    	jiesanshetuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiesanshetuan);

        dissolveClubService.insert(jiesanshetuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DissolveClubEntity jiesanshetuan, HttpServletRequest request){
    	jiesanshetuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiesanshetuan);

        dissolveClubService.insert(jiesanshetuan);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DissolveClubEntity jiesanshetuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiesanshetuan);
        dissolveClubService.updateById(jiesanshetuan);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dissolveClubService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DissolveClubEntity> wrapper = new EntityWrapper<DissolveClubEntity>();
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

		int count = dissolveClubService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
