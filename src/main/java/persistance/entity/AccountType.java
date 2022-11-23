package persistance.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class AccountType {

	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String name;

}
