package com.pigyrj.kep.server.auth.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

/**
 * @author YRJ
 * @date 2019/3/14
 * <p>
 * jwt playload part info
 */
@Getter
@Setter
@NoArgsConstructor
public class JwtPlayload implements JwtShell {

    //---以下为jwt标准字段---
    /**
     * JWT ID用于标识该JWT
     */
    private String jti;
    /**
     * 发行人
     */
    private String iss;
    /**
     * 主题
     */
    private String sub;
    /**
     * 用户
     */
    private String aud;
    /**
     * 在此之前不可用
     */
    private Date nbf;
    /**
     * 发布时间
     */
    private Date iat;
    /**
     * 到期时间
     */
    private Date exp;


    //---以下为jwt扩展---
    /**
     * 用户的id
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户别名
     */
    private String userAlias;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 有效时间
     */
    private Long period;

    /**
     * 其他扩展
     */
    private Map<String, Object> extensions;


    public Long getPeriod() {
        if (period != null){

        }else {
            period = exp.getTime() - nbf.getTime();
        }

        return period;
    }

}
