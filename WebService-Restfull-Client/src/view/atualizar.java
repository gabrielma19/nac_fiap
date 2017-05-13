package view;

import javax.swing.JOptionPane;

import TO.AluguelTO;
import repository.AluguelRepository;

public class atualizar {
	public static void main(String[] args) {
		AluguelRepository rep = new AluguelRepository();
		
		int codRemove = Integer.parseInt(JOptionPane.showInputDialog("Codigo valido para atualizar!"));
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Valor do Imovel"));
		String local = JOptionPane.showInputDialog("Digite a rua");
		String cidade = JOptionPane.showInputDialog("Digite a cidade");
		String imob = JOptionPane.showInputDialog("Nome da Imobiliaria");
		
		try {
			AluguelTO aluguel = new AluguelTO(codRemove, valor, local, cidade, imob );
			rep.atualizar(aluguel);
			System.out.println("Atualizado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
