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

import com.entity.NewClubEntity;
import com.entity.view.NewClubView;

import com.service.NewClubService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 建立社团
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@RestController
@RequestMapping("/jianlishetuan")
public class NewClubController {
    @Autowired
    private NewClubService newClubService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, NewClubEntity jianlishetuan,
                  HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			jianlishetuan.setXueshengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<NewClubEntity> ew = new EntityWrapper<NewClubEntity>();


		PageUtils page = newClubService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlishetuan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, NewClubEntity jianlishetuan,
                  HttpServletRequest request){
        EntityWrapper<NewClubEntity> ew = new EntityWrapper<NewClubEntity>();

		PageUtils page = newClubService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlishetuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NewClubEntity jianlishetuan){
       	EntityWrapper<NewClubEntity> ew = new EntityWrapper<NewClubEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianlishetuan, "jianlishetuan")); 
        return R.ok().put("data", newClubService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NewClubEntity jianlishetuan){
        EntityWrapper<NewClubEntity> ew = new EntityWrapper<NewClubEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianlishetuan, "jianlishetuan")); 
		NewClubView jianlishetuanView =  newClubService.selectView(ew);
		return R.ok("查询建立社团成功").put("data", jianlishetuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NewClubEntity jianlishetuan = newClubService.selectById(id);
        return R.ok().put("data", jianlishetuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NewClubEntity jianlishetuan = newClubService.selectById(id);
        return R.ok().put("data", jianlishetuan);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NewClubEntity jianlishetuan, HttpServletRequest request){
    	jianlishetuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianlishetuan);

        newClubService.insert(jianlishetuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NewClubEntity jianlishetuan, HttpServletRequest request){
    	jianlishetuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianlishetuan);

        newClubService.insert(jianlishetuan);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NewClubEntity jianlishetuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianlishetuan);
        newClubService.updateById(jianlishetuan);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        newClubService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<NewClubEntity> wrapper = new EntityWrapper<NewClubEntity>();
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

		int count = newClubService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

}
