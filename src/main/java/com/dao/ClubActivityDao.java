package com.dao;

import com.entity.ClubActivityEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ClubActivityVO;
import com.entity.view.ClubActivityView;


/**
 * 社团活动
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface ClubActivityDao extends BaseMapper<ClubActivityEntity> {
	
	List<ClubActivityVO> selectListVO(@Param("ew") Wrapper<ClubActivityEntity> wrapper);
	
	ClubActivityVO selectVO(@Param("ew") Wrapper<ClubActivityEntity> wrapper);
	
	List<ClubActivityView> selectListView(@Param("ew") Wrapper<ClubActivityEntity> wrapper);

	List<ClubActivityView> selectListView(Pagination page, @Param("ew") Wrapper<ClubActivityEntity> wrapper);
	
	ClubActivityView selectView(@Param("ew") Wrapper<ClubActivityEntity> wrapper);
	

}
