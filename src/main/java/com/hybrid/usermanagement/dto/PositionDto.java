package com.hybrid.usermanagement.dto;


import java.util.List;

public class PositionDto {
    private long id;
    private String name;
    private LocationDto location;
    private List<PositionSubjectDto> positionSubjects;

    public PositionDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public List<PositionSubjectDto> getPositionSubjects() {
        return positionSubjects;
    }

    public void setPositionSubjects(List<PositionSubjectDto> positionSubjects) {
        this.positionSubjects = positionSubjects;
    }
}
