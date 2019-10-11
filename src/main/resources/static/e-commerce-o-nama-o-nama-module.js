(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-commerce-o-nama-o-nama-module"],{

/***/ "./src/app/e-commerce/o-nama/o-nama.component.html":
/*!*********************************************************!*\
  !*** ./src/app/e-commerce/o-nama/o-nama.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n  <div class=\"headerONama\">\r\n    <h1>O nama</h1>\r\n  </div>\r\n  <div class=\"d-flex flex-column flex-lg-row pozadina-bela\">\r\n    <div class=\"parcele-slika pozadina-istorija\">\r\n    </div>\r\n    <div class=\"parcele\">\r\n      <p>\r\n        <b>AUTOMATERIJAL d.o.o. </b> Šabac je osnovano 1990. godine i, sada već preko 29 godina, bavi se snabdevanjem\r\n        našeg tržišta kvalitetnim delovima, mazivima materijalom za održavanje motornih vozila.\r\n      </p>\r\n      <p class=\"drugi-stih\">Poslujemo kao maloprodaja i veleprodaja. Kao veleprodaja razvili smo svoju prodajnu mrežu na\r\n        regionu Zapadne Srbije (mačvanski, sremski, kolubarski i zlatiborski okrug). Naši partneri u ovom poslu su\r\n        fizička lica, ovlašćeni i nezavisni serviseri, vlasnici voznih parkova, proizvođačka industrijska preduzeća,\r\n        veleprodaje i maloprodaje delova i materijala za popravku motornih vozila.\r\n      </p>\r\n    </div>\r\n  </div>\r\n  <div class=\"d-flex flex-column-reverse flex-lg-row\">\r\n    <div class=\"parcele parcela-najveca\">\r\n      <p>\r\n        Mi zadovoljavamo potrebe naših partnera koje se najvećim delom odnose na delove i materijal za održavanje i\r\n        popravku motora i stajnog trapa, prvenstveno putničkih motornih vozila proizvedenih u Nemačkoj a sve više smo\r\n        snabdeveni i odgovarajućim artiklima za vozila proizvedena u drugim evropskim zemljama, npr.: Škoda, Fiat,\r\n        Renault, Peugeot, Citroen, Alfa Romeo, Saab, Volvo itd., kao i za vozila proizvedena u Japanu, Koreji i širom\r\n        sveta: Toyota, Honda, Mazda, Nissan, Mitsubishi, Suzuki, Kia, Hyundai, Chevrolet - Daewoo, Chrysler, Rover,\r\n        Daihatsu, Subaru, itd.\r\n      </p>\r\n      <p class=\"drugi-stih\">Uz našu robu uvek plasiramo i dodatnu uslugu, prvenstveno se to odnosi na svaku vrstu pomoći\r\n        u pronalaženju odgovarajućeg artikla i pored svog angažmana u tu svrhu obezbeđujemo odgovarajuću dokumentaciju i\r\n        kataloge za servisere i trgovce. Zatim, organizujemo i realizujemo razne vrste obuka za servisere i trgovce, u\r\n        saradnji sa proizvođačima – uvoznicima učestvujemo u ugovornom opremanju poslovnog – radnog prostora naših\r\n        partnera, istrajavamo u potpunom realizovanju svih ugovorenih garancija i drugo.\r\n      </p>\r\n    </div>\r\n    <div class=\"parcele-slika pozadina-usluga\">\r\n    </div>\r\n  </div>\r\n  <div class=\"d-flex flex-column flex-lg-row poslednja-parcela pozadina-bela\">\r\n    <div class=\"parcele-slika pozadina-proizvodi\">\r\n    </div>\r\n    <div class=\"parcele\">\r\n      <p>\r\n        Za neke brendove smo se zaštitili kao ovlašćeni uvoznici i distributeri za definisanu teritoriju, a sa nekim\r\n        konkurentima i sarađujemo, tako da smo vremenom izgradili poziciju nezaobilaznog faktora na svom terenu u\r\n        oblasti kojom se bavimo. AUTOMATERIJAL d.o.o. je direktni uvoznik, iz Nemačke, od proizvođača \"Kolbenschmidt\",\r\n        \"Pierburg\", i \"Victor Reinz\", iz Italije \"DeDaX\", zastupnik koncerna \"Bilstein\" i \"Febi\", uključujući i brend\r\n        \"Blue Print\", regionalni zastupnik - ovlašćeni distributer „Magneti Marelli“, regionalni zastupnik - ovlašćeni\r\n        distributer „Shell“, „Castrol“ „TOTAL“, „Fuchs“, „LukOil“ i „ENEOS“ maziva, ovlašćeni distributer i serviser\r\n        „energizer“ akumulatora, regionalni zastupnik - originalih BMW rezervnih delova. U našoj prodaji se nalaze\r\n        proizvodi raznih renomiranih proizvodjača rezervnih delova i opreme.</p>\r\n    </div>\r\n  </div>\r\n  <div class=\"pozadina-bela\">\r\n    <div class=\"d-flex justify-content-center logoi\">\r\n      <div *ngIf=\"isLargeDiv\" class=\"owl-carousel-moj\">\r\n        <owl-carousel [options]=\"mySlideLargeOptions\" [carouselClasses]=\"['owl-theme']\">\r\n          <div class=\"item\" *ngFor=\"let brand of mySlideBrands;let i = index\">\r\n            <div>\r\n              <button mat-button class=\"dugme\" (click)=\"otvoriDialog(brand)\">\r\n                <img width=\"65px\" height=\"65px\" src={{brand.urlSlikeLogo}} />\r\n              </button>\r\n            </div>\r\n          </div>\r\n        </owl-carousel>\r\n      </div>\r\n      <div *ngIf=\"!isLargeDiv\" class=\"owl-carousel-moj\">\r\n        <owl-carousel [options]=\"mySlideSmallOptions\" [carouselClasses]=\"['owl-theme']\">\r\n          <div class=\"item\" *ngFor=\"let brand of mySlideBrands;let i = index\">\r\n            <div>\r\n              <button mat-button class=\"dugme\" (click)=\"otvoriDialog(brand)\">\r\n                <img width=\"65px\" height=\"65px\" src={{brand.urlSlikeLogo}} />\r\n              </button>\r\n            </div>\r\n          </div>\r\n        </owl-carousel>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</main>"

/***/ }),

