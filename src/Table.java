/**
 * This method serves as a monitpr e.g semaphore for both the chef and  Agent class which helps to
 * synchronize both threads
 */
public class Table {
    private Agent.ingredients[] ingredients;// Holds the two ingredients for the chef to use
    private int numberOfIngredients;// counts the number of ingredients present


    private  int sandwichmade;// counts the number of sandwich that has been made by the chef


    public Table() {
        this.numberOfIngredients = 0;
        this.ingredients = new Agent.ingredients[2];
    }

    /**
     * Places two ingredients on the table and makes the threads wait if one of the array is not empty
     * @param sandwichIngredient
     * @param sandwichIngredient2
     */
    public synchronized void placeitems(Agent.ingredients sandwichIngredient,Agent.ingredients sandwichIngredient2){

        while(ingredients[0]!=null || ingredients[1]!=null){
            try{
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ingredients[numberOfIngredients]=sandwichIngredient;
        numberOfIngredients++;
        ingredients[numberOfIngredients]=sandwichIngredient2;
        numberOfIngredients++;
        notifyAll();


    }

    /**
     *This is a method that takes in a parameter of type "Agent.ingredients" and returns a boolean value
     * @param ingre which is an ingredient
     * @return true if item is in the array  false otherwise
     */
    private boolean items(Agent.ingredients ingre){
        if(ingre== ingredients[0] || ingre== ingredients[1]){
            return true;
        }
        return false;
    //return (ingre== ingredients[0] || ingre== ingredients[1]);
    }

    /**
     * This synchronized method takes in an ingredient and checks if the item is already present in the array
     * or if the two slots in the array are empty
     * @param ingredients
     * @return true if succefully removed and item and false if sandwhicmade is more than 20
     */
    public synchronized boolean removeItems(Agent.ingredients ingredients){

        while(items(ingredients)==true || (this.ingredients[0] == null) || (this.ingredients[1] == null)){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        if(sandwichmade >= 20)
            return false;

        increaseSandwhichMade();
        System.out.println("Made sandwich with " + ingredients.toString() + " " + this.ingredients[0] + " " + this.ingredients[1] + " " + sandwichmade);
        this.ingredients[0]=null;
        this.ingredients[1]=null;
        numberOfIngredients=0;
        notifyAll();
        return true;
    }

    /**
     * inreases sandwicmade
     */
    private   void increaseSandwhichMade(){
        sandwichmade++;

    }

    /**
     * checks the number of sandwichmade
     * @return int
     */
    public  int getSandwichmade() {
        return sandwichmade;
    }




}
