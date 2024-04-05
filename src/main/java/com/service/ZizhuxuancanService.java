package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZizhuxuancanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZizhuxuancanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZizhuxuancanView;


/**
 * 自助选餐
 *
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
public interface ZizhuxuancanService extends IService<ZizhuxuancanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZizhuxuancanVO> selectListVO(Wrapper<ZizhuxuancanEntity> wrapper);
   	
   	ZizhuxuancanVO selectVO(@Param("ew") Wrapper<ZizhuxuancanEntity> wrapper);
   	
   	List<ZizhuxuancanView> selectListView(Wrapper<ZizhuxuancanEntity> wrapper);
   	
   	ZizhuxuancanView selectView(@Param("ew") Wrapper<ZizhuxuancanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZizhuxuancanEntity> wrapper);

   	

}

