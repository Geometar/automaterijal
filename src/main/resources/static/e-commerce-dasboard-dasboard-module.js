(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-commerce-dasboard-dasboard-module"],{

/***/ "./src/app/e-commerce/dasboard/clanak/clanak.component.html":
/*!******************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/clanak/clanak.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\n  <div class=\"d-flex flex-row-reverse bd-highlight\">\n    <button class=\"button-glavni-100 nazad-button\" mat-raised-button (click)=\"idiNazad()\">\n      <mat-icon>keyboard_arrow_left</mat-icon> Nazad\n    </button>\n  </div>\n  <section>\n    <div class=\"d-flex flex-column d-flex justify-content-center vest-sektor\">\n      <div [innerHTML]=\"vest.naslov\"></div>\n      <div><img src={{vest.slika}}></div>\n      <div [innerHTML]=\"vest.tekst\"></div>\n    </div>\n  </section>\n</main>"

/***/ }),

/***/ "./src/app/e-commerce/dasboard/clanak/clanak.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/clanak/clanak.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "img {\n  width: 100%;\n  height: 300px; }\n\n.vest-sektor {\n  width: 50%;\n  margin-left: 25%; }\n\n/* :host /deep/ mySelector { */\n\n:host ::ng-deep ul {\n  list-style-type: circle;\n  padding: 0px 30px; }\n\n:host ::ng-deep p {\n  margin-top: 15px;\n  padding: 10px; }\n\n:host ::ng-deep img {\n  width: 100%;\n  height: 100%; }\n\n:host ::ng-deep h1 {\n  text-align: center;\n  margin-bottom: 20px; }\n\n@media only screen and (max-width: 1025px) {\n  .img {\n    width: 100%;\n    height: 100%; }\n  .vest-sektor {\n    width: 90%;\n    margin-left: 5%; } }\n"

/***/ }),

/***/ "./src/app/e-commerce/dasboard/clanak/clanak.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/clanak/clanak.component.ts ***!
  \****************************************************************/
