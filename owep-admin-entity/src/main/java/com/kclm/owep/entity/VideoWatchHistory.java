/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 视频观看历史
 */
public class VideoWatchHistory {

    private Integer historyId;//观看历史id
    private LocalDateTime watchTime;//观看时间
    private StudyRecore studyRecore;//观看进度及观看人和视频关联表
    private int version = 1;  //版本号
    private LocalDateTime createTime = LocalDateTime.now();  //创建时间
    private LocalDateTime lastAccessTime; //最后一次访问时间

}
