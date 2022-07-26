/*
 * This file is generated by jOOQ.
 */
package com.petclinic.tables;


import com.petclinic.Indexes;
import com.petclinic.Keys;
import com.petclinic.Public;
import com.petclinic.tables.records.OwnersRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
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
public class Owners extends TableImpl<OwnersRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.owners</code>
     */
    public static final Owners OWNERS = new Owners();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OwnersRecord> getRecordType() {
        return OwnersRecord.class;
    }

    /**
     * The column <code>public.owners.id</code>.
     */
    public final TableField<OwnersRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.owners.first_name</code>.
     */
    public final TableField<OwnersRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.owners.last_name</code>.
     */
    public final TableField<OwnersRecord, String> LAST_NAME = createField(DSL.name("last_name"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.owners.address</code>.
     */
    public final TableField<OwnersRecord, String> ADDRESS = createField(DSL.name("address"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.owners.city</code>.
     */
    public final TableField<OwnersRecord, String> CITY = createField(DSL.name("city"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.owners.telephone</code>.
     */
    public final TableField<OwnersRecord, String> TELEPHONE = createField(DSL.name("telephone"), SQLDataType.CLOB, this, "");

    private Owners(Name alias, Table<OwnersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Owners(Name alias, Table<OwnersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.owners</code> table reference
     */
    public Owners(String alias) {
        this(DSL.name(alias), OWNERS);
    }

    /**
     * Create an aliased <code>public.owners</code> table reference
     */
    public Owners(Name alias) {
        this(alias, OWNERS);
    }

    /**
     * Create a <code>public.owners</code> table reference
     */
    public Owners() {
        this(DSL.name("owners"), null);
    }

    public <O extends Record> Owners(Table<O> child, ForeignKey<O, OwnersRecord> key) {
        super(child, key, OWNERS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.OWNERS_LAST_NAME_IDX);
    }

    @Override
    public Identity<OwnersRecord, Integer> getIdentity() {
        return (Identity<OwnersRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<OwnersRecord> getPrimaryKey() {
        return Keys.OWNERS_PKEY;
    }

    @Override
    public List<UniqueKey<OwnersRecord>> getKeys() {
        return Arrays.<UniqueKey<OwnersRecord>>asList(Keys.OWNERS_PKEY);
    }

    @Override
    public Owners as(String alias) {
        return new Owners(DSL.name(alias), this);
    }

    @Override
    public Owners as(Name alias) {
        return new Owners(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Owners rename(String name) {
        return new Owners(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Owners rename(Name name) {
        return new Owners(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