/*! exports provided: ClanakComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ClanakComponent", function() { return ClanakComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../model/dto */ "./src/app/e-commerce/model/dto.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ClanakComponent = /** @class */ (function () {
    function ClanakComponent(router, route) {
        this.router = router;
        this.route = route;
    }
    ClanakComponent.prototype.ngOnInit = function () {
        var urlParam;
        this.route.params.subscribe(function (params) {
            urlParam = params.id;
        });
        this.vest = this.objediniSveVesti()
            .filter(function (vest) { return vest.id === urlParam; })
            .pop();
    };
    ClanakComponent.prototype.idiNazad = function () {
        this.router.navigate(['/naslovna']);
    };
    ClanakComponent.prototype.objediniSveVesti = function () {
        var sveVesti = [];
        sveVesti.push(this.shell_u_ponudi(), this.febi_u_ponudi(), this.mahle_u_ponudi(), this.ks_u_ponudi(), this.mahle_pakovanje_vesti(), this.mahle_kompresori_vesti());
        return sveVesti;
    };
    ClanakComponent.prototype.shell_u_ponudi = function () {
        var shell_u_ponudi = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["Vest"]();
        shell_u_ponudi.id = 'shell-u-ponudi';
        shell_u_ponudi.naslov = '<h1>Uz novu <b>GTL</b> tehnologiju budućnost je počela</h1>';
        shell_u_ponudi.slika = 'assets/slike/novouponudi/velika/shell.png';
        shell_u_ponudi.tekst = '<p>Shell je multinacionalna angloholandska naftna kompanija osnovana osnovana u Ujedinjenom Kraljevstvu sa sedištem u Holandiji. Kompanija je vertikalno integrisana i ima aktivnosti gotovo u svim područijima industrije nafte i gasa. Kao vodeća kompanija u proizvodnji ulja I maziva prisutan je u preko 100 zemalja. U svom portfoliu ima preko 2000 proizvoda raznih namena kako bi odgovorio svim zahtevima koje tržište diktira. Shell je takođe izbor mnogih proizvođača vozila, mašina, industrijskih postrojenja I mnogih dugih proizvođača kao prvo punjenje u svojim proizvodima. Shell je trenutno jedina energentska kompanija na svetu koja bazna ulja dobija iz gasa (GTL tehnologija). Postorjenje za preradu se nalazi u Kataru i jedino je tog tipa. Prvo postrojenje se nalazilo u Maleziji I napravljeno je pre 40 godina I sluzilo je za razvoj tehnologije. Razvitkom fabrika je premeštena u Katar I sada punim kapacitetima proizvodi potrebne količine baznog ulja za potrebe svetskog tržišta. </p> <p>Šel je takođe I po tržišnoj kapitalizaciji jedno od vodećih preuzeća u svetu. Šel je u  2013 godini bio vodeće preduzeće na Fortune global 500-listi najvećih preduzeća na svetu.</p>';
        return shell_u_ponudi;
    };
    ClanakComponent.prototype.febi_u_ponudi = function () {
        var shell_u_ponudi = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["Vest"]();
        shell_u_ponudi.id = 'febi-u-ponudi';
        shell_u_ponudi.naslov = '<h1>Kompletno rešenje za vaše vozilo</h1>';
        shell_u_ponudi.slika = 'assets/slike/novouponudi/velika/febi.png';
        shell_u_ponudi.tekst = '<p>Febi bilstein je  osnovan davne 1844 godine. Danas je jedan od vodećih svetskih proizvođača i dobavljača rezervnih delova za putnička i komercijalna vozila na nezavisnom tržištu rezervnih delova.  Više od 170 godina održava kontinuitet, kvalitet, uslugu, pouzdanost i inovacije. Asortiman cini 30.000 razlicitih rezervnih delova. Osim toga, febi ima svoja predstavništva ili iskusnog partnera u preko 69 zemalja. </p> <p>Od upravljačke, motorne i kočne tehnike, tehnike šasija i učvršćivanja točkova do autoelektrike i pneumatike i programa febi plus – kod firme febi bilstein ćete naći sve za profesionalno servisiranje - putničkih vozila, kamiona, autobusa, prikolica, poluprikolica i malih transportera svih aktuelnih marki i modela.</p> <p class="proba">Febi bilstein stoji za proizvode koji ispunjavaju najviše zahteve kvaliteta izrade i bezbednosti ugradnje. Kvalitetom, brzinom i postavljanjem trendova febi bilstein vam daje odlučujući podsticaj na globalnom tržištu. Zato što kao premium marka ima obavezu da ispuni zahteve svojih kupaca – svakodnevno.</p> <p>AUTOMATERIJAL d.o.o - je zastupnik koncerna Febi Bilstein i Blue Printa za zapadnu Srbiju.</p>';
        return shell_u_ponudi;
    };
    ClanakComponent.prototype.mahle_u_ponudi = function () {
        var mahle_u_ponudi = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["Vest"]();
        mahle_u_ponudi.id = 'mahle-u-ponudi';
        mahle_u_ponudi.naslov = '<h1>U korak sa vremenom</h1>';
        mahle_u_ponudi.slika = 'assets/slike/novouponudi/velika/mahle.png';
        mahle_u_ponudi.tekst = '<p>Mahle je vodeći međunarodni partner za razvoj I dobavljač za automobilsku industriju, kao I pionir I pokretač tehnologije za budućnost.</p> <p>Zasnovan na velikoj složenosti sistema koja se sastoji od motora I komponenata motora, filtriranja I upravljanja toplotnom energijom, portfolio proizvoda grupe se bavi svim ključnim pitanjima vezanim za tehnologiju pogonskog sistema i klima uređaja.</p> <p>Mahle proizvodi se ugrađuju u najmanje svako drugo vozilo širom sveta. Decenijama Mahle komponente I sistemi su takođe korišćeni na svetskim trkalištima I izvan puta-u stacionarnim aplikacijama, za mobilnu mašineriju, železničku transport, kao I pomorske aplikacije.</p> <p>Ono po čemu je Mahle preopoznatljiv širom sveta je svakako pre svega motorna grupa. Ogroman deo svetskih proizvođača vozila, kako  putničkih tako I teretnih upravo ugrađuju u svoje motore komponente dizajnirane u napravljene u Mahle fabrikama. Takođe, kupovinom svetskog Brenda Knecht, Mahle ulazi kao premijum proizvođač filtera na tržište, nudeći svoje proizvode u aftermarketu istog kvaliteta kao I oni koji su prva ugradnja ovog proizvođača.</p> <p>Kupovinom nekoliko velikih proizođača komponenti za vozila Mahle je svoj portfolio proširio I na uređaje vezane za klimatizaciju vozila, termomenadžment, turbopunjače, alternatore, alnasere I mnoge druge sastavne delove vozila. Ono po čemu je mahle prepoznatljiv je motorna grupa.</p>';
        return mahle_u_ponudi;
    };
    ClanakComponent.prototype.ks_u_ponudi = function () {
        var shell_u_ponudi = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["Vest"]();
        shell_u_ponudi.id = 'ks-u-ponudi';
        shell_u_ponudi.naslov = '<h1>Godine poverenja su preporuka</h1>';
        shell_u_ponudi.slika = 'assets/slike/novouponudi/velika/ks.png';
        shell_u_ponudi.tekst = '<p>U svojoj ulozi dobavljača prvog reda, Pierburg je tradicionalno bio jedan od najbližih partnera automobilskoj industriji, od samog početka uspešnog unapređenja razvoja automobila.Pierburg je osnovan 1909. godine kao trgovac čelikom u Berlinu; 1928. godine, Pierburg je počeo s proizvodnjom karburatora i vrlo brzo je stsao u glavnog  dobavljača za sve nemačke proizvođače automobila i mnoge međunarodne proizvođače motornih vozila i proizvođače motora.Godine 1986. Pierburg je preuzeo Rheinmetall Group i 1998. se spojio sa Kolbenschmidt-om da bi formirao Kolbenschmidt Pierburg AG.U okviru Rheinmetall Automotive, Pierburg je specijalista za kontrolu emisije, dovod vazduha, prigušne ventile i solenoidne ventile.Decenije iskustva u kombinaciji sa sveobuhvatnim, inovativnim i globalno priznatim mogućnostima u svakom aspektu motora su faktori koji su doveli Pierburg u svoju misiju da stalno razvija i proizvodi komponente, module i sisteme za budućnost.U razvoju novih generacija motora dobijaju na značaju takvi faktori kao što su smanjena potrošnja goriva, niže emisije štetnih gasova  i poboljšane performanse, udobnost i sigurnost.U te svrhe, Pierburg nudi visoko tehnološka rešenja: električne pumpe za hlađenje na zahtev, sisteme za recirkulaciju izduvnih gasova  sa ​​istosmernim motorom, ventile za odvod vazduha, te različite verzije pogonskih modula. Svi ovi razvoji pomažu da se stvori ekonomski i ekološki uravnotežen automobil.</p> <p>Divizija KS Kolbenschmidt razvija, proizvodi i prodaje klipove za benzinske i dizel motore za automobile i komercijalna vozila i jedan je od najistaknutijih igrača u svom segmentu. Ostali proizvodi uključuju klipove za dvotaktne i kompresorske motore kao i velike klipove za stacionarne, brodske i lokomotivne motore.Unapređenje gustine snage, kao i postizanje daljnjeg smanjenja potrošnje goriva i emisija, već godinama predstavljaju faktore koji utiču na razvoj novih tipova klipova kod KS Kolbenschmidt.</p>';
        return shell_u_ponudi;
    };
    ClanakComponent.prototype.mahle_pakovanje_vesti = function () {
        var mahlePakovanjeVesti = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["Vest"]();
        mahlePakovanjeVesti.id = 'mahle-pakovanje';
        mahlePakovanjeVesti.naslov = '<h1>Nova ambalaža - dokazan kvalitet</h1>';
        mahlePakovanjeVesti.slika = 'assets/slike/novouponudi/velika/mahle-pakovanja.png';
        mahlePakovanjeVesti.tekst = '<p>MAHLE Aftermarket proizvodi dolaze u novo dizajniranom pakovanju od 2019. godine. Jednostavno i jasno za lako rukovanje u trgovini i radionicama. I naravno, oni će još uvek imati dokazan kvalitet MAHLE.</p> <p>Novo: Jasne boje, koncizna informacija i jasan dizajn omogućavaju lako rukovanje i brzu identifikaciju u skladištu.</p> <p>Novi pristup opisu proizvoda prilagođen čitaču, dodatne ikone podrške za proizvode, prikazuju se samo bitne informacije.</p><p>Takođe je usklađena šema boja, što je rezultiralo sledećim promjenama:</p> <ul><li>Promena boje ambalaže BEHR sa narandžaste na plavu</li><li> Promena boje za delove motora od crvene do plave</li><li> Činimo ga još jednostavnijim: MAHLE ORIGINAL postaje MAHLE</li></ul> <p> Jednostavno i jasno - zahvaljujući novom dizajnu ambalaže: </p><ul> <li>Svi relevantni detalji na prvi pogled</li> <li>Jednostavno rukovanje u trgovini i radionicama</li> <li>Jednostavna identifikacija u skladištu (sa udaljenosti) zahvaljujući jasnim bojama</li> <li>Garantovana visoka sigurnost (zaštita od piraterije proizvoda)</li> <li>Snažan izgled za sedam jakih brendova</li></ul> <p>MAHLE Aftermarket objedinjuje sedam jakih, međunarodnih brendova koji su sinonim za inovacije i beskompromisni kvalitet. Pored kišobranskog brenda MAHLE, tu spadaju uspešne kompanije kao što su BEHR, CLEVITE, IZUMI, METAL LEVE i KNECHT FILTER. BRAIN BEE, novo integrisana u MAHLE porodicu marki 2018. godine, je stručnjak za radioničku opremu i dijagnostiku za tržišta u Evropi, Bliskom Istoku, Africi, Južnoj Americi i delovima Azije.</p>   <p>Širom svijeta, brand MAHLE je sinonim za rezervne delove u kvalitetui originalne opreme duž celog pogonskog sklopa - od komponenti motora, turbokompresora, filtera, hlađenja motora i klima uređaja, starter motora i alternatora kroz radioničku opremu i dijagnostiku, e-mobilnost i elektroniku , pa čak i rezervne delove za klasična vozila.</p>';
        return mahlePakovanjeVesti;
    };
    ClanakComponent.prototype.mahle_kompresori_vesti = function () {
        var mahleKompresoriVesti = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["Vest"]();
        mahleKompresoriVesti.id = 'mahle-kompresori';
        mahleKompresoriVesti.naslov = '<h1>Mahle kompresori klime</h1>';
        mahleKompresoriVesti.slika = 'assets/slike/novouponudi/velika/kompresori.png';
        mahleKompresoriVesti.tekst = '<p>Kompanija MAHLE ulazi na tržište kompresora klima uređaja. Sinonim kvaliteta i pouzdanosti kompanije MAHLE  ovi kompresori opravdavaju.</p> <p>Nivo klimatskog komfora definisan u današnjim vozilima je već na visokom nivou i nastaviće da raste u budućnosti. Međutim, klima uređaji imaju više uloga nego što je  udobna vožnja. Oni takođe igraju ključnu ulogu u pogledu bezbednosti. Pored održavanja vozača udobnim i opreznim, klima uređaj takođe odvlažuje vazduh u kabini i na taj način sprečava zamagljivanje prozora.</p> <p>U svom portfoliu MAHLE nudi veliki broj kompresora za veliki broj renomiranih proizvođača vozila, kao što su VW, AUDI, BMW, Mercedes, Opel...</p>';
        return mahleKompresoriVesti;
    };
    ClanakComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-clanak',
            template: __webpack_require__(/*! ./clanak.component.html */ "./src/app/e-commerce/dasboard/clanak/clanak.component.html"),
            styles: [__webpack_require__(/*! ./clanak.component.scss */ "./src/app/e-commerce/dasboard/clanak/clanak.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"]])
    ], ClanakComponent);
    return ClanakComponent;
}());



