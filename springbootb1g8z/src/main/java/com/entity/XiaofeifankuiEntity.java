package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

@TableName("xiaofeifankui")
public class XiaofeifankuiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public XiaofeifankuiEntity() {}
    public XiaofeifankuiEntity(T t){
        try { BeanUtils.copyProperties(this, t); } catch (IllegalAccessException | InvocationTargetException e) { e.printStackTrace(); }
    }

    @TableId
    private Long id;
    private String yonghuming;
    private String neirong;
    private String jiudianmingcheng;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public void setYonghuming(String yonghuming){ this.yonghuming = yonghuming; }
    public String getYonghuming(){ return yonghuming; }
    public void setNeirong(String neirong){ this.neirong = neirong; }
    public String getNeirong(){ return neirong; }
    public void setJiudianmingcheng(String jiudianmingcheng){ this.jiudianmingcheng = jiudianmingcheng; }
    public String getJiudianmingcheng(){ return jiudianmingcheng; }
    public Date getAddtime(){ return addtime; }
    public void setAddtime(Date addtime){ this.addtime = addtime; }
}
