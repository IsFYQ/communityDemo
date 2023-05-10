package com.dao;

import com.entity.StudentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.StudentVO;
import com.entity.view.StudentView;


/**
 * 学生
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface StudentDao extends BaseMapper<StudentEntity> {
	
	List<StudentVO> selectListVO(@Param("ew") Wrapper<StudentEntity> wrapper);
	
	StudentVO selectVO(@Param("ew") Wrapper<StudentEntity> wrapper);
	
	List<StudentView> selectListView(@Param("ew") Wrapper<StudentEntity> wrapper);

	List<StudentView> selectListView(Pagination page, @Param("ew") Wrapper<StudentEntity> wrapper);
	
	StudentView selectView(@Param("ew") Wrapper<StudentEntity> wrapper);
	

}
