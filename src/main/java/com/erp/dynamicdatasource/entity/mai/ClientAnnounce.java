package com.erp.dynamicdatasource.entity.mai;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@ToString
@Entity
@Table(name = "client_announce")
public class ClientAnnounce implements Serializable {

    private static final long serialVersionUID = 4686456629970025399L;


    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 平台ID  0=全平台
     */
    @Column(name = "plat_id")
    private Integer platId;

    /**
     * 公告图片允许为空（,可能是url或图片名字）
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 公告标题 可选
     */
    @Column(name = "title")
    private String title;

    /**
     * 内容标题 可选
     */
    @Column(name = "content_title")
    private String contentTitle;

    /**
     * 公告内容 必填
     */
    @Column(name = "content")
    private String content;

    /**
     * 公告开始时间戳
     */
    @Column(name = "start_time")
    private Long startTime;

    /**
     * 公告结束时间戳
     */
    @Column(name = "end_time")
    private Long endTime;

    /**
     * 通告类型 1=系统公告,2=活动公告
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 是否置顶 1=置顶
     */
    @Column(name = "top")
    private Integer top;

    /**
     * 是否显示红点1=显示
     */
    @Column(name = "red_dot")
    private Integer redDot;

    /**
     * 链接类型 1=http链接2=游戏内链接
     */
    @Column(name = "img_link_type")
    private Integer imgLinkType;

    /**
     * 图片链接
     */
    @Column(name = "img_link")
    private String imgLink;

    @Column(name = "version")
    @Transient
    private Date version = new Date();

    @Transient
    private String startTimeData;

    @Transient
    private String endTimeData;

}

