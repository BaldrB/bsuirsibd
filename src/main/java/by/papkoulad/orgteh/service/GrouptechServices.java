package by.papkoulad.orgteh.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import by.papkoulad.orgteh.models.Grouptech;
import by.papkoulad.orgteh.repo.GrouptechRepository;

@Service
public class GrouptechServices extends CrudImpl<Grouptech> {
    public GrouptechRepository repository;

	@Autowired
	public GrouptechServices(GrouptechRepository repository) {
		super(repository);
		this.repository = repository;
    }
    
    public Grouptech findByName(String name) {
		return repository.findByNameIgnoreCase(name);
	}
    
}
