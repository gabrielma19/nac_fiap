package bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import TO.AluguelTO;
import repository.AluguelRepository;

@ManagedBean
public class AlugaBean {
		
	private int codigo;
	private AluguelTO aluga;
	private AluguelRepository rep;
	
	@PostConstruct
	public void init(){
		aluga = new AluguelTO();
		rep = new AluguelRepository();
	}
	
	public void buscar(){
		try {
			aluga = rep.buscar(codigo);
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	public String deletar(){
		try {
		rep.remover(codigo);
		System.out.println("Removido Com Sucesoo!");
		FacesMessage msg = new FacesMessage("Removido Com Sucesoo!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			e.printStackTrace();
			return "deletar-aluguel";
		}
		return "lista-aluguel";
	}
	
	public String cadastrar(){
		try {
			rep.cadastrar(aluga);
			System.out.println("Cadastrado com sucesso!");
			FacesMessage msg = new FacesMessage("Novo Aluguel cadastrado com sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			e.printStackTrace();
			return "cadastra-aluguel";
		}
		return "lista-aluguel";
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public AluguelTO getAluga() {
		return aluga;
	}
	public void setAluga(AluguelTO aluga) {
		this.aluga = aluga;
	}
	
	
			
}
