package com.example.project.dto;

import com.example.project.entity.Account;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
    Account accountDtoToAccount(AccountDto accountDto);

    AccountDto accountToAccountDto(Account account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account updateAccountFromAccountDto(AccountDto accountDto, @MappingTarget Account account);
}
