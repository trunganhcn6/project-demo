package com.example.project.model.dto;

import com.example.project.model.entity.StoreAcc;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
    StoreAcc accountDtoToAccount(StoreAccDto storeAccDto);

    StoreAccDto accountToAccountDto(StoreAcc storeAcc);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    StoreAcc updateAccountFromAccountDto(StoreAccDto storeAccDto, @MappingTarget StoreAcc storeAcc);
}
