
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class CompradorImpl extends UnicastRemoteObject implements Comprador {
 int en_subasta=0;// Esta variable nos servira de bandera y valdra uno cuando el comprador este siguiendo la subasta
	CompradorImpl() throws RemoteException {
    }
	//Este metodo permitira al cliente ver la lista de articulos y es llamado por el ServidorImpl
    public void enseña_articulos(String apodo, List<String> m) throws RemoteException {
	System.out.println("\n" +"Señor/Señora "+ apodo +" la lista de articulos en subasta es la siguiente:"+"\n");
	for(int x=0;x<m.size();x++) {
		  System.out.println(m.get(x)+"\n");
		}
System.out.println("¿Qué desea hacer ahora?");
            System.out.println("Introduzca 1 si desea ver los artículos en subasta de nuevo");
            System.out.println("Introduzca 2 si desea pujar por un artículo");
            System.out.println("Introduzca 3 si desea salir");
    }
 public void setEn_Subasta(int comprando) throws RemoteException
    {
    	this.en_subasta=comprando;
    }
public void informa_compradores(String mensaje) throws RemoteException
{
System.out.println(mensaje);
}
public int getEstoy_subasta() throws RemoteException
{
return this.en_subasta;
}


public void informa_compradores_salida() throws RemoteException
{
    //metodo que avisa al comprador de que la subasta ha acabado
System.out.println("¡ SUBASTA ACABADA, introduce una letra para salir !");
}
}
