package it.begear.heroku.campionato.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.begear.heroku.campionato.entity.Squadre;
import it.begear.heroku.campionato.repository.SquadreRepository;

@Service
public class SquadreService {

	@Autowired
	private SquadreRepository repository;

	public List<Squadre> listAll(String keyword) {
		List<Squadre> squadre = new ArrayList<Squadre>();
		if (keyword != null) {
			squadre = repository.search(keyword);
		} else {
			squadre = repository.findAll();
		}
		Sort sort = Sort.by(Sort.Direction.DESC, "punti");
		squadre = repository.orderByPunti(sort);
		return squadre;
	}

	public void save(Squadre squadre) {
		repository.save(squadre);
	}

	public Squadre getSquadre(Integer id_squadra) {
		return repository.findById(id_squadra).get();
	}

	public void deleteSquadra(Integer id_squadra) {
		repository.deleteById(id_squadra);
	}

}
