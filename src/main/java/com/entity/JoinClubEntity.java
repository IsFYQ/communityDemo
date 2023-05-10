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
 * 加入社团
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
@TableName("join_club")
public class JoinClubEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JoinClubEntity() {
		
	}
	
	public JoinClubEntity(T t) {
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
	 * 加入编号
	 */
					
	private String jiarubianhao;
	
	/**
	 * 社团名称
	 */
					
	private String shetuanmingcheng;
	
	/**
	 * 社团标签
	 */
					
	private String shetuanbiaoqian;
	
	/**
	 * 人数
	 */
					
	private Integer renshu;
	
	/**
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shenqingshijian;
	
	/**
	 * 加入学生账号
	 */
					
	private String jiaruxueshengzhanghao;
	
	/**
	 * 加入学生姓名
	 */
					
	private String jiaruxueshengxingming;
	
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
	 * 设置：加入编号
	 */
	public void setJiarubianhao(String jiarubianhao) {
		this.jiarubianhao = jiarubianhao;
	}
	/**
	 * 获取：加入编号
	 */
	public String getJiarubianhao() {
		return jiarubianhao;
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
	 * 设置：社团标签
	 */
	public void setShetuanbiaoqian(String shetuanbiaoqian) {
		this.shetuanbiaoqian = shetuanbiaoqian;
	}
	/**
	 * 获取：社团标签
	 */
	public String getShetuanbiaoqian() {
		return shetuanbiaoqian;
	}
	/**
	 * 设置：人数
	 */
	public void setRenshu(Integer renshu) {
		this.renshu = renshu;
	}
	/**
	 * 获取：人数
	 */
	public Integer getRenshu() {
		return renshu;
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
	 * 设置：加入学生账号
	 */
	public void setJiaruxueshengzhanghao(String jiaruxueshengzhanghao) {
		this.jiaruxueshengzhanghao = jiaruxueshengzhanghao;
	}
	/**
	 * 获取：加入学生账号
	 */
	public String getJiaruxueshengzhanghao() {
		return jiaruxueshengzhanghao;
	}
	/**
	 * 设置：加入学生姓名
	 */
	public void setJiaruxueshengxingming(String jiaruxueshengxingming) {
		this.jiaruxueshengxingming = jiaruxueshengxingming;
	}
	/**
	 * 获取：加入学生姓名
	 */
	public String getJiaruxueshengxingming() {
		return jiaruxueshengxingming;
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
