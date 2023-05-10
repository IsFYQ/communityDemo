package com.entity.view;

import com.entity.JoinClubEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 加入社团
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@TableName("jiarushetuan")
public class JoinClubView extends JoinClubEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JoinClubView(){
	}
 
 	public JoinClubView(JoinClubEntity joinClubEntity){
 	try {
			BeanUtils.copyProperties(this, joinClubEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
