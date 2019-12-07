package com.knbsites.studentTracker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Student {

    private final UUID id;
    private final String name;
    private final String classroom;

    public Student(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String name,
                   @JsonProperty("classroom") String classroom)
    {
        this.id = id;
        this.name = name;
        this.classroom = classroom;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassroom() {
        return classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}

