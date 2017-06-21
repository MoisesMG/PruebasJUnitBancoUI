package iubanco.TestSuite.TestCase_Unidad;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import iubanco.RegistroCuentasAccesoAleatorio;

/**
 * 
 * @author Moises Mena
 *
 */
public class ProcesadorTransaccionesTest {
	RandomAccessFile file;
	static String rutaAcceso;
	static int numeroCuenta;
	static String primerNombre;
	static String apellidoPaterno;
	static double saldo;
	
	@BeforeClass
	public static void inicializarVariables(){
		numeroCuenta = 20;
		primerNombre = "Moises";
		apellidoPaterno = "Gonzalez";
		saldo = 200;
		rutaAcceso = "C:\\Users\\Maxwell\\Documents\\UCA_8C"
				+"\\Validacion y mantenimiento de software\\IUBanco\\aleatorio.txt";
	}//fin metodo
	
	@Before
	public void abrirArchivo() throws FileNotFoundException{
		file = new RandomAccessFile(rutaAcceso, "rw");
		System.out.println("Archivo abierto");
	}//fin metodo
	
	@Test
	public void pruebaAccionNuevoRegistro() throws IOException, IllegalArgumentException{
		//varibales temporales 
		int numeroCuentaTemp;
		String primerNombreTemp;
		String apellidoPaternoTemp;
		double saldoTemp;
		StringBuffer buffer = null;
		
		//TODO insertar registro
		file.seek((numeroCuenta -1) * RegistroCuentasAccesoAleatorio.TAMANIO);
		file.writeInt(numeroCuenta);
		
		buffer = new StringBuffer(primerNombre);
		buffer.setLength(15);
		file.writeChars(buffer.toString());
		
		buffer = new StringBuffer(apellidoPaterno);
		buffer.setLength(15);
		file.writeChars(buffer.toString());
		
		file.writeDouble(saldo);
		
		//TODO leer el ultimo registro
		file.seek((numeroCuenta -1) * RegistroCuentasAccesoAleatorio.TAMANIO);
		numeroCuentaTemp = file.readInt();
		primerNombreTemp = leerCadena(file);
		apellidoPaternoTemp = leerCadena(file);
		saldoTemp = file.readDouble();
		
		System.out.println("datos ingresados: " + numeroCuenta + ", "
					+ primerNombre + ", " + apellidoPaterno + ", "
					+ saldo);
		System.out.println("datos en el archivo: "  + numeroCuentaTemp + ", "
					+ primerNombreTemp + ", " + apellidoPaternoTemp + ", "
					+ saldoTemp);
		
		//TODO comparar variables en memoria con las del archivo
		assertTrue(numeroCuentaTemp == numeroCuenta);
	}//fin metodo
	
	@After
	public void cerrarArchivo() throws IOException{
		if(file != null)
			file.close();
		System.out.println("se acaba de cerrar el archivo");
	}//fin metodo
	
	private String leerCadena( RandomAccessFile file ) throws IOException
	   {
	      char nombre[] = new char[ 15 ], temp;

	      for ( int cuenta = 0; cuenta < nombre.length; cuenta++ ) {
	         temp = file.readChar();
	         nombre[ cuenta ] = temp;
	      }     
	      
	      return new String( nombre ).replace( '\0', ' ' );
	   }

}//fin clase
