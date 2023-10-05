package fr.humanbooster.fx.plage.business;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Concessionnaire extends Utilisateur {

	private String numeroDeTelephone;
	
	
}
