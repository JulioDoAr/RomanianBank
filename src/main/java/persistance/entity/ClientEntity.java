package persistance.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class ClientEntity {

	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String address;

	@Getter
	@Setter
	private Date birth;

	@Getter
	@Setter
	private int bankId;

}
