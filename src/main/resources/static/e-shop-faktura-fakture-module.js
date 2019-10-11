(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-shop-faktura-fakture-module"],{

/***/ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.html":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.html ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <main>\r\n        <div *ngIf=\"!ucitavanje && dataSource != null && dataSource.length > 0\">\r\n            <h1>Detalji fakture: {{faktura.id}}</h1>\r\n            <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n                <button class=\"button-glavni-100 nazad-button\" mat-raised-button (click)=\"idiNazad()\">\r\n                    <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n                </button>\r\n            </div>\r\n\r\n            <div class=\"d-flex flex-wrap bd-highlight flex-sm-row flex-column detalji-div\">\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-100\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.status\" class=\"boja-siva-400\">Status: {{faktura.status.naziv}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-100\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-siva-400\">Datum: {{faktura.vremePorucivanja | datum}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-100\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.nacinPlacanja\" class=\"boja-siva-400\">Nacin placanja:\r\n                            {{faktura.nacinPlacanja.naziv}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-100\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.nacinPrevoza\" class=\"boja-siva-400\">Nacin prevoza: {{\"prevoz_\" +\r\n                            faktura.nacinPrevoza.id | translate}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-100\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.adresa\" class=\"boja-siva-400\">Adresa: {{faktura.adresa.naziv}}</p>\r\n                    </label>\r\n                </div>\r\n            </div>\r\n            <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n                <table mat-table [dataSource]=\"dataSource\">\r\n\r\n                    <!-- Kataloski broj Column -->\r\n                    <ng-container matColumnDef=\"robaId\">\r\n                        <th mat-header-cell *matHeaderCellDef> Kataloški broj </th>\r\n                        <td data-label=\"Kataloški broj\" mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{faktura.kataloskiBroj}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Kataloski broj Column -->\r\n                    <ng-container matColumnDef=\"proizvodjac\">\r\n                        <th mat-header-cell *matHeaderCellDef> Proizvodjač </th>\r\n                        <td data-label=\"Proizvodjač\" mat-cell *matCellDef=\"let faktura\">\r\n                            <p >\r\n                                {{faktura.proizvodjac.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Narucena Kolicina Column -->\r\n                    <ng-container matColumnDef=\"kolicina\">\r\n                        <th mat-header-cell *matHeaderCellDef> Narucena Količina</th>\r\n                        <td data-label=\"Narucena Količina\" mat-cell *matCellDef=\"let faktura\">\r\n                            <p >\r\n                                {{faktura.kolicina}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Potvrdjena Kolicina Column -->\r\n                    <ng-container matColumnDef=\"potvrdjenaKolicina\">\r\n                        <th mat-header-cell *matHeaderCellDef> Potvrdjena količina </th>\r\n                        <td data-label=\"Potvrdjena količina\" mat-cell *matCellDef=\"let faktura\">\r\n                            <p >\r\n                                {{faktura.potvrdjenaKolicina}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Rabat Column -->\r\n                    <ng-container matColumnDef=\"rabat\">\r\n                        <th mat-header-cell *matHeaderCellDef> Rabat </th>\r\n                        <td data-label=\"Rabat\" mat-cell *matCellDef=\"let faktura\">\r\n                            <p >\r\n                                {{faktura.rabat}}%\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"cena\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                        <td data-label=\"Cena\" mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1 text-right iznos-margin\">\r\n                                {{faktura.cena | currency:\" \"}} RSD\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- tatus Column -->\r\n                    <ng-container matColumnDef=\"status\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\">Status</th>\r\n                        <td data-label=\"Status\" mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"text-center tabela-u-korpi mat-body-1\">\r\n                                {{faktura.status.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n                    <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n                </table>\r\n                <div class=\"d-flex flex-column flex-sm-row\">\r\n                    <div class=\"d-flex flex-fill justify-content-end\">\r\n                    </div>\r\n                    <div class=\"d-flex flex-fill justify-content-end\">\r\n                        <table class=\"table sirina-cena\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td class=\"pozadina-glavna-50 boja-siva-400\">Ukupnan iznos: </td>\r\n                                    <td class=\"text-right\"><b>{{faktura.iznosPotvrdjen | currency:\" \"}} RSD</b></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div *ngIf=\"!ucitavanje && (dataSource == null || dataSource.length == 0)\">\r\n            <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n                <button class=\"button-glavni-100 nazad-button nazad-dugme-dole\" mat-raised-button (click)=\"idiNazad()\">\r\n                    <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n                </button>\r\n            </div>\r\n            <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n                <i class=\"material-icons icon-size\">\r\n                    error_outline\r\n                </i>\r\n                <h1 class=\"h1-faktura-upozorenje\">Porudzbenica je prazna</h1>\r\n            </div>\r\n        </div>\r\n        <div *ngIf=\"!ucitavanje && error\">\r\n            <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n                <button class=\"button-glavni-100 nazad-button greska-dugme-pozicija\" mat-raised-button (click)=\"idiNazad()\">\r\n                    <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n                </button>\r\n            </div>\r\n            <div class=\"d-flex flex-column prazna-tabela\">\r\n                <i class=\"material-icons icon-size\">\r\n                    error_outline\r\n                </i>\r\n                <h1 class=\"h1-faktura-upozorenje\">Porudzbenica ne postoji</h1>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n            <mat-spinner></mat-spinner>\r\n        </div>\r\n    </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.scss":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.scss ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  margin-left: 5%;\n  margin-top: 0.5em; }\n\np {\n  font-size: 0.92em; }\n\ntable {\n  margin: 0px !important; }\n\n.nazad-dugme-dole {\n  top: 40px; }\n\n.greska-dugme-pozicija {\n  position: relative;\n  top: 50px; }\n\n.detalji-div {\n  width: 90%;\n  margin-left: 5%; }\n\n@media screen and (max-width: 900px) {\n  p {\n    font-size: 0.85em;\n    font-weight: bold; }\n  tr.mat-header-row {\n    height: 0px; }\n  .text-center {\n    text-align: none; } }\n\n@media only screen and (max-device-width: 640px) {\n  h1 {\n    margin-top: 0px; }\n  .nazad-dugme-dole {\n    top: 10px; }\n  .greska-dugme-pozicija {\n    position: relative;\n    top: 5px; } }\n"

