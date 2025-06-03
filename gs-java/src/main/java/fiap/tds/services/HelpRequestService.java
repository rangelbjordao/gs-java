package fiap.tds.services;

import fiap.tds.client.NominatimClient;
import fiap.tds.dtos.HelpRequestDTO;
import fiap.tds.dtos.NominatimSearchResponseDTO;
import fiap.tds.models.HelpRequest;
import fiap.tds.models.Status;
import fiap.tds.repositories.HelpRequestRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;
import java.util.List;


@ApplicationScoped
public class HelpRequestService {

    @Inject
    HelpRequestRepository helpRequestRepository;

    @Inject
    @RestClient
    NominatimClient nominatimClient;

    private final String appUserAgent = "MeuAppSOS-FIAP/1.0 (rm561160@fiap.com.br)";

    // This another way to implement the method, returns the entity created, and show the id etc.
    @Transactional
    public HelpRequest reportHelpRequest(HelpRequestDTO helpDto) {
        var help = new HelpRequest();
        help.setNotes(helpDto.getNotes());
        help.setContactInfo(helpDto.getContactInfo());
        help.setRequestTimestamp(LocalDateTime.now());
        help.setStatus(Status.PENDENTE);

        try {
            List<NominatimSearchResponseDTO> results = nominatimClient.searchByQuery(
                    "json",
                    helpDto.getCep(),
                    "br",
                    1,
                    "pt-BR",
                    appUserAgent
            );

            if (results != null && !results.isEmpty()) {
                NominatimSearchResponseDTO location = results.getFirst();

                help.setLatitude(Double.parseDouble(location.lat));
                help.setLongitude(Double.parseDouble(location.lon));
                help.setEnderecoAproximado(location.display_name);
                help.setCep(helpDto.getCep());
            } else {
                System.err.println("Nominatim: Nenhuma coordenada encontrada para o CEP fornecido.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar localização via CEP: " + e.getMessage());
        }

        helpRequestRepository.save(help);
        return help;
    }



    public HelpRequest findHelpById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo.");
        }
        var helpRequest = helpRequestRepository.findById(id);
        if (helpRequest.isEmpty()) {
            throw new NotFoundException("Nenhum objeto foi encontrado com o id: " + id);
        }
        return null;
    }

    // This method will return all help requests, GET request maybe it will exclusively for admins.
    public List<HelpRequest> getAllHelpRequests() {
        var helpList = helpRequestRepository.findAll();
        if (helpList == null || helpList.isEmpty()) {
            throw new NotFoundException("Nenhuma solicitação de ajuda encontrada.");
        }
        return helpList;
    }

}



