package com.dao;

import com.entity.XiaofeifankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.entity.vo.XiaofeifankuiVO;
import com.entity.view.XiaofeifankuiView;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.Wrapper;

public interface XiaofeifankuiDao extends BaseMapper<XiaofeifankuiEntity> {
    List<XiaofeifankuiVO> selectListVO(@Param("ew") Wrapper<XiaofeifankuiEntity> wrapper);
    XiaofeifankuiVO selectVO(@Param("ew") Wrapper<XiaofeifankuiEntity> wrapper);
    List<XiaofeifankuiView> selectListView(@Param("ew") Wrapper<XiaofeifankuiEntity> wrapper);
    List<XiaofeifankuiView> selectListView(com.baomidou.mybatisplus.plugins.pagination.Pagination page,@Param("ew") Wrapper<XiaofeifankuiEntity> wrapper);
    XiaofeifankuiView selectView(@Param("ew") Wrapper<XiaofeifankuiEntity> wrapper);
}
