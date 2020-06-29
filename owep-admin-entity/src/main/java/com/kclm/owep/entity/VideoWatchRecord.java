/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: @TODO
 * @Version : v1.0
 * @Create: 2020年6月29日 上午10:10:40
 * @Description 观看绝对历史（不可删除的历史记录）
 */
public class VideoWatchRecord {//观看绝对历史（不可删除的历史记录）

    private Integer watchRecordId;//观看视频的绝对记录id
    private LocalDateTime recordStartTime;//记录开始时间
    private LocalDateTime recordEndTime;//记录结束时间
    private User user;//观看人
    private Video video;//观看的视频
    private Integer recordStartPosition;//视频开始位置
    private Integer recordEndPosition;//视频结束位置
    private int version = 1;  //版本号
    private LocalDateTime createTime = LocalDateTime.now();  //创建时间
    private LocalDateTime lastAccessTime; //最后一次访问时间
}
