/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ClientQuantityDTO;
import com.kclm.owep.dto.CustomerSourceDTO;
import com.kclm.owep.dto.ResultSummaryDTO;
import com.kclm.owep.mapper.ClientMapper;
import com.kclm.owep.service.DataReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/14 16:41
 *@Description TODO
 *
 */
@Service
public class DataReportServiceImpl implements DataReportService {

    @Autowired
    ClientMapper clientMapper;



    @Override
    public ResultSummaryDTO getResultsSummary(LocalDate localDate) {
        return null;
    }

    @Override
    public CustomerSourceDTO getCustomerSource(LocalDate localDate) {
        return null;
    }

    @Override
    public ClientQuantityDTO getClientQuantity(LocalDate localDate) {
        return null;
    }
}
