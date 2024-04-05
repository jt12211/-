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

import com.entity.CaipinfenleiEntity;
import com.entity.view.CaipinfenleiView;

import com.service.CaipinfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 菜品分类
 * 后端接口
 * @author 
 * @email 
 * @date 2030-01-16 20:16:35
 */
@RestController
@RequestMapping("/caipinfenlei")
public class CaipinfenleiController {
    @Autowired
    private CaipinfenleiService caipinfenleiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaipinfenleiEntity caipinfenlei,
		HttpServletRequest request){
        EntityWrapper<CaipinfenleiEntity> ew = new EntityWrapper<CaipinfenleiEntity>();

		PageUtils page = caipinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaipinfenleiEntity caipinfenlei, 
		HttpServletRequest request){
        EntityWrapper<CaipinfenleiEntity> ew = new EntityWrapper<CaipinfenleiEntity>();

		PageUtils page = caipinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinfenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaipinfenleiEntity caipinfenlei){
       	EntityWrapper<CaipinfenleiEntity> ew = new EntityWrapper<CaipinfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caipinfenlei, "caipinfenlei")); 
        return R.ok().put("data", caipinfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaipinfenleiEntity caipinfenlei){
        EntityWrapper< CaipinfenleiEntity> ew = new EntityWrapper< CaipinfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caipinfenlei, "caipinfenlei")); 
		CaipinfenleiView caipinfenleiView =  caipinfenleiService.selectView(ew);
		return R.ok("查询菜品分类成功").put("data", caipinfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaipinfenleiEntity caipinfenlei = caipinfenleiService.selectById(id);
        return R.ok().put("data", caipinfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaipinfenleiEntity caipinfenlei = caipinfenleiService.selectById(id);
        return R.ok().put("data", caipinfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaipinfenleiEntity caipinfenlei, HttpServletRequest request){
        if(caipinfenleiService.selectCount(new EntityWrapper<CaipinfenleiEntity>().eq("caipinfenlei", caipinfenlei.getCaipinfenlei()))>0) {
            return R.error("菜品分类已存在");
        }
    	//ValidatorUtils.validateEntity(caipinfenlei);
        caipinfenleiService.insert(caipinfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaipinfenleiEntity caipinfenlei, HttpServletRequest request){
        if(caipinfenleiService.selectCount(new EntityWrapper<CaipinfenleiEntity>().eq("caipinfenlei", caipinfenlei.getCaipinfenlei()))>0) {
            return R.error("菜品分类已存在");
        }
    	//ValidatorUtils.validateEntity(caipinfenlei);
        caipinfenleiService.insert(caipinfenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaipinfenleiEntity caipinfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinfenlei);
        if(caipinfenleiService.selectCount(new EntityWrapper<CaipinfenleiEntity>().ne("id", caipinfenlei.getId()).eq("caipinfenlei", caipinfenlei.getCaipinfenlei()))>0) {
            return R.error("菜品分类已存在");
        }
        caipinfenleiService.updateById(caipinfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caipinfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
