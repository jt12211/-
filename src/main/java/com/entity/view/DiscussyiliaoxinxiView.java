package com.entity.view;

import com.entity.DiscussyiliaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 医疗信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-01-16 20:16:37
 */
@TableName("discussyiliaoxinxi")
public class DiscussyiliaoxinxiView  extends DiscussyiliaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussyiliaoxinxiView(){
	}
 
 	public DiscussyiliaoxinxiView(DiscussyiliaoxinxiEntity discussyiliaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussyiliaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
