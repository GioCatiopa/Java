public class Main {
    public static void main(String[] args) {
        Table myTable = new Table();                            /* Istance of the shared resource */
        Dwarve company[] = new Dwarve[6];                       /* Creation of an array of 6 items */
        for(int i = 0; i < company.length; i++){                 
            company[i] = new Dwarve(myTable, "Dwarve_" + i, i); /* Istance of an item in the array */
        } 

        for(int i = 0; i < company.length; i++){
            company[i].start();                                 /* The execution of the Dwarve-Thread is started */
        }

        for(int i = 0; i < company.length; i++){
            try {
                company[i].join();                              /* The interruption of the Dwarve-Thread is called */
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("\n\nSimulation terminated!");
    }
}
