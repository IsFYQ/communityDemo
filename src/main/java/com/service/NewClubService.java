package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NewClubEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NewClubVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NewClubView;


/**
 * 建立社团
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface NewClubService extends IService<NewClubEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NewClubVO> selectListVO(Wrapper<NewClubEntity> wrapper);
   	
   	NewClubVO selectVO(@Param("ew") Wrapper<NewClubEntity> wrapper);
   	
   	List<NewClubView> selectListView(Wrapper<NewClubEntity> wrapper);
   	
   	NewClubView selectView(@Param("ew") Wrapper<NewClubEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NewClubEntity> wrapper);
   	

}

