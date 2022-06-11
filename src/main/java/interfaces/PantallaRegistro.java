package interfaces;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Usuario;
import elementosVisuales.BotonesInicio;
import enums.Pais;
import exceptions.AñoInvalidoException;
import exceptions.ContraseñaVaciaException;
import exceptions.EmailValidoException;
import interfaces.Ventana;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoEmail;
	private JTextField campoUsuario;
	private JTextField campoFechaNacimiento;
	private JPasswordField campoContraseña;

	public PantallaRegistro(Ventana v) {
		setBackground(Color.DARK_GRAY);
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 101, 0, 92, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
				
				JLabel icono = new JLabel("");
				icono.setIcon(new ImageIcon("./imagenes/Akatsuki-Logo-Pequeno.png"));
				GridBagConstraints gbc_icono = new GridBagConstraints();
				gbc_icono.insets = new Insets(0, 0, 5, 5);
				gbc_icono.gridx = 0;
				gbc_icono.gridy = 0;
				add(icono, gbc_icono);
				
				JButton botonAtras = new JButton("\u27A1");
				GridBagConstraints gbc_botonAtras = new GridBagConstraints();
				gbc_botonAtras.gridwidth = 3;
				gbc_botonAtras.insets = new Insets(0, 0, 5, 5);
				gbc_botonAtras.anchor = GridBagConstraints.EAST;
				gbc_botonAtras.gridx = 5;
				gbc_botonAtras.gridy = 0;
				add(botonAtras, gbc_botonAtras);
				
				botonAtras.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ventana.cambiarAPantalla("inicio");
					}
				});
		
				JLabel labelTitulo = new JLabel("Registro");
				labelTitulo.setForeground(Color.RED);
				labelTitulo.setFont(new Font("Liberation Mono", Font.BOLD, 35));
				GridBagConstraints gbc_labelTitulo = new GridBagConstraints();
				gbc_labelTitulo.gridwidth = 9;
				gbc_labelTitulo.insets = new Insets(0, 0, 5, 0);
				gbc_labelTitulo.gridx = 0;
				gbc_labelTitulo.gridy = 1;
				add(labelTitulo, gbc_labelTitulo);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelEmail.setForeground(Color.RED);
		labelEmail.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 2;
		gbc_labelEmail.gridy = 2;
		add(labelEmail, gbc_labelEmail);

		campoEmail = new JTextField();
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.gridwidth = 2;
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.gridx = 3;
		gbc_campoEmail.gridy = 2;
		add(campoEmail, gbc_campoEmail);
		campoEmail.setColumns(10);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelUsuario.setForeground(Color.RED);
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.anchor = GridBagConstraints.WEST;
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 2;
		gbc_labelUsuario.gridy = 3;
		add(labelUsuario, gbc_labelUsuario);

		campoUsuario = new JTextField();
		GridBagConstraints gbc_campoUsuario = new GridBagConstraints();
		gbc_campoUsuario.gridwidth = 2;
		gbc_campoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_campoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoUsuario.gridx = 3;
		gbc_campoUsuario.gridy = 3;
		add(campoUsuario, gbc_campoUsuario);
		campoUsuario.setColumns(10);

		JLabel labelContraseña = new JLabel("Contraseña");
		labelContraseña.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelContraseña.setForeground(Color.RED);
		GridBagConstraints gbc_labelContraseña = new GridBagConstraints();
		gbc_labelContraseña.anchor = GridBagConstraints.WEST;
		gbc_labelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseña.gridx = 2;
		gbc_labelContraseña.gridy = 4;
		add(labelContraseña, gbc_labelContraseña);

		campoContraseña = new JPasswordField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.gridwidth = 2;
		gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.gridx = 3;
		gbc_campoContraseña.gridy = 4;
		add(campoContraseña, gbc_campoContraseña);

		JLabel labelFechaNacimiento = new JLabel("FechaNacimiento");
		labelFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelFechaNacimiento.setForeground(Color.RED);
		GridBagConstraints gbc_labelFechaNacimiento = new GridBagConstraints();
		gbc_labelFechaNacimiento.anchor = GridBagConstraints.WEST;
		gbc_labelFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_labelFechaNacimiento.gridx = 2;
		gbc_labelFechaNacimiento.gridy = 5;
		add(labelFechaNacimiento, gbc_labelFechaNacimiento);

		campoFechaNacimiento = new JTextField();
		GridBagConstraints gbc_campoFechaNacimiento = new GridBagConstraints();
		gbc_campoFechaNacimiento.gridwidth = 2;
		gbc_campoFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_campoFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoFechaNacimiento.gridx = 3;
		gbc_campoFechaNacimiento.gridy = 5;
		add(campoFechaNacimiento, gbc_campoFechaNacimiento);
		campoFechaNacimiento.setColumns(10);

		JLabel labelGenero = new JLabel("Genero");
		labelGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelGenero.setForeground(Color.RED);
		GridBagConstraints gbc_labelGenero = new GridBagConstraints();
		gbc_labelGenero.anchor = GridBagConstraints.WEST;
		gbc_labelGenero.insets = new Insets(0, 0, 5, 5);
		gbc_labelGenero.gridx = 2;
		gbc_labelGenero.gridy = 6;
		add(labelGenero, gbc_labelGenero);

		final JRadioButton generoHombre = new JRadioButton("Hombre");
		GridBagConstraints gbc_generoHombre = new GridBagConstraints();
		gbc_generoHombre.insets = new Insets(0, 0, 5, 5);
		gbc_generoHombre.gridx = 3;
		gbc_generoHombre.gridy = 6;
		add(generoHombre, gbc_generoHombre);

		final JRadioButton generoMujer = new JRadioButton("Mujer");
		GridBagConstraints gbc_generoMujer = new GridBagConstraints();
		gbc_generoMujer.insets = new Insets(0, 0, 5, 5);
		gbc_generoMujer.gridx = 4;
		gbc_generoMujer.gridy = 6;
		add(generoMujer, gbc_generoMujer);

		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(generoHombre);
		grupoGenero.add(generoMujer);

		JLabel labelLocalizacion = new JLabel("Localización");
		labelLocalizacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelLocalizacion.setForeground(Color.RED);
		labelLocalizacion.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_labelLocalizacion = new GridBagConstraints();
		gbc_labelLocalizacion.insets = new Insets(0, 0, 5, 5);
		gbc_labelLocalizacion.anchor = GridBagConstraints.WEST;
		gbc_labelLocalizacion.gridx = 2;
		gbc_labelLocalizacion.gridy = 7;
		add(labelLocalizacion, gbc_labelLocalizacion);

		final JComboBox selectorPais = new JComboBox();
		selectorPais.setModel(new DefaultComboBoxModel(Pais.values()));
		GridBagConstraints gbc_selectorPais = new GridBagConstraints();
		gbc_selectorPais.gridwidth = 2;
		gbc_selectorPais.insets = new Insets(0, 0, 5, 5);
		gbc_selectorPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectorPais.gridx = 3;
		gbc_selectorPais.gridy = 7;
		add(selectorPais, gbc_selectorPais);

		JButton botonRegistro = new BotonesInicio("Registrarse");

		GridBagConstraints gbc_botonRegistro = new GridBagConstraints();
		gbc_botonRegistro.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonRegistro.gridwidth = 3;
		gbc_botonRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistro.gridx = 2;
		gbc_botonRegistro.gridy = 8;
		add(botonRegistro, gbc_botonRegistro);

		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String email = campoEmail.getText();
					String nombre = campoUsuario.getText();
					String contraseña = new String(campoContraseña.getPassword());
					String fechaEnTexto = campoFechaNacimiento.getText();
					String[] fechaNaciPartida = fechaEnTexto.split("/");
					LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(fechaNaciPartida[2]),
							Integer.parseInt(fechaNaciPartida[1]), Integer.parseInt(fechaNaciPartida[0]));
					String genero=null;
					if(generoHombre.isSelected()) {
						genero="Hombre";
					}else if(generoMujer.isSelected()) {
						genero="Mujer";
					}
					Pais pais = (Pais) selectorPais.getSelectedItem();
					System.out.println(pais);
					if(genero!=null) {
						new Usuario(nombre, email, contraseña, (short) fechaNacimiento.getYear(), fechaNacimiento,
								LocalDateTime.now(), LocalTime.now());
						
						JOptionPane.showMessageDialog(ventana,
								"Registro completado con éxito",
								"Registro completado",JOptionPane.PLAIN_MESSAGE);
						ventana.cambiarAPantalla("login");
					}else {
						JOptionPane.showMessageDialog(ventana,
								"Por favor, selecciona un género","Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (DateTimeException | SQLException
						| ContraseñaVaciaException|
						EmailValidoException | AñoInvalidoException e1) {
					JOptionPane.showMessageDialog(
					ventana,e1.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
					
					//TODO METER EL ERROR DEL SPLIT DE LA CONTRASEÑA
				} catch(ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(ventana,
							"Formato de fecha incorrecto, debe ser dd/MM/YYYY",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
}

