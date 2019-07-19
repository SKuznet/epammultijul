package com.epam.multi.homework2;

import java.util.concurrent.Callable;

public class ImplementsCallable implements Callable {

  @Override
  public Object call() throws Exception {
    return "hello from callable";
  }
}
