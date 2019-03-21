package com.pigyrj.kep.auth;

import com.pigyrj.kep.server.auth.pki.PKIUtils;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.security.KeyStore;

/**
 * @author YRJ
 * @date 2019/3/19
 */
public class PKITest {

    @Test
    public void priviateKey_Test() throws Exception{
        File file = new File("D:\\project\\190313\\1\\kep\\src\\main\\java\\com\\pigyrj\\kep\\server\\auth\\pki\\pfx\\test2048.pfx");
        KeyStore keyStore = PKIUtils.getKeyStore(FileCopyUtils.copyToByteArray(file),"123123");
        System.out.println("keystore type=" + keyStore.getType());

        System.out.println("ok");
    }
}
