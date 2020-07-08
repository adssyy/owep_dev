package com.kclm.owep.mapper.system;

import com.kclm.owep.OwepAdminWebDaoApplication;
import com.kclm.owep.entity.DbCopy;
import com.kclm.owep.entity.SystLog;
import com.kclm.owep.mapper.DbCopyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = OwepAdminWebDaoApplication.class)
class DbCopyMapperTest {

    @Autowired
    private DbCopyMapper dbCopyMapper;

    @Test
    public void save(){
        DbCopy dbCopy=new DbCopy();

        dbCopy.setCreateTime(LocalDateTime.now());
        dbCopy.setFileName("katong");
        dbCopy.setFilePath("hello/hello");
        dbCopy.setLastAccessTime(LocalDateTime.now());
        dbCopy.setStatus(true);
        dbCopy.setVersion(1);
        this.dbCopyMapper.save(dbCopy);
        System.out.println(dbCopyMapper);
        System.out.println(dbCopy);
    }

    @Test
    public void update(){
        DbCopy dbCopy=new DbCopy();
        dbCopy.setId(4);
        dbCopy.setFileName("update2");
        dbCopy.setVersion(1);
        dbCopy.setStatus(true);
        dbCopy.setCreateTime(LocalDateTime.now());
        this.dbCopyMapper.update(dbCopy);
        System.out.println(dbCopy);

    }
    @Test
    public void deleteById(){
        DbCopy dbCopy=new DbCopy();
        dbCopy.setId(3);
        this.dbCopyMapper.deleteById(dbCopy);

    }

    @Test
    public void deleteSelect(){

        //dbCopyMapper.deleteSelect();
    }

    @Test
    public void selectById(){
        System.out.println("DbCopyMapper"+dbCopyMapper);
        final DbCopy dbCopy=this.dbCopyMapper.selectById(1);
        System.out.println(dbCopy);

    }

    @Test
    public void SelectAll(){
        final List<DbCopy> all=dbCopyMapper.selectAll();
        //
        if (all != null){
            all.forEach(System.out::println);
        }
    }
    @Test
    void findByTime(){
        LocalDateTime start= LocalDateTime.of(2018,1,13,9,43,46);
        LocalDateTime end=LocalDateTime.now();
        this.dbCopyMapper.findByTime(start,end);

    }
}