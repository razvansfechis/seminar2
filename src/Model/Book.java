package Model;


public class Book implements IObject{

    double weight;
    private final String TYPE = "Book";

    public Book(double volume){
        this.weight= volume;
    }
    @Override
    public double getMinWeight() {
        return this.weight;
    }

    @Override
    public String getString() {
        return this.TYPE;
    }
}
