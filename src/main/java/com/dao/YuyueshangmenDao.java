package com.dao;

import com.entity.YuyueshangmenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuyueshangmenVO;
import com.entity.view.YuyueshangmenView;


/**
 * 预约上门
 * 
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
public interface YuyueshangmenDao extends BaseMapper<YuyueshangmenEntity> {
	
	List<YuyueshangmenVO> selectListVO(@Param("ew") Wrapper<YuyueshangmenEntity> wrapper);
	
	YuyueshangmenVO selectVO(@Param("ew") Wrapper<YuyueshangmenEntity> wrapper);
	
	List<YuyueshangmenView> selectListView(@Param("ew") Wrapper<YuyueshangmenEntity> wrapper);

	List<YuyueshangmenView> selectListView(Pagination page,@Param("ew") Wrapper<YuyueshangmenEntity> wrapper);

	
	YuyueshangmenView selectView(@Param("ew") Wrapper<YuyueshangmenEntity> wrapper);
	

}
