package com.example.project.model.dto;

import com.example.project.model.entity.Request;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RequestMapper {
    Request requestDtoToRequest(RequestDto requestDto);

    RequestDto requestToRequestDto(Request request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Request updateRequestFromRequestDto(RequestDto requestDto, @MappingTarget Request request);

    @AfterMapping
    default void linkRequestDetails(@MappingTarget Request request) {
        request.getRequestDetails().forEach(requestDetail -> requestDetail.setRequest(request));
    }
}
