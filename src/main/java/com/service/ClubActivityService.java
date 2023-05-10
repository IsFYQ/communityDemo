package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ClubActivityEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ClubActivityVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ClubActivityView;


/**
 * 社团活动
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface ClubActivityService extends IService<ClubActivityEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ClubActivityVO> selectListVO(Wrapper<ClubActivityEntity> wrapper);
   	
   	ClubActivityVO selectVO(@Param("ew") Wrapper<ClubActivityEntity> wrapper);
   	
   	List<ClubActivityView> selectListView(Wrapper<ClubActivityEntity> wrapper);
   	
   	ClubActivityView selectView(@Param("ew") Wrapper<ClubActivityEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ClubActivityEntity> wrapper);
   	

}

