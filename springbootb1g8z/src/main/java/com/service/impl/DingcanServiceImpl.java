package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.DingcanDao;
import com.entity.DingcanEntity;
import com.service.DingcanService;
import com.entity.vo.DingcanVO;
import com.entity.view.DingcanView;

@Service("dingcanService")
public class DingcanServiceImpl extends ServiceImpl<DingcanDao, DingcanEntity> implements DingcanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingcanEntity> page = this.selectPage(
                new Query<DingcanEntity>(params).getPage(),
                new EntityWrapper<DingcanEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<DingcanEntity> wrapper) {
        Page<DingcanView> page = new Query<DingcanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<DingcanVO> selectListVO(Wrapper<DingcanEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public DingcanVO selectVO(Wrapper<DingcanEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<DingcanView> selectListView(Wrapper<DingcanEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public DingcanView selectView(Wrapper<DingcanEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
