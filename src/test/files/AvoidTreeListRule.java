/*
 * Copyright (C) 2012-2025 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
import org.apache.commons.collections4.list.TreeList;
import java.util.ArrayList;

class A {
  void foo() {
    TreeList myList = new TreeList(new ArrayList<>()); // Noncompliant {{Avoid using TreeList}}
    // Noncompliant@+1
    MyList myOtherList = new MyList(); // as MyList extends the TreeList, we expect an issue here
  }
}

class MyList extends TreeList {

}
