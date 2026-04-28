package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

@TableName("caipinxinxi")
public class CaipinxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public CaipinxinxiEntity() {}
    public CaipinxinxiEntity(T t){
        try { BeanUtils.copyProperties(this, t); } catch (IllegalAccessException | InvocationTargetException e) { e.printStackTrace(); }
    }

    @TableId
    private Long id;
    private String caipinmingcheng;
    private String caipintupian;
    private String canleixing;
    private Float jiage;
    private String fene;
    private String caipinjieshao;
    private Long clicknum;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Date getAddtime(){ return addtime; }
    public void setAddtime(Date addtime){ this.addtime = addtime; }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getCaipinmingcheng(){ return caipinmingcheng; }
    public void setCaipinmingcheng(String caipinmingcheng){ this.caipinmingcheng = caipinmingcheng; }

    public String getCaipintupian(){ return caipintupian; }
    public void setCaipintupian(String caipintupian){ this.caipintupian = caipintupian; }

    public String getCanleixing(){ return canleixing; }
    public void setCanleixing(String canleixing){ this.canleixing = canleixing; }

    public Float getJiage(){ return jiage; }
    public void setJiage(Float jiage){ this.jiage = jiage; }

    public String getFene(){ return fene; }
    public void setFene(String fene){ this.fene = fene; }

    public String getCaipinjieshao(){ return caipinjieshao; }
    public void setCaipinjieshao(String caipinjieshao){ this.caipinjieshao = caipinjieshao; }

    public Long getClicknum(){ return clicknum; }
    public void setClicknum(Long clicknum){ this.clicknum = clicknum; }
}
