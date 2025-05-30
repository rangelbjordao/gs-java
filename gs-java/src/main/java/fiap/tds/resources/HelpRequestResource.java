package fiap.tds.resources;

import fiap.tds.dtos.HelpRequestDTO;
import fiap.tds.services.HelpRequestService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/solicitar-ajuda")
public class HelpRequestResource {
    @Inject
    HelpRequestService helpRequestService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response reportHelpRequest(HelpRequestDTO helpDto){
        var helpRequest = helpRequestService.reportHelpRequest(helpDto);
        return Response.status(Response.Status.CREATED).entity(helpRequest).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getHelpById(@PathParam("id") Long id) {
        var helpId = helpRequestService.findHelpById(id);
        return Response.ok(helpId).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllHelpRequests() {
        var helpList = helpRequestService.getAllHelpRequests();
        if (helpList == null || helpList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Nenhuma solicitação de ajuda encontrada.").build();
        }
        return Response.ok(helpList).build();

    }
}
