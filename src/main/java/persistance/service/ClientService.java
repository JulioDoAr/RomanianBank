package persistance.service;

import java.util.List;

import client.Client;

public interface ClientService {

	Client create(Client client);

	Client findByName(String name);

	List<Client> getAllByCode();

}
