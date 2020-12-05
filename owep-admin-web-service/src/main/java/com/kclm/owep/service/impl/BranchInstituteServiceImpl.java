/*******
 * 2018-2021版权所有 CopyRight(c) 快程乐码信息有限公司 未经授权，不得随意使用！ 
 */
package com.kclm.owep.service.impl;

import com.kclm.owep.convert.BranchInstituteConvert;
import com.kclm.owep.dto.BranchInstituteDTO;
import com.kclm.owep.entity.BranchInstitute;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.mapper.BranchInstituteMapper;
import com.kclm.owep.mapper.OrgInstituteMapper;
import com.kclm.owep.service.BranchInstituteService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*******
 * @Author yangwr
 * @Version v1.0
 * @Create 2020/7/15 14:44
 * @Description TODO
 */
@Service
public class BranchInstituteServiceImpl implements BranchInstituteService {

    @Autowired
    private OrgInstituteMapper orgInstituteMapper;

    @Autowired
    private BranchInstituteMapper branchInstituteMapper;

    @Autowired
    private MapperFactory mapperFactory;

    /***
     * 查询所有的数据
     * @return
     */
    @Override
    public List<BranchInstituteDTO> findAllBranch() {
        List<BranchInstitute> branchInstitutes = this.branchInstituteMapper.selectAll();
        List<BranchInstituteDTO> branchInstituteDTOS = new ArrayList<>();

        for (BranchInstitute branchInstitute:branchInstitutes){
            branchInstituteDTOS.add(BranchInstituteConvert.INSTSNCE.entityToDTO(branchInstitute));
        }
        return branchInstituteDTOS;
    }

    /***
     * 根据分支名称和所属机构自定义查询
     * @param branchName
     * @param orgInstitute
     * @return
     */
    @Override
    public List<BranchInstituteDTO> findBranchInstituteByNameAndInstitute(String branchName, String orgInstitute) {

        return null;
    }

    /***
     * 添加分支机构
     * @param branchInstitute
     * @return
     */
    @Override
    public int addBranchInstitute(BranchInstitute branchInstitute) {
        return 0;
    }

    /***
     * 根据id删除所选择的资源
     * @param branchIds
     * @return
     */
    @Override
    public int deleteSelectBranchInstitute(List<Serializable> branchIds) {
        return branchInstituteMapper.deleteSelect(branchIds);
    }

    /**
     * 添加分支机构
     * @param branchInstitute
     * @return
     */
    @Override
    public int updateBranchInst(BranchInstitute branchInstitute) {
        return branchInstituteMapper.update(branchInstitute);
    }

    /***
     * 根据id删除资源
     * @param branchId
     * @return
     */
    @Override
    public int deleteBranchInstituteById(Serializable branchId) {
        return branchInstituteMapper.deleteById(branchId);
    }

    /****
     * 根据所属机构查询
     * @param orgInstitute
     * @return
     */
    public List<BranchInstituteDTO> findByInstitute(OrgInstitute orgInstitute){
        BranchInstitute branchInstitute = new BranchInstitute();
        branchInstitute.setOrgInstitute(orgInstitute);
        List<BranchInstitute> byBranchNameAndinstitute = branchInstituteMapper.findByBranchNameAndinstitute(branchInstitute);
        List<BranchInstituteDTO> branchInstituteDTOS = new ArrayList<>();
        for (BranchInstitute entity:byBranchNameAndinstitute){
            branchInstituteDTOS.add(BranchInstituteConvert.INSTSNCE.entityToDTO(entity));
        }

        return branchInstituteDTOS;
    }
}
