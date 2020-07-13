package com.kclm.owep.organization;

import com.kclm.owep.OwepAdminWebDaoApplication;
import com.kclm.owep.entity.BranchInstitute;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.mapper.BranchInstituteMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = OwepAdminWebDaoApplication.class)
class BranchInstituteMapperTest {
    @Autowired
    private BranchInstituteMapper branchInstituteMapper;

    /************
     * 插入数据
     */
    @Test
    public void save() {
        BranchInstitute branchInstitute = new BranchInstitute();
        branchInstitute.setBranchName("培训机构");
        OrgInstitute orgInstitute = new OrgInstitute();
        orgInstitute.setId(1);
        branchInstitute.setOrgInstitute(orgInstitute);
        this.branchInstituteMapper.save(branchInstitute);
    }

    /***
     * 根据分支名称来查询
     */
    @Test
    void findByBranchName() {
        final List<BranchInstitute> branchInstitute = this.branchInstituteMapper.findByBranchName("培训机构");
        System.out.println(branchInstitute);
    }

    /***
     * 查询所有数据
     */
    @Test
    public void selectAll() {
        final List<BranchInstitute> All = this.branchInstituteMapper.selectAll();
        All.forEach(System.out::println);
    }

    /***
     * 更新数据
     */
    @Test
    public void update() {
        BranchInstitute branchInstitute = this.branchInstituteMapper.selectById(1);
        branchInstitute.setBranchName("学校");
        OrgInstitute orgInstitute = new OrgInstitute();
        orgInstitute.setId(2);
        branchInstitute.setOrgInstitute(orgInstitute);
        this.branchInstituteMapper.update(branchInstitute);
    }

    /***
     * 根据id来查询
     */
    @Test
    public void selectById() {
        BranchInstitute branchInstitute = this.branchInstituteMapper.selectById(2);
        System.out.println(branchInstitute);
    }
    @Test
    public void deleteByid(){
        this.branchInstituteMapper.deleteById(1);
    }
}