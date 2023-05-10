package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DissolveClubEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DissolveClubVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DissolveClubView;


/**
 * 解散社团
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface DissolveClubService extends IService<DissolveClubEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DissolveClubVO> selectListVO(Wrapper<DissolveClubEntity> wrapper);
   	
   	DissolveClubVO selectVO(@Param("ew") Wrapper<DissolveClubEntity> wrapper);
   	
   	List<DissolveClubView> selectListView(Wrapper<DissolveClubEntity> wrapper);
   	
   	DissolveClubView selectView(@Param("ew") Wrapper<DissolveClubEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DissolveClubEntity> wrapper);
   	

}

