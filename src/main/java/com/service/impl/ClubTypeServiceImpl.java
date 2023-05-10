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


import com.dao.ClubTypeDao;
import com.entity.ClubTypeEntity;
import com.service.ClubTypeService;
import com.entity.vo.ClubTypeVO;
import com.entity.view.ClubTypeView;

@Service("clubTypeService")
public class ClubTypeServiceImpl extends ServiceImpl<ClubTypeDao, ClubTypeEntity> implements ClubTypeService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ClubTypeEntity> page = this.selectPage(
                new Query<ClubTypeEntity>(params).getPage(),
                new EntityWrapper<ClubTypeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ClubTypeEntity> wrapper) {
		  Page<ClubTypeView> page =new Query<ClubTypeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ClubTypeVO> selectListVO(Wrapper<ClubTypeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ClubTypeVO selectVO(Wrapper<ClubTypeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ClubTypeView> selectListView(Wrapper<ClubTypeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ClubTypeView selectView(Wrapper<ClubTypeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
