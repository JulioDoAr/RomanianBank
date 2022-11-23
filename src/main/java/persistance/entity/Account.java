package persistance.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Account {

	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String code;

	@Getter
	@Setter
	private double amount;

	@Getter
	@Setter
	private int clientId;

	@Getter
	@Setter
	private int accountTypeId;
}
