package fr.humanbooster.fx.plage.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.humanbooster.fx.plage.business.File;
import fr.humanbooster.fx.plage.business.Parasol;

public interface ParasolDao extends JpaRepository<Parasol, Long> {

	@Query("""
			FROM Parasol
			WHERE file=:file
			""")
	List<Parasol> findByFile(File file);

	Page<Parasol> findByFileId(Pageable pageable, Long idFile);

	List<Parasol> findByNumEmplacementLessThan(byte i);
	
}
