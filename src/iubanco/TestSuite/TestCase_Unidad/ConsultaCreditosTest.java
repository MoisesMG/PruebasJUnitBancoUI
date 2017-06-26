package iubanco.TestSuite.TestCase_Unidad;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class ConsultaCreditosTest {
	private double saldo;
	private String tipoCuenta;
	
	@Test
	public void debeMostrarseTest(){
		/**
		 * la variable saldo debe tomar los valores
		 * 	-1.00
		 * 	1.00
		 * 0
		 * 
		 * La variable tipo cuenta debe tomar los valores
		 * 	Saldos con credito
		 * 	Saldos con debito
		 * 	Saldos en ceros
		 * 	Valor ficticio
		 */
		saldo = 0;
		tipoCuenta = "Valor ficticio";
		try {
			if ( tipoCuenta.equals( "Saldos con credito" ) && saldo < 0 )
		         System.out.println("se recorrio el primer camino");

		      else if ( tipoCuenta.equals( "Saldos con debito" ) && saldo > 0 )
		         System.out.println("Se recorrio el segundo camino");

		      else if ( tipoCuenta.equals( "Saldos en ceros" ) && saldo == 0 )
		         System.out.println("Se recorrio el tercer camino");
		      else
		    	  System.out.println("No se recorrio nungun camino");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//fin metodo
	
}//fin clase
