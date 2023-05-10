package com.dao;

import com.entity.ClubTypeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ClubTypeVO;
import com.entity.view.ClubTypeView;


/**
 * 社团类型
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface ClubTypeDao extends BaseMapper<ClubTypeEntity> {
	
	List<ClubTypeVO> selectListVO(@Param("ew") Wrapper<ClubTypeEntity> wrapper);
	
	ClubTypeVO selectVO(@Param("ew") Wrapper<ClubTypeEntity> wrapper);
	
	List<ClubTypeView> selectListView(@Param("ew") Wrapper<ClubTypeEntity> wrapper);

	List<ClubTypeView> selectListView(Pagination page, @Param("ew") Wrapper<ClubTypeEntity> wrapper);
	
	ClubTypeView selectView(@Param("ew") Wrapper<ClubTypeEntity> wrapper);
	

}
