package com.erp.dynamicdatasource.dao.dync;

import com.erp.dynamicdatasource.entity.dync.ServerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 2p
 * @date 2021/9/8 17:48
 * @desc ServerInfoRepository
 */
public interface ServerInfoRepository  extends JpaRepository<ServerInfo,Integer> {
}
