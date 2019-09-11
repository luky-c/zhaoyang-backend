package com.zhaoyang.project.controller.device;
import com.alibaba.fastjson.JSON;
import com.zhaoyang.project.config.GlobalCorsConfig;
import com.zhaoyang.project.model.CommondBean.CommondBean;
import com.zhaoyang.project.model.UpdateDeletedBean;
import com.zhaoyang.project.network.NetworkUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.zhaoyang.project.model.TenantConf.TenantConfBean;

@ComponentScan
@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping("/eventSource")
@Import(GlobalCorsConfig.class)

public class EventSourceController {
    private String tenantConfJsonDetail = null;
    private String eventJsonDetail = null;
    private  String commondDetail = null;
    private String token = null;
    private String updateDeletedResult  = null;
    private String assignTokenResult =null;

    //获取tenant com.zhaoyang.project.config Detail
    @RequestMapping(value = "/getTenantConfJson", method = RequestMethod.GET)
    public String getTenantConfJson(@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){

        String url = "http://localhost:8080/sitewhere/api/tenants/"+sitewhereToken+"/engine/com.zhaoyang.project.configuration/json";
        tenantConfJsonDetail = NetworkUtils.doGetAsync(url, "");

        return tenantConfJsonDetail;
    }

    @RequestMapping(value = "/getSitewhereToken", method = RequestMethod.GET)
    public String getSitewhereToken(@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        token=sitewhereToken;

        return token;
    }


    // 添加配置
    @RequestMapping(value = "/postEventSource",method = RequestMethod.POST)
    public String postEventSource(@RequestBody TenantConfBean tenantConfBean){
        String tenantConf=JSON.toJSONString(tenantConfBean);
        String url1 = "http://localhost:8080/sitewhere/api/tenants/"+token+"/engine/com.zhaoyang.project.configuration/json";
        String url2 = "http://localhost:8080/sitewhere/api/tenants/"+token+"/engine/reboot";


        String url11 = "http://localhost:8080/sitewhere/api/tenants/stomp1/engine/com.zhaoyang.project.configuration/json";
        String url22 = "http://localhost:8080/sitewhere/api/tenants/stomp1/engine/reboot";
        eventJsonDetail = NetworkUtils.doPostAsync(url1, tenantConf,token);
        eventJsonDetail = NetworkUtils.doPostAsync(url2, "",token);

        System.out.println(eventJsonDetail);
        System.out.println(tenantConf);
        token = null;
        return eventJsonDetail;
    }


   //停用设备接口

    @RequestMapping(value = "/postStopCommond",method = RequestMethod.POST)
    public String postStopCommond(@RequestBody CommondBean commondBean){
        String commond=JSON.toJSONString(commondBean);
        String url = "http://localhost:8080/sitewhere/api/assignments/"+commondBean.getAssignToken()+"/invocations";
        commondDetail = NetworkUtils.doPostAsync(url, commond,commondBean.getSitewhereToken());

        String url2 = "http://localhost:8080/sitewhere/api/devices/"+commondBean.getHardwareId();
        UpdateDeletedBean updateDeletedBean = new UpdateDeletedBean();
        updateDeletedBean.setComments("已停用");
        String updateDeleted=JSON.toJSONString(updateDeletedBean);
        updateDeletedResult = NetworkUtils.doPutAsync(url2, updateDeleted,commondBean.getSitewhereToken());

        return commondDetail;
    }

   //启用设备
    @RequestMapping(value = "/postStartCommond",method = RequestMethod.POST)
    public String postStartCommond(@RequestBody CommondBean commondBean){
        String commond=JSON.toJSONString(commondBean);
        String url = "http://localhost:8080/sitewhere/api/assignments/"+commondBean.getAssignToken()+"/invocations";
        commondDetail = NetworkUtils.doPostAsync(url, commond,commondBean.getSitewhereToken());

        String url2 = "http://localhost:8080/sitewhere/api/devices/"+commondBean.getHardwareId();
        UpdateDeletedBean updateDeletedBean = new UpdateDeletedBean();
        updateDeletedBean.setComments("运行中");
        String updateDeleted=JSON.toJSONString(updateDeletedBean);
        updateDeletedResult = NetworkUtils.doPutAsync(url2, updateDeleted,commondBean.getSitewhereToken());

        return commondDetail;
    }


    @RequestMapping(value = "/getAssignToken", method = RequestMethod.GET)
    public String getAssignToken(@RequestParam(value="hardwareId",required = true) String hardwareId,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){

        String url = "http://localhost:8080/sitewhere/api/devices/"+hardwareId+"/assignment";
        assignTokenResult = NetworkUtils.doGetAsync(url, sitewhereToken);

        return assignTokenResult;
    }






}
