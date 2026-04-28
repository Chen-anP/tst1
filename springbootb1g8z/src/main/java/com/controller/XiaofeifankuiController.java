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

import com.entity.XiaofeifankuiEntity;
import com.service.XiaofeifankuiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 消费反馈
 */
@RestController
@RequestMapping("/xiaofeifankui")
public class XiaofeifankuiController {
    @Autowired
    private XiaofeifankuiService xiaofeifankuiService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String,Object> params,XiaofeifankuiEntity xiaofeifankui,HttpServletRequest request){
        EntityWrapper<XiaofeifankuiEntity> ew = new EntityWrapper<XiaofeifankuiEntity>();
        PageUtils page = xiaofeifankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaofeifankui), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String,Object> params,XiaofeifankuiEntity xiaofeifankui,HttpServletRequest request){
        EntityWrapper<XiaofeifankuiEntity> ew = new EntityWrapper<XiaofeifankuiEntity>();
        PageUtils page = xiaofeifankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaofeifankui), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/add")
    public R add(@RequestBody XiaofeifankuiEntity xiaofeifankui, HttpServletRequest request){
        xiaofeifankui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        xiaofeifankuiService.insert(xiaofeifankui);
        return R.ok();
    }

    @RequestMapping("/save")
    public R save(@RequestBody XiaofeifankuiEntity xiaofeifankui, HttpServletRequest request){
        xiaofeifankui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        xiaofeifankuiService.insert(xiaofeifankui);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody XiaofeifankuiEntity xiaofeifankui, HttpServletRequest request){
        xiaofeifankuiService.updateById(xiaofeifankui);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaofeifankuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaofeifankuiEntity e = xiaofeifankuiService.selectById(id);
        return R.ok().put("data", e);
    }

}
