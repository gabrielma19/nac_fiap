package resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import dao.AluguelDAO;
import dao.impl.AluguelDAOImpl;
import entity.Aluguel;
import exception.CommitErrorException;
import singleton.EntityManagerFactorySingleton;

@Path("/aluga")
public class AluguelResource {
	
	private EntityManagerFactory emf;
	
	public AluguelResource(){
		emf = EntityManagerFactorySingleton.getInstance();
	}
	
	@GET
	@Path("/{cdImovel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aluguel buscar(@PathParam("cdImovel") int id){
		EntityManager em = emf.createEntityManager();
		AluguelDAO dao = new AluguelDAOImpl(em);
		Aluguel aluguel = dao.buscar(id);
		em.close();
		return aluguel;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aluguel> listar(){
		EntityManager em = emf.createEntityManager();
		AluguelDAO dao = new AluguelDAOImpl(em);
		List<Aluguel> lista = dao.listar();
		em.close();
		return lista;	
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Aluguel aluguel, @PathParam("id") int cdImovel){
		EntityManager em = emf.createEntityManager();
		AluguelDAO dao = new AluguelDAOImpl(em);
		aluguel.setCdImovel(cdImovel);
		try {
			dao.atualizar(aluguel);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
		return Response.ok().build();
	}
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int cdImovel){
		EntityManager em = emf.createEntityManager();
		AluguelDAO dao = new AluguelDAOImpl(em);
		try {
			dao.excluir(cdImovel);
			dao.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			em.close();
		}
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //Recebe JSON
	public Response cadastrar(Aluguel aluguel, 
				@Context UriInfo uriInfo){
		//Cria o DAO
		EntityManager em = emf.createEntityManager();
		AluguelDAO dao = new AluguelDAOImpl(em);
		//Utiliza o DAO para cadastrar
		try {
			dao.cadastrar(aluguel);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		//Retorna a URL e o HTTP status 201 (created)
		
		UriBuilder url = UriBuilder.fromPath(uriInfo.getPath());
		url.path(String.valueOf(aluguel.getCdImovel()));
		return Response.created(url.build()).build();
	}
	
	
	
}
