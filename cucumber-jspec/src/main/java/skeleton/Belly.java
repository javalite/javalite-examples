package skeleton;

public class Belly {
    private int cukes;
    public void eat(int cukes) {
        this.cukes = cukes;
    }

    public boolean isHungry(){
        return cukes == 0;
    }
}
