package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.RobaDto.RobaDtoBuilder;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaAplikacijaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.Proizvodjac.ProizvodjacBuilder;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.entity.roba.RobaAplikacija;
import com.automaterijal.application.domain.entity.roba.RobaOpis;
import com.automaterijal.db.tables.records.RobaRecord;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-04T11:53:45+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class RobaMapperImpl implements RobaMapper {

    @Override
    public RobaDto map(Roba roba) {
        if ( roba == null ) {
            return null;
        }

        RobaDtoBuilder robaDto = RobaDto.builder();

        robaDto.slika( robaToSlikaDto( roba ) );
        if ( roba.getGrupaid() != null ) {
            robaDto.grupa( roba.getGrupaid() );
        }
        robaDto.podGrupa( roba.getPodgrupaid() );
        if ( roba.getRobaid() != null ) {
            robaDto.robaid( roba.getRobaid() );
        }
        if ( roba.getKatbr() != null ) {
            robaDto.katbr( roba.getKatbr() );
        }
        if ( roba.getKatbrpro() != null ) {
            robaDto.katbrpro( roba.getKatbrpro() );
        }
        if ( roba.getNaziv() != null ) {
            robaDto.naziv( roba.getNaziv() );
        }
        if ( roba.getProizvodjac() != null ) {
            robaDto.proizvodjac( roba.getProizvodjac() );
        }
        robaDto.stanje( roba.getStanje() );

        return robaDto.build();
    }

    @Override
    public List<RobaTehnickiOpisDto> map(List<RobaOpis> opisi) {
        if ( opisi == null ) {
            return null;
        }

        List<RobaTehnickiOpisDto> list = new ArrayList<RobaTehnickiOpisDto>( opisi.size() );
        for ( RobaOpis robaOpis : opisi ) {
            list.add( robaOpisToRobaTehnickiOpisDto( robaOpis ) );
        }

        return list;
    }

    @Override
    public RobaDetaljiDto mapujDetaljno(Roba roba) {
        if ( roba == null ) {
            return null;
        }

        RobaDetaljiDto robaDetaljiDto = new RobaDetaljiDto();

        robaDetaljiDto.setSlika( robaToSlikaDto1( roba ) );
        if ( roba.getGrupaid() != null ) {
            robaDetaljiDto.setGrupa( roba.getGrupaid() );
        }
        robaDetaljiDto.setPodGrupa( String.valueOf( roba.getPodgrupaid() ) );
        if ( roba.getRobaid() != null ) {
            robaDetaljiDto.setRobaid( roba.getRobaid() );
        }
        if ( roba.getKatbr() != null ) {
            robaDetaljiDto.setKatbr( roba.getKatbr() );
        }
        if ( roba.getNaziv() != null ) {
            robaDetaljiDto.setNaziv( roba.getNaziv() );
        }
        robaDetaljiDto.setStanje( roba.getStanje() );
        if ( roba.getProizvodjac() != null ) {
            robaDetaljiDto.setProizvodjac( roba.getProizvodjac() );
        }

        return robaDetaljiDto;
    }

    @Override
    public RobaAplikacijaDto mapAplikacija(RobaAplikacija aplikacija) {
        if ( aplikacija == null ) {
            return null;
        }

        RobaAplikacijaDto robaAplikacijaDto = new RobaAplikacijaDto();

        if ( aplikacija.getKw() != null ) {
            robaAplikacijaDto.setKw( aplikacija.getKw() );
        }
        if ( aplikacija.getProizvodjacNaziv() != null ) {
            robaAplikacijaDto.setProizvodjacNaziv( aplikacija.getProizvodjacNaziv() );
        }
        if ( aplikacija.getModelNaziv() != null ) {
            robaAplikacijaDto.setModelNaziv( aplikacija.getModelNaziv() );
        }
        if ( aplikacija.getTipVozila() != null ) {
            robaAplikacijaDto.setTipVozila( aplikacija.getTipVozila() );
        }
        if ( aplikacija.getProizOd() != null ) {
            robaAplikacijaDto.setProizOd( aplikacija.getProizOd() );
        }
        if ( aplikacija.getProizDo() != null ) {
            robaAplikacijaDto.setProizDo( aplikacija.getProizDo() );
        }
        if ( aplikacija.getHp() != null ) {
            robaAplikacijaDto.setHp( aplikacija.getHp() );
        }
        if ( aplikacija.getCcm() != null ) {
            robaAplikacijaDto.setCcm( aplikacija.getCcm() );
        }

        return robaAplikacijaDto;
    }

    @Override
    public Roba map(RobaRecord robaRecord) {
        if ( robaRecord == null ) {
            return null;
        }

        Roba roba = new Roba();

        roba.setProizvodjac( robaRecordToProizvodjac( robaRecord ) );
        if ( robaRecord.getRobaid() != null ) {
            roba.setRobaid( robaRecord.getRobaid().longValue() );
        }
        if ( robaRecord.getKatbr() != null ) {
            roba.setKatbr( robaRecord.getKatbr() );
        }
        if ( robaRecord.getKatbrpro() != null ) {
            roba.setKatbrpro( robaRecord.getKatbrpro() );
        }
        if ( robaRecord.getNaziv() != null ) {
            roba.setNaziv( robaRecord.getNaziv() );
        }
        if ( robaRecord.getGrupaid() != null ) {
            roba.setGrupaid( robaRecord.getGrupaid() );
        }
        if ( robaRecord.getPodgrupaid() != null ) {
            roba.setPodgrupaid( robaRecord.getPodgrupaid() );
        }
        if ( robaRecord.getStanje() != null ) {
            roba.setStanje( robaRecord.getStanje().doubleValue() );
        }
        if ( robaRecord.getSlika() != null ) {
            roba.setSlika( robaRecord.getSlika() );
        }
        if ( robaRecord.getFabrcena() != null ) {
            roba.setFabrcena( robaRecord.getFabrcena().doubleValue() );
        }
        if ( robaRecord.getDevnabcena() != null ) {
            roba.setDevnabcena( robaRecord.getDevnabcena().doubleValue() );
        }
        if ( robaRecord.getPorez() != null ) {
            roba.setPorez( robaRecord.getPorez().doubleValue() );
        }
        if ( robaRecord.getKomentar() != null ) {
            roba.setKomentar( robaRecord.getKomentar() );
        }
        if ( robaRecord.getVpcid() != null ) {
            roba.setVpcid( robaRecord.getVpcid() );
        }

        return roba;
    }

    protected SlikaDto robaToSlikaDto(Roba roba) {
        if ( roba == null ) {
            return null;
        }

        SlikaDto slikaDto = new SlikaDto();

        if ( roba.getSlika() != null ) {
            slikaDto.setRobaSlika( roba.getSlika() );
        }

        return slikaDto;
    }

    protected RobaTehnickiOpisDto robaOpisToRobaTehnickiOpisDto(RobaOpis robaOpis) {
        if ( robaOpis == null ) {
            return null;
        }

        RobaTehnickiOpisDto robaTehnickiOpisDto = new RobaTehnickiOpisDto();

        if ( robaOpis.getOznaka() != null ) {
            robaTehnickiOpisDto.setOznaka( robaOpis.getOznaka() );
        }
        if ( robaOpis.getVrednost() != null ) {
            robaTehnickiOpisDto.setVrednost( robaOpis.getVrednost() );
        }
        if ( robaOpis.getJedinica() != null ) {
            robaTehnickiOpisDto.setJedinica( robaOpis.getJedinica() );
        }

        return robaTehnickiOpisDto;
    }

    protected SlikaDto robaToSlikaDto1(Roba roba) {
        if ( roba == null ) {
            return null;
        }

        SlikaDto slikaDto = new SlikaDto();

        if ( roba.getSlika() != null ) {
            slikaDto.setRobaSlika( roba.getSlika() );
        }

        return slikaDto;
    }

    protected Proizvodjac robaRecordToProizvodjac(RobaRecord robaRecord) {
        if ( robaRecord == null ) {
            return null;
        }

        ProizvodjacBuilder proizvodjac = Proizvodjac.builder();

        if ( robaRecord.getProid() != null ) {
            proizvodjac.proid( robaRecord.getProid() );
        }

        return proizvodjac.build();
    }
}
