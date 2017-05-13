package repository;


	import java.util.List;
	import java.util.Arrays;

	import javax.ws.rs.core.MediaType;

	import com.sun.jersey.api.client.Client;
	import com.sun.jersey.api.client.ClientResponse;
	import com.sun.jersey.api.client.WebResource;

	import TO.AluguelTO;
	import exception.WebServiceException;

	public class AluguelRepository {
		private static final String URL = "http://localhost:8080/WebService-Restfull/rest/aluga/";
		
		private Client cliente = Client.create();
		
		public List<AluguelTO> listar() throws WebServiceException{
			 WebResource resource = cliente.resource(URL);
			 ClientResponse response = resource.accept(
				MediaType.APPLICATION_JSON).get(ClientResponse.class);
			 if (response.getStatus() == 200){
				 AluguelTO[] aluguel = response.getEntity(AluguelTO[].class);
				 return Arrays.asList(aluguel);
			 }
			 throw new WebServiceException("HTTP Status: " 
					 							+ response.getStatus());
		}
		public AluguelTO buscar(int id) throws WebServiceException{
			WebResource resource = cliente.resource(URL + id);
			ClientResponse response = resource.accept(
				MediaType.APPLICATION_JSON).get(ClientResponse.class);
			if (response.getStatus() == 200){
				AluguelTO aluguel = response.getEntity(AluguelTO.class);
				return aluguel;
			}
			throw new WebServiceException("HTTP Status: " +
												response.getStatus());
		}
		public void cadastrar(AluguelTO aluguel) throws WebServiceException{
			WebResource resource = cliente.resource(URL);
			ClientResponse response = resource.type(
					MediaType.APPLICATION_JSON)
					 .post(ClientResponse.class,aluguel);
			 if (response.getStatus() != 201)
				 throw new WebServiceException("HTTP Status: " + response.getStatus());
		}
		public void atualizar(AluguelTO aluguel) throws WebServiceException{
			WebResource resource = 
					cliente.resource(URL + aluguel.getCodigo());
			ClientResponse response = resource.type(
					MediaType.APPLICATION_JSON)
					.put(ClientResponse.class,aluguel);
			if (response.getStatus() != 200)
				throw new WebServiceException("HTTP Status: " +
												response.getStatus());
		}
		public void remover(int codigo) throws WebServiceException{
			WebResource resource = cliente.resource(URL + codigo);
			ClientResponse response = resource.delete(ClientResponse.class);
			if (response.getStatus() != 204)
				throw new WebServiceException("HTTP Status: " +
												response.getStatus());
		}
		
	}
	