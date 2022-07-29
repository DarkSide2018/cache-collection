package org.springframework.samples.petclinic.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class OwnerService {
	private final CacheManager manager;
	private final OwnerRepository repository;

	public OwnerService(CacheManager manager, OwnerRepository repository) {
		this.manager = manager;
		this.repository = repository;
	}

	@PostConstruct
	public void init() {
		repository.findAll().forEach(elem -> {
			manager.getCache("owner").put(elem.getId(), elem);
		});
	}
}
