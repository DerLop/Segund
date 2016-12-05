package py.edu.facitec.edgar.entidad;

import java.util.List;

public class TarjetaDeCredito {
	
	private String empresa;
	private double monto;
	
	
	
	public TarjetaDeCredito(){
		empresa="";
		monto=0;
		
	}



	public TarjetaDeCredito(String empresa, double monto) {
		super();
		this.empresa = empresa;
		this.monto = monto;
	}



	public String getEmpresa() {
		return empresa;
	}



	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}



	public double getMonto() {
		return monto;
	}



	public void setMonto(double monto) {
		this.monto = monto;
	}



	@Override
	public String toString() {
		return "TarjetaDeCredito [empresa=" + empresa + ", monto=" + monto + ", toString()=" + super.toString() + "]";
	}
	
	

}
