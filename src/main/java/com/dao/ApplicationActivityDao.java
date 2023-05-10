package com.dao;

import com.entity.ApplicationActivityEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ApplicationActivityVO;
import com.entity.view.ApplicationActivityView;


/**
 * 申请参加
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface ApplicationActivityDao extends BaseMapper<ApplicationActivityEntity> {
	
	List<ApplicationActivityVO> selectListVO(@Param("ew") Wrapper<ApplicationActivityEntity> wrapper);
	
	ApplicationActivityVO selectVO(@Param("ew") Wrapper<ApplicationActivityEntity> wrapper);
	
	List<ApplicationActivityView> selectListView(@Param("ew") Wrapper<ApplicationActivityEntity> wrapper);

	List<ApplicationActivityView> selectListView(Pagination page, @Param("ew") Wrapper<ApplicationActivityEntity> wrapper);
	
	ApplicationActivityView selectView(@Param("ew") Wrapper<ApplicationActivityEntity> wrapper);
	

}
