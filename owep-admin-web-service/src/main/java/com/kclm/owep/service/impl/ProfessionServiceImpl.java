/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.Profession;
import com.kclm.owep.mapper.ProfessionMapper;
import com.kclm.owep.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/15 16:23
 * @version v1.0
 * @description 专业方向业务层接口
 *
 */
@Service
public class ProfessionServiceImpl implements ProfessionService {

    /***
     * 保存专业
     * @param entity
     * @return
     */
    @Override
    public int save(Profession entity) {
        return 0;
    }

    /**
     * 更新专业
     * @param entity
     * @return
     */
    @Override
    public int update(Profession entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteSelect(List<Serializable> idList) {
        return 0;
    }

    @Override
    public ProfessionDTO selectById(Serializable id) {
        return null;
    }

    @Override
    public List<ProfessionDTO> selectAll() {
        return null;
    }

    @Override
    public List<ProfessionDTO> selectByProName(String proName) {
        return null;
    }

    @Override
    public List<ProfessionDTO> selectByBranchName(String branName) {
        return null;
    }
}
