/*
 * This file is generated by jOOQ.
 */
package com.petclinic.tables;


import com.petclinic.Indexes;
import com.petclinic.Keys;
import com.petclinic.Public;
import com.petclinic.tables.records.VetsRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
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
public class Vets extends TableImpl<VetsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.vets</code>
     */
    public static final Vets VETS = new Vets();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VetsRecord> getRecordType() {
        return VetsRecord.class;
    }

    /**
     * The column <code>public.vets.id</code>.
     */
    public final TableField<VetsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.vets.first_name</code>.
     */
    public final TableField<VetsRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.vets.last_name</code>.
     */
    public final TableField<VetsRecord, String> LAST_NAME = createField(DSL.name("last_name"), SQLDataType.CLOB, this, "");

    private Vets(Name alias, Table<VetsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Vets(Name alias, Table<VetsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.vets</code> table reference
     */
    public Vets(String alias) {
        this(DSL.name(alias), VETS);
    }

    /**
     * Create an aliased <code>public.vets</code> table reference
     */
    public Vets(Name alias) {
        this(alias, VETS);
    }

    /**
     * Create a <code>public.vets</code> table reference
     */
    public Vets() {
        this(DSL.name("vets"), null);
    }

    public <O extends Record> Vets(Table<O> child, ForeignKey<O, VetsRecord> key) {
        super(child, key, VETS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.VETS_LAST_NAME_IDX);
    }

    @Override
    public Identity<VetsRecord, Integer> getIdentity() {
        return (Identity<VetsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<VetsRecord> getPrimaryKey() {
        return Keys.VETS_PKEY;
    }

    @Override
    public List<UniqueKey<VetsRecord>> getKeys() {
        return Arrays.<UniqueKey<VetsRecord>>asList(Keys.VETS_PKEY);
    }

    @Override
    public Vets as(String alias) {
        return new Vets(DSL.name(alias), this);
    }

    @Override
    public Vets as(Name alias) {
        return new Vets(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Vets rename(String name) {
        return new Vets(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Vets rename(Name name) {
        return new Vets(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}