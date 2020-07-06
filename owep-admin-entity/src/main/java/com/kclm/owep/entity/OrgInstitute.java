package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/*******
 * @Author yangwr
 * @Version v1.0
 * @Create 2020/7/6 16:34
 * @Description 组织机构实体类
 */
public class OrgInstitute implements Serializable {

    private static final long serialVersionUID = 1L;

    /***
     * 组织机构id
     */
    private Integer id;
    /***
     * 机构名称
     */
    private String instituteName;
    /***
     *机构类型
     */
    private Integer instituteType;
    /***
     *是否逻辑删除，1表示未删除，0表示已删除
     */
    private Integer delete;
    /***
     *版本
     */
    private Integer version;
    /***
     *创建时间
     */
    private LocalDateTime createTime;
    /***
     *最后访问时间
     */
    private LocalDateTime lastAccessTime;

    /***
     *get,set方法
     */
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName == null ? null : instituteName.trim();
    }

    public Integer getInstituteType() {
        return instituteType;
    }

    public void setInstituteType(Integer instituteType) {
        this.instituteType = instituteType;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }


    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
}