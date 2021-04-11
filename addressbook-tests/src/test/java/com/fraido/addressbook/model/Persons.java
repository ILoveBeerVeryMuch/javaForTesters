package com.fraido.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Persons extends ForwardingSet<PersonData> {
    private Set<PersonData> delegate;

    @Override
    protected Set delegate() {
        return delegate;
    }

    public Persons(Persons persons) {
        this.delegate = new HashSet<PersonData>(persons.delegate);
    }

    public Persons(Collection<PersonData> persons) {
        this.delegate = new HashSet<PersonData>(persons);
    }

    public Persons() {
        this.delegate = new HashSet<PersonData>();
    }

    public Persons withAdded(PersonData personData) {
        Persons persons = new Persons(this);
        persons.add(personData);
        return persons;
    }

    public Persons without(PersonData personData) {
        Persons persons = new Persons(this);
        persons.remove(personData);
        return persons;
    }
}
