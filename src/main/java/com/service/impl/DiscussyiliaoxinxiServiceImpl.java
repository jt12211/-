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


import com.dao.DiscussyiliaoxinxiDao;
import com.entity.DiscussyiliaoxinxiEntity;
import com.service.DiscussyiliaoxinxiService;
import com.entity.vo.DiscussyiliaoxinxiVO;
import com.entity.view.DiscussyiliaoxinxiView;

@Service("discussyiliaoxinxiService")
public class DiscussyiliaoxinxiServiceImpl extends ServiceImpl<DiscussyiliaoxinxiDao, DiscussyiliaoxinxiEntity> implements DiscussyiliaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyiliaoxinxiEntity> page = this.selectPage(
                new Query<DiscussyiliaoxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussyiliaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyiliaoxinxiEntity> wrapper) {
		  Page<DiscussyiliaoxinxiView> page =new Query<DiscussyiliaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyiliaoxinxiVO> selectListVO(Wrapper<DiscussyiliaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyiliaoxinxiVO selectVO(Wrapper<DiscussyiliaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyiliaoxinxiView> selectListView(Wrapper<DiscussyiliaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyiliaoxinxiView selectView(Wrapper<DiscussyiliaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
