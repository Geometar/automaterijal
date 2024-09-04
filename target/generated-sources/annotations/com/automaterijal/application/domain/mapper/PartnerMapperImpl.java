package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.dto.PartnerLogovanjeDto;
import com.automaterijal.application.domain.entity.MestaIsporuke;
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
public class PartnerMapperImpl implements PartnerMapper {

    @Override
    public PartnerDto map(Partner partner) {
        if ( partner == null ) {
            return null;
        }

        PartnerDto partnerDto = new PartnerDto();

        if ( partner.getPrivilegije() != null ) {
            partnerDto.setPrivilegije( partner.getPrivilegije() );
        }
        String naziv = partnerMestaIsporukeNaziv( partner );
        if ( naziv != null ) {
            partnerDto.setNaziv( naziv );
        }
        String adresa = partnerMestaIsporukeAdresa( partner );
        if ( adresa != null ) {
            partnerDto.setAdresa( adresa );
        }
        Integer loginCount = partnerUsersLoginCount( partner );
        if ( loginCount != null ) {
            partnerDto.setLoginCount( loginCount );
        }
        else {
            partnerDto.setLoginCount( 0 );
        }
        if ( partner.getPpid() != null ) {
            partnerDto.setPpid( partner.getPpid() );
        }
        if ( partner.getEmail() != null ) {
            partnerDto.setEmail( partner.getEmail() );
        }
        if ( partner.getWebKorisnik() != null ) {
            partnerDto.setWebKorisnik( partner.getWebKorisnik() );
        }
        if ( partner.getStanje() != null ) {
            partnerDto.setStanje( partner.getStanje() );
        }
        if ( partner.getStanjeporoku() != null ) {
            partnerDto.setStanjeporoku( partner.getStanjeporoku() );
        }
        if ( partner.getWebStatus() != null ) {
            partnerDto.setWebStatus( partner.getWebStatus() );
        }

        return partnerDto;
    }

    @Override
    public void map(Partner partner, PartnerDto partnerDto) {
        if ( partnerDto == null ) {
            return;
        }

        if ( partner.getUsers() == null ) {
            partner.setUsers( new Users() );
        }
        partnerDtoToUsers( partnerDto, partner.getUsers() );
        if ( partner.getMestaIsporuke() == null ) {
            partner.setMestaIsporuke( new MestaIsporuke() );
        }
        partnerDtoToMestaIsporuke( partnerDto, partner.getMestaIsporuke() );
        if ( partnerDto.getNaziv() != null ) {
            partner.setNaziv( partnerDto.getNaziv() );
        }
        if ( partnerDto.getEmail() != null ) {
            partner.setEmail( partnerDto.getEmail() );
        }
        if ( partnerDto.getWebKorisnik() != null ) {
            partner.setWebKorisnik( partnerDto.getWebKorisnik() );
        }
        if ( partnerDto.getWebStatus() != null ) {
            partner.setWebStatus( partnerDto.getWebStatus() );
        }
        if ( partnerDto.getPrivilegije() != null ) {
            partner.setPrivilegije( partnerDto.getPrivilegije() );
        }
    }

    @Override
    public PartnerLogovanjeDto mapLogovanje(Partner partner) {
        if ( partner == null ) {
            return null;
        }

        PartnerLogovanjeDto partnerLogovanjeDto = new PartnerLogovanjeDto();

        String naziv = partnerMestaIsporukeNaziv( partner );
        if ( naziv != null ) {
            partnerLogovanjeDto.setNaziv( naziv );
        }
        if ( partner.getPpid() != null ) {
            partnerLogovanjeDto.setPpid( partner.getPpid() );
        }

        afterMaper( partnerLogovanjeDto, partner );

        return partnerLogovanjeDto;
    }

    private String partnerMestaIsporukeNaziv(Partner partner) {
        if ( partner == null ) {
            return null;
        }
        MestaIsporuke mestaIsporuke = partner.getMestaIsporuke();
        if ( mestaIsporuke == null ) {
            return null;
        }
        String naziv = mestaIsporuke.getNaziv();
        if ( naziv == null ) {
            return null;
        }
        return naziv;
    }

    private String partnerMestaIsporukeAdresa(Partner partner) {
        if ( partner == null ) {
            return null;
        }
        MestaIsporuke mestaIsporuke = partner.getMestaIsporuke();
        if ( mestaIsporuke == null ) {
            return null;
        }
        String adresa = mestaIsporuke.getAdresa();
        if ( adresa == null ) {
            return null;
        }
        return adresa;
    }

    private Integer partnerUsersLoginCount(Partner partner) {
        if ( partner == null ) {
            return null;
        }
        Users users = partner.getUsers();
        if ( users == null ) {
            return null;
        }
        Integer loginCount = users.getLoginCount();
        if ( loginCount == null ) {
            return null;
        }
        return loginCount;
    }

    protected void partnerDtoToUsers(PartnerDto partnerDto, Users mappingTarget) {
        if ( partnerDto == null ) {
            return;
        }

        if ( partnerDto.getNoviPassword() != null ) {
            mappingTarget.setPassword( partnerDto.getNoviPassword() );
        }
    }

    protected void partnerDtoToMestaIsporuke(PartnerDto partnerDto, MestaIsporuke mappingTarget) {
        if ( partnerDto == null ) {
            return;
        }

        if ( partnerDto.getAdresa() != null ) {
            mappingTarget.setAdresa( partnerDto.getAdresa() );
        }
    }
}
