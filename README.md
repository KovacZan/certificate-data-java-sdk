# certificate-manager-java-sdk
![](https://raw.githubusercontent.com/KovacZan/certificate-manager-java-sdk/master/bcdiploma-1021x400.jpg)

> Certificate manager transaction using java sdk

### Example of usage

```java
Transaction transaction = new CertificateManagerBuilder()
                .nonce(nonce)
                .certifiedDataAsset("certified data")
                .sign("clay harbor enemy utility margin pretty hub comic piece aerobic umbrella acquire")
                .transaction;
```
