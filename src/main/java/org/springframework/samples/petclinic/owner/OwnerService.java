package org.springframework.samples.petclinic.owner;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Service
public class OwnerService {
	private final CacheManager manager;
	private final OwnerRepository repository;

	private final ConcurrentMap ownerCache;

	public OwnerService(CacheManager manager, OwnerRepository repository) {
		this.manager = manager;
		this.repository = repository;
		Cache nativeCache = (Cache) manager.getCache("owner").getNativeCache();
		ownerCache = nativeCache.asMap();
	}

	@PostConstruct
	public void init() {
		repository.findAll().forEach(elem -> {
			ownerCache.put(elem.getId(), elem);
		});
	}

	public Page<Owner> findByLastName(String lastName) {
		List filteredOwners = ownerCache.values().stream().filter(item->{
			Owner owner = (Owner) item;
			return owner.getLastName().contains(lastName);
		}).toList();
		return new PageImpl<>(filteredOwners);
	}
	public Owner findById(Integer id){
		return (Owner)ownerCache.get(id);
	}

}
