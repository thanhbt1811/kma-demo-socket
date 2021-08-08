package read_write_file.sale_management;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 2:39 AM
 */
public class ManagementImpl extends UnicastRemoteObject implements  Management{
    private final String serverName;

    protected ManagementImpl(String serverName) throws RemoteException {
        this.serverName = serverName;
    }

    @Override
    public List<House> getAllHouse() throws RemoteException {
        List<House> houses =   FileSupport.readFile();
        for (House house : houses){
            System.out.println(house.toString());
        }
        return  houses;
    }

    @Override
    public void addHouse(House house) throws RemoteException {
        List<House> houses = FileSupport.readFile();
        houses.add(house);
        FileSupport.writeFile(houses);
    }

    @Override
    public void buyHouse(House house) throws RemoteException {
        List<House> houses = FileSupport.readFile();
        for(House h : houses){
            if (house.getCode() == h.getCode()){
                h.setStatus(true);
            }
        }
        FileSupport.writeFile(houses);
    }

    @Override
    public void cancel() throws RemoteException {
        try {
            Naming.unbind(serverName);
            UnicastRemoteObject.unexportObject(this,true);
            System.out.println("Cancel success");

        } catch (NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
