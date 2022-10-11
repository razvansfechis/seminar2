package Repository;
import Model.IObject;

public interface IRepository {
    void add(IObject elem) throws MyException;
    void remove(int pos) throws MyException;
    IObject[] Filter() throws MyException;
    int getSize() throws MyException;

    IObject[] getAll() throws MyException;
}
