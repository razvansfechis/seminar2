package Controller;
import Model.IObject;
import Repository.IRepository;
import Repository.MyException;
public class Controller {
    IRepository repository;

    public Controller(IRepository repository){
        this.repository = repository;
    }

    public void add(IObject obj) throws MyException{
        this.repository.add(obj);
    }

    public void remove(int pos) throws MyException{
        this.repository.remove(pos);
    }

    public IObject[] filter() throws MyException{
        return this.repository.Filter();
    }

    public int size() throws MyException{
        return this.repository.getSize();
    }

    public IObject[] getAll() throws MyException{
        return this.repository.getAll();
    }
}
