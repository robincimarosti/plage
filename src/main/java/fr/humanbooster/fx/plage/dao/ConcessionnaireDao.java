package fr.humanbooster.fx.plage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.plage.business.Concessionnaire;

public interface ConcessionnaireDao extends JpaRepository<Concessionnaire, Long> {

}
