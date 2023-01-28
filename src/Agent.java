import java.util.*;
/**
This is the Agent class that puts an ingredient into the table for the chef class to be able to make a sandwich
**/
public class Agent extends Thread {

    public enum ingredients {BREAD,PEANUTBUTTER,JAM} // These are the constant values used to make a sandwich
    private  Table table;// Serves as a monitor for both the chef and agent
    private Random rand;// This attribute helps select a random ingredient from the three constant ingredients


    public Agent(Table table) {
        this.table=table;
        this.rand=new Random();

    }

    /**
     * This method selects random ingredients
     *
     * @return an ingredient
     */
    private ingredients selectRandom(){
        int index;
        index=rand.nextInt(ingredients.values().length);
        return ingredients.values()[index];
    }
    @Override
    /**
     * This method is  inherited from the Thread class
     */
    public  void run() {
        while (table.getSandwichmade() < 20) {
            ingredients ingre1 = selectRandom();
            ingredients ingre2 = selectRandom();
            while (ingre2 == ingre1) {
                ingre2 = selectRandom();
            }

            table.placeitems(ingre1, ingre2);

        }
        stop();


    }


}
