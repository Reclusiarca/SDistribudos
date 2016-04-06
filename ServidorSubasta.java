import java.rmi.*;
import java.rmi.server.*;

class ServidorSubasta  {
    static public void main (String args[]) {
       if (args.length!=1) {
            System.err.println("Uso: ServidorSubasta numPuertoRegistro");
            return;
        }
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            FabricaArticulosImpl srv = new FabricaArticulosImpl();	
            Naming.rebind("rmi://localhost:" + args[0] + "/FabricaArticulo", srv);
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
