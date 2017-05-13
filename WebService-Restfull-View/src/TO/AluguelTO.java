package TO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AluguelTO {
	
		private int codigo;
	
		private int valor;
		
		private String local;
		
		private String cidade;
		
		private String imobiliaria;
		
		
		public AluguelTO() {
			super();
		}

		public AluguelTO(int codigo, int valor, String local, String cidade, String imobiliaria) {
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