/***/ }),

/***/ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.ts":
/*!*****************************************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.ts ***!
  \*****************************************************************************/
/*! exports provided: FakturaDetaljiComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FakturaDetaljiComponent", function() { return FakturaDetaljiComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../model/dto */ "./src/app/e-shop/model/dto.ts");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _service_faktura_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../service/faktura.service */ "./src/app/e-shop/service/faktura.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var FakturaDetaljiComponent = /** @class */ (function () {
    function FakturaDetaljiComponent(loginServis, route, fakturaServis, router) {
        this.loginServis = loginServis;
        this.route = route;
        this.fakturaServis = fakturaServis;
        this.router = router;
        this.faktura = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["Fakutra"]();
        this.ucitavanje = false;
        this.error = false;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.displayedColumns = ['robaId', 'proizvodjac', 'kolicina', 'potvrdjenaKolicina',
            'rabat', 'cena', 'status'];
    }
    FakturaDetaljiComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.ucitavanje = true;
        this.loginServis.vratiUlogovanogKorisnika(false)
            .subscribe(function (res) {
            if (res !== null) {
                _this.partner = res;
                _this.vratiFakturu();
            }
            else {
                _this.router.navigate(['/login']);
                _this.loginServis.izbaciPartnerIzSesije();
            }
        });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
    };
    FakturaDetaljiComponent.prototype.vratiFakturu = function () {
        var _this = this;
        this.route.params.subscribe(function (params) {
            _this.fakturaServis.vratiFakturuPojedinacno(params.id, _this.partner.ppid)
                .subscribe(function (res) {
                _this.error = false;
                _this.faktura = res;
                _this.fakturaDetalji = res.detalji;
                _this.dataSource = _this.fakturaDetalji;
                _this.ucitavanje = false;
            }, function (error) {
                _this.error = true;
                _this.ucitavanje = false;
            });
        });
    };
    FakturaDetaljiComponent.prototype.idiNazad = function () {
        this.router.navigate(['/porudzbenice']);
    };
    FakturaDetaljiComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-faktura-detalji',
            template: __webpack_require__(/*! ./faktura-detalji.component.html */ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.html"),
            styles: [__webpack_require__(/*! ./faktura-detalji.component.scss */ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.scss")]
        }),
        __metadata("design:paramtypes", [_service_login_service__WEBPACK_IMPORTED_MODULE_3__["LoginService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"],
            _service_faktura_service__WEBPACK_IMPORTED_MODULE_4__["FakturaService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]])
    ], FakturaDetaljiComponent);
    return FakturaDetaljiComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/faktura/faktura.component.html":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura.component.html ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <main>\r\n        <div>\r\n            <h1>Moje porudzbenice</h1>\r\n            <div *ngIf=\"!ucitavanje && dataSource != null && dataSource.length > 0\" class=\"tabela-div\">\r\n                <table mat-table [dataSource]=\"dataSource\">\r\n\r\n                    <!-- Kataloski broj Column -->\r\n                    <ng-container matColumnDef=\"orderId\">\r\n                        <th mat-header-cell *matHeaderCellDef> Broj Fakture </th>\r\n                        <td mat-cell data-label=\"Broj Fakture\" *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{faktura.orderId}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Broj stavki Column -->\r\n                    <ng-container matColumnDef=\"brojStavki\">\r\n                        <th mat-header-cell *matHeaderCellDef>Broj stavki</th>\r\n                        <td mat-cell data-label=\"Broj stavki\" *matCellDef=\"let faktura\">\r\n                            <p>\r\n                                {{faktura.brojStavki}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"iznosNarucen\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Iznos narucen </th>\r\n                        <td mat-cell data-label=\"Iznos narucen\" *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2 text-right iznos-margin\">\r\n                                {{faktura.iznosNarucen | currency:\" \"}} RSD\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"iznosPotvrdjen\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Iznos potvrdjen </th>\r\n                        <td mat-cell data-label=\"Iznos potvrdjen\" *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2 text-right iznos-margin\">\r\n                                {{faktura.iznosPotvrdjen | currency:\" \"}} RSD\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Vreme porucivanja Column -->\r\n                    <ng-container matColumnDef=\"vremePorucivanja\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Datum </th>\r\n                        <td mat-cell data-label=\"Datum\" *matCellDef=\"let faktura\">\r\n                            <p class=\"text-center tabela-u-korpi\">\r\n                                {{faktura.vremePorucivanja | datum}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Status Column -->\r\n                    <ng-container matColumnDef=\"status\">\r\n                        <th mat-header-cell *matHeaderCellDef> Status </th>\r\n                        <td mat-cell data-label=\"Status\" *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{faktura.status.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Akcije Column -->\r\n                    <ng-container matColumnDef=\"ackije\">\r\n                        <th mat-header-cell *matHeaderCellDef> </th>\r\n                        <td mat-cell class=\"visina-div-dugmeta\" *matCellDef=\"let faktura\">\r\n                            <div class=\"dugme-mobilni\">\r\n                                <button class=\"velicina-dugmeta button-glavni-100\" mat-raised-button\r\n                                    (click)=\"detaljiFakture(faktura.id)\">Detalji</button>\r\n                            </div>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n                    <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n                </table>\r\n                <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\"\r\n                    [pageSizeOptions]=\"[5, 10, 25]\" [pageIndex]=\"pageIndex\" [length]=\"tableLength\"\r\n                    [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n                </mat-paginator>\r\n            </div>\r\n            <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n                <mat-spinner></mat-spinner>\r\n            </div>\r\n        </div>\r\n\r\n        <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"error || (fakure && fakure.length === 0)\">\r\n            <i class=\"material-icons icon-size\">\r\n                error_outline\r\n            </i>\r\n            <h1 class=\"h1-faktura-upozorenje\">Istorija porucivanja je prazna</h1>\r\n        </div>\r\n    </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/faktura/faktura.component.scss":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura.component.scss ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@media screen and (max-width: 900px) {\n  p {\n    font-size: 0.85em;\n    font-weight: bold; }\n  tr.mat-header-row {\n    height: 0px; } }\n"

/***/ }),

