package com.pigyrj.kep.server.service;

import com.pigyrj.kep.server.dao.entity.DictNodeEntity;
import com.pigyrj.kep.server.dao.mapper.DictNodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author YRJ
 * @date 2019/5/7
 */
@Service
public class DictNodeService {
    @Autowired
    private DictNodeMapper dictNodeMapper;

    public List<DictNodeEntity> queryList(Map paramsMap){
        return dictNodeMapper.queryList(paramsMap);
    }
}
