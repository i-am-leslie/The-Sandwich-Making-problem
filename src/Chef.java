/**
 * This method remmoves ingredients and makes a sandwich
 */
public class Chef extends Thread {
    private Agent.ingredients ingredients;
    private Table table;// monitor


    public Chef(Agent.ingredients ingredients,Table table) {
        this.ingredients= ingredients;
        this.table=table;
    }

    /**
     * removes ingredients from the table
     */
    public  void chefMadeSandwich() {
        table.removeItems(ingredients);



    }
    @Override
    public void run() {

        while (table.getSandwichmade() < 20) {
            chefMadeSandwich();
        }
        stop();



    }
}
