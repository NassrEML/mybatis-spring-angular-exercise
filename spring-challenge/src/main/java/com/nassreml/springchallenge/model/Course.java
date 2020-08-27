package com.nassreml.springchallenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Course {

    private String id;

    @NotNull(message = "Availability cannot be null")
    private boolean availability;

    @NotNull(message = "Teacher Id cannot be null")
    private String teacher_id;

    @Size(min = 5, max = 200, message = "Title must be between 5 and 200 characters")
    private String title;

    @NotNull(message = "Difficulty cannot be null and it has to be one of these three; \"Básico\", \"Intermedio\" or \"Avanzado\"")
    private Difficulty difficulty;

    @Min(value = 5, message = "Course hours should not be less than 5")
    @Max(value = 300, message = "Course hours should not be greater than 300")
    private Integer hours;

    public Course() {
    }

    public Course(@JsonProperty("id") String id,
                  @JsonProperty("availability") boolean availability,
                  @JsonProperty("teacher_id") String teacher_id,
                  @JsonProperty("title") String title,
                  @JsonProperty("difficulty") Difficulty difficulty,
                  @JsonProperty("hours") Integer hours) {
        this.id = id;
        this.availability = availability;
        this.teacher_id = teacher_id;
        this.title = title;
        this.difficulty = difficulty;
        this.hours = hours;
    }

    public String getId() {
        return id;
    }

    public boolean getAvailability() {
        return availability;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public String getTitle() {
        return title;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Integer getHours() {
        return hours;
    }
}
