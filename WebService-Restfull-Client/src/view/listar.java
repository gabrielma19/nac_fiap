package view;

import java.util.List;

import TO.AluguelTO;
import repository.AluguelRepository;

public class listar {
	public static void main(String[] args) {
		
		AluguelRepository rep = new AluguelRepository();

		try {
			List<AluguelTO> lista = rep.listar();
			System.out.println("Listado com sucesso");
			for(AluguelTO aluguel : lista){
				
				System.out.println(aluguel.getValor());
				System.out.println(aluguel.getLocal());
				System.out.println(aluguel.getCidade());
				System.out.println(aluguel.getImobiliaria());
				System.out.println("-----------------------------------");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
