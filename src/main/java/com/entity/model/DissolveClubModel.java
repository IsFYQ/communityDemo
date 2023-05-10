package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 解散社团
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-17 17:15:57
 */
public class DissolveClubModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 社团名称
	 */
	
	private String shetuanmingcheng;
		
	/**
	 * 解散原因
	 */
	
	private String jiesanyuanyin;
		
	/**
	 * 申请时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
	 * 设置：解散原因
	 */
	 
	public void setJiesanyuanyin(String jiesanyuanyin) {
		this.jiesanyuanyin = jiesanyuanyin;
	}
	
	/**
	 * 获取：解散原因
	 */
	public String getJiesanyuanyin() {
		return jiesanyuanyin;
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
