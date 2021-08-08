package read_write_file.sale_management;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 3:15 AM
 */
public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",7777);
            Management management = (Management) registry.lookup("Management");
            System.out.println("Lookup success");
            while (true){
                menu();
                switch (new  Scanner(System.in).nextInt()){
                    case 1 : getAll(management);break;
                    case 2 : addNewHouse(management);break;
                    case 3 :buyHouse(management);break;
                    case 4 : {
                        management.cancel();
                        return;
                    }
                    default: {
                        System.out.println("Please choose from 1 to 4");
                        break;
                    }
                }
            }
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
    static  private  void menu(){
        System.out.println("Please choose ");
        System.out.println("1. Print house list");
        System.out.println("2. Create  new house");
        System.out.println("3. Buy house");
        System.out.println("4. Exits");
    }
    static  private void getAll(Management management) throws RemoteException {
        List<House> houses = management.getAllHouse();
        System.out.println("Get success");
        for (House house: houses) {
            System.out.println(house.toString());
        }
    }
    static  private void addNewHouse(Management management) throws RemoteException{
        House house = getHouse();
        System.out.println("Input New House Information");
        management.addHouse(house);
        System.out.println("Add success");
    }
    static  private void buyHouse(Management management) throws  RemoteException{
        List<House> houses = management.getAllHouse();
        System.out.println("Get success");
        for (House house: houses) {
            System.out.println(house.toString());
        }
        System.out.println("Input code house buy");
        int code = new  Scanner(System.in).nextInt();
        House house = findHouse(code,houses);
        if (house != null){
            management.buyHouse(house);
        }else {
            System.out.println("The house doesn't exist");
        }

    }
    static private  House findHouse(int code,List<House>houses) {
        for(House house : houses){
            if (house.getCode() == code){
                return house;
            }
        }
        return  null;
    }

    static private House getHouse() {
        System.out.println("Input House Code");
        int code =  new Scanner(System.in).nextInt();
        System.out.println("Input House Price");
        int price = new Scanner(System.in).nextInt();
        System.out.println("Input House Status (True or False");
        boolean status =new Scanner(System.in).nextBoolean();
        return new House(code,price,status);
    }

}
