

import java.rmi.*;
import java.util.List;

interface Comprador extends Remote {
    void enseña_articulos(String apodo, List<String> m) throws RemoteException;
    void setEn_Subasta(int comprando) throws RemoteException;
    void informa_compradores(String mensaje) throws RemoteException;	
    int getEstoy_subasta() throws RemoteException;
}
