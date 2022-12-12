public class Dwarve extends Thread {
    private Table myTable;  /* Istance of the shared resource */
    private int index;      /* Index of the Dwarve */
    
    public Dwarve(Table t, String n, int i){
        super(n);
        this.myTable = t;
        this.index = i;
    }

    @Override
    public void run(){
        for(int i = 0; i < 3; i++){
            this.myTable.eat(this.index);           /* The Dwarve is going to eat */
            this.myTable.sleepingTime(this.index);  /* The Dwarve is going to sleep */

            /* Then, the Dwarve wait for 0.5s */
            try{
                Thread.sleep(500);
            }catch(InterruptedException ex){
                System.out.println(ex);
            }
        }

        System.out.println("The Dwarve number " + this.index + " terminate his execution!");
    }
}
