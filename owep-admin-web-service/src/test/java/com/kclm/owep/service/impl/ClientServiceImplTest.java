package com.kclm.owep.service.impl;

import com.kclm.owep.OwepAdminServiceApplication;
import com.kclm.owep.dto.ClientDTO;
import com.kclm.owep.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OwepAdminServiceApplication.class)
class ClientServiceImplTest {

    @Autowired
    ClientServiceImpl clientService;

    /**
     * 通过客户属性查询客户
     */
    @Test
    void findClientByField() {
        Client client = new Client();
        client.setClientState(1);
        List<ClientDTO> clientByField = clientService.findClientByField(client);
        clientByField.forEach(System.out::println);
    }

    /**
     * 查询所有客户
     */
    @Test
    void findAllClient() {
        List<ClientDTO> allClient = clientService.findAllClient();
        allClient.forEach(System.out::println);
    }

    /**
     * 分页查询所有客户
     */
    @Test
    void findAllByPaging() {
        List<ClientDTO> allByPaging = clientService.findAllByPaging(1, 2);
        allByPaging.forEach(System.out::println);
    }

    /**
     * 测试添加客户
     */
    @Test
    void addClient() {
        Client client = new Client();
        client.setClientState(1);
        client.setGender(1);
        client.setClientName("章一封");
        client.setClientPhone("18807031363");
        User user = new User();
        user.setId(1);
        client.setUser(user);
        client.setClientEmail("1210736891@qq.com");
        /*添加客户时 默认未贷款*/
      //  client.setLoanStatus(1);
        client.setMajor("软件技术");
        Profession profession = new Profession();
        profession.setId(1);
        client.setProfession(profession);
        Channel channel = new Channel();
        channel.setId(1);
        client.setChannel(channel);
        clientService.addClient(client);
    }

    @Test
    void assigningClient() {
        List<Serializable> integers = Arrays.asList(1, 2, 4);
        clientService.assigningClient(integers,"打王者没有时间",2,1);
    }

    @Test
    void deleteClientByIds() {
        List<Serializable> integers = Arrays.asList(1);
        clientService.deleteClientByIds(integers);
    }

    @Test
    void deleteClientById() {
        clientService.deleteClientById(2);
    }

    @Test
    void signClient() {
        Client client = new Client();
        client.setId(5);
        client.setLoanStatus(1);
        client.setLoan(30000d);
        client.setPayMent(5000);
        client.setTotalPay(30000d);
        client.setAdvancePay(111d);
        client.setMonthPay(200d);
        client.setSignTime(LocalDateTime.now());
        client.setClientState(2);
        clientService.signClient(client);
    }

    @Test
    void alterClient() {
        Client client = new Client();
        client.setId(5);
        client.setClientName("张山丰");
        client.setClientPhone("18812345655");
        client.setAdvancePay(3000d);
        client.setGender(1);
        client.setClientExperience("你为何如此优秀");
        client.setSalsemanDescribe("此人很优秀");
        client.setTotalPay(30000d);
        client.setMonthPay(6000d);
        client.setPayMent(6000);
        client.setIsAssignClass(1);
        client.setClientEmail("413127846@qq.com");
        client.setClientState(1);
        client.setLoan(30000d);
        client.setLoanStatus(1);
        client.setInterviewTimeStart(LocalDateTime.now());
        client.setInterviewTimeEnd(LocalDateTime.of(2022,9,11,9,11));
        client.setClientState(2);
        Profession profession = new Profession();
        profession.setId(1);
        client.setProfession(profession);
        client.setMajor("软件技术");
        client.setSignTime(LocalDateTime.now());
        client.setIsDelete(1);
        Channel channel = new Channel();
        channel.setId(1);
        client.setChannel(channel);
        client.setLastAccessTime(LocalDateTime.now());
        User user = new User();
        user.setId(1);
        client.setUser(user);
        clientService.alterClient(client);
    }

    @Test
    void sendEmailClient() {

        //TODO


    }

    @Test
    void addClientNote() {
        ClientNote clientNote = new ClientNote();
        clientNote.setClientState(1);
        Client client = new Client();
        client.setId(1);
        clientNote.setClient(client);
        clientNote.setClientNote("意向客户");
        clientService.addClientNote(clientNote);

    }
}