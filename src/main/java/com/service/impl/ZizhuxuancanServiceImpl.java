package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZizhuxuancanDao;
import com.entity.ZizhuxuancanEntity;
import com.service.ZizhuxuancanService;
import com.entity.vo.ZizhuxuancanVO;
import com.entity.view.ZizhuxuancanView;

@Service("zizhuxuancanService")
public class ZizhuxuancanServiceImpl extends ServiceImpl<ZizhuxuancanDao, ZizhuxuancanEntity> implements ZizhuxuancanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZizhuxuancanEntity> page = this.selectPage(
                new Query<ZizhuxuancanEntity>(params).getPage(),
                new EntityWrapper<ZizhuxuancanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZizhuxuancanEntity> wrapper) {
		  Page<ZizhuxuancanView> page =new Query<ZizhuxuancanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZizhuxuancanVO> selectListVO(Wrapper<ZizhuxuancanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZizhuxuancanVO selectVO(Wrapper<ZizhuxuancanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZizhuxuancanView> selectListView(Wrapper<ZizhuxuancanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZizhuxuancanView selectView(Wrapper<ZizhuxuancanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
