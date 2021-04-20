package com.hybrid.usermanagement.dto;

public class PositionSubjectDto {
    private long id;
    private SubjectDto subjects;
    private boolean allowEdit;
    private boolean allowView;
    private boolean allowCreate;
    private boolean allowDelete;

    public PositionSubjectDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SubjectDto getSubjects() {
        return subjects;
    }

    public void setSubjects(SubjectDto subjects) {
        this.subjects = subjects;
    }

    public boolean isAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(boolean allowEdit) {
        this.allowEdit = allowEdit;
    }

    public boolean isAllowView() {
        return allowView;
    }

    public void setAllowView(boolean allowView) {
        this.allowView = allowView;
    }

    public boolean isAllowCreate() {
        return allowCreate;
    }

    public void setAllowCreate(boolean allowCreate) {
        this.allowCreate = allowCreate;
    }

    public boolean isAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(boolean allowDelete) {
        this.allowDelete = allowDelete;
    }
}
