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

import com.entity.YiliaoxinxiEntity;
import com.entity.view.YiliaoxinxiView;

import com.service.YiliaoxinxiService;
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
 * 医疗信息
 * 后端接口
 * @author 
 * @email 
 * @date 2030-01-16 20:16:35
 */
@RestController
@RequestMapping("/yiliaoxinxi")
public class YiliaoxinxiController {
    @Autowired
    private YiliaoxinxiService yiliaoxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YiliaoxinxiEntity yiliaoxinxi,
		HttpServletRequest request){
        EntityWrapper<YiliaoxinxiEntity> ew = new EntityWrapper<YiliaoxinxiEntity>();

		PageUtils page = yiliaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiliaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YiliaoxinxiEntity yiliaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<YiliaoxinxiEntity> ew = new EntityWrapper<YiliaoxinxiEntity>();

		PageUtils page = yiliaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiliaoxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YiliaoxinxiEntity yiliaoxinxi){
       	EntityWrapper<YiliaoxinxiEntity> ew = new EntityWrapper<YiliaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yiliaoxinxi, "yiliaoxinxi")); 
        return R.ok().put("data", yiliaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YiliaoxinxiEntity yiliaoxinxi){
        EntityWrapper< YiliaoxinxiEntity> ew = new EntityWrapper< YiliaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yiliaoxinxi, "yiliaoxinxi")); 
		YiliaoxinxiView yiliaoxinxiView =  yiliaoxinxiService.selectView(ew);
		return R.ok("查询医疗信息成功").put("data", yiliaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YiliaoxinxiEntity yiliaoxinxi = yiliaoxinxiService.selectById(id);
        return R.ok().put("data", yiliaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YiliaoxinxiEntity yiliaoxinxi = yiliaoxinxiService.selectById(id);
        return R.ok().put("data", yiliaoxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YiliaoxinxiEntity yiliaoxinxi = yiliaoxinxiService.selectById(id);
        if(type.equals("1")) {
        	yiliaoxinxi.setThumbsupnum(yiliaoxinxi.getThumbsupnum()+1);
        } else {
        	yiliaoxinxi.setCrazilynum(yiliaoxinxi.getCrazilynum()+1);
        }
        yiliaoxinxiService.updateById(yiliaoxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YiliaoxinxiEntity yiliaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yiliaoxinxi);
        yiliaoxinxiService.insert(yiliaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YiliaoxinxiEntity yiliaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yiliaoxinxi);
        yiliaoxinxiService.insert(yiliaoxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YiliaoxinxiEntity yiliaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yiliaoxinxi);
        yiliaoxinxiService.updateById(yiliaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yiliaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
