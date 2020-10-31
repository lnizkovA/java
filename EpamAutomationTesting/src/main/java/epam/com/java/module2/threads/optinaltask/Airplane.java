package epam.com.java.module2.threads.optinaltask;

import java.util.concurrent.Semaphore;

public class Airplane implements Runnable {
    private int id;
    private Semaphore sem;
    private  boolean isFlighed = false;

    public Airplane(int id, Semaphore sem){
       this.id = id;
       this.sem = sem;
    }

    @Override
    public void run() {
        try {
            if (! isFlighed){
                System.out.println("Самолет  id = "+id+" начал выход на полосу" );
                sem.acquire();
                System.out.println("Полоса приняла cамолет id= "+id);

                Thread.sleep(1000);
                isFlighed = true;

                System.out.println("Самолет  id = "+id+"  взлетел");
                sem.release();
                System.out.println("Полоса освободилась");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error");
        }

    }
}
