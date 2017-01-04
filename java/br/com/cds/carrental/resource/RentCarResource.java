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

import br.com.cds.carrental.dao.CarDAO;
import br.com.cds.carrental.dao.ICarDAO;
import br.com.cds.carrental.dao.IRentCarDAO;
import br.com.cds.carrental.dao.RentalCarDAO;
import br.com.cds.carrental.domain.Car;
import br.com.cds.carrental.domain.RentCar;

@Path("/rentacar")
public class RentCarResource {

	private static final Logger LOGGER = Logger.getLogger(RentCarResource.class);

	private IRentCarDAO<RentCar, Long> dao;
	private ICarDAO<Car, Long> carDao;

	public RentCarResource() {
		this.dao = new RentalCarDAO();
		this.carDao = new CarDAO();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response save(RentCar rentCar) {
		try {
//			if(dao.findRent(rentCar.getCustomer().getId(),
//					rentCar.getCar().getId(),
//					rentCar.getCar().getRentalDate(),
//					rentCar.getCar().getReturnDate()).isEmpty())
				dao.save(rentCar);
//			else
//				return Response.status(226).entity("This car is already rented, please chose another car:"+rentCar.toString()).build();
			
			return Response
					.status(200)
					.entity("Registro inserido: " + rentCar.toString())
					.build();	
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	public Response update(RentCar rent) {
		try {
			
			dao.update(rent);
			
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
	public Car findById(@PathParam("id") Long id) {
		try {

			return carDao.findById(id);
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RentCar> findAll() {
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
	public List<RentCar> findAllXML() {
		try {
			
			return dao.findAll(); 
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}
	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByCustomer(@PathParam("name") String name) {
		LOGGER.info("NAME : " + name);
		try {
			
			List<RentCar> rent = dao.findByCustomer(name);
			
			GenericEntity<List<RentCar>> entities = new GenericEntity<List<RentCar>>(rent) {};
			
			return Response
					.ok(entities)
					.build();
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}
	
	
}
