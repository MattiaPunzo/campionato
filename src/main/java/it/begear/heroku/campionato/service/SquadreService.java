package it.begear.heroku.campionato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.heroku.campionato.entity.Squadre;
import it.begear.heroku.campionato.repository.SquadreRepository;

@Service
public class SquadreService {

	@Autowired
	private SquadreRepository repository;
	
	 public List<Squadre> listAll(String keyword){
			if(keyword != null) {
				return repository.search(keyword); 
			}
			return repository.findAll();
			
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
