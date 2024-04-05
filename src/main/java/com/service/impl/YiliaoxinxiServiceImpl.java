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


import com.dao.YiliaoxinxiDao;
import com.entity.YiliaoxinxiEntity;
import com.service.YiliaoxinxiService;
import com.entity.vo.YiliaoxinxiVO;
import com.entity.view.YiliaoxinxiView;

@Service("yiliaoxinxiService")
public class YiliaoxinxiServiceImpl extends ServiceImpl<YiliaoxinxiDao, YiliaoxinxiEntity> implements YiliaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiliaoxinxiEntity> page = this.selectPage(
                new Query<YiliaoxinxiEntity>(params).getPage(),
                new EntityWrapper<YiliaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiliaoxinxiEntity> wrapper) {
		  Page<YiliaoxinxiView> page =new Query<YiliaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YiliaoxinxiVO> selectListVO(Wrapper<YiliaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YiliaoxinxiVO selectVO(Wrapper<YiliaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YiliaoxinxiView> selectListView(Wrapper<YiliaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiliaoxinxiView selectView(Wrapper<YiliaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
