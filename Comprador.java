

import java.rmi.*;
import java.util.List;

interface Comprador extends Remote {
    void enseña_articulos(String apodo, List<String> m) throws RemoteException;
}
