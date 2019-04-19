import { Component, OnInit, ViewChild } from '@angular/core';
import { DataService } from '../service/data/data.service';
import { Korpa, RobaKorpa } from '../model/porudzbenica';
import { LocalStorageService } from '../service/data/local-storage.service';
import { MatTable, MatDialog } from '@angular/material';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { ValueHelp, Partner, Fakutra, FakturaDetalji, Proizvodjač } from '../model/dto';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../service/login.service';
import { FakturaService } from '../service/faktura.service';
import { Router } from '@angular/router';
import { IzmenaKolicineModalComponent } from 'src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component';
import { UspesnoPorucivanjeModalComponent } from 'src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component';

@Component({
  selector: 'app-korpa',
  templateUrl: './korpa.component.html',
  styleUrls: ['./korpa.component.scss']
})
export class KorpaComponent implements OnInit {

  public korpa: Korpa;
  public partner: Partner;
  public bezPdv: string;
  public pdv: string;
  public ukupno: string;
  public dataSource: any;
  public nacinPlacanja: ValueHelp[];
  public izabranNacinPlacanja: ValueHelp;
  public nacinPrevoza: ValueHelp[];
  public izabranNacinPrevoza: ValueHelp;
  private faktura: Fakutra;

  // sve forme
  public drugiNacinPrevoza: FormGroup;
  public adresaForm: FormGroup;
  public dugmeZaPorucivanjeStisnuto = false;

  public displayedColumns: string[] = ['katbr', 'katbrpro', 'naziv'
    , 'proizvodjac', 'kolicina', 'cena', 'izbaciDugme'];

  public treceLiceOpcije: string[] = ['Kurirske službe', 'Drugo'];
  public izabranaTrecaLiceOpcija: string;
  public kurirskeSluzbe: string[] = ['Aks', 'Beks', 'City'];
  public izabraneKurirskeSluzbe: string;
  public adresaDostave: string[] = ['Vaša adresa', 'Druga'];
  public izabraneAdresaDostave: string;
  public napomena: string;
  public ucitavanje = false;
  private alive = true;
  @ViewChild(MatTable) table: MatTable<any>;

  constructor(
    private dataService: DataService,
    private loginServis: LoginService,
    public storage: LocalStorageService,
    public dialog: MatDialog,
    private formBuilder: FormBuilder,
    private fakturaServis: FakturaService,
    private router: Router) { }

  ngOnInit() {
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    this.vratiOpsteInformacije();
    this.dataService.trenutnaKorpa.subscribe(korpa => {
      this.korpa = korpa;
      this.preracunajUkupno();
      this.dataSource = this.korpa.roba;
    });
    this.izabranaTrecaLiceOpcija = this.treceLiceOpcije[0];
    this.izabraneKurirskeSluzbe = this.kurirskeSluzbe[0];
    this.izabraneAdresaDostave = this.adresaDostave[0];
    this.inicijalizujSveForme();
  }

  inicijalizujSveForme() {
    this.drugiNacinPrevoza = this.formBuilder.group({
      prevoz: ['', [Validators.required, Validators.minLength(3)]]
    });
    this.adresaForm = this.formBuilder.group({
      ulica: ['', [Validators.required, Validators.minLength(3)]],
      grad: ['', [Validators.required, Validators.minLength(2)]]
    });
  }

