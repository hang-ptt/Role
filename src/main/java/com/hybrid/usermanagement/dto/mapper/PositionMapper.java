package com.hybrid.usermanagement.dto.mapper;

import com.hybrid.usermanagement.dto.PositionDto;
import com.hybrid.usermanagement.entity.Position;

import java.util.List;

public interface PositionMapper extends EntityMapper<PositionDto, Position> {
    @Override
    PositionDto toDataObject(Position entity);

    @Override
    List<PositionDto> toDataObject(List<Position> entities);

    @Override
    Position toEntity(PositionDto data);

    @Override
    List<Position> toEntity(List<PositionDto> datas);
}
