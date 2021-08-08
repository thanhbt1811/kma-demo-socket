package rmi.search_key;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 12:15 AM
 */
public interface Dictionary extends Remote {
    public  String translateToKey(String word) throws RemoteException;
    public  String translateToWord(String key) throws  RemoteException;
}
