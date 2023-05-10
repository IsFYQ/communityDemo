package com.dao;

import com.entity.DissolveClubEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DissolveClubVO;
import com.entity.view.DissolveClubView;


/**
 * 解散社团
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface DissolveClubDao extends BaseMapper<DissolveClubEntity> {
	
	List<DissolveClubVO> selectListVO(@Param("ew") Wrapper<DissolveClubEntity> wrapper);
	
	DissolveClubVO selectVO(@Param("ew") Wrapper<DissolveClubEntity> wrapper);
	
	List<DissolveClubView> selectListView(@Param("ew") Wrapper<DissolveClubEntity> wrapper);

	List<DissolveClubView> selectListView(Pagination page, @Param("ew") Wrapper<DissolveClubEntity> wrapper);
	
	DissolveClubView selectView(@Param("ew") Wrapper<DissolveClubEntity> wrapper);
	

}
