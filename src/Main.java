public class Main {

    public static void main(String[] args) throws InterruptedException {
        Table t=new Table();
        Agent a =new Agent(t);
        Chef c=new Chef(Agent.ingredients.PEANUTBUTTER,t);
        Chef c1=new Chef(Agent.ingredients.JAM,t);
        Chef c2=new Chef(Agent.ingredients.BREAD,t);

        a.start();
        c.start();
        c1.start();
        c2.start();



    }
}