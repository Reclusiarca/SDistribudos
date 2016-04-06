import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

class FabricaArticulosImpl extends UnicastRemoteObject implements FabricaArticulos {
    //creo una Lista de Listas 
    List<List <ServicioArticulos> > list;
    //Creo una lista de pujas 
    List<Pujas> listpujas;
    FabricaArticulosImpl() throws RemoteException {
	list = new LinkedList<ServicioArticulos>();
	listpujas = new LinkedList<ServicioPuja>();
	// bucle que crea de forma automatica 10 objetos sin pujas
	for (int c=1, c< 10 , c++) {
	    listpujas(c) = new LinkedList<ServicioPuja>();
	    // no estoy seguro si se puede hacer esto, mañana le pregunto a teresa(6/4) 
	    ServicioArticulo e = new ServicioArticuloImpl(c,listpujas(c) = new LinkedList<ServicioPuja>(););
	    list.add(e);	    
	}
    }

    public ServicioArticulos crearpuja(int cantidad,int articulo) throws RemoteException {
	// crea la puja y la mete en su lista correspondiente 
	ServicioPuja puja = new ServicioPujaImpl(int cantidad,date Fecha);
	listpujas(articulo).add(puja);
	//aqui hace falta poner la posicion del Articulo para añadir lista actualizada
	list.set(articulo,listpujas(articulo))
	return puja ;
    }


    public List<List<ServicioArticulos>> obtenerArticulos() throws RemoteException{
	return list;
    }
}
