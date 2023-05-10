package com.dao;

import com.entity.JoinClubEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JoinClubVO;
import com.entity.view.JoinClubView;


/**
 * 加入社团
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface JoinClubDao extends BaseMapper<JoinClubEntity> {
	
	List<JoinClubVO> selectListVO(@Param("ew") Wrapper<JoinClubEntity> wrapper);
	
	JoinClubVO selectVO(@Param("ew") Wrapper<JoinClubEntity> wrapper);
	
	List<JoinClubView> selectListView(@Param("ew") Wrapper<JoinClubEntity> wrapper);

	List<JoinClubView> selectListView(Pagination page, @Param("ew") Wrapper<JoinClubEntity> wrapper);
	
	JoinClubView selectView(@Param("ew") Wrapper<JoinClubEntity> wrapper);
	

}
