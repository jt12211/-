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


import com.dao.DiscusszizhuxuancanDao;
import com.entity.DiscusszizhuxuancanEntity;
import com.service.DiscusszizhuxuancanService;
import com.entity.vo.DiscusszizhuxuancanVO;
import com.entity.view.DiscusszizhuxuancanView;

@Service("discusszizhuxuancanService")
public class DiscusszizhuxuancanServiceImpl extends ServiceImpl<DiscusszizhuxuancanDao, DiscusszizhuxuancanEntity> implements DiscusszizhuxuancanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszizhuxuancanEntity> page = this.selectPage(
                new Query<DiscusszizhuxuancanEntity>(params).getPage(),
                new EntityWrapper<DiscusszizhuxuancanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszizhuxuancanEntity> wrapper) {
		  Page<DiscusszizhuxuancanView> page =new Query<DiscusszizhuxuancanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusszizhuxuancanVO> selectListVO(Wrapper<DiscusszizhuxuancanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszizhuxuancanVO selectVO(Wrapper<DiscusszizhuxuancanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszizhuxuancanView> selectListView(Wrapper<DiscusszizhuxuancanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszizhuxuancanView selectView(Wrapper<DiscusszizhuxuancanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
