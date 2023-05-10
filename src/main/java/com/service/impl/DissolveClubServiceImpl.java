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


import com.dao.DissolveClubDao;
import com.entity.DissolveClubEntity;
import com.service.DissolveClubService;
import com.entity.vo.DissolveClubVO;
import com.entity.view.DissolveClubView;

@Service("jiesanshetuanService")
public class DissolveClubServiceImpl extends ServiceImpl<DissolveClubDao, DissolveClubEntity> implements DissolveClubService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DissolveClubEntity> page = this.selectPage(
                new Query<DissolveClubEntity>(params).getPage(),
                new EntityWrapper<DissolveClubEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DissolveClubEntity> wrapper) {
		  Page<DissolveClubView> page =new Query<DissolveClubView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DissolveClubVO> selectListVO(Wrapper<DissolveClubEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DissolveClubVO selectVO(Wrapper<DissolveClubEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DissolveClubView> selectListView(Wrapper<DissolveClubEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DissolveClubView selectView(Wrapper<DissolveClubEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
