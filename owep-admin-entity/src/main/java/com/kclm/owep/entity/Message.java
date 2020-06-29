/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;


import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description message
 */
public class Message implements java.io.Serializable {


    private Integer msgId;//私信id

    private User fromUser;//发送者

    private User toUser;//接受者

    private String msgTitle;//私信标题

    private String msgContent;//私信内容

    private LocalDateTime sendTime; //发送时间

    private Integer isRead;//是否已读,1:已读、2：未读

    private int version = 1;  //版本号
    private LocalDateTime createTime = LocalDateTime.now();  //创建时间
    private LocalDateTime lastAccessTime; //最后一次访问时间


}
