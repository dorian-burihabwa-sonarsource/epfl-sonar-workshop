/*
 * Copyright (C) 2012-2022 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
package org.sonar.samples.java.checks;

import java.util.Collections;
import java.util.List;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

@Rule(key = "ReturnTypeDifferentFromSingleParameter")
public class ReturnTypeDifferentFromSingleParameterCheck extends IssuableSubscriptionVisitor {

  @Override
  public List<Tree.Kind> nodesToVisit() {
    return Collections.singletonList(Tree.Kind.METHOD);
  }

  @Override
  public void visitNode(Tree tree) {
    MethodTree method = (MethodTree) tree;
    if (method.parameters().size() == 1) {
      Symbol.MethodSymbol symbol = method.symbol();
      Type firstParameterType = symbol.parameterTypes().get(0);
      Type returnType = symbol.returnType().type();
      if (returnType.is(firstParameterType.fullyQualifiedName())) {
        reportIssue(method.simpleName(), "Never do that!");
      }
    }
  }

}
