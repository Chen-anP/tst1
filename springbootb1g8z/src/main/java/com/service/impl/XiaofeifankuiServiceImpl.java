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

import com.dao.XiaofeifankuiDao;
import com.entity.XiaofeifankuiEntity;
import com.service.XiaofeifankuiService;
import com.entity.vo.XiaofeifankuiVO;
import com.entity.view.XiaofeifankuiView;

@Service("xiaofeifankuiService")
public class XiaofeifankuiServiceImpl extends ServiceImpl<XiaofeifankuiDao, XiaofeifankuiEntity> implements XiaofeifankuiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaofeifankuiEntity> page = this.selectPage(
                new Query<XiaofeifankuiEntity>(params).getPage(),
                new EntityWrapper<XiaofeifankuiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaofeifankuiEntity> wrapper) {
        Page<XiaofeifankuiView> page = new Query<XiaofeifankuiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<XiaofeifankuiVO> selectListVO(Wrapper<XiaofeifankuiEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public XiaofeifankuiVO selectVO(Wrapper<XiaofeifankuiEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<XiaofeifankuiView> selectListView(Wrapper<XiaofeifankuiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public XiaofeifankuiView selectView(Wrapper<XiaofeifankuiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
