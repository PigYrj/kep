package com.pigyrj.kep.server.auth.jwt;

import java.io.Serializable;

/**
 * @author YRJ
 * @date 2019/3/14
 *
 * jwt 相关的元数据
 */
public interface JwtMeta extends Serializable{
    /**
     * 用户的id
     */
    String USER_ID = "userId";

    /**
     * 用户名称
     */
    String USER_NAME = "userName";

    /**
     * 用户别名
     */
    String USER_ALIAS = "userAlias";

    /**
     * 用户类型
     */
    String USER_TYPE = "userType";
}
