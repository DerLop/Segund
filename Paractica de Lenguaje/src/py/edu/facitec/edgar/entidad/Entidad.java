package py.edu.facitec.edgar.entidad;

public abstract class Entidad {
	private Integer codigo;
	
	
	 public Entidad(){
		 codigo=0;
	 }
	 
	 
	 public abstract Integer obtenerCodigo();


	public Entidad(Integer codigo) {
		super();
		this.codigo = codigo;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "Entidad [codigo=" + codigo + ", toString()=" + super.toString() + "]";
	}
	 
	 

}
