package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZizhuxuancanEntity;
import com.entity.view.ZizhuxuancanView;

import com.service.ZizhuxuancanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 自助选餐
 * 后端接口
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
@RestController
@RequestMapping("/zizhuxuancan")
public class ZizhuxuancanController {
    @Autowired
    private ZizhuxuancanService zizhuxuancanService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZizhuxuancanEntity zizhuxuancan,
		HttpServletRequest request){
        EntityWrapper<ZizhuxuancanEntity> ew = new EntityWrapper<ZizhuxuancanEntity>();

		PageUtils page = zizhuxuancanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zizhuxuancan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZizhuxuancanEntity zizhuxuancan, 
		HttpServletRequest request){
        EntityWrapper<ZizhuxuancanEntity> ew = new EntityWrapper<ZizhuxuancanEntity>();

		PageUtils page = zizhuxuancanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zizhuxuancan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZizhuxuancanEntity zizhuxuancan){
       	EntityWrapper<ZizhuxuancanEntity> ew = new EntityWrapper<ZizhuxuancanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zizhuxuancan, "zizhuxuancan")); 
        return R.ok().put("data", zizhuxuancanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZizhuxuancanEntity zizhuxuancan){
        EntityWrapper< ZizhuxuancanEntity> ew = new EntityWrapper< ZizhuxuancanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zizhuxuancan, "zizhuxuancan")); 
		ZizhuxuancanView zizhuxuancanView =  zizhuxuancanService.selectView(ew);
		return R.ok("查询自助选餐成功").put("data", zizhuxuancanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZizhuxuancanEntity zizhuxuancan = zizhuxuancanService.selectById(id);
        return R.ok().put("data", zizhuxuancan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZizhuxuancanEntity zizhuxuancan = zizhuxuancanService.selectById(id);
        return R.ok().put("data", zizhuxuancan);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ZizhuxuancanEntity zizhuxuancan = zizhuxuancanService.selectById(id);
        if(type.equals("1")) {
        	zizhuxuancan.setThumbsupnum(zizhuxuancan.getThumbsupnum()+1);
        } else {
        	zizhuxuancan.setCrazilynum(zizhuxuancan.getCrazilynum()+1);
        }
        zizhuxuancanService.updateById(zizhuxuancan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZizhuxuancanEntity zizhuxuancan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zizhuxuancan);
        zizhuxuancanService.insert(zizhuxuancan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZizhuxuancanEntity zizhuxuancan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zizhuxuancan);
        zizhuxuancanService.insert(zizhuxuancan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZizhuxuancanEntity zizhuxuancan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zizhuxuancan);
        zizhuxuancanService.updateById(zizhuxuancan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zizhuxuancanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
