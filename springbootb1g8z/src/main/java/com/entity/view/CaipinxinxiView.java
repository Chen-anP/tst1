package com.entity.view;

import com.entity.CaipinxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;

/**
 * 菜品信息 - 后端返回视图
 */
@TableName("caipinxinxi")
public class CaipinxinxiView extends CaipinxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public CaipinxinxiView(){}
    public CaipinxinxiView(CaipinxinxiEntity entity){
        try {
            BeanUtils.copyProperties(this, entity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
