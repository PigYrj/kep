package com.pigyrj.kep.server.dao.mapper;

import com.pigyrj.kep.server.dao.entity.DictNodeEntity;

import java.util.List;
import java.util.Map;

/**
 * 字典节点
 */
public interface DictNodeMapper {

    List<DictNodeEntity> queryList(Map paramsMap);

}