/*
 * Copyright (C) 2012-2025 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
class A {

  int foo() {}
  int foo(int a) {} // Noncompliant {{message}}
  int foo(int a, int b) {}

  Object foo(Object a){} // Noncompliant {{message}}
  String bar(String a){} // Noncompliant {{message}}
  String qix(Object a){}
}