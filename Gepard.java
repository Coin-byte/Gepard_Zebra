public class Gepard extends Animal{

    public Gepard(){
        super();
    }
    public Gepard(int x, boolean moved){
        super(x);
        this.setTag('G');
        this.setHunger(0);
        this.setMoved(moved);
        this.setPrey(false);
    }

}
