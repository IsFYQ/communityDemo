package com.entity.view;

import com.entity.ApplicationActivityEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 申请参加
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@TableName("shenqingcanjia")
public class ApplicationActivityView extends ApplicationActivityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ApplicationActivityView(){
	}
 
 	public ApplicationActivityView(ApplicationActivityEntity applicationActivityEntity){
 	try {
			BeanUtils.copyProperties(this, applicationActivityEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
