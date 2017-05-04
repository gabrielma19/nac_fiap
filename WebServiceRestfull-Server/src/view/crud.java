package view;

import java.util.List;

import javax.swing.JOptionPane;

import entity.Aluguel;
import repository.AluguelRepository;

public class crud {
	public static void main(String[] args) {
		
		AluguelRepository rep = new AluguelRepository();

		String operacao = new String();
		operacao = JOptionPane.showInputDialog("Escolha a operação desejada");

		if (operacao.toUpperCase().equals("LISTAR")) {
			try {
				List<Aluguel> lista = rep.listar();
				for(Aluguel aluguel : lista){
					System.out.println(aluguel.getValor());
					System.out.println(aluguel.getLocal());
					System.out.println(aluguel.getCidade());
					System.out.println(aluguel.getImobiliaria());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (operacao.toUpperCase().equals("ATUALIZAR")){
			Aluguel aluguel = new Aluguel();
			try {
				rep.atualizar(aluguel);
				System.out.println("Atualizado com sucesso");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(operacao.toUpperCase().equals("CADASTRAR")){
			Aluguel aluguel = new Aluguel();
			try {
				rep.cadastrar(aluguel);
				System.out.println("Cadastrado com sucesso");
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}else if(operacao.toUpperCase().equals("REMOVER") || operacao.toUpperCase().equals("DELETAR")){
			String codRemove = new String();
			codRemove = JOptionPane.showInputDialog("Codigo valido para remoção!");
			try {
				rep.remover(Integer.parseInt(codRemove));
				System.out.println("Removido com sucesso");
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}else{
			System.out.println("Opção desejada não encontrada !!");
		}

	}
}
