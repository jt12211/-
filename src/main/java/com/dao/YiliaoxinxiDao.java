package com.dao;

import com.entity.YiliaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YiliaoxinxiVO;
import com.entity.view.YiliaoxinxiView;


/**
 * 医疗信息
 * 
 * @author 
 * @email 
 * @date 2030-01-16 20:16:35
 */
public interface YiliaoxinxiDao extends BaseMapper<YiliaoxinxiEntity> {
	
	List<YiliaoxinxiVO> selectListVO(@Param("ew") Wrapper<YiliaoxinxiEntity> wrapper);
	
	YiliaoxinxiVO selectVO(@Param("ew") Wrapper<YiliaoxinxiEntity> wrapper);
	
	List<YiliaoxinxiView> selectListView(@Param("ew") Wrapper<YiliaoxinxiEntity> wrapper);

	List<YiliaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YiliaoxinxiEntity> wrapper);

	
	YiliaoxinxiView selectView(@Param("ew") Wrapper<YiliaoxinxiEntity> wrapper);
	

}
