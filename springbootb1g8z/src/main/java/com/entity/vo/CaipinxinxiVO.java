package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * 菜品信息 - 手机端返回实体
 */
public class CaipinxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String caipinmingcheng;
    private String caipintupian;
    private String canleixing;
    private Float jiage;
    private String fene;
    private String caipinjieshao;
    private Long clicknum;

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
