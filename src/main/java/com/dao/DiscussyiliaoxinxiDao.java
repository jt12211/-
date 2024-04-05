package com.dao;

import com.entity.DiscussyiliaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyiliaoxinxiVO;
import com.entity.view.DiscussyiliaoxinxiView;


/**
 * 医疗信息评论表
 * 
 * @author 
 * @email 
 * @date 2030-01-16 20:16:37
 */
public interface DiscussyiliaoxinxiDao extends BaseMapper<DiscussyiliaoxinxiEntity> {
	
	List<DiscussyiliaoxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussyiliaoxinxiEntity> wrapper);
	
	DiscussyiliaoxinxiVO selectVO(@Param("ew") Wrapper<DiscussyiliaoxinxiEntity> wrapper);
	
	List<DiscussyiliaoxinxiView> selectListView(@Param("ew") Wrapper<DiscussyiliaoxinxiEntity> wrapper);

	List<DiscussyiliaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyiliaoxinxiEntity> wrapper);

	
	DiscussyiliaoxinxiView selectView(@Param("ew") Wrapper<DiscussyiliaoxinxiEntity> wrapper);
	

}
