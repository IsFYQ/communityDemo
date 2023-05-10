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


import com.dao.ClubInformationDao;
import com.entity.ClubInformationEntity;
import com.service.ClubInformationService;
import com.entity.vo.ClubInformationVO;
import com.entity.view.ClubInformationView;

@Service("clubInformationService")
public class ClubInformationServiceImpl extends ServiceImpl<ClubInformationDao, ClubInformationEntity> implements ClubInformationService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ClubInformationEntity> page = this.selectPage(
                new Query<ClubInformationEntity>(params).getPage(),
                new EntityWrapper<ClubInformationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ClubInformationEntity> wrapper) {
		  Page<ClubInformationView> page =new Query<ClubInformationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ClubInformationVO> selectListVO(Wrapper<ClubInformationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ClubInformationVO selectVO(Wrapper<ClubInformationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ClubInformationView> selectListView(Wrapper<ClubInformationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ClubInformationView selectView(Wrapper<ClubInformationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
