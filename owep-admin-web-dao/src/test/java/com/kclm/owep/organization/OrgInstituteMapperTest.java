package com.kclm.owep.organization;

import com.kclm.owep.OwepAdminWebDaoApplication;
import com.kclm.owep.entity.BranchInstitute;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.mapper.OrgInstituteMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(classes = OwepAdminWebDaoApplication.class)
public class OrgInstituteMapperTest {


    @Autowired
    private OrgInstituteMapper orgInstituteMapper;
    /***
     * 插入数据
     */
    @Test
    public void save() {
        OrgInstitute orgInstitute = new OrgInstitute();
        orgInstitute.setInstituteName("快程乐码");
        orgInstitute.setInstituteType(123);
        this.orgInstituteMapper.save(orgInstitute);
    }

    /***
     * 根据机构名称查找数据
     */
    @Test
    void findByinstituteName() {

        List<OrgInstitute> orgInstitute = orgInstituteMapper.findByinstituteName("快程乐码");
        orgInstitute.forEach(System.out::println);

    }

    /***
     * 更新数据
     */
    @Test
    public void update() {
        OrgInstitute orgInstitute = this.orgInstituteMapper.selectById(1);
        orgInstitute.setInstituteName("萍乡学院");
        orgInstitute.setInstituteType(2);
        this.orgInstituteMapper.update(orgInstitute);
    }

    /***
     * 根据id查找数据
     */
    @Test
    public void selectById() {
        OrgInstitute orgInstitute = this.orgInstituteMapper.selectById(2);
        System.out.println(orgInstitute);
    }
    @Test
    public void  deleteById(){

       this.orgInstituteMapper.deleteById(3);
    }

 }