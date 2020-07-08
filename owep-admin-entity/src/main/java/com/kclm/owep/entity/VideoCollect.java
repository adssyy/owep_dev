/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.entity;

import java.util.Date;

/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 视频观看历史
 */

public class VideoCollect {

    private Integer id;


    private Integer fkStudentId;


    private Integer fkSectionId;


    private Integer fkVideoId;


    private String courseName;


    private String chapterName;


    private String sectionName;


    private Date createTime;


    private Date lastAccessTime;


    private Integer version;



}