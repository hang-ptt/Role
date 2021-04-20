package com.hybrid.usermanagement.dto.mapper;

import com.hybrid.usermanagement.dto.SubjectDto;
import com.hybrid.usermanagement.entity.Subject;

import java.util.List;

public interface SubjectMapper extends EntityMapper<SubjectDto, Subject>{
    @Override
    SubjectDto toDataObject(Subject entity);

    @Override
    List<SubjectDto> toDataObject(List<Subject> entities);

    @Override
    Subject toEntity(SubjectDto data);

    @Override
    List<Subject> toEntity(List<SubjectDto> datas);
}
