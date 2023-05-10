package com.entity.view;

import com.entity.DissolveClubEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 解散社团
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@TableName("jiesanshetuan")
public class DissolveClubView extends DissolveClubEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DissolveClubView(){
	}
 
 	public DissolveClubView(DissolveClubEntity dissolveClubEntity){
 	try {
			BeanUtils.copyProperties(this, dissolveClubEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
