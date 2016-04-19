import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class ClienteLog {
    static public void main (String args[]) {
        if (args.length!=6) {
            System.err.println("Uso: ClienteLog hostregistro numPuertoRegistro nombreArchivo  nombre" );
            return;
        }

       if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        try {
            FabricaLog srv = (FabricaLog) Naming.lookup("//" + args[0] + ":" + args[1] + "/FabricaApuestas");
	   

 /*       Log algo = new Log(args[2],args[3]);
	    ServicioLog c = srv.crearLog(algo);
	    c.log(" " + i + " "+ args[3] );
        
	    */
	    Runtime.getRuntime().exec(clear);
	    system.out.printl("Sistema de susbastas RMI ");
	    /*
 se imprimen todos los objetos de la subasta y  se preegunta por que articulo 
	    */
	    system.out.printl(" Introduce que elemento quiere consultar ");
	

    // Se introduce el articulo 
	    /*
  Se abre el siguiente menu con las opciones:
  system.out.printl(" El articulo seleccionado es el X  ");
  system.out.printl(" 1) Consultar apuesta mas alta ");
  system.out.printl(" 2) Historico de apuestas  ");
	     */	  
	   	   
	List <ServicioLog> lista;
	lista=srv.obtenerLogs();
	//opcion 1 //pero con el metodo para el maximo 
	Log ele2 = i.obtenerLog();
	

	//Opcion 2
	for(ServicioLog i: lista ){
	    Log ele2 = i.obtenerLog();
	    System.out.println(ele2 +":  " + i.obtenerFecha());
	}

	}
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        catch (Exception e) {
            System.err.println("Excepcion en ClienteBanco:");
            e.printStackTrace();
        }
    }
}
