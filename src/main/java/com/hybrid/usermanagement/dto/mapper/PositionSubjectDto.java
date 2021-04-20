package com.hybrid.usermanagement.dto.mapper;

import com.hybrid.usermanagement.entity.PositionSubject;

import java.util.List;

public interface PositionSubjectDto extends EntityMapper<PositionSubjectDto, PositionSubject> {
    @Override
    PositionSubjectDto toDataObject(PositionSubject entity);

    @Override
    List<PositionSubjectDto> toDataObject(List<PositionSubject> entities);

    @Override
    PositionSubject toEntity(PositionSubjectDto data);

    @Override
    List<PositionSubject> toEntity(List<PositionSubjectDto> datas);
}