/***/ "./src/app/e-shop/faktura/faktura.component.ts":
/*!*****************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura.component.ts ***!
  \*****************************************************/
/*! exports provided: FakturaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FakturaComponent", function() { return FakturaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _service_faktura_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/faktura.service */ "./src/app/e-shop/service/faktura.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var FakturaComponent = /** @class */ (function () {
    function FakturaComponent(loginServis, fakturaService, router) {
        this.loginServis = loginServis;
        this.fakturaService = fakturaService;
        this.router = router;
        this.error = false;
        this.ucitavanje = false;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.displayedColumns = ['orderId', 'brojStavki', 'iznosNarucen', 'iznosPotvrdjen', 'vremePorucivanja', 'status', 'ackije'];
    }
    FakturaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.ucitavanje = true;
        this.loginServis.vratiUlogovanogKorisnika(false)
            .subscribe(function (res) {
            if (res !== null) {
                _this.partner = res;
                _this.vratiFaktureKorisnika();
            }
            else {
                _this.router.navigate(['/login']);
                _this.loginServis.izbaciPartnerIzSesije();
            }
        });
    };
    FakturaComponent.prototype.vratiFaktureKorisnika = function () {
        var _this = this;
        this.fakturaService.vratiFaktureKorisnika(this.pageIndex, this.rowsPerPage, this.partner.ppid)
            .subscribe(function (res) {
            _this.error = false;
            _this.fakure = res.content;
            _this.dataSource = _this.fakure;
            _this.ucitavanje = false;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.ucitavanje = false;
            _this.error = true;
        });
    };
    FakturaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.vratiFaktureKorisnika();
    };
    FakturaComponent.prototype.detaljiFakture = function (id) {
        this.router.navigate(['/porudzbenice/' + id]);
    };
    FakturaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-faktura',
            template: __webpack_require__(/*! ./faktura.component.html */ "./src/app/e-shop/faktura/faktura.component.html"),
            styles: [__webpack_require__(/*! ./faktura.component.scss */ "./src/app/e-shop/faktura/faktura.component.scss")]
        }),
        __metadata("design:paramtypes", [_service_login_service__WEBPACK_IMPORTED_MODULE_1__["LoginService"],
            _service_faktura_service__WEBPACK_IMPORTED_MODULE_2__["FakturaService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
    ], FakturaComponent);
    return FakturaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/faktura/fakture.module.ts":
/*!**************************************************!*\
  !*** ./src/app/e-shop/faktura/fakture.module.ts ***!
  \**************************************************/
/*! exports provided: FaktureModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FaktureModule", function() { return FaktureModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var _magacin_shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../magacin/shared-components/shared-magacin.module */ "./src/app/e-shop/magacin/shared-components/shared-magacin.module.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./faktura-detalji/faktura-detalji.component */ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.ts");
/* harmony import */ var _faktura_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./faktura.component */ "./src/app/e-shop/faktura/faktura.component.ts");
/* harmony import */ var src_app_shared_pipes_pipe_module__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/shared/pipes/pipe.module */ "./src/app/shared/pipes/pipe.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};









var routes = [
    {
        path: '',
        component: _faktura_component__WEBPACK_IMPORTED_MODULE_7__["FakturaComponent"]
    },
    {
        path: ':id',
        component: _faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_6__["FakturaDetaljiComponent"]
    }
];
var FaktureModule = /** @class */ (function () {
    function FaktureModule() {
    }
    FaktureModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                src_app_shared_pipes_pipe_module__WEBPACK_IMPORTED_MODULE_8__["PipeModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_3__["MaterialModule"],
                _magacin_shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_4__["SharedMagacinModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_5__["RouterModule"].forChild(routes)
            ],
            declarations: [_faktura_component__WEBPACK_IMPORTED_MODULE_7__["FakturaComponent"], _faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_6__["FakturaDetaljiComponent"]],
            exports: [_faktura_component__WEBPACK_IMPORTED_MODULE_7__["FakturaComponent"]]
        })
    ], FaktureModule);
    return FaktureModule;
}());



/***/ })

}]);
//# sourceMappingURL=e-shop-faktura-fakture-module.js.map