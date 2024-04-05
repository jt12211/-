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


import com.dao.SuqiufankuiDao;
import com.entity.SuqiufankuiEntity;
import com.service.SuqiufankuiService;
import com.entity.vo.SuqiufankuiVO;
import com.entity.view.SuqiufankuiView;

@Service("suqiufankuiService")
public class SuqiufankuiServiceImpl extends ServiceImpl<SuqiufankuiDao, SuqiufankuiEntity> implements SuqiufankuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SuqiufankuiEntity> page = this.selectPage(
                new Query<SuqiufankuiEntity>(params).getPage(),
                new EntityWrapper<SuqiufankuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SuqiufankuiEntity> wrapper) {
		  Page<SuqiufankuiView> page =new Query<SuqiufankuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SuqiufankuiVO> selectListVO(Wrapper<SuqiufankuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SuqiufankuiVO selectVO(Wrapper<SuqiufankuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SuqiufankuiView> selectListView(Wrapper<SuqiufankuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SuqiufankuiView selectView(Wrapper<SuqiufankuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