/***/ }),

/***/ "./src/app/e-commerce/dasboard/dasboard.component.html":
/*!*************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/dasboard.component.html ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\n  <section class=\"d-flex flex-xl-row-reverse flex-column centar skecija-mala\">\n    <div class=\"pomeri-levo\">\n      <i class=\"material-icons velicina-ikone\">\n        place\n      </i>\n      <p class=\"header\">Prvomajska 61, Šabac</p>\n    </div>\n    <div class=\"pomeri-levo\">\n      <i class=\"material-icons velicina-ikone\">\n        email\n      </i>\n      <p class=\"header\">office@automaterijal.com</p>\n    </div>\n    <div class=\"pomeri-levo\">\n      <i class=\"material-icons velicina-ikone\">\n        phone\n      </i>\n      <p class=\"header\"> <a class=\"header\" href=\"tel:015334630\">015/334-630</a></p>\n    </div>\n  </section>\n  <section>\n    <carousel>\n      <slide class=\"animated fadeIn\" *ngFor=\"let brand of mySlidePagePapers;let i = index\">\n        <img src=\"{{brand.urlSlikePozadina}}\" alt=\"first slide\" style=\"display: block; width: 100%;\">\n      </slide>\n    </carousel>\n  </section>\n  <section class=\"d-flex flex-xl-row flex-column centar pozadina-bela skecija-srednja\">\n    <div class=\"flex-fill mobilni\">\n      <p class=\"inline-content paragraph text-center\">Posetite našu online prodavnicu i webshop katalog</p>\n      <button color=\"primary\" class=\"inline-content inline-button\" (click)=\"goToShoping()\" mat-mini-fab>\n        <mat-icon aria-label=\"Example icon-button with a heart icon\">shopping_cart</mat-icon>\n      </button>\n    </div>\n    <div class=\"flex-fill\">\n      <p class=\"inline-content paragraph text-center\">Pošaljite nam upit za deo koji tražite</p>\n      <button color=\"primary\" (click)=\"otvoriUpitModal()\" class=\"inline-content inline-button\" mat-mini-fab>\n        <mat-icon aria-label=\"Example icon-button with a heart icon\">question_answer</mat-icon>\n      </button>\n    </div>\n  </section>\n  <section class=\"sekcija\">\n    <app-ponuda></app-ponuda>\n  </section>\n  <section class=\"pozadina-bela sekcija\">\n    <app-vesti></app-vesti>\n  </section>\n</main>"

/***/ }),

