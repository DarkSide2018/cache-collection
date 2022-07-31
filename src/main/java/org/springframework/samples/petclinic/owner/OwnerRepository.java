
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
	@Transactional(readOnly = true)
	public List<PetType> findPetTypes() {
		return context
			.select(DSL.asterisk())
			.from(TYPES)
			.orderBy(TYPES.NAME)
			.fetchInto(PetType.class);
	}


	@Transactional(readOnly = true)
	public Page<Owner> findByLastName(String lastName) {

		List<Owner> ownerList = context.select(DSL.asterisk())
			.from(OWNERS)
			.where(OWNERS.LAST_NAME.like(lastName + "%"))
			.fetchInto(Owner.class);
		return new PageImpl<Owner>(ownerList);
	}

	@Transactional(readOnly = true)
	@Cacheable("owner")
	public Owner findById(Integer id) {
		return context.select(DSL.asterisk())
			.from(OWNERS)
			.where(OWNERS.ID.eq(id))
			.fetchOneInto(Owner.class);
	}

	@InvalidateOwnerCache
	public OwnersRecord save(Owner owner) {
		owner.setId(context.nextval("owners_id_seq").intValue());
		return context
			.insertInto(OWNERS)
			.set(context.newRecord(OWNERS, owner))
			.returning().fetchOne();
	}
	@InvalidateOwnerCache
	public void update(Owner owner) {
		OwnersRecord record = context.newRecord(OWNERS, owner);
		record.update();
	}
	public List<Owner> findAll() {
		return context.select(DSL.asterisk()).from(OWNERS).fetchInto(Owner.class);
	}
}
