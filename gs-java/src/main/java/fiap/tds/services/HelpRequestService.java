package fiap.tds.services;

import fiap.tds.dtos.HelpRequestDTO;
import fiap.tds.models.HelpRequest;
import fiap.tds.models.Status;
import fiap.tds.repositories.HelpRequestRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HelpRequestService {

    @Inject
    HelpRequestRepository helpRequestRepository;

    // This another way to implement the method, returns the entity created, and show the id etc.
    @Transactional
    public HelpRequest reportHelpRequest(HelpRequestDTO helpDto) {
        try {
            var help = new HelpRequest();
            help.setLatitude(helpDto.getLatitude());
            help.setLongitude(helpDto.getLongitude());
            help.setRequestTimestamp(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toLocalDateTime());
            help.setStatus(Status.PENDENTE);
            help.setNotes(helpDto.getNotes());
            help.setContactInfo(helpDto.getContactInfo());
            helpRequestRepository.persistHelp(help);
            return help;
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao registrar solicitação de ajuda: " + e.getMessage(), e);
        }
    }

    public HelpRequest findHelpById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo.");
        }
        var helpRequest = helpRequestRepository.findHelpById(id);
        if (helpRequest == null) {
            throw new NotFoundException("Nenhum objeto foi encontrado com o id: " + id);
        }
        return helpRequest;
    }

    // This method will return all help requests, GET request maybe it will exclusively for admins.
    public List<HelpRequest> getAllHelpRequests() {
        var helpList = helpRequestRepository.findAllHelpRequests();
        if (helpList == null || helpList.isEmpty()) {
            throw new NotFoundException("Nenhuma solicitação de ajuda encontrada.");
        }
        return helpList;
    }

}













    // This is the original method, it does not return the entity created, just void.
    /**
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
    **/



