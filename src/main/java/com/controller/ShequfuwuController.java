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

import com.entity.ShequfuwuEntity;
import com.entity.view.ShequfuwuView;

import com.service.ShequfuwuService;
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
 * 社区服务
 * 后端接口
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
@RestController
@RequestMapping("/shequfuwu")
public class ShequfuwuController {
    @Autowired
    private ShequfuwuService shequfuwuService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShequfuwuEntity shequfuwu,
		HttpServletRequest request){
        EntityWrapper<ShequfuwuEntity> ew = new EntityWrapper<ShequfuwuEntity>();

		PageUtils page = shequfuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequfuwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShequfuwuEntity shequfuwu, 
		HttpServletRequest request){
        EntityWrapper<ShequfuwuEntity> ew = new EntityWrapper<ShequfuwuEntity>();

		PageUtils page = shequfuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequfuwu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShequfuwuEntity shequfuwu){
       	EntityWrapper<ShequfuwuEntity> ew = new EntityWrapper<ShequfuwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shequfuwu, "shequfuwu")); 
        return R.ok().put("data", shequfuwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShequfuwuEntity shequfuwu){
        EntityWrapper< ShequfuwuEntity> ew = new EntityWrapper< ShequfuwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shequfuwu, "shequfuwu")); 
		ShequfuwuView shequfuwuView =  shequfuwuService.selectView(ew);
		return R.ok("查询社区服务成功").put("data", shequfuwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShequfuwuEntity shequfuwu = shequfuwuService.selectById(id);
        return R.ok().put("data", shequfuwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShequfuwuEntity shequfuwu = shequfuwuService.selectById(id);
        return R.ok().put("data", shequfuwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShequfuwuEntity shequfuwu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shequfuwu);
        shequfuwuService.insert(shequfuwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShequfuwuEntity shequfuwu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shequfuwu);
        shequfuwuService.insert(shequfuwu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShequfuwuEntity shequfuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shequfuwu);
        shequfuwuService.updateById(shequfuwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shequfuwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
