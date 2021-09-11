package com.erp.dynamicdatasource.service;

import com.alibaba.fastjson.JSONObject;
import com.erp.dynamicdatasource.dao.game.GameNameRepository;
import com.erp.dynamicdatasource.entity.game.ShardingName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 2p
 * @date 2021/9/11 11:10
 * @desc GameServiceImpl
 */
@Service
public class GameServiceImpl {

    @Autowired
    private GameNameRepository gameNameRepository;

    public String getGameNameAll() {
        List<ShardingName> all = gameNameRepository.findAll();
        String s = JSONObject.toJSONString(all);
        System.out.println("GameServiceImpl>>           ++ " + s);
        return s;
    }


    public String getGameByUid(List<Integer> ids) {
        List<ShardingName> all = gameNameRepository.findAllById(ids);
        String s = JSONObject.toJSONString(all);
        System.out.println("GameServiceImpl>>           ++ " + s);
        return s;
    }
}
