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
 * @date 2021-09-01
 * @desc desc
 */

@Setter
@Getter
@ToString
@Entity
@Table(name = "server_info")
public class ServerInfo implements Serializable {

    private static final long serialVersionUID = 3945686901055721157L;

    @Id
    @Column(name = "server_id")
    private Integer serverId;

    /**
     * 服务器代码版本号
     */
    @Column(name = "server_version")
    private Integer serverVersion;

    /**
     * 是否支持客户端包压缩
     */
    @Column(name = "can_compress")
    private Integer canCompress;

    @Column(name = "area_id")
    private Integer areaId;

    /**
     * 兼容最小客户端版本号(版本号*100)
     */
    @Column(name = "min_client_version")
    private Integer minClientVersion;

    /**
     * 兼容最大客户端版本号(版本号*100)
     */
    @Column(name = "max_client_version")
    private Integer maxClientVersion;

    @Column(name = "server_ip")
    private String serverIp;

    @Column(name = "server_tcp_port")
    private Integer serverTcpPort;

    @Column(name = "server_rmi_port")
    private Integer serverRmiPort;

    @Column(name = "server_http_port")
    private Integer serverHttpPort;

    /**
     * 1=域名中已经包含端口号,其他值=未包含端口(目前仅用于客户端判断是否增加port)
     */
    @Column(name = "url_contain_port")
    private Integer urlContainPort;

    @Column(name = "sftpu_name")
    private String sftpuName;

    @Column(name = "sftpu_password")
    private String sftpuPassword;

    @Column(name = "sftp_port")
    private Integer sftpPort;

    @Column(name = "log_dir_path")
    private String logDirPath;

    /**
     * 服务器类型：1 游戏服；2 战斗服；3 聊天服；4 API服；5 GM服; 6 战斗验证服
     */
    @Column(name = "server_type")
    private Integer serverType;

    /**
     * 聊天服务器id= 非游戏服务器就填0
     */
    @Column(name = "chat_id")
    private Integer chatId;

    @Column(name = "version")
    private Date version;

    /**
     * 内网IP
     */
    @Column(name = "lan_ip")
    private String lanIp;

    @Column(name = "id")
    private String id;

    /**
     * 非选服状态下0=非默认进入1=默认可进入，存在多个默认可进入时随机进入一个
     */
    @Column(name = "default_entry")
    private Integer defaultEntry;

    @Column(name = "create_date_time")
    private Date createDateTime;

    @Column(name = "deleted")
    private Integer deleted;

    @Column(name = "update_date_time")
    private Date updateDateTime;

    /**
     * gm 默认请求的Server(配置)，每个类型必须且只有一个 1。 此字段目前只有gm使用
     */
    @Column(name = "default_gm_reqeust")
    private Integer defaultGmReqeust;

    /**
     * 值为 1表示是测试服  Gm刷新服务功能开关集合的时候， 只会刷新测试服
     */
    @Column(name = "is_dev")
    private Integer isDev;

}
