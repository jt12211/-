package com.dao;

import com.entity.ZizhuxuancanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZizhuxuancanVO;
import com.entity.view.ZizhuxuancanView;


/**
 * 自助选餐
 * 
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
public interface ZizhuxuancanDao extends BaseMapper<ZizhuxuancanEntity> {
	
	List<ZizhuxuancanVO> selectListVO(@Param("ew") Wrapper<ZizhuxuancanEntity> wrapper);
	
	ZizhuxuancanVO selectVO(@Param("ew") Wrapper<ZizhuxuancanEntity> wrapper);
	
	List<ZizhuxuancanView> selectListView(@Param("ew") Wrapper<ZizhuxuancanEntity> wrapper);

	List<ZizhuxuancanView> selectListView(Pagination page,@Param("ew") Wrapper<ZizhuxuancanEntity> wrapper);

	
	ZizhuxuancanView selectView(@Param("ew") Wrapper<ZizhuxuancanEntity> wrapper);
	

}
