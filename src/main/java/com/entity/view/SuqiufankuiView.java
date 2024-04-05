package com.entity.view;

import com.entity.SuqiufankuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 诉求反馈
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
@TableName("suqiufankui")
public class SuqiufankuiView  extends SuqiufankuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SuqiufankuiView(){
	}
 
 	public SuqiufankuiView(SuqiufankuiEntity suqiufankuiEntity){
 	try {
			BeanUtils.copyProperties(this, suqiufankuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
