# Java Multibase
This is a Java implementation of the IETF Multibase standard. 
The standard is currently in draft status. More information: https://www.ietf.org/id/draft-multiformats-multibase-04.html

### Current status
Note, this library is still under development.
Currently supported data formats are:

- Base64
- Base64URL
- Base58

### Usage
The Multiformat uses a similar interface as the JDK Base64 class.

JDK Base64:
```java
Base64.getEncoder().encode("test".getBytes(StandardCharsets.UTF_8));
```

MultiBase Base64:
```java
MultiBase.getBase64Encoder().encode("test".getBytes(StandardCharsets.UTF_8));
```
