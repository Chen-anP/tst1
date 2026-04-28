package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingcanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.DingcanVO;
import com.entity.view.DingcanView;

public interface DingcanService extends IService<DingcanEntity> {
    PageUtils queryPage(Map<String, Object> params);
    List<DingcanVO> selectListVO(Wrapper<DingcanEntity> wrapper);
    DingcanVO selectVO(@Param("ew") Wrapper<DingcanEntity> wrapper);
    List<DingcanView> selectListView(Wrapper<DingcanEntity> wrapper);
    DingcanView selectView(@Param("ew") Wrapper<DingcanEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params,Wrapper<DingcanEntity> wrapper);
}
