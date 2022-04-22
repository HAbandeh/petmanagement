package com.cobra.petmanagement.model;

import javax.persistence.*;

@Entity
@Table(name="PETS")
public class Pet extends  Base{

    @Column(name= "NAME")
    private String name;

    @Column(name= "AGE")
    private Long age;

    @JoinColumn(name= "OWNER")
    @ManyToOne
    private Owner owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
