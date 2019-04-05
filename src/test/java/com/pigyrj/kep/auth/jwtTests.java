package com.pigyrj.kep.auth;

import com.pigyrj.kep.server.auth.handler.JwtHandler;
import com.pigyrj.kep.server.auth.jwt.JwtHeader;
import com.pigyrj.kep.server.auth.jwt.JwtPlayload;
import com.pigyrj.kep.server.auth.jwt.JwtSignature;
import com.pigyrj.kep.server.auth.pki.KeyPair;
import com.pigyrj.kep.server.auth.pki.PKIUtils;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.File;

/**
 * @author YRJ
 * @date 2019/3/14
 */
public class jwtTests {

    @Test
    public void jwtGen_Test() throws Exception{
        ClassPathResource classPathResource = new ClassPathResource("/static/pfx/default1.pfx");
        File file = classPathResource.getFile();

        ClassPathResource classPathResource2 = new ClassPathResource("/static/pfx/default2.pfx");
        File file2 = classPathResource2.getFile();
        KeyPair keyPair = PKIUtils.getKeyPair(FileCopyUtils.copyToByteArray(file),"123123");
        KeyPair keyPair2 = PKIUtils.getKeyPair(FileCopyUtils.copyToByteArray(file2),"123123");
        JwtHandler jwtHandler = new JwtHandler();

        JwtPlayload playload = new JwtPlayload();
        playload.setIss("unitid");
        playload.setPeriod(1000*60*60l);
        playload.setUserAlias("yrj");
        playload.setUserId("111");


        JwtSignature jwtSignature = new JwtSignature();
        jwtSignature.setAlgorithm(SignatureAlgorithm.RS256);
//        jwtSignature.setKey(keyPair.getPrivateKey());
        jwtSignature.setKey(keyPair.getPrivateKey());
        String token = jwtHandler.generateToken(new JwtHeader(),playload,jwtSignature);

        Jwt jwtinfo = Jwts.parser().setSigningKey(keyPair.getPrivateKey()).parse(token);

        String[] jwts = token.split("\\.");
        String srcData = jwts[0] + "." +jwts[1];
        String signVale = jwts[2];

        boolean judge = PKIUtils.verifySignRSA(srcData,signVale,keyPair.getPublicKey());
        Assert.assertEquals(true,judge);
    }

}
