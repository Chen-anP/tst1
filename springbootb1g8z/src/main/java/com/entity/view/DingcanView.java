package com.entity.view;

import com.entity.DingcanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 点餐
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-04 00:20:04
 */
@TableName("dingcan")
public class DingcanView  extends DingcanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DingcanView(){
	}
 
 	public DingcanView(DingcanEntity dingcanEntity){
 	try {
			BeanUtils.copyProperties(this, dingcanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
