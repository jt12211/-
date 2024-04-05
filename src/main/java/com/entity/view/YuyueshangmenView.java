package com.entity.view;

import com.entity.YuyueshangmenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 预约上门
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
@TableName("yuyueshangmen")
public class YuyueshangmenView  extends YuyueshangmenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuyueshangmenView(){
	}
 
 	public YuyueshangmenView(YuyueshangmenEntity yuyueshangmenEntity){
 	try {
			BeanUtils.copyProperties(this, yuyueshangmenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
