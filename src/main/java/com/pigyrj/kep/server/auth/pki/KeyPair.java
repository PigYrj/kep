package com.pigyrj.kep.server.auth.pki;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author YRJ
 * @date 2019/3/19
 */
@Getter
@Setter
@NoArgsConstructor
public class KeyPair {

    private PublicKey publicKey;

    private PrivateKey privateKey;

    public KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }
}
