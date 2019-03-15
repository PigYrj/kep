package com.pigyrj.kep.server.auth.handler;

import com.pigyrj.kep.server.auth.jwt.JwtHeader;
import com.pigyrj.kep.server.auth.jwt.JwtMeta;
import com.pigyrj.kep.server.auth.jwt.JwtPlayload;
import com.pigyrj.kep.server.auth.jwt.JwtSignature;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.util.Iterator;
import java.util.Map;

/**
 * @author YRJ
 * @date 2019/3/14
 */
public class JwtHandler {

    public void generateToken(JwtHeader jwtHeader, JwtPlayload jwtPlayload, JwtSignature jwtSignature){


        JwtBuilder jwtBuilder = Jwts.builder().setId(jwtPlayload.getJti())
                                .setSubject(jwtPlayload.getSub())
                                .setIssuer(jwtPlayload.getSub())
                                .setAudience(jwtPlayload.getAud())
                                .setIssuedAt(jwtPlayload.getIat())
                                .setNotBefore(jwtPlayload.getNbf())
                                .setExpiration(jwtPlayload.getExp())
                                .claim(JwtMeta.USER_ID,jwtPlayload.getUserId())
                                .claim(JwtMeta.USER_NAME,jwtPlayload.getUserName())
                                .claim(JwtMeta.USER_ALIAS,jwtPlayload.getUserAlias())
                                .claim(JwtMeta.USER_TYPE,jwtPlayload.getUserType());
        //resolve extensions
        Map<String, Object> extensionsMap = jwtPlayload.getExtensions();
        Iterator<String> extKeyIterator = extensionsMap.keySet().iterator();
        //put value
        while (extKeyIterator.hasNext()){
            String key = extKeyIterator.next();
            jwtBuilder.claim(key,extensionsMap.get(key));
        }

    }
}
