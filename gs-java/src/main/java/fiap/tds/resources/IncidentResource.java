package fiap.tds.resources;

import fiap.tds.dtos.HelpRequestDTO;
import fiap.tds.dtos.HelpRequestResponseDTO;
import fiap.tds.models.HelpRequest;
import fiap.tds.services.HelpRequestService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.stream.Collectors;

@Path("/incidentes")
public class IncidentResource {
    @Inject
    HelpRequestService helpService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllIncidents() {
        var incidents = helpService.getAllHelpRequests();
        if (incidents.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity("Nenhum incidente encontrado").build();
        }
        var incidentsFiltered = incidents.stream()
                .map(h -> new HelpRequestResponseDTO(
                        h.getId(),
                        h.getCep(),
                        h.getNotes(),
                        h.getContactInfo(),
                        h.getLatitude(),
                        h.getLongitude(),
                        h.getStatus().name()
                ))
                .collect(Collectors.toList());

        return Response.ok(incidentsFiltered).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getIncidentById(@PathParam("id") Long id) {
        var incident = helpService.findHelpById(id);
        if (incident == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Incidente não encontrado").build();
        }
        return Response.ok(incident).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response resolveIncident(@PathParam("id") Long id) {
        try {
            helpService.resolveHelpRequest(id);
            return Response.ok("Incidente resolvido com sucesso!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Não foi possível encontrar o incidente: " + e.getMessage()).build();
        }
    }
}
