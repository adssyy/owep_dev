/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.Profession;
import com.kclm.owep.entity.Resource;

import java.time.LocalDate;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/13 10:34
 * @version v1.0
 * @description 班级dto
 *
 */
public class ClazzDTO{
    /***
     * id
     */
    private Integer id;
    /***
     * 班级编号
     */
    private String classNumber;
    /***
     * 班级名称
     */
    private String className;
    /***
     * 专业管理
     */
    private Profession profession;
    /***
     * 开班时间
     */
    private LocalDate startTime;

    /***
     * 结束时间
     */
    private LocalDate endTime;

    /***
     * 启用状态（1：启用 0：未启用）
     */
    private Integer classStatus;

    /***
     * 所属机构
     */
    private String instituteName;

    /***
     * 所属分支
     */
    private String branchName;

    /***
     * 班级描述
     */
    private String classDesc;
    /***
     * 老师名
     */
    private String teacherName;
    /***
     * 资源管理
     */
    private List<Resource> resourceList;

    /***
     * 方案
     */
    private List<PlanManager> planManagerList;

}
