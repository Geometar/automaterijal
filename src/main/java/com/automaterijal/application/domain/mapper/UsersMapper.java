package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UsersMapper {

    @Mapping(target = "ppid", source = "ppid")
    @Mapping(target = "orderCount", constant = "0")
    @Mapping(target = "acceptedOrders", constant = "0")
    @Mapping(target = "cancelleOrders", constant = "0")
    @Mapping(target = "loginCount", constant = "0")
    @Mapping(target = "active", constant = "1")
    public abstract Users map(Partner partner);

}
