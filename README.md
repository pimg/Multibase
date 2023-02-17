# Java Multibase
![CI tests](https://github.com/pimg/Multibase/actions/workflows/main.yml/badge.svg)

This is a Java implementation of the IETF Multibase standard. 
The standard is currently in draft status. More information: https://www.ietf.org/archive/id/draft-multiformats-multibase-06.html

### Current status
Note, this library is still under development.
Currently supported data formats are:

- Base64
- Base64URL
- Base58
- Hexadecimal 
- Octal
- Binary

### Usage
The Multiformat uses a somewhat similar interface as the JDK Base64 class.
The different encoding and decoding formats are encapsulated in the Multibase enum.

JDK Base64:
```java
Base64.getEncoder().encode("test".getBytes(StandardCharsets.UTF_8));
```

Multibase Base64:
```java
Multibase.BASE64.getEncoder().encode("test".getBytes(StandardCharsets.UTF_8));
```

Multibase HEX:
```java
String testHexStr = "f466f6f";
byte[] decodedByteArr = Multibase.HEX.getDecoder().decode(testHexStr);
```
