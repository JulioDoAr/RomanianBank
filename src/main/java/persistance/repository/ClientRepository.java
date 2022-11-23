package persistance.repository;

import client.Client;

public interface ClientRepository {

	boolean create(Client client);

	Client findByName(String name);

}
