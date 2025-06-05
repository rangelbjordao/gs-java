package fiap.tds.resources;

import fiap.tds.dtos.UsersDTO;
import fiap.tds.models.Users;
import fiap.tds.services.UsersService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
public class UserRegisterResource {

    @Inject
    UsersService usersService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(UsersDTO usersDTO) {
        usersService.register(usersDTO);
        return Response.status(Response.Status.CREATED).entity("Usuário cadastrado com sucesso!").build();
    }
}