/***/ "./src/app/e-commerce/dasboard/dasboard.component.scss":
/*!*************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/dasboard.component.scss ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".animated {\n  -webkit-animation-duration: 1s;\n  animation-duration: 1s;\n  -webkit-animation-fill-mode: both;\n  animation-fill-mode: both; }\n\n@-webkit-keyframes fadeIn {\n  0% {\n    opacity: 0; }\n  100% {\n    opacity: 1; } }\n\n@Keyframes fadeIn {\n  0% {\n    opacity: 0; }\n  100% {\n    opacity: 1; } }\n\n.fadeIn {\n  -webkit-animation-name: fadeIn;\n  animation-name: fadeIn; }\n\nimg {\n  height: 100%;\n  vw: 100 !important; }\n\n.sekcija {\n  padding: 30px;\n  padding-bottom: 40px; }\n\n.skecija-mala {\n  padding: 10px; }\n\n.skecija-srednja {\n  padding: 20px; }\n\n.inline-content {\n  display: inline; }\n\n.paragraph {\n  font-size: 1.01em;\n  margin-right: 15px;\n  text-align: center; }\n\n.centar {\n  text-align: center; }\n\n.velicina-ikone {\n  font-size: 0.8em;\n  color: #345cac; }\n\n.header {\n  display: inline;\n  font-size: 0.9em;\n  margin-left: 5px;\n  color: black; }\n\n.pomeri-levo {\n  margin-right: 15px; }\n\n@media only screen and (max-width: 1025px) {\n  .paragraph {\n    font-size: 1em;\n    margin-right: 0px;\n    text-align: left; }\n  .inline-content {\n    display: block; }\n  .inline-button {\n    margin-left: 44%;\n    margin-bottom: 20px;\n    margin-top: 5px; }\n  .mobilni {\n    justify-content: center;\n    align-content: center;\n    text-align: center; } }\n\n@media only screen and (max-width: 670px) {\n  img {\n    height: 155px;\n    vw: 100 !important; } }\n"

/***/ }),

