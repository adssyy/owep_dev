package com.kclm.owep.mapper;

import com.kclm.owep.OwepAdminWebDaoApplication;
import com.kclm.owep.entity.OrgInstitute;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(classes = OwepAdminWebDaoApplication.class)
public class OrgInstituteMapperTest {


    @Autowired
    private  OrgInstituteMapper orgInstituteMapper;
    @Test
    public void save(){
    OrgInstitute orgInstitute = new OrgInstitute();
    orgInstitute.setInstituteName("快程乐码");
    orgInstitute.setInstituteType(123);
    this.orgInstituteMapper.save(orgInstitute);
    }
    @Test
    void findByinstituteName() {

       List<OrgInstitute> orgInstitute = orgInstituteMapper.findByinstituteName("快程乐码");
       orgInstitute.forEach(System.out::println);

    }
}