//package trabalhoProdutorConsumidor;

import javax.swing.JButton;


public class ButtonOperation{
	private JButton produtor;
	private JButton consumidor;

	public ButtonOperation(){
		produtor = new JButton("Produtor");
		consumidor = new JButton("Consumidor");
	}
	
	public JButton getButtonProdutor(){
		return produtor;
	}
	
	public JButton getButtonConsumidor(){
		return consumidor;
	}
}