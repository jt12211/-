package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyueshangmenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuyueshangmenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyueshangmenView;


/**
 * 预约上门
 *
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
public interface YuyueshangmenService extends IService<YuyueshangmenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyueshangmenVO> selectListVO(Wrapper<YuyueshangmenEntity> wrapper);
   	
   	YuyueshangmenVO selectVO(@Param("ew") Wrapper<YuyueshangmenEntity> wrapper);
   	
   	List<YuyueshangmenView> selectListView(Wrapper<YuyueshangmenEntity> wrapper);
   	
   	YuyueshangmenView selectView(@Param("ew") Wrapper<YuyueshangmenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyueshangmenEntity> wrapper);

   	

}

