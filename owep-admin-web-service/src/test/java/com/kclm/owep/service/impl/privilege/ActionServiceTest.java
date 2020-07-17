package com.kclm.owep.service.impl.privilege;

import com.kclm.owep.dto.ActionDTO;
import com.kclm.owep.entity.Action;
import com.kclm.owep.service.ActionService;
import com.kclm.owep.service.impl.SysStatisticsServiceImplTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @program: owep
 * @package: com.kclm.owep.service.impl.privilege
 * @description:
 * @author: qi_kran
 * @create: 2020-07-17 09:58
 **/
class ActionServiceTest extends SysStatisticsServiceImplTest {
    @Autowired
    private ActionService actionService;

    @Test
    void saveOrUpdate() {
        Action action = new Action("asd", "asd", "aaa", "11", 11);
        action.setId(16);
        actionService.saveOrUpdate(action);

    }

    @Test
    void deleteAction() {
        actionService.deleteAction(Arrays.asList(15));
    }

    @Test
    void selectById() {
        ActionDTO actionDTO = actionService.selectById(7);
        System.out.println(actionDTO);
    }

    @Test
    void selectAllAction() {
        List<ActionDTO> actionDTOS = actionService.selectAllAction(0);
        actionDTOS.forEach(System.out::println);
    }
}