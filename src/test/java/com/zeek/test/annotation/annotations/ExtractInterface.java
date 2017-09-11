//: annotations/ExtractInterface.java
// APT-based annotation processing.
package com.zeek.test.annotation.annotations;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
  public String value();
} ///:~
