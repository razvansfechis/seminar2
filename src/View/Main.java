package View;
import Model.Apple;
import Model.IObject;
import Model.Cakes;
import Model.Book;

import Repository.Repository;
import Controller.Controller;
import Repository.MyException;
import java.util.Scanner;

public class Main {

    public static void PrintManu(){
        System.out.println("1.Add Object \n" +
                "2.Delete an object \n" +
                "3.Print all objects\n" +
                "4.Filter objects\n" +
                "0.Exit");

    }
    public static void main(String[] args) {
        Repository repository = new Repository(10);
        Controller controller = new Controller(repository);

        Scanner in = new Scanner(System.in);
        PrintManu();

        int opt = in.nextInt();

        while (opt != 0) {
            if (opt == 1) {
                Scanner inShape = new Scanner(System.in);
                System.out.println("enter Object(Apple, Cake, Book)");
                String shape = inShape.nextLine();
                System.out.println("Enter weight: ");
                double volume = inShape.nextDouble();
                try {
                    if(shape.equals("Apple"))
                    {
                        Apple b = new Apple(volume);
                        controller.add(b);
                    }else if (shape.equals("Cake")){
                        Cakes g = new Cakes(volume);
                        controller.add(g);
                    }else if (shape.equals("Book")){
                        Book t = new Book(volume);
                        controller.add(t);
                    }else throw new MyException("No such type exists");
                } catch (MyException ex) {
                    System.out.println("Error:" + ex + "\n");
                }

            } else if (opt == 2) {
                Scanner pos = new Scanner(System.in);
                System.out.println("Position of element to remove: ");
                int position = pos.nextInt();
                try {
                    controller.remove(position);
                } catch (MyException ex) {
                    System.out.println("Error: " + ex + "\n");
                }
            } else if (opt == 3) {
                try {
                    IObject[] objects = controller.getAll();
                    for (int i = 0; i < controller.size(); i++) {
                        System.out.println(objects[i].getString() + " ");
                    }
                } catch (MyException ex) {
                    System.out.println("Error: " + ex + "\n");
                }

            } else if (opt == 4) {
                try {
                    IObject[] objects = controller.filter();
                    for (IObject object : objects) {
                        System.out.println(object.getString() + " ");
                    }
                } catch (MyException ex) {
                    System.out.println("Error: " + ex + "\n");
                }
            }
            else {
                System.out.println("Invalid option");
            }

            PrintManu();
            opt = in.nextInt();
        }
    }
}