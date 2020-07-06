package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/*******
 * @Author yangwr
 * @Version v1.0
 * @Create 2020/7/6 16:34
 * @Description 分支机构实体类
 */
public class BranchInstitute implements Serializable {

    private static final long serialVersionUID = 1L;

    /***
     * 分支机构id
     */
    private Integer id;
    /***
     *分支名称
     */
    private String branchName;
    /***
     *组织机构id（外键）
     */
    private List<OrgInstitute> fkOrgId;
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
     * get,set 方法
     * @return
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<OrgInstitute> getFkOrgId() {
        return fkOrgId;
    }

    public void setFkOrgId(List<OrgInstitute> fkOrgId) {
        this.fkOrgId = fkOrgId;
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