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
import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import java.io.File;

/**
 * @author YRJ
 * @date 2019/3/14
 */
public class jwtTests {

    @Test
    public void jwtGen_Test() throws Exception{
        File file = new File("D:\\project\\190313\\1\\kep\\src\\main\\java\\com\\pigyrj\\kep\\server\\auth\\pki\\pfx\\test2048.pfx");
        KeyPair keyPair = PKIUtils.getKeyPair(FileCopyUtils.copyToByteArray(file),"123123");

        JwtHandler jwtHandler = new JwtHandler();

        JwtPlayload playload = new JwtPlayload();
        playload.setIss("unitid");
        playload.setPeriod(1000*60*60l);
        playload.setUserAlias("yrj");
        playload.setUserId("111");


        JwtSignature jwtSignature = new JwtSignature();
        jwtSignature.setAlgorithm(SignatureAlgorithm.RS256);
        jwtSignature.setKey(keyPair.getPrivateKey());
        String token = jwtHandler.generateToken(new JwtHeader(),playload,jwtSignature);

        Jwt jwtinfo = Jwts.parser().setSigningKey(keyPair.getPublicKey()).parse(token);
    }

}
