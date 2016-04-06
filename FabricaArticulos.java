import java.rmi.*;
import java.util.*;

interface FabricaArticulos extends Remote {
    ServicioPuja crearpuja(int cantidad,date Fecha) throws RemoteException;
    List<List<ServicioArticulos>> obtenerArticulos() throws RemoteException;

}

