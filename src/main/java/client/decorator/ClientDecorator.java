package client.decorator;

import client.Client;

public abstract class ClientDecorator implements Client {
	Client decorated;

	public ClientDecorator(Client decorated) {
		this.decorated = decorated;
	}
}
