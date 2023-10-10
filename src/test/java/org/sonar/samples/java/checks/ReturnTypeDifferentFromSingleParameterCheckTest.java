/*
 * Copyright (C) 2012-2022 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

public class ReturnTypeDifferentFromSingleParameterCheckTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/ReturnTypeDifferentFromSingleParameterSample.java")
      .withCheck(new ReturnTypeDifferentFromSingleParameterCheck())
      .verifyIssues();
  }
}
