package it.begear.heroku.campionato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.begear.heroku.campionato.entity.Squadre;

public interface SquadreRepository extends JpaRepository<Squadre, Integer> {
	
	@Query("SELECT s FROM Squadre s WHERE CONCAT(s.id_squadra, s.nome, s.partite_giocate, s.punti) LIKE %?1% ORDER BY s.punti ASC")
	public List<Squadre> search(String keyword);
	
}
