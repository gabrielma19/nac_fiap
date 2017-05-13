package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import TO.AluguelTO;
import repository.AluguelRepository;

@ManagedBean
public class ListAluguelBean {
private List<AluguelTO> lista;
	
	private AluguelRepository rep;
	
	@PostConstruct
	private void init(){
		rep = new AluguelRepository();
		try {
			lista = rep.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<AluguelTO> getLista() {
		return lista;
	}

	public void setLista(List<AluguelTO> lista) {
		this.lista = lista;
	}
	
}
