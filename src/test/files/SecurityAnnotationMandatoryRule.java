/*
 * Copyright (C) 2012-2025 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
package company.demo;

/**
 *This file is the sample code against we run our unit test.
 *It is placed src/test/files in order to not be part of the maven compilation.
 **/
class BusinessClassDelegate implements MySecurityInterface, SecondInterface {

  int aField;

  @MySecurityAnnotation
  public void aMethod() { }

  @org.foo.MyOtherSecurityAnnotation
  public void anotherMethod() { // Noncompliant {{Mandatory Annotation not set @MySecurityAnnotation}}
    //        ^^^^^^^^^^^^^
  }

  @VariousAnnotation
  public void differentMethod() { // Noncompliant {{Mandatory Annotation not set @MySecurityAnnotation}}
    //        ^^^^^^^^^^^^^^^
  }
}

class OtherClass implements FirstInterface, SecondInterface {

  int aField;

  @MySecurityAnnotation
  public void aMethod() { }

  public void anotherMethod() { } // Compliant
}
