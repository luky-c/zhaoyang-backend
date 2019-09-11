package com.zhaoyang.project.controller.device;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;
import com.zhaoyang.project.config.GlobalCorsConfig;
import com.zhaoyang.project.database.DbDeviceManage;
import com.zhaoyang.project.database.DbManager;
import com.zhaoyang.project.interfaces.ResultInfoInterface;
import com.zhaoyang.project.model.*;
import com.zhaoyang.project.model.AddPerson.AddPersonBean;
import com.zhaoyang.project.model.AddSite.AddSiteBean;
import com.zhaoyang.project.model.AssociaPerson.AssociaPersonBean;
import com.zhaoyang.project.model.AssociaPerson.Metadata;
import com.zhaoyang.project.model.CreateDevice.CreateDeviceBean;
import com.zhaoyang.project.model.DeviceList.Data;
import com.zhaoyang.project.model.DeviceList.DeviceList;
import com.zhaoyang.project.model.Measure.MeasureBean;
import com.zhaoyang.project.model.ResDeviceList.ResDeviceListBean;
import com.zhaoyang.project.model.ResDeviceList.ResultBean;
import com.zhaoyang.project.model.SpecToken.SpecTokenBean;
import com.zhaoyang.project.model.SpecToken.SpecTokensBean;
import com.zhaoyang.project.model.table.DeviceInfoTable;
import com.zhaoyang.project.network.NetworkUtils;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sun.nio.ch.Net;

import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@ComponentScan
@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping("/deviceInfo")
@Import(GlobalCorsConfig.class)
public class DeviceDetailController {
    private String resultDetail = null;

    //获取device Detail
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    public DeviceInfoTable getDetail(@RequestParam(value="id",required = true) long id){
    	DbDeviceManage dbDeviceManage = new DbDeviceManage();
       return  dbDeviceManage.selectById(id);
    }



}
