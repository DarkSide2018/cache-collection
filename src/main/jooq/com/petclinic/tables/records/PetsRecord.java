/*
 * This file is generated by jOOQ.
 */
package com.petclinic.tables.records;


import com.petclinic.tables.Pets;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PetsRecord extends UpdatableRecordImpl<PetsRecord> implements Record5<Integer, String, LocalDate, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.pets.id</code>.
     */
    public PetsRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.pets.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.pets.name</code>.
     */
    public PetsRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.pets.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.pets.birth_date</code>.
     */
    public PetsRecord setBirthDate(LocalDate value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.pets.birth_date</code>.
     */
    public LocalDate getBirthDate() {
        return (LocalDate) get(2);
    }

    /**
     * Setter for <code>public.pets.type_id</code>.
     */
    public PetsRecord setTypeId(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.pets.type_id</code>.
     */
    public Integer getTypeId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.pets.owner_id</code>.
     */
    public PetsRecord setOwnerId(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.pets.owner_id</code>.
     */
    public Integer getOwnerId() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, LocalDate, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, LocalDate, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Pets.PETS.ID;
    }

    @Override
    public Field<String> field2() {
        return Pets.PETS.NAME;
    }

    @Override
    public Field<LocalDate> field3() {
        return Pets.PETS.BIRTH_DATE;
    }

    @Override
    public Field<Integer> field4() {
        return Pets.PETS.TYPE_ID;
    }

    @Override
    public Field<Integer> field5() {
        return Pets.PETS.OWNER_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public LocalDate component3() {
        return getBirthDate();
    }

    @Override
    public Integer component4() {
        return getTypeId();
    }

    @Override
    public Integer component5() {
        return getOwnerId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public LocalDate value3() {
        return getBirthDate();
    }

    @Override
    public Integer value4() {
        return getTypeId();
    }

    @Override
    public Integer value5() {
        return getOwnerId();
    }

    @Override
    public PetsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public PetsRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public PetsRecord value3(LocalDate value) {
        setBirthDate(value);
        return this;
    }

    @Override
    public PetsRecord value4(Integer value) {
        setTypeId(value);
        return this;
    }

    @Override
    public PetsRecord value5(Integer value) {
        setOwnerId(value);
        return this;
    }

    @Override
    public PetsRecord values(Integer value1, String value2, LocalDate value3, Integer value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PetsRecord
     */
    public PetsRecord() {
        super(Pets.PETS);
    }

    /**
     * Create a detached, initialised PetsRecord
     */
    public PetsRecord(Integer id, String name, LocalDate birthDate, Integer typeId, Integer ownerId) {
        super(Pets.PETS);

        setId(id);
        setName(name);
        setBirthDate(birthDate);
        setTypeId(typeId);
        setOwnerId(ownerId);
    }
}
