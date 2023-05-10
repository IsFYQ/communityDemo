package com.dao;

import com.entity.ClubInformationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ClubInformationVO;
import com.entity.view.ClubInformationView;


/**
 * 社团信息
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface ClubInformationDao extends BaseMapper<ClubInformationEntity> {
	
	List<ClubInformationVO> selectListVO(@Param("ew") Wrapper<ClubInformationEntity> wrapper);
	
	ClubInformationVO selectVO(@Param("ew") Wrapper<ClubInformationEntity> wrapper);
	
	List<ClubInformationView> selectListView(@Param("ew") Wrapper<ClubInformationEntity> wrapper);

	List<ClubInformationView> selectListView(Pagination page, @Param("ew") Wrapper<ClubInformationEntity> wrapper);
	
	ClubInformationView selectView(@Param("ew") Wrapper<ClubInformationEntity> wrapper);
	

}
