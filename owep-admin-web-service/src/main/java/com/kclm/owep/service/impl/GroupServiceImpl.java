/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.dto.GroupDTO;
import com.kclm.owep.dto.GroupRoleDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Role;
import com.kclm.owep.mapper.GroupMapper;
import com.kclm.owep.mapper.RoleMapper;
import com.kclm.owep.service.GroupService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/14 10:36
 * @description:
 **/
@Service
public class GroupServiceImpl implements GroupService {
    private final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
    @Resource
//    @Autowired
    private GroupMapper groupMapper;
    @Resource
//    @Autowired
    private RoleMapper roleMapper;
    @Resource
//    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public int saveOrUpdate(Group group) {
        Assert.notNull(group.getGroupName(), "group对象不能为空");
        logger.debug("group:" + group.toString());
        Integer id = group.getId();
        if (id == null) {
            return groupMapper.save(group);

        } else if (id > 0) {
            return groupMapper.update(group);
        }
        return -1;
    }

    @Override
    public int deleteGroup(List<Serializable> ids) {
        Assert.notNull(ids, "ids对象不能为空");
        groupMapper.deleteByGroupIdInGR(ids);
        logger.debug("ids:" + ids.size());
        if (ids.size() == 1) {
            return groupMapper.deleteById(ids.get(0));
        } else if (ids.size() > 1) {

            return groupMapper.deleteSelect(ids);
        }
        return -1;
    }

    @Override
    public List<GroupDTO> selectByName(String name) {
        Assert.notNull(name, "name为空");
        List<Group> groups = groupMapper.selectByGroupName(name);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<GroupDTO> groupDTOS = mapperFacade.mapAsList(groups, GroupDTO.class);
        logger.debug("groupDTOS:" + groupDTOS);
        return groupDTOS;
    }

    @Override
    public GroupDTO selectById(Serializable id) {
        if (id != null) {
            Group group = groupMapper.selectById(id);
            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            GroupDTO groupDTO = mapperFacade.map(group, GroupDTO.class);
            logger.debug("groupDTO:" + groupDTO);
            return groupDTO;
        } else {
            throw new IllegalArgumentException("id值不合法");
        }

    }

    @Override
    public List<GroupDTO> selectAllGroups(int pageNum) {
        if (pageNum >= 0) {
            PageHelper.startPage(pageNum, PAGE_SIZE);
            List<Group> groups = groupMapper.selectAll();
            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            List<GroupDTO> groupDTOS = mapperFacade.mapAsList(groups, GroupDTO.class);
            logger.debug("groupDTOS:" + groupDTOS);
            return groupDTOS;
        } else {
            throw new IllegalArgumentException("pageNum值不合法");
        }

    }



    @Override
    public GroupRoleDTO selectRolesByGroupId(Serializable groupId) {
        if (groupId != null) {
            System.out.println("========================>"+groupMapper);
            List<Group> groups = groupMapper.selectRolesByGroupId(groupId);
            Group group = groups.get(0);
            mapperFactory.classMap(Group.class, GroupRoleDTO.class)
                    .field("id", "groupId")
                    .field("roles{id}", "roleIds{}")
                    .register();
            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            GroupRoleDTO groupRoleDTO = mapperFacade.map(group, GroupRoleDTO.class);
//            GroupRoleDTO groupRoleDTO = new GroupRoleDTO();
//            groupRoleDTO.setGroupId(group.getId());
//            List<Integer> roleIds = new ArrayList<>();
//            for(Role r : group.getRoles()) {
//                roleIds.add(r.getId());
//            }
//            groupRoleDTO.setRoleIds(roleIds);

            logger.debug("groupRoleDTO:" + groupRoleDTO);
            return groupRoleDTO;
        } else throw new IllegalArgumentException("groupId值不合法");
    }

    @Override
    public int assignRoleToGroup(Map<Integer, List<Integer>> map) {
        Assert.notNull(map, "map对象不能为空");
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        try {
            for (Map.Entry<Integer, List<Integer>> next : entries) {
                Integer key = next.getKey();
                List<Integer> value = next.getValue();
                groupMapper.deleteByGroupIdInGR(Arrays.asList(key));
                logger.debug("key:" + key + "_value:" + value);
                value.forEach(e -> groupMapper.assignRoleToGroup(key, e));
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        }
    }

    @Override
    public NodeDTO selectAllRoles() {
        mapperFactory.classMap(Role.class, NodeDTO.class)
                .field("roleName", "text")
                .field("id", "tags").register();
        List<Role> roles = roleMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<NodeDTO> nodeDTOS = mapperFacade.mapAsList(roles, NodeDTO.class);
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setText("角色");
        nodeDTO.setNodes(nodeDTOS);
        nodeDTO.setTags(0);
        logger.debug("nodeDTO:" + nodeDTO);
        return nodeDTO;
    }
}
