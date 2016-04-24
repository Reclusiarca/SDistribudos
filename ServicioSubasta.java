
import java.rmi.*;
import java.util.List;

interface ServicioSubasta extends Remote {
    void alta(Comprador c) throws RemoteException;
    void baja(Comprador c) throws RemoteException;
    void bajatodos() throws RemoteException;
    boolean finalizar() throws RemoteException;
    void ver_articulos(Comprador c,String apodo) throws RemoteException;
    void comprar(Comprador c, Integer cantidad) throws RemoteException;
    List<String> que_vendemos() throws RemoteException;
    int comienza_subasta(int indexarti,int tiemposeg, int cantidadini) throws RemoteException;
void setIndex_ensubasta(int valor) throws RemoteException;
int getIndex_ensubasta() throws RemoteException;
void setpuja_mas_alta(int valor) throws RemoteException;
int getpuja_mas_alta() throws RemoteException;
void informa_compradores(String s) throws RemoteException;
String get_articulosubasta()throws RemoteException;
}
