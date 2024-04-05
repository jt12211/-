package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiliaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YiliaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YiliaoxinxiView;


/**
 * 医疗信息
 *
 * @author 
 * @email 
 * @date 2030-01-16 20:16:35
 */
public interface YiliaoxinxiService extends IService<YiliaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiliaoxinxiVO> selectListVO(Wrapper<YiliaoxinxiEntity> wrapper);
   	
   	YiliaoxinxiVO selectVO(@Param("ew") Wrapper<YiliaoxinxiEntity> wrapper);
   	
   	List<YiliaoxinxiView> selectListView(Wrapper<YiliaoxinxiEntity> wrapper);
   	
   	YiliaoxinxiView selectView(@Param("ew") Wrapper<YiliaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiliaoxinxiEntity> wrapper);

   	

}

