
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.*;

class CompradorSubasta {
    static public void main (String args[]) {
        if (args.length!=3) {
            System.err.println("Uso: CompradorSubasta hostregistro numPuertoRegistro nombrecomprador");
            return;
        }

       if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        try {

            ServicioSubasta srv = (ServicioSubasta) Naming.lookup("//" + args[0] + ":" + args[1] + "/Subasta");
            CompradorImpl c = new CompradorImpl();
            srv.alta(c);//Nos damos de alta en el servicio
            //Preguntamos al cliente qué desea hacer
            System.out.println("\n"+"¡Enhorabuena! Se ha unido usted a la subasta. Indiquenos que desea hacer:\n");
            System.out.println("Introduzca 1 si desea ver los artículos en subasta");
            System.out.println("Introduzca 2 si desea pujar por un artículo");
            System.out.println("Introduzca 3 si desea salir");
            Scanner ent = new Scanner(System.in);
            String apodo = args[2];
            System.out.print(apodo + "> ");
            while (ent.hasNextLine()) {
            	if (ent.nextLine().compareTo("1")==0)
            	{
            		srv.ver_articulos(c,apodo);
            	}
            	else if(ent.nextLine().compareTo("2")==0)
            	{
            		System.out.println("2º Servicio");
            	}
            }
            srv.baja(c);
            System.exit(0);
            }
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        catch (Exception e) {
            System.err.println("Excepcion en ClienteChat:");
            e.printStackTrace();
        }
        
     }
}
