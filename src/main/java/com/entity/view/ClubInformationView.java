package com.entity.view;

import com.entity.ClubInformationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 社团信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@TableName("shetuanxinxi")
public class ClubInformationView extends ClubInformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ClubInformationView(){
	}
 
 	public ClubInformationView(ClubInformationEntity clubInformationEntity){
 	try {
			BeanUtils.copyProperties(this, clubInformationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
