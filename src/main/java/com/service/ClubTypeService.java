package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ClubTypeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ClubTypeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ClubTypeView;


/**
 * 社团类型
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface ClubTypeService extends IService<ClubTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ClubTypeVO> selectListVO(Wrapper<ClubTypeEntity> wrapper);
   	
   	ClubTypeVO selectVO(@Param("ew") Wrapper<ClubTypeEntity> wrapper);
   	
   	List<ClubTypeView> selectListView(Wrapper<ClubTypeEntity> wrapper);
   	
   	ClubTypeView selectView(@Param("ew") Wrapper<ClubTypeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ClubTypeEntity> wrapper);
   	

}

