package ga.telas;

import ga.telas.JPanelArredondado;
import ga.telas.main;
import ga.db.logar;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class login extends JFrame {
	
	main painelprincipal = new main();
	logar logar = new logar();
	private JPanel contentPane;
	private JPasswordField pf_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public login() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
		
		JLabel lb_Titulo = new JLabel("Sistema de Gestão Aeroportuário");
		lb_Titulo.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lb_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Titulo.setBounds(6, 22, 564, 43);
		contentPane.add(lb_Titulo);
		
		JPanelArredondado panel_login = new JPanelArredondado();
		panel_login.setBackground(new Color(254, 255, 255));
        panel_login.setBounds(191, 77, 200, 245);
        panel_login.setRaioArredondamento(20);
        contentPane.add(panel_login);
        panel_login.setLayout(null);
        
        JLabel lb_Acesso = new JLabel("Acesso");
        lb_Acesso.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lb_Acesso.setHorizontalAlignment(SwingConstants.CENTER);
        lb_Acesso.setBounds(6, 18, 188, 16);
        panel_login.add(lb_Acesso);
        
        JLabel lb_CPF = new JLabel("CPF");
        lb_CPF.setHorizontalAlignment(SwingConstants.CENTER);
        lb_CPF.setBounds(6, 61, 188, 16);
        panel_login.add(lb_CPF);
        
        JFormattedTextField ftf_CPF = new JFormattedTextField(mascaraCPF);
        ftf_CPF.setBounds(16, 89, 167, 26);
        panel_login.add(ftf_CPF);
        
        JLabel lb_Senha = new JLabel("Senha");
        lb_Senha.setHorizontalAlignment(SwingConstants.CENTER);
        lb_Senha.setBounds(6, 127, 188, 16);
        panel_login.add(lb_Senha);
        
        pf_Senha = new JPasswordField();
        pf_Senha.setBounds(16, 155, 167, 26);
        panel_login.add(pf_Senha);
        
        JButton bt_Entrar = new JButton("Entrar");
        bt_Entrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpf = ftf_CPF.getText();
				char[] senha = pf_Senha.getPassword();
        		 
        		boolean loginSucesso = logar.fazerLogin(cpf, senha);
        		if (loginSucesso) {
        			//SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
        			dispose();
        			painelprincipal.main(null);
        		}
        	}
        });
        bt_Entrar.setBounds(42, 193, 117, 29);
        panel_login.add(bt_Entrar);
        
        
	}
}
