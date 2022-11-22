package main;

import logger.ConsoleOutputOperation;
import logger.Logger;
import persistance.Database;

public class Main {

	public static void main(String[] args) {
		Logger.getInstance().addOutputOperation(new ConsoleOutputOperation());
		Logger.getInstance().startWrite();

		Database db = Database.getInstance();
		Logger.getInstance().finishWrite();
	}

}
