package fiap.tds.services;

import fiap.tds.dtos.HelpRequestDTO;
import fiap.tds.models.HelpRequest;
import fiap.tds.repositories.HelpRequestRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@ApplicationScoped
public class HelpRequestService {

    @Inject
    HelpRequestRepository helpRequestRepository;

    @Transactional
    public void reportHelpRequest(HelpRequestDTO helpDto){
        var help = new HelpRequest();
        help.setLatitude(help.getLatitude());
        help.setLongitude(help.getLongitude());
        help.setRequestTimestamp(LocalDateTime.now());
        help.setStatus(help.getStatus());
        help.setNotes(help.getNotes());
        help.setContactInfo(help.getContactInfo());
        helpRequestRepository.persistHelp(help);
    }
}
