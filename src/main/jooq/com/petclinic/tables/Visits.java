/*
 * This file is generated by jOOQ.
 */
package com.petclinic.tables;


import com.petclinic.Indexes;
import com.petclinic.Keys;
import com.petclinic.Public;
import com.petclinic.tables.records.VisitsRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class Visits extends TableImpl<VisitsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.visits</code>
     */
    public static final Visits VISITS = new Visits();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VisitsRecord> getRecordType() {
        return VisitsRecord.class;
    }

    /**
     * The column <code>public.visits.id</code>.
     */
    public final TableField<VisitsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.visits.pet_id</code>.
     */
    public final TableField<VisitsRecord, Integer> PET_ID = createField(DSL.name("pet_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.visits.visit_date</code>.
     */
    public final TableField<VisitsRecord, LocalDate> VISIT_DATE = createField(DSL.name("visit_date"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.visits.description</code>.
     */
    public final TableField<VisitsRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.CLOB, this, "");

    private Visits(Name alias, Table<VisitsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Visits(Name alias, Table<VisitsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.visits</code> table reference
     */
    public Visits(String alias) {
        this(DSL.name(alias), VISITS);
    }

    /**
     * Create an aliased <code>public.visits</code> table reference
     */
    public Visits(Name alias) {
        this(alias, VISITS);
    }

    /**
     * Create a <code>public.visits</code> table reference
     */
    public Visits() {
        this(DSL.name("visits"), null);
    }

    public <O extends Record> Visits(Table<O> child, ForeignKey<O, VisitsRecord> key) {
        super(child, key, VISITS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.VISITS_PET_ID_IDX);
    }

    @Override
    public Identity<VisitsRecord, Integer> getIdentity() {
        return (Identity<VisitsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<VisitsRecord> getPrimaryKey() {
        return Keys.VISITS_PKEY;
    }

    @Override
    public List<UniqueKey<VisitsRecord>> getKeys() {
        return Arrays.<UniqueKey<VisitsRecord>>asList(Keys.VISITS_PKEY);
    }

    @Override
    public List<ForeignKey<VisitsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<VisitsRecord, ?>>asList(Keys.VISITS__VISITS_PET_ID_FKEY);
    }

    private transient Pets _pets;

    public Pets pets() {
        if (_pets == null)
            _pets = new Pets(this, Keys.VISITS__VISITS_PET_ID_FKEY);

        return _pets;
    }

    @Override
    public Visits as(String alias) {
        return new Visits(DSL.name(alias), this);
    }

    @Override
    public Visits as(Name alias) {
        return new Visits(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Visits rename(String name) {
        return new Visits(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Visits rename(Name name) {
        return new Visits(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, LocalDate, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}