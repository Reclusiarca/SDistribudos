
import java.rmi.*;
import java.util.List;

interface ServicioSubasta extends Remote {
    void alta(Comprador c) throws RemoteException;
    void baja(Comprador c) throws RemoteException;
    void ver_articulos(Comprador c,String apodo) throws RemoteException;
    void comprar(Comprador c, Integer cantidad) throws RemoteException;
    List<String> que_vendemos() throws RemoteException;
}
