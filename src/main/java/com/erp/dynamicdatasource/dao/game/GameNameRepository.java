package com.erp.dynamicdatasource.dao.game;

import com.erp.dynamicdatasource.entity.dync.DbInfo;
import com.erp.dynamicdatasource.entity.game.ShardingName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 2p
 * @date 2021/9/11 11:04
 * @desc GameNameRepository
 */
public interface GameNameRepository extends JpaRepository<ShardingName, Integer> {
}
