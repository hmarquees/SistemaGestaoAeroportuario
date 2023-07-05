package ga.telas;


import ga.db.cadastrar;
import ga.db.conexao;
import ga.db.atualizar;
import ga.db.excluir;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLayeredPane;

public class main extends JFrame {
	
	cadastrar cadastrar = new cadastrar();
	static atualizar atualizar = new atualizar();
	static excluir excluir = new excluir();

	private JPanel contentPane;
	private JPanel Painel_Consulta_Aeroporto;
	private JPanel Painel_Aeroporto_Cadastro;
	private JPanel Painel_Aviao_Cadastro;
	private JPanel Painel_Consulta_Aviao;
	private JPanel Painel_Voo_Cadastro;
	private JPanel Painel_Consulta_Voo;
	private JPanel Painel_Companhia_Cadastro;
	private JPanel Painel_Consulta_Companhia;
	private JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
					frame.setTitle("Sistema de Gestão Aeroportuária");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238,238,238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		JLabel lbl_Titulo = new JLabel("SISTEMA DE GESTÃO AEROPORTUÁRIA");
		lbl_Titulo.setForeground(new Color(0, 0, 0));
		lbl_Titulo.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lbl_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Titulo.setBounds(6, 6, 721, 47);
		contentPane.add(lbl_Titulo);
		*/
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 30, 730, 430);
		contentPane.add(layeredPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(94, 94, 94));
		menuBar.setBounds(0, 0, 730, 30);
		contentPane.add(menuBar);
		
		JMenu mnAeroportos = new JMenu("Aeroportos");
		mnAeroportos.setForeground(new Color(254, 255, 255));
		mnAeroportos.setBackground(new Color(66, 66, 66));
		menuBar.add(mnAeroportos);
		
		JMenuItem mntmCadastroAeroporto = new JMenuItem("Cadastro");
		mntmCadastroAeroporto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				try {
					cadastroaeroporto();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnAeroportos.add(mntmCadastroAeroporto);
		
		JMenuItem mntmConsultaAeroporto = new JMenuItem("Consulta");
		mntmConsultaAeroporto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				consultaaeroporto();
			}
		});
		mnAeroportos.add(mntmConsultaAeroporto);
		
		JMenu mnAvioes = new JMenu("Aviões");
		menuBar.add(mnAvioes);
		
		JMenuItem mntmCadastroAvioes = new JMenuItem("Cadastro");
		mntmCadastroAvioes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				cadastroaviao();
			}
		});
		mnAvioes.add(mntmCadastroAvioes);
		
		JMenuItem mntmConsultaAvioes = new JMenuItem("Consulta");
		mntmConsultaAvioes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				consultaaviao();
			}
		});
		mnAvioes.add(mntmConsultaAvioes);
		
		JMenu mnCompanhias = new JMenu("Companhias");
		menuBar.add(mnCompanhias);
		
		JMenuItem mntm_CadastroCompanhia = new JMenuItem("Cadastro");
		mntm_CadastroCompanhia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				try {
					cadastrocompanhia();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnCompanhias.add(mntm_CadastroCompanhia);
		
		JMenuItem mntmConsultaCompanhia = new JMenuItem("Consulta");
		mntmConsultaCompanhia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				consultacompanhia();
			}
		});
		mnCompanhias.add(mntmConsultaCompanhia);
		
		JMenu mnVoos = new JMenu("Voos");
		menuBar.add(mnVoos);
		
		JMenuItem mntm_CadastroVoos = new JMenuItem("Cadastro");
		mntm_CadastroVoos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				try {
					cadastrovoo();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnVoos.add(mntm_CadastroVoos);
		
		JMenuItem mntm_ConsultaVoo = new JMenuItem("Consulta");
		mntm_ConsultaVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				consultavoo();
			}
		});
		mnVoos.add(mntm_ConsultaVoo);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenu mnPassagens = new JMenu("Passagens");
		menuBar.add(mnPassagens);
	}

	
	private void consultaaeroporto() {
		
		Painel_Consulta_Aeroporto = new JPanel();
		layeredPane.setLayer(Painel_Consulta_Aeroporto, 0);
		Painel_Consulta_Aeroporto.setBackground(new Color(238,238,238));
		Painel_Consulta_Aeroporto.setBounds(0, 0, 730, 430);
		layeredPane.add(Painel_Consulta_Aeroporto);
		
		JTable table_aeroportos = new JTable();											// cria um JTable
		table_aeroportos.setBackground(new Color(238,238,238));						// define a cor de fundo do JTable
		table_aeroportos.setBounds(6, 238, 638, -233);
		DefaultTableModel model = (DefaultTableModel) table_aeroportos.getModel();		//
		model.addColumn("Código");														// adiciona a coluna 0
		model.addColumn("Nome");														// adiciona a coluna 1
		model.addColumn("Cidade");														// adiciona a coluna 2
		model.addColumn("Estado");														// adiciona a coluna 3
		table_aeroportos.getColumnModel().getColumn(0).setPreferredWidth(50);			// define a largura da coluna 0
		table_aeroportos.getColumnModel().getColumn(1).setPreferredWidth(400);			// define a largura da coluna 1
		table_aeroportos.getColumnModel().getColumn(2).setPreferredWidth(150);			// define a largura da coluna 2
		table_aeroportos.getColumnModel().getColumn(3).setPreferredWidth(50);			// define a largura da coluna 3
		
		JScrollPane scrollPane = new JScrollPane(table_aeroportos);						// cria o ScrollPane e adiciona o JTable
		scrollPane.setPreferredSize(new Dimension(730, 430));							// define a largura e altura do ScrollPane
		JViewport viewport = scrollPane.getViewport();									// define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(238,238,238));								// define a cor de fundo do ScrollPane
		Painel_Consulta_Aeroporto.add(scrollPane);										// adiciona o ScrollPane ao JPanel
		
		
		try {
		    
			conexao novaConexao = new conexao();
		    Connection conectar = novaConexao.getConexao();
		    Connection conn = conectar;
		    
		    // Procedimentos para obter os dados de uma tabela
            java.sql.Statement stmt = conn.createStatement();
            String query = "SELECT cod, nome, cidade, estado FROM aeroporto";
            ResultSet rs = stmt.executeQuery(query);

		    while (rs.next()) {
		        int cod = rs.getInt("cod");
		        String nome = rs.getString("nome");
		        String cidade = rs.getString("cidade");
		        String estado = rs.getString("estado");

		        model.addRow(new Object[]{cod, nome, cidade, estado});
		    }

		    // Fim do procedimento para obter os dados
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (Exception e) {
		    System.out.println("Problemas ao tentar conectar com o banco de dados");
		}
		
		
	}

	private void cadastroaeroporto() throws ParseException {
		
		Painel_Aeroporto_Cadastro = new JPanel();
		layeredPane.setLayer(Painel_Aeroporto_Cadastro, 1);
		Painel_Aeroporto_Cadastro.setBackground(new Color(238,238,238));
		Painel_Aeroporto_Cadastro.setBounds(0, 0, 730, 430);
		layeredPane.add(Painel_Aeroporto_Cadastro);
		Painel_Aeroporto_Cadastro.setLayout(null);
		
		MaskFormatter mascaraCEP = new MaskFormatter("##.###-###");
				
		JLabel lbl_Codigo = new JLabel("Código");
		lbl_Codigo.setBounds(20, 30, 60, 16);
		Painel_Aeroporto_Cadastro.add(lbl_Codigo);
		
		JTextField tf_Codigo = new JTextField();
		tf_Codigo.setBounds(69, 25, 113, 26);
		Painel_Aeroporto_Cadastro.add(tf_Codigo);
		//tf_Codigo.setColumns(10);
		
		JLabel lbl_Nome = new JLabel("Nome");
		lbl_Nome.setBounds(194, 30, 61, 16);
		Painel_Aeroporto_Cadastro.add(lbl_Nome);
		
		JLabel lbl_Logradouro = new JLabel("Logradouro");
		lbl_Logradouro.setBounds(20, 66, 86, 16);
		Painel_Aeroporto_Cadastro.add(lbl_Logradouro);
		
		JLabel lbl_Numero = new JLabel("Número");
		lbl_Numero.setBounds(528, 66, 61, 16);
		Painel_Aeroporto_Cadastro.add(lbl_Numero);
		
		JLabel lbl_Complemento = new JLabel("Complemento");
		lbl_Complemento.setBounds(20, 102, 98, 16);
		Painel_Aeroporto_Cadastro.add(lbl_Complemento);
		
		JLabel lbl_Bairro = new JLabel("Bairro");
		lbl_Bairro.setBounds(423, 102, 45, 16);
		Painel_Aeroporto_Cadastro.add(lbl_Bairro);
		
		JLabel lbl_Cidade = new JLabel("Cidade");
		lbl_Cidade.setBounds(20, 138, 61, 16);
		Painel_Aeroporto_Cadastro.add(lbl_Cidade);
		
		JLabel lbl_Estado = new JLabel("Estado");
		lbl_Estado.setBounds(394, 138, 50, 16);
		Painel_Aeroporto_Cadastro.add(lbl_Estado);
		
		JLabel lbl_CEP = new JLabel("CEP");
		lbl_CEP.setBounds(515, 138, 34, 16);
		Painel_Aeroporto_Cadastro.add(lbl_CEP);
		
		
		JTextField tf_Nome = new JTextField();
		tf_Nome.setBounds(238, 25, 462, 26);
		Painel_Aeroporto_Cadastro.add(tf_Nome);
		//tf_Nome.setColumns(10);
		
		JTextField tf_Logradouro = new JTextField();
		tf_Logradouro.setBounds(96, 61, 420, 26);
		Painel_Aeroporto_Cadastro.add(tf_Logradouro);
		//tf_Logradouro.setColumns(10);
		
		JTextField tf_Numero = new JTextField();
		tf_Numero.setBounds(586, 61, 114, 26);
		Painel_Aeroporto_Cadastro.add(tf_Numero);
		//tf_Numero.setColumns(10);
		
		JTextField tf_Complemento = new JTextField();
		tf_Complemento.setBounds(125, 97, 286, 26);
		Painel_Aeroporto_Cadastro.add(tf_Complemento);
		//tf_Complemento.setColumns(10);
		
		JTextField tf_Bairro = new JTextField();
		tf_Bairro.setBounds(463, 97, 237, 26);
		Painel_Aeroporto_Cadastro.add(tf_Bairro);
		//tf_Bairro.setColumns(10);
		
		JTextField tf_Cidade = new JTextField();
		tf_Cidade.setBounds(69, 133, 313, 26);
		Painel_Aeroporto_Cadastro.add(tf_Cidade);
		//tf_Estado.setColumns(10);
		
		JComboBox cb_Estado = new JComboBox();
		cb_Estado.setBounds(440, 134, 69, 27);
		cb_Estado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RR", "RO", "RJ", "RN", "RS", "SC", "SP", "SE", "TO"}));
		Painel_Aeroporto_Cadastro.add(cb_Estado);
		
		JFormattedTextField ftf_CEP = new JFormattedTextField(mascaraCEP);
		ftf_CEP.setBounds(561, 133, 139, 26);
		Painel_Aeroporto_Cadastro.add(ftf_CEP);
		
		JButton btn_CadastrarAeroporto = new JButton("Cadastrar");
		btn_CadastrarAeroporto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod;
				String nome, logradouro, numero, complemento, bairro, cidade, estado, cep;
				
				cod = Integer.parseInt(tf_Codigo.getText());
				nome = tf_Nome.getText();
				logradouro = tf_Logradouro.getText();
				numero = tf_Numero.getText();
				complemento = tf_Complemento.getText();
				bairro = tf_Bairro.getText();
				cidade = tf_Cidade.getText();
				estado = cb_Estado.getSelectedItem().toString();
				cep = ftf_CEP.getText();
				
				cadastrar.aeroporto(cod, nome, logradouro, numero, complemento, bairro, cidade, estado, cep);
			
				tf_Codigo.setText(null);
				tf_Nome.setText(null);
				tf_Logradouro.setText(null);
				tf_Numero.setText(null);
				tf_Complemento.setText(null);
				tf_Bairro.setText(null);
				tf_Cidade.setText(null);
				cb_Estado.setSelectedItem("AC");
				ftf_CEP.setText(null);
			
			}
		});
		btn_CadastrarAeroporto.setBounds(20, 350, 120, 30);
		Painel_Aeroporto_Cadastro.add(btn_CadastrarAeroporto);
		
		JButton btn_AtualizarAeroporto = new JButton("Atualizar");
		btn_AtualizarAeroporto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cod;
				String nome, logradouro, numero, complemento, bairro, cidade, estado, cep;
				
				cod = Integer.parseInt(tf_Codigo.getText());
				nome = tf_Nome.getText();
				logradouro = tf_Logradouro.getText();
				numero = tf_Numero.getText();
				complemento = tf_Complemento.getText();
				bairro = tf_Bairro.getText();
				cidade = tf_Cidade.getText();
				estado = cb_Estado.getSelectedItem().toString();
				cep = ftf_CEP.getText();
				
				atualizar.aeroporto(cod, nome, logradouro, numero, complemento, bairro, cidade, estado, cep);
			}
		});
		btn_AtualizarAeroporto.setBounds(160, 350, 120, 30);
		Painel_Aeroporto_Cadastro.add(btn_AtualizarAeroporto);
		
		JButton btn_ExcluirAeroporto = new JButton("Excluir");
		btn_ExcluirAeroporto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cod;
				cod = Integer.parseInt(tf_Codigo.getText());
				
				//confirmação de ação
				//Sim = 0 Não=1 Cancelar=3
				int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclusão do aeroporto "+cod+"?");
				if(opcao == 0) {
					excluir.aeroporto(cod);
				}
			}
		});
		btn_ExcluirAeroporto.setBounds(300, 350, 120, 30);
		Painel_Aeroporto_Cadastro.add(btn_ExcluirAeroporto);
		
		JButton btn_BuscarAeroporto = new JButton("Buscar");
		btn_BuscarAeroporto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo = Integer.parseInt(tf_Codigo.getText());
				
				try {
					
					conexao novaConexao = new conexao();
				    Connection conectar = novaConexao.getConexao();
				    
		            String query = "SELECT * FROM aeroporto WHERE cod=?";
		            PreparedStatement statement = conectar.prepareStatement(query);
		            statement.setInt(1, codigo);
					
		            ResultSet rs = statement.executeQuery();
					
					
				    if (rs.next()) {
				        String nome = rs.getString("nome");
				        String logradouro = rs.getString("logradouro");
				        String numero = rs.getString("numero");
				        String complemento = rs.getString("complemento");
				        String bairro = rs.getString("bairro");
				        String cidade = rs.getString("cidade");
				        String estado = rs.getString("estado");
				        String cep = rs.getString("cep");
				        
				        tf_Nome.setText(nome);
				        tf_Logradouro.setText(logradouro);
				        tf_Numero.setText(numero);
				        tf_Complemento.setText(complemento);
				        tf_Bairro.setText(bairro);
				        tf_Cidade.setText(cidade);
				        cb_Estado.setSelectedItem(estado);
				        ftf_CEP.setText(cep);
				    }
				    
				    
				} catch (SQLException a) {
				    a.printStackTrace();
				}
			}
		});
		btn_BuscarAeroporto.setBounds(440, 350, 120, 30);
		Painel_Aeroporto_Cadastro.add(btn_BuscarAeroporto);
		
		JButton btn_LimparAeroporto = new JButton("Limpar");
		btn_LimparAeroporto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_Codigo.setText(null);
				tf_Nome.setText(null);
				tf_Logradouro.setText(null);
				tf_Numero.setText(null);
				tf_Complemento.setText(null);
				tf_Bairro.setText(null);
				tf_Cidade.setText(null);
				cb_Estado.setSelectedItem("AC");
				ftf_CEP.setText(null);
			}
		});
		btn_LimparAeroporto.setBounds(580, 350, 120, 30);
		Painel_Aeroporto_Cadastro.add(btn_LimparAeroporto);
		
		
		
		
	}
	
	private void cadastroaviao() {
		
		Painel_Aviao_Cadastro = new JPanel();
		layeredPane.setLayer(Painel_Aviao_Cadastro, 2);
		Painel_Aviao_Cadastro.setBackground(new Color(238,238,238));
		Painel_Aviao_Cadastro.setBounds(0, 0, 730, 430);
		layeredPane.add(Painel_Aviao_Cadastro);
		Painel_Aviao_Cadastro.setLayout(null);
		
		JLabel lbl_Cod = new JLabel("Código");
		lbl_Cod.setBounds(70, 52, 53, 16);
		Painel_Aviao_Cadastro.add(lbl_Cod);
		
		JLabel lbl_Fabricante = new JLabel("Fabricante");
		lbl_Fabricante.setBounds(291, 52, 80, 16);
		Painel_Aviao_Cadastro.add(lbl_Fabricante);
		
		JLabel lbl_Modelo = new JLabel("Modelo");
		lbl_Modelo.setBounds(70, 100, 61, 16);
		Painel_Aviao_Cadastro.add(lbl_Modelo);
		
		JLabel lbl_Capacidade = new JLabel("Capacidade");
		lbl_Capacidade.setBounds(466, 100, 80, 16);
		Painel_Aviao_Cadastro.add(lbl_Capacidade);
		
		JTextField tF_Cod = new JTextField();
		tF_Cod.setBounds(130, 47, 130, 26);
		Painel_Aviao_Cadastro.add(tF_Cod);
		//tF_Cod.setColumns(10);
		
		JTextField tF_Fabricante = new JTextField();
		tF_Fabricante.setBounds(372, 47, 269, 26);
		Painel_Aviao_Cadastro.add(tF_Fabricante);
		tF_Fabricante.setColumns(10);
		
		JTextField tF_Modelo = new JTextField();
		tF_Modelo.setBounds(130, 95, 318, 26);
		Painel_Aviao_Cadastro.add(tF_Modelo);
		tF_Modelo.setColumns(10);
		
		JTextField tF_Capacidade = new JTextField();
		tF_Capacidade.setBounds(558, 95, 83, 26);
		Painel_Aviao_Cadastro.add(tF_Capacidade);
		tF_Capacidade.setColumns(10);
		
		JButton btn_Cadastrar = new JButton("Cadastrar");
		btn_Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fabricante, modelo;
				int capacidade=0;
				
				fabricante = tF_Fabricante.getText();
				modelo = tF_Modelo.getText();
				if (!tF_Capacidade.getText().equals("")) {
					capacidade = Integer.parseInt(tF_Capacidade.getText());
				}
				if(
						fabricante.equals("")
						|| modelo.equals("") 
						|| capacidade <= 0
						) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
				}else {
					cadastrar.aviao(fabricante, modelo, capacidade);
				}
			}
		});
		btn_Cadastrar.setBounds(20, 350, 120, 30);
		Painel_Aviao_Cadastro.add(btn_Cadastrar);
		
		JButton btn_Atualizar = new JButton("Atualizar");
		btn_Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fabricante, modelo;
				int capacidade, cod;
				
				fabricante = tF_Fabricante.getText();
				modelo = tF_Modelo.getText();
				capacidade = Integer.parseInt(tF_Capacidade.getText());
				cod = Integer.parseInt(tF_Cod.getText());
				
				atualizar.aviao(cod, fabricante, modelo, capacidade);
			}
		});
		btn_Atualizar.setBounds(160, 350, 120, 30);
		Painel_Aviao_Cadastro.add(btn_Atualizar);
		
		JButton btn_Excluir = new JButton("Excluir");
		btn_Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				int cod;
				cod = Integer.parseInt(tF_Cod.getText());
				
				//confirmação de ação
				//Sim = 0 Não=1 Cancelar=3
				int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclusão do aeroporto "+cod+"?");
				if(opcao == 0) {
					excluir.aviao(cod);
				}
			}
		});
		btn_Excluir.setBounds(300, 350, 120, 30);
		Painel_Aviao_Cadastro.add(btn_Excluir);
		
		JButton btn_BuscarAviao = new JButton("Buscar");
		btn_BuscarAviao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo = Integer.parseInt(tF_Cod.getText());
				
				try {
					
					conexao novaConexao = new conexao();
				    Connection conectar = novaConexao.getConexao();
				    
		            String query = "SELECT * FROM aviao WHERE cod=?";
		            PreparedStatement statement = conectar.prepareStatement(query);
		            statement.setInt(1, codigo);
					
		            ResultSet rs = statement.executeQuery();
					
				    if (rs.next()) {
				        String fabricante = rs.getString("fabricante");
				        String modelo = rs.getString("modelo");
				        String capacidade = rs.getString("capacidade");
				       				        
				        tF_Fabricante.setText(fabricante);
				        tF_Modelo.setText(modelo);
				        tF_Capacidade.setText(capacidade);
				    }
				    
				    
				} catch (SQLException a) {
				    a.printStackTrace();
				}
			}
		});
		btn_BuscarAviao.setBounds(440, 350, 120, 30);
		Painel_Aviao_Cadastro.add(btn_BuscarAviao);
		
		JButton btn_LimparAviao = new JButton("Limpar");
		btn_LimparAviao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tF_Cod.setText(null);
				tF_Fabricante.setText(null);
				tF_Modelo.setText(null);
				tF_Capacidade.setText(null);
			}
		});
		btn_LimparAviao.setBounds(580, 350, 120, 30);
		Painel_Aviao_Cadastro.add(btn_LimparAviao);
		
	}

	private void consultaaviao() {
		
		Painel_Consulta_Aviao = new JPanel();
		layeredPane.setLayer(Painel_Consulta_Aviao, 3);
		Painel_Consulta_Aviao.setBackground(new Color(238,238,238));
		Painel_Consulta_Aviao.setBounds(0, 0, 730, 430);
		layeredPane.add(Painel_Consulta_Aviao);
		
		JTable table_avioes = new JTable();											// cria um JTable
		table_avioes.setBackground(new Color(238,238,238));						// define a cor de fundo do JTable
		table_avioes.setBounds(6, 238, 638, -233);
		DefaultTableModel model = (DefaultTableModel) table_avioes.getModel();		//
		model.addColumn("Código");														// adiciona a coluna 0
		model.addColumn("Fabricante");														// adiciona a coluna 1
		model.addColumn("Modelo");														// adiciona a coluna 2
		model.addColumn("Capacidade");														// adiciona a coluna 3
		table_avioes.getColumnModel().getColumn(0).setPreferredWidth(75);			// define a largura da coluna 0
		table_avioes.getColumnModel().getColumn(1).setPreferredWidth(250);			// define a largura da coluna 1
		table_avioes.getColumnModel().getColumn(2).setPreferredWidth(250);			// define a largura da coluna 2
		table_avioes.getColumnModel().getColumn(3).setPreferredWidth(75);			// define a largura da coluna 3
		
		JScrollPane scrollPane = new JScrollPane(table_avioes);						// cria o ScrollPane e adiciona o JTable
		scrollPane.setPreferredSize(new Dimension(730, 430));							// define a largura e altura do ScrollPane
		JViewport viewport = scrollPane.getViewport();									// define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(238,238,238));								// define a cor de fundo do ScrollPane
		Painel_Consulta_Aviao.add(scrollPane);										// adiciona o ScrollPane ao JPanel
		
		
		try {
		    
			conexao novaConexao = new conexao();
		    Connection conectar = novaConexao.getConexao();
		    Connection conn = conectar;
		    
		    
		    // Procedimentos para obter os dados de uma tabela
            java.sql.Statement stmt = conn.createStatement();
            String query = "SELECT * FROM aviao";
            ResultSet rs = stmt.executeQuery(query);

		    while (rs.next()) {
		        int cod = rs.getInt("cod");
		        String fabricante = rs.getString("fabricante");
		        String modelo = rs.getString("modelo");
		        int capacidade = rs.getInt("capacidade");

		        model.addRow(new Object[]{cod, fabricante, modelo, capacidade});
		    }

		    // Fim do procedimento para obter os dados
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (Exception e) {
		    System.out.println("Problemas ao tentar conectar com o banco de dados");
		}
		
		
	}

	private void cadastrovoo() throws ParseException {
		
		Painel_Voo_Cadastro = new JPanel();
		layeredPane.setLayer(Painel_Voo_Cadastro, 5);
		Painel_Voo_Cadastro.setBackground(new Color(238,238,238));
		Painel_Voo_Cadastro.setBounds(0, 0, 730, 430);
		layeredPane.add(Painel_Voo_Cadastro);
		Painel_Voo_Cadastro.setLayout(null);
		
		MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
		MaskFormatter mascaraData = new MaskFormatter("####-##-##");
		MaskFormatter mascaraHora = new MaskFormatter("##:##");
		
		JLabel lbl_Cod = new JLabel("Código");
		lbl_Cod.setBounds(20, 21, 45, 16);
		Painel_Voo_Cadastro.add(lbl_Cod);
		
		JLabel lbl_Companhia = new JLabel("CNPJ Companhia Aérea");
		lbl_Companhia.setBounds(230, 21, 152, 16);
		Painel_Voo_Cadastro.add(lbl_Companhia);
		
		JLabel lbl_AeroOrigem = new JLabel("Código do Aeroporto de Origem");
		lbl_AeroOrigem.setBounds(20, 54, 209, 16);
		Painel_Voo_Cadastro.add(lbl_AeroOrigem);
		
		JLabel lbl_AeroDestino = new JLabel("Código do Aeroporto de Destino");
		lbl_AeroDestino.setBounds(322, 54, 204, 16);
		Painel_Voo_Cadastro.add(lbl_AeroDestino);
		
		JLabel lbl_Data = new JLabel("Data");
		lbl_Data.setBounds(20, 88, 45, 16);
		Painel_Voo_Cadastro.add(lbl_Data);
		
		JLabel lbl_Horario = new JLabel("Horário");
		lbl_Horario.setBounds(193, 88, 52, 16);
		Painel_Voo_Cadastro.add(lbl_Horario);
		
		JLabel lbl_CodAviao = new JLabel("Código do Avião");
		lbl_CodAviao.setBounds(365, 88, 112, 16);
		Painel_Voo_Cadastro.add(lbl_CodAviao);
		
		JTextField tf_Cod = new JTextField();
		tf_Cod.setBounds(72, 16, 146, 26);
		Painel_Voo_Cadastro.add(tf_Cod);
		tf_Cod.setColumns(10);
		
		JFormattedTextField ftf_Companhia = new JFormattedTextField(mascaraCNPJ);
		ftf_Companhia.setBounds(394, 16, 228, 26);
		Painel_Voo_Cadastro.add(ftf_Companhia);
		
		JTextField tf_AeroOrigem = new JTextField();
		tf_AeroOrigem.setBounds(228, 49, 87, 26);
		Painel_Voo_Cadastro.add(tf_AeroOrigem);
		tf_AeroOrigem.setColumns(10);
		
		JTextField tf_AeroDestino = new JTextField();
		tf_AeroDestino.setBounds(532, 49, 90, 26);
		Painel_Voo_Cadastro.add(tf_AeroDestino);
		tf_AeroDestino.setColumns(10);
		
		JFormattedTextField ftf_Data = new JFormattedTextField(mascaraData);
		ftf_Data.setBounds(56, 83, 125, 26);
		Painel_Voo_Cadastro.add(ftf_Data);
		
		JFormattedTextField ftf_Horario = new JFormattedTextField(mascaraHora);
		ftf_Horario.setBounds(255, 83, 87, 26);
		Painel_Voo_Cadastro.add(ftf_Horario);
		
		JTextField tf_CodAviao = new JTextField();
		tf_CodAviao.setBounds(478, 83, 146, 26);
		Painel_Voo_Cadastro.add(tf_CodAviao);
		tf_CodAviao.setColumns(10);
		
		
		JButton btn_Cadastrar = new JButton("Cadastrar");
		btn_Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String companhia, data, hora;
				int aeroorigem, aerodestino, codaviao;
				
				companhia = ftf_Companhia.getText();
				data = ftf_Data.getText();
				hora = ftf_Horario.getText();
				aeroorigem = Integer.parseInt(tf_AeroOrigem.getText());
				aerodestino = Integer.parseInt(tf_AeroDestino.getText());
				codaviao = Integer.parseInt(tf_CodAviao.getText());
				
				cadastrar.voo(companhia, aeroorigem, aerodestino, data, hora, codaviao);
			}	
		});
		btn_Cadastrar.setBounds(20, 350, 120, 30);
		Painel_Voo_Cadastro.add(btn_Cadastrar);
		
		JButton btn_Atualizar = new JButton("Atualizar");
		btn_Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Atualizar.setBounds(140, 350, 120, 30);
		Painel_Voo_Cadastro.add(btn_Atualizar);
		
		JButton btn_Excluir = new JButton("Excluir");
		btn_Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod;
				cod = Integer.parseInt(tf_Cod.getText());
				
				//confirmação de ação
				//Sim = 0 Não=1 Cancelar=3
				int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclusão do voo "+cod+"?");
				if(opcao == 0) {
					excluir.voo(cod);
				}
			}
		});
		btn_Excluir.setBounds(300, 350, 120, 30);
		Painel_Voo_Cadastro.add(btn_Excluir);
		
		JButton btn_BuscarVoo = new JButton("Buscar");
		btn_BuscarVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(tf_Cod.getText());
				
				try {	
					conexao novaConexao = new conexao();
				    Connection conectar = novaConexao.getConexao();
				    
		            String query = "SELECT * FROM voo WHERE cod=?";
		            PreparedStatement statement = conectar.prepareStatement(query);
		            statement.setInt(1, codigo);
					
		            ResultSet rs = statement.executeQuery();
					
					
				    if (rs.next()) {
				        String companhia = rs.getString("companhia");
				        String aeroorigem = rs.getString("aeroporto_origem");
				        String aerodestino = rs.getString("aeroporto_destino");
				        String data = rs.getString("dada");
				        String horario = rs.getString("horario");
				        String codaviao = rs.getString("cod_aviao");
				       				        
				        ftf_Companhia.setText(companhia);
				        tf_AeroOrigem.setText(aeroorigem);
				        tf_AeroDestino.setText(aerodestino);
				        ftf_Data.setText(data);
				        ftf_Horario.setText(horario);
				        tf_CodAviao.setText(codaviao);
				    }
				} catch (SQLException a) {
				    a.printStackTrace();
				}
			}
		});
		btn_BuscarVoo.setBounds(440, 350, 120, 30);
		Painel_Voo_Cadastro.add(btn_BuscarVoo);
		
		JButton btn_LimparVoo = new JButton("Limpar");
		btn_LimparVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_Cod.setText("");
				ftf_Companhia.setText("");
				ftf_Data.setText("");
				ftf_Horario.setText("");
				tf_AeroOrigem.setText("");
				tf_AeroDestino.setText("");
				tf_CodAviao.setText("");
			}
		});
		btn_LimparVoo.setBounds(580, 350, 120, 30);
		Painel_Voo_Cadastro.add(btn_LimparVoo);
		
	}

	private void consultavoo() {
		
		Painel_Consulta_Voo = new JPanel();
		layeredPane.setLayer(Painel_Consulta_Voo, 3);
		Painel_Consulta_Voo.setBackground(new Color(238,238,238));
		Painel_Consulta_Voo.setBounds(0, 0, 730, 430);
		layeredPane.add(Painel_Consulta_Voo);
		
		JTable table_voos = new JTable();											// cria um JTable
		table_voos.setBackground(new Color(238,238,238));								// define a cor de fundo do JTable
		table_voos.setBounds(6, 238, 638, -233);
		DefaultTableModel model = (DefaultTableModel) table_voos.getModel();		//
		model.addColumn("Voo");														// adiciona a coluna 0
		model.addColumn("Origem");													// adiciona a coluna 1
		model.addColumn("Destino");													// adiciona a coluna 2
		model.addColumn("Companhia");												// adiciona a coluna 3
		model.addColumn("Horario");
		table_voos.getColumnModel().getColumn(0).setPreferredWidth(50);				// define a largura da coluna 0
		table_voos.getColumnModel().getColumn(1).setPreferredWidth(200);			// define a largura da coluna 1
		table_voos.getColumnModel().getColumn(2).setPreferredWidth(200);			// define a largura da coluna 2
		table_voos.getColumnModel().getColumn(3).setPreferredWidth(150);			// define a largura da coluna 3
		table_voos.getColumnModel().getColumn(4).setPreferredWidth(50);
		
		JScrollPane scrollPane = new JScrollPane(table_voos);						// cria o ScrollPane e adiciona o JTable
		scrollPane.setPreferredSize(new Dimension(650, 251));						// define a largura e altura do ScrollPane
		JViewport viewport = scrollPane.getViewport();								// define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(238,238,238));								// define a cor de fundo do ScrollPane
		Painel_Consulta_Aviao.add(scrollPane);										// adiciona o ScrollPane ao JPanel
		
		
		try {
		    
			conexao novaConexao = new conexao();
		    Connection conectar = novaConexao.getConexao();
		    PreparedStatement preparar = null;
		    Connection conn = conectar;
		    
		    
		    // Procedimentos para obter os dados de uma tabela
            java.sql.Statement stmt = conn.createStatement();
            String query = "SELECT voo.cod, aeroporto.cod, aeroporto.cod, companhia.nome, voo.horario FROM aviao";
            ResultSet rs = stmt.executeQuery(query);

		    while (rs.next()) {
		        int cod = rs.getInt("cod");
		        String fabricante = rs.getString("fabricante");
		        String modelo = rs.getString("modelo");
		        int capacidade = rs.getInt("capacidade");

		        model.addRow(new Object[]{cod, fabricante, modelo, capacidade});
		    }

		    // Fim do procedimento para obter os dados
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (Exception e) {
		    System.out.println("Problemas ao tentar conectar com o banco de dados");
		}
		
		
	}
	
	private void cadastrocompanhia() throws ParseException {
		
		Painel_Companhia_Cadastro = new JPanel();
		layeredPane.setLayer(Painel_Companhia_Cadastro, 1);
		Painel_Companhia_Cadastro.setBackground(new Color(238,238,238));
		Painel_Companhia_Cadastro.setBounds(0, 0, 730, 430);
		layeredPane.add(Painel_Companhia_Cadastro);
		Painel_Companhia_Cadastro.setLayout(null);
		
		MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
		MaskFormatter mascaraCEP = new MaskFormatter("##.###-###");
		
		JLabel lbl_CNPJ = new JLabel("CNPJ");
		lbl_CNPJ.setBounds(20, 30, 40, 16);
		Painel_Companhia_Cadastro.add(lbl_CNPJ);
		
		JLabel lbl_NomeFantasia = new JLabel("Nome Fantasia");
		lbl_NomeFantasia.setBounds(301, 30, 99, 16);
		Painel_Companhia_Cadastro.add(lbl_NomeFantasia);
		
		JLabel lbl_RazaoSocial = new JLabel("Razão Social");
		lbl_RazaoSocial.setBounds(22, 66, 84, 16);
		Painel_Companhia_Cadastro.add(lbl_RazaoSocial);
		
		JLabel lbl_Logradouro = new JLabel("Logradouro");
		lbl_Logradouro.setBounds(22, 102, 84, 16);
		Painel_Companhia_Cadastro.add(lbl_Logradouro);
		
		JLabel lbl_Numero = new JLabel("Número");
		lbl_Numero.setBounds(512, 102, 61, 16);
		Painel_Companhia_Cadastro.add(lbl_Numero);
		
		JLabel lbl_Complemento = new JLabel("Complemento");
		lbl_Complemento.setBounds(22, 138, 99, 16);
		Painel_Companhia_Cadastro.add(lbl_Complemento);
		
		JLabel lbl_Bairro = new JLabel("Bairro");
		lbl_Bairro.setBounds(371, 138, 40, 16);
		Painel_Companhia_Cadastro.add(lbl_Bairro);
		
		JLabel lbl_Cidade = new JLabel("Cidade");
		lbl_Cidade.setBounds(22, 174, 61, 16);
		Painel_Companhia_Cadastro.add(lbl_Cidade);
		
		JLabel lbl_Estado = new JLabel("Estado");
		lbl_Estado.setBounds(370, 174, 61, 16);
		Painel_Companhia_Cadastro.add(lbl_Estado);
		
		JLabel lbl_CEP = new JLabel("CEP");
		lbl_CEP.setBounds(524, 174, 34, 16);
		Painel_Companhia_Cadastro.add(lbl_CEP);
		
		JFormattedTextField ftf_CNPJ = new JFormattedTextField(mascaraCNPJ);
		ftf_CNPJ.setBounds(59, 25, 230, 26);
		Painel_Companhia_Cadastro.add(ftf_CNPJ);
		
		JTextField tf_NomeFantasia = new JTextField();
		tf_NomeFantasia.setBounds(398, 25, 302, 26);
		Painel_Companhia_Cadastro.add(tf_NomeFantasia);
		tf_NomeFantasia.setColumns(10);
		
		JTextField tf_RazaoSocial = new JTextField();
		tf_RazaoSocial.setBounds(105, 61, 595, 26);
		Painel_Companhia_Cadastro.add(tf_RazaoSocial);
		tf_RazaoSocial.setColumns(10);
		
		JTextField tf_Logradouro = new JTextField();
		tf_Logradouro.setBounds(105, 97, 395, 26);
		Painel_Companhia_Cadastro.add(tf_Logradouro);
		tf_Logradouro.setColumns(10);
		
		JTextField tf_Numero = new JTextField();
		tf_Numero.setToolTipText("");
		tf_Numero.setBounds(570, 97, 130, 26);
		Painel_Companhia_Cadastro.add(tf_Numero);
		tf_Numero.setColumns(10);
		
		JTextField tf_Complemento = new JTextField();
		tf_Complemento.setBounds(115, 133, 244, 26);
		Painel_Companhia_Cadastro.add(tf_Complemento);
		tf_Complemento.setColumns(10);
		
		JTextField tf_Bairro = new JTextField();
		tf_Bairro.setBounds(415, 133, 285, 26);
		Painel_Companhia_Cadastro.add(tf_Bairro);
		tf_Bairro.setColumns(10);
		
		JTextField tf_Cidade = new JTextField();
		tf_Cidade.setBounds(71, 169, 287, 26);
		Painel_Companhia_Cadastro.add(tf_Cidade);
		tf_Cidade.setColumns(10);
		
		JComboBox cb_Estado = new JComboBox();
		cb_Estado.setBounds(415, 170, 84, 27);
		cb_Estado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RR", "RO", "RJ", "RN", "RS", "SC", "SP", "SE", "TO"}));
		Painel_Companhia_Cadastro.add(cb_Estado);
		
		JFormattedTextField ftf_CEP = new JFormattedTextField(mascaraCEP);
		ftf_CEP.setBounds(556, 169, 144, 26);
		Painel_Companhia_Cadastro.add(ftf_CEP);
		
		JButton btn_Cadastrar = new JButton("Cadastrar");
		btn_Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj,razaosocial,nomefantasia,logradouro,numero,complemento,bairro,cidade,estado,cep;
				
				cnpj = ftf_CNPJ.getText();
				razaosocial = tf_RazaoSocial.getText();
				nomefantasia = tf_NomeFantasia.getText();
				logradouro = tf_Logradouro.getText();
				numero = tf_Numero.getText();
				complemento = tf_Complemento.getText();
				bairro = tf_Bairro.getText();
				cidade = tf_Cidade.getText();
				estado = cb_Estado.getSelectedItem().toString();
				cep = ftf_CEP.getText();
				
				cadastrar.companhia(cnpj, razaosocial, nomefantasia, logradouro, numero, complemento, bairro, cidade, estado, cep);
			}
		});
		btn_Cadastrar.setBounds(20, 350, 120, 30);
		Painel_Companhia_Cadastro.add(btn_Cadastrar);
		
		JButton btn_Atualizar = new JButton("Atualizar");
		btn_Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj,razaosocial,nomefantasia,logradouro,numero,complemento,bairro,cidade,estado,cep;
				
				cnpj = ftf_CNPJ.getText();
				razaosocial = tf_RazaoSocial.getText();
				nomefantasia = tf_NomeFantasia.getText();
				logradouro = tf_Logradouro.getText();
				numero = tf_Numero.getText();
				complemento = tf_Complemento.getText();
				bairro = tf_Bairro.getText();
				cidade = tf_Cidade.getText();
				estado = cb_Estado.getSelectedItem().toString();
				cep = ftf_CEP.getText();
				
				atualizar.companhia(cnpj, razaosocial, nomefantasia, logradouro, numero, complemento, bairro, cidade, estado, cep);
			}
		});
		btn_Atualizar.setBounds(160, 350, 120, 30);
		Painel_Companhia_Cadastro.add(btn_Atualizar);
		
		JButton btn_Excluir = new JButton("Excluir");
		btn_Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj;
				cnpj = ftf_CNPJ.getText();
				
				//confirmação de ação
				//Sim = 0 Não=1 Cancelar=3
				int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclusão do companhia "+cnpj+"?");
				if(opcao == 0) {
					excluir.companhia(cnpj);
				}
			}
		});
		
		btn_Excluir.setBounds(300, 350, 120, 30);
		Painel_Companhia_Cadastro.add(btn_Excluir);
		
		
		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj = ftf_CNPJ.getText();
				
				try {	
					conexao novaConexao = new conexao();
				    Connection conectar = novaConexao.getConexao();
				    
		            String query = "SELECT * FROM companhia WHERE cnpj=?";
		            PreparedStatement statement = conectar.prepareStatement(query);
		            statement.setString(1, cnpj);
					
		            ResultSet rs = statement.executeQuery();
					
					
				    if (rs.next()) {
				        String razaosocial = rs.getString("razao_social");
				        String nomefantasia = rs.getString("nome_fantasia");
				        String logradouro = rs.getString("logradouro");
				        String numero = rs.getString("numero");
				        String complemento = rs.getString("complemento");
				        String bairro = rs.getString("bairro");
				        String cidade = rs.getString("cidade");
				        String estado = rs.getString("estado");
				        String cep = rs.getString("cep");
				       				        
				        tf_RazaoSocial.setText(razaosocial);
				        tf_NomeFantasia.setText(nomefantasia);
				        tf_Logradouro.setText(logradouro);
				        tf_Numero.setText(numero);
				        tf_Complemento.setText(complemento);
				        tf_Bairro.setText(bairro);
				        tf_Cidade.setText(cidade);
				        cb_Estado.setSelectedItem(estado);
				        ftf_CEP.setText(cep);
				    }
				} catch (SQLException a) {
				    a.printStackTrace();
				}
			}
		});
		btn_Buscar.setBounds(440, 350, 120, 30);
		Painel_Companhia_Cadastro.add(btn_Buscar);
		
		JButton btn_Limpar = new JButton("Limpar");
		btn_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ftf_CNPJ.setText("");
				tf_RazaoSocial.setText("");
				tf_NomeFantasia.setText("");
				tf_Logradouro.setText("");
				tf_Numero.setText("");
				tf_Complemento.setText("");
				tf_Bairro.setText("");
				tf_Cidade.setText("");
				cb_Estado.setSelectedItem("AC");
				ftf_CEP.setText("");
			}
		});
		btn_Limpar.setBounds(580, 350, 120, 30);
		Painel_Companhia_Cadastro.add(btn_Limpar);
	}

	private void consultacompanhia() {
			
			Painel_Consulta_Companhia = new JPanel();
			layeredPane.setLayer(Painel_Consulta_Companhia, 3);
			Painel_Consulta_Companhia.setBackground(new Color(238,238,238));
			Painel_Consulta_Companhia.setBounds(0, 0, 730, 430);
			layeredPane.add(Painel_Consulta_Companhia);
			
			JTable table_companhias = new JTable();											// cria um JTable
			table_companhias.setBackground(new Color(238,238,238));								// define a cor de fundo do JTable
			table_companhias.setBounds(6, 238, 638, -233);
			DefaultTableModel model = (DefaultTableModel) table_companhias.getModel();		//
			model.addColumn("CNPJ");														// adiciona a coluna 0
			model.addColumn("Nome");													// adiciona a coluna 1
			model.addColumn("Cidade");													// adiciona a coluna 2
			model.addColumn("Estado");												// adiciona a coluna 3
			model.addColumn("CEP");
			table_companhias.getColumnModel().getColumn(0).setPreferredWidth(200);				// define a largura da coluna 0
			table_companhias.getColumnModel().getColumn(1).setPreferredWidth(200);			// define a largura da coluna 1
			table_companhias.getColumnModel().getColumn(2).setPreferredWidth(200);			// define a largura da coluna 2
			table_companhias.getColumnModel().getColumn(3).setPreferredWidth(80);			// define a largura da coluna 3
			table_companhias.getColumnModel().getColumn(4).setPreferredWidth(120);
			
			JScrollPane scrollPane = new JScrollPane(table_companhias);						// cria o ScrollPane e adiciona o JTable
			scrollPane.setPreferredSize(new Dimension(730, 430));						// define a largura e altura do ScrollPane
			JViewport viewport = scrollPane.getViewport();								// define a cor de fundo do ScrollPane
			viewport.setBackground(new Color(238,238,238));								// define a cor de fundo do ScrollPane
			Painel_Consulta_Companhia.add(scrollPane);										// adiciona o ScrollPane ao JPanel
			
			try { 
				conexao novaConexao = new conexao();
			    Connection conectar = novaConexao.getConexao();
			    Connection conn = conectar;
			    
			    // Procedimentos para obter os dados de uma tabela
	            java.sql.Statement stmt = conn.createStatement();
	            String query = "SELECT cnpj, nome_fantasia, cidade, estado, cep FROM companhia";
	            ResultSet rs = stmt.executeQuery(query);
	
			    while (rs.next()) {
			        String cnpj = rs.getString("cnpj");
			        String nomefantasia = rs.getString("nome_fantasia");
			        String cidade = rs.getString("cidade");
			        String estado = rs.getString("estado");
			        String cep = rs.getString("cep");
	
			        model.addRow(new Object[]{cnpj, nomefantasia, cidade, estado, cep});
			    }
	
			    // Fim do procedimento para obter os dados
			} catch (SQLException ex) {
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			} catch (Exception e) {
			    System.out.println("Problemas ao tentar conectar com o banco de dados");
			}
			
			
		}
		
		
		public void limparpainel() {
	
	        layeredPane.removeAll();
	        //layeredPane.add(p);
	        layeredPane.repaint();
	        layeredPane.revalidate();
	    }
}
