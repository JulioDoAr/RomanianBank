package client.decorator.impl;

import client.Client;
import client.decorator.ClientDecorator;

public class LifeEnsuresDecorator extends ClientDecorator {

	public LifeEnsuresDecorator(Client decorated) {
		super(decorated);
	}

	@Override
	public String toString() {
		return String.format("%s\nDecorated with Life Ensures", super.toString());
	}
}
