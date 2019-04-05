# kep

## jwt的生成及验证
```
   @Test
      public void jwtGen_Test() throws Exception{
          //ClassPathResource访问项目内文件 若是以jar形式运行 请使用classPathResource.getInputStream()
          ClassPathResource classPathResource = new ClassPathResource("/static/pfx/default1.pfx");
          File file = classPathResource.getFile();

          //读取公私钥对
          KeyPair keyPair = PKIUtils.getKeyPair(FileCopyUtils.copyToByteArray(file),"123123");
          //头信息
          JwtHandler jwtHandler = new JwtHandler();
          //信息负载部分
          JwtPlayload playload = new JwtPlayload();
          playload.setIss("unitid");
          playload.setPeriod(1000*60*60l);
          playload.setUserAlias("yrj");
          playload.setUserId("111");
          //签名部分
          JwtSignature jwtSignature = new JwtSignature();
          jwtSignature.setAlgorithm(SignatureAlgorithm.RS256);
          jwtSignature.setKey(keyPair.getPrivateKey());
          String token = jwtHandler.generateToken(new JwtHeader(),playload,jwtSignature);
          //解析jwt
          Jwt jwtinfo = Jwts.parser().setSigningKey(keyPair.getPrivateKey()).parse(token);

          String[] jwts = token.split("\\.");
          //其实jwt中 是对header和palyload的URLBase64进行的签名
          String srcData = jwts[0] + "." +jwts[1];
          //签名部分
          String signVale = jwts[2];
          //验证签名
          boolean judge = PKIUtils.verifySignRSA(srcData,signVale,keyPair.getPublicKey());
          Assert.assertEquals(true,judge);
      }
```
