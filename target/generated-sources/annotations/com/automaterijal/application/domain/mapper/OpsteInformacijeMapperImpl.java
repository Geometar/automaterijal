package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.ValueHelpDto;
import com.automaterijal.application.domain.entity.valuehelp.NacinPlacanja;
import com.automaterijal.application.domain.entity.valuehelp.NacinPrevoza;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-04T11:53:44+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class OpsteInformacijeMapperImpl implements OpsteInformacijeMapper {

    @Override
    public ValueHelpDto map(NacinPlacanja nacinPlacanja) {
        if ( nacinPlacanja == null ) {
            return null;
        }

        ValueHelpDto valueHelpDto = new ValueHelpDto();

        if ( nacinPlacanja.getId() != null ) {
            valueHelpDto.setId( nacinPlacanja.getId() );
        }
        if ( nacinPlacanja.getNaziv() != null ) {
            valueHelpDto.setNaziv( nacinPlacanja.getNaziv() );
        }

        return valueHelpDto;
    }

    @Override
    public ValueHelpDto map(NacinPrevoza nacinPrevoza) {
        if ( nacinPrevoza == null ) {
            return null;
        }

        ValueHelpDto valueHelpDto = new ValueHelpDto();

        if ( nacinPrevoza.getId() != null ) {
            valueHelpDto.setId( nacinPrevoza.getId() );
        }
        if ( nacinPrevoza.getNaziv() != null ) {
            valueHelpDto.setNaziv( nacinPrevoza.getNaziv() );
        }

        return valueHelpDto;
    }
}
