package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.ExternalRobaDto;
import com.automaterijal.application.domain.entity.roba.Roba;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-04T11:53:44+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ExternalRobaMapperImpl implements ExternalRobaMapper {

    @Override
    public ExternalRobaDto map(Roba roba, Double cena) {
        if ( roba == null && cena == null ) {
            return null;
        }

        ExternalRobaDto externalRobaDto = new ExternalRobaDto();

        if ( roba != null ) {
            if ( roba.getNaziv() != null ) {
                externalRobaDto.setDescription( roba.getNaziv() );
            }
            externalRobaDto.setQuantity( roba.getStanje() );
            if ( roba.getKatbr() != null ) {
                externalRobaDto.setItemNo( roba.getKatbr() );
            }
        }
        if ( cena != null ) {
            externalRobaDto.setPrice( cena );
        }
        externalRobaDto.setSucess( true );

        return externalRobaDto;
    }
}
