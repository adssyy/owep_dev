/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description videoQuesApprove
 */
public class VideoQuesApprove {

    private Integer approveId;//问题点赞id
    private VideoQuestion videoQuestion;//问题
    private User approveUser;//点赞人
    private LocalDateTime createTime;//点赞时间
    private int version = 1;  //版本号
    private LocalDateTime lastAccessTime; //最后一次访问时间
}