/***/ "./src/app/e-commerce/dasboard/dasboard.component.ts":
/*!***********************************************************!*\
  !*** ./src/app/e-commerce/dasboard/dasboard.component.ts ***!
  \***********************************************************/
/*! exports provided: DasboardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DasboardComponent", function() { return DasboardComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../model/dto */ "./src/app/e-commerce/model/dto.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var src_app_shared_modal_upit_modal_upit_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/shared/modal/upit-modal/upit-modal.component */ "./src/app/shared/modal/upit-modal/upit-modal.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var DasboardComponent = /** @class */ (function () {
    function DasboardComponent(router, dialog) {
        this.router = router;
        this.dialog = dialog;
        this.mySlidePagePapers = this.vratiSveSlajdove();
    }
    DasboardComponent.prototype.ngOnInit = function () { };
    DasboardComponent.prototype.goToShoping = function () {
        this.router.navigateByUrl('/roba');
    };
    DasboardComponent.prototype.vratiSveSlajdove = function () {
        var nizSlajdovi = [];
        var slide1 = this.slide1();
        var slide2 = this.slide2();
        var slide3 = this.slide3();
        nizSlajdovi.push(slide1, slide2, slide3);
        return nizSlajdovi;
    };
    DasboardComponent.prototype.slide1 = function () {
        var slide = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        slide.urlSlikePozadina = 'assets/slike/ui/slider/111.png';
        return slide;
    };
    DasboardComponent.prototype.slide2 = function () {
        var slide = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        slide.urlSlikePozadina = 'assets/slike/ui/slider/HEADER2.png';
        return slide;
    };
    DasboardComponent.prototype.slide3 = function () {
        var slide = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        slide.urlSlikePozadina = 'assets/slike/ui/slider/HEADER3.png';
        return slide;
    };
    DasboardComponent.prototype.otvoriUpitModal = function () {
        this.dialog.open(src_app_shared_modal_upit_modal_upit_modal_component__WEBPACK_IMPORTED_MODULE_4__["UpitModalComponent"], {
            width: '400px'
        });
    };
    DasboardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-dasboard',
            template: __webpack_require__(/*! ./dasboard.component.html */ "./src/app/e-commerce/dasboard/dasboard.component.html"),
            styles: [__webpack_require__(/*! ./dasboard.component.scss */ "./src/app/e-commerce/dasboard/dasboard.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"], _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatDialog"]])
    ], DasboardComponent);
    return DasboardComponent;
}());



