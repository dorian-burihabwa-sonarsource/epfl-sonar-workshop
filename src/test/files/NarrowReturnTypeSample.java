class NarrowReturnTypeSample {
  Object f(boolean cond) { // Noncompliant {{Change the return type to "String".}}
    if (cond) {
      return "b";
    }
    return new String("a");
  }

  CharSequence second(boolean cond) { // Noncompliant
    if (cond) {
      return "b";
    } else if (!cond) {
      return "a";
    }
    return giveMeAGreeting();
  }

  Number third(boolean cond) { // Noncompliant {{Change the return type to "Integer".}}
    if (cond) {
      return Integer.valueOf(42);
    }
    return Integer.valueOf(0);
  }

  String giveMeAGreeting() { // Compliant
    return "Hello, World!";
  }


  Object inferredReturnType(int value) { // Compliant False Negative
    return switch (value) {
      case 0 -> "a";
      case 42 -> "b";
      default -> "default";
    };
  }

}