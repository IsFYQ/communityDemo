package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ApplicationActivityDao;
import com.entity.ApplicationActivityEntity;
import com.service.ApplicationActivityService;
import com.entity.vo.ApplicationActivityVO;
import com.entity.view.ApplicationActivityView;

@Service("applicationActivityService")
public class ApplicationActivityServiceImpl extends ServiceImpl<ApplicationActivityDao, ApplicationActivityEntity> implements ApplicationActivityService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ApplicationActivityEntity> page = this.selectPage(
                new Query<ApplicationActivityEntity>(params).getPage(),
                new EntityWrapper<ApplicationActivityEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ApplicationActivityEntity> wrapper) {
		  Page<ApplicationActivityView> page =new Query<ApplicationActivityView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ApplicationActivityVO> selectListVO(Wrapper<ApplicationActivityEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ApplicationActivityVO selectVO(Wrapper<ApplicationActivityEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ApplicationActivityView> selectListView(Wrapper<ApplicationActivityEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ApplicationActivityView selectView(Wrapper<ApplicationActivityEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
