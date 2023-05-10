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


import com.dao.JoinClubDao;
import com.entity.JoinClubEntity;
import com.service.JoinClubService;
import com.entity.vo.JoinClubVO;
import com.entity.view.JoinClubView;

@Service("joinClubService")
public class JoinClubServiceImpl extends ServiceImpl<JoinClubDao, JoinClubEntity> implements JoinClubService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JoinClubEntity> page = this.selectPage(
                new Query<JoinClubEntity>(params).getPage(),
                new EntityWrapper<JoinClubEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JoinClubEntity> wrapper) {
		  Page<JoinClubView> page =new Query<JoinClubView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JoinClubVO> selectListVO(Wrapper<JoinClubEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JoinClubVO selectVO(Wrapper<JoinClubEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JoinClubView> selectListView(Wrapper<JoinClubEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JoinClubView selectView(Wrapper<JoinClubEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
