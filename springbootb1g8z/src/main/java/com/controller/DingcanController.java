package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.annotation.IgnoreAuth;

import com.entity.DingcanEntity;
import com.service.DingcanService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 订餐
 */
@RestController
@RequestMapping("/dingcan")
public class DingcanController {
    @Autowired
    private DingcanService dingcanService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String,Object> params,DingcanEntity dingcan,HttpServletRequest request){
        EntityWrapper<DingcanEntity> ew = new EntityWrapper<DingcanEntity>();
        PageUtils page = dingcanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingcan), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/list")
    public R list(@RequestParam Map<String,Object> params,DingcanEntity dingcan,HttpServletRequest request){
        EntityWrapper<DingcanEntity> ew = new EntityWrapper<DingcanEntity>();
        PageUtils page = dingcanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingcan), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/lists")
    public R lists(DingcanEntity dingcan){
        EntityWrapper<DingcanEntity> ew = new EntityWrapper<DingcanEntity>();
        ew.allEq(MPUtil.allEQMapPre(dingcan, "dingcan"));
        return R.ok().put("data", dingcanService.selectListView(ew));
    }

    @RequestMapping("/query")
    public R query(DingcanEntity dingcan){
        EntityWrapper<DingcanEntity> ew = new EntityWrapper<DingcanEntity>();
        ew.allEq(MPUtil.allEQMapPre(dingcan, "dingcan"));
        return R.ok().put("data", dingcanService.selectView(ew));
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingcanEntity dingcan = dingcanService.selectById(id);
        return R.ok().put("data", dingcan);
    }

    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingcanEntity dingcan = dingcanService.selectById(id);
        return R.ok().put("data", dingcan);
    }

    @RequestMapping("/save")
    public R save(@RequestBody DingcanEntity dingcan, HttpServletRequest request){
        Object tableObj = request.getSession().getAttribute("tableName");
        if(tableObj!=null && tableObj.toString().equals("yuangong")){
            return R.error("员工无权执行订餐操作");
        }
        dingcan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        dingcanService.insert(dingcan);
        return R.ok();
    }

    @RequestMapping("/add")
    public R add(@RequestBody DingcanEntity dingcan, HttpServletRequest request){
        Object tableObj = request.getSession().getAttribute("tableName");
        if(tableObj!=null && tableObj.toString().equals("yuangong")){
            return R.error("员工无权执行订餐操作");
        }
        dingcan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        dingcanService.insert(dingcan);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody DingcanEntity dingcan, HttpServletRequest request){
        dingcanService.updateById(dingcan);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingcanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 用户退订（仅允许本人退订）
     */
    @RequestMapping("/cancel")
    public R cancel(@RequestBody Long id, HttpServletRequest request){
        DingcanEntity dingcan = dingcanService.selectById(id);
        if(dingcan==null) {
            return R.error("订单不存在");
        }
        Object tableObj = request.getSession().getAttribute("tableName");
        if(tableObj!=null && tableObj.toString().equals("yuangong")){
            return R.error("员工无权执行退订操作");
        }
        if(tableObj!=null && tableObj.toString().equals("yonghu")){
            String username = (String)request.getSession().getAttribute("username");
            if(username==null || !username.equals(dingcan.getYonghuming())){
                return R.error("无权限取消他人订单");
            }
        }
        dingcanService.deleteById(id);
        return R.ok();
    }

}
