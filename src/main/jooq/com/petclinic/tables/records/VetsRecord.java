/*
 * This file is generated by jOOQ.
 */
package com.petclinic.tables.records;


import com.petclinic.tables.Vets;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VetsRecord extends UpdatableRecordImpl<VetsRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.vets.id</code>.
     */
    public VetsRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.vets.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.vets.first_name</code>.
     */
    public VetsRecord setFirstName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.vets.first_name</code>.
     */
    public String getFirstName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.vets.last_name</code>.
     */
    public VetsRecord setLastName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.vets.last_name</code>.
     */
    public String getLastName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Vets.VETS.ID;
    }

    @Override
    public Field<String> field2() {
        return Vets.VETS.FIRST_NAME;
    }

    @Override
    public Field<String> field3() {
        return Vets.VETS.LAST_NAME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getFirstName();
    }

    @Override
    public String component3() {
        return getLastName();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getFirstName();
    }

    @Override
    public String value3() {
        return getLastName();
    }

    @Override
    public VetsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public VetsRecord value2(String value) {
        setFirstName(value);
        return this;
    }

    @Override
    public VetsRecord value3(String value) {
        setLastName(value);
        return this;
    }

    @Override
    public VetsRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VetsRecord
     */
    public VetsRecord() {
        super(Vets.VETS);
    }

    /**
     * Create a detached, initialised VetsRecord
     */
    public VetsRecord(Integer id, String firstName, String lastName) {
        super(Vets.VETS);

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }
}