
import java.rmi.*;

interface ServicioSubasta extends Remote {
    void alta(Comprador c) throws RemoteException;
    void baja(Comprador c) throws RemoteException;
    void ver_articulos(Comprador c,String apodo) throws RemoteException;
    void comprar(Comprador e, Integer cantidad) throws RemoteException;
}
