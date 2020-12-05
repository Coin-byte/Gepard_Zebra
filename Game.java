import java.util.Random;
import java.util.Scanner;

public class Game {
    private Random random = new Random();
    protected static Animal[] board = new Animal[1200];


    public Game(){
        inputAnimals();
        int count = 0;
        do{
            Board.print();
            System.out.println();
            debug();
            moveAll();
            resetMoved();
            count++;
        }while(count < 10);

    }

    public void inputAnimals(){
       Scanner scan = new Scanner(System.in);
       int gepards = 0;
       int zebras = 0;
       try{
           System.out.println("How many Gepards and Zebras are going to be in the field? \nGepards:");
           gepards = scan.nextInt();
           while (gepards > zebras || zebras < 1) {
               System.out.print("There needs to be at least as many zebras. \nZebras: ");
               zebras = scan.nextInt();
           }
       }catch (Exception e){
           System.out.println("You need to input a number!");
           inputAnimals();
       }
       createAnimals(gepards, zebras);
    }

    public void createAnimals(int g, int z){
        for (int i = 0; i < g; i++) {
            placeAnimal(new Gepard());
        }
        for (int i = 0; i < z; i++) {
            placeAnimal(new Zebra());
        }
    }

    public void placeAnimal(Animal a) {
        int x;

        do{
            x = random.nextInt(1198) + 1;
        }while(Board.occupied(x));
            if(a instanceof Gepard){
                board[x] = new Gepard(x, false);
            }else if(a instanceof Zebra){
                board[x] = new Zebra(x, false);
            }else{
                System.out.println("Could not place more animals");
            }
    }

    public void moveAll(){
        for (Animal a : board){
            if (a != null){
                a.move(Animal.moveDir.right);
            }
        }
    }

    public void resetMoved(){
        for (Animal a : board){
            if (a != null){
                a.setMoved(false);
            }
        }
    }

    public static void debug() {
        for (Animal var : board) {
            if(var != null){
                System.out.println(var);
            }
        }
    }

}
