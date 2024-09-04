package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.izvestaj.FirmaDto;
import com.automaterijal.application.domain.dto.izvestaj.KomentarDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.Firma;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.Komentar;
import com.automaterijal.application.domain.entity.komercijalista.izvestaj.KreirajIzvestaj;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class IzvetajMapperImpl implements IzvetajMapper {

    private final DatatypeFactory datatypeFactory;

    public IzvetajMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public KomentarDto map(Komentar komentar, Partner partner) {
        if ( komentar == null && partner == null ) {
            return null;
        }

        KomentarDto komentarDto = new KomentarDto();

        if ( komentar != null ) {
            if ( komentar.getPodsetnik() != null ) {
                komentarDto.setPodsetnik( xmlGregorianCalendarToLocalDate( dateToXmlGregorianCalendar( komentar.getPodsetnik() ) ) );
            }
            if ( komentar.getDatumKreiranja() != null ) {
                komentarDto.setDatumKreiranja( komentar.getDatumKreiranja() );
            }
            if ( komentar.getKomentar() != null ) {
                komentarDto.setKomentar( komentar.getKomentar() );
            }
            if ( komentar.getId() != null ) {
                komentarDto.setId( komentar.getId() );
            }
            if ( komentar.getFirma() != null ) {
                komentarDto.setFirma( komentar.getFirma() );
            }
            if ( komentar.getPpid() != null ) {
                komentarDto.setPpid( komentar.getPpid() );
            }
        }
        if ( partner != null ) {
            if ( partner.getNaziv() != null ) {
                komentarDto.setKomercijalista( partner.getNaziv() );
            }
        }

        return komentarDto;
    }

    @Override
    public FirmaDto map(Firma firma) {
        if ( firma == null ) {
            return null;
        }

        FirmaDto firmaDto = new FirmaDto();

        if ( firma.getId() != null ) {
            firmaDto.setId( firma.getId() );
        }
        if ( firma.getMesto() != null ) {
            firmaDto.setMesto( firma.getMesto() );
        }
        if ( firma.getIme() != null ) {
            firmaDto.setIme( firma.getIme() );
        }
        if ( firma.getAdresa() != null ) {
            firmaDto.setAdresa( firma.getAdresa() );
        }
        if ( firma.getKontakt() != null ) {
            firmaDto.setKontakt( firma.getKontakt() );
        }
        if ( firma.getSektor() != null ) {
            firmaDto.setSektor( firma.getSektor() );
        }
        if ( firma.getOsnovniAsortiman() != null ) {
            firmaDto.setOsnovniAsortiman( firma.getOsnovniAsortiman() );
        }
        if ( firma.getKonkurent() != null ) {
            firmaDto.setKonkurent( firma.getKonkurent() );
        }

        return firmaDto;
    }

    @Override
    public Komentar mapIzvestaj(KreirajIzvestaj izvestaj, Firma firma, Partner partner) {
        if ( izvestaj == null && firma == null && partner == null ) {
            return null;
        }

        Komentar komentar = new Komentar();

        if ( izvestaj != null ) {
            if ( izvestaj.getDatumKreiranja() != null ) {
                komentar.setDatumKreiranja( map( izvestaj.getDatumKreiranja() ) );
            }
            if ( izvestaj.getPodsetnik() != null ) {
                komentar.setPodsetnik( map( izvestaj.getPodsetnik() ) );
            }
            if ( izvestaj.getKomentar() != null ) {
                komentar.setKomentar( izvestaj.getKomentar() );
            }
        }
        if ( firma != null ) {
            if ( firma.getId() != null ) {
                komentar.setFirma( firma.getId() );
            }
        }
        if ( partner != null ) {
            if ( partner.getPpid() != null ) {
                komentar.setPpid( partner.getPpid() );
            }
        }

        return komentar;
    }

    @Override
    public Firma mapirajFirmu(KreirajIzvestaj izvestaj, Partner partner) {
        if ( izvestaj == null && partner == null ) {
            return null;
        }

        Firma firma = new Firma();

        if ( izvestaj != null ) {
            if ( izvestaj.getIme() != null ) {
                firma.setIme( izvestaj.getIme() );
            }
            if ( izvestaj.getSektor() != null ) {
                firma.setSektor( izvestaj.getSektor() );
            }
            if ( izvestaj.getAdresa() != null ) {
                firma.setAdresa( izvestaj.getAdresa() );
            }
            if ( izvestaj.getKontakt() != null ) {
                firma.setKontakt( izvestaj.getKontakt() );
            }
            if ( izvestaj.getMesto() != null ) {
                firma.setMesto( izvestaj.getMesto() );
            }
            if ( izvestaj.getFirmaId() != null ) {
                firma.setId( izvestaj.getFirmaId() );
            }
            if ( izvestaj.getKonkurent() != null ) {
                firma.setKonkurent( izvestaj.getKonkurent() );
            }
            if ( izvestaj.getOsnovniAsortiman() != null ) {
                firma.setOsnovniAsortiman( izvestaj.getOsnovniAsortiman() );
            }
        }
        if ( partner != null ) {
            if ( partner.getPpid() != null ) {
                firma.setPpid( partner.getPpid() );
            }
        }

        return firma;
    }

    private static LocalDate xmlGregorianCalendarToLocalDate( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        return LocalDate.of( xcal.getYear(), xcal.getMonth(), xcal.getDay() );
    }

    private XMLGregorianCalendar dateToXmlGregorianCalendar( Date date ) {
        if ( date == null ) {
            return null;
        }

        GregorianCalendar c = new GregorianCalendar();
        c.setTime( date );
        return datatypeFactory.newXMLGregorianCalendar( c );
    }
}
