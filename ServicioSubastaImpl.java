
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

class ServicioSubastaImpl extends UnicastRemoteObject implements ServicioSubasta {
 List<Comprador> l;
 List<String> articulos;
 int index_ensubasta=0; //Último artículo que se ha vendido se usa para llevar el control de qué artículo se esta vendiendo en este momento
 String articulo1="Articulo 1: Las meninas";
 String articulo2="Articulo 2: Joyas de la Reina Isabel";
 String articulo3="Articulo 3: Ferrari";
int puja_mas_alta; //La puja mas alta que se ha dado

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
 //Metodo que se ejecutara antes de finalizar la subasta para dar de baja a todos los usuarios
    public void bajatodos() throws RemoteException {
	int tam=l.size();
	for (int aux=0 ; aux < tam;aux++)
	    {
	Comprador c = l.get(aux);
	c.informa_compradores_salida();
	}
    }
    //metodo para que el servidor no se cierre hasta que todos los usuarios se marchen
    public boolean finalizar() throws RemoteException {

	return l.isEmpty();
    }

    //Metodo que se ejecutara cuando el comprador desee ver los articulos en subasta
    //Argumentos: Comprador que desea ver los articulos y el apodo del mismo	
    public void ver_articulos(Comprador c, String apodo)
	throws RemoteException {
                c.enseña_articulos(apodo, articulos);
    }
    public void comprar(Comprador c, Integer cantidad ) throws RemoteException
    {
	StringBuilder sb = new StringBuilder();
	sb.append("Acaba de pujar por el articulo ");
	sb.append(articulos.get(index_ensubasta));
	sb.append(" permanezca a la espera o escriba salir para salir al menu");
	String mensaje = sb.toString();	
	c.informa_compradores(mensaje);
    	setpuja_mas_alta(cantidad);
    }
    //Metodo que permitirá al servidor ver los articulos disponibles hoy en subasta para comenzarla
    public List<String> que_vendemos()throws RemoteException{
		return this.articulos;
}
public int comienza_subasta(int indexarti,int tiemposeg, int cantidadini) throws RemoteException{
	 int segundos_finalizar_venta=tiemposeg;//Si esta variable llega a 0 se finaliza la venta
	 int ultima_puja=cantidadini; //Aqui asignamos la ultima puja recibida por el articulo
	
	setpuja_mas_alta(cantidadini); //Empezamos la puja con la cantidad inicial 
		System.out.println("Comienza la subasta del articulo "+articulos.get(indexarti)+ " 	con una puja inicial de "+cantidadini);
	System.out.println("¿Quien da mas?");
for (Comprador c: l) {
	    if (c.getEstoy_subasta()==1){
		StringBuilder sb = new StringBuilder();
	sb.append("Comienza la subasta del articulo ");
	sb.append(articulos.get(indexarti));
	sb.append(" con una puja inicial de ");
	sb.append(cantidadini);
	String mensaje1 = sb.toString();
	String mensaje2="¿Quien da mas?";
	c.informa_compradores(mensaje1);
	c.informa_compradores(mensaje2);
}}
while(segundos_finalizar_venta!=0)
{
	try {
    Thread.sleep(1000);                //Esto actuará como contador y esperará 1 segundo por lo que aproximadamente cada entrada en el while será de un segundo
	   
	if(ultima_puja!=getpuja_mas_alta()) //Si alguien ha superado la puja inicial..
	{
	for (Comprador c: l) {
	    if (c.getEstoy_subasta()==1){
		StringBuilder sbu = new StringBuilder();
	sbu.append("Nueva puja por ");
	sbu.append(getpuja_mas_alta());
	String mensaje3 = sbu.toString();
	String mensaje4="¿Alguien da mas?";
	c.informa_compradores(mensaje3);
	c.informa_compradores(mensaje4);
}}
	System.out.println("Nueva puja por "+getpuja_mas_alta());
	System.out.println("¿Alguien da mas?");
	ultima_puja=getpuja_mas_alta(); // Actualizamos la variable local de ultima puja 
	segundos_finalizar_venta=30; // El contador empezará a contar de nuevo
	}
    else {
	segundos_finalizar_venta--; //Si nadie ha pujado se le restará un segundo al contador
	}
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
}
// Comprabacion para saber si alguien ha pujado y segun el if avisa o no de la ultima puja y empieza la siguiente
if( ultima_puja == 200 )
    {
	System.out.println("¡ Nadie ha pujado por este articulo !"); 
    }
else{
System.out.println("¡"+articulos.get(indexarti)+" adjudicado por " + ultima_puja + "euros!"); 
}
setIndex_ensubasta(indexarti+1); //Actualizamos la variable para pasar al siguiente articulo
return 0;
    }

public String get_articulosubasta()throws RemoteException
{
return this.articulos.get(index_ensubasta);
}
public int getIndex_ensubasta() throws RemoteException
{
	return this.index_ensubasta;
}
public void setIndex_ensubasta(int valor) throws RemoteException
{
	this.index_ensubasta=valor;
}
public void setpuja_mas_alta(int valor) throws RemoteException
{
	this.puja_mas_alta=valor;
}
public int getpuja_mas_alta() throws RemoteException
{
	return this.puja_mas_alta;
}
public void informa_compradores(String s) throws RemoteException
{

}
}
