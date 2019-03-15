package com.pigyrj.kep.server.auth.jwt;

import java.util.Date;
import java.util.Map;

/**
 * @author YRJ
 * @date 2019/3/14
 * <p>
 * jwt playload part info
 */
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
     * 其他扩展
     */
    private Map<String, Object> extensions;

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public Date getNbf() {
        return nbf;
    }

    public void setNbf(Date nbf) {
        this.nbf = nbf;
    }

    public Date getIat() {
        return iat;
    }

    public void setIat(Date iat) {
        this.iat = iat;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Map<String, Object> getExtensions() {
        return extensions;
    }

    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
}
