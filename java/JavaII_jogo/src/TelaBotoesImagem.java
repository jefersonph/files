import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class TelaBotoesImagem extends JFrame{

	JButton botao1 = new JButton();
	JButton botao2 = new JButton();
	JButton botao3 = new JButton();
	JButton botao4 = new JButton();
	JButton botao5 = new JButton();
	JButton botao6 = new JButton();
	JButton botao7 = new JButton();
	JButton botao8 = new JButton();
	JButton botao9 = new JButton();
	JButton botao10 = new JButton();
	JButton botao11 = new JButton();
	JButton botao12 = new JButton();
	JButton botao13 = new JButton();
	JButton botao14 = new JButton();
	JButton botao15 = new JButton();
	JButton botao16 = new JButton();
	JButton botao17 = new JButton();
	JButton botao18 = new JButton();
	JButton botao19 = new JButton();
	JButton botao20 = new JButton();
	JButton botao21 = new JButton();
	JButton botao22 = new JButton();
	JButton botao23 = new JButton();
	JButton botao24 = new JButton();
	JPanel painelPrincipal = new JPanel();
	ImageIcon icone1 = new ImageIcon("id_02g.gif");
	ImageIcon icone2 = new ImageIcon("id_02g.gif");
	ImageIcon icone3 = new ImageIcon("id_02g.gif");
	ImageIcon icone4 = new ImageIcon("id_02g.gif");
	ImageIcon icone5 = new ImageIcon("id_02g.gif");
	ImageIcon icone6 = new ImageIcon("id_02g.gif");
	ImageIcon icone7 = new ImageIcon("id_02g.gif");
	ImageIcon icone8 = new ImageIcon("id_02g.gif");
	ImageIcon icone9 = new ImageIcon("id_02g.gif");
	ImageIcon icone10 = new ImageIcon("id_02g.gif");
	ImageIcon icone11 = new ImageIcon("id_02g.gif");
	ImageIcon icone12 = new ImageIcon("id_02g.gif");
	ImageIcon icone13 = new ImageIcon("id_02g.gif");
	ImageIcon icone14 = new ImageIcon("id_02g.gif");
	ImageIcon icone15 = new ImageIcon("id_02g.gif");
	ImageIcon icone16 = new ImageIcon("id_02g.gif");
	ImageIcon icone17 = new ImageIcon("id_02g.gif");
	ImageIcon icone18 = new ImageIcon("id_02g.gif");
	ImageIcon icone19 = new ImageIcon("id_02g.gif");
	ImageIcon icone20 = new ImageIcon("id_02g.gif");
	ImageIcon icone21 = new ImageIcon("id_02g.gif");
	ImageIcon icone22 = new ImageIcon("id_02g.gif");
	ImageIcon icone23 = new ImageIcon("id_02g.gif");
	ImageIcon icone24 = new ImageIcon("id_02g.gif");
	ImageIcon iconea0 = new ImageIcon("200.jpg");
	ImageIcon iconea1 = new ImageIcon("1.jpg");
	ImageIcon iconea2 = new ImageIcon("2.jpg");
	ImageIcon iconea3 = new ImageIcon("3.jpg");
	ImageIcon iconea4 = new ImageIcon("4.jpg");
	ImageIcon iconea5 = new ImageIcon("5.jpg");
	ImageIcon iconea6 = new ImageIcon("6.jpg");
	ImageIcon iconea7 = new ImageIcon("7.jpg");
	ImageIcon iconea8 = new ImageIcon("8.jpg");
	ImageIcon iconea9 = new ImageIcon("9.jpg");
	ImageIcon iconea10 = new ImageIcon("10.jpg");
	ImageIcon iconea11 = new ImageIcon("11.jpg");
	ImageIcon iconea12 = new ImageIcon("12.jpg");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	Icon status = TelaBotoesImagem.this.iconea0;
	Icon status1 = TelaBotoesImagem.this.iconea0;
	JFrame frame = new JFrame();
	
	TelaBotoesImagem(){
		// Chama o construtor da super-classe
		super("Jogo da Velha");

		// Insere imagens nos botoes
		this.botao1.setIcon(icone1);
		this.botao2.setIcon(icone2);
		this.botao3.setIcon(icone3);
		this.botao4.setIcon(icone4);
		this.botao5.setIcon(icone5);
		this.botao6.setIcon(icone6);
		this.botao7.setIcon(icone7);
		this.botao8.setIcon(icone8);
		this.botao9.setIcon(icone9);
		this.botao10.setIcon(icone10);
		this.botao11.setIcon(icone11);
		this.botao12.setIcon(icone12);
		this.botao13.setIcon(icone13);
		this.botao14.setIcon(icone14);
		this.botao15.setIcon(icone15);
		this.botao16.setIcon(icone16);
		this.botao17.setIcon(icone17);
		this.botao18.setIcon(icone18);
		this.botao19.setIcon(icone19);
		this.botao20.setIcon(icone20);
		this.botao21.setIcon(icone21);
		this.botao22.setIcon(icone22);
		this.botao23.setIcon(icone23);
		this.botao24.setIcon(icone24);

		// Define os tamanhos dos botoes
		this.botao1.setPreferredSize(new Dimension(100,100));
		this.botao2.setPreferredSize(new Dimension(100,100));
		this.botao3.setPreferredSize(new Dimension(100,100));
		this.botao4.setPreferredSize(new Dimension(100,100));
		this.botao5.setPreferredSize(new Dimension(100,100));
		this.botao6.setPreferredSize(new Dimension(100,100));
		this.botao7.setPreferredSize(new Dimension(100,100));
		this.botao8.setPreferredSize(new Dimension(100,100));
		this.botao9.setPreferredSize(new Dimension(100,100));
		this.botao10.setPreferredSize(new Dimension(100,100));
		this.botao11.setPreferredSize(new Dimension(100,100));
		this.botao12.setPreferredSize(new Dimension(100,100));
		this.botao13.setPreferredSize(new Dimension(100,100));
		this.botao14.setPreferredSize(new Dimension(100,100));
		this.botao15.setPreferredSize(new Dimension(100,100));
		this.botao16.setPreferredSize(new Dimension(100,100));
		this.botao17.setPreferredSize(new Dimension(100,100));
		this.botao18.setPreferredSize(new Dimension(100,100));
		this.botao19.setPreferredSize(new Dimension(100,100));
		this.botao20.setPreferredSize(new Dimension(100,100));
		this.botao21.setPreferredSize(new Dimension(100,100));
		this.botao22.setPreferredSize(new Dimension(100,100));
		this.botao23.setPreferredSize(new Dimension(100,100));
		this.botao24.setPreferredSize(new Dimension(100,100));


		// Define as acoes dos botoes
		this.botao1.addActionListener(new CliqueBotao());
		this.botao2.addActionListener(new CliqueBotao());
		this.botao3.addActionListener(new CliqueBotao());
		this.botao4.addActionListener(new CliqueBotao());
		this.botao5.addActionListener(new CliqueBotao());
		this.botao6.addActionListener(new CliqueBotao());
		this.botao7.addActionListener(new CliqueBotao());
		this.botao8.addActionListener(new CliqueBotao());
		this.botao9.addActionListener(new CliqueBotao());
		this.botao10.addActionListener(new CliqueBotao());
		this.botao11.addActionListener(new CliqueBotao());
		this.botao12.addActionListener(new CliqueBotao());
		this.botao13.addActionListener(new CliqueBotao());
		this.botao14.addActionListener(new CliqueBotao());
		this.botao15.addActionListener(new CliqueBotao());
		this.botao16.addActionListener(new CliqueBotao());
		this.botao17.addActionListener(new CliqueBotao());
		this.botao18.addActionListener(new CliqueBotao());
		this.botao19.addActionListener(new CliqueBotao());
		this.botao20.addActionListener(new CliqueBotao());
		this.botao21.addActionListener(new CliqueBotao());
		this.botao22.addActionListener(new CliqueBotao());
		this.botao23.addActionListener(new CliqueBotao());
		this.botao24.addActionListener(new CliqueBotao());


		// Define o layout do container basico
		setLayout(new GridLayout(4,1));

		// Define o layout dos panels
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));


		//Adiciona os botoes no painel
		p1.add(botao1);
		p1.add(botao2);
		p1.add(botao3);
		p1.add(botao4);
		p1.add(botao5);
		p1.add(botao6);
		p2.add(botao7);
		p2.add(botao8);
		p2.add(botao9);
		p2.add(botao10);
		p2.add(botao11);
		p2.add(botao12);
		p3.add(botao13);
		p3.add(botao14);
		p3.add(botao15);
		p3.add(botao16);
		p3.add(botao17);
		p3.add(botao18);
		p4.add(botao19);
		p4.add(botao20);
		p4.add(botao21);
		p4.add(botao22);
		p4.add(botao23);
		p4.add(botao24);


		// Adiciona os dois painéis no container básico
		add(p1);
		add(p2);
		add(p3);
		add(p4);


	}

	class CliqueBotao implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == TelaBotoesImagem.this.botao1){
				if (TelaBotoesImagem.this.botao1.getIcon() == TelaBotoesImagem.this.icone1){
					TelaBotoesImagem.this.botao1.setIcon(TelaBotoesImagem.this.iconea1);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea1;
					}
					else
						status1 = TelaBotoesImagem.this.iconea1;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao1.setIcon(TelaBotoesImagem.this.icone1);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}else if(e.getSource() == TelaBotoesImagem.this.botao2){
				if(TelaBotoesImagem.this.botao2.getIcon() == TelaBotoesImagem.this.icone2){
					TelaBotoesImagem.this.botao2.setIcon(TelaBotoesImagem.this.iconea2);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea2;
					}
					else
						status1 = TelaBotoesImagem.this.iconea2;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao2.setIcon(TelaBotoesImagem.this.icone2);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao3){
				if(TelaBotoesImagem.this.botao3.getIcon() == TelaBotoesImagem.this.icone3){
					TelaBotoesImagem.this.botao3.setIcon(TelaBotoesImagem.this.iconea3);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea3;
					}
					else
						status1 = TelaBotoesImagem.this.iconea3;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao3.setIcon(TelaBotoesImagem.this.icone3);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao4){
				if(TelaBotoesImagem.this.botao4.getIcon() == TelaBotoesImagem.this.icone4){
					TelaBotoesImagem.this.botao4.setIcon(TelaBotoesImagem.this.iconea4);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea4;
					}
					else
						status1 = TelaBotoesImagem.this.iconea4;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
				} else {
					TelaBotoesImagem.this.botao4.setIcon(TelaBotoesImagem.this.icone4);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao5){
				if(TelaBotoesImagem.this.botao5.getIcon() == TelaBotoesImagem.this.icone5){
					TelaBotoesImagem.this.botao5.setIcon(TelaBotoesImagem.this.iconea5);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea5;
					}
					else
						status1 = TelaBotoesImagem.this.iconea5;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao5.setIcon(TelaBotoesImagem.this.icone5);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao6){
				if(TelaBotoesImagem.this.botao6.getIcon() == TelaBotoesImagem.this.icone6){
					TelaBotoesImagem.this.botao6.setIcon(TelaBotoesImagem.this.iconea6);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea6;
					}
					else
						status1 = TelaBotoesImagem.this.iconea6;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
				
				} else {
					TelaBotoesImagem.this.botao6.setIcon(TelaBotoesImagem.this.icone6);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao7){
				if(TelaBotoesImagem.this.botao7.getIcon() == TelaBotoesImagem.this.icone7){
					TelaBotoesImagem.this.botao7.setIcon(TelaBotoesImagem.this.iconea7);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea7;
					}
					else
						status1 = TelaBotoesImagem.this.iconea7;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao7.setIcon(TelaBotoesImagem.this.icone7);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao8){
				if(TelaBotoesImagem.this.botao8.getIcon() == TelaBotoesImagem.this.icone8){
					TelaBotoesImagem.this.botao8.setIcon(TelaBotoesImagem.this.iconea8);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea8;
					}
					else
						status1 = TelaBotoesImagem.this.iconea8;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao8.setIcon(TelaBotoesImagem.this.icone8);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao9){
				if(TelaBotoesImagem.this.botao9.getIcon() == TelaBotoesImagem.this.icone9){
					TelaBotoesImagem.this.botao9.setIcon(TelaBotoesImagem.this.iconea9);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea9;
					}
					else
						status1 = TelaBotoesImagem.this.iconea9;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao9.setIcon(TelaBotoesImagem.this.icone9);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao10){
				if(TelaBotoesImagem.this.botao10.getIcon() == TelaBotoesImagem.this.icone10){
					TelaBotoesImagem.this.botao10.setIcon(TelaBotoesImagem.this.iconea10);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea10;
					}
					else
						status1 = TelaBotoesImagem.this.iconea10;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao10.setIcon(TelaBotoesImagem.this.icone10);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao11){
				if(TelaBotoesImagem.this.botao11.getIcon() == TelaBotoesImagem.this.icone11){
					TelaBotoesImagem.this.botao11.setIcon(TelaBotoesImagem.this.iconea11);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea11;
					}
					else
						status1 = TelaBotoesImagem.this.iconea11;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao11.setIcon(TelaBotoesImagem.this.icone11);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao12){
				if(TelaBotoesImagem.this.botao12.getIcon() == TelaBotoesImagem.this.icone12){
					TelaBotoesImagem.this.botao12.setIcon(TelaBotoesImagem.this.iconea12);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea12;
					}
					else
						status1 = TelaBotoesImagem.this.iconea12;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao12.setIcon(TelaBotoesImagem.this.icone12);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			/// meio
			else if(e.getSource() == TelaBotoesImagem.this.botao13){
				if(TelaBotoesImagem.this.botao13.getIcon() == TelaBotoesImagem.this.icone13){
					TelaBotoesImagem.this.botao13.setIcon(TelaBotoesImagem.this.iconea6);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea6;
					}
					else
						status1 = TelaBotoesImagem.this.iconea6;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao13.setIcon(TelaBotoesImagem.this.icone13);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao14){
				if(TelaBotoesImagem.this.botao14.getIcon() == TelaBotoesImagem.this.icone14){
					TelaBotoesImagem.this.botao14.setIcon(TelaBotoesImagem.this.iconea5);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea5;
					}
					else
						status1 = TelaBotoesImagem.this.iconea5;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao14.setIcon(TelaBotoesImagem.this.icone14);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao15){
				if(TelaBotoesImagem.this.botao15.getIcon() == TelaBotoesImagem.this.icone15){
					TelaBotoesImagem.this.botao15.setIcon(TelaBotoesImagem.this.iconea4);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea4;
					}
					else
						status1 = TelaBotoesImagem.this.iconea4;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao15.setIcon(TelaBotoesImagem.this.icone15);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao16){
				if(TelaBotoesImagem.this.botao16.getIcon() == TelaBotoesImagem.this.icone16){
					TelaBotoesImagem.this.botao16.setIcon(TelaBotoesImagem.this.iconea3);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea3;
					}
					else
						status1 = TelaBotoesImagem.this.iconea3;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao16.setIcon(TelaBotoesImagem.this.icone16);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao17){
				if(TelaBotoesImagem.this.botao17.getIcon() == TelaBotoesImagem.this.icone17){
					TelaBotoesImagem.this.botao17.setIcon(TelaBotoesImagem.this.iconea2);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea2;
					}
					else
						status1 = TelaBotoesImagem.this.iconea2;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao17.setIcon(TelaBotoesImagem.this.icone17);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao18){
				if(TelaBotoesImagem.this.botao18.getIcon() == TelaBotoesImagem.this.icone18){
					TelaBotoesImagem.this.botao18.setIcon(TelaBotoesImagem.this.iconea1);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea1;
					}
					else
						status1 = TelaBotoesImagem.this.iconea1;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao18.setIcon(TelaBotoesImagem.this.icone18);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao19){
				if(TelaBotoesImagem.this.botao19.getIcon() == TelaBotoesImagem.this.icone19){
					TelaBotoesImagem.this.botao19.setIcon(TelaBotoesImagem.this.iconea12);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea12;
					}
					else
						status1 = TelaBotoesImagem.this.iconea12;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao19.setIcon(TelaBotoesImagem.this.icone19);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao20){
				if(TelaBotoesImagem.this.botao20.getIcon() == TelaBotoesImagem.this.icone20){
					TelaBotoesImagem.this.botao20.setIcon(TelaBotoesImagem.this.iconea11);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea11;
					}
					else
						status1 = TelaBotoesImagem.this.iconea11;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
				} else {
					TelaBotoesImagem.this.botao20.setIcon(TelaBotoesImagem.this.icone20);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao21){
				if(TelaBotoesImagem.this.botao21.getIcon() == TelaBotoesImagem.this.icone21){
					TelaBotoesImagem.this.botao21.setIcon(TelaBotoesImagem.this.iconea10);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea10;
					}
					else
						status1 = TelaBotoesImagem.this.iconea10;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao21.setIcon(TelaBotoesImagem.this.icone21);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao22){
				if(TelaBotoesImagem.this.botao22.getIcon() == TelaBotoesImagem.this.icone22){
					TelaBotoesImagem.this.botao22.setIcon(TelaBotoesImagem.this.iconea9);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea9;
					}
					else
						status1 = TelaBotoesImagem.this.iconea9;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao22.setIcon(TelaBotoesImagem.this.icone22);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao23){
				if(TelaBotoesImagem.this.botao23.getIcon() == TelaBotoesImagem.this.icone23){
					TelaBotoesImagem.this.botao23.setIcon(TelaBotoesImagem.this.iconea8);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea8;
					}
					else
						status1 = TelaBotoesImagem.this.iconea8;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao23.setIcon(TelaBotoesImagem.this.icone23);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
				}
			}
			else if(e.getSource() == TelaBotoesImagem.this.botao24){
				if(TelaBotoesImagem.this.botao24.getIcon() == TelaBotoesImagem.this.icone24){
					TelaBotoesImagem.this.botao24.setIcon(TelaBotoesImagem.this.iconea7);
					if( status == TelaBotoesImagem.this.iconea0){
						status = TelaBotoesImagem.this.iconea7;
					}
					else
						status1 = TelaBotoesImagem.this.iconea7;
					if(status == status1)
						JOptionPane.showMessageDialog(frame, "Acertou");
					
				} else {
					TelaBotoesImagem.this.botao24.setIcon(TelaBotoesImagem.this.icone24);
					status = TelaBotoesImagem.this.iconea0;
					status1 = TelaBotoesImagem.this.iconea0;
					
				}
			}
			TelaBotoesImagem.this.painelPrincipal.revalidate();
			TelaBotoesImagem.this.painelPrincipal.repaint();

		}

	}
}


