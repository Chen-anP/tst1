package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaofeifankuiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaofeifankuiVO;
import com.entity.view.XiaofeifankuiView;

public interface XiaofeifankuiService extends IService<XiaofeifankuiEntity> {
    PageUtils queryPage(Map<String, Object> params);
    List<XiaofeifankuiVO> selectListVO(Wrapper<XiaofeifankuiEntity> wrapper);
    XiaofeifankuiVO selectVO(@Param("ew") Wrapper<XiaofeifankuiEntity> wrapper);
    List<XiaofeifankuiView> selectListView(Wrapper<XiaofeifankuiEntity> wrapper);
    XiaofeifankuiView selectView(@Param("ew") Wrapper<XiaofeifankuiEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params,Wrapper<XiaofeifankuiEntity> wrapper);
}
