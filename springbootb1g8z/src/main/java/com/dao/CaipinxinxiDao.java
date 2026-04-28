package com.dao;

import com.entity.CaipinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.entity.vo.CaipinxinxiVO;
import com.entity.view.CaipinxinxiView;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.Wrapper;

public interface CaipinxinxiDao extends BaseMapper<CaipinxinxiEntity> {
    List<CaipinxinxiVO> selectListVO(@Param("ew") Wrapper<CaipinxinxiEntity> wrapper);
    CaipinxinxiVO selectVO(@Param("ew") Wrapper<CaipinxinxiEntity> wrapper);
    List<CaipinxinxiView> selectListView(@Param("ew") Wrapper<CaipinxinxiEntity> wrapper);
    List<CaipinxinxiView> selectListView(com.baomidou.mybatisplus.plugins.pagination.Pagination page, @Param("ew") Wrapper<CaipinxinxiEntity> wrapper);
    CaipinxinxiView selectView(@Param("ew") Wrapper<CaipinxinxiEntity> wrapper);
}
