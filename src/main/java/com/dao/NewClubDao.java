package com.dao;

import com.entity.NewClubEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NewClubVO;
import com.entity.view.NewClubView;


/**
 * 建立社团
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface NewClubDao extends BaseMapper<NewClubEntity> {
	
	List<NewClubVO> selectListVO(@Param("ew") Wrapper<NewClubEntity> wrapper);
	
	NewClubVO selectVO(@Param("ew") Wrapper<NewClubEntity> wrapper);
	
	List<NewClubView> selectListView(@Param("ew") Wrapper<NewClubEntity> wrapper);

	List<NewClubView> selectListView(Pagination page, @Param("ew") Wrapper<NewClubEntity> wrapper);
	
	NewClubView selectView(@Param("ew") Wrapper<NewClubEntity> wrapper);
	

}
