public class Board {

    public Board(){

    }

    /**
     * Skriver ut alla objekt i arrayen board,
     *
     * alla index utan värde skrivs ut som -
     *
     * counter räknar upp tills den når 60 och byter rad
     */
    static void print(){

        int counter = 0;
        int row = 0;

        for (Animal a : Game.board) {
            if(a != null){
                System.out.print(a.getTag());
                counter++;
            }else if(row == 0 || row == 19 || counter == 59 || counter == 0){
                System.out.print("*");
                counter++;
            }else{
                System.out.print(" ");
                counter++;
            }

            if(counter == 60){
                System.out.println();
                counter = 0;
                row++;
            }
        }
    }

    static boolean occupied(int x){
        return Game.board[x] != null;
    }

}
