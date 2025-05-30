package fiap.tds.services;

import fiap.tds.dtos.HelpRequestDTO;
import fiap.tds.models.HelpRequest;
import fiap.tds.models.Status;
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
    public void reportHelpRequest(HelpRequestDTO helpDto) {
        try {
            var help = new HelpRequest();
            help.setLatitude(helpDto.getLatitude());
            help.setLongitude(helpDto.getLongitude());
            help.setRequestTimestamp(LocalDateTime.now());
            help.setStatus(Status.PENDENTE);
            help.setNotes(helpDto.getNotes());
            help.setContactInfo(helpDto.getContactInfo());
            helpRequestRepository.persistHelp(help);
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao registrar solicitação de ajuda: " + e.getMessage(), e);
        }
    }


}
