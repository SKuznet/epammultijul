package hw1;



import java.util.concurrent.Semaphore;

public class GreenThread implements Runnable {

  CommonResource res;
  Semaphore sem;
  String name = "GreenThread";

  GreenThread(CommonResource res, Semaphore sem){
    this.res=res;
    this.sem=sem;
  }

  @Override
  public void run(){

    while(true) {
      try {
        sem.acquire();
        res.x = 1;
        while (res.x < 4) {
          Thread.sleep(6000);
          System.out.println(this.name + ": " + res.x);
          res.x++;

        }
      } catch (InterruptedException e) {
        System.out.println("ZELENII");
      }
      System.out.println(name + " освобождает разрешение");
      sem.release();
    }
  }
}
