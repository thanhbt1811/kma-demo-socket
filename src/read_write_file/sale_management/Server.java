package read_write_file.sale_management;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 3:15 AM
 */
public class Server {
    public static void main(String[] args) {
        try {
             Management management = new ManagementImpl("Management");
            Registry registry = LocateRegistry.createRegistry(7777);
            System.out.println("Create Registry Success");
            registry.bind("Management",management);
            System.out.println(">>>>>INFO: RMI Server started!!!!!!!!");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

}
