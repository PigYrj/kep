package com.pigyrj.kep.server.auth.pki;

import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * @author YRJ
 * @date 2019/3/19
 * Public Key Infrastructure tools
 */
public class PKIUtils {

    /**
     * 根据pfx证书获取keyStore
     *
     * @param pfxData pfx文件主体 需要包含私钥和公钥
     * @param password pfx文件的密码 将转为char[]是同
     */
    public static KeyStore getKeyStore(byte[] pfxData, String password) throws Exception {
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        keystore.load(new ByteArrayInputStream(pfxData), password.toCharArray());
        return keystore;
    }

    /**
     * 根据pfx证书获取证书对象
     *
     * @param pfxData  pfx的字节数组
     * @param password pfx证书密码
     */
    public static X509Certificate getX509Certificate(byte[] pfxData, String password) throws Exception {
        X509Certificate x509Certificate = null;
        KeyStore keystore = getKeyStore(pfxData, password);
        Enumeration<String> enums = keystore.aliases();
        String keyAlias = null;
        while (enums.hasMoreElements()) {
            keyAlias = enums.nextElement();
            if (keystore.isKeyEntry(keyAlias)) {
                x509Certificate = (X509Certificate) keystore.getCertificate(keyAlias);
            }
        }

        return x509Certificate;
    }

    /**
     * 获取rsa 私钥
     *
     * @param pfxData  pfx的字节数组
     * @param password pfx证书密码
     */
    public static PrivateKey getPrivateKey(byte[] pfxData, String password) throws Exception {

        KeyStore keystore = getKeyStore(pfxData, password);
        Enumeration<String> enums = keystore.aliases();
        String keyAlias = null;
        while (enums.hasMoreElements()) {
            keyAlias = enums.nextElement();
        }

        return (PrivateKey) keystore.getKey(keyAlias, password.toCharArray());
    }

    public static KeyPair getKeyPair(byte[] pfxData, String password) throws Exception {
        X509Certificate x509Certificate = null;
        KeyStore keystore = getKeyStore(pfxData, password);
        Enumeration<String> enums = keystore.aliases();
        String keyAlias = null;
        while (enums.hasMoreElements()) {
            keyAlias = enums.nextElement();
            if (keystore.isKeyEntry(keyAlias)) {
                x509Certificate = (X509Certificate) keystore.getCertificate(keyAlias);
            }
        }

        PublicKey publicKey = x509Certificate.getPublicKey();
        PrivateKey privateKey = (PrivateKey) keystore.getKey(keyAlias, password.toCharArray());

        return new KeyPair(publicKey,privateKey);
    }
}
