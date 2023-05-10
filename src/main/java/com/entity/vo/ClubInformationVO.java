package com.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 社团信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public class ClubInformationVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 社团标签
	 */
	
	private String shetuanbiaoqian;
		
	/**
	 * 社团类型
	 */
	
	private String shetuanleixing;
		
	/**
	 * 社团目标
	 */
	
	private String shetuanmubiao;
		
	/**
	 * 人数
	 */
	
	private Integer renshu;
		
	/**
	 * 社团简介
	 */
	
	private String shetuanjianjie;
		
	/**
	 * 社团详情
	 */
	
	private String shetuanxiangqing;
		
	/**
	 * 学生账号
	 */
	
	private String xueshengzhanghao;
		
	/**
	 * 学生姓名
	 */
	
	private String xueshengxingming;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
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
	 * 设置：社团目标
	 */
	 
	public void setShetuanmubiao(String shetuanmubiao) {
		this.shetuanmubiao = shetuanmubiao;
	}
	
	/**
	 * 获取：社团目标
	 */
	public String getShetuanmubiao() {
		return shetuanmubiao;
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
	 * 设置：社团简介
	 */
	 
	public void setShetuanjianjie(String shetuanjianjie) {
		this.shetuanjianjie = shetuanjianjie;
	}
	
	/**
	 * 获取：社团简介
	 */
	public String getShetuanjianjie() {
		return shetuanjianjie;
	}
				
	
	/**
	 * 设置：社团详情
	 */
	 
	public void setShetuanxiangqing(String shetuanxiangqing) {
		this.shetuanxiangqing = shetuanxiangqing;
	}
	
	/**
	 * 获取：社团详情
	 */
	public String getShetuanxiangqing() {
		return shetuanxiangqing;
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
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
