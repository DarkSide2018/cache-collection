/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.owner;

import com.petclinic.tables.records.OwnersRecord;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.petclinic.Tables.OWNERS;
import static com.petclinic.tables.Types.TYPES;

@Repository
public class OwnerRepository {
	private final DSLContext context;

	public OwnerRepository(DSLContext context) {
		this.context = context;
	}

	/**
	 * Retrieve all {@link PetType}s from the data store.
	 *
	 * @return a Collection of {@link PetType}s.
	 */
	@Transactional(readOnly = true)
	public List<PetType> findPetTypes() {
		return context
			.select(DSL.asterisk())
			.from(TYPES)
			.orderBy(TYPES.NAME)
			.fetchInto(PetType.class);
	}

	/**
	 * Retrieve {@link Owner}s from the data store by last name, returning all owners
	 * whose last name <i>starts</i> with the given name.
	 *
	 * @param lastName Value to search for
	 * @return a Collection of matching {@link Owner}s (or an empty Collection if none
	 * found)
	 */


	@Transactional(readOnly = true)
	public Page<Owner> findByLastName(String lastName) {

		List<Owner> ownerList = context.select(DSL.asterisk())
			.from(OWNERS)
			.where(OWNERS.LAST_NAME.like(lastName + "%"))
			.fetchInto(Owner.class);
		return new PageImpl<Owner>(ownerList);
	}

	/**
	 * Retrieve an {@link Owner} from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the {@link Owner} if found
	 */
	@Transactional(readOnly = true)
	@Cacheable("owner")
	public Owner findById(Integer id) {
		return context.select(DSL.asterisk())
			.from(OWNERS)
			.where(OWNERS.ID.eq(id))
			.fetchOneInto(Owner.class);
	}

	/**
	 * Save an {@link Owner} to the data store, either inserting or updating it.
	 *
	 * @param owner the {@link Owner} to save
	 * @return
	 */
	@InvalidateOwnerCache
	public OwnersRecord save(Owner owner) {
		owner.setId(context.nextval("owners_id_seq").intValue());
		return context
			.insertInto(OWNERS)
			.set(context.newRecord(OWNERS, owner))
			.returning().fetchOne();
	}

	public void update(Owner owner) {
		OwnersRecord record = context.newRecord(OWNERS, owner);
		record.update();
	}

	public List<Owner> findAll() {
		return context.select(DSL.asterisk()).from(OWNERS).fetchInto(Owner.class);
	}
}
