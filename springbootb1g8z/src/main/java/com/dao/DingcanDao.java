package com.dao;

import com.entity.DingcanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.entity.vo.DingcanVO;
import com.entity.view.DingcanView;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.Wrapper;

public interface DingcanDao extends BaseMapper<DingcanEntity> {
    List<DingcanVO> selectListVO(@Param("ew") Wrapper<DingcanEntity> wrapper);
    DingcanVO selectVO(@Param("ew") Wrapper<DingcanEntity> wrapper);
    List<DingcanView> selectListView(@Param("ew") Wrapper<DingcanEntity> wrapper);
    List<DingcanView> selectListView(com.baomidou.mybatisplus.plugins.pagination.Pagination page,@Param("ew") Wrapper<DingcanEntity> wrapper);
    DingcanView selectView(@Param("ew") Wrapper<DingcanEntity> wrapper);
}
