package view;

import javax.swing.JOptionPane;

import repository.AluguelRepository;

public class deletar {
	public static void main(String[] args) {
		AluguelRepository rep = new AluguelRepository();
		String codRemove = JOptionPane.showInputDialog("Codigo valido para remoção!");
			try {
				rep.remover(Integer.parseInt(codRemove));
				System.out.println("Removido com sucesso");
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
	}
}
