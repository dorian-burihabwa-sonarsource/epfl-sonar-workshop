/*
 * Copyright (C) 2012-2025 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
/**
 *This file is the sample code against we run our unit test.
 *It is placed src/test/files in order to not be part of the maven compilation.
 **/
class AvoidMethodDeclarationCheck {

  int aField;

  public void aMethod() { // Noncompliant {{Avoid declaring methods (don't ask why)}}

  }

}