/***/ "./src/app/e-commerce/o-nama/o-nama.component.scss":
/*!*********************************************************!*\
  !*** ./src/app/e-commerce/o-nama/o-nama.component.scss ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  text-align: center;\n  padding-top: 1em;\n  padding-bottom: 1em; }\n\nh2 {\n  color: #345cac; }\n\np {\n  text-align: justify; }\n\n.headerONama {\n  background-image: url(\"/assets/slike/ui/pozadine/onama.png\");\n  background-position: center;\n  background-repeat: no-repeat;\n  background-size: 100% 102px; }\n\n.parcele {\n  width: 50%;\n  padding: 3%; }\n\n.parcele-slika {\n  width: 50%;\n  padding: 3%; }\n\n.pozadina-istorija {\n  background-image: url(\"/assets/slike/ui/pozadine/istorija.png\");\n  background-position: center;\n  background-repeat: no-repeat;\n  background-size: contain; }\n\n.pozadina-usluga {\n  background-image: url(\"/assets/slike/ui/pozadine/usluga.png\");\n  background-position: center;\n  background-repeat: no-repeat;\n  background-size: contain; }\n\n.pozadina-proizvodi {\n  background-image: url(\"/assets/slike/ui/pozadine/proizvodi.png\");\n  background-position: center;\n  background-repeat: no-repeat;\n  background-size: contain; }\n\n.parcela-ikona {\n  text-align: center;\n  position: relative;\n  bottom: -30%; }\n\n.drugi-stih {\n  margin-top: 1rem; }\n\n.ikona {\n  font-size: 3rem;\n  color: #345cac;\n  text-align: center; }\n\n.dobavljaci-logo {\n  width: 65px;\n  height: 65px; }\n\n.logoi {\n  width: 80%;\n  margin-left: 10%; }\n\n.owl-carousel-moj {\n  width: 600px !important; }\n\n.dugme {\n  padding: 0px;\n  height: 66px;\n  width: 66px; }\n\n@media only screen and (max-width: 1025px) {\n  .parcela-najveca {\n    height: 700px !important; }\n  .parcele {\n    width: 100%;\n    padding: 3%; }\n  .parcele-slika {\n    width: 100%;\n    height: 250px;\n    padding: 3%; }\n  .logoi {\n    width: 100%;\n    margin-left: 0%; }\n  .owl-carousel-moj {\n    width: 600px !important; } }\n\n@media only screen and (max-device-width: 1025px) {\n  .parcela-najveca {\n    height: 700px !important; }\n  .parcele {\n    width: 100%;\n    padding: 3%; }\n  .parcele-slika {\n    width: 100%;\n    height: 250px;\n    padding: 3%; }\n  .logoi {\n    width: 100%;\n    margin-left: 0%; }\n  .owl-carousel-moj {\n    margin-left: 20px;\n    width: 600px !important; } }\n\n@media only screen and (max-width: 991px) {\n  .parcela-najveca {\n    height: 450px !important; }\n  .owl-carousel-moj {\n    width: 600px !important; }\n  .parcele {\n    width: 100%;\n    padding: 3%;\n    height: 350px; }\n  .parcele-slike {\n    width: 100%;\n    padding: 3%;\n    height: 250px; }\n  .poslednja-parcela {\n    height: 700px;\n    padding-bottom: 100px; } }\n\n@media only screen and (max-width: 750px) {\n  .poslednja-parcela {\n    height: 700px;\n    padding-bottom: 100px; }\n  .parcele {\n    width: 100%;\n    padding: 3%;\n    height: 350px; }\n  .parcele-slika {\n    width: 100%;\n    padding: 3%;\n    height: 250px; }\n  .owl-carousel-moj {\n    margin-top: 100px;\n    width: 360px !important; }\n  .pozadina-proizvodi {\n    margin-top: 0px; }\n  .parcela-najveca {\n    height: 700px !important; } }\n\n@media only screen and (max-width: 500px) {\n  .poslednja-parcela {\n    height: 800px;\n    padding-bottom: 0px; }\n  .parcele {\n    width: 100%;\n    padding: 3%;\n    height: 450px; }\n  .parcele-slika {\n    width: 100%;\n    padding: 3%;\n    height: 250px; }\n  .owl-carousel-moj {\n    width: 360px !important;\n    margin-left: 10px;\n    height: 100%; }\n  .pozadina-proizvodi {\n    margin-top: 0px; }\n  .parcela-najveca {\n    height: 800px !important; } }\n"

/***/ }),

