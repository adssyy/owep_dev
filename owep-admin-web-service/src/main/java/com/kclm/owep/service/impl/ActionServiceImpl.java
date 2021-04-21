/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.dto.ActionDTO;
import com.kclm.owep.entity.Action;
import com.kclm.owep.mapper.ActionMapper;
import com.kclm.owep.mapper.MenuMapper;
import com.kclm.owep.service.ActionService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/15 10:45
 * @description:
 **/
@Service
public class ActionServiceImpl implements ActionService {
    private final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
    @Autowired
    private MapperFactory mapperFactory;
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public int saveOrUpdate(Action action) {
        Assert.notNull(action.getActionName(), "group对象不能为空");
        logger.debug("action:" + action.toString());
        Integer id = action.getId();
        if (id == null) {
            return actionMapper.save(action);

        } else if (id > 0) {
            return actionMapper.update(action);
        }
        return -1;
    }

    @Override
    public int deleteAction(List<Serializable> ids) {
        Assert.notNull(ids, "ids对象不能为空");
        menuMapper.deleteByActionIdInAPM(ids);
        logger.debug("ids:" + ids.size());
        if (ids.size() == 1) {
            return actionMapper.deleteById(ids.get(0));
        } else if (ids.size() > 1) {
            return actionMapper.deleteSelect(ids);
        }
        return -1;
    }

    @Override
    public ActionDTO selectById(Serializable id) {
        if (id != null) {
            Action action = actionMapper.selectById(id);
            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            ActionDTO actionDTO = mapperFacade.map(action, ActionDTO.class);
            logger.debug("actionDTO:"+actionDTO);
            return actionDTO;
        } else {
            throw new IllegalArgumentException("id值不合法");
        }
    }

    @Override
    public List<ActionDTO> selectAllAction(int pageNum) {
        if (pageNum >= 0) {
            //PageHelper.startPage(pageNum, PAGE_SIZE);
            List<Action> actions = actionMapper.selectAll();
            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            List<ActionDTO> actionDTOS = mapperFacade.mapAsList(actions, ActionDTO.class);
            logger.debug("actionDTOS:"+actionDTOS);
            return actionDTOS;
        } else {
            throw new IllegalArgumentException("pageNum值不合法");
        }

    }
}
