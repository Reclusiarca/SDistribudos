
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class ServicioSubastaImpl extends UnicastRemoteObject implements ServicioSubasta {
 List<Comprador> l;
    String articulo1="Articulo 1: Las meninas";
    String articulo2="Articulo 2: Joyas de la Reina Isabel";
    String articulo3="Articulo 3: Ferrari";
List<String> articulos;
    ServicioSubastaImpl() throws RemoteException {
	articulos=Arrays.asList(articulo1,articulo2,articulo3);
        l = new LinkedList<Comprador>(); 
        articulos = new LinkedList<String>();
    }
    //Metodo que se ejecuta cada vez que entre un Comprador en la subasta
    public void alta(Comprador c) throws RemoteException {
	l.add(c);
    }
    //Metodo que se ejecutara cada vez que salga un comprador de la subasta
    public void baja(Comprador c) throws RemoteException {
	l.remove(l.indexOf(c));
    }
    public void ver_articulos(Comprador esc, String apodo)
	throws RemoteException {
                esc.enseña_articulos(apodo, articulos);
    }
    public void comprar(Comprador e, Integer cantidad ) throws RemoteException
    {
    	
    }

}