/***/ }),

/***/ "./src/app/e-commerce/dasboard/dasboard.module.ts":
/*!********************************************************!*\
  !*** ./src/app/e-commerce/dasboard/dasboard.module.ts ***!
  \********************************************************/
/*! exports provided: DasboardModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DasboardModule", function() { return DasboardModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _dasboard_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./dasboard.component */ "./src/app/e-commerce/dasboard/dasboard.component.ts");
/* harmony import */ var _clanak_clanak_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./clanak/clanak.component */ "./src/app/e-commerce/dasboard/clanak/clanak.component.ts");
/* harmony import */ var _ponuda_ponuda_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./ponuda/ponuda.component */ "./src/app/e-commerce/dasboard/ponuda/ponuda.component.ts");
/* harmony import */ var _vesti_vesti_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./vesti/vesti.component */ "./src/app/e-commerce/dasboard/vesti/vesti.component.ts");
/* harmony import */ var ngx_bootstrap_carousel__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ngx-bootstrap/carousel */ "./node_modules/ngx-bootstrap/carousel/fesm5/ngx-bootstrap-carousel.js");
/* harmony import */ var ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ngx-owl-carousel */ "./node_modules/ngx-owl-carousel/index.js");
/* harmony import */ var ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/shared/material/material.module */ "./src/app/shared/material/material.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};









var routes = [
    {
        path: '',
        component: _dasboard_component__WEBPACK_IMPORTED_MODULE_2__["DasboardComponent"]
    },
    {
        path: ':id',
        component: _clanak_clanak_component__WEBPACK_IMPORTED_MODULE_3__["ClanakComponent"]
    },
];
var DasboardModule = /** @class */ (function () {
    function DasboardModule() {
    }
    DasboardModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                ngx_bootstrap_carousel__WEBPACK_IMPORTED_MODULE_6__["CarouselModule"],
                ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_7__["OwlModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_8__["MaterialModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)
            ],
            declarations: [_dasboard_component__WEBPACK_IMPORTED_MODULE_2__["DasboardComponent"], _clanak_clanak_component__WEBPACK_IMPORTED_MODULE_3__["ClanakComponent"], _ponuda_ponuda_component__WEBPACK_IMPORTED_MODULE_4__["PonudaComponent"], _vesti_vesti_component__WEBPACK_IMPORTED_MODULE_5__["VestiComponent"]],
            exports: [_dasboard_component__WEBPACK_IMPORTED_MODULE_2__["DasboardComponent"]]
        })
    ], DasboardModule);
    return DasboardModule;
}());



/***/ }),

