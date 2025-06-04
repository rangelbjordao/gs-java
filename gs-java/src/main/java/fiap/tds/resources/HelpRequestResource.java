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
}
