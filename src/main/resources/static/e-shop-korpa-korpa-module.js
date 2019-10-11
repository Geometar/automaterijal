(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-shop-korpa-korpa-module"],{

/***/ "./src/app/e-shop/korpa/korpa.component.html":
/*!***************************************************!*\
  !*** ./src/app/e-shop/korpa/korpa.component.html ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!dataSource || dataSource.length == 0\">\r\n        <i class=\"material-icons icon-size\">\r\n            shopping_cart\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Korpa je trenutno prazna</h1>\r\n    </div>\r\n    <div class=\"tabela-div\" *ngIf=\"dataSource && dataSource.length > 0\">\r\n        <div class=\"headerKorpa\">\r\n        </div>\r\n        <div class=\"margin-bottom--10\">\r\n            <p class=\"pdv\"><i>Sve cene su prikazane sa pdv-om.</i></p>\r\n            <table mat-table [dataSource]=\"dataSource\" class=\"mat-elevation-z8\">\r\n                <!-- Kataloski broj Column -->\r\n                <ng-container matColumnDef=\"katbr\">\r\n                    <th mat-header-cell *matHeaderCellDef> Kataloški broj </th>\r\n                    <td mat-cell data-label=\"Kataloški broj\" *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.katbr}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Kataloski broj proizvodjaca Column -->\r\n                <ng-container matColumnDef=\"katbrpro\">\r\n                    <th mat-header-cell *matHeaderCellDef> Kataloški broj proizvodjača </th>\r\n                    <td mat-cell data-label=\"Kataloški broj proizvodjača\" *matCellDef=\"let roba\">\r\n                        <p>\r\n                            {{roba.katbrpro}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Naziv Column -->\r\n                <ng-container matColumnDef=\"naziv\">\r\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                    <td mat-cell data-label=\"Naziv\" *matCellDef=\"let roba\">\r\n                        <p>\r\n                            {{roba.naziv}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Proizvodjač Column -->\r\n                <ng-container matColumnDef=\"proizvodjac\">\r\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjač </th>\r\n                    <td mat-cell data-label=\"Proizvodjač\" *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.proizvodjac.naziv}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Cena Column -->\r\n                <ng-container matColumnDef=\"kolicina\">\r\n                    <th mat-header-cell *matHeaderCellDef> Količina </th>\r\n                    <td mat-cell data-label=\"Količina\" *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.kolicina}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Cena Column -->\r\n                <ng-container matColumnDef=\"cena\">\r\n                    <th mat-header-cell *matHeaderCellDef> Ukupno </th>\r\n                    <td mat-cell data-label=\"Ukupno\" *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.cenaUkupno | currency:\" \"}} DIN\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Kolicina Column -->\r\n                <ng-container matColumnDef=\"izbaciDugme\">\r\n                    <th mat-header-cell *matHeaderCellDef> </th>\r\n                    <td mat-cell *matCellDef=\"let roba; let i = index;\">\r\n                        <div class=\"d-flex flex-row justify-content-center button-align bd-highlight\">\r\n                            <div class=\"p-1 bd-highlight levo-dugme\">\r\n                                <button class=\"button-glavni-100 velicina-dugmeta\" mat-raised-button\r\n                                    (click)=\"otvoriDialog(roba)\">Izmeni</button>\r\n                            </div>\r\n                            <div class=\"p-1 bd-highlight desno-dugme\">\r\n                                <button class=\"button-crveni-50 velicina-dugmeta\" mat-raised-button\r\n                                    (click)='izbaciIzKorpe(i)'>Izbaci</button>\r\n                            </div>\r\n                        </div>\r\n\r\n                </ng-container>\r\n\r\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n            </table>\r\n        </div>\r\n        <div class=\"d-flex flex-column flex-xl-row\">\r\n            <div class=\"d-flex flex-column flex-xl-row flex-fill \">\r\n                <div class=\"flex-fill\">\r\n                    <div class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                        <div *ngIf=\"nacinPlacanja && nacinPlacanja.length > 0\" class=\"granice\">\r\n                            <h3>Način plaćanja</h3>\r\n                            <hr>\r\n                            <mat-radio-group class=\"radio-grupa\" [(ngModel)]=\"izabranNacinPlacanja\">\r\n                                <mat-radio-button color=\"primary\" class=\"radio-dugme\"\r\n                                    *ngFor=\"let placanje of nacinPlacanja\" [value]=\"placanje\">\r\n                                    {{placanje.naziv}}\r\n                                </mat-radio-button>\r\n                            </mat-radio-group>\r\n                        </div>\r\n                    </div>\r\n                    <div *ngIf=\"nacinPrevoza && nacinPrevoza.length > 0\"\r\n                        class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                        <div class=\"granice visina-prevoza\">\r\n                            <h3>Način prevoza</h3>\r\n                            <hr>\r\n                            <mat-radio-group class=\"radio-grupa\" [(ngModel)]=\"izabranNacinPrevoza\">\r\n                                <mat-radio-button color=\"primary\" class=\"radio-dugme\"\r\n                                    *ngFor=\"let prevoz of nacinPrevoza\" [value]=\"prevoz\">\r\n                                    {{\"prevoz_\" + prevoz.id | translate}}\r\n                                </mat-radio-button>\r\n                            </mat-radio-group>\r\n                        </div>\r\n                        <div *ngIf=\"izabranNacinPrevoza.id === 2\" class=\"granice pomeri-dole\">\r\n                            <h4>Izaberite način dostave</h4>\r\n                            <mat-radio-group class=\"radio-grupa\" [(ngModel)]=\"izabranaTrecaLiceOpcija\">\r\n                                <mat-radio-button color=\"primary\" class=\"radio-dugme\"\r\n                                    *ngFor=\"let opcije of treceLiceOpcije\" [value]=\"opcije\">\r\n                                    {{opcije}}\r\n                                </mat-radio-button>\r\n                            </mat-radio-group>\r\n                            <div>\r\n                                <div *ngIf=\"izabranaTrecaLiceOpcija === treceLiceOpcije[0]\">\r\n                                    <mat-form-field>\r\n                                        <mat-select placeholder=\"Kurirske sluzbe\" [(ngModel)]=\"izabraneKurirskeSluzbe\">\r\n                                            <mat-option *ngFor=\"let sluzbe of kurirskeSluzbe\" [value]=\"sluzbe\">\r\n                                                {{sluzbe}}\r\n                                            </mat-option>\r\n                                        </mat-select>\r\n                                    </mat-form-field>\r\n                                </div>\r\n                                <div *ngIf=\"izabranaTrecaLiceOpcija === treceLiceOpcije[1]\">\r\n                                    <mat-form-field role=\"form\" [formGroup]=\"drugiNacinPrevoza\">\r\n                                        <textarea matInput #prevoz formControlName=\"prevoz\"\r\n                                            placeholder=\"Upišite drugi način prevoza...\"></textarea>\r\n                                    </mat-form-field>\r\n                                    <div *ngIf=\"dugmeZaPorucivanjeStisnuto && d.prevoz.errors\">\r\n                                        <div *ngIf=\"d.prevoz.errors.required\">\r\n                                            <p class=\"upozorenje\">Ovo polje je obavezno</p>\r\n                                        </div>\r\n                                        <div *ngIf=\"d.prevoz.errors.minlength\">\r\n                                            <p class=\"upozorenje\">Minimalno 3 karaktera</p>\r\n                                        </div>\r\n                                    </div>\r\n                                </div>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n                <div class=\"flex-fill\">\r\n                    <div class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                        <div *ngIf=\"nacinPlacanja && nacinPlacanja.length > 0\" class=\"granice visina\">\r\n                            <h3>Napomena</h3>\r\n                            <hr>\r\n                            <mat-form-field class=\"sirina-cena\">\r\n                                <textarea matInput class=\"napomena\" [(ngModel)]=\"napomena\"\r\n                                    placeholder=\"Unesite napomenu...\"></textarea>\r\n                            </mat-form-field>\r\n                        </div>\r\n                    </div>\r\n                    <div class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                        <div *ngIf=\"nacinPlacanja && nacinPlacanja.length > 0\" class=\"granice\">\r\n                            <h3>Izaberite adresu dostave</h3>\r\n                            <hr>\r\n                            <mat-radio-group class=\"radio-grupa\" [(ngModel)]=\"izabraneAdresaDostave\">\r\n                                <mat-radio-button color=\"primary\" class=\"radio-dugme\"\r\n                                    *ngFor=\"let adresa of adresaDostave\" [value]=\"adresa\">\r\n                                    {{adresa}}\r\n                                </mat-radio-button>\r\n                            </mat-radio-group>\r\n                        </div>\r\n                        <div class=\"granice pomeri-dole\">\r\n                            <div *ngIf=\"izabraneAdresaDostave === adresaDostave[0]\" class=\"pomeri-dole\">\r\n                                <h4>Adresa</h4>\r\n                                <label> {{partner.adresa}}</label>\r\n                            </div>\r\n                            <div *ngIf=\"izabraneAdresaDostave === adresaDostave[1]\" class=\"pomeri-dole\">\r\n                                <h4>Druga adresa dostave</h4>\r\n                                <form role=\"form\" [formGroup]=\"adresaForm\">\r\n                                    <div>\r\n                                        <mat-form-field role=\"form\">\r\n                                            <input type=\"text\" #ulica formControlName=\"ulica\" matInput\r\n                                                placeholder=\"Ulica i broj\">\r\n                                        </mat-form-field>\r\n                                    </div>\r\n                                    <div *ngIf=\"dugmeZaPorucivanjeStisnuto && a.ulica.errors\">\r\n                                        <div *ngIf=\"a.ulica.errors.required\">\r\n                                            <p class=\"upozorenje\">Naziv ulice je obavezan</p>\r\n                                        </div>\r\n                                        <div *ngIf=\"a.ulica.errors.minlength\">\r\n                                            <p class=\"upozorenje\">Naziv ulice mora imati minimalno 3 karaktera</p>\r\n                                        </div>\r\n                                    </div>\r\n                                    <div>\r\n                                        <mat-form-field role=\"form\">\r\n                                            <input type=\"text\" #grad formControlName=\"grad\" matInput placeholder=\"Grad\">\r\n                                        </mat-form-field>\r\n                                    </div>\r\n                                    <div *ngIf=\"dugmeZaPorucivanjeStisnuto && a.grad.errors\">\r\n                                        <div *ngIf=\"a.grad.errors.required\">\r\n                                            <p class=\"upozorenje\">Naziv grada je obavezan</p>\r\n                                        </div>\r\n                                        <div *ngIf=\"a.grad.errors.minlength\">\r\n                                            <p class=\"upozorenje\">Naziv grada mora imati minimalno 2 karaktera</p>\r\n                                        </div>\r\n                                    </div>\r\n                                </form>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n            <div class=\"d-flex flex-fill flex-column\">\r\n                <table class=\"table sirina-cena\">\r\n                    <tbody>\r\n                        <tr>\r\n                            <td class=\"pozadina-glavna-50 boja-siva-400\">Bez pdv-a: </td>\r\n                            <td class=\"text-right\">{{bezPdv | currency:\" \"}} RSD</td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td class=\"pozadina-glavna-50 boja-siva-400\">Pdv: </td>\r\n                            <td class=\"text-right\">{{pdv | currency:\" \"}} RSD</td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td class=\"pozadina-glavna-50 boja-siva-400\">Ukupno za uplatu: </td>\r\n                            <td class=\"text-right\"><b>{{ukupno | currency:\" \"}} RSD</b></td>\r\n                        </tr>\r\n                    </tbody>\r\n                </table>\r\n                <div>\r\n                    <button class=\"button-glavni-100 dugme-sirina float-right\" mat-raised-button\r\n                        (click)=\"posaljiPorudzbinu(roba)\">Potvrdi</button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/korpa/korpa.component.scss":
/*!***************************************************!*\
  !*** ./src/app/e-shop/korpa/korpa.component.scss ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".velicina-dugmeta {\n  padding: 0 10px; }\n\n.korpa-h1 {\n  margin-top: 0.5em;\n  font-size: 3.5em;\n  color: #345cac; }\n\n.headerKorpa {\n  background-image: url(\"/assets/slike/ui/pozadine/korpa.png\");\n  background-position: center;\n  background-repeat: no-repeat;\n  background-size: 100% 90px;\n  height: 100px; }\n\np {\n  text-align: left !important; }\n\nh3 {\n  font-weight: bold;\n  padding-left: 10px;\n  padding-top: 10px;\n  color: #345cac; }\n\nhr {\n  width: 90%;\n  margin-bottom: 5px;\n  margin-top: 5px; }\n\nh4 {\n  font-size: 1em;\n  font-weight: bold;\n  padding-left: 1em;\n  color: #345cac; }\n\ntextarea {\n  color: #273747; }\n\nlabel {\n  color: #273747;\n  font-weight: bold; }\n\n.radio-grupa {\n  display: inline-flex;\n  flex-direction: column; }\n\n.radio-dugme {\n  margin: 2px;\n  font-size: 0.8em !important; }\n\n.sirina-cena {\n  width: 95%; }\n\n.dugme-sirina {\n  width: 150px;\n  height: 40px;\n  border-radius: 5px; }\n\n.granice {\n  box-shadow: 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);\n  background-color: white;\n  padding-left: 5px;\n  width: 95%;\n  margin: 5px; }\n\n.pomeri-dole {\n  margin-top: 7px; }\n\n.visina {\n  height: 181px; }\n\n.visina-prevoza {\n  height: 193px; }\n\n.napomena {\n  height: 80px; }\n\n.google-mapa {\n  margin-left: 10%;\n  width: 80%; }\n\n@media only screen and (max-width: 1200px) {\n  .granice {\n    width: 99%; } }\n\n@media only screen and (max-width: 640px) {\n  .korpa-h1 {\n    margin-top: 0.5em; }\n  .headerKorpa {\n    background-size: 100% 75px; }\n  .sirina-cena {\n    width: 95%;\n    margin-left: 2%; } }\n\n@media screen and (max-width: 900px) {\n  p {\n    font-size: 0.85em;\n    font-weight: bold;\n    text-align: right !important; }\n  tr.mat-header-row {\n    height: 0px; }\n  .text-center {\n    text-align: none; }\n  .mat-table .mat-cell:last-child {\n    margin-top: 10px;\n    padding-left: 10px;\n    padding-right: 10px;\n    height: 45px; }\n  .button-align {\n    text-align: center; }\n  .levo-dugme {\n    padding-right: 20px !important;\n    display: inline-block !important; }\n  .desno-dugme {\n    padding-left: 20px !important;\n    display: inline-block !important; } }\n"

/***/ }),

