
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
	    System.out.println("Si la subasta ha finalizado escriba una palabra");

            String apodo = args[2];
try{
            	InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                String s; 
		String s2;
                int i;
		int j;
                while ((s = br.readLine()) != null)
                {
                i = Integer.parseInt(s);
                if (i==1)
                {
                	srv.ver_articulos(c,apodo);
                }
                else if (i==2)
                {
			c.setEn_Subasta(1);
                	System.out.println("Bienvenido a la subasta, actualmente se está subastantando " + srv.get_articulosubasta()+" por una cantidad de "+srv.getpuja_mas_alta()+" si esta interesado introduzca una cantidad"+"\n");
InputStreamReader isrr = new InputStreamReader(System.in);
                BufferedReader brr = new BufferedReader(isrr);
		while ((s2 = brr.readLine()) != null || s2!="salir")
                {		  
	    j = Integer.parseInt(s2);
         if (j<srv.getpuja_mas_alta())
		System.out.println("Puja más baja que la actual, debe pujar superando "+srv.getpuja_mas_alta());
else
                	srv.comprar(c,j);
			
                }}
                else if (i==3)
                {
                	System.out.println("Saliendo..");
			isr.close();
                    srv.baja(c);
                    System.exit(0);
                }
                else
                {
                	System.out.println("Opcion no valida");
			srv.ver_articulos(c,apodo);
                }
                }
                isr.close();
                srv.baja(c);
                System.exit(0);
                
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
catch (NumberFormatException nfe)
{
                System.err.println("Saliendo de la subasta...");
		srv.baja(c);
		System.exit(0);
		}}
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        catch (Exception e) {
            System.err.println("Excepcion en ClienteChat:");
            e.printStackTrace();
        }
        
     }
}