  vratiOpsteInformacije() {
    const vrsteInformacije = ['placanje', 'prevoz'];
    vrsteInformacije.forEach(vrsta => {
      this.dataService.vratiOpsteInformacije(vrsta).pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => throwError(error)),
        finalize(() => this.ucitavanje = false)
      )
        .subscribe(
          res => {
            if (vrsta === vrsteInformacije[0]) {
              this.nacinPlacanja = res;
              this.izabranNacinPlacanja = res[0];
            } else {
              this.nacinPrevoza = res;
              this.izabranNacinPrevoza = res[0];
            }
          },
          error => {
            console.log('Podnaci informaciju je izbacilo gresku izbacilo je gresko');
          });
    });

  }

  izbaciIzKorpe(index: number) {
    this.dataService.izbaciIzKorpe(index);
    this.table.renderRows();
  }

  otvoriDialog(roba: RobaKorpa): void {
    const dialogRef = this.dialog.open(IzmenaKolicineModalComponent, {
      width: '400px',
      data: roba
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      if (result) {
        this.promeniKolicinuArtikla(result);
      }
    });
  }
  otvoriDialogUspesnoPorucivanje(faktura: Fakutra): void {
    const dialogRef = this.dialog.open(UspesnoPorucivanjeModalComponent, {
      width: '400px',
      data: faktura
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.router.navigate(['/naslovna']);
    });
  }

  promeniKolicinuArtikla(artikal: RobaKorpa) {
    this.korpa.roba.forEach(roba => {
      if (roba.katbr === artikal.katbr) {
        roba.kolicina = artikal.kolicina;
        roba.cenaUkupno = artikal.cenaUkupno;
      }
    });
    this.storage.zameniArtikalSaNovim(artikal);
    this.preracunajUkupno();
    this.dataSource = this.korpa.roba;
    this.table.renderRows();
  }

  private preracunajUkupno() {
    this.korpa.ukupno = 0;
    this.korpa.roba.forEach(roba => {
      this.korpa.ukupno = this.korpa.ukupno + roba.cenaUkupno;
    });
    this.bezPdv = (this.korpa.ukupno / 1.2).toFixed(2);
    this.pdv = (this.korpa.ukupno - this.korpa.ukupno / 1.2).toFixed(2);
    this.ukupno = this.korpa.ukupno.toFixed(2);
  }

  // glavna metoda
  posaljiPorudzbinu() {
    this.dugmeZaPorucivanjeStisnuto = true;
    if (this.izabraneAdresaDostave === this.adresaDostave[1]) {
      if (this.adresaForm.invalid) {
        return;
      }
    }
    if (this.izabranNacinPrevoza === this.treceLiceOpcije[1]) {
      if (this.drugiNacinPrevoza.invalid) {
        return;
      }
    }
    this.korpa.nacinIsporuke = this.izabranNacinPrevoza.id;
    this.korpa.nacinPlacanja = this.izabranNacinPlacanja.id;
    this.popuniNapomenu();
    this.korpaUFakturu();
    this.fakturaServis.sacuvajFakturu(this.faktura).pipe(
      takeWhile(() => this.alive),
      catchError((error: Response) => throwError(error)),
      finalize(() => this.ucitavanje = false)
    )
      .subscribe(
        res => {
          this.faktura = res;
          this.otvoriDialogUspesnoPorucivanje(this.faktura);
          this.dataService.ocistiKorpu();
          this.router.navigate(['/naslovna']);
        },
        error => {
          console.log('Cuvaj fakturu u bazi');
        });

    console.log('Kora za porudzbinu  ' + JSON.stringify(this.faktura));
    console.log('Porucivanje je uspesno! :)');
  }

  korpaUFakturu() {
    this.faktura = new Fakutra();
    this.faktura.adresa = this.napraviIPopuniValueHelp(this.partner.ppid);
    this.faktura.nacinPlacanja = this.napraviIPopuniValueHelp(this.korpa.nacinPlacanja);
    this.faktura.nacinPrevoza = this.napraviIPopuniValueHelp(this.korpa.nacinIsporuke);
    this.faktura.napomena = this.korpa.napomena;
    this.faktura.iznos = this.korpa.ukupno;
    this.faktura.detalji = [];
    this.korpa.roba.forEach((roba: RobaKorpa) => {
      this.faktura.detalji.push(this.popuniStavke(roba));
    });
  }

  popuniStavke(roba: RobaKorpa) {
    const stavka = new FakturaDetalji();
    stavka.kataloskiBroj = roba.katbr;
    stavka.proizvodjac = roba.proizvodjac;
    stavka.kolicina = roba.kolicina;
    stavka.rabat = roba.rabat;
    stavka.robaId = roba.robaid;
    stavka.cena = roba.cenaKom;
    return stavka;
  }

  napraviIPopuniValueHelp(id: number): ValueHelp {
    const valueHelp = new ValueHelp();
    valueHelp.id = id;
    return valueHelp;
  }

  popuniNapomenu() {
    this.korpa.napomena = '';
    if (this.izabranNacinPrevoza === this.nacinPrevoza[2]) {
      let nacinPrevoza;
      if (this.izabranaTrecaLiceOpcija === this.treceLiceOpcije[0]) {
        nacinPrevoza = this.izabraneKurirskeSluzbe;
      } else {
        nacinPrevoza = this.drugiNacinPrevoza.controls.prevoz.value;
      }
      this.korpa.napomena = this.korpa.napomena + 'Način prevoza: ' + nacinPrevoza + ' - ';
    }

    if (this.izabraneAdresaDostave === this.adresaDostave[1]) {
      let adresaDostave;
      if (this.izabranaTrecaLiceOpcija === this.treceLiceOpcije[0]) {
        adresaDostave = this.adresaForm.controls.ulica.value + ', ' + this.adresaForm.controls.grad.value;
      }
      this.korpa.napomena = this.korpa.napomena + 'Adresa dostave: ' + adresaDostave + ' - ';
    }
    if (this.napomena) {
      this.korpa.napomena = this.korpa.napomena + 'Napomena: ' + this.napomena;
    }
  }

  // convenience getter for easy access to form fields
  get a() { return this.adresaForm.controls; }
  get d() { return this.drugiNacinPrevoza.controls; }
}
