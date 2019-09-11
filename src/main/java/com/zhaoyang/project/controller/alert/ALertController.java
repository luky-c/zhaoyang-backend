package com.zhaoyang.project.controller.alert;
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
@RequestMapping("/alert")
@Import(GlobalCorsConfig.class)
public class ALertController {

    private String result1 = null;

    private String StartMeasuresResult = null;
    private String StartAlertResult = null;

    private String getDatafromFile(String fileName) {

        String Path="D:/Project/LouProject(1)/LouProject/china-main-city" + fileName+ ".json";
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    @RequestMapping(value = "/getCityJson", method = RequestMethod.GET)
    public String getCityJson(@RequestParam(value="cityName",required = false) String cityName){

        String resultCity = null;

        resultCity=getDatafromFile(cityName);
        return resultCity;
    }
/*
    @RequestMapping(value = "/getStartAlert", method = RequestMethod.GET)
    public String getStartAlert(@RequestParam(value="startDate",required = true) String startDate,@RequestParam(value="siteToken",required = true) String siteToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){

        String url = "http://localhost:8080/sitewhere/api/sites/"+siteToken+"/alerts?startDate="+startDate;

//        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
//            @Override
//            public void onResponse(String result) {
//                System.out.println(result);
//                StartAlertResult = result;
////                List<MeasureBean> measureBean=JSON.toJavaObject(JSON.parseObject(result), MeasureBean.class);
//
//
//            }
//        });
//        while(StartAlertResult == null){
//            continue;
//        }
        StartAlertResult = NetworkUtils.doGetAsync(url, sitewhereToken);
        System.out.println(StartAlertResult);

        return StartAlertResult;
    }
*/





}