/***/ "./src/app/e-commerce/o-nama/o-nama.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/e-commerce/o-nama/o-nama.component.ts ***!
  \*******************************************************/
/*! exports provided: ONamaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ONamaComponent", function() { return ONamaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../model/dto */ "./src/app/e-commerce/model/dto.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var src_app_shared_modal_brendovi_modal_brendovi_modal_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/modal/brendovi-modal/brendovi-modal.component */ "./src/app/shared/modal/brendovi-modal/brendovi-modal.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ONamaComponent = /** @class */ (function () {
    function ONamaComponent(dialog) {
        this.dialog = dialog;
        this.mySlideBrands = this.vratiSveBrendove();
        this.mySlideLargeOptions = {
            items: 7, margin: 20,
            dots: true, nav: false, autoplay: true,
            autoplayTimeout: 2500, rewind: true
        };
        this.mySlideSmallOptions = {
            items: 3, margin: 5,
            dots: true, nav: false, autoplay: true,
            autoplayTimeout: 2500, rewind: true
        };
        this.isLargeDiv = window.innerWidth > 750;
    }
    ONamaComponent.prototype.ngOnInit = function () {
        this.innerWidth = window.innerWidth;
        this.changeSlideConfiguration();
    };
    ONamaComponent.prototype.onResize = function (event) {
        this.innerWidth = window.innerWidth;
        this.changeSlideConfiguration();
    };
    ONamaComponent.prototype.changeSlideConfiguration = function () {
        if (this.innerWidth < 750) {
            this.isLargeDiv = false;
        }
        else {
            this.isLargeDiv = true;
        }
    };
    ONamaComponent.prototype.otvoriDialog = function (brend) {
        this.dialog.open(src_app_shared_modal_brendovi_modal_brendovi_modal_component__WEBPACK_IMPORTED_MODULE_3__["BrendoviModalComponent"], {
            width: '700px',
            data: brend
        });
    };
    ONamaComponent.prototype.vratiSveBrendove = function () {
        var nizOdBrendova = [];
        var febi = this.febi();
        var shell = this.shell();
        var mahle = this.mahle();
        var kolbenschmidt = this.kolbenschmidt();
        var pierburg = this.pierburg();
        var victorReinz = this.victorReinz();
        var bluePrint = this.bluePrint();
        var mm = this.mm();
        nizOdBrendova.push(febi, shell, mahle, victorReinz, kolbenschmidt, pierburg, mm, bluePrint);
        return nizOdBrendova;
    };
    ONamaComponent.prototype.febi = function () {
        var febi = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        febi.ime = 'Febi';
        febi.urlSlikeLogo = 'assets/slike/brendovi/logo/febi.png';
        febi.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/febi.png';
        febi.opis = '<p>Febi bilstein je  osnovan davne 1844 godine. Danas je jedan od vodećih svetskih proizvođača i dobavljača rezervnih delova za putnička i komercijalna vozila na nezavisnom tržištu rezervnih delova.  Više od 170 godina održava kontinuitet, kvalitet, uslugu, pouzdanost i inovacije. Asortiman cini 30.000 razlicitih rezervnih delova. Osim toga, febi ima svoja predstavništva ili iskusnog partnera u preko 69 zemalja. </p> <p>Od upravljačke, motorne i kočne tehnike, tehnike šasija i učvršćivanja točkova do autoelektrike i pneumatike i programa febi plus – kod firme febi bilstein ćete naći sve za profesionalno servisiranje - putničkih vozila, kamiona, autobusa, prikolica, poluprikolica i malih transportera svih aktuelnih marki i modela.</p> <p class="proba">Febi bilstein stoji za proizvode koji ispunjavaju najviše zahteve kvaliteta izrade i bezbednosti ugradnje. Kvalitetom, brzinom i postavljanjem trendova febi bilstein vam daje odlučujući podsticaj na globalnom tržištu. Zato što kao premium marka ima obavezu da ispuni zahteve svojih kupaca – svakodnevno.</p> <p>AUTOMATERIJAL d.o.o - je zastupnik koncerna Febi Bilstein i Blue Printa za zapadnu Srbiju.</p>';
        return febi;
    };
    ONamaComponent.prototype.shell = function () {
        var shell = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        shell.ime = 'Shell';
        shell.urlSlikeLogo = 'assets/slike/brendovi/logo/shell.png';
        shell.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/shell.png';
        shell.opis = '<p> Kompanije Shell ima iza sebe 70 godina u inovacijama i stoga je broj jedan dobavljač lubrikanata. Poznata činjenica je da neki od  svetskih proizvođaća automobila preferiraju Shell motorno ulje prvo punjenje novih vozila koja izlaze iz fabike. Kompletan asortiman uključujući sintetičke proizvode visokih performansi može da zadovolji sve poterbe i aplikacije koje vam trebaju.</p><p>AUTOMATERIJAL d.o.o je ovlašceni distributer Shell ulja. </p>';
        return shell;
    };
    ONamaComponent.prototype.victorReinz = function () {
        var vr = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        vr.ime = 'Victor Reinz';
        vr.urlSlikeLogo = 'assets/slike/brendovi/logo/vik.png';
        vr.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/victor-reinz.png';
        vr.opis = '<p> Victor Reinz je Nemačka kompanija koja donosi inovativne tehnologije zaptivanja vrhunskog kvaliteta. Više od 80 godina brend Victor Reinz je sinonim za vrhunske zaptivače i semeringe. Svi rezervni delovi u asortimanu ispunjavaju visoke standarde kvaliteta OEM. Poslednjih godina na tržištu su zauzeli vodeću poziciju, kao proizvođači dihtunga glave, garniture dihtunga i semeringa.</p><p > Skoro sve poznate marke i modeli proizvođača automobila širom sveta su opremljeni sa profesionalnim zaptivnim rešenjima iz Victor Reinza u oblasti motora i izduvnih grasova.</p>';
        return vr;
    };
    ONamaComponent.prototype.mahle = function () {
        var mahle = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        mahle.ime = 'Mahle';
        mahle.urlSlikeLogo = 'assets/slike/brendovi/logo/mahle.png';
        mahle.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/mahle.png';
        mahle.opis = '<p>Marka MAHLE označava rezervne delove u kvalitetu originalne opreme duž celog pogonskog sklopa - od komponenti motora, filtracije i perifernih uređaja motora do upravljanja toplotom i mehatronike. Takođe predstavlja visokokvalitetnu specijalnu opremu za održavanje i servis. </p> <p>Marka je podržana od strane MAHLE-a, vodećeg svetskog dobavljača automobilske opreme, koji snabdeva tržište automobilske opreme visokokvalitetnim proizvodima zahvaljujući OE kompetenciji, vodeći istraživački i razvojni rad, kao i svoju međunarodnu logističku mrežu. </p>';
        return mahle;
    };
    ONamaComponent.prototype.kolbenschmidt = function () {
        var kolbenschmidt = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        kolbenschmidt.ime = 'Kolbenschmidt';
        kolbenschmidt.urlSlikeLogo = 'assets/slike/brendovi/logo/ks.png';
        kolbenschmidt.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/ks.png';
        kolbenschmidt.opis = '<p> Kolbenschmidt razvija i proizvodi klipove za benzin i dizel motore za putnicka i teretna vozila. Jedan je od najistaknutijih igraca u ovom segmentu. Ostali proizvodi uključuju ventile, vođice ventila, karike, ležajeve radilica, bregaste osovine.. </p> <p class="probam">Smanjenje potrošnje goriva i emisija izduvnih gasova su godinama glavni pokretač razvoja  novih vrsta klipova.</p> <p class="proba"> Već godinama, mnogi važni dileri originalnih delova su redovne mušterije Kolbenschmidt-a. Glavna tržišta su Evropa, Serverna i Južna Amerika, i Azija.';
        return kolbenschmidt;
    };
    ONamaComponent.prototype.pierburg = function () {
        var pierburg = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        pierburg.ime = 'Pierburg';
        pierburg.urlSlikeLogo = 'assets/slike/brendovi/logo/pirb.png';
        pierburg.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/pb.png';
        pierburg.opis = '<p>Pierburg, kao dobavljač prve klase, tradicionalno je jedan od najbližih partnera u autobomilskoj industriji. Osnovan je 1909. godine, kao trgovina čelika u Berlinu. 1928. godine počinje sa proizvodnjom karburatora i uskoro postaje jedini snabdevač svih nemačkih automobila i mnogih svetskih proizvođača motornih vozila i proizvođača motora. Pierburg razvija inovativne komponente i sistemska rešenja sa priznatim nadležnostima u oblasti dovoda vazduha i kontrole emisija. Svi ovi proizvodi, pumpe goriva, egr ventil, nepovratni ventil, protokomeri o vakuum pumpe, odgovaraju visokim zahtevima tržišta i standardima kvaliteta.</p> <p> Kako u prošlosti tako i sad, Pierburg aktivno oblikuje budućnost automobila.</p>';
        return pierburg;
    };
    ONamaComponent.prototype.mm = function () {
        var mm = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        mm.ime = 'Magenti Marreli';
        mm.urlSlikeLogo = 'assets/slike/brendovi/logo/mm.png';
        mm.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/magneti-marelli.png';
        mm.opis = '<p>Magneti Mareilli je međunarodna grupa posvećena projektovanju i proizvodnji sistema visoke tehnologije i komponenti za automobilsku indrustriju. Osnovana je 1919. godine, sa kapitalom potpisana na dva jednaka dela između Fiat-a i kompanije Ercole Marelli. Sa 38.000 zaposlenih, 89 proizvodnih pogona, prisutni su u 19 zemalja i snabdevaju sve najvažnije proizvođače u Evropi, Severnoj i Južnoj Americi i Aziji. Cilj Magenti Marelli-ja je da bude na raspolaganju kupcima po pristupačnoj ceni, spajanjem visokog kvaliteta i visoke tehnologije.</p> <p> Magneti Marelli je prvi stvorio ksenonsko svetlo 1991. godine, dajući novu dimenziju frontalnoj rasvetli. Od 2010. godine, postaje dobavljač Mercedes-Benz za sve LED farove sa prilagodljivom funkcijom za svetlo.</p> <p>2010. godine Ministartsvo za kulturnu baštinu i aktivnost Italije nagrađuje Magneti Marelli sa "Deklaracija o istorijskom značaju".</p>';
        return mm;
    };
    ONamaComponent.prototype.bluePrint = function () {
        var bp = new _model_dto__WEBPACK_IMPORTED_MODULE_1__["Brend"]();
        bp.ime = 'Blue Print';
        bp.urlSlikeLogo = 'assets/slike/brendovi/logo/bp.png';
        bp.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/blueprint.png';
        bp.opis = '<p>Blue Print je pravi izbor za kvalitetne rezervne delove za azijske, američke, britanske automobile i laka komercijalna vozila. Blue Print pruža aftermarket visoko preciznim komponentama kao i tehničkim i informacijskim rešenjima za više od 160 različitih tipova proizvoda.</p> <p>Širok asortiman od više od 23.000 artikala dostupnih u preko 160 vrsta proizvoda pod jednom robnom markom, uključujući i OE proizvode svrstava Blue Print kao jednog od brendova sa najvećom ponudom na tržištu.</p>';
        return bp;
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["HostListener"])('window:resize', ['$event']),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", [Object]),
        __metadata("design:returntype", void 0)
    ], ONamaComponent.prototype, "onResize", null);
    ONamaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-o-nama',
            template: __webpack_require__(/*! ./o-nama.component.html */ "./src/app/e-commerce/o-nama/o-nama.component.html"),
            styles: [__webpack_require__(/*! ./o-nama.component.scss */ "./src/app/e-commerce/o-nama/o-nama.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialog"]])
    ], ONamaComponent);
    return ONamaComponent;
}());



