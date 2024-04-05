package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszizhuxuancanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszizhuxuancanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszizhuxuancanView;


/**
 * 自助选餐评论表
 *
 * @author 
 * @email 
 * @date 2030-01-16 20:16:37
 */
public interface DiscusszizhuxuancanService extends IService<DiscusszizhuxuancanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszizhuxuancanVO> selectListVO(Wrapper<DiscusszizhuxuancanEntity> wrapper);
   	
   	DiscusszizhuxuancanVO selectVO(@Param("ew") Wrapper<DiscusszizhuxuancanEntity> wrapper);
   	
   	List<DiscusszizhuxuancanView> selectListView(Wrapper<DiscusszizhuxuancanEntity> wrapper);
   	
   	DiscusszizhuxuancanView selectView(@Param("ew") Wrapper<DiscusszizhuxuancanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszizhuxuancanEntity> wrapper);

   	

}

