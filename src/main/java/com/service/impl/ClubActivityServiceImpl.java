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


import com.dao.ClubActivityDao;
import com.entity.ClubActivityEntity;
import com.service.ClubActivityService;
import com.entity.vo.ClubActivityVO;
import com.entity.view.ClubActivityView;

@Service("clubActivityService")
public class ClubActivityServiceImpl extends ServiceImpl<ClubActivityDao, ClubActivityEntity> implements ClubActivityService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ClubActivityEntity> page = this.selectPage(
                new Query<ClubActivityEntity>(params).getPage(),
                new EntityWrapper<ClubActivityEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ClubActivityEntity> wrapper) {
		  Page<ClubActivityView> page =new Query<ClubActivityView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ClubActivityVO> selectListVO(Wrapper<ClubActivityEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ClubActivityVO selectVO(Wrapper<ClubActivityEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ClubActivityView> selectListView(Wrapper<ClubActivityEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ClubActivityView selectView(Wrapper<ClubActivityEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
