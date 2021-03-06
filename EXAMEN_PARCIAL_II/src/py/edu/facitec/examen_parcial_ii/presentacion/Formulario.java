package py.edu.facitec.examen_parcial_ii.presentacion;

import java.awt.EventQueue;
import java.util.List;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import py.edu.facitec.examen_parcial_ii.buscadores.BuscadorCliente;
import py.edu.facitec.examen_parcial_ii.dao.ClienteDao;
import py.edu.facitec.examen_parcial_ii.interfaces.InterfazBuscadorClientes;
import py.edu.facitec.examen_parcial_ii.modelo.Cliente;
import py.edu.facitec.examen_parcial_ii.util.Factory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JDialog implements InterfazBuscadorClientes{
	private JTextField tfCliente;
	private Cliente cliente;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Factory.setUp();
				
				ClienteDao dao = new ClienteDao();
				List<Cliente> clientes = dao.recuperarTodo();
				Cliente c;
				if (clientes.size() == 0) {
					for (int i = 1; i <= 10; i++) {
						dao = new ClienteDao();
						c = new Cliente();
						c.setNombre("Cliente "+i);
						c.setDocumento(i+"");
						c.setEstado(true);
						dao.insertarOModificar(c);
						try {
							dao.ejecutar();
						} catch (Exception e) {
							dao.cancelar();
						}
					}
				}
				try {							
					Formulario dialog = new Formulario();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Formulario() {
		setBounds(100, 100, 626, 292);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCliente.setBounds(28, 57, 46, 14);
		getContentPane().add(lblCliente);
		
		tfCliente = new JTextField();
		tfCliente.setBounds(85, 54, 214, 20);
		getContentPane().add(tfCliente);
		tfCliente.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirBuscadorCliente();
			}

			
		});
		btnBuscarCliente.setBounds(321, 53, 89, 23);
		getContentPane().add(btnBuscarCliente);

	}

	@Override
	public void setCliente(Cliente cliente) {
		tfCliente.setText(cliente.getNombre());
		this.cliente = cliente;
		
		
	}
	private void abrirBuscadorCliente() {
		BuscadorCliente fBuscadorCliente =  new BuscadorCliente();
		fBuscadorCliente.setInterfaz(this);
		fBuscadorCliente.setVisible(true);
		
	}
}
