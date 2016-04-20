
import java.rmi.*;
import java.util.List;

class ServidorSubasta  {
    static public void main (String args[]) {
	List<String> articulos_subasta;// Aqui almacenaremos los articulos que vamos a subastar
	int i;//Variable para recorrer los artículos a subastar
	int index=0; //Indice del articulo que se está vendiendo en ese momento 
       if (args.length!=1) {
            System.err.println("Uso: ServidorSubasta numPuertoRegistro");
            return;
        }
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            ServicioSubastaImpl srv = new ServicioSubastaImpl();
            Naming.rebind("rmi://localhost:" + args[0] + "/Subasta", srv);
	    articulos_subasta= srv.que_vendemos(); //Ahora ya sabemos los articulos para iniciar la subasta
	    i=articulos_subasta.size();		
            while(i>0)
            {
		//Aqui llamamos al hilo subasta 
            	i--;
            } 		        
	}
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        }
        catch (Exception e) {
            System.err.println("Excepcion en ServidorSubasta:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
