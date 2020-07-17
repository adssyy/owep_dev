/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.dto;

import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.entity.Student;

import java.time.LocalDateTime;
import java.util.List;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/13 9:44
 * @Description 授课管理的dto
 */
public class TeachingDTO {

    /**
     * id
     */
    private Integer id;
    /***
     * 班级描述
     */
    private String classDesc;
    /***
     * 资源管理
     */
    private List<Resource> resourceList;
    private List<EvaluateDTO> evaluateDTOs;
    private List<LeaveDTO> leaveDTOs;
    private List<IllegalDTO> illegalDTOs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public List<EvaluateDTO> getEvaluateDTOs() {
        return evaluateDTOs;
    }

    public void setEvaluateDTOs(List<EvaluateDTO> evaluateDTOs) {
        this.evaluateDTOs = evaluateDTOs;
    }

    public List<LeaveDTO> getLeaveDTOs() {
        return leaveDTOs;
    }

    public void setLeaveDTOs(List<LeaveDTO> leaveDTOs) {
        this.leaveDTOs = leaveDTOs;
    }

    public List<IllegalDTO> getIllegalDTOs() {
        return illegalDTOs;
    }

    public void setIllegalDTOs(List<IllegalDTO> illegalDTOs) {
        this.illegalDTOs = illegalDTOs;
    }

    @Override
    public String toString() {
        return "TeachingDTO{" +
                "id=" + id +
                ", classDesc='" + classDesc + '\'' +
                ", resourceList=" + resourceList +
                ", evaluateDTOs=" + evaluateDTOs +
                ", leaveDTOs=" + leaveDTOs +
                ", illegalDTOs=" + illegalDTOs +
                '}';
    }

    public TeachingDTO() {
    }

    public TeachingDTO(List<EvaluateDTO> evaluateDTOs, List<LeaveDTO> leaveDTOs, List<IllegalDTO> illegalDTOs) {
        this.evaluateDTOs = evaluateDTOs;
        this.leaveDTOs = leaveDTOs;
        this.illegalDTOs = illegalDTOs;
    }
}