/***/ }),

/***/ "./src/app/e-commerce/o-nama/o-nama.module.ts":
/*!****************************************************!*\
  !*** ./src/app/e-commerce/o-nama/o-nama.module.ts ***!
  \****************************************************/
/*! exports provided: ONamaModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ONamaModule", function() { return ONamaModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _o_nama_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./o-nama.component */ "./src/app/e-commerce/o-nama/o-nama.component.ts");
/* harmony import */ var ngx_bootstrap_carousel__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-bootstrap/carousel */ "./node_modules/ngx-bootstrap/carousel/fesm5/ngx-bootstrap-carousel.js");
/* harmony import */ var ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ngx-owl-carousel */ "./node_modules/ngx-owl-carousel/index.js");
/* harmony import */ var ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_5__);
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};






var routes = [
    {
        path: '',
        component: _o_nama_component__WEBPACK_IMPORTED_MODULE_3__["ONamaComponent"]
    }
];
var ONamaModule = /** @class */ (function () {
    function ONamaModule() {
    }
    ONamaModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                ngx_bootstrap_carousel__WEBPACK_IMPORTED_MODULE_4__["CarouselModule"],
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_5__["OwlModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)
            ],
            declarations: [_o_nama_component__WEBPACK_IMPORTED_MODULE_3__["ONamaComponent"]],
            exports: [_o_nama_component__WEBPACK_IMPORTED_MODULE_3__["ONamaComponent"]]
        })
    ], ONamaModule);
    return ONamaModule;
}());



/***/ })

}]);
//# sourceMappingURL=e-commerce-o-nama-o-nama-module.js.map