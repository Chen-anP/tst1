package com.entity.view;

import com.entity.XiaofeifankuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 消费反馈
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-04 00:20:04
 */
@TableName("xiaofeifankui")
public class XiaofeifankuiView  extends XiaofeifankuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaofeifankuiView(){
	}
 
 	public XiaofeifankuiView(XiaofeifankuiEntity xiaofeifankuiEntity){
 	try {
			BeanUtils.copyProperties(this, xiaofeifankuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
