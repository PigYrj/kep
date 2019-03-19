package com.pigyrj.kep.server.auth.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Key;

/**
 * @author YRJ
 * @date 2019/3/14
 *
 * key和keyByte二选一即可 在都有输入的情况下 以key为优先
 */
@Getter
@Setter
@NoArgsConstructor
public class JwtSignature {

    private SignatureAlgorithm algorithm;

    private byte[] keyByte;

    private Key key;
}
