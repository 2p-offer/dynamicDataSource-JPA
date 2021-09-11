package com.erp.dynamicdatasource.controller;

import com.alibaba.fastjson.JSONObject;
import com.erp.dynamicdatasource.config.DynamicConfig;
import com.erp.dynamicdatasource.config.DynamicRoutingDataSourceContext;
import com.erp.dynamicdatasource.context.ContxtIniter;
import com.erp.dynamicdatasource.entity.ConfigDbInfo;
import com.erp.dynamicdatasource.service.DynamicServeiceImpl;
import com.erp.dynamicdatasource.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author 2p
 * @date 2021/9/8 17:20
 * @desc TestController
 */
@Controller
public class TestController {

    @Autowired
    DynamicConfig config;


    @Autowired
    DynamicServeiceImpl dynamicServeice;

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    ContxtIniter contxtIniter;

    @RequestMapping("/")
    @ResponseBody
    public String indexPage() {
        return "123";
    }

    @RequestMapping("/getconfig")
    @ResponseBody
    public String getConfigDo() {
        Map<String, ConfigDbInfo> dbInfos = config.getDbInfos();
        return JSONObject.toJSONString(dbInfos);
    }

    @RequestMapping("/getServerInfo")
    @ResponseBody
    public String getServerInfoDo() {
        return dynamicServeice.testDynamic();
    }


    @RequestMapping("/changeAndGet/{db}")
    @ResponseBody
    public String getServerInfoDo(@PathVariable(value = "db") String db) {
        String s = contxtIniter.dbInfo.get(db);
        DynamicRoutingDataSourceContext.setRoutingDataSource(s);
        return dynamicServeice.testDynamic();
    }


    @RequestMapping("/getClientAnno")
    @ResponseBody
    public String getClientAnnoDo() {
        return dynamicServeice.testMai();
    }


    @RequestMapping("/getGameAll/{db}")
    @ResponseBody
    public String getGame(@PathVariable(value = "db") String db) {

        DynamicRoutingDataSourceContext.setRoutingDataSource(db);
        String gameNameAll = gameService.getGameNameAll();
        return gameNameAll;
    }

    @RequestMapping("/getGameAll")
    @ResponseBody
    public String getGameAll() {
        String gameNameAll = gameService.getGameNameAll();
        return gameNameAll;
    }

    @RequestMapping("/getGameAll/{db}/{uid}")
    @ResponseBody
    public String getGameById(@PathVariable(value = "db") String db, @PathVariable(value = "uid") String uid) {
        String[] split = uid.split(",");
        List<Integer> ids = new ArrayList<>(split.length);
        for (String s : split) {
            ids.add(Integer.valueOf(s));
        }

        DynamicRoutingDataSourceContext.setRoutingDataSource(db);
        String gameNameAll = gameService.getGameByUid(ids);
        return gameNameAll;
    }
}
