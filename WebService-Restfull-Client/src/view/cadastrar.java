package view;


import javax.swing.JOptionPane;

import TO.AluguelTO;
import repository.AluguelRepository;

public class cadastrar {
	public static void main(String[] args) {
		
		AluguelRepository rep = new AluguelRepository();
		
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Valor do Imovel"));
		String local = JOptionPane.showInputDialog("Digite a rua");
		String cidade = JOptionPane.showInputDialog("Digite a cidade");
		String imob = JOptionPane.showInputDialog("Nome da Imobiliaria");
		
		try {
			AluguelTO aluguel = new AluguelTO(0, valor, local, cidade, imob);
			rep.cadastrar(aluguel);
			System.out.println("Cadastrado com sucesso");

				System.out.println(aluguel.getValor());
				System.out.println(aluguel.getLocal());
				System.out.println(aluguel.getCidade());
				System.out.println(aluguel.getImobiliaria());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não cadastrou");
			// TODO: handle exception
		}
	}
}
