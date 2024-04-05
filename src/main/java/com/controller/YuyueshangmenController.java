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

import com.entity.YuyueshangmenEntity;
import com.entity.view.YuyueshangmenView;

import com.service.YuyueshangmenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 预约上门
 * 后端接口
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
@RestController
@RequestMapping("/yuyueshangmen")
public class YuyueshangmenController {
    @Autowired
    private YuyueshangmenService yuyueshangmenService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyueshangmenEntity yuyueshangmen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yuyueshangmen.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyueshangmenEntity> ew = new EntityWrapper<YuyueshangmenEntity>();

		PageUtils page = yuyueshangmenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyueshangmen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyueshangmenEntity yuyueshangmen, 
		HttpServletRequest request){
        EntityWrapper<YuyueshangmenEntity> ew = new EntityWrapper<YuyueshangmenEntity>();

		PageUtils page = yuyueshangmenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyueshangmen), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyueshangmenEntity yuyueshangmen){
       	EntityWrapper<YuyueshangmenEntity> ew = new EntityWrapper<YuyueshangmenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyueshangmen, "yuyueshangmen")); 
        return R.ok().put("data", yuyueshangmenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyueshangmenEntity yuyueshangmen){
        EntityWrapper< YuyueshangmenEntity> ew = new EntityWrapper< YuyueshangmenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyueshangmen, "yuyueshangmen")); 
		YuyueshangmenView yuyueshangmenView =  yuyueshangmenService.selectView(ew);
		return R.ok("查询预约上门成功").put("data", yuyueshangmenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyueshangmenEntity yuyueshangmen = yuyueshangmenService.selectById(id);
        return R.ok().put("data", yuyueshangmen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyueshangmenEntity yuyueshangmen = yuyueshangmenService.selectById(id);
        return R.ok().put("data", yuyueshangmen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyueshangmenEntity yuyueshangmen, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuyueshangmen);
        yuyueshangmenService.insert(yuyueshangmen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyueshangmenEntity yuyueshangmen, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuyueshangmen);
        yuyueshangmenService.insert(yuyueshangmen);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyueshangmenEntity yuyueshangmen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyueshangmen);
        yuyueshangmenService.updateById(yuyueshangmen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyueshangmenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
