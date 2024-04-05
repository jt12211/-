package com.dao;

import com.entity.DiscusszizhuxuancanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszizhuxuancanVO;
import com.entity.view.DiscusszizhuxuancanView;


/**
 * 自助选餐评论表
 * 
 * @author 
 * @email 
 * @date 2030-01-16 20:16:37
 */
public interface DiscusszizhuxuancanDao extends BaseMapper<DiscusszizhuxuancanEntity> {
	
	List<DiscusszizhuxuancanVO> selectListVO(@Param("ew") Wrapper<DiscusszizhuxuancanEntity> wrapper);
	
	DiscusszizhuxuancanVO selectVO(@Param("ew") Wrapper<DiscusszizhuxuancanEntity> wrapper);
	
	List<DiscusszizhuxuancanView> selectListView(@Param("ew") Wrapper<DiscusszizhuxuancanEntity> wrapper);

	List<DiscusszizhuxuancanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszizhuxuancanEntity> wrapper);

	
	DiscusszizhuxuancanView selectView(@Param("ew") Wrapper<DiscusszizhuxuancanEntity> wrapper);
	

}