/***/ "./src/app/e-shop/korpa/korpa.component.ts":
/*!*************************************************!*\
  !*** ./src/app/e-shop/korpa/korpa.component.ts ***!
  \*************************************************/
/*! exports provided: KorpaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KorpaComponent", function() { return KorpaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_data_data_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _service_data_local_storage_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/data/local-storage.service */ "./src/app/e-shop/service/data/local-storage.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../model/dto */ "./src/app/e-shop/model/dto.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _service_faktura_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../service/faktura.service */ "./src/app/e-shop/service/faktura.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_shared_modal_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component */ "./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.ts");
/* harmony import */ var src_app_shared_modal_uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component */ "./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.ts");
/* harmony import */ var src_app_shared_modal_neuspesno_porucivanje_modal_neuspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component */ "./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};














var KorpaComponent = /** @class */ (function () {
    function KorpaComponent(dataService, loginServis, storage, dialog, formBuilder, fakturaServis, router) {
        this.dataService = dataService;
        this.loginServis = loginServis;
        this.storage = storage;
        this.dialog = dialog;
        this.formBuilder = formBuilder;
        this.fakturaServis = fakturaServis;
        this.router = router;
        this.dugmeZaPorucivanjeStisnuto = false;
        this.displayedColumns = ['katbr', 'katbrpro', 'naziv',
            'proizvodjac', 'kolicina', 'cena', 'izbaciDugme'];
        this.treceLiceOpcije = ['Kurirske službe', 'Drugo'];
        this.kurirskeSluzbe = ['Aks', 'Beks'];
        this.adresaDostave = ['Vaša adresa', 'Druga'];
        this.ucitavanje = false;
        this.alive = true;
    }
    KorpaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.loginServis.vratiUlogovanogKorisnika(false)
            .subscribe(function (res) {
            if (res !== null) {
                _this.partner = res;
                _this.inicijalizujKorpu();
            }
            else {
                _this.router.navigate(['/login']);
                _this.loginServis.izbaciPartnerIzSesije();
            }
        });
    };
    KorpaComponent.prototype.inicijalizujKorpu = function () {
        var _this = this;
        this.vratiOpsteInformacije();
        this.dataService.trenutnaKorpa.subscribe(function (korpa) {
            _this.korpa = korpa;
            _this.preracunajUkupno();
            _this.dataSource = _this.korpa.roba;
        });
        this.izabranaTrecaLiceOpcija = this.treceLiceOpcije[0];
        this.izabraneKurirskeSluzbe = this.kurirskeSluzbe[0];
        this.izabraneAdresaDostave = this.adresaDostave[0];
        this.inicijalizujSveForme();
    };
    KorpaComponent.prototype.inicijalizujSveForme = function () {
        this.drugiNacinPrevoza = this.formBuilder.group({
            prevoz: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_7__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_7__["Validators"].minLength(3)]]
        });
        this.adresaForm = this.formBuilder.group({
            ulica: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_7__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_7__["Validators"].minLength(3)]],
            grad: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_7__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_7__["Validators"].minLength(2)]]
        });
    };
    KorpaComponent.prototype.vratiOpsteInformacije = function () {
        var _this = this;
        var vrsteInformacije = ['placanje', 'prevoz'];
        vrsteInformacije.forEach(function (vrsta) {
            _this.dataService.vratiOpsteInformacije(vrsta).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_5__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["finalize"])(function () { return _this.ucitavanje = false; }))
                .subscribe(function (res) {
                if (vrsta === vrsteInformacije[0]) {
                    _this.nacinPlacanja = res;
                    _this.izabranNacinPlacanja = res[0];
                }
                else {
                    _this.nacinPrevoza = res;
                    _this.izabranNacinPrevoza = res[0];
                }
            }, function (error) {
            });
        });
    };
    KorpaComponent.prototype.izbaciIzKorpe = function (index) {
        this.dataService.izbaciIzKorpe(index);
        this.table.renderRows();
    };
    KorpaComponent.prototype.otvoriDialog = function (roba) {
        var _this = this;
        var dialogRef = this.dialog.open(src_app_shared_modal_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_11__["IzmenaKolicineModalComponent"], {
            width: '400px',
            data: roba
        });
        dialogRef.afterClosed().subscribe(function (result) {
            if (result) {
                _this.promeniKolicinuArtikla(result);
            }
        });
    };
    KorpaComponent.prototype.otvoriDialogUspesnoPorucivanje = function () {
        var _this = this;
        var dialogRef = this.dialog.open(src_app_shared_modal_uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_12__["UspesnoPorucivanjeModalComponent"], {
            width: '400px'
        });
        dialogRef.afterClosed().subscribe(function () {
            _this.router.navigate(['/naslovna']);
        });
    };
    KorpaComponent.prototype.otvoriDialogNeuspesnoPorucivanje = function (roba, faktura) {
        var _this = this;
        var dialogRef = this.dialog.open(src_app_shared_modal_neuspesno_porucivanje_modal_neuspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_13__["NeuspesnoPorucivanjeModalComponent"], {
            width: '400px',
            data: { faktura: faktura, roba: roba }
        });
        dialogRef.afterClosed().subscribe(function () {
            _this.zatvaranjeNeuspesnogDiloga(roba);
        });
    };
    KorpaComponent.prototype.zatvaranjeNeuspesnogDiloga = function (roba) {
        var _this = this;
        var stanjePromenjeno = false;
        roba.forEach(function (r) {
            _this.korpa.roba
                .filter(function (robaKorpa) { return robaKorpa.robaid === r.robaid; })
                .map(function (robaKorpa) {
                stanjePromenjeno = true;
                robaKorpa.kolicina = r.stanje;
            });
        });
        this.korpa.roba = this.korpa.roba.filter(function (rKorpa) { return rKorpa.kolicina > 0; });
        if (stanjePromenjeno) {
            this.dataSource = null;
            this.dataSource = this.korpa.roba;
        }
    };
    KorpaComponent.prototype.promeniKolicinuArtikla = function (artikal) {
        this.korpa.roba.forEach(function (roba) {
            if (roba.katbr === artikal.katbr) {
                roba.kolicina = artikal.kolicina;
                roba.cenaUkupno = artikal.cenaUkupno;
            }
        });
        this.storage.zameniArtikalSaNovim(artikal);
        this.preracunajUkupno();
        this.dataSource = this.korpa.roba;
        this.table.renderRows();
    };
    KorpaComponent.prototype.preracunajUkupno = function () {
        var _this = this;
        this.korpa.ukupno = 0;
        this.korpa.roba.forEach(function (roba) {
            _this.korpa.ukupno = _this.korpa.ukupno + roba.cenaUkupno;
        });
        this.bezPdv = (this.korpa.ukupno / 1.2).toFixed(2);
        this.pdv = (this.korpa.ukupno - this.korpa.ukupno / 1.2).toFixed(2);
        this.ukupno = this.korpa.ukupno.toFixed(2);
    };
    // glavna metoda
    KorpaComponent.prototype.posaljiPorudzbinu = function () {
        var _this = this;
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
        this.loginServis.vratiUlogovanogKorisnika(false).subscribe(function (partner) {
            if (partner) {
                _this.submitujFakturu();
            }
            else {
                _this.router.navigate(['/login']);
                _this.loginServis.izbaciPartnerIzSesije();
            }
        });
    };
    KorpaComponent.prototype.submitujFakturu = function () {
        var _this = this;
        this.fakturaServis.submitujFakturu(this.faktura).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_5__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            if (res.length === 0) {
                _this.otvoriDialogUspesnoPorucivanje();
                _this.dataService.ocistiKorpu();
                _this.router.navigate(['/naslovna']);
            }
            else {
                _this.otvoriDialogNeuspesnoPorucivanje(res, _this.faktura);
            }
        });
    };
    KorpaComponent.prototype.korpaUFakturu = function () {
        var _this = this;
        this.faktura = new _model_dto__WEBPACK_IMPORTED_MODULE_6__["Fakutra"]();
        this.faktura.adresa = this.napraviIPopuniValueHelp(this.partner.ppid);
        this.faktura.nacinPlacanja = this.napraviIPopuniValueHelp(this.korpa.nacinPlacanja);
        this.faktura.nacinPrevoza = this.napraviIPopuniValueHelp(this.korpa.nacinIsporuke);
        this.faktura.napomena = this.korpa.napomena;
        this.faktura.iznosNarucen = this.korpa.ukupno;
        this.faktura.detalji = [];
        this.korpa.roba.forEach(function (roba) {
            _this.faktura.detalji.push(_this.popuniStavke(roba));
        });
    };
    KorpaComponent.prototype.popuniStavke = function (roba) {
        var stavka = new _model_dto__WEBPACK_IMPORTED_MODULE_6__["FakturaDetalji"]();
        stavka.kataloskiBroj = roba.katbr;
        stavka.proizvodjac = roba.proizvodjac;
        stavka.kolicina = roba.kolicina;
        stavka.rabat = roba.rabat;
        stavka.robaId = roba.robaid;
        stavka.cena = roba.cenaKom;
        return stavka;
    };
    KorpaComponent.prototype.napraviIPopuniValueHelp = function (id) {
        var valueHelp = new _model_dto__WEBPACK_IMPORTED_MODULE_6__["ValueHelp"]();
        valueHelp.id = id;
        return valueHelp;
    };
    KorpaComponent.prototype.popuniNapomenu = function () {
        this.korpa.napomena = '';
        if (this.izabranNacinPrevoza === this.nacinPrevoza[2]) {
            var nacinPrevoza = void 0;
            if (this.izabranaTrecaLiceOpcija === this.treceLiceOpcije[0]) {
                nacinPrevoza = this.izabraneKurirskeSluzbe;
            }
            else {
                nacinPrevoza = this.drugiNacinPrevoza.controls.prevoz.value;
            }
            this.korpa.napomena = this.korpa.napomena + 'Način prevoza: ' + nacinPrevoza + ' - ';
        }
        if (this.izabraneAdresaDostave === this.adresaDostave[1]) {
            var adresaDostave = this.adresaForm.controls.ulica.value + ', ' + this.adresaForm.controls.grad.value;
            this.korpa.napomena = this.korpa.napomena + 'Adresa dostave: ' + adresaDostave + ' - ';
        }
        if (this.napomena) {
            this.korpa.napomena = this.korpa.napomena + 'Napomena: ' + this.napomena;
        }
    };
    Object.defineProperty(KorpaComponent.prototype, "a", {
        // convenience getter for easy access to form fields
        get: function () { return this.adresaForm.controls; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(KorpaComponent.prototype, "d", {
        get: function () { return this.drugiNacinPrevoza.controls; },
        enumerable: true,
        configurable: true
    });
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])(_angular_material__WEBPACK_IMPORTED_MODULE_3__["MatTable"]),
        __metadata("design:type", _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatTable"])
    ], KorpaComponent.prototype, "table", void 0);
    KorpaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-korpa',
            template: __webpack_require__(/*! ./korpa.component.html */ "./src/app/e-shop/korpa/korpa.component.html"),
            styles: [__webpack_require__(/*! ./korpa.component.scss */ "./src/app/e-shop/korpa/korpa.component.scss")]
        }),
        __metadata("design:paramtypes", [_service_data_data_service__WEBPACK_IMPORTED_MODULE_1__["DataService"],
            _service_login_service__WEBPACK_IMPORTED_MODULE_8__["LoginService"],
            _service_data_local_storage_service__WEBPACK_IMPORTED_MODULE_2__["LocalStorageService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatDialog"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_7__["FormBuilder"],
            _service_faktura_service__WEBPACK_IMPORTED_MODULE_9__["FakturaService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_10__["Router"]])
    ], KorpaComponent);
    return KorpaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/korpa/korpa.module.ts":
/*!**********************************************!*\
  !*** ./src/app/e-shop/korpa/korpa.module.ts ***!
  \**********************************************/
/*! exports provided: KorpaModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KorpaModule", function() { return KorpaModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _korpa_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./korpa.component */ "./src/app/e-shop/korpa/korpa.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/shared/material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var _magacin_shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../magacin/shared-components/shared-magacin.module */ "./src/app/e-shop/magacin/shared-components/shared-magacin.module.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_shared_pipes_pipe_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/shared/pipes/pipe.module */ "./src/app/shared/pipes/pipe.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};








var routes = [
    {
        path: '',
        component: _korpa_component__WEBPACK_IMPORTED_MODULE_2__["KorpaComponent"]
    }
];
var KorpaModule = /** @class */ (function () {
    function KorpaModule() {
    }
    KorpaModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_4__["MaterialModule"],
                _magacin_shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_5__["SharedMagacinModule"],
                src_app_shared_pipes_pipe_module__WEBPACK_IMPORTED_MODULE_7__["PipeModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_6__["RouterModule"].forChild(routes)
            ],
            declarations: [_korpa_component__WEBPACK_IMPORTED_MODULE_2__["KorpaComponent"]],
            exports: [_korpa_component__WEBPACK_IMPORTED_MODULE_2__["KorpaComponent"]]
        })
    ], KorpaModule);
    return KorpaModule;
}());



/***/ })

}]);
//# sourceMappingURL=e-shop-korpa-korpa-module.js.map