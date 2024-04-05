package com.entity.vo;

import com.entity.DingdanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 订单信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
public class DingdanxinxiVO  implements Serializable {
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
	 * 菜品规格
	 */
	
	private String caipinguige;
		
	/**
	 * 菜品价格
	 */
	
	private Double caipinjiage;
		
	/**
	 * 购买数量
	 */
	
	private Integer caipinshuliang;
		
	/**
	 * 总费用
	 */
	
	private Double zongfeiyong;
		
	/**
	 * 购买时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date goumaishijian;
		
	/**
	 * 购买备注
	 */
	
	private String goumaibeizhu;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 手机号
	 */
	
	private String shoujihao;
		
	/**
	 * 送餐地址
	 */
	
	private String songcandizhi;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
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
	 * 设置：购买数量
	 */
	 
	public void setCaipinshuliang(Integer caipinshuliang) {
		this.caipinshuliang = caipinshuliang;
	}
	
	/**
	 * 获取：购买数量
	 */
	public Integer getCaipinshuliang() {
		return caipinshuliang;
	}
				
	
	/**
	 * 设置：总费用
	 */
	 
	public void setZongfeiyong(Double zongfeiyong) {
		this.zongfeiyong = zongfeiyong;
	}
	
	/**
	 * 获取：总费用
	 */
	public Double getZongfeiyong() {
		return zongfeiyong;
	}
				
	
	/**
	 * 设置：购买时间
	 */
	 
	public void setGoumaishijian(Date goumaishijian) {
		this.goumaishijian = goumaishijian;
	}
	
	/**
	 * 获取：购买时间
	 */
	public Date getGoumaishijian() {
		return goumaishijian;
	}
				
	
	/**
	 * 设置：购买备注
	 */
	 
	public void setGoumaibeizhu(String goumaibeizhu) {
		this.goumaibeizhu = goumaibeizhu;
	}
	
	/**
	 * 获取：购买备注
	 */
	public String getGoumaibeizhu() {
		return goumaibeizhu;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：手机号
	 */
	 
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	
	/**
	 * 获取：手机号
	 */
	public String getShoujihao() {
		return shoujihao;
	}
				
	
	/**
	 * 设置：送餐地址
	 */
	 
	public void setSongcandizhi(String songcandizhi) {
		this.songcandizhi = songcandizhi;
	}
	
	/**
	 * 获取：送餐地址
	 */
	public String getSongcandizhi() {
		return songcandizhi;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
