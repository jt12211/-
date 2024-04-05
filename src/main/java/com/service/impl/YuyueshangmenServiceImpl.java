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


import com.dao.YuyueshangmenDao;
import com.entity.YuyueshangmenEntity;
import com.service.YuyueshangmenService;
import com.entity.vo.YuyueshangmenVO;
import com.entity.view.YuyueshangmenView;

@Service("yuyueshangmenService")
public class YuyueshangmenServiceImpl extends ServiceImpl<YuyueshangmenDao, YuyueshangmenEntity> implements YuyueshangmenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyueshangmenEntity> page = this.selectPage(
                new Query<YuyueshangmenEntity>(params).getPage(),
                new EntityWrapper<YuyueshangmenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyueshangmenEntity> wrapper) {
		  Page<YuyueshangmenView> page =new Query<YuyueshangmenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YuyueshangmenVO> selectListVO(Wrapper<YuyueshangmenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyueshangmenVO selectVO(Wrapper<YuyueshangmenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyueshangmenView> selectListView(Wrapper<YuyueshangmenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyueshangmenView selectView(Wrapper<YuyueshangmenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
