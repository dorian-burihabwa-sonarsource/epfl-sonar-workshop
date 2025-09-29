/*
 * Copyright (C) 2012-2025 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
/**
 *This file is the sample code against we run our unit test.
 *It is placed src/test/files in order to not be part of the maven compilation.
 **/
class AvoidBrandInNamesCheck {

  int aField;

  public void methodWithMYCOMPANY() { // Noncompliant {{Avoid using Brand in method name}}

  }

  public void methodWithMyCompany() { // Noncompliant {{Avoid using Brand in method name}}

  }

  public void methodWithMyOtherCompany() { // Compliant

  }

}
