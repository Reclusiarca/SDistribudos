
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class CompradorImpl extends UnicastRemoteObject implements Comprador {
 
	CompradorImpl() throws RemoteException {
    }
	//Este metodo permitira al cliente ver la lista de articulos y es llamado por el ServidorImpl
    public void enseña_articulos(String apodo, List<String> m) throws RemoteException {
	System.out.println("\n" +"Señor/Señora "+ apodo +" la lista de articulos es:"+"\n");
	for (String c: m) 
	{
		System.out.println(c+"\n");
	}
	
    }
}
