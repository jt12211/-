package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyiliaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyiliaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyiliaoxinxiView;


/**
 * 医疗信息评论表
 *
 * @author 
 * @email 
 * @date 2030-01-16 20:16:37
 */
public interface DiscussyiliaoxinxiService extends IService<DiscussyiliaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyiliaoxinxiVO> selectListVO(Wrapper<DiscussyiliaoxinxiEntity> wrapper);
   	
   	DiscussyiliaoxinxiVO selectVO(@Param("ew") Wrapper<DiscussyiliaoxinxiEntity> wrapper);
   	
   	List<DiscussyiliaoxinxiView> selectListView(Wrapper<DiscussyiliaoxinxiEntity> wrapper);
   	
   	DiscussyiliaoxinxiView selectView(@Param("ew") Wrapper<DiscussyiliaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyiliaoxinxiEntity> wrapper);

   	

}

