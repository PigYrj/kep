package com.pigyrj.kep.server.auth.handler;

import com.pigyrj.kep.server.auth.jwt.JwtHeader;
import com.pigyrj.kep.server.auth.jwt.JwtMeta;
import com.pigyrj.kep.server.auth.jwt.JwtPlayload;
import com.pigyrj.kep.server.auth.jwt.JwtSignature;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.Map;

/**
 * @author YRJ
 * @date 2019/3/14
 */
public class JwtHandler {

    public String generateToken(JwtHeader jwtHeader, JwtPlayload jwtPlayload, JwtSignature jwtSignature) {

        JwtBuilder jwtBuilder = Jwts.builder();

        Iterator<String> headerKeyIterator = jwtHeader.keySet().iterator();
        while (headerKeyIterator.hasNext()) {
            String key = headerKeyIterator.next();
            jwtBuilder.setHeaderParam(key, jwtHeader.get(key));
        }

        jwtBuilder.setId(jwtPlayload.getJti())
                .setSubject(jwtPlayload.getSub())
                .setIssuer(jwtPlayload.getSub())
                .setAudience(jwtPlayload.getAud())
                .setIssuedAt(jwtPlayload.getIat())
                .setNotBefore(jwtPlayload.getNbf())
                .setExpiration(jwtPlayload.getExp())
                .claim(JwtMeta.USER_ID, jwtPlayload.getUserId())
                .claim(JwtMeta.USER_NAME, jwtPlayload.getUserName())
                .claim(JwtMeta.USER_ALIAS, jwtPlayload.getUserAlias())
                .claim(JwtMeta.USER_TYPE, jwtPlayload.getUserType())
                .claim(JwtMeta.PERIOD, jwtPlayload.getPeriod());

        //1.resolve extensions
        Map<String, Object> extensionsMap = jwtPlayload.getExtensions();

        if (!CollectionUtils.isEmpty(extensionsMap)){
            Iterator<String> extKeyIterator = extensionsMap.keySet().iterator();
            //2.put value
            while (extKeyIterator.hasNext()) {
                String key = extKeyIterator.next();
                jwtBuilder.claim(key, extensionsMap.get(key));
            }
        }

        if (null != jwtSignature.getKey()) {
            jwtBuilder.signWith(jwtSignature.getAlgorithm(), jwtSignature.getKey());
        } else {
            jwtBuilder.signWith(jwtSignature.getAlgorithm(), jwtSignature.getKeyByte());
        }

        String token = jwtBuilder.compact();
        return formatToken(token);
    }

    public void verify(String token){
        Jwts.parser().parse(token);
    }

    private String formatToken(String token){
        return token;
    }
}
