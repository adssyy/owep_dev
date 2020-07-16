/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.service;

import com.kclm.owep.dto.ClientQuantityDTO;
import com.kclm.owep.dto.CustomerSourceDTO;
import com.kclm.owep.dto.ResultSummaryDTO;

import java.time.LocalDate;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 13:59
 *@Description 数据报表业务接口
 *
 */
public interface DataReportService {


    /**
     * 通过年月      查询当月的业绩汇总情况
     * @param localDate
     * @return
     */
    ResultSummaryDTO getResultsSummary(LocalDate localDate);


    /**
     * 通过年月     查询当月的客户来源情况
     * @param localDate
     * @return
     */
    CustomerSourceDTO getCustomerSource(LocalDate localDate);

    /**
     * 通过年月     查询当月的客户情况
     * @param localDate
     * @return
     */
    ClientQuantityDTO getClientQuantity(LocalDate localDate);
}
