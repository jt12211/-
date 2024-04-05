package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SuqiufankuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SuqiufankuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SuqiufankuiView;


/**
 * 诉求反馈
 *
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
public interface SuqiufankuiService extends IService<SuqiufankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SuqiufankuiVO> selectListVO(Wrapper<SuqiufankuiEntity> wrapper);
   	
   	SuqiufankuiVO selectVO(@Param("ew") Wrapper<SuqiufankuiEntity> wrapper);
   	
   	List<SuqiufankuiView> selectListView(Wrapper<SuqiufankuiEntity> wrapper);
   	
   	SuqiufankuiView selectView(@Param("ew") Wrapper<SuqiufankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SuqiufankuiEntity> wrapper);

   	

}

