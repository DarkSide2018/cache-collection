package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
@Aspect
public class CacheOwnerAspect {
	private final Cache cache;

	private final OwnerRepository repository;


	public CacheOwnerAspect(CacheManager manager,
							OwnerRepository repository) {
		this.cache = manager.getCache("owner");
		this.repository = repository;
	}
	@Pointcut(
		"@annotation(org.springframework.samples.petclinic.owner.InvalidateOwnerCache) "
	)
	public void invalidate(){

	}
	@After("invalidate()")
	public void invalidateOwner(JoinPoint jp){
		Optional<Object> first = Arrays.stream(jp.getArgs()).findFirst();
		if(!(first.orElseThrow(()->new RuntimeException("first arg was null")) instanceof Owner)) {
			throw new RuntimeException("first arg have to be Owner type");
		}
		Owner owner = (Owner) first.get();
		Owner ownerFromDb = repository.findById(owner.getId());
		cache.put(ownerFromDb.getId(),ownerFromDb);
	}
}

