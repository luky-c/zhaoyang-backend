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
import java.util.ArrayList;
import java.util.List;
@ComponentScan
@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping("/device")
@Import(GlobalCorsConfig.class)
public class AddDeviceController {
    private Boolean includeAssignments;
    private Boolean includeZones;
    private int page;
    private int pageSize;
    private String result1 = null;
    DeviceList deviceList = new DeviceList();
    DeviceList deviceListResult= null;
    DeviceList siteDevices = new DeviceList();
    DeviceList siteDevicesResult = null;
    private String resultTemp = null;
    private String allDeviceList = null;
    private String siteDeviceList = null;
    private String SiteDevicesresult = null;
    private String resultAddSite = null;
    private String resultAddDevice = null;
    private String  resultAddSafePerson = null;
    private String  resultAddSafePerson1 = null;
    private String  resultDeviceList  = null;
    private String specCommondList =null;
    private String deleteDeviceResult= null;
/*
    //获取site列表
    @RequestMapping(value = "/getSite", method = RequestMethod.GET)
    public String register2(@RequestParam(value="page",required=true)int page,@RequestParam(value="pageSize",required=true)int pageSize,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        this.page =page;
        this.pageSize=pageSize;
        result1 = null;
        String url1 = "http://localhost:8080/sitewhere/api/sites?includeAssignments=false&includeZones=false&page=";
        String url2 ="&pageSize=";
        String url = url1+this.page+url2+this.pageSize;
        result1 = NetworkUtils.doGetAsync(url, sitewhereToken);
        System.out.println(result1);
        return result1;
    }
    //添加site
    @RequestMapping(value = "/addSite",method = RequestMethod.POST)
    public String regist(@RequestBody AddSiteBean addSiteBean){
        String addSite=JSON.toJSONString(addSiteBean);
        resultAddSite = NetworkUtils.doPostAsync("http://localhost:8080/sitewhere/api/sites", addSite,addSiteBean.getSitewhereToken());
//        NetworkUtils.doPost("http://localhost:8080/sitewhere/api/sites", addSite, addSiteBean.getSitewhereToken(), new ResultInfoInterface() {
//            @Override
//            public void onResponse(String result) {
//                System.out.println(result);
//            }
//        });
        return JSON.toJSONString(addSiteBean);
    }
    //添加设备
    @RequestMapping(value = "/addDevice",method = RequestMethod.POST)
    public String addDevice(@RequestBody CreateDeviceBean createDeviceBean){
        String createDevice=JSON.toJSONString(createDeviceBean);
        resultAddDevice = NetworkUtils.doPostAsync("http://localhost:8080/sitewhere/api/devices", createDevice,createDeviceBean.getSitewhereToken());
//        NetworkUtils.doPost("http://localhost:8080/sitewhere/api/devices", createDevice, createDeviceBean.getSitewhereToken(), new ResultInfoInterface() {
//            @Override
//            public void onResponse(String result) {
//                System.out.println(result);
//            }
//        });
        return createDevice;
    }

    //删除设备
    @RequestMapping(value = "/deleteDevice", method = RequestMethod.GET)
    public String deleteDevice(@RequestParam(value="assignToken",required=true)String assignToken,@RequestParam(value="deviceId",required=true)String deviceId,@RequestParam(value="sitewhereToken",required=true)String sitewhereToken){
        String url = "http://localhost:8080/sitewhere/api/assignments/"+assignToken+"/end";
        NetworkUtils.doPostAsync(url, "",sitewhereToken);

        String url2 = "http://localhost:8080/sitewhere/api/devices/"+deviceId+"?force=true";
        deleteDeviceResult = NetworkUtils.doDeleteAsync(url2,sitewhereToken);

        return deleteDeviceResult;
    }




    //添加assetperson 安全管理员并建立连接

    @RequestMapping(value = "/addSafePerson",method = RequestMethod.POST)
    public String addSafePerson(@RequestBody final AddPersonBean addPersonBean){
        String addPerson=JSON.toJSONString(addPersonBean);
        String resultFinal = null;
        resultAddSafePerson = NetworkUtils.doPostAsync("http://localhost:8080/sitewhere/api/assets/categories/default-person-asset/persons", addPerson,addPersonBean.getSitewhereToken());
        AssociaPersonBean associaPersonBean = new AssociaPersonBean();
        associaPersonBean.setAssetId(addPersonBean.getId());
        associaPersonBean.setAssetModuleId("default-person-asset");
        associaPersonBean.setAssignmentType("Associated");
        associaPersonBean.setDeviceHardwareId(addPersonBean.getDeviceHardwareId());
        associaPersonBean.setMetadata(new Metadata());
        String associaPerson=JSON.toJSONString(associaPersonBean);
        resultAddSafePerson1 = NetworkUtils.doPostAsync("http://localhost:8080/sitewhere/api/assignments", associaPerson,addPersonBean.getSitewhereToken());
        return resultAddSafePerson1;

//        NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assets/categories/default-person-asset/persons", addPerson, addPersonBean.getSitewhereToken(), new ResultInfoInterface() {
//            @Override
//            public void onResponse(String result) {
//                AssociaPersonBean associaPersonBean = new AssociaPersonBean();
//                associaPersonBean.setAssetId(addPersonBean.getId());
//                associaPersonBean.setAssetModuleId("default-person-asset");
//                associaPersonBean.setAssignmentType("Associated");
//                associaPersonBean.setDeviceHardwareId(addPersonBean.getDeviceHardwareId());
//                associaPersonBean.setMetadata(new Metadata());
//                String associaPerson=JSON.toJSONString(associaPersonBean);
//                NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assignments", associaPerson, addPersonBean.getSitewhereToken(), new ResultInfoInterface() {
//                    @Override
//                    public void onResponse(String result) {
////                        System.out.println(result);
//                        result1 = result;
//
//                    }
//                });
//            }
//        });
//        while(result1 == null){
//            continue;
//        }
//        return result1;
    }
    
    */
    //查询用户的spectoken
    @RequestMapping(value = "/getSpecToken", method = RequestMethod.GET)
    public String getSpecToken(@RequestParam(value="name",required=true)String name){
    	DbDeviceManage dbDeviceManage = new DbDeviceManage();

        SpecTokensBean specTokensBean = new SpecTokensBean();
        List<SpecTokenBean> specToken = new ArrayList<SpecTokenBean>();
        List<DeviceInfoTable> deviceInfoBeans = dbDeviceManage.select(name);
        if(deviceInfoBeans.size() != 0 ){
            for(int i=0;i<deviceInfoBeans.size();i++){
                SpecTokenBean specTokenBean=new SpecTokenBean();
                specTokenBean.setLabel(deviceInfoBeans.get(i).getSpecName());
                specTokenBean.setValue(deviceInfoBeans.get(i).getSpecToken());
                specToken.add(specTokenBean);

            }
            specTokensBean.setSpecToken(specToken);

        }


        return JSON.toJSONString(specTokensBean);
    }
    @RequestMapping(value = "/insertDevice", method = RequestMethod.POST)
    public void insertDevice(@RequestParam(value="name",required=true)String name,@RequestParam(value="siteToken",required=true)String siteToken,@RequestParam(value="specToken",required=true)String specToken,@RequestParam(value="specName",required=true)String specName){
    	DbDeviceManage dbDeviceManage = new DbDeviceManage();
    	dbDeviceManage.insert(name, siteToken, specToken,  specName);
    }
    @RequestMapping(value = "/deleteDevice", method = RequestMethod.DELETE)
    public void deleteDevice(@RequestParam(value="id",required=true)long id){
    	DbDeviceManage dbDeviceManage = new DbDeviceManage();
    	dbDeviceManage.delete(id);
    }
    
    
    
/*
    //获取devicelist

/*

    @RequestMapping(value = "/getDeviceList", method = RequestMethod.GET)
    public String getDeviceList(@RequestParam(value="page",required=true)int page,@RequestParam(value="pageSize",required=true)int pageSize,@RequestParam(value="siteToken",required = true) String siteToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        this.page =page;
        this.pageSize=pageSize;
        deviceListResult = null;
        String url1 = "http://localhost:8080/sitewhere/api/sites/" +siteToken+
                "/assignments?includeDevice=true&includeAsset=true&page=";
        String url2 ="&pageSize=";
        String url = url1+this.page+url2+this.pageSize;
        resultDeviceList = NetworkUtils.doGetAsync(url, sitewhereToken);
        List<Data> dataList = new ArrayList<Data>();
        ResDeviceListBean resDeviceListBean=JSON.toJavaObject(JSON.parseObject(resultDeviceList), ResDeviceListBean.class);
        for(int i=0;i<resDeviceListBean.getResults().size();i++){
            Data data = new Data();
            ResultBean res = resDeviceListBean.getResults().get(i);
            data.setAssetName(res.getAssetName());
            if(res.getDevice()==null){
                continue;
            }
            data.setComments(res.getDevice().getComments());
            data.setHardwareId(res.getDeviceHardwareId());
            data.setName(res.getAssociatedPerson().getName());
            data.setId(res.getAssociatedPerson().getId());
            data.setEmailAddress(res.getAssociatedPerson().getEmailAddress());
            data.setLocationCity(res.getDevice().getMetadata().getLocationCity());
            data.setLocationDetial(res.getDevice().getMetadata().getLocationDetial());
            data.setCenterLatitude(res.getDevice().getMetadata().getCenterLatitude());
            data.setCenterLongitude(res.getDevice().getMetadata().getCenterLongitude());
            data.setAssignToken(res.getToken());
            dataList.add(data);
        }
        deviceList.setData(dataList);
        deviceListResult = deviceList;
        return JSON.toJSONString(deviceListResult);

//        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
//            @Override
//            public void onResponse(String result) {
//                List<Data> dataList = new ArrayList<Data>();
//                ResDeviceListBean resDeviceListBean=JSON.toJavaObject(JSON.parseObject(result), ResDeviceListBean.class);
//                for(int i=0;i<resDeviceListBean.getResults().size();i++){
//                    Data data = new Data();
//                    ResultBean res = resDeviceListBean.getResults().get(i);
//                    data.setAssetName(res.getAssetName());
//                    data.setComments(res.getDevice().getComments());
//                    data.setHardwareId(res.getDeviceHardwareId());
//                    data.setName(res.getAssociatedPerson().getName());
//                    data.setId(res.getAssociatedPerson().getId());
//                    data.setEmailAddress(res.getAssociatedPerson().getEmailAddress());
//                    data.setLocationCity(res.getDevice().getMetadata().getLocationCity());
//                    data.setLocationDetial(res.getDevice().getMetadata().getLocationDetial());
//                    data.setCenterLatitude(res.getDevice().getMetadata().getCenterLatitude());
//                    data.setCenterLongitude(res.getDevice().getMetadata().getCenterLongitude());
//                    data.setAssignToken(res.getToken());
//                    dataList.add(data);
//                }
//                deviceList.setData(dataList);
//                deviceListResult = deviceList;
//
//
//            }
//        });
//        while(deviceListResult  == null){
//            continue;
//        }
//        return JSON.toJSONString(deviceListResult);
    }
*/
  /*  //获取devicelist  筛选by sitetoken
    @RequestMapping(value = "/getSiteDevices", method = RequestMethod.GET)
    public String getSiteDevices(@RequestParam(value="siteToken",required = true) String siteToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        siteDevicesResult = null;
        String url = "http://localhost:8080/sitewhere/api/sites/" +siteToken+
                "/assignments?includeDevice=true&includeAsset=true";
        SiteDevicesresult = NetworkUtils.doGetAsync(url, sitewhereToken);
        List<Data> dataList = new ArrayList<Data>();
        ResDeviceListBean resDeviceListBean=JSON.toJavaObject(JSON.parseObject(SiteDevicesresult), ResDeviceListBean.class);
        for(int i=0;i<resDeviceListBean.getResults().size();i++){
            Data data = new Data();
            ResultBean res = resDeviceListBean.getResults().get(i);
            data.setAssetName(res.getAssetName());
            if(res.getDevice()==null){
                continue;
            }
            data.setComments(res.getDevice().getComments());
            data.setHardwareId(res.getDeviceHardwareId());
            data.setName(res.getAssociatedPerson().getName());
            data.setId(res.getAssociatedPerson().getId());
            data.setEmailAddress(res.getAssociatedPerson().getEmailAddress());
            data.setLocationCity(res.getDevice().getMetadata().getLocationCity());
            data.setLocationDetial(res.getDevice().getMetadata().getLocationDetial());
            data.setCenterLatitude(res.getDevice().getMetadata().getCenterLatitude());
            data.setCenterLongitude(res.getDevice().getMetadata().getCenterLongitude());
            data.setAssignToken(res.getToken());
            dataList.add(data);
        }
        siteDevices.setData(dataList);
        siteDevicesResult=siteDevices;
//        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
//            @Override
//            public void onResponse(String result) {
//
//
//            }
//        });
//        while(siteDevicesResult == null){
//            continue;
//        }
        return JSON.toJSONString(siteDevicesResult);
    }

*/
/*
    @RequestMapping(value = "/getAllDeviceList", method = RequestMethod.GET)
    public String getAllDeviceList(@RequestParam(value="page",required=true)int page,@RequestParam(value="pageSize",required=true)int pageSize,@RequestParam(value="siteToken",required = true) String siteToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        this.page =page;
        this.pageSize=pageSize;
        String url1 = "http://localhost:8080/sitewhere/api/devices?includeDeleted=false&excludeAssigned=false&includeSpecification=true&includeAssignment=true&page=";
        String url2 ="&pageSize=";
        String url = url1+this.page+url2+this.pageSize;
        allDeviceList = NetworkUtils.doGetAsync(url, sitewhereToken);
        return allDeviceList;
    }
*/
/*    //获取site的device
    @RequestMapping(value = "/getSiteDeviceList", method = RequestMethod.GET)
    public String getSiteDeviceList(@RequestParam(value="deleted",required=false)String deleted,@RequestParam(value="page",required=true)int page,@RequestParam(value="pageSize",required=true)int pageSize,@RequestParam(value="siteToken",required = true) String siteToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        this.page =page;
        siteDeviceList = null;
        this.pageSize=pageSize;
        String url1 = "http://localhost:8080/sitewhere/api/devices?"+"includeDeleted=false&excludeAssigned=false&includeSpecification=true&includeAssignment=true&site="+siteToken+"&page=";
        String url2 ="&pageSize=";
        String url = url1+this.page+url2+this.pageSize;
        siteDeviceList = NetworkUtils.doGetAsync(url, sitewhereToken);
        return siteDeviceList;
    }
*/
    //获取指令
/*
    @RequestMapping(value = "/getSpecCommond", method = RequestMethod.GET)
    public String getSpecCommond(@RequestParam(value="specToken",required=true)String specToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){

        String url = "http://localhost:8080/sitewhere/api/specifications/"+specToken+"/namespaces?includeDeleted=false";
        specCommondList = NetworkUtils.doGetAsync(url, sitewhereToken);
        return specCommondList;
    }
*/


/*
    @RequestMapping(value = "/getTempVal", method = RequestMethod.GET)
    public String getTempVal(@RequestParam(value="assignToken",required = true) String assignToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        String url = "http://localhost:8080/sitewhere/api/assignments/" +assignToken+
                "/measurements/series";
        resultTemp = NetworkUtils.doGetAsync(url, sitewhereToken);

//        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
//            @Override
//            public void onResponse(String result) {
//                resultTemp = result;
//                System.out.println(result);
//
//            }
//        });
//
//        while(resultTemp == null){
//            continue;
//        }
        return resultTemp;
    }
*/
}
