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
 * 健康记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
@TableName("jiankangjilu")
public class JiankangjiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangjiluEntity() {
		
	}
	
	public JiankangjiluEntity(T t) {
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
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 体重
	 */
					
	private String tizhong;
	
	/**
	 * 体温
	 */
					
	private Double tiwen;
	
	/**
	 * 血氧饱和度
	 */
					
	private String xueyangbaohedu;
	
	/**
	 * 心率
	 */
					
	private Double xinlv;
	
	/**
	 * 血压
	 */
					
	private Double xueya;
	
	/**
	 * 血糖
	 */
					
	private Double xuetang;
	
	/**
	 * 血脂
	 */
					
	private Double xuezhi;
	
	/**
	 * 视力
	 */
					
	private String shili;
	
	/**
	 * 睡眠质量
	 */
					
	private String shuimianzhiliang;
	
	/**
	 * 测量日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date celiangriqi;
	
	
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
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：体重
	 */
	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}
	/**
	 * 获取：体重
	 */
	public String getTizhong() {
		return tizhong;
	}
	/**
	 * 设置：体温
	 */
	public void setTiwen(Double tiwen) {
		this.tiwen = tiwen;
	}
	/**
	 * 获取：体温
	 */
	public Double getTiwen() {
		return tiwen;
	}
	/**
	 * 设置：血氧饱和度
	 */
	public void setXueyangbaohedu(String xueyangbaohedu) {
		this.xueyangbaohedu = xueyangbaohedu;
	}
	/**
	 * 获取：血氧饱和度
	 */
	public String getXueyangbaohedu() {
		return xueyangbaohedu;
	}
	/**
	 * 设置：心率
	 */
	public void setXinlv(Double xinlv) {
		this.xinlv = xinlv;
	}
	/**
	 * 获取：心率
	 */
	public Double getXinlv() {
		return xinlv;
	}
	/**
	 * 设置：血压
	 */
	public void setXueya(Double xueya) {
		this.xueya = xueya;
	}
	/**
	 * 获取：血压
	 */
	public Double getXueya() {
		return xueya;
	}
	/**
	 * 设置：血糖
	 */
	public void setXuetang(Double xuetang) {
		this.xuetang = xuetang;
	}
	/**
	 * 获取：血糖
	 */
	public Double getXuetang() {
		return xuetang;
	}
	/**
	 * 设置：血脂
	 */
	public void setXuezhi(Double xuezhi) {
		this.xuezhi = xuezhi;
	}
	/**
	 * 获取：血脂
	 */
	public Double getXuezhi() {
		return xuezhi;
	}
	/**
	 * 设置：视力
	 */
	public void setShili(String shili) {
		this.shili = shili;
	}
	/**
	 * 获取：视力
	 */
	public String getShili() {
		return shili;
	}
	/**
	 * 设置：睡眠质量
	 */
	public void setShuimianzhiliang(String shuimianzhiliang) {
		this.shuimianzhiliang = shuimianzhiliang;
	}
	/**
	 * 获取：睡眠质量
	 */
	public String getShuimianzhiliang() {
		return shuimianzhiliang;
	}
	/**
	 * 设置：测量日期
	 */
	public void setCeliangriqi(Date celiangriqi) {
		this.celiangriqi = celiangriqi;
	}
	/**
	 * 获取：测量日期
	 */
	public Date getCeliangriqi() {
		return celiangriqi;
	}

}
