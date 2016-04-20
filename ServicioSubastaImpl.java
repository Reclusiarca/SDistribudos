
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class ServicioSubastaImpl extends UnicastRemoteObject implements ServicioSubasta {
 List<Comprador> l;
 List<String> articulos;
    String articulo1="Articulo 1: Las meninas";
    String articulo2="Articulo 2: Joyas de la Reina Isabel";
    String articulo3="Articulo 3: Ferrari";

    ServicioSubastaImpl() throws RemoteException {
        l = new LinkedList<Comprador>(); 
        articulos = new LinkedList<String>();
	articulos.add(articulo1);
	articulos.add(articulo2);
	articulos.add(articulo3);
    }
    //Metodo que se ejecuta cada vez que entre un Comprador en la subasta
    public void alta(Comprador c) throws RemoteException {
	l.add(c);
    }
    //Metodo que se ejecutara cada vez que salga un comprador de la subasta
    public void baja(Comprador c) throws RemoteException {
	l.remove(l.indexOf(c));
    }
    //Metodo que se ejecutara cuando el comprador desee ver los articulos en subasta	
    public void ver_articulos(Comprador c, String apodo)
	throws RemoteException {
                c.enseña_articulos(apodo, articulos);
    }
    public void comprar(Comprador e, Integer cantidad ) throws RemoteException
    {
    	
    }
    //Metodo que permitirá al servidor ver los articulos disponibles hoy en subasta para comenzarla
    public List<String> que_vendemos()throws RemoteException{
		return this.articulos;
}
}
