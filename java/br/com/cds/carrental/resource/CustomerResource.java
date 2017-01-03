package br.com.cds.carrental.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.cds.carrental.dao.CustomerDAO;
import br.com.cds.carrental.dao.ICustomerDAO;
import br.com.cds.carrental.domain.Customer;

@Path("/customers")
public class CustomerResource {

	private static final Logger LOGGER = Logger.getLogger(CustomerResource.class);

	private ICustomerDAO<Customer, Long> dao;

	public CustomerResource() {
		this.dao = new CustomerDAO();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response save(Customer customer) {
		try {
		
			dao.save(customer);	
			
			return Response
					.status(200)
					.entity("Registro inserido: " + customer.toString())
					.build();	
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	public Response update(Customer customer) {
		try {
			
			dao.update(customer);
			
			return Response
					.status(200)
					.entity("Registro editado.")
					.build();	
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("id") Long id) {
		try {
			
			dao.delete(id);
			
			return Response
					.status(200)
					.entity("Registro removido.")
					.build();
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			Response
			.status(500)
			.entity("Erro ocorrido ao tentar excluir o contato:"+ex+"--"+ex.getMessage())
			.build();
			throw new WebApplicationException("Erro ocorrido ao tentar excluir o contato:"+ex+"--"+ex.getMessage());
		}
	}

	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Customer findById(@PathParam("id") Long id) {
		try {

			return dao.findById(id);
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> findAll() {
		try {
			
			return dao.findAll(); 
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Customer> findAllXML() {
		try {
			
			return dao.findAll(); 
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}
	@GET
	@Path("/cpf/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByCpf(@PathParam("cpf") String cpf) {
		LOGGER.info("NAME : " + cpf);
		try {
			
			List<Customer> customers = dao.findByCpf(cpf);
			
			GenericEntity<List<Customer>> entities = new GenericEntity<List<Customer>>(customers) {};
			
			return Response
					.ok(entities)
					.build();
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}
	
	@GET
	@Path("/cnpj/{cnpj}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByCnpj(@PathParam("cnpj") String cnpj) {
		LOGGER.info("NAME : " + cnpj);
		try {
			
			List<Customer> customers = dao.findByCnpj(cnpj);
			
			GenericEntity<List<Customer>> entities = new GenericEntity<List<Customer>>(customers) {};
			
			return Response
					.ok(entities)
					.build();
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}
}
