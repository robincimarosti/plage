package fr.humanbooster.fx.plage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.plage.business.Statut;

public interface StatutDao extends JpaRepository<Statut, Long> {

}