/***/ "./src/app/e-commerce/dasboard/ponuda/ponuda.component.html":
/*!******************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/ponuda/ponuda.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h1>Izdvajamo iz ponude</h1>\n<div class=\"d-flex flex-lg-row flex-column justify-content-center\">\n  <div *ngFor=\"let vest of ponuda\">\n    <mat-card class=\"example-card\" fxLayout=\"row\" fxLayoutWrap>\n      <mat-card-header class=\"naslov\">\n        <mat-card-title>\n          <h2>{{vest.naslov}}</h2>\n        </mat-card-title>\n      </mat-card-header>\n      <img mat-card-image src=\"{{vest.opisSlika}}\" alt=\"Slika Ponude\">\n      <mat-card-content class=\"card-sadrzaj\">\n        <p class=\"opis-vesti\">\n          {{vest.opis}}\n        </p>\n      </mat-card-content>\n      <mat-card-actions class=\"d-flex justify-content-center\">\n        <button class=\"sirina button-glavni-100\" mat-raised-button (click)=\"detaljiVesti(vest.id)\">Pročitaj</button>\n      </mat-card-actions>\n    </mat-card>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/e-commerce/dasboard/ponuda/ponuda.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/ponuda/ponuda.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  font-size: 1.6em;\n  color: #345cac;\n  margin-bottom: 20px;\n  text-align: center; }\n\nh2 {\n  font-size: 1.3em;\n  font-weight: bold; }\n\n.naslov {\n  justify-content: center; }\n\n.example-card {\n  width: 80%;\n  margin-left: 5%; }\n\n.opis-vesti {\n  text-align: center;\n  font-size: 0.97em; }\n\n.sirina {\n  width: 200px; }\n\n.card-sadrzaj {\n  height: 40px; }\n\n@media only screen and (max-width: 1025px) {\n  .example-card {\n    width: 95%;\n    margin-left: 10px;\n    margin-top: 10px; }\n  h1 {\n    font-size: 1.5em; }\n  h2 {\n    font-size: 1.2em; } }\n"

/***/ }),

/***/ "./src/app/e-commerce/dasboard/ponuda/ponuda.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/ponuda/ponuda.component.ts ***!
  \****************************************************************/
/*! exports provided: PonudaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PonudaComponent", function() { return PonudaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../model/dto */ "./src/app/e-commerce/model/dto.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var PonudaComponent = /** @class */ (function () {
    function PonudaComponent(router) {
        this.router = router;
        this.ponuda = [];
    }
    PonudaComponent.prototype.ngOnInit = function () {
        this.vratiSvePonude();
    };
    PonudaComponent.prototype.detaljiVesti = function (id) {
        this.router.navigate(['/naslovna/' + id]);
    };
    PonudaComponent.prototype.vratiSvePonude = function () {
        var shell = this.shell();
        var febi = this.febi();
        var mahle = this.mahle();
        var ks = this.ks();
        this.ponuda.push(shell, febi, mahle, ks);
    };
    PonudaComponent.prototype.shell = function () {
        var shell = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["VestiNaslovna"]();
        shell.id = 'shell-u-ponudi';
        shell.naslov = 'Shell';
        shell.opis = 'Shell – globalni lider u proizvodnji ulja I maziva';
        shell.opisSlika = 'assets/slike/novouponudi/mala/shell.png';
        return shell;
    };
    PonudaComponent.prototype.febi = function () {
        var febi = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["VestiNaslovna"]();
        febi.id = 'febi-u-ponudi';
        febi.naslov = 'Febi';
        febi.opis = 'Više od 45000 proizvoda u službi održavanja vašeg vozila';
        febi.opisSlika = 'assets/slike/novouponudi/mala/febi.png';
        return febi;
    };
    PonudaComponent.prototype.mahle = function () {
        var mahle = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["VestiNaslovna"]();
        mahle.id = 'mahle-u-ponudi';
        mahle.naslov = 'Mahle';
        mahle.opis = 'Od 1920 u srži automobila';
        mahle.opisSlika = 'assets/slike/novouponudi/mala/mahle.png';
        return mahle;
    };
    PonudaComponent.prototype.ks = function () {
        var ks = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["VestiNaslovna"]();
        ks.id = 'ks-u-ponudi';
        ks.naslov = 'Kolbenschmidt';
        ks.opis = 'Godine poverenja su preporuka';
        ks.opisSlika = 'assets/slike/novouponudi/mala/ks.png';
        return ks;
    };
    PonudaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-ponuda',
            template: __webpack_require__(/*! ./ponuda.component.html */ "./src/app/e-commerce/dasboard/ponuda/ponuda.component.html"),
            styles: [__webpack_require__(/*! ./ponuda.component.scss */ "./src/app/e-commerce/dasboard/ponuda/ponuda.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], PonudaComponent);
    return PonudaComponent;
}());



/***/ }),

