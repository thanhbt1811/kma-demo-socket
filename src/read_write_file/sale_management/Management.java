package read_write_file.sale_management;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 2:33 AM
 */
public interface Management extends Remote {

    List<House> getAllHouse() throws RemoteException;

    void addHouse(House house) throws RemoteException;

    void buyHouse(House house) throws RemoteException;

    void cancel() throws RemoteException;
}
