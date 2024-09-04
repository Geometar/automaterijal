package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-04T11:53:44+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class PodrgrupaMapperImpl implements PodrgrupaMapper {

    @Override
    public PodgrupaDto map(PodGrupa podgrupa) {
        if ( podgrupa == null ) {
            return null;
        }

        PodgrupaDto podgrupaDto = new PodgrupaDto();

        if ( podgrupa.getNaziv() != null ) {
            podgrupaDto.setNaziv( podgrupa.getNaziv() );
        }
        if ( podgrupa.getPodGrupaId() != null ) {
            podgrupaDto.setId( podgrupa.getPodGrupaId() );
        }

        return podgrupaDto;
    }
}
