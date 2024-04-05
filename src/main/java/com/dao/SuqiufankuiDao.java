package com.dao;

import com.entity.SuqiufankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SuqiufankuiVO;
import com.entity.view.SuqiufankuiView;


/**
 * 诉求反馈
 * 
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
public interface SuqiufankuiDao extends BaseMapper<SuqiufankuiEntity> {
	
	List<SuqiufankuiVO> selectListVO(@Param("ew") Wrapper<SuqiufankuiEntity> wrapper);
	
	SuqiufankuiVO selectVO(@Param("ew") Wrapper<SuqiufankuiEntity> wrapper);
	
	List<SuqiufankuiView> selectListView(@Param("ew") Wrapper<SuqiufankuiEntity> wrapper);

	List<SuqiufankuiView> selectListView(Pagination page,@Param("ew") Wrapper<SuqiufankuiEntity> wrapper);

	
	SuqiufankuiView selectView(@Param("ew") Wrapper<SuqiufankuiEntity> wrapper);
	

}
