package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.Users;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-04T11:53:45+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public Users map(Partner partner) {
        if ( partner == null ) {
            return null;
        }

        Users users = new Users();

        if ( partner.getPpid() != null ) {
            users.setPpid( partner.getPpid() );
        }

        users.setOrderCount( 0 );
        users.setCancelleOrders( 0 );
        users.setActive( 1 );
        users.setAcceptedOrders( 0 );
        users.setLoginCount( 0 );

        return users;
    }
}
