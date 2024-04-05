package com.entity.vo;

import com.entity.ZizhuxuancanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 自助选餐
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
public class ZizhuxuancanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 菜品分类
	 */
	
	private String caipinfenlei;
		
	/**
	 * 菜品图片
	 */
	
	private String caipintupian;
		
	/**
	 * 菜品数量
	 */
	
	private Integer caipinshuliang;
		
	/**
	 * 菜品规格
	 */
	
	private String caipinguige;
		
	/**
	 * 菜品价格
	 */
	
	private Double caipinjiage;
		
	/**
	 * 菜品材料
	 */
	
	private String caipincailiao;
		
	/**
	 * 菜品详情
	 */
	
	private String caipinxiangqing;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：菜品分类
	 */
	 
	public void setCaipinfenlei(String caipinfenlei) {
		this.caipinfenlei = caipinfenlei;
	}
	
	/**
	 * 获取：菜品分类
	 */
	public String getCaipinfenlei() {
		return caipinfenlei;
	}
				
	
	/**
	 * 设置：菜品图片
	 */
	 
	public void setCaipintupian(String caipintupian) {
		this.caipintupian = caipintupian;
	}
	
	/**
	 * 获取：菜品图片
	 */
	public String getCaipintupian() {
		return caipintupian;
	}
				
	
	/**
	 * 设置：菜品数量
	 */
	 
	public void setCaipinshuliang(Integer caipinshuliang) {
		this.caipinshuliang = caipinshuliang;
	}
	
	/**
	 * 获取：菜品数量
	 */
	public Integer getCaipinshuliang() {
		return caipinshuliang;
	}
				
	
	/**
	 * 设置：菜品规格
	 */
	 
	public void setCaipinguige(String caipinguige) {
		this.caipinguige = caipinguige;
	}
	
	/**
	 * 获取：菜品规格
	 */
	public String getCaipinguige() {
		return caipinguige;
	}
				
	
	/**
	 * 设置：菜品价格
	 */
	 
	public void setCaipinjiage(Double caipinjiage) {
		this.caipinjiage = caipinjiage;
	}
	
	/**
	 * 获取：菜品价格
	 */
	public Double getCaipinjiage() {
		return caipinjiage;
	}
				
	
	/**
	 * 设置：菜品材料
	 */
	 
	public void setCaipincailiao(String caipincailiao) {
		this.caipincailiao = caipincailiao;
	}
	
	/**
	 * 获取：菜品材料
	 */
	public String getCaipincailiao() {
		return caipincailiao;
	}
				
	
	/**
	 * 设置：菜品详情
	 */
	 
	public void setCaipinxiangqing(String caipinxiangqing) {
		this.caipinxiangqing = caipinxiangqing;
	}
	
	/**
	 * 获取：菜品详情
	 */
	public String getCaipinxiangqing() {
		return caipinxiangqing;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
