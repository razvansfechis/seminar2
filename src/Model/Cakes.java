package Model;

public class Cakes implements IObject{

    double weight;

    private final String TYPE = "Cake";

    public Cakes(double volume){this.weight = volume;}

    public double getMinWeight(){return this.weight;}

    public String getString(){return this.TYPE;}
}
