package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.tecdoc.TecDocDokumentacija;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.tecdoc.ArticleDocuments2Record;
import com.automaterijal.application.tecdoc.AssignedArticleAttributs2Record;
import com.automaterijal.application.tecdoc.ThumbnailByArticleIdRecord;
import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-04T11:53:45+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class TecDocMapperImpl implements TecDocMapper {

    @Override
    public TecDocAtributi map(AssignedArticleAttributs2Record record, RobaDto robaDto, Long tecDocArticleId, Integer tecDocPpid) {
        if ( record == null && robaDto == null && tecDocArticleId == null && tecDocPpid == null ) {
            return null;
        }

        TecDocAtributi tecDocAtributi = new TecDocAtributi();

        if ( record != null ) {
            if ( record.getAttrUnit() != null ) {
                tecDocAtributi.setAttrUnit( record.getAttrUnit() );
            }
            if ( record.getAttrShortName() != null ) {
                tecDocAtributi.setAttrShortName( record.getAttrShortName() );
            }
            if ( record.getAttrValue() != null ) {
                tecDocAtributi.setAttrValue( record.getAttrValue() );
            }
            if ( record.getAttrType() != null ) {
                tecDocAtributi.setAttrType( record.getAttrType() );
            }
        }
        if ( robaDto != null ) {
            if ( robaDto.getRobaid() != null ) {
                tecDocAtributi.setRobaId( robaDto.getRobaid() );
            }
            String proid = robaDtoProizvodjacProid( robaDto );
            if ( proid != null ) {
                tecDocAtributi.setPpid( proid );
            }
            if ( robaDto.getKatbr() != null ) {
                tecDocAtributi.setKatbr( robaDto.getKatbr() );
            }
            byte[] dokument = robaDto.getDokument();
            if ( dokument != null ) {
                tecDocAtributi.setDokument( Arrays.copyOf( dokument, dokument.length ) );
            }
        }
        if ( tecDocArticleId != null ) {
            tecDocAtributi.setTecDocArticleId( tecDocArticleId.intValue() );
        }
        if ( tecDocPpid != null ) {
            tecDocAtributi.setTecDocPpid( tecDocPpid );
        }

        return tecDocAtributi;
    }

    @Override
    public TecDocAtributi map(ArticleDocuments2Record record, RobaDto robaDto, Long tecDocArticleId, Integer tecDocPpid) {
        if ( record == null && robaDto == null && tecDocArticleId == null && tecDocPpid == null ) {
            return null;
        }

        TecDocAtributi tecDocAtributi = new TecDocAtributi();

        if ( record != null ) {
            if ( record.getDocId() != null ) {
                tecDocAtributi.setDokumentId( record.getDocId() );
            }
        }
        if ( robaDto != null ) {
            if ( robaDto.getRobaid() != null ) {
                tecDocAtributi.setRobaId( robaDto.getRobaid() );
            }
            String proid = robaDtoProizvodjacProid( robaDto );
            if ( proid != null ) {
                tecDocAtributi.setPpid( proid );
            }
            if ( robaDto.getKatbr() != null ) {
                tecDocAtributi.setKatbr( robaDto.getKatbr() );
            }
            byte[] dokument = robaDto.getDokument();
            if ( dokument != null ) {
                tecDocAtributi.setDokument( Arrays.copyOf( dokument, dokument.length ) );
            }
        }
        if ( tecDocArticleId != null ) {
            tecDocAtributi.setTecDocArticleId( tecDocArticleId.intValue() );
        }
        if ( tecDocPpid != null ) {
            tecDocAtributi.setTecDocPpid( tecDocPpid );
        }

        return tecDocAtributi;
    }

    @Override
    public TecDocDokumentacija map(ArticleDocuments2Record record) {
        if ( record == null ) {
            return null;
        }

        TecDocDokumentacija tecDocDokumentacija = new TecDocDokumentacija();

        if ( record.getDocFileTypeName() != null ) {
            tecDocDokumentacija.setDocFileTypeName( record.getDocFileTypeName() );
        }
        if ( record.getDocId() != null ) {
            tecDocDokumentacija.setDocId( record.getDocId() );
        }
        if ( record.getDocLinkId() != null ) {
            tecDocDokumentacija.setDocLinkId( record.getDocLinkId() );
        }
        if ( record.getDocText() != null ) {
            tecDocDokumentacija.setDocText( record.getDocText() );
        }
        if ( record.getDocTypeId() != null ) {
            tecDocDokumentacija.setDocTypeId( record.getDocTypeId() );
        }
        if ( record.getDocTypeName() != null ) {
            tecDocDokumentacija.setDocTypeName( record.getDocTypeName() );
        }
        if ( record.getDocUrl() != null ) {
            tecDocDokumentacija.setDocUrl( record.getDocUrl() );
        }

        return tecDocDokumentacija;
    }

    @Override
    public TecDocAtributi map(ThumbnailByArticleIdRecord record, RobaDto robaDto, Long tecDocArticleId, Integer tecDocPpid) {
        if ( record == null && robaDto == null && tecDocArticleId == null && tecDocPpid == null ) {
            return null;
        }

        TecDocAtributi tecDocAtributi = new TecDocAtributi();

        if ( record != null ) {
            if ( record.getThumbDocId() != null ) {
                tecDocAtributi.setDokumentId( record.getThumbDocId() );
            }
        }
        if ( robaDto != null ) {
            if ( robaDto.getRobaid() != null ) {
                tecDocAtributi.setRobaId( robaDto.getRobaid() );
            }
            String proid = robaDtoProizvodjacProid( robaDto );
            if ( proid != null ) {
                tecDocAtributi.setPpid( proid );
            }
            if ( robaDto.getKatbr() != null ) {
                tecDocAtributi.setKatbr( robaDto.getKatbr() );
            }
            byte[] dokument = robaDto.getDokument();
            if ( dokument != null ) {
                tecDocAtributi.setDokument( Arrays.copyOf( dokument, dokument.length ) );
            }
        }
        if ( tecDocArticleId != null ) {
            tecDocAtributi.setTecDocArticleId( tecDocArticleId.intValue() );
        }
        if ( tecDocPpid != null ) {
            tecDocAtributi.setTecDocPpid( tecDocPpid );
        }

        return tecDocAtributi;
    }

    private String robaDtoProizvodjacProid(RobaDto robaDto) {
        if ( robaDto == null ) {
            return null;
        }
        Proizvodjac proizvodjac = robaDto.getProizvodjac();
        if ( proizvodjac == null ) {
            return null;
        }
        String proid = proizvodjac.getProid();
        if ( proid == null ) {
            return null;
        }
        return proid;
    }
}
