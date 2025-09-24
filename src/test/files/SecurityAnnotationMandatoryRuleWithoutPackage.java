/*
 * Copyright (C) 2012-2025 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
class BusinessClassDelegate implements MySecurityInterface, SecondInterface {

  int aField;

  @MySecurityAnnotation
  public void aMethod() { }

  public void anotherMethod() { } // Noncompliant {{Mandatory Annotation not set @MySecurityAnnotation}}

}
