package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ClubInformationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ClubInformationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ClubInformationView;


/**
 * 社团信息
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface ClubInformationService extends IService<ClubInformationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ClubInformationVO> selectListVO(Wrapper<ClubInformationEntity> wrapper);
   	
   	ClubInformationVO selectVO(@Param("ew") Wrapper<ClubInformationEntity> wrapper);
   	
   	List<ClubInformationView> selectListView(Wrapper<ClubInformationEntity> wrapper);
   	
   	ClubInformationView selectView(@Param("ew") Wrapper<ClubInformationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ClubInformationEntity> wrapper);
   	

}

