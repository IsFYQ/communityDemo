package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 建立社团
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@TableName("new_club")
public class NewClubEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public NewClubEntity() {
		
	}
	
	public NewClubEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 社团名称
	 */
					
	private String shetuanmingcheng;
	
	/**
	 * 社团人数
	 */
					
	private String shetuanrenshu;
	
	/**
	 * 社团类型
	 */
					
	private String shetuanleixing;
	
	/**
	 * 负责内容
	 */
					
	private String fuzeneirong;
	
	/**
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shenqingshijian;
	
	/**
	 * 学生账号
	 */
					
	private String xueshengzhanghao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：社团名称
	 */
	public void setShetuanmingcheng(String shetuanmingcheng) {
		this.shetuanmingcheng = shetuanmingcheng;
	}
	/**
	 * 获取：社团名称
	 */
	public String getShetuanmingcheng() {
		return shetuanmingcheng;
	}
	/**
	 * 设置：社团人数
	 */
	public void setShetuanrenshu(String shetuanrenshu) {
		this.shetuanrenshu = shetuanrenshu;
	}
	/**
	 * 获取：社团人数
	 */
	public String getShetuanrenshu() {
		return shetuanrenshu;
	}
	/**
	 * 设置：社团类型
	 */
	public void setShetuanleixing(String shetuanleixing) {
		this.shetuanleixing = shetuanleixing;
	}
	/**
	 * 获取：社团类型
	 */
	public String getShetuanleixing() {
		return shetuanleixing;
	}
	/**
	 * 设置：负责内容
	 */
	public void setFuzeneirong(String fuzeneirong) {
		this.fuzeneirong = fuzeneirong;
	}
	/**
	 * 获取：负责内容
	 */
	public String getFuzeneirong() {
		return fuzeneirong;
	}
	/**
	 * 设置：申请时间
	 */
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
	}
	/**
	 * 设置：学生账号
	 */
	public void setXueshengzhanghao(String xueshengzhanghao) {
		this.xueshengzhanghao = xueshengzhanghao;
	}
	/**
	 * 获取：学生账号
	 */
	public String getXueshengzhanghao() {
		return xueshengzhanghao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
