/*******
 * 2018-2021版权所有 CopyRight(c) 快程乐码信息有限公司 未经授权，不得随意使用！ 
 */
package com.kclm.owep.service.impl;

import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.mapper.BranchInstituteMapper;
import com.kclm.owep.mapper.OrgInstituteMapper;
import com.kclm.owep.service.OrgInstituteService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/*******
 * @Author yangwr
 * @Version v1.0
 * @Create 2020/7/15 14:18
 * @Description 机构列表业务层接口
 */
@Service
public class OrgInstituteServiceImpl implements OrgInstituteService {

    @Autowired
    private OrgInstituteMapper orgInstituteMapper;

    @Autowired
    private BranchInstituteMapper branchInstituteMapper;

    @Autowired
    private MapperFactory mapperFactory;

    /***
     * 查找所有的机构
     * @return
     */
    @Override
    public List<OrgInstituteDTO> findAllinstitute() {
        List<OrgInstitute> orgInstituteList = orgInstituteMapper.selectAll();
        MapperFacade mapperFacade = this.mapperFactory.getMapperFacade();
        List<OrgInstituteDTO> orgInstituteDTOS = mapperFacade.mapAsList(orgInstituteList, OrgInstituteDTO.class);
        return orgInstituteDTOS;
    }

    /***
     * 根据机构名和机构类型自定义查找
     * @param instituteName
     * @param instituteType
     * @return
     */
    @Override
    public List<OrgInstituteDTO> findOrgInstituteByNameAndType(String instituteName, String instituteType) {

        return null;
    }

    /***
     * 添加机构列表
     * @param orgInstitute
     * @return
     */
    @Override
    public int addOrgInstitute(OrgInstitute orgInstitute) {
        return 0;
    }

    /***
     * 根据选择的id删除资源
     * @param instituteIds
     * @return
     */
    @Override
    public int deleteSelectOrgInstitute(List<Serializable> instituteIds) {
        return orgInstituteMapper.deleteSelect(instituteIds);
    }

    /***
     * 修改机构列表
     * @param orgInstitute
     * @return
     */
    @Override
    public int updateOrgInstitute(OrgInstitute orgInstitute) {
        return orgInstituteMapper.update(orgInstitute);
    }

    /***
     * 根据id删除资源
     * @param instituteId
     * @return
     */
    @Override
    public int deleteOrgInstituteById(Serializable instituteId) {
        return orgInstituteMapper.deleteById(instituteId);
    }


}
