package fr.humanbooster.fx.plage.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.humanbooster.fx.plage.business.Client;
import fr.humanbooster.fx.plage.dto.ClientDto;

public interface ClientService {

	/**
	 * La méthode renvoie une page de Client
	 * 
	 * @param pageable qui correspond à une demande de page
	 * @return une page de clients
	 */
	Page<Client> recupererClients(Pageable pageable);

	Client recupererClient(Long idClient);

	Client enregistrerClient(Client client);

	Client enregistrerClient(ClientDto clientDto);

	boolean supprimerClient(Long id);
}
