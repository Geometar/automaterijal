package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.FakturaDetaljiDto;
import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.ValueHelpDto;
import com.automaterijal.application.domain.entity.Faktura;
import com.automaterijal.application.domain.entity.FakturaDetalji;
import com.automaterijal.application.domain.entity.MestaIsporuke;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.entity.valuehelp.NacinPlacanja;
import com.automaterijal.application.domain.entity.valuehelp.NacinPrevoza;
import com.automaterijal.application.domain.entity.valuehelp.Status;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-04T11:53:45+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class FakturaMapperImpl extends FakturaMapper {

    private final DatatypeFactory datatypeFactory;

    public FakturaMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public FakturaDto map(Faktura faktura) {
        if ( faktura == null ) {
            return null;
        }

        FakturaDto fakturaDto = new FakturaDto();

        fakturaDto.setNacinPlacanja( fakturaToValueHelpDto( faktura ) );
        fakturaDto.setAdresa( fakturaToValueHelpDto1( faktura ) );
        fakturaDto.setNacinPrevoza( fakturaToValueHelpDto2( faktura ) );
        fakturaDto.setStatus( fakturaToValueHelpDto3( faktura ) );
        if ( faktura.getPpid() != null ) {
            fakturaDto.setPartner( String.valueOf( faktura.getPpid() ) );
        }
        if ( faktura.getDataSent() != null ) {
            fakturaDto.setVremePorucivanja( xmlGregorianCalendarToString( dateToXmlGregorianCalendar( faktura.getDataSent() ), null ) );
        }
        if ( faktura.getId() != null ) {
            fakturaDto.setId( faktura.getId() );
        }
        if ( faktura.getOrderId() != null ) {
            fakturaDto.setOrderId( faktura.getOrderId() );
        }
        if ( faktura.getNapomena() != null ) {
            fakturaDto.setNapomena( faktura.getNapomena() );
        }
        if ( faktura.getIznosNarucen() != null ) {
            fakturaDto.setIznosNarucen( faktura.getIznosNarucen() );
        }
        if ( faktura.getIznosPotvrdjen() != null ) {
            fakturaDto.setIznosPotvrdjen( faktura.getIznosPotvrdjen() );
        }
        List<FakturaDetaljiDto> list = fakturaDetaljiListToFakturaDetaljiDtoList( faktura.getDetalji() );
        if ( list != null ) {
            fakturaDto.setDetalji( list );
        }

        return fakturaDto;
    }

    @Override
    public Faktura map(FakturaDto faktura) {
        if ( faktura == null ) {
            return null;
        }

        Faktura faktura1 = new Faktura();

        Integer id = fakturaNacinPlacanjaId( faktura );
        if ( id != null ) {
            faktura1.setNuid( id );
        }
        Integer id1 = fakturaNacinPrevozaId( faktura );
        if ( id1 != null ) {
            faktura1.setNiid( id1 );
        }
        Integer id2 = fakturaAdresaId( faktura );
        if ( id2 != null ) {
            faktura1.setMestoIsporuke( id2 );
        }
        if ( faktura.getId() != null ) {
            faktura1.setId( faktura.getId() );
        }
        if ( faktura.getOrderId() != null ) {
            faktura1.setOrderId( faktura.getOrderId() );
        }
        if ( faktura.getStatus() != null ) {
            faktura1.setStatus( map( faktura.getStatus() ) );
        }
        if ( faktura.getNapomena() != null ) {
            faktura1.setNapomena( faktura.getNapomena() );
        }
        if ( faktura.getIznosNarucen() != null ) {
            faktura1.setIznosNarucen( faktura.getIznosNarucen() );
        }
        if ( faktura.getIznosPotvrdjen() != null ) {
            faktura1.setIznosPotvrdjen( faktura.getIznosPotvrdjen() );
        }
        List<FakturaDetalji> list = fakturaDetaljiDtoListToFakturaDetaljiList( faktura.getDetalji() );
        if ( list != null ) {
            faktura1.setDetalji( list );
        }

        return faktura1;
    }

    @Override
    public FakturaDto map(FakturaDto fakturaDto, NacinPlacanja nacinPlacanja) {
        if ( nacinPlacanja == null ) {
            return null;
        }

        if ( fakturaDto.getNacinPlacanja() == null ) {
            fakturaDto.setNacinPlacanja( new ValueHelpDto() );
        }
        nacinPlacanjaToValueHelpDto( nacinPlacanja, fakturaDto.getNacinPlacanja() );

        return fakturaDto;
    }

    @Override
    public FakturaDto map(FakturaDto fakturaDto, NacinPrevoza nacinPrevoza) {
        if ( nacinPrevoza == null ) {
            return null;
        }

        if ( fakturaDto.getNacinPrevoza() == null ) {
            fakturaDto.setNacinPrevoza( new ValueHelpDto() );
        }
        nacinPrevozaToValueHelpDto( nacinPrevoza, fakturaDto.getNacinPrevoza() );

        return fakturaDto;
    }

    @Override
    public FakturaDto map(FakturaDto fakturaDto, MestaIsporuke mestaIsporuke) {
        if ( mestaIsporuke == null ) {
            return null;
        }

        if ( fakturaDto.getAdresa() == null ) {
            fakturaDto.setAdresa( new ValueHelpDto() );
        }
        mestaIsporukeToValueHelpDto( mestaIsporuke, fakturaDto.getAdresa() );

        return fakturaDto;
    }

    @Override
    public FakturaDto map(FakturaDto fakturaDto, Status status) {
        if ( status == null ) {
            return null;
        }

        if ( fakturaDto.getStatus() == null ) {
            fakturaDto.setStatus( new ValueHelpDto() );
        }
        statusToValueHelpDto( status, fakturaDto.getStatus() );

        return fakturaDto;
    }

    @Override
    public FakturaDetaljiDto map(FakturaDetalji fakturaDetalji) {
        if ( fakturaDetalji == null ) {
            return null;
        }

        FakturaDetaljiDto fakturaDetaljiDto = new FakturaDetaljiDto();

        fakturaDetaljiDto.setStatus( fakturaDetaljiToValueHelpDto( fakturaDetalji ) );
        if ( fakturaDetalji.getKolicina() != null ) {
            fakturaDetaljiDto.setKolicina( fakturaDetalji.getKolicina() );
        }
        if ( fakturaDetalji.getRobaId() != null ) {
            fakturaDetaljiDto.setRobaId( fakturaDetalji.getRobaId() );
        }
        if ( fakturaDetalji.getPotvrdjenaKolicina() != null ) {
            fakturaDetaljiDto.setPotvrdjenaKolicina( fakturaDetalji.getPotvrdjenaKolicina() );
        }
        if ( fakturaDetalji.getCena() != null ) {
            fakturaDetaljiDto.setCena( fakturaDetalji.getCena() );
        }
        if ( fakturaDetalji.getRabat() != null ) {
            fakturaDetaljiDto.setRabat( fakturaDetalji.getRabat() );
        }

        return fakturaDetaljiDto;
    }

    @Override
    public void map(FakturaDetaljiDto fakturaDto, Status status) {
        if ( status == null ) {
            return;
        }

        if ( fakturaDto.getStatus() == null ) {
            fakturaDto.setStatus( new ValueHelpDto() );
        }
        statusToValueHelpDto1( status, fakturaDto.getStatus() );
    }

    @Override
    public void map(FakturaDetaljiDto fakturaDto, Roba roba) {
        if ( roba == null ) {
            return;
        }

        if ( fakturaDto.getSlika() == null ) {
            fakturaDto.setSlika( new SlikaDto() );
        }
        robaToSlikaDto( roba, fakturaDto.getSlika() );
        if ( roba.getKatbr() != null ) {
            fakturaDto.setKataloskiBroj( roba.getKatbr() );
        }
        else {
            fakturaDto.setKataloskiBroj( null );
        }
        if ( roba.getKatbrpro() != null ) {
            fakturaDto.setKataloskiBrojProizvodjaca( roba.getKatbrpro() );
        }
        else {
            fakturaDto.setKataloskiBrojProizvodjaca( null );
        }
        if ( roba.getNaziv() != null ) {
            fakturaDto.setNaziv( roba.getNaziv() );
        }
        else {
            fakturaDto.setNaziv( null );
        }
        if ( roba.getProizvodjac() != null ) {
            fakturaDto.setProizvodjac( roba.getProizvodjac() );
        }
        else {
            fakturaDto.setProizvodjac( null );
        }
    }

    @Override
    public void map(FakturaDetaljiDto fakturaDto, Proizvodjac proizvodjac) {
        if ( proizvodjac == null ) {
            return;
        }

        fakturaDto.setProizvodjac( proizvodjac );
    }

    private String xmlGregorianCalendarToString( XMLGregorianCalendar xcal, String dateFormat ) {
        if ( xcal == null ) {
            return null;
        }

        if (dateFormat == null ) {
            return xcal.toString();
        }
        else {
            Date d = xcal.toGregorianCalendar().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat( dateFormat );
            return sdf.format( d );
        }
    }

    private XMLGregorianCalendar dateToXmlGregorianCalendar( Date date ) {
        if ( date == null ) {
            return null;
        }

        GregorianCalendar c = new GregorianCalendar();
        c.setTime( date );
        return datatypeFactory.newXMLGregorianCalendar( c );
    }

    protected ValueHelpDto fakturaToValueHelpDto(Faktura faktura) {
        if ( faktura == null ) {
            return null;
        }

        ValueHelpDto valueHelpDto = new ValueHelpDto();

        if ( faktura.getNuid() != null ) {
            valueHelpDto.setId( faktura.getNuid() );
        }

        return valueHelpDto;
    }

    protected ValueHelpDto fakturaToValueHelpDto1(Faktura faktura) {
        if ( faktura == null ) {
            return null;
        }

        ValueHelpDto valueHelpDto = new ValueHelpDto();

        if ( faktura.getMestoIsporuke() != null ) {
            valueHelpDto.setId( faktura.getMestoIsporuke() );
        }

        return valueHelpDto;
    }

    protected ValueHelpDto fakturaToValueHelpDto2(Faktura faktura) {
        if ( faktura == null ) {
            return null;
        }

        ValueHelpDto valueHelpDto = new ValueHelpDto();

        if ( faktura.getNiid() != null ) {
            valueHelpDto.setId( faktura.getNiid() );
        }

        return valueHelpDto;
    }

    protected ValueHelpDto fakturaToValueHelpDto3(Faktura faktura) {
        if ( faktura == null ) {
            return null;
        }

        ValueHelpDto valueHelpDto = new ValueHelpDto();

        if ( faktura.getStatus() != null ) {
            valueHelpDto.setId( faktura.getStatus() );
        }

        return valueHelpDto;
    }

    protected List<FakturaDetaljiDto> fakturaDetaljiListToFakturaDetaljiDtoList(List<FakturaDetalji> list) {
        if ( list == null ) {
            return null;
        }

        List<FakturaDetaljiDto> list1 = new ArrayList<FakturaDetaljiDto>( list.size() );
        for ( FakturaDetalji fakturaDetalji : list ) {
            list1.add( map( fakturaDetalji ) );
        }

        return list1;
    }

    private Integer fakturaNacinPlacanjaId(FakturaDto fakturaDto) {
        if ( fakturaDto == null ) {
            return null;
        }
        ValueHelpDto nacinPlacanja = fakturaDto.getNacinPlacanja();
        if ( nacinPlacanja == null ) {
            return null;
        }
        Integer id = nacinPlacanja.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer fakturaNacinPrevozaId(FakturaDto fakturaDto) {
        if ( fakturaDto == null ) {
            return null;
        }
        ValueHelpDto nacinPrevoza = fakturaDto.getNacinPrevoza();
        if ( nacinPrevoza == null ) {
            return null;
        }
        Integer id = nacinPrevoza.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer fakturaAdresaId(FakturaDto fakturaDto) {
        if ( fakturaDto == null ) {
            return null;
        }
        ValueHelpDto adresa = fakturaDto.getAdresa();
        if ( adresa == null ) {
            return null;
        }
        Integer id = adresa.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected FakturaDetalji fakturaDetaljiDtoToFakturaDetalji(FakturaDetaljiDto fakturaDetaljiDto) {
        if ( fakturaDetaljiDto == null ) {
            return null;
        }

        FakturaDetalji fakturaDetalji = new FakturaDetalji();

        if ( fakturaDetaljiDto.getRobaId() != null ) {
            fakturaDetalji.setRobaId( fakturaDetaljiDto.getRobaId() );
        }
        if ( fakturaDetaljiDto.getKolicina() != null ) {
            fakturaDetalji.setKolicina( fakturaDetaljiDto.getKolicina() );
        }
        if ( fakturaDetaljiDto.getPotvrdjenaKolicina() != null ) {
            fakturaDetalji.setPotvrdjenaKolicina( fakturaDetaljiDto.getPotvrdjenaKolicina() );
        }
        if ( fakturaDetaljiDto.getCena() != null ) {
            fakturaDetalji.setCena( fakturaDetaljiDto.getCena() );
        }
        if ( fakturaDetaljiDto.getStatus() != null ) {
            fakturaDetalji.setStatus( map( fakturaDetaljiDto.getStatus() ) );
        }
        if ( fakturaDetaljiDto.getRabat() != null ) {
            fakturaDetalji.setRabat( fakturaDetaljiDto.getRabat() );
        }

        return fakturaDetalji;
    }

    protected List<FakturaDetalji> fakturaDetaljiDtoListToFakturaDetaljiList(List<FakturaDetaljiDto> list) {
        if ( list == null ) {
            return null;
        }

        List<FakturaDetalji> list1 = new ArrayList<FakturaDetalji>( list.size() );
        for ( FakturaDetaljiDto fakturaDetaljiDto : list ) {
            list1.add( fakturaDetaljiDtoToFakturaDetalji( fakturaDetaljiDto ) );
        }

        return list1;
    }

    protected void nacinPlacanjaToValueHelpDto(NacinPlacanja nacinPlacanja, ValueHelpDto mappingTarget) {
        if ( nacinPlacanja == null ) {
            return;
        }

        if ( nacinPlacanja.getId() != null ) {
            mappingTarget.setId( nacinPlacanja.getId() );
        }
        else {
            mappingTarget.setId( null );
        }
        if ( nacinPlacanja.getNaziv() != null ) {
            mappingTarget.setNaziv( nacinPlacanja.getNaziv() );
        }
        else {
            mappingTarget.setNaziv( null );
        }
    }

    protected void nacinPrevozaToValueHelpDto(NacinPrevoza nacinPrevoza, ValueHelpDto mappingTarget) {
        if ( nacinPrevoza == null ) {
            return;
        }

        if ( nacinPrevoza.getNaziv() != null ) {
            mappingTarget.setNaziv( nacinPrevoza.getNaziv() );
        }
        else {
            mappingTarget.setNaziv( null );
        }
        if ( nacinPrevoza.getId() != null ) {
            mappingTarget.setId( nacinPrevoza.getId() );
        }
        else {
            mappingTarget.setId( null );
        }
    }

    protected void mestaIsporukeToValueHelpDto(MestaIsporuke mestaIsporuke, ValueHelpDto mappingTarget) {
        if ( mestaIsporuke == null ) {
            return;
        }

        if ( mestaIsporuke.getPpid() != null ) {
            mappingTarget.setId( mestaIsporuke.getPpid() );
        }
        else {
            mappingTarget.setId( null );
        }
        if ( mestaIsporuke.getAdresa() != null ) {
            mappingTarget.setNaziv( mestaIsporuke.getAdresa() );
        }
        else {
            mappingTarget.setNaziv( null );
        }
    }

    protected void statusToValueHelpDto(Status status, ValueHelpDto mappingTarget) {
        if ( status == null ) {
            return;
        }

        if ( status.getId() != null ) {
            mappingTarget.setId( status.getId() );
        }
        else {
            mappingTarget.setId( null );
        }
        if ( status.getOpis() != null ) {
            mappingTarget.setNaziv( status.getOpis() );
        }
        else {
            mappingTarget.setNaziv( null );
        }
    }

    protected ValueHelpDto fakturaDetaljiToValueHelpDto(FakturaDetalji fakturaDetalji) {
        if ( fakturaDetalji == null ) {
            return null;
        }

        ValueHelpDto valueHelpDto = new ValueHelpDto();

        if ( fakturaDetalji.getStatus() != null ) {
            valueHelpDto.setId( fakturaDetalji.getStatus() );
        }

        return valueHelpDto;
    }

    protected void statusToValueHelpDto1(Status status, ValueHelpDto mappingTarget) {
        if ( status == null ) {
            return;
        }

        if ( status.getId() != null ) {
            mappingTarget.setId( status.getId() );
        }
        else {
            mappingTarget.setId( null );
        }
        if ( status.getOpis() != null ) {
            mappingTarget.setNaziv( status.getOpis() );
        }
        else {
            mappingTarget.setNaziv( null );
        }
    }

    protected void robaToSlikaDto(Roba roba, SlikaDto mappingTarget) {
        if ( roba == null ) {
            return;
        }

        if ( roba.getSlika() != null ) {
            mappingTarget.setRobaSlika( roba.getSlika() );
        }
        else {
            mappingTarget.setRobaSlika( null );
        }
    }
}
