package Repository;
import Model.IObject;
public class Repository implements IRepository {

    private int size;
    private IObject[] data;

    public Repository (int capacity){
        this.size = 0;
        this.data = new IObject[capacity];
    }

    @Override
    public void add(IObject elem) throws MyException {
        if (this.size == this.data.length){
            throw new MyException("list is full");
        }
        else if(elem.getMinWeight() <= 0){
            throw new MyException("Object can't have 0 or negative volume");
        }
        else {
            this.data[this.size++] = elem;
        }
    }

    @Override
    public void remove(int pos) throws MyException {
        if(pos>size || pos < 0) {
            throw new MyException("there is no element on that position");
        }
        for(int i =pos ;i<this.size;i++){
            this.data[i] = this.data[i+1];
        }
        this.size--;
    }

    @Override
    public IObject[] Filter() throws MyException {
        if(this.size == 0){
            throw new MyException("List empty");
        }
        int len = 0;

        for(int i =0;i<this.size;i++){
            if(this.data[i].getMinWeight()>IObject.MIN_WEIGHT) {
                len++;
            }
        }

        IObject[] filter = new IObject[len];

        len =0;

        for (int i=0;i < this.size;i++){
            if(this.data[i].getMinWeight() > IObject.MIN_WEIGHT){
                filter[len++] = this.data[i];
            }
        }
        return filter;
    }

    @Override
    public int getSize() throws MyException {
        return this.size;
    }

    @Override
    public IObject[] getAll() throws MyException {
        return this.data;
    }
}
