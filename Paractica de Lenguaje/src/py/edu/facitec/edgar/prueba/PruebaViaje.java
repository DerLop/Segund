package py.edu.facitec.edgar.prueba;

import java.math.BigDecimal;
import java.util.Date;

import javax.swing.JOptionPane;

import py.edu.facitec.edgar.movimiento.Viaje;

public class PruebaViaje {
	
	private Viaje viaje= new Viaje();
	
	public void cargar(){
		viaje.setTotal(new BigDecimal( JOptionPane.showInputDialog("Ingrese el total del viaje")));
		viaje.getPasaje().setPrecio(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrse el preio del pasaje")));
		viaje.getPasaje().getTurista().setNombre(JOptionPane.showInputDialog("Ingrse el nombre del turista"));
		viaje.getPasaje().getTurista().setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del turista")));
		viaje.getPasaje().getTurista().setFechaNacimiento(new Date(JOptionPane.showInputDialog("Ingrese la fecha e nacimiento" )));
		}
	public void imprimir(){
		viaje.toString();
		
		
	}
	public static void main(String[] args) {
		
	}

}
