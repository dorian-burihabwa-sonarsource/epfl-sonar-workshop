/*
 * Copyright (C) 2012-2022 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
package org.sonar.samples.java.checks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ExpressionTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.ReturnStatementTree;
import org.sonar.plugins.java.api.tree.Tree;

@Rule(key = "NarrowReturnType")
public class NarrowReturnTypeCheck extends IssuableSubscriptionVisitor {
  @Override
  public List<Tree.Kind> nodesToVisit() {
    return List.of(Tree.Kind.METHOD);
  }

  @Override
  public void visitNode(Tree tree) {
    MethodTree method = (MethodTree) tree;
    Type returnType = method.symbol().returnType().type();
    var visitor = new ReturnVisitor();
    method.accept(visitor);
    if (visitor.typesReturned.size() == 1) {
      var effectivelyReturned = visitor.typesReturned.stream().findFirst().get();
      if (!effectivelyReturned.is(returnType.fullyQualifiedName()) && effectivelyReturned.isSubtypeOf(returnType)) {
        reportIssue(
          method,
          String.format("Change the return type to \"%s\".", effectivelyReturned.name())
        );
      }
    }
  }

  class ReturnVisitor extends BaseTreeVisitor {
    private final Set<Type> typesReturned = new HashSet<>();

    @Override
    public void visitReturnStatement(ReturnStatementTree tree) {
      ExpressionTree expression = tree.expression();
      if (expression != null) {
        Type type = expression.symbolType();
        if (type != null) {
          typesReturned.add(type);
        }
      }
      super.visitReturnStatement(tree);
    }
  }
}
