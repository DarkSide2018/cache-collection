/*
 * This file is generated by jOOQ.
 */
package com.petclinic.tables;


import com.petclinic.Keys;
import com.petclinic.Public;
import com.petclinic.tables.records.VetSpecialtiesRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VetSpecialties extends TableImpl<VetSpecialtiesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.vet_specialties</code>
     */
    public static final VetSpecialties VET_SPECIALTIES = new VetSpecialties();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VetSpecialtiesRecord> getRecordType() {
        return VetSpecialtiesRecord.class;
    }

    /**
     * The column <code>public.vet_specialties.vet_id</code>.
     */
    public final TableField<VetSpecialtiesRecord, Integer> VET_ID = createField(DSL.name("vet_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.vet_specialties.specialty_id</code>.
     */
    public final TableField<VetSpecialtiesRecord, Integer> SPECIALTY_ID = createField(DSL.name("specialty_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private VetSpecialties(Name alias, Table<VetSpecialtiesRecord> aliased) {
        this(alias, aliased, null);
    }

    private VetSpecialties(Name alias, Table<VetSpecialtiesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.vet_specialties</code> table reference
     */
    public VetSpecialties(String alias) {
        this(DSL.name(alias), VET_SPECIALTIES);
    }

    /**
     * Create an aliased <code>public.vet_specialties</code> table reference
     */
    public VetSpecialties(Name alias) {
        this(alias, VET_SPECIALTIES);
    }

    /**
     * Create a <code>public.vet_specialties</code> table reference
     */
    public VetSpecialties() {
        this(DSL.name("vet_specialties"), null);
    }

    public <O extends Record> VetSpecialties(Table<O> child, ForeignKey<O, VetSpecialtiesRecord> key) {
        super(child, key, VET_SPECIALTIES);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<UniqueKey<VetSpecialtiesRecord>> getKeys() {
        return Arrays.<UniqueKey<VetSpecialtiesRecord>>asList(Keys.VET_SPECIALTIES_VET_ID_SPECIALTY_ID_KEY);
    }

    @Override
    public List<ForeignKey<VetSpecialtiesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<VetSpecialtiesRecord, ?>>asList(Keys.VET_SPECIALTIES__VET_SPECIALTIES_VET_ID_FKEY, Keys.VET_SPECIALTIES__VET_SPECIALTIES_SPECIALTY_ID_FKEY);
    }

    private transient Vets _vets;
    private transient Specialties _specialties;

    public Vets vets() {
        if (_vets == null)
            _vets = new Vets(this, Keys.VET_SPECIALTIES__VET_SPECIALTIES_VET_ID_FKEY);

        return _vets;
    }

    public Specialties specialties() {
        if (_specialties == null)
            _specialties = new Specialties(this, Keys.VET_SPECIALTIES__VET_SPECIALTIES_SPECIALTY_ID_FKEY);

        return _specialties;
    }

    @Override
    public VetSpecialties as(String alias) {
        return new VetSpecialties(DSL.name(alias), this);
    }

    @Override
    public VetSpecialties as(Name alias) {
        return new VetSpecialties(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public VetSpecialties rename(String name) {
        return new VetSpecialties(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public VetSpecialties rename(Name name) {
        return new VetSpecialties(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}