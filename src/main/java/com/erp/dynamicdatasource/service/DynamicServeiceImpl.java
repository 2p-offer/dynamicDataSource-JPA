package com.erp.dynamicdatasource.service;

import com.alibaba.fastjson.JSONObject;
import com.erp.dynamicdatasource.dao.dync.ServerInfoRepository;
import com.erp.dynamicdatasource.dao.mai.ClientAnnounceRepository;
import com.erp.dynamicdatasource.entity.dync.ServerInfo;
import com.erp.dynamicdatasource.entity.mai.ClientAnnounce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 2p
 * @date 2021/9/8 17:50
 * @desc DynamicServeiceImpl
 */
@Service
public class DynamicServeiceImpl {

    @Autowired
    private ServerInfoRepository serverInfoRepository;

    @Autowired
    private ClientAnnounceRepository clientAnnounceRepository;

    public String testDynamic() {
        List<ServerInfo> all = serverInfoRepository.findAll();
        String s = JSONObject.toJSONString(all);

        System.out.println("testDynamic>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + s);
        return s;
    }


    public String testMai() {
        List<ClientAnnounce> all = clientAnnounceRepository.findAll();

        String s = JSONObject.toJSONString(all);

        System.out.println("testMai>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + s);
        return s;
    }
}
