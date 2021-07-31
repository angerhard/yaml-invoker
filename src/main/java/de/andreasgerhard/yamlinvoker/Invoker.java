package de.andreasgerhard.yamlinvoker;

import de.andreasgerhard.interpreter.Interpreter;
import java.io.File;

public class Invoker {

  public static void main(String[] args) {
    if (args == null || args.length < 1) {
      System.err.println("I need the yaml file as parameter");
      System.exit(1);
    }
    File file = new File(args[0]);
    if (!file.exists() || file.isDirectory()) {
      System.err.printf("%s doesn't exists!%n", args[0]);
      System.exit(1);
    }
    new Interpreter(args[0]);
  }
}
