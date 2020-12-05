public class Animal {
    private int hunger;
    private int xPos;
    private int row;
    private int col;

    final int maxHunger = 5;
    
    private char tag;

    private boolean moved;
    private boolean prey;

    public enum moveDir{up, down, left, right}

    public Animal(){
        hunger = 0;
        tag = 'a';
        moved = true;
        prey = false;
        xPos = -1;
    }
    public Animal(int x){

        this.xPos = x;
        this.row = x / 60;
        this.col = x % 60;
    }



    public void move(moveDir dir){
        int oldPos = this.xPos;

        if(!this.getMoved()){
            switch (dir){
                case up:
                    if(this.row == 0){
                        this.setMoved(true);
                        break;
                    }else{
                        this.setxPos(this.getxPos() - 60);
                        Game.board[this.xPos] = updatePos(this.getTag(), this.getxPos(), oldPos);
                        break;
                    }
                case down:
                    if(this.row == 19){
                        this.setMoved(true);
                        break;
                    }else{
                        this.setxPos(this.getxPos() + 60);
                        Game.board[this.xPos] = updatePos(this.getTag(), this.getxPos(), oldPos);
                        break;
                    }
                case left:
                    if(this.col == 0){
                        this.setMoved(true);
                        break;
                    }else{
                        this.setxPos(this.getxPos() - 1);
                        Game.board[this.xPos] = updatePos(this.getTag(), this.getxPos(), oldPos);
                        break;
                    }
                case right:
                    if(this.col == 59){
                        this.setMoved(true);
                        break;
                    }else{
                        this.setxPos(this.getxPos() + 1);
                        Game.board[this.xPos] = updatePos(this.getTag(), this.getxPos(), oldPos);
                        break;
                    }
            }
        }

    }

    public Animal updatePos(char a, int pos, int oldPos){
        if(a == 'G'){
            Game.board[oldPos] = null;
            return new Gepard(pos, true);
        }else{
            Game.board[oldPos] = null;
            return new Zebra(pos, true);
        }
    }




    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setTag(char tag) {
        this.tag = tag;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public void setPrey(boolean prey) {
        this.prey = prey;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getMaxHunger() {
        return maxHunger;
    }

    public int getHunger() {
        return hunger;
    }

    public char getTag() {
        return tag;
    }

    public int getxPos() {
        return xPos;
    }
    public boolean getMoved(){
        return moved;
    }


    @Override
    public String toString() {
        return "Animal{" +
                ", xPos=" + xPos +
                ", row=" + row +
                ", col=" + col +
                ", tag=" + tag +
                ", moved=" + moved +
                '}';
    }
}
