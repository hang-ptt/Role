package com.hybrid.usermanagement.dto.mapper;

import com.hybrid.usermanagement.dto.LocationDto;
import com.hybrid.usermanagement.entity.Location;

import java.util.List;

public interface LocationMapper extends EntityMapper<LocationDto, Location>{
    @Override
    LocationDto toDataObject(Location entity);

    @Override
    List<LocationDto> toDataObject(List<Location> entities);

    @Override
    Location toEntity(LocationDto data);

    @Override
    List<Location> toEntity(List<LocationDto> datas);
}
