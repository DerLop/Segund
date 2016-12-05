package py.edu.facitec.examen_parcial_ii.presentacion;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import py.edu.facitec.examen_parcial_ii.modelo.Cliente;

public class ModeloTablaCliente extends AbstractTableModel{
	
	private String[] columnas = {
			"ID", "NOMBRE", "DOCUMENTO", "ACTIVO"
	};
	private Object[][] datos = new Object[0][columnas.length];
	
	public void setLista(List<Cliente> lista) {
		datos = new Object[lista.size()][columnas.length];
		for (int i = 0; i < lista.size(); i++) {
			datos[i][0] = lista.get(i).getId();
			datos[i][1] = lista.get(i).getNombre();
			datos[i][2] = lista.get(i).getDocumento();
			datos[i][3] = lista.get(i).isEstado();
		}
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}
	
	@Override
	public String getColumnName(int i) {
		return columnas[i];
	}

	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public Object getValueAt(int f, int c) {
		return datos[f][c];
	}
}
