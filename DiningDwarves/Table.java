import java.util.concurrent.locks.ReentrantLock;

public class Table{
    private ReentrantLock chopsticks[]; /* Array of binary semaphores */

    public Table(){
        this.chopsticks = new ReentrantLock[6];
        for(int i = 0; i < this.chopsticks.length; i++){
            this.chopsticks[i] = new ReentrantLock();
        }
    }

    public void eat(int index){
        if(index < 5){
            this.chopsticks[index].lock();                                  /* The left chopstick is taken */
            this.chopsticks[(index + 1) % this.chopsticks.length].lock();   /* The right chopstick is taken */
        }else{
            this.chopsticks[(index + 1) % this.chopsticks.length].lock();
            this.chopsticks[index].lock();
        }

        /* The Dwarve is eating for 2s */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        /* The Dwarve has finished eating */
        this.chopsticks[(index + 1) % this.chopsticks.length].unlock();     /* The right chopstick is freed */
        this.chopsticks[index].unlock();                                    /* The left chopstick is freed */

        System.out.println("The dwarve number " + index + " ate!");
    }

    public void sleepingTime(int index){
        System.out.println("The dwarve number " + index + " is going to sleep!");
        /* The Dwarve is going to sleep for 1s */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}