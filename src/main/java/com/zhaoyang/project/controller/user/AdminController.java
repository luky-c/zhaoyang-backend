package com.zhaoyang.project.controller.user;
import com.alibaba.fastjson.JSON;
import com.zhaoyang.project.config.GlobalCorsConfig;
import com.zhaoyang.project.database.DbAdminUserManager;
import com.zhaoyang.project.database.DbManager;
import com.zhaoyang.project.database.DbDeviceManage;
import com.zhaoyang.project.model.AdminUserBean.AdminUserBean;
import com.zhaoyang.project.model.AdminUserListBean.specToken;
import com.zhaoyang.project.model.AdminUserListBean.AdminUserListBean;
import com.zhaoyang.project.model.EditTenantBean.EditTenantBean;
import com.zhaoyang.project.model.ResAdminUserInfoBean.ResAdminUserInfoBean;
import com.zhaoyang.project.model.ResTenantUserBean.ResTenantUserBean;
import com.zhaoyang.project.network.NetworkUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping("/admin")
@Import(GlobalCorsConfig.class)
public class AdminController {
	
	/*
    private String getTenantsResult = null;
    private  String stopTenantResult = null;
    private String startTenantResult = null;
    private String exactTenantsResult = null;
    private String delTenantsResult = null;
    private String tenantAdminUsersResult = null;
    private String editTenantResult = null;
    //获取tenant list
    @RequestMapping(value = "/getTenants", method = RequestMethod.GET)
    public String getTenants(@RequestParam(value="page",required = true) String page,@RequestParam(value="pageSize",required = true) String pageSize){
        String url = "http://localhost:8080/sitewhere/api/tenants?includeRuntimeInfo=true&authUserId=admin&page="+page+"&pageSize"+pageSize;
        getTenantsResult = NetworkUtils.doGetAsync(url, "");
        return getTenantsResult;
    }

    //停用tenant
    @RequestMapping(value = "/stopTenant", method = RequestMethod.GET)
    public String stopTenant(@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){


        String url = "http://localhost:8080/sitewhere/api/tenants/"+sitewhereToken+"/engine/stop";
        stopTenantResult = NetworkUtils.doPostAsync(url, "",sitewhereToken);
        return stopTenantResult;
    }

    //启用tenant
    @RequestMapping(value = "/startTenant", method = RequestMethod.GET)
    public String startTenant(@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){

        String url = "http://localhost:8080/sitewhere/api/tenants/"+sitewhereToken+"/engine/start";
        startTenantResult = NetworkUtils.doPostAsync(url, "",sitewhereToken);
        return startTenantResult;
    }
    //精准搜索tenant
    @RequestMapping(value = "/getExactTenant", method = RequestMethod.GET)
    public String getExactTenant(@RequestParam(value="tenantId",required = true) String tenantId){
        String url = "http://localhost:8080/sitewhere/api/tenants/"+tenantId;
        exactTenantsResult = NetworkUtils.doGetAsync(url, "");
        return exactTenantsResult;
    }
    @RequestMapping(value = "/deleteTenant", method = RequestMethod.GET)
    public String deleteTenant(@RequestParam(value="tenantId",required = true) String tenantId,@RequestParam(value="name",required = true) String name){
        String url = "http://localhost:8080/sitewhere/api/tenants/"+tenantId+"?force=true";
        delTenantsResult = NetworkUtils.doDeleteAsync(url, "");
        DbManager.getInstance().init();
        DbManager.getInstance().delete(name);
        DbManager.getInstance().close();
        DbDeviceManage.getInstance().init();
        DbDeviceManage.getInstance().delete(name);
        DbDeviceManage.getInstance().close();
        return delTenantsResult;
    }


    //获取tenant的user
    @RequestMapping(value = "/getTenantAdminUsers", method = RequestMethod.GET)
    public String getTenantAdminUsers(@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        String url = "http://localhost:8080/sitewhere/api/users?includeDeleted=false";
        System.out.println(tenantAdminUsersResult);
        tenantAdminUsersResult = NetworkUtils.doGetAsync(url, "");
        System.out.println(tenantAdminUsersResult);
        ResTenantUserBean resTenantUserBean= JSON.toJavaObject(JSON.parseObject(tenantAdminUsersResult), ResTenantUserBean.class);
        AdminUserListBean adminUserListBean = new AdminUserListBean();
        List<specToken> adminUserBeans = new ArrayList<specToken>();
        for(int i=0;i<resTenantUserBean.getResults().size();i++){
            specToken adminUserBean = new specToken();
            adminUserBean.setLabel(resTenantUserBean.getResults().get(i).getUsername());
            adminUserBean.setValue(resTenantUserBean.getResults().get(i).getUsername());
            adminUserBeans.add(adminUserBean);
        }
        adminUserListBean.setSpecToken(adminUserBeans);

        System.out.println(adminUserListBean);


        return JSON.toJSONString(adminUserListBean);
    }

    @RequestMapping(value = "/editTenant",method = RequestMethod.POST)
    public String editTenant(@RequestBody EditTenantBean editTenantBean){
        String editTenant=JSON.toJSONString(editTenantBean);
        String url = "http://localhost:8080/sitewhere/api/tenants/"+editTenantBean.getId();
        editTenantResult = NetworkUtils.doPutAsync(url, editTenant,editTenantBean.getId());

        return editTenantResult;
    }
    */
}
