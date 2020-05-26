package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;

import lt.vu.entities.Factory;
import lt.vu.persistence.FactoriesDAO;
import lt.vu.rest.dto.FactoryDto;
import lt.vu.services.Capitalizer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/factories")
public class FactoryController {

    @Inject
    @Setter @Getter
    private FactoriesDAO factoriesDAO;

    @Inject
    private Capitalizer capitalizer;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Factory factory = factoriesDAO.findOne(id);
        if (factory == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        FactoryDto factoryDto = new FactoryDto();
        factoryDto.setName(factory.getName());
        factoryDto.setId(factory.getId());

        return Response.ok(factoryDto).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create (FactoryDto factoryData) {
        Factory factory = new Factory();
        factory.setName(capitalizer.capitalize(factoryData.getName()));
        factoriesDAO.persist(factory);
        return Response.ok().build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update (@PathParam("id") final Integer id, FactoryDto factoryDto) {
        try {
            Factory localFactory = factoriesDAO.findOne(id);
            if (localFactory == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            localFactory.setName(capitalizer.capitalize(factoryDto.getName()));
            factoriesDAO.update(localFactory);
            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}