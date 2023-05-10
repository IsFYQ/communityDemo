package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ApplicationActivityEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ApplicationActivityVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ApplicationActivityView;


/**
 * 申请参加
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface ApplicationActivityService extends IService<ApplicationActivityEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ApplicationActivityVO> selectListVO(Wrapper<ApplicationActivityEntity> wrapper);
   	
   	ApplicationActivityVO selectVO(@Param("ew") Wrapper<ApplicationActivityEntity> wrapper);
   	
   	List<ApplicationActivityView> selectListView(Wrapper<ApplicationActivityEntity> wrapper);
   	
   	ApplicationActivityView selectView(@Param("ew") Wrapper<ApplicationActivityEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ApplicationActivityEntity> wrapper);
   	

}

