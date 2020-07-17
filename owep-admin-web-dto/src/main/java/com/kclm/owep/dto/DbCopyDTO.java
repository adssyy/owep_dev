/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */
package com.kclm.owep.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/13 10:23
 *@Description 数据库备份DTO
 */
public class DbCopyDTO implements Serializable {

    private static final long serialVersionUTD = 1L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 备份sql文件名
     */
    private  String fileName;
    /**
     * 备份的状态，1代表成功，0代表失败
     */
    private boolean status;
    /**
     * 备份的时间
     */
    private LocalDateTime createTime =LocalDateTime.now();
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "DbCopyDTO{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
