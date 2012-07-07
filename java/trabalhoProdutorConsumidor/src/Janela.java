//package trabalhoProdutorConsumidor;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


public class Janela extends JFrame implements ActionListener, DisplayTextField{
	private ButtonOperation buttons;
	private JLabel label[];
	private CubbyHole1 cubby;
	
	public Janela() {
		super("Trablaho Produtor consumidor");
		setLayout( new GridLayout(2,4,3,3) ); 
		buttons = new ButtonOperation();
		label = new JLabel[4];
		label[0] = new JLabel("Nome Consumidor:");
		label[1] = new JLabel("Valor a consumir:");
		label[2] = new JLabel("Nome Produtor:");
		label[3] = new JLabel("Valor a produzir:");
		cubby = new CubbyHole1();
		add(label[2]);
		add(displayNomeProducer);
		add(label[3]);
		add(displayProducer);
		add(buttons.getButtonProdutor());
		add(label[0]);
		add(displayNomeConsumer);
		add(label[1]);
		add(displayConsumer);
		add(buttons.getButtonConsumidor());
		buttons.getButtonProdutor().addActionListener(this);
		buttons.getButtonConsumidor().addActionListener(this);

		//Evita que a JFrame seja redimensionada
		pack();
		this.setResizable(false);
		
		//setSize(350, 250);
		setVisible(true);	
	}

	public void actionPerformed( ActionEvent event ) {
		if (event.getSource() == buttons.getButtonProdutor()){
			String msgProducer = "";
			if(displayNomeProducer.getText().length()== 0){
				msgProducer = "Informe um nome para o produtor.";
				JOptionPane.showMessageDialog( null, msgProducer, "Alerta produtor", JOptionPane.PLAIN_MESSAGE );
				label[2].setForeground(Color.RED);
			}
			
			if(displayProducer.getText().length()== 0){
				msgProducer = msgProducer + "\nInforme um Valor para produção.";
				JOptionPane.showMessageDialog( null, msgProducer, "Alerta produtor", JOptionPane.PLAIN_MESSAGE );
				label[3].setForeground(Color.RED);
			}

			if(msgProducer == ""){
				Producer auxProducer = new Producer(cubby, Integer.parseInt(displayProducer.getText()), displayNomeProducer.getText());
				auxProducer.start();
				label[2].setForeground(Color.BLACK);
				label[3].setForeground(Color.BLACK);
				JOptionPane.showMessageDialog( null, "não tem erro "+displayProducer.getText()+" - "+displayNomeProducer.getText(), "Alerta produtor", JOptionPane.PLAIN_MESSAGE );
			}
		}
		
		if (event.getSource() == buttons.getButtonConsumidor()){
			//System.out.println("consumidor");
			String msgConsumer = "";
			if(displayNomeConsumer.getText().length()== 0){
				msgConsumer = "Informe um nome para o consumidor.";
				JOptionPane.showMessageDialog( null, msgConsumer, "Alerta consumidor", JOptionPane.PLAIN_MESSAGE );
				label[0].setForeground(Color.RED);
			}
			
			if(displayConsumer.getText().length()== 0){
				msgConsumer = msgConsumer + "\nInforme um Valor ser consumido.";
				JOptionPane.showMessageDialog( null, msgConsumer, "Alerta consumidor", JOptionPane.PLAIN_MESSAGE );
				label[1].setForeground(Color.RED);
			}

			if(msgConsumer == ""){
				Consumer auxConsumer = new Consumer(cubby, Integer.parseInt(displayConsumer.getText()), displayNomeConsumer.getText());
				auxConsumer.start();
				criaConsumidor(displayNomeConsumer.getText(), displayConsumer.getText());
				label[0].setForeground(Color.BLACK);
				label[1].setForeground(Color.BLACK);
				JOptionPane.showMessageDialog( null, "não tem erro "+displayConsumer.getText()+" - "+displayNomeConsumer.getText(), "Alerta consumidor", JOptionPane.PLAIN_MESSAGE );
			}
		}
	}
	
	public void criaConsumidor(String nome, String valor){
		JFrame frame = new JFrame(nome);
		frame.setLayout(new FlowLayout());
		JLabel labeltemp = new JLabel(valor);
		frame.add(labeltemp);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
