package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JoinClubEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JoinClubVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JoinClubView;


/**
 * 加入社团
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public interface JoinClubService extends IService<JoinClubEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JoinClubVO> selectListVO(Wrapper<JoinClubEntity> wrapper);
   	
   	JoinClubVO selectVO(@Param("ew") Wrapper<JoinClubEntity> wrapper);
   	
   	List<JoinClubView> selectListView(Wrapper<JoinClubEntity> wrapper);
   	
   	JoinClubView selectView(@Param("ew") Wrapper<JoinClubEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JoinClubEntity> wrapper);
   	

}

