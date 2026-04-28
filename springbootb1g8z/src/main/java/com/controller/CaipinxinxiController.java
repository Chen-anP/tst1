package com.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.annotation.IgnoreAuth;

import com.entity.CaipinxinxiEntity;
import com.service.CaipinxinxiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 菜品信息
 */
@RestController
@RequestMapping("/caipinxinxi")
public class CaipinxinxiController {
    @Autowired
    private CaipinxinxiService caipinxinxiService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String,Object> params, CaipinxinxiEntity caipinxinxi, HttpServletRequest request){
        EntityWrapper<CaipinxinxiEntity> ew = new EntityWrapper<CaipinxinxiEntity>();
        PageUtils page = caipinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinxinxi), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String,Object> params, CaipinxinxiEntity caipinxinxi, HttpServletRequest request){
        EntityWrapper<CaipinxinxiEntity> ew = new EntityWrapper<CaipinxinxiEntity>();
        PageUtils page = caipinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinxinxi), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/lists")
    public R lists(CaipinxinxiEntity caipinxinxi){
        EntityWrapper<CaipinxinxiEntity> ew = new EntityWrapper<CaipinxinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre(caipinxinxi, "caipinxinxi"));
        return R.ok().put("data", caipinxinxiService.selectListView(ew));
    }

    @RequestMapping("/query")
    public R query(CaipinxinxiEntity caipinxinxi){
        EntityWrapper<CaipinxinxiEntity> ew = new EntityWrapper<CaipinxinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre(caipinxinxi, "caipinxinxi"));
        return R.ok().put("data", caipinxinxiService.selectView(ew));
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaipinxinxiEntity caipinxinxi = caipinxinxiService.selectById(id);
        return R.ok().put("data", caipinxinxi);
    }

    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaipinxinxiEntity caipinxinxi = caipinxinxiService.selectById(id);
        // 更新点击次数
        caipinxinxi.setClicknum(caipinxinxi.getClicknum() == null ? 1 : caipinxinxi.getClicknum() + 1);
        caipinxinxiService.updateById(caipinxinxi);
        return R.ok().put("data", caipinxinxi);
    }

    @RequestMapping("/save")
    public R save(@RequestBody CaipinxinxiEntity caipinxinxi, HttpServletRequest request){
        caipinxinxi.setId(new Date().getTime() + new Double(Math.floor(Math.random()*1000)).longValue());
        caipinxinxi.setClicknum(0L);
        caipinxinxiService.insert(caipinxinxi);
        return R.ok();
    }

    @RequestMapping("/add")
    public R add(@RequestBody CaipinxinxiEntity caipinxinxi, HttpServletRequest request){
        caipinxinxi.setId(new Date().getTime() + new Double(Math.floor(Math.random()*1000)).longValue());
        caipinxinxi.setClicknum(0L);
        caipinxinxiService.insert(caipinxinxi);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody CaipinxinxiEntity caipinxinxi, HttpServletRequest request){
        caipinxinxiService.updateById(caipinxinxi);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caipinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
