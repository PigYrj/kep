package com.pigyrj.kep.server.controller.biz;

import com.pigyrj.kep.server.dao.entity.DictNodeEntity;
import com.pigyrj.kep.server.service.DictNodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author YRJ
 * @date 2019/5/7
 */
@RestController
@RequestMapping("/kep/dict-node")
public class DictNodeController {
    @Autowired
    private DictNodeService dictNodeService;

    @GetMapping("/list")
    public List<DictNodeEntity> queryList(){
        HashMap<String,String> paramsMap = new HashMap<>(2);
        return dictNodeService.queryList(paramsMap);
    }

    @GetMapping("/test")
    public void queryList(String param){
        if (StringUtils.isEmpty(param)){
            param = "kongde";
        }
        System.out.println(param);
    }

}
