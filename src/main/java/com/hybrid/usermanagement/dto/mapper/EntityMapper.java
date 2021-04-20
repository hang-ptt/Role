package com.hybrid.usermanagement.dto.mapper;

import java.util.List;

public interface EntityMapper <A,T>{

    A toDataObject(T entity);

    List<A> toDataObject(List<T> entities);

    T toEntity(A data);

    List<T> toEntity(List<A> datas);
}
