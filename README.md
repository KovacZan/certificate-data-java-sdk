# certificate-manager-java-sdk

> Certificate manager transaction using java sdk

### Example of usage

```java
Transaction transaction = new CertificateManagerBuilder()
                .nonce(nonce)
                .certifiedDataAsset("certified data")
                .sign("clay harbor enemy utility margin pretty hub comic piece aerobic umbrella acquire")
                .transaction;
```

### Run main class
To execute the following transaction run:
 
 `gradle certificateManager`