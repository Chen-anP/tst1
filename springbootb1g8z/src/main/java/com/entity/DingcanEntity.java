package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

@TableName("dingcan")
public class DingcanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public DingcanEntity() {}
    public DingcanEntity(T t){
        try { BeanUtils.copyProperties(this, t); } catch (IllegalAccessException | InvocationTargetException e) { e.printStackTrace(); }
    }

    @TableId
    private Long id;
    private String dingdanbianhao;
    private String caidanmingcheng;
    private Float jiage;
    private Integer shuliang;
    private Float zongjine;
    private String yonghuming;
    private String xingming;
    private String shoujihao;
    private String jiudianmingcheng;
    private String ispay;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Date getAddtime(){ return addtime; }
    public void setAddtime(Date addtime){ this.addtime = addtime; }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public void setDingdanbianhao(String dingdanbianhao){ this.dingdanbianhao = dingdanbianhao; }
    public String getDingdanbianhao(){ return dingdanbianhao; }
    public void setCaidanmingcheng(String caidanmingcheng){ this.caidanmingcheng = caidanmingcheng; }
    public String getCaidanmingcheng(){ return caidanmingcheng; }
    public void setJiage(Float jiage){ this.jiage = jiage; }
    public Float getJiage(){ return jiage; }
    public void setShuliang(Integer shuliang){ this.shuliang = shuliang; }
    public Integer getShuliang(){ return shuliang; }
    public void setZongjine(Float zongjine){ this.zongjine = zongjine; }
    public Float getZongjine(){ return zongjine; }
    public void setYonghuming(String yonghuming){ this.yonghuming = yonghuming; }
    public String getYonghuming(){ return yonghuming; }
    public void setXingming(String xingming){ this.xingming = xingming; }
    public String getXingming(){ return xingming; }
    public void setShoujihao(String shoujihao){ this.shoujihao = shoujihao; }
    public String getShoujihao(){ return shoujihao; }
    public void setJiudianmingcheng(String jiudianmingcheng){ this.jiudianmingcheng = jiudianmingcheng; }
    public String getJiudianmingcheng(){ return jiudianmingcheng; }
    public void setIspay(String ispay){ this.ispay = ispay; }
    public String getIspay(){ return ispay; }
}
