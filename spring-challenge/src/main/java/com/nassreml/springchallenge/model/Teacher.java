package com.nassreml.springchallenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Teacher {

    private String id;

    @NotNull(message = "Name and surname cannot be null")
    private String name_surname;

    public Teacher() {
    }

    public Teacher(@JsonProperty("id") String id,
                   @JsonProperty("name_surname") String name_surname) {
        this.id = id;
        this.name_surname = name_surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_surname() {
        return name_surname;
    }

    public void setName_surname(String name_surname) {
        this.name_surname = name_surname;
    }
}
