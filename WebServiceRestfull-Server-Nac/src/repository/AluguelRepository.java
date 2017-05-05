package repository;

import java.util.List;
import java.util.Arrays;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import entity.Aluguel;
import exception.WebServiceException;

public class AluguelRepository {
	private static final String URL = "http://localhost:8080/WebServiceRestfull-Server-Nac/rest/aluga/";
	
	private Client cliente = Client.create();
	
	public List<Aluguel> listar() throws WebServiceException{
		 WebResource resource = cliente.resource(URL);
		 ClientResponse response = resource.accept(
			MediaType.APPLICATION_JSON).get(ClientResponse.class);
		 if (response.getStatus() == 200){
			 Aluguel[] aluguel = response.getEntity(Aluguel[].class);
			 return Arrays.asList(aluguel);
		 }
		 throw new WebServiceException("HTTP Status: " 
				 							+ response.getStatus());
	}
	public Aluguel buscar(int id) throws WebServiceException{
		WebResource resource = cliente.resource(URL + id);
		ClientResponse response = resource.accept(
			MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (response.getStatus() == 200){
			Aluguel aluguel = response.getEntity(Aluguel.class);
			return aluguel;
		}
		throw new WebServiceException("HTTP Status: " +
											response.getStatus());
	}
	public void cadastrar(Aluguel aluguel) throws WebServiceException{
		WebResource resource = cliente.resource(URL);
		ClientResponse response = resource.type(
				MediaType.APPLICATION_JSON)
				 .post(ClientResponse.class,aluguel);
		 if (response.getStatus() != 201)
			 throw new WebServiceException("HTTP Status: " +
					 						response.getStatus());
	}
	public void atualizar(Aluguel aluguel) throws WebServiceException{
		WebResource resource = 
				cliente.resource(URL + aluguel.getCdImovel());
		ClientResponse response = resource.type(
				MediaType.APPLICATION_JSON)
				.put(ClientResponse.class,aluguel);
		if (response.getStatus() != 200)
			throw new WebServiceException("HTTP Status: " +
											response.getStatus());
	}
	public void remover(int cdImovel) throws WebServiceException{
		WebResource resource = cliente.resource(URL + cdImovel);
		ClientResponse response = resource.delete(ClientResponse.class);
		if (response.getStatus() != 204)
			throw new WebServiceException("HTTP Status: " +
											response.getStatus());
	}
	
}
