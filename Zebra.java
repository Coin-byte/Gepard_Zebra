public class Zebra extends Animal{

    public Zebra(){
        super();
    }
    public Zebra(int x, boolean moved){
        super(x);
        this.setTag('Z');
        this.setHunger(0);
        this.setMoved(moved);
        this.setPrey(true);
    }
}
