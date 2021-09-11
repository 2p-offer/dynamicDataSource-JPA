package com.erp.dynamicdatasource.dao.dync;

import com.erp.dynamicdatasource.entity.dync.DbInfo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author 2p
 * @date 2021/9/10 14:33
 * @desc GsServerInfoRepository
 */
public interface GsDbInfoRepository extends JpaRepository<DbInfo, Integer> {

}