/***/ "./src/app/e-commerce/dasboard/vesti/vesti.component.html":
/*!****************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/vesti/vesti.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h1>Vesti</h1>\n<div class=\"d-flex flex-lg-row flex-column\">\n  <div class=\"d-flex flex-lg-row flex-column justify-content-center\" *ngFor=\"let vest of ponuda\">\n    <mat-card class=\"example-card\" fxLayout=\"row\" fxLayoutWrap>\n      <mat-card-header class=\"naslov\">\n        <mat-card-title>\n          <h2>{{vest.naslov}}</h2>\n        </mat-card-title>\n      </mat-card-header>\n      <img mat-card-image src=\"{{vest.opisSlika}}\" alt=\"Slika vesti\">\n      <mat-card-content class=\"card-sadrzaj\">\n        <p class=\"opis-vesti\">\n          {{vest.opis}}\n        </p>\n      </mat-card-content>\n      <mat-card-actions class=\"d-flex justify-content-center\">\n        <button class=\"sirina button-glavni-100\" mat-raised-button (click)=\"detaljiVesti(vest.id)\"\n          color=\"primary\">Pročitaj</button>\n      </mat-card-actions>\n    </mat-card>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/e-commerce/dasboard/vesti/vesti.component.scss":
/*!****************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/vesti/vesti.component.scss ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  font-size: 1.6em;\n  color: #345cac;\n  margin-bottom: 20px;\n  text-align: center; }\n\nh2 {\n  font-size: 1.3em;\n  font-weight: bold; }\n\n.naslov {\n  justify-content: center; }\n\n.example-card {\n  width: 80%;\n  margin-left: 5%; }\n\n.opis-vesti {\n  text-align: center;\n  font-size: 0.97em; }\n\n.sirina {\n  width: 200px; }\n\n.card-sadrzaj {\n  height: 40px; }\n\n@media only screen and (max-width: 1025px) {\n  .example-card {\n    width: 95%;\n    margin-left: 10px;\n    margin-top: 10px; }\n  h1 {\n    font-size: 1.5em; }\n  h2 {\n    font-size: 1.2em; } }\n"

/***/ }),

/***/ "./src/app/e-commerce/dasboard/vesti/vesti.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/vesti/vesti.component.ts ***!
  \**************************************************************/
/*! exports provided: VestiComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "VestiComponent", function() { return VestiComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../model/dto */ "./src/app/e-commerce/model/dto.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var VestiComponent = /** @class */ (function () {
    function VestiComponent(router) {
        this.router = router;
        this.ponuda = [];
    }
    VestiComponent.prototype.ngOnInit = function () {
        this.vratiSvePonude();
    };
    VestiComponent.prototype.detaljiVesti = function (id) {
        this.router.navigate(['/naslovna/' + id]);
    };
    VestiComponent.prototype.vratiSvePonude = function () {
        var mahlePakovanjeVest = this.vestNovoPakovanjeMahle();
        var mahleKompresori = this.vestMahleKompresori();
        this.ponuda.push(mahlePakovanjeVest, mahleKompresori);
    };
    VestiComponent.prototype.vestNovoPakovanjeMahle = function () {
        var vest = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["VestiNaslovna"]();
        vest.id = 'mahle-pakovanje';
        vest.naslov = 'Novo Pakovanje Mahle';
        vest.opis = 'Novi dizajn ambalaže za MAHLE Aftermarket proizvode od 2019. godine';
        vest.opisSlika = 'assets/slike/novouponudi/mala/mahle-pakovanje.png';
        return vest;
    };
    VestiComponent.prototype.vestMahleKompresori = function () {
        var vest = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["VestiNaslovna"]();
        vest.id = 'mahle-kompresori';
        vest.naslov = 'Mahle kompresori klime';
        vest.opis = 'Novo u asortimanu - kompresori klime Mahle';
        vest.opisSlika = 'assets/slike/novouponudi/mala/kompresori.png';
        return vest;
    };
    VestiComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-vesti',
            template: __webpack_require__(/*! ./vesti.component.html */ "./src/app/e-commerce/dasboard/vesti/vesti.component.html"),
            styles: [__webpack_require__(/*! ./vesti.component.scss */ "./src/app/e-commerce/dasboard/vesti/vesti.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]])
    ], VestiComponent);
    return VestiComponent;
}());



/***/ })

}]);
//# sourceMappingURL=e-commerce-dasboard-dasboard-module.js.map