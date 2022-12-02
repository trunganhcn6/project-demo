package com.example.project.dto;

import com.example.project.entity.RequestDetails;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RequestDetailsMapper {
    RequestDetails requestDetailsDtoToRequestDetails(RequestDetailsDto requestDetailsDto);

    RequestDetailsDto requestDetailsToRequestDetailsDto(RequestDetails requestDetails);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RequestDetails updateRequestDetailsFromRequestDetailsDto(RequestDetailsDto requestDetailsDto, @MappingTarget RequestDetails requestDetails);
}
