package fiap.tds.repositories;

import fiap.tds.models.HelpRequest;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class HelpRequestRepository implements PanacheRepository<HelpRequest> {
    public void persistHelp(HelpRequest helpRequest) {
        helpRequest.persist();
    }
}
