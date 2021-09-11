package com.erp.dynamicdatasource.entity.dync;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 2p
 * @date 2021-09-07
 * @desc desc
 */

@Setter
@Getter
@ToString
@Entity
@Table(name = "db_info")
public class DbInfo implements Serializable {

    private static final long serialVersionUID = 4394234526444437113L;


    /**
     * DBId
     */
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "write_host")
    private String writeHost;

    @Column(name = "write_port")
    private Integer writePort;

    /**
     * 数据库IP
     */
    @Column(name = "read_host")
    private String readHost;

    @Column(name = "read_port")
    private Integer readPort;

    /**
     * API服编号，0表示不读取
     */
    @Column(name = "entry_id")
    private Integer entryId;

    /**
     * 日志数据库信息id
     */
    @Column(name = "log_id")
    private Integer logId;

    /**
     * 聊天数据库信息id
     */
    @Column(name = "chat_id")
    private Integer chatId;

    /**
     * 数据库名
     */
    @Column(name = "game_db_name")
    private String gameDbName;

    /**
     * 数据库用户名
     */
    @Column(name = "write_user_name")
    private String writeUserName;

    /**
     * 数据库密码
     */
    @Column(name = "write_user_pwd")
    private String writeUserPwd;

    @Column(name = "read_user_name")
    private String readUserName;

    @Column(name = "read_user_pwd")
    private String readUserPwd;

    @Column(name = "version")
    private Date version;

    @Column(name = "enabled")
    private Integer enabled;

    /**
     * 验证中心是否会读本库
     */
    @Column(name = "distribute_isread")
    private Integer distributeIsread;

    /**
     * 聊天举报功能是否读本库
     */
    @Column(name = "chatreport_isread")
    private Integer chatreportIsread;


}
