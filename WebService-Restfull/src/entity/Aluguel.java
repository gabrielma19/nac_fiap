package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALUGUEL_IMOVEL")
@SequenceGenerator(name="SeqAluguel", sequenceName="SQ_TB_ALUGUEL", allocationSize = 1)
public class Aluguel {
	@Id
	@GeneratedValue(generator="SeqAluguel", strategy= GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="VL_VALOR")
	private int valor;
	
	@Column(name="DS_LOCAL")
	private String local;
	
	@Column(name="DS_CIDADE")
	private String cidade;
	
	@Column(name="NM_IMOB")
	private String imobiliaria;
	
	

	public Aluguel() {
		super();
	}

	public Aluguel(int codigo, int valor, String local, String cidade, String imobiliaria) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.local = local;
		this.cidade = cidade;
		this.imobiliaria = imobiliaria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getImobiliaria() {
		return imobiliaria;
	}

	public void setImobiliaria(String imobiliaria) {
		this.imobiliaria = imobiliaria;
	}
	
	
}
