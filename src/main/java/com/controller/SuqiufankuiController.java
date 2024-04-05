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

import com.entity.SuqiufankuiEntity;
import com.entity.view.SuqiufankuiView;

import com.service.SuqiufankuiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 诉求反馈
 * 后端接口
 * @author 
 * @email 
 * @date 2030-01-16 20:16:36
 */
@RestController
@RequestMapping("/suqiufankui")
public class SuqiufankuiController {
    @Autowired
    private SuqiufankuiService suqiufankuiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SuqiufankuiEntity suqiufankui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			suqiufankui.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<SuqiufankuiEntity> ew = new EntityWrapper<SuqiufankuiEntity>();

		PageUtils page = suqiufankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, suqiufankui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SuqiufankuiEntity suqiufankui, 
		HttpServletRequest request){
        EntityWrapper<SuqiufankuiEntity> ew = new EntityWrapper<SuqiufankuiEntity>();

		PageUtils page = suqiufankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, suqiufankui), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SuqiufankuiEntity suqiufankui){
       	EntityWrapper<SuqiufankuiEntity> ew = new EntityWrapper<SuqiufankuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( suqiufankui, "suqiufankui")); 
        return R.ok().put("data", suqiufankuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SuqiufankuiEntity suqiufankui){
        EntityWrapper< SuqiufankuiEntity> ew = new EntityWrapper< SuqiufankuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( suqiufankui, "suqiufankui")); 
		SuqiufankuiView suqiufankuiView =  suqiufankuiService.selectView(ew);
		return R.ok("查询诉求反馈成功").put("data", suqiufankuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SuqiufankuiEntity suqiufankui = suqiufankuiService.selectById(id);
        return R.ok().put("data", suqiufankui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SuqiufankuiEntity suqiufankui = suqiufankuiService.selectById(id);
        return R.ok().put("data", suqiufankui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SuqiufankuiEntity suqiufankui, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(suqiufankui);
        suqiufankuiService.insert(suqiufankui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SuqiufankuiEntity suqiufankui, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(suqiufankui);
        suqiufankuiService.insert(suqiufankui);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SuqiufankuiEntity suqiufankui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(suqiufankui);
        suqiufankuiService.updateById(suqiufankui);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<SuqiufankuiEntity> list = new ArrayList<SuqiufankuiEntity>();
        for(Long id : ids) {
            SuqiufankuiEntity suqiufankui = suqiufankuiService.selectById(id);
            suqiufankui.setSfsh(sfsh);
            suqiufankui.setShhf(shhf);
            list.add(suqiufankui);
        }
        suqiufankuiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        suqiufankuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
