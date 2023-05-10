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


import com.dao.NewClubDao;
import com.entity.NewClubEntity;
import com.service.NewClubService;
import com.entity.vo.NewClubVO;
import com.entity.view.NewClubView;

@Service("newClubService")
public class NewClubServiceImpl extends ServiceImpl<NewClubDao, NewClubEntity> implements NewClubService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NewClubEntity> page = this.selectPage(
                new Query<NewClubEntity>(params).getPage(),
                new EntityWrapper<NewClubEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NewClubEntity> wrapper) {
		  Page<NewClubView> page =new Query<NewClubView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NewClubVO> selectListVO(Wrapper<NewClubEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NewClubVO selectVO(Wrapper<NewClubEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NewClubView> selectListView(Wrapper<NewClubEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NewClubView selectView(Wrapper<NewClubEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
