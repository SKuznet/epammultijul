package hw1;

import java.util.concurrent.Semaphore;

public class Light implements Runnable{

  CommonResource res;
  Semaphore sem;
  String name;

  Light(){}

  Light(CommonResource res, Semaphore sem, String name){
    this.res=res;
    this.sem=sem;
    this.name=name;
  }

  public void run() {
  }
}
