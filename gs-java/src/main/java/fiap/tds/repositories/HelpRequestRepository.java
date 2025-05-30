package fiap.tds.repositories;

import fiap.tds.models.HelpRequest;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class HelpRequestRepository implements PanacheRepository<HelpRequest> {
    public void persistHelp(HelpRequest helpRequest) {
        helpRequest.persist();
    }

    public HelpRequest findHelpById(Long id){
        var helpRequest = findById(id);
        if (helpRequest == null) {
            throw new NotFoundException("Nenhum objeto foi encontado com o id: " + id);
        }
        return helpRequest;
    }

    public List<HelpRequest> findAllHelpRequests() {
        var helpList = listAll();
        if (helpList.isEmpty()) {
            return null;
        }
        return helpList;
    }
}
