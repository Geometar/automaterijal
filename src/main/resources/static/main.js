(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _e_shop_roba_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./e-shop/roba/filteri/filteri.component */ "./src/app/e-shop/roba/filteri/filteri.component.ts");
/* harmony import */ var _e_shop_roba_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./e-shop/roba/akumulatori/akumulatori.component */ "./src/app/e-shop/roba/akumulatori/akumulatori.component.ts");
/* harmony import */ var _e_shop_roba_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./e-shop/roba/ulja/ulja.component */ "./src/app/e-shop/roba/ulja/ulja.component.ts");
/* harmony import */ var _e_shop_korpa_korpa_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./e-shop/korpa/korpa.component */ "./src/app/e-shop/korpa/korpa.component.ts");
/* harmony import */ var _e_shop_login_login_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./e-shop/login/login.component */ "./src/app/e-shop/login/login.component.ts");
/* harmony import */ var _e_shop_faktura_faktura_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./e-shop/faktura/faktura.component */ "./src/app/e-shop/faktura/faktura.component.ts");
/* harmony import */ var _e_shop_faktura_faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./e-shop/faktura/faktura-detalji/faktura-detalji.component */ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.ts");
/* harmony import */ var _e_shop_roba_ostalo_ostalo_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./e-shop/roba/ostalo/ostalo.component */ "./src/app/e-shop/roba/ostalo/ostalo.component.ts");
/* harmony import */ var _e_shop_roba_ostalo_kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component */ "./src/app/e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component.ts");
/* harmony import */ var _e_shop_partner_partner_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./e-shop/partner/partner.component */ "./src/app/e-shop/partner/partner.component.ts");
/* harmony import */ var _e_shop_roba_roba_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./e-shop/roba/roba.component */ "./src/app/e-shop/roba/roba.component.ts");
/* harmony import */ var _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./e-commerce/dasboard/dasboard.component */ "./src/app/e-commerce/dasboard/dasboard.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};














var routes = [
    { path: '', redirectTo: '/naslovna', pathMatch: 'full' },
    { path: 'naslovna', component: _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_13__["DasboardComponent"] },
    { path: 'o-nama', component: _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_13__["DasboardComponent"] },
    { path: 'kontakt', component: _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_13__["DasboardComponent"] },
    { path: 'roba', component: _e_shop_roba_roba_component__WEBPACK_IMPORTED_MODULE_12__["RobaComponent"] },
    { path: 'filteri', component: _e_shop_roba_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_2__["FilteriComponent"] },
    { path: 'ulja', component: _e_shop_roba_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_4__["UljaComponent"] },
    { path: 'akumulatori', component: _e_shop_roba_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_3__["AkumulatoriComponent"] },
    { path: 'ostalo', component: _e_shop_roba_ostalo_ostalo_component__WEBPACK_IMPORTED_MODULE_9__["OstaloComponent"] },
    { path: 'ostalo/:id', component: _e_shop_roba_ostalo_kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_10__["KategorijaSpecificnaComponent"] },
    { path: 'login', component: _e_shop_login_login_component__WEBPACK_IMPORTED_MODULE_6__["LoginComponent"] },
    { path: 'kontakt', component: _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_13__["DasboardComponent"] },
    { path: 'licni-podaci', component: _e_shop_partner_partner_component__WEBPACK_IMPORTED_MODULE_11__["PartnerComponent"] },
    { path: 'porudzbenice', component: _e_shop_faktura_faktura_component__WEBPACK_IMPORTED_MODULE_7__["FakturaComponent"] },
    { path: 'porudzbenice/:id', component: _e_shop_faktura_faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_8__["FakturaDetaljiComponent"] },
    { path: 'korpa', component: _e_shop_korpa_korpa_component__WEBPACK_IMPORTED_MODULE_5__["KorpaComponent"] }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-navigacija></app-navigacija>"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'Automaterijal';
    }
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var angular_webstorage_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! angular-webstorage-service */ "./node_modules/angular-webstorage-service/bundles/angular-webstorage-service.es5.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./shared/material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var _navigacija_navigacija_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./navigacija/navigacija.component */ "./src/app/navigacija/navigacija.component.ts");
/* harmony import */ var _e_shop_roba_roba_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./e-shop/roba/roba.component */ "./src/app/e-shop/roba/roba.component.ts");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _e_shop_roba_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./e-shop/roba/filteri/filteri.component */ "./src/app/e-shop/roba/filteri/filteri.component.ts");
/* harmony import */ var _e_shop_roba_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./e-shop/roba/akumulatori/akumulatori.component */ "./src/app/e-shop/roba/akumulatori/akumulatori.component.ts");
/* harmony import */ var _e_shop_roba_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./e-shop/roba/ulja/ulja.component */ "./src/app/e-shop/roba/ulja/ulja.component.ts");
/* harmony import */ var _e_shop_roba_ulja_motorna_motorna_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./e-shop/roba/ulja/motorna/motorna.component */ "./src/app/e-shop/roba/ulja/motorna/motorna.component.ts");
/* harmony import */ var _e_shop_roba_ulja_menjacko_menjacko_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./e-shop/roba/ulja/menjacko/menjacko.component */ "./src/app/e-shop/roba/ulja/menjacko/menjacko.component.ts");
/* harmony import */ var _e_shop_roba_ulja_kociona_kociona_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./e-shop/roba/ulja/kociona/kociona.component */ "./src/app/e-shop/roba/ulja/kociona/kociona.component.ts");
/* harmony import */ var _e_shop_roba_ulja_antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./e-shop/roba/ulja/antifriz/antifriz.component */ "./src/app/e-shop/roba/ulja/antifriz/antifriz.component.ts");
/* harmony import */ var _e_shop_roba_ulja_industrijska_industrijska_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./e-shop/roba/ulja/industrijska/industrijska.component */ "./src/app/e-shop/roba/ulja/industrijska/industrijska.component.ts");
/* harmony import */ var _e_shop_korpa_korpa_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./e-shop/korpa/korpa.component */ "./src/app/e-shop/korpa/korpa.component.ts");
/* harmony import */ var _e_shop_korpa_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component */ "./src/app/e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.ts");
/* harmony import */ var _e_shop_login_login_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./e-shop/login/login.component */ "./src/app/e-shop/login/login.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _navigacija_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./navigacija/logout-modal/logout-modal.component */ "./src/app/navigacija/logout-modal/logout-modal.component.ts");
/* harmony import */ var _e_shop_faktura_faktura_component__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./e-shop/faktura/faktura.component */ "./src/app/e-shop/faktura/faktura.component.ts");
/* harmony import */ var _pipes_PrevodilacPipe__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ./pipes/PrevodilacPipe */ "./src/app/pipes/PrevodilacPipe.ts");
/* harmony import */ var _pipes_EmptyPipe__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ./pipes/EmptyPipe */ "./src/app/pipes/EmptyPipe.ts");
/* harmony import */ var _e_shop_faktura_faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! ./e-shop/faktura/faktura-detalji/faktura-detalji.component */ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.ts");
/* harmony import */ var _pipes_DatePipe__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! ./pipes/DatePipe */ "./src/app/pipes/DatePipe.ts");
/* harmony import */ var _e_shop_roba_ostalo_ostalo_component__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! ./e-shop/roba/ostalo/ostalo.component */ "./src/app/e-shop/roba/ostalo/ostalo.component.ts");
/* harmony import */ var _e_shop_roba_ostalo_kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(/*! ./e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component */ "./src/app/e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component.ts");
/* harmony import */ var _e_shop_partner_partner_component__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(/*! ./e-shop/partner/partner.component */ "./src/app/e-shop/partner/partner.component.ts");
/* harmony import */ var _e_shop_korpa_uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(/*! ./e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component */ "./src/app/e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.ts");
/* harmony import */ var _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(/*! ./e-commerce/dasboard/dasboard.component */ "./src/app/e-commerce/dasboard/dasboard.component.ts");
/* harmony import */ var _e_shop_login_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(/*! ./e-shop/login/registracija-modal/registracija-modal.component */ "./src/app/e-shop/login/registracija-modal/registracija-modal.component.ts");
/* harmony import */ var _e_shop_login_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(/*! ./e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component */ "./src/app/e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};




































var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                _navigacija_navigacija_component__WEBPACK_IMPORTED_MODULE_6__["NavigacijaComponent"],
                _e_shop_roba_roba_component__WEBPACK_IMPORTED_MODULE_7__["RobaComponent"],
                _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_33__["DasboardComponent"],
                _e_shop_roba_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_11__["FilteriComponent"],
                _e_shop_roba_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_12__["AkumulatoriComponent"],
                _e_shop_roba_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_13__["UljaComponent"],
                _e_shop_roba_ulja_motorna_motorna_component__WEBPACK_IMPORTED_MODULE_14__["MotornaComponent"],
                _e_shop_roba_ulja_menjacko_menjacko_component__WEBPACK_IMPORTED_MODULE_15__["MenjackoComponent"],
                _e_shop_roba_ulja_kociona_kociona_component__WEBPACK_IMPORTED_MODULE_16__["KocionaComponent"],
                _e_shop_roba_ulja_antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_17__["AntifrizComponent"],
                _e_shop_roba_ulja_industrijska_industrijska_component__WEBPACK_IMPORTED_MODULE_18__["IndustrijskaComponent"],
                _e_shop_korpa_korpa_component__WEBPACK_IMPORTED_MODULE_19__["KorpaComponent"],
                _e_shop_korpa_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_20__["IzmenaKolicineModalComponent"],
                _e_shop_login_login_component__WEBPACK_IMPORTED_MODULE_21__["LoginComponent"],
                _navigacija_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_23__["LogoutModalComponent"],
                _e_shop_faktura_faktura_component__WEBPACK_IMPORTED_MODULE_24__["FakturaComponent"],
                _pipes_PrevodilacPipe__WEBPACK_IMPORTED_MODULE_25__["TranslatePipe"],
                _pipes_EmptyPipe__WEBPACK_IMPORTED_MODULE_26__["EmptyPipe"],
                _pipes_DatePipe__WEBPACK_IMPORTED_MODULE_28__["DatePipe"],
                _e_shop_faktura_faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_27__["FakturaDetaljiComponent"],
                _e_shop_roba_ostalo_ostalo_component__WEBPACK_IMPORTED_MODULE_29__["OstaloComponent"],
                _e_shop_roba_ostalo_kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_30__["KategorijaSpecificnaComponent"],
                _e_shop_partner_partner_component__WEBPACK_IMPORTED_MODULE_31__["PartnerComponent"],
                _e_shop_korpa_uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_32__["UspesnoPorucivanjeModalComponent"],
                _e_shop_login_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_34__["RegistracijaModalComponent"],
                _e_shop_login_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_35__["ZaboravljenaSifraModalComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_http__WEBPACK_IMPORTED_MODULE_8__["HttpModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_22__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_10__["ReactiveFormsModule"],
                angular_webstorage_service__WEBPACK_IMPORTED_MODULE_2__["StorageServiceModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["BrowserAnimationsModule"],
                _shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__["MaterialModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_9__["AppRoutingModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_10__["FormsModule"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]],
            entryComponents: [
                _e_shop_login_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_35__["ZaboravljenaSifraModalComponent"],
                _e_shop_login_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_34__["RegistracijaModalComponent"],
                _e_shop_korpa_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_20__["IzmenaKolicineModalComponent"],
                _navigacija_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_23__["LogoutModalComponent"],
                _e_shop_korpa_uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_32__["UspesnoPorucivanjeModalComponent"]
            ]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/e-commerce/dasboard/dasboard.component.css":
/*!************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/dasboard.component.css ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".grid-container {\n  margin: 20px;\n}\n\n.dashboard-card {\n  position: absolute;\n  top: 15px;\n  left: 15px;\n  right: 15px;\n  bottom: 15px;\n}\n\n.more-button {\n  position: absolute;\n  top: 5px;\n  right: 10px;\n}\n\n.dashboard-card-content {\n  text-align: center;\n}"

/***/ }),

/***/ "./src/app/e-commerce/dasboard/dasboard.component.html":
/*!*************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/dasboard.component.html ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"grid-container\">\n  <h1 class=\"mat-h1\">Dashboard</h1>\n  <mat-grid-list cols=\"2\" rowHeight=\"350px\">\n    <mat-grid-tile *ngFor=\"let card of cards | async\" [colspan]=\"card.cols\" [rowspan]=\"card.rows\">\n      <mat-card class=\"dashboard-card\">\n        <mat-card-header>\n          <mat-card-title>\n            {{card.title}}\n            <button mat-icon-button class=\"more-button\" [matMenuTriggerFor]=\"menu\" aria-label=\"Toggle menu\">\n              <mat-icon>more_vert</mat-icon>\n            </button>\n            <mat-menu #menu=\"matMenu\" xPosition=\"before\">\n              <button mat-menu-item>Expand</button>\n              <button mat-menu-item>Remove</button>\n            </mat-menu>\n          </mat-card-title>\n        </mat-card-header>\n        <mat-card-content class=\"dashboard-card-content\">\n          <div>Card Content Here</div>\n        </mat-card-content>\n      </mat-card>\n    </mat-grid-tile>\n  </mat-grid-list>\n</div>"

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
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/cdk/layout */ "./node_modules/@angular/cdk/esm5/layout.es5.js");
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
    function DasboardComponent(breakpointObserver) {
        this.breakpointObserver = breakpointObserver;
        /** Based on the screen size, switch from standard to one column per row */
        this.cards = this.breakpointObserver.observe(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_2__["Breakpoints"].Handset).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (_a) {
            var matches = _a.matches;
            if (matches) {
                return [
                    { title: 'Card 1', cols: 1, rows: 1 },
                    { title: 'Card 2', cols: 1, rows: 1 },
                    { title: 'Card 3', cols: 1, rows: 1 },
                    { title: 'Card 4', cols: 1, rows: 1 }
                ];
            }
            return [
                { title: 'Card 1', cols: 2, rows: 1 },
                { title: 'Card 2', cols: 1, rows: 1 },
                { title: 'Card 3', cols: 1, rows: 2 },
                { title: 'Card 4', cols: 1, rows: 1 }
            ];
        }));
    }
    DasboardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-dasboard',
            template: __webpack_require__(/*! ./dasboard.component.html */ "./src/app/e-commerce/dasboard/dasboard.component.html"),
            styles: [__webpack_require__(/*! ./dasboard.component.css */ "./src/app/e-commerce/dasboard/dasboard.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_2__["BreakpointObserver"]])
    ], DasboardComponent);
    return DasboardComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.html":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.html ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <main>\r\n        <div *ngIf=\"faktura && fakturaDetalji && dataSource != null && dataSource.length > 0\">\r\n            <h1>Detalji fakture: {{faktura.orderId}}</h1>\r\n            <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n                <button class=\"button-glavni nazad-button\" mat-raised-button (click)=\"idiNazad()\">\r\n                    <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n                </button>\r\n            </div>\r\n\r\n            <div class=\"d-flex bd-highlight flex-sm-row flex-column detalji-div\">\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.status\" class=\"boja-kontra-bela\">Status: {{faktura.status.naziv}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Datum: {{faktura.vremePorucivanja | datum}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.nacinPlacanja\" class=\"boja-kontra-bela\">Nacin placanja:\r\n                            {{faktura.nacinPlacanja.naziv}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.nacinPrevoza\" class=\"boja-kontra-bela\">Nacin prevoza: {{\"prevoz_\" +\r\n                            faktura.nacinPrevoza.id | translate}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.adresa\" class=\"boja-kontra-bela\">Adresa: {{faktura.adresa.naziv}}</p>\r\n                    </label>\r\n                </div>\r\n            </div>\r\n            <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n                <table mat-table [dataSource]=\"dataSource\">\r\n\r\n                    <!-- Kataloski broj Column -->\r\n                    <ng-container matColumnDef=\"robaId\">\r\n                        <th mat-header-cell *matHeaderCellDef> Kataloski Broj </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{faktura.kataloskiBroj}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Kataloski broj Column -->\r\n                    <ng-container matColumnDef=\"proizvodjac\">\r\n                        <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1\">\r\n                                {{faktura.proizvodjac.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Narucena Kolicina Column -->\r\n                    <ng-container matColumnDef=\"kolicina\">\r\n                        <th mat-header-cell *matHeaderCellDef> Narucena Kolicina</th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1\">\r\n                                {{faktura.kolicina}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Potvrdjena Kolicina Column -->\r\n                    <ng-container matColumnDef=\"potvrdjenaKolicina\">\r\n                        <th mat-header-cell *matHeaderCellDef> Potvrdjena Kolicina </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1\">\r\n                                {{faktura.potvrdjenaKolicina}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Rabat Column -->\r\n                    <ng-container matColumnDef=\"rabat\">\r\n                        <th mat-header-cell *matHeaderCellDef> Rabat </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1\">\r\n                                {{faktura.rabat}}%\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"cena\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1 text-right iznos-margin\">\r\n                                {{faktura.cena | currency:\" \"}} RSD\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- tatus Column -->\r\n                    <ng-container matColumnDef=\"status\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\">Status</th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"text-center mat-body-1\">\r\n                                {{faktura.status.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n                    <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n                </table>\r\n                <div class=\"d-flex flex-column flex-sm-row\">\r\n                    <div class=\"d-flex flex-fill justify-content-end\">\r\n                    </div>\r\n                    <div class=\"d-flex flex-fill justify-content-end\">\r\n                        <table class=\"table sirina-cena\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td class=\"pozadina-glavna-50 boja-kontra-bela\">Ukupno za iznos: </td>\r\n                                    <td class=\"text-right\"><b>{{faktura.iznos | currency:\" \"}} RSD</b></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div *ngIf=\"dataSource == null || dataSource.length == 0\">\r\n            <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n                <button class=\"button-glavni nazad-button nazad-button-dole\" mat-raised-button (click)=\"idiNazad()\">\r\n                    <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n                </button>\r\n            </div>\r\n            <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n                <i class=\"material-icons icon-size\">\r\n                    error_outline\r\n                </i>\r\n                <h1 class=\"h1-upozorenje\">Porudzbenica je prazna</h1>\r\n            </div>\r\n        </div>\r\n        <div *ngIf=\"error\">\r\n            <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n                <button class=\"button-glavni nazad-button greska-button\" mat-raised-button (click)=\"idiNazad()\">\r\n                    <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n                </button>\r\n            </div>\r\n            <div class=\"d-flex flex-column prazna-tabela\">\r\n                <i class=\"material-icons icon-size\">\r\n                    error_outline\r\n                </i>\r\n                <h1 class=\"h1-upozorenje\">Porudzbenica ne postoji</h1>\r\n            </div>\r\n        </div>\r\n    </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.scss":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.scss ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  color: #283b4e;\n  font-size: 32px;\n  font-weight: bold;\n  margin-left: 6%;\n  margin-top: 25px; }\n\np {\n  font-size: 15px; }\n\ntable {\n  margin: 0px !important; }\n\n.nazad-button {\n  border-radius: 12px;\n  margin-right: 5%;\n  width: 120px !important;\n  height: 40px !important; }\n\n.nazad-button-dole {\n  top: 40px; }\n\n.greska-button {\n  position: relative;\n  top: 50px; }\n\n.detalji-div {\n  width: 90%;\n  margin-left: 5%; }\n\n.h1-upozorenje {\n  color: #8ea7b4 !important;\n  text-align: center;\n  font-size: 50px !important;\n  margin: 0% !important; }\n\n@media only screen and (max-device-width: 640px) {\n  .nazad-button {\n    border-radius: 12px;\n    margin-right: 0% !important; }\n  .nazad-button-dole {\n    top: 10px; }\n  .greska-button {\n    position: relative;\n    top: 5px; } }\n"

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
        this.error = false;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.displayedColumns = ['robaId', 'proizvodjac', 'kolicina', 'potvrdjenaKolicina',
            'rabat', 'cena', 'status'];
    }
    FakturaDetaljiComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.route.params.subscribe(function (params) {
            _this.fakturaServis.vratiFakturuPojedinacno(params.id, _this.partner.ppid)
                .subscribe(function (res) {
                _this.error = false;
                _this.faktura = res;
                _this.fakturaDetalji = res.detalji;
                _this.dataSource = _this.fakturaDetalji;
            }, function (error) {
                _this.error = true;
                console.log('Pronaci detalje fakture je bacilo gresku', error);
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

module.exports = "<div class=\"container-fluid\">\r\n    <main>\r\n        <div *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n            <h1>Moje porudzbenice</h1>\r\n            <div class=\"tabela-div\">\r\n                <table mat-table [dataSource]=\"dataSource\">\r\n\r\n                    <!-- Kataloski broj Column -->\r\n                    <ng-container matColumnDef=\"orderId\">\r\n                        <th mat-header-cell *matHeaderCellDef> Broj Fakture </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{faktura.orderId}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Kataloski broj proizvodjaca Column -->\r\n                    <ng-container matColumnDef=\"nacinPlacanja\">\r\n                        <th mat-header-cell *matHeaderCellDef> Nacin Placanja</th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1\">\r\n                                {{faktura.nacinPlacanja.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Naziv Column -->\r\n                    <ng-container matColumnDef=\"nacinPrevoza\">\r\n                        <th mat-header-cell *matHeaderCellDef> Nacin Prevoza </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1\">\r\n                                {{\"prevoz_\" + faktura.nacinPrevoza.id | translate}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Proizvodjac Column -->\r\n                    <ng-container matColumnDef=\"adresa\">\r\n                        <th mat-header-cell *matHeaderCellDef> Adresa </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1\">\r\n                                {{faktura.adresa.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"napomena\">\r\n                        <th mat-header-cell *matHeaderCellDef> Napomena </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1 napomena\">\r\n                                {{faktura.napomena | empty}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Broj stavki Column -->\r\n                    <ng-container matColumnDef=\"brojStavki\">\r\n                        <th mat-header-cell *matHeaderCellDef>Broj stavki</th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1\">\r\n                                {{faktura.brojStavki}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"iznos\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Ukupan iznos </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2 text-right iznos-margin\">\r\n                                {{faktura.iznos | currency:\" \"}} RSD\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Vreme porucivanja Column -->\r\n                    <ng-container matColumnDef=\"vremePorucivanja\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Datum </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1\" class=\"text-center\">\r\n                                {{faktura.vremePorucivanja | datum}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Status Column -->\r\n                    <ng-container matColumnDef=\"status\">\r\n                        <th mat-header-cell *matHeaderCellDef> Status </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{faktura.status.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Akcije Column -->\r\n                    <ng-container matColumnDef=\"ackije\">\r\n                        <th mat-header-cell *matHeaderCellDef> </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <button class=\"button-glavni\" mat-raised-button (click)=\"detaljiFakture(faktura.id)\">Detalji</button>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n                    <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n                </table>\r\n                <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n                    [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n                </mat-paginator>\r\n            </div>\r\n        </div>\r\n\r\n        <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"error\">\r\n            <i class=\"material-icons icon-size\">\r\n                error_outline\r\n            </i>\r\n            <h1 class=\"h1-upozorenje\">Istorija porucivanja je prazna</h1>\r\n        </div>\r\n    </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/faktura/faktura.component.scss":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura.component.scss ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  color: #283b4e;\n  font-size: 32px;\n  font-weight: bold;\n  margin-left: 6%;\n  margin-top: 25px; }\n\n.h1-upozorenje {\n  color: #8ea7b4 !important;\n  text-align: center;\n  font-size: 50px !important;\n  margin: 0% !important; }\n\n.napomena {\n  width: 300px; }\n"

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
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.displayedColumns = ['orderId', 'nacinPlacanja', 'nacinPrevoza',
            'adresa', 'napomena', 'brojStavki', 'iznos', 'vremePorucivanja', 'status', 'ackije'];
    }
    FakturaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.vratiFaktureKorisnika();
    };
    FakturaComponent.prototype.vratiFaktureKorisnika = function () {
        var _this = this;
        this.fakturaService.vratiFaktureKorisnika(this.pageIndex, this.rowsPerPage, this.partner.ppid)
            .subscribe(function (res) {
            _this.error = false;
            _this.fakure = res.content;
            _this.dataSource = _this.fakure;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.error = true;
            console.log('Pronaci fakture je bacilo gresku', error);
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

/***/ "./src/app/e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.html":
/*!*****************************************************************************************!*\
  !*** ./src/app/e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.html ***!
  \*****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n  <main>\r\n    <div class=\"pozadina-glavna-50 boja-kontra-bela\">\r\n      <h1>Artikal broj: {{data.katbr}}</h1>\r\n    </div>\r\n    <table class=\"table\">\r\n      <tbody>\r\n        <tr>\r\n          <td>Proizvodjac</td>\r\n          <td>{{data.proizvodjac.naziv}}</td>\r\n        </tr>\r\n        <tr>\r\n          <td>Cena</td>\r\n          <td>{{data.cenaKom | currency:\" \"}} RSD</td>\r\n        <tr>\r\n          <td>Kolicina</td>\r\n          <td>\r\n            <select class=\"custom-select custom-select-md\" [(ngModel)]=\"data.kolicina\">\r\n              <option *ngFor=\"let kolicina of stanje\" [value]=\"kolicina\">{{kolicina}}</option>\r\n            </select>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>Ukupno za placanje</td>\r\n          <td><b>{{data.kolicina * data.cenaKom | currency:\" \"}} RSD</b></td>\r\n        </tr>\r\n      </tbody>\r\n    </table>\r\n    <div class=\"d-flex flex-row justify-content-center\">\r\n      <button class=\"button-glavni\" mat-raised-button (click)=\"sacuvajIzmene()\">Sacuvaj</button>\r\n      <span class=\"col-2\"></span>\r\n      <button class=\"button-error\" mat-raised-button (click)=\"bezIzmena()\">Ponisti</button>\r\n    </div>\r\n  </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.scss":
/*!*****************************************************************************************!*\
  !*** ./src/app/e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.scss ***!
  \*****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "p {\n  text-align: center; }\n\nh1 {\n  text-align: center;\n  font-size: 20px;\n  padding: 10px; }\n\n.pomeri {\n  margin-left: 10px; }\n"

/***/ }),

/***/ "./src/app/e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.ts":
/*!***************************************************************************************!*\
  !*** ./src/app/e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.ts ***!
  \***************************************************************************************/
/*! exports provided: IzmenaKolicineModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "IzmenaKolicineModalComponent", function() { return IzmenaKolicineModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! lodash */ "./node_modules/lodash/lodash.js");
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _model_porudzbenica__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/porudzbenica */ "./src/app/e-shop/model/porudzbenica.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (undefined && undefined.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};




var IzmenaKolicineModalComponent = /** @class */ (function () {
    function IzmenaKolicineModalComponent(dialogRef, roba) {
        this.dialogRef = dialogRef;
        this.roba = roba;
        this.stanje = [];
    }
    IzmenaKolicineModalComponent.prototype.ngOnInit = function () {
        this.data = lodash__WEBPACK_IMPORTED_MODULE_2__["clone"](this.roba);
        this.popuniSelectStanja();
    };
    IzmenaKolicineModalComponent.prototype.popuniSelectStanja = function () {
        var index = 1;
        while (index <= this.data.stanje) {
            this.stanje[index - 1] = index;
            index++;
        }
    };
    IzmenaKolicineModalComponent.prototype.sacuvajIzmene = function () {
        this.data.kolicina = lodash__WEBPACK_IMPORTED_MODULE_2__["toNumber"](this.data.kolicina);
        this.data.cenaUkupno = this.data.kolicina * this.data.cenaKom;
        this.dialogRef.close(this.data);
    };
    IzmenaKolicineModalComponent.prototype.bezIzmena = function () {
        this.dialogRef.close();
    };
    IzmenaKolicineModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-izmena-kolicine-modal',
            template: __webpack_require__(/*! ./izmena-kolicine-modal.component.html */ "./src/app/e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.html"),
            styles: [__webpack_require__(/*! ./izmena-kolicine-modal.component.scss */ "./src/app/e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.scss")]
        }),
        __param(1, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MAT_DIALOG_DATA"])),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"],
            _model_porudzbenica__WEBPACK_IMPORTED_MODULE_3__["RobaKorpa"]])
    ], IzmenaKolicineModalComponent);
    return IzmenaKolicineModalComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/korpa/korpa.component.html":
/*!***************************************************!*\
  !*** ./src/app/e-shop/korpa/korpa.component.html ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"grid-container\">\r\n    <main>\r\n        <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"dataSource.length == 0\">\r\n            <i class=\"material-icons icon-size\">\r\n                shopping_cart\r\n            </i>\r\n            <h1 class=\"h1-upozorenje\">Korpa je trenutno prazna</h1>\r\n        </div>\r\n        <div class=\"tabela-div\" *ngIf=\"dataSource.length > 0\">\r\n            <div style=\"overflow-x:auto;\">\r\n                <table mat-table [dataSource]=\"dataSource\" class=\"mat-elevation-z8\">\r\n                    <!-- Kataloski broj Column -->\r\n                    <ng-container matColumnDef=\"katbr\">\r\n                        <th mat-header-cell *matHeaderCellDef> Kataloski broj </th>\r\n                        <td mat-cell *matCellDef=\"let roba\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{roba.katbr}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Kataloski broj proizvodjaca Column -->\r\n                    <ng-container matColumnDef=\"katbrpro\">\r\n                        <th mat-header-cell *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                        <td mat-cell *matCellDef=\"let roba\">\r\n                            <p class=\"mat-body-1\">\r\n                                {{roba.katbrpro}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Naziv Column -->\r\n                    <ng-container matColumnDef=\"naziv\">\r\n                        <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                        <td mat-cell *matCellDef=\"let roba\">\r\n                            <p class=\"mat-body-1\">\r\n                                {{roba.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Proizvodjac Column -->\r\n                    <ng-container matColumnDef=\"proizvodjac\">\r\n                        <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                        <td mat-cell *matCellDef=\"let roba\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{roba.proizvodjac.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"kolicina\">\r\n                        <th mat-header-cell *matHeaderCellDef> Kolicina </th>\r\n                        <td mat-cell *matCellDef=\"let roba\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{roba.kolicina}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"cena\">\r\n                        <th mat-header-cell *matHeaderCellDef> Ukupno </th>\r\n                        <td mat-cell *matCellDef=\"let roba\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{roba.cenaUkupno | currency:\" \"}} DIN\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Kolicina Column -->\r\n                    <ng-container matColumnDef=\"izbaciDugme\">\r\n                        <th mat-header-cell *matHeaderCellDef> </th>\r\n                        <td mat-cell *matCellDef=\"let roba; let i = index;\">\r\n                            <div class=\"d-flex flex-column flex-lg-row bd-highlight\">\r\n                                <div class=\"p-1 bd-highlight\">\r\n                                    <button class=\"button-glavni\" mat-raised-button (click)=\"otvoriDialog(roba)\">Izmeni</button>\r\n                                </div>\r\n                                <div class=\"p-1 bd-highlight\">\r\n                                    <button class=\"button-error\" mat-raised-button (click)='izbaciIzKorpe(i)'>Izbaci</button>\r\n                                </div>\r\n                            </div>\r\n\r\n                    </ng-container>\r\n\r\n                    <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n                    <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n                </table>\r\n            </div>\r\n            <div class=\"d-flex flex-column flex-xl-row\">\r\n                <div class=\"d-flex flex-column flex-xl-row flex-fill \">\r\n                    <div class=\"flex-fill\">\r\n                        <div class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                            <div *ngIf=\"nacinPlacanja && nacinPlacanja.length > 0\" class=\"granice\">\r\n                                <h3>Način plaćanja</h3>\r\n                                <hr>\r\n                                <mat-radio-group class=\"example-radio-group\" [(ngModel)]=\"izabranNacinPlacanja\">\r\n                                    <mat-radio-button color=\"primary\" class=\"example-radio-button\" *ngFor=\"let placanje of nacinPlacanja\"\r\n                                        [value]=\"placanje\">\r\n                                        {{placanje.naziv}}\r\n                                    </mat-radio-button>\r\n                                </mat-radio-group>\r\n                            </div>\r\n                        </div>\r\n                        <div *ngIf=\"nacinPrevoza && nacinPrevoza.length > 0\" class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                            <div class=\"granice visina-prevoza\">\r\n                                <h3>Način prevoza</h3>\r\n                                <hr>\r\n                                <mat-radio-group class=\"example-radio-group\" [(ngModel)]=\"izabranNacinPrevoza\">\r\n                                    <mat-radio-button color=\"primary\" class=\"example-radio-button\" *ngFor=\"let prevoz of nacinPrevoza\"\r\n                                        [value]=\"prevoz\">\r\n                                        {{\"prevoz_\" + prevoz.id | translate}}\r\n                                    </mat-radio-button>\r\n                                </mat-radio-group>\r\n                            </div>\r\n                            <div *ngIf=\"izabranNacinPrevoza.id === 2\" class=\"granice pomeri-dole\">\r\n                                <h4>Izaberite način dostave</h4>\r\n                                <mat-radio-group class=\"example-radio-group\" [(ngModel)]=\"izabranaTrecaLiceOpcija\">\r\n                                    <mat-radio-button color=\"primary\" class=\"example-radio-button\" *ngFor=\"let opcije of treceLiceOpcije\"\r\n                                        [value]=\"opcije\">\r\n                                        {{opcije}}\r\n                                    </mat-radio-button>\r\n                                </mat-radio-group>\r\n                                <div>\r\n                                    <div *ngIf=\"izabranaTrecaLiceOpcija === treceLiceOpcije[0]\">\r\n                                        <mat-form-field>\r\n                                            <mat-select placeholder=\"Kurirske sluzbe\" [(ngModel)]=\"izabraneKurirskeSluzbe\">\r\n                                                <mat-option *ngFor=\"let sluzbe of kurirskeSluzbe\" [value]=\"sluzbe\">\r\n                                                    {{sluzbe}}\r\n                                                </mat-option>\r\n                                            </mat-select>\r\n                                        </mat-form-field>\r\n                                    </div>\r\n                                    <div *ngIf=\"izabranaTrecaLiceOpcija === treceLiceOpcije[1]\">\r\n                                        <mat-form-field role=\"form\" [formGroup]=\"drugiNacinPrevoza\">\r\n                                            <textarea matInput #prevoz formControlName=\"prevoz\" placeholder=\"Upišite drugi način prevoza...\"></textarea>\r\n                                        </mat-form-field>\r\n                                        <div *ngIf=\"dugmeZaPorucivanjeStisnuto && d.prevoz.errors\">\r\n                                            <div *ngIf=\"d.prevoz.errors.required\">\r\n                                                <p class=\"upozorenje\">\r\n                                                    <p class=\"upozorenje\">Ovo polje je obavezno</p>\r\n                                            </div>\r\n                                            <div *ngIf=\"d.prevoz.errors.minlength\">\r\n                                                <p class=\"upozorenje\">\r\n                                                    <p class=\"upozorenje\">Minimalno 3 karaktera</p>\r\n                                            </div>\r\n                                        </div>\r\n                                    </div>\r\n                                </div>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                    <div class=\"flex-fill\">\r\n                        <div class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                            <div *ngIf=\"nacinPlacanja && nacinPlacanja.length > 0\" class=\"granice visina\">\r\n                                <h3>Napomena</h3>\r\n                                <hr>\r\n                                <mat-form-field>\r\n                                    <textarea matInput class=\"napomena\" [(ngModel)]=\"napomena\" placeholder=\"Unesite napomenu...\"></textarea>\r\n                                </mat-form-field>\r\n                            </div>\r\n                        </div>\r\n                        <div class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n\r\n                            <div *ngIf=\"nacinPlacanja && nacinPlacanja.length > 0\" class=\"granice\">\r\n                                <h3>Izaberite adresu dostave</h3>\r\n                                <hr>\r\n                                <mat-radio-group class=\"example-radio-group\" [(ngModel)]=\"izabraneAdresaDostave\">\r\n                                    <mat-radio-button color=\"primary\" class=\"example-radio-button\" *ngFor=\"let adresa of adresaDostave\"\r\n                                        [value]=\"adresa\">\r\n                                        {{adresa}}\r\n                                    </mat-radio-button>\r\n                                </mat-radio-group>\r\n                            </div>\r\n                            <div class=\"granice pomeri-dole\">\r\n                                <div *ngIf=\"izabraneAdresaDostave === adresaDostave[0]\" class=\"pomeri-dole\">\r\n                                    <h4>Adresa</h4>\r\n                                    <label> {{partner.adresa}}</label>\r\n                                </div>\r\n                                <div *ngIf=\"izabraneAdresaDostave === adresaDostave[1]\" class=\"pomeri-dole\">\r\n                                    <h4>Druga adresa dostave</h4>\r\n                                    <form role=\"form\" [formGroup]=\"adresaForm\">\r\n                                        <div>\r\n                                            <mat-form-field role=\"form\">\r\n                                                <input type=\"text\" #ulica formControlName=\"ulica\" matInput placeholder=\"Ulica i broj\">\r\n                                            </mat-form-field>\r\n                                        </div>\r\n                                        <div *ngIf=\"dugmeZaPorucivanjeStisnuto && a.ulica.errors\">\r\n                                            <div *ngIf=\"a.ulica.errors.required\">\r\n                                                <p class=\"upozorenje\">\r\n                                                    <p class=\"upozorenje\">Naziv ulice je obavezan</p>\r\n                                            </div>\r\n                                            <div *ngIf=\"a.ulica.errors.minlength\">\r\n                                                <p class=\"upozorenje\">\r\n                                                    <p class=\"upozorenje\">Naziv ulice mora imati minimalno 3 karaktera</p>\r\n                                            </div>\r\n                                        </div>\r\n                                        <div>\r\n                                            <mat-form-field role=\"form\">\r\n                                                <input type=\"text\" #grad formControlName=\"grad\" matInput placeholder=\"Grad\">\r\n                                            </mat-form-field>\r\n                                        </div>\r\n                                        <div *ngIf=\"dugmeZaPorucivanjeStisnuto && a.grad.errors\">\r\n                                            <div *ngIf=\"a.grad.errors.required\">\r\n                                                <p class=\"upozorenje\">\r\n                                                    <p class=\"upozorenje\">Naziv grada je obavezan</p>\r\n                                            </div>\r\n                                            <div *ngIf=\"a.grad.errors.minlength\">\r\n                                                <p class=\"upozorenje\">\r\n                                                    <p class=\"upozorenje\">Naziv grada mora imati minimalno 2 karaktera</p>\r\n                                            </div>\r\n                                        </div>\r\n                                    </form>\r\n                                </div>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n                <div class=\"d-flex flex-fill flex-column\">\r\n                    <table class=\"table sirina-cena\">\r\n                        <tbody>\r\n                            <tr>\r\n                                <td class=\"pozadina-glavna-50 boja-kontra-bela\">Bez pdv-a: </td>\r\n                                <td class=\"text-right\">{{bezPdv | currency:\" \"}} RSD</td>\r\n                            </tr>\r\n                            <tr>\r\n                                <td class=\"pozadina-glavna-50 boja-kontra-bela\">Pdv: </td>\r\n                                <td class=\"text-right\">{{pdv | currency:\" \"}} RSD</td>\r\n                            </tr>\r\n                            <tr>\r\n                                <td class=\"pozadina-glavna-50 boja-kontra-bela\">Ukupno za uplatu: </td>\r\n                                <td class=\"text-right\"><b>{{ukupno | currency:\" \"}} RSD</b></td>\r\n                            </tr>\r\n                        </tbody>\r\n                    </table>\r\n                    <div>\r\n                        <button class=\"button-glavni dugme-sirina float-right\" mat-raised-button (click)=\"posaljiPorudzbinu(roba)\">Potvrdi</button>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/korpa/korpa.component.scss":
/*!***************************************************!*\
  !*** ./src/app/e-shop/korpa/korpa.component.scss ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "p {\n  text-align: left !important; }\n\nh3 {\n  font-size: 20px;\n  font-weight: bold;\n  padding-left: 10px;\n  padding-top: 10px;\n  color: #3e5e9e; }\n\nhr {\n  width: 90%;\n  margin-bottom: 5px;\n  margin-top: 5px; }\n\nh4 {\n  font-size: 16px;\n  font-weight: bold;\n  padding-left: 10px;\n  color: #3e5e9e; }\n\ntextarea {\n  font-size: 15px;\n  color: #283b4e; }\n\nlabel {\n  font-size: 15px;\n  color: #283b4e;\n  font-weight: bold; }\n\n.example-radio-group {\n  display: inline-flex;\n  flex-direction: column; }\n\n.example-radio-button {\n  margin: 2px;\n  font-size: 14px !important; }\n\n.example-selected-value {\n  margin: 15px 0; }\n\n.sirina-cena {\n  width: 95%; }\n\n.dugme-sirina {\n  width: 150px;\n  height: 40px;\n  border-radius: 5px; }\n\n.granice {\n  box-shadow: 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);\n  background-color: white;\n  padding-left: 5px;\n  width: 95%;\n  margin: 5px; }\n\n.pomeri-dole {\n  margin-top: 5px; }\n\n.pomeri-dole {\n  margin-top: 0px; }\n\n.upozorenje {\n  text-align: left;\n  font-family: sans-serif;\n  font-size: 12px;\n  color: red;\n  margin-top: -15px;\n  margin-bottom: 0px; }\n\n.visina {\n  height: 180px; }\n\n.visina-prevoza {\n  height: 177px; }\n\n.napomena {\n  height: 80px; }\n\n@media only screen and (max-device-width: 640px) {\n  .sirina-cena {\n    width: 95%;\n    margin-left: 2%; } }\n"

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
/* harmony import */ var _izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./izmena-kolicine-modal/izmena-kolicine-modal.component */ "./src/app/e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../model/dto */ "./src/app/e-shop/model/dto.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _service_faktura_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../service/faktura.service */ "./src/app/e-shop/service/faktura.service.ts");
/* harmony import */ var _uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./uspesno-porucivanje-modal/uspesno-porucivanje-modal.component */ "./src/app/e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
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
        this.kurirskeSluzbe = ['Aks', 'Beks', 'City'];
        this.adresaDostave = ['Vaša adresa', 'Druga'];
        this.ucitavanje = false;
        this.alive = true;
    }
    KorpaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
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
            prevoz: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_8__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_8__["Validators"].minLength(3)]]
        });
        this.adresaForm = this.formBuilder.group({
            ulica: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_8__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_8__["Validators"].minLength(3)]],
            grad: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_8__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_8__["Validators"].minLength(2)]]
        });
    };
    KorpaComponent.prototype.vratiOpsteInformacije = function () {
        var _this = this;
        var vrsteInformacije = ['placanje', 'prevoz'];
        vrsteInformacije.forEach(function (vrsta) {
            _this.dataService.vratiOpsteInformacije(vrsta).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_6__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["finalize"])(function () { return _this.ucitavanje = false; }))
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
                console.log('Podnaci informaciju je izbacilo gresku izbacilo je gresko');
            });
        });
    };
    KorpaComponent.prototype.izbaciIzKorpe = function (index) {
        this.dataService.izbaciIzKorpe(index);
        this.table.renderRows();
    };
    KorpaComponent.prototype.otvoriDialog = function (roba) {
        var _this = this;
        var dialogRef = this.dialog.open(_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_4__["IzmenaKolicineModalComponent"], {
            width: '400px',
            data: roba
        });
        dialogRef.afterClosed().subscribe(function (result) {
            console.log('The dialog was closed');
            if (result) {
                _this.promeniKolicinuArtikla(result);
            }
        });
    };
    KorpaComponent.prototype.otvoriDialogUspesnoPorucivanje = function (faktura) {
        var _this = this;
        var dialogRef = this.dialog.open(_uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_11__["UspesnoPorucivanjeModalComponent"], {
            width: '400px',
            data: faktura
        });
        dialogRef.afterClosed().subscribe(function (result) {
            console.log('The dialog was closed');
            _this.router.navigate(['/naslovna']);
        });
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
        this.fakturaServis.sacuvajFakturu(this.faktura).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_6__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.faktura = res;
            _this.otvoriDialogUspesnoPorucivanje(_this.faktura);
            _this.dataService.ocistiKorpu();
            _this.router.navigate(['/naslovna']);
        }, function (error) {
            console.log('Cuvaj fakturu u bazi');
        });
        console.log('Kora za porudzbinu  ' + JSON.stringify(this.faktura));
        console.log('Porucivanje je uspesno! :)');
    };
    KorpaComponent.prototype.korpaUFakturu = function () {
        var _this = this;
        this.faktura = new _model_dto__WEBPACK_IMPORTED_MODULE_7__["Fakutra"]();
        this.faktura.adresa = this.napraviIPopuniValueHelp(this.partner.ppid);
        this.faktura.nacinPlacanja = this.napraviIPopuniValueHelp(this.korpa.nacinPlacanja);
        this.faktura.nacinPrevoza = this.napraviIPopuniValueHelp(this.korpa.nacinIsporuke);
        this.faktura.napomena = this.korpa.napomena;
        this.faktura.iznos = this.korpa.ukupno;
        this.faktura.detalji = [];
        this.korpa.roba.forEach(function (roba) {
            _this.faktura.detalji.push(_this.popuniStavke(roba));
        });
    };
    KorpaComponent.prototype.popuniStavke = function (roba) {
        var stavka = new _model_dto__WEBPACK_IMPORTED_MODULE_7__["FakturaDetalji"]();
        stavka.kataloskiBroj = roba.katbr;
        stavka.proizvodjac = roba.proizvodjac;
        stavka.kolicina = roba.kolicina;
        stavka.rabat = roba.rabat;
        stavka.robaId = roba.robaid;
        stavka.cena = roba.cenaKom;
        return stavka;
    };
    KorpaComponent.prototype.napraviIPopuniValueHelp = function (id) {
        var valueHelp = new _model_dto__WEBPACK_IMPORTED_MODULE_7__["ValueHelp"]();
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
            var adresaDostave = void 0;
            if (this.izabranaTrecaLiceOpcija === this.treceLiceOpcije[0]) {
                adresaDostave = this.adresaForm.controls.ulica.value + ', ' + this.adresaForm.controls.grad.value;
            }
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
            _service_login_service__WEBPACK_IMPORTED_MODULE_9__["LoginService"],
            _service_data_local_storage_service__WEBPACK_IMPORTED_MODULE_2__["LocalStorageService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatDialog"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_8__["FormBuilder"],
            _service_faktura_service__WEBPACK_IMPORTED_MODULE_10__["FakturaService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_12__["Router"]])
    ], KorpaComponent);
    return KorpaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.html":
/*!*************************************************************************************************!*\
  !*** ./src/app/e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.html ***!
  \*************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n  <main class=\"text-center\">\r\n      <p>Porudžbina je uspešno poslata.</p>\r\n      <p>Broj porudžbine je <b>{{faktura.orderId}}</b></p>\r\n    <div class=\"d-flex flex-row justify-content-center\">\r\n      <button mat-raised-button class=\"button-glavni pomeri\" (click)=\"zatvori()\">Zatvori</button>\r\n      </div>\r\n  </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.scss":
/*!*************************************************************************************************!*\
  !*** ./src/app/e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.scss ***!
  \*************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "p {\n  color: #283b4e !important;\n  font-size: 17px !important; }\n\n.pomeri {\n  margin-top: 15px; }\n"

/***/ }),

/***/ "./src/app/e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.ts":
/*!***********************************************************************************************!*\
  !*** ./src/app/e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.ts ***!
  \***********************************************************************************************/
/*! exports provided: UspesnoPorucivanjeModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UspesnoPorucivanjeModalComponent", function() { return UspesnoPorucivanjeModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../model/dto */ "./src/app/e-shop/model/dto.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (undefined && undefined.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};



var UspesnoPorucivanjeModalComponent = /** @class */ (function () {
    function UspesnoPorucivanjeModalComponent(dialogRef, faktura) {
        this.dialogRef = dialogRef;
        this.faktura = faktura;
    }
    UspesnoPorucivanjeModalComponent.prototype.ngOnInit = function () {
        this.data = this.faktura;
    };
    UspesnoPorucivanjeModalComponent.prototype.zatvori = function () {
        this.dialogRef.close();
    };
    UspesnoPorucivanjeModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-uspesno-porucivanje-modal',
            template: __webpack_require__(/*! ./uspesno-porucivanje-modal.component.html */ "./src/app/e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.html"),
            styles: [__webpack_require__(/*! ./uspesno-porucivanje-modal.component.scss */ "./src/app/e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.scss")]
        }),
        __param(1, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MAT_DIALOG_DATA"])),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"],
            _model_dto__WEBPACK_IMPORTED_MODULE_2__["Fakutra"]])
    ], UspesnoPorucivanjeModalComponent);
    return UspesnoPorucivanjeModalComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/login/login.component.css":
/*!**************************************************!*\
  !*** ./src/app/e-shop/login/login.component.css ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".flex-login {\r\n    margin-top: 10%;\r\n    display: flex;\r\n    justify-content: center;\r\n}\r\n.login-form {\r\n    width: 400px;\r\n    justify-content: center;\r\n}\r\nh1 {\r\n    text-align: center;\r\n\tfont-family: serif;\r\n\tfont-weight: normal;\r\n\ttext-transform: uppercase;\r\n}\r\nbutton{\r\n    margin:auto;\r\n    display:block;\r\n}\r\np {\r\n      text-align: center;\r\n      font-family: sans-serif;\r\n      padding: 0;\r\n      margin: 0;\r\n}\r\n.is-invalid {\r\n    border: 1px solid red;\r\n}\r\n.upozorenje {\r\n    text-align: left;\r\n    font-family: sans-serif;\r\n    font-size: 14px;\r\n    color: red;\r\n\r\n}"

/***/ }),

/***/ "./src/app/e-shop/login/login.component.html":
/*!***************************************************!*\
  !*** ./src/app/e-shop/login/login.component.html ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n\t<div class=\"flex-login\">\r\n\t\t<div class=\"login-form\">\r\n\t\t\t<h1>Prijavi se</h1>\r\n\t\t\t<div class=\"alert alert-danger\" role=\"alert\" *ngIf=\"!uspesnoLogovanje\">\r\n\t\t\t\t<p>Username ili password je pogresan.</p>\r\n\t\t\t</div>\r\n\t\t\t<form role=\"form\" [formGroup]=\"registerForm\">\r\n\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t<input type=\"text\" formControlName=\"username\" class=\"form-control rounded\" placeholder=\"Vaše korisničko ime\" id=\"username\"\r\n\t\t\t\t\t name=\"username\" [ngClass]=\"{ 'is-invalid': submitted && registerForm.controls.username.errors }\" [(ngModel)]=\"credentials.username\" />\r\n\t\t\t\t\t<div *ngIf=\"submitted && registerForm.controls.username.errors\">\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.username.errors.required\">\r\n\t\t\t\t\t\t\t<p class=\"upozorenje\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Korisnicko ime je obavezno</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.username.errors.minlength\">\r\n\t\t\t\t\t\t\t<p class=\"upozorenje\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Korisnicko ime mora imati minimalno 3 karaktera</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t<input type=\"password\" formControlName=\"password\" class=\"form-control rounded\" placeholder=\"Šifra\" id=\"password\"\r\n\t\t\t\t\t name=\"password\" [(ngModel)]=\"credentials.password\" [ngClass]=\"{ 'is-invalid': submitted && registerForm.controls.password.errors }\" />\r\n\t\t\t\t\t<div *ngIf=\"submitted && registerForm.controls.password.errors\">\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.password.errors.required\">\r\n\t\t\t\t\t\t\t<p class=\"upozorenje\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Šifra je obavezna</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.password.errors.minlength\">\r\n\t\t\t\t\t\t\t<p class=\"upozorenje\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Šifra mora imati minimalno 3 karaktera</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"d-flex\">\r\n\t\t\t\t\t<button mat-button (click)=\"otvoriResgracijaDialog()\" color=\"primary\">Nemate nalog?</button>\r\n\t\t\t\t\t<button mat-raised-button (click)=\"login()\" class=\"rounded\" color=\"primary\">Prijava</button>\r\n\t\t\t\t\t<button mat-button (click)=\"otvoriZaboravljenuSifruDialog()\" color=\"primary\">Zaboravili ste šifru?</button>\r\n\t\t\t\t</div>\r\n\t\t\t</form>\r\n\t\t</div>\r\n\t</div>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/login/login.component.ts":
/*!*************************************************!*\
  !*** ./src/app/e-shop/login/login.component.ts ***!
  \*************************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./registracija-modal/registracija-modal.component */ "./src/app/e-shop/login/registracija-modal/registracija-modal.component.ts");
/* harmony import */ var _zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./zaboravljena-sifra-modal/zaboravljena-sifra-modal.component */ "./src/app/e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var LoginComponent = /** @class */ (function () {
    function LoginComponent(loginServis, formBuilder, dialog) {
        this.loginServis = loginServis;
        this.formBuilder = formBuilder;
        this.dialog = dialog;
        this.submitted = false;
        this.credentials = {};
        this.uspesnoLogovanje = true;
    }
    LoginComponent.prototype.ngOnInit = function () {
        this.registerForm = this.formBuilder.group({
            username: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].minLength(3)]],
            password: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].minLength(3)]]
        });
    };
    Object.defineProperty(LoginComponent.prototype, "f", {
        // convenience getter for easy access to form fields
        get: function () { return this.registerForm.controls; },
        enumerable: true,
        configurable: true
    });
    LoginComponent.prototype.login = function () {
        var _this = this;
        this.submitted = true;
        // stop here if form is invalid
        if (this.registerForm.invalid) {
            return;
        }
        this.loginServis.ulogujSe(this.credentials);
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.loginServis.daLiJeLogovanjeUspesno.subscribe(function (b) { return _this.uspesnoLogovanje = b; });
    };
    LoginComponent.prototype.otvoriResgracijaDialog = function () {
        var dialogRef = this.dialog.open(_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_4__["RegistracijaModalComponent"], {
            width: '400px'
        });
    };
    LoginComponent.prototype.otvoriZaboravljenuSifruDialog = function () {
        var dialogRef = this.dialog.open(_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_5__["ZaboravljenaSifraModalComponent"], {
            width: '400px'
        });
    };
    LoginComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/e-shop/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/e-shop/login/login.component.css")]
        }),
        __metadata("design:paramtypes", [_service_login_service__WEBPACK_IMPORTED_MODULE_1__["LoginService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatDialog"]])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/login/registracija-modal/registracija-modal.component.html":
/*!***********************************************************************************!*\
  !*** ./src/app/e-shop/login/registracija-modal/registracija-modal.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\n  <mat-horizontal-stepper [linear]=\"true\" #stepper>\n    <mat-step>\n      <ng-template matStepLabel>Vrsta</ng-template>\n      <mat-radio-group class=\"radio-group\" [(ngModel)]=\"vrstaRegistracije\">\n        <mat-radio-button color=\"primary\" *ngFor=\"let registracija of registracije\" [value]=\"registracija\">\n          {{registracija}}\n        </mat-radio-button>\n      </mat-radio-group>\n      <div>\n        <button mat-button color=\"primary\" (click)=\"odrediFormu()\" matStepperNext>Dalje</button>\n      </div>\n    </mat-step>\n    <mat-step [stepControl]=\"odredjenaForma\">\n      <ng-template matStepLabel>Forma</ng-template>\n      <form role=\"form\" [formGroup]=\"privatnoLiceForm\" *ngIf=\"vrstaRegistracije == registracije[0]\">\n        <mat-form-field class=\"example-full-width\">\n          <input #imeIPrezime formControlName=\"imeIPrezime\" matInput placeholder=\"Ime i prezime\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && privatno.imeIPrezime.errors\">\n          <div *ngIf=\"privatno.imeIPrezime.errors.required\">\n            <p class=\"upozorenje\">Ime i prezime je obavezno</p>\n          </div>\n          <div *ngIf=\"privatno.imeIPrezime.errors.minlength\">\n            <p class=\"upozorenje\">Ime i prezime mora imati minimalno 3 karaktera</p>\n          </div>\n        </div>\n\n        <mat-form-field class=\"example-full-width\">\n          <input #grad formControlName=\"grad\" matInput placeholder=\"Grad\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && privatno.grad.errors\">\n          <div *ngIf=\"privatno.grad.errors.required\">\n            <p class=\"upozorenje\">Naziv grada je obavezan</p>\n          </div>\n          <div *ngIf=\"privatno.grad.errors.minlength\">\n            <p class=\"upozorenje\">Grad mora imati minimalno 2 karaktera</p>\n          </div>\n        </div>\n\n        <mat-form-field class=\"example-full-width\">\n          <input #adresa formControlName=\"adresa\" matInput placeholder=\"Adresa\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && privatno.adresa.errors\">\n          <div *ngIf=\"privatno.adresa.errors.required\">\n            <p class=\"upozorenje\">Adresa je obavezna</p>\n          </div>\n          <div *ngIf=\"privatno.adresa.errors.minlength\">\n            <p class=\"upozorenje\">Adresa mora imati minimalno 3 karaktera</p>\n          </div>\n        </div>\n\n        <mat-form-field class=\"example-full-width\">\n          <input #email formControlName=\"email\" matInput type=\"email\" placeholder=\"Email\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && privatno.email.errors\">\n          <div *ngIf=\"privatno.email.errors.required\">\n            <p class=\"upozorenje\">Email je obavezan</p>\n          </div>\n          <div *ngIf=\"privatno.email.errors.email\">\n            <p class=\"upozorenje\">Email nije validan</p>\n          </div>\n        </div>\n\n        <mat-form-field class=\"example-full-width\">\n          <input #kontaktTelefon formControlName=\"kontaktTelefon\" matInput type=\"tel\" placeholder=\"Broj telefona\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && privatno.kontaktTelefon.errors\">\n          <div *ngIf=\"privatno.kontaktTelefon.errors.required\">\n            <p class=\"upozorenje\">Broj telefona je obavezan</p>\n          </div>\n          <div *ngIf=\"privatno.kontaktTelefon.errors.minlength\">\n            <p class=\"upozorenje\">Broj telefona mora imati vise od 5 karakera</p>\n          </div>\n        </div>\n\n      </form>\n      <form role=\"form\" [formGroup]=\"parvnoLiceForm\" *ngIf=\"vrstaRegistracije == registracije[1]\">\n        <mat-form-field class=\"example-full-width\">\n          <input #grad formControlName=\"nazivFirme\" matInput placeholder=\"Naziv firme\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && pravno.nazivFirme.errors\">\n          <div *ngIf=\"pravno.nazivFirme.errors.required\">\n            <p class=\"upozorenje\">Naziv firme je obavezan</p>\n          </div>\n          <div *ngIf=\"pravno.nazivFirme.errors.minlength\">\n            <p class=\"upozorenje\">Ime i prezime mora imati minimalno 3 karaktera</p>\n          </div>\n        </div>\n        <mat-form-field class=\"example-full-width\">\n          <input #pib formControlName=\"pib\" matInput placeholder=\"Pib\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && pravno.pib.errors\">\n          <div *ngIf=\"pravno.pib.errors.required\">\n            <p class=\"upozorenje\">Pib je obavezan</p>\n          </div>\n          <div *ngIf=\"pravno.pib.errors.minlength\">\n            <p class=\"upozorenje\">Pib mora imati minimalno 3 karaktera</p>\n          </div>\n        </div>\n\n        <mat-form-field class=\"example-full-width\">\n          <input #grad formControlName=\"grad\" matInput placeholder=\"Grad\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && pravno.grad.errors\">\n          <div *ngIf=\"pravno.grad.errors.required\">\n            <p class=\"upozorenje\">Naziv grada je obavezan</p>\n          </div>\n          <div *ngIf=\"pravno.grad.errors.minlength\">\n            <p class=\"upozorenje\">Grad mora imati minimalno 2 karaktera</p>\n          </div>\n        </div>\n\n        <mat-form-field class=\"example-full-width\">\n          <input #adresa formControlName=\"adresa\" matInput placeholder=\"Adresa\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && pravno.adresa.errors\">\n          <div *ngIf=\"pravno.adresa.errors.required\">\n            <p class=\"upozorenje\">Adresa je obavezna</p>\n          </div>\n          <div *ngIf=\"pravno.adresa.errors.minlength\">\n            <p class=\"upozorenje\">Adresa mora imati minimalno 3 karaktera</p>\n          </div>\n        </div>\n\n        <mat-form-field class=\"example-full-width\">\n          <input #email formControlName=\"email\" matInput type=\"email\" placeholder=\"Email\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && pravno.email.errors\">\n          <div *ngIf=\"pravno.email.errors.required\">\n            <p class=\"upozorenje\">Email je obavezan</p>\n          </div>\n          <div *ngIf=\"pravno.email.errors.email\">\n            <p class=\"upozorenje\">Email nije validan</p>\n          </div>\n        </div>\n        <mat-form-field class=\"example-full-width\">\n          <input #kontaktTelefon formControlName=\"kontaktTelefon\" matInput type=\"tel\" placeholder=\"Broj telefona\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && pravno.kontaktTelefon.errors\">\n          <div *ngIf=\"pravno.kontaktTelefon.errors.required\">\n            <p class=\"upozorenje\">Telefon je obavezan</p>\n          </div>\n          <div *ngIf=\"pravno.kontaktTelefon.errors.minlength\">\n            <p class=\"upozorenje\">>Telefon mora imati minimalno 5 karaktera</p>\n          </div>\n        </div>\n      </form>\n      <div>\n        <button mat-button matStepperPrevious>Nazad</button>\n        <button mat-button color=\"primary\" (click)=\"registracijaKorisnika()\" matStepperNext>Registruj se</button>\n      </div>\n    </mat-step>\n    <mat-step>\n      <ng-template matStepLabel>Done</ng-template>\n      <h2>Registracija je uspešno poslata</h2>\n      <p> U narednih 24h vaš zahtev će biti obradjen i dobićete mail sa detaljima vašeg naloga.</p>\n      <div>\n        <button mat-button color=\"primary\" (click)=\"zatvoriDialog()\">Zatvori</button>\n      </div>\n    </mat-step>\n  </mat-horizontal-stepper>\n</main>"

/***/ }),

/***/ "./src/app/e-shop/login/registracija-modal/registracija-modal.component.scss":
/*!***********************************************************************************!*\
  !*** ./src/app/e-shop/login/registracija-modal/registracija-modal.component.scss ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h2 {\n  color: #283b4e !important;\n  font-size: 18px;\n  padding-bottom: 10px; }\n\np {\n  font-size: 16px;\n  text-align: left;\n  font-family: inherit; }\n\n.radio-group {\n  display: inline-flex;\n  flex-direction: column; }\n\n.example-full-width {\n  width: 100%; }\n\n.upozorenje {\n  text-align: left;\n  font-family: sans-serif;\n  font-size: 12px;\n  color: red;\n  margin-top: -15px;\n  margin-bottom: 0px; }\n"

/***/ }),

/***/ "./src/app/e-shop/login/registracija-modal/registracija-modal.component.ts":
/*!*********************************************************************************!*\
  !*** ./src/app/e-shop/login/registracija-modal/registracija-modal.component.ts ***!
  \*********************************************************************************/
/*! exports provided: RegistracijaModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RegistracijaModalComponent", function() { return RegistracijaModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/dto */ "./src/app/e-shop/model/dto.ts");
/* harmony import */ var _service_email_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../service/email.service */ "./src/app/e-shop/service/email.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var RegistracijaModalComponent = /** @class */ (function () {
    function RegistracijaModalComponent(dialogRef, formBuilder, emailService) {
        this.dialogRef = dialogRef;
        this.formBuilder = formBuilder;
        this.emailService = emailService;
        this.registracije = ['Fizičko lice', 'Pravno lice'];
        this.formaSubmited = false;
        this.registracija = new _model_dto__WEBPACK_IMPORTED_MODULE_3__["Registracija"]();
        this.alive = true;
        this.ucitavanje = false;
    }
    RegistracijaModalComponent.prototype.ngOnInit = function () {
        this.vrstaRegistracije = this.registracije[0];
        this.inicijalizujSveRegistracioneForme();
    };
    RegistracijaModalComponent.prototype.inicijalizujSveRegistracioneForme = function () {
        this.privatnoLiceForm = this.formBuilder.group({
            imeIPrezime: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]],
            grad: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(2)]],
            adresa: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]],
            email: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].email]],
            kontaktTelefon: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(5)]]
        });
        this.parvnoLiceForm = this.formBuilder.group({
            nazivFirme: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]],
            pib: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]],
            grad: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(2)]],
            adresa: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]],
            email: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].email]],
            kontaktTelefon: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(5)]]
        });
    };
    RegistracijaModalComponent.prototype.registracijaKorisnika = function () {
        var _this = this;
        this.formaSubmited = true;
        if (this.vrstaRegistracije === this.registracije[0]) {
            if (this.privatnoLiceForm.invalid) {
                return;
            }
            else {
                this.registracija = new _model_dto__WEBPACK_IMPORTED_MODULE_3__["Registracija"]();
                this.popuniRegistracijuZaPrivatnaLica();
            }
        }
        else {
            if (this.parvnoLiceForm.invalid) {
                return;
            }
            else {
                this.registracija = new _model_dto__WEBPACK_IMPORTED_MODULE_3__["Registracija"]();
                this.popuniRegistracijuZaPravnaLica();
            }
        }
        this.emailService.posaljiMailZaRegistraciju(this.registracija).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_6__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["finalize"])(function () { return _this.ucitavanje = false; })).subscribe(function (res) {
            console.log('Mail uspesno poslat');
        }, function (error) {
            console.log('Error pri slanju registracionog maila', error);
        });
    };
    RegistracijaModalComponent.prototype.odrediFormu = function () {
        if (this.vrstaRegistracije === this.registracije[0]) {
            this.odredjenaForma = this.privatnoLiceForm;
        }
        else {
            this.odredjenaForma = this.parvnoLiceForm;
        }
    };
    RegistracijaModalComponent.prototype.popuniRegistracijuZaPrivatnaLica = function () {
        this.registracija.imeIPrezime = this.privatno.imeIPrezime.value;
        this.registracija.grad = this.privatno.grad.value;
        this.registracija.adresa = this.privatno.adresa.value;
        this.registracija.email = this.privatno.email.value;
        this.registracija.kontaktTelefon = this.privatno.kontaktTelefon.value;
        this.registracija.daLiJePravnoLice = false;
    };
    RegistracijaModalComponent.prototype.popuniRegistracijuZaPravnaLica = function () {
        this.registracija.nazivFirme = this.pravno.nazivFirme.value;
        this.registracija.pib = this.pravno.pib.value;
        this.registracija.grad = this.pravno.grad.value;
        this.registracija.adresa = this.pravno.adresa.value;
        this.registracija.email = this.pravno.email.value;
        this.registracija.kontaktTelefon = this.pravno.kontaktTelefon.value;
        this.registracija.daLiJePravnoLice = true;
    };
    RegistracijaModalComponent.prototype.zatvoriDialog = function () {
        this.dialogRef.close();
    };
    Object.defineProperty(RegistracijaModalComponent.prototype, "privatno", {
        // convenience getter for easy access to form fields
        get: function () { return this.privatnoLiceForm.controls; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(RegistracijaModalComponent.prototype, "pravno", {
        get: function () { return this.parvnoLiceForm.controls; },
        enumerable: true,
        configurable: true
    });
    RegistracijaModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-registracija-modal',
            template: __webpack_require__(/*! ./registracija-modal.component.html */ "./src/app/e-shop/login/registracija-modal/registracija-modal.component.html"),
            styles: [__webpack_require__(/*! ./registracija-modal.component.scss */ "./src/app/e-shop/login/registracija-modal/registracija-modal.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogRef"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"],
            _service_email_service__WEBPACK_IMPORTED_MODULE_4__["EmailService"]])
    ], RegistracijaModalComponent);
    return RegistracijaModalComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.html":
/*!***********************************************************************************************!*\
  !*** ./src/app/e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.html ***!
  \***********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\n  <section *ngIf=\"!mailUspesnoPoslat\">\n    <h1>Pronađi svoj Automaterijal nalog</h1>\n    <p>Unesi svoju e-postu</p>\n    <form role=\"form\" [formGroup]=\"zaboravljeSifraForma\">\n      <mat-form-field class=\"email-input\">\n        <input #email formControlName=\"email\" matInput type=\"email\" placeholder=\"Vaša e-pošta\">\n      </mat-form-field>\n      <div *ngIf=\"formaSubmited && zaboravljeno.email.errors\">\n        <div *ngIf=\"zaboravljeno.email.errors.required\">\n          <p class=\"upozorenje\">Email je obavezan</p>\n        </div>\n        <div *ngIf=\"zaboravljeno.email.errors.email\">\n          <p class=\"upozorenje\">Email nije validan</p>\n        </div>\n      </div>\n      <div class=\"pomeri-dole\">\n        <button mat-raised-button (click)=\"posaljiMailZaboravljenaSifra()\" class=\"button-glavni\">Potvrdi</button>\n      </div>\n    </form>\n  </section>\n  <section *ngIf=\"mailUspesnoPoslat\">\n    <h1>Mail uspešno poslat</h1>\n    <p>Uskoro će vam stići mail sa linkom gde možete promeniti vašu šifru.</p>\n    <div class=\"pomeri-dole\">\n        <button mat-raised-button (click)=\"zatvoriDialog()\" class=\"button-glavni\">Zatvori</button>\n      </div>\n  </section>\n</main>"

/***/ }),

/***/ "./src/app/e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.scss":
/*!***********************************************************************************************!*\
  !*** ./src/app/e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.scss ***!
  \***********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  color: #283b4e !important;\n  font-size: 19px;\n  font-weight: bold;\n  margin-bottom: 25px; }\n\np {\n  font-size: 17px;\n  margin-bottom: 10px;\n  font-family: inherit; }\n\n.email-input {\n  width: 80%; }\n\n.upozorenje {\n  text-align: left;\n  font-family: sans-serif;\n  font-size: 12px;\n  color: red;\n  margin-top: -15px;\n  margin-bottom: 0px; }\n\n.pomeri-dole {\n  margin-top: 10px; }\n"

/***/ }),

/***/ "./src/app/e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.ts":
/*!*********************************************************************************************!*\
  !*** ./src/app/e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.ts ***!
  \*********************************************************************************************/
/*! exports provided: ZaboravljenaSifraModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ZaboravljenaSifraModalComponent", function() { return ZaboravljenaSifraModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _service_email_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../service/email.service */ "./src/app/e-shop/service/email.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../model/dto */ "./src/app/e-shop/model/dto.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var ZaboravljenaSifraModalComponent = /** @class */ (function () {
    function ZaboravljenaSifraModalComponent(dialogRef, formBuilder, emailService, snackBar) {
        this.dialogRef = dialogRef;
        this.formBuilder = formBuilder;
        this.emailService = emailService;
        this.snackBar = snackBar;
        this.resetSifre = new _model_dto__WEBPACK_IMPORTED_MODULE_6__["ResetSifre"]();
        this.mailUspesnoPoslat = false;
        this.formaSubmited = false;
        this.alive = true;
        this.ucitavanje = false;
    }
    ZaboravljenaSifraModalComponent.prototype.ngOnInit = function () {
        this.inicijalizujSveRegistracioneForme();
    };
    ZaboravljenaSifraModalComponent.prototype.inicijalizujSveRegistracioneForme = function () {
        this.zaboravljeSifraForma = this.formBuilder.group({
            email: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].email]],
        });
    };
    ZaboravljenaSifraModalComponent.prototype.posaljiMailZaboravljenaSifra = function () {
        var _this = this;
        this.formaSubmited = true;
        if (this.zaboravljeSifraForma.invalid) {
            return;
        }
        this.resetSifre.email = this.zaboravljeno.email.value;
        this.emailService
            .posaljiMailZaResetovanjeSifre(this.resetSifre)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["catchError"])(function (error) {
            if (error.status === 400) {
                var snackPoruka = 'Mail ne postoji u našoj bazi.';
                _this.otvoriSnackBar(snackPoruka);
                return rxjs__WEBPACK_IMPORTED_MODULE_5__["EMPTY"];
            }
            Object(rxjs__WEBPACK_IMPORTED_MODULE_5__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["finalize"])(function () { return _this.ucitavanje = false; })).subscribe(function (res) {
            _this.mailUspesnoPoslat = true;
            console.log('Mail za resetovanje sifre uspesno poslat');
        }, function (error) {
            console.log('Error pri slanju za resetovanje sifre', error);
        });
    };
    ZaboravljenaSifraModalComponent.prototype.zatvoriDialog = function () {
        this.dialogRef.close();
    };
    Object.defineProperty(ZaboravljenaSifraModalComponent.prototype, "zaboravljeno", {
        // convenience getter for easy access to form fields
        get: function () { return this.zaboravljeSifraForma.controls; },
        enumerable: true,
        configurable: true
    });
    ZaboravljenaSifraModalComponent.prototype.otvoriSnackBar = function (poruka) {
        this.snackBar.open(poruka, '', {
            duration: 2000,
            panelClass: ['my-snack-bar']
        });
    };
    ZaboravljenaSifraModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-zaboravljena-sifra-modal',
            template: __webpack_require__(/*! ./zaboravljena-sifra-modal.component.html */ "./src/app/e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.html"),
            styles: [__webpack_require__(/*! ./zaboravljena-sifra-modal.component.scss */ "./src/app/e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _service_email_service__WEBPACK_IMPORTED_MODULE_3__["EmailService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]])
    ], ZaboravljenaSifraModalComponent);
    return ZaboravljenaSifraModalComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/model/dto.ts":
/*!*************************************!*\
  !*** ./src/app/e-shop/model/dto.ts ***!
  \*************************************/
/*! exports provided: ValueHelp, Roba, RobaPage, Partner, Fakutra, FakturaPage, FakturaDetalji, Proizvodjac, Registracija, ResetSifre */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ValueHelp", function() { return ValueHelp; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Roba", function() { return Roba; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RobaPage", function() { return RobaPage; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Partner", function() { return Partner; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Fakutra", function() { return Fakutra; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FakturaPage", function() { return FakturaPage; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FakturaDetalji", function() { return FakturaDetalji; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Proizvodjac", function() { return Proizvodjac; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Registracija", function() { return Registracija; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ResetSifre", function() { return ResetSifre; });
/* harmony import */ var _page__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./page */ "./src/app/e-shop/model/page.ts");
var __extends = (undefined && undefined.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();

var ValueHelp = /** @class */ (function () {
    function ValueHelp() {
    }
    return ValueHelp;
}());

var Roba = /** @class */ (function () {
    function Roba() {
    }
    return Roba;
}());

var RobaPage = /** @class */ (function (_super) {
    __extends(RobaPage, _super);
    function RobaPage() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.content = null;
        return _this;
    }
    return RobaPage;
}(_page__WEBPACK_IMPORTED_MODULE_0__["Page"]));

var Partner = /** @class */ (function () {
    function Partner() {
    }
    return Partner;
}());

var Fakutra = /** @class */ (function () {
    function Fakutra() {
    }
    return Fakutra;
}());

var FakturaPage = /** @class */ (function (_super) {
    __extends(FakturaPage, _super);
    function FakturaPage() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.content = null;
        return _this;
    }
    return FakturaPage;
}(_page__WEBPACK_IMPORTED_MODULE_0__["Page"]));

var FakturaDetalji = /** @class */ (function () {
    function FakturaDetalji() {
    }
    return FakturaDetalji;
}());

var Proizvodjac = /** @class */ (function () {
    function Proizvodjac() {
    }
    return Proizvodjac;
}());

var Registracija = /** @class */ (function () {
    function Registracija() {
    }
    return Registracija;
}());

var ResetSifre = /** @class */ (function () {
    function ResetSifre() {
    }
    return ResetSifre;
}());



/***/ }),

/***/ "./src/app/e-shop/model/konstante.ts":
/*!*******************************************!*\
  !*** ./src/app/e-shop/model/konstante.ts ***!
  \*******************************************/
/*! exports provided: transformator, mesec */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "transformator", function() { return transformator; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "mesec", function() { return mesec; });
var transformator = {
    prevoz_0: 'Automaterijal vozi robu',
    prevoz_1: 'Vi vozite robu',
    prevoz_2: 'Treće lice vozi robu',
    kategorija_AMORTIZER: 'Amortizeri',
    kategorija_BRAVA: 'Brava vrata i elek. ulozak brave',
    kategorija_BREGASTA: 'Bregasta osovina',
    kategorija_BRISAČ: 'Brisači - metlice',
    kategorija_CILINDAR: 'Cilindri-kočioni',
    kategorija_DIHTUNG: 'Dihtunzi svi',
    kategorija_DISK_PLOČICE: 'Disk pločice',
    kategorija_DISKOVI: 'Diskovi',
    kategorija_DVOTAKTOL: 'Dvotaktol ulje',
    kategorija_GREJAČ: 'Grejači',
    kategorija_GUMICE: 'Gumice',
    kategorija_HEMIJA: 'Hemija za automobile',
    kategorija_HIDROPODIZAČ: 'Hidropodizači ventila',
    kategorija_HLADNJAK: 'Hladnjak',
    kategorija_ZGLOB: 'Zglob homokinetički',
    kategorija_INTERKULER: 'Interkuler',
    kategorija_KABLOVI: 'Kablovi za svećice',
    kategorija_KARIKE: 'Karike',
    kategorija_KARTER: 'Karter',
    kategorija_KLACKALICA: 'Klackalica',
    kategorija_KVAČILO: 'Kvačilo - Zamajci',
    kategorija_KLIP: 'Klip',
    kategorija_KOZMETIKA: 'Kozmetika',
    kategorija_KUGLA: 'Kugla',
    kategorija_LANAC: 'Lanac - klizači, setovi',
    kategorija_LETVA: 'Letva volana - spone',
    kategorija_LEŽAJEVI: 'Ležajevi radilice',
    kategorija_MANŽENTA: 'Manžetne',
    kategorija_PAKNOVI: 'Paknovi',
    kategorija_PREKIDAČ: 'Prekidači',
    kategorija_PROTOKOMER: 'Protokomer',
    kategorija_PUMPA: 'Pumpa za vodu',
    kategorija_RAME: 'Rame',
    kategorija_RAZVODNIK: 'Razvodnik paljenja',
    kategorija_REMENICA: 'Remenice',
    kategorija_SEMERING: 'Semering',
    kategorija_SVEĆICA: 'Svećica i kablovi',
    kategorija_SIJALICA: 'Sijalice',
    kategorija_SILEN: 'Silen blokovi',
    kategorija_STABILIZATOR: 'Stabilizator',
    kategorija_TERMODAVAČ: 'Termodavač',
    kategorija_TERMOSTAT: 'Termostat',
    kategorija_VENTIL: 'Ventili',
    kategorija_VENTILATOR: 'Ventilator',
    kategorija_ZUPČANIK: 'Zupčanici',
    empty: 'N/A'
};
var mesec = {
    mesec_01: 'Januar',
    mesec_02: 'Februar',
    mesec_03: 'Mart',
    mesec_04: 'April',
    mesec_05: 'Maj',
    mesec_06: 'Jun',
    mesec_07: 'Jul',
    mesec_08: 'Avgust',
    mesec_09: 'Septembar',
    mesec_10: 'Oktobar',
    mesec_11: 'Novembar',
    mesec_12: 'Decembar'
};


/***/ }),

/***/ "./src/app/e-shop/model/page.ts":
/*!**************************************!*\
  !*** ./src/app/e-shop/model/page.ts ***!
  \**************************************/
/*! exports provided: Page */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Page", function() { return Page; });
var Page = /** @class */ (function () {
    function Page() {
        this.last = null;
        this.totalPages = null;
        this.totalElements = null;
        this.numberOfElements = null;
        this.first = null;
        this.sort = null;
        this.size = null;
        this.number = null;
    }
    return Page;
}());



/***/ }),

/***/ "./src/app/e-shop/model/porudzbenica.ts":
/*!**********************************************!*\
  !*** ./src/app/e-shop/model/porudzbenica.ts ***!
  \**********************************************/
/*! exports provided: Korpa, RobaKorpa */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Korpa", function() { return Korpa; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RobaKorpa", function() { return RobaKorpa; });
var Korpa = /** @class */ (function () {
    function Korpa() {
        this.roba = [];
    }
    return Korpa;
}());

var RobaKorpa = /** @class */ (function () {
    function RobaKorpa(robaid, katbr, katbrpro, naziv, proizvodjac, kolicina, rabat, cena, stanje) {
        this.robaid = robaid;
        this.katbr = katbr;
        this.katbrpro = katbrpro;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.kolicina = kolicina;
        this.rabat = rabat;
        this.cenaKom = cena;
        this.cenaUkupno = cena * kolicina;
        this.stanje = stanje;
    }
    return RobaKorpa;
}());



/***/ }),

/***/ "./src/app/e-shop/partner/partner.component.html":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/partner/partner.component.html ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n  <main class=\"licni-podaci\">\r\n    <div class=\"d-flex flex-column  flex-xl-row\">\r\n      <div class=\"strana\">\r\n        <div class=\"header2\">\r\n          <h1>Licni podaci</h1>\r\n        </div>\r\n        <ul>\r\n          <li>\r\n            <span class=\"leva-strana\">\r\n              Naziv:\r\n            </span> <span class=\"desna-strana\"> {{partner.naziv}} </span>\r\n          </li>\r\n          <li><span class=\"leva-strana\">Adresa:</span> {{partner.adresa}}</li>\r\n          <li><span class=\"leva-strana\">Email:</span> {{partner.email | lowercase}}</li>\r\n          <li><span class=\"leva-strana\">Stanje:</span> <span [ngClass]=\"{'dugovanje': daLiDuguje}\"><b>{{partner.stanje\r\n                | currency:\" \"}} RSD</b></span></li>\r\n        </ul>\r\n      </div>\r\n      <div class=\"strana\">\r\n        <div class=\"header2\">\r\n          <h1>Akcije</h1>\r\n        </div>\r\n        <mat-accordion>\r\n          <mat-expansion-panel class=\"exp-panel\">\r\n            <mat-expansion-panel-header>\r\n              <mat-panel-title>\r\n                <p class=\"panel\">Promenite adresu</p>\r\n              </mat-panel-title>\r\n            </mat-expansion-panel-header>\r\n            <form role=\"form\" [formGroup]=\"adresaForm\">\r\n              <div>\r\n                <mat-form-field>\r\n                  <input type=\"text\" #ulica formControlName=\"ulica\" [ngClass]=\"{ 'is-invalid': adresaSubmited && a.ulica.errors }\"\r\n                    matInput placeholder=\"Ulica i broj\">\r\n                </mat-form-field>\r\n              </div>\r\n              <div *ngIf=\"adresaSubmited && a.ulica.errors\">\r\n                <div *ngIf=\"a.ulica.errors.required\">\r\n                  <p class=\"upozorenje\">\r\n                    <p class=\"upozorenje\">Naziv ulice je obavezan</p>\r\n                </div>\r\n                <div *ngIf=\"a.ulica.errors.minlength\">\r\n                  <p class=\"upozorenje\">\r\n                    <p class=\"upozorenje\">Naziv ulice mora imati minimalno 3 karaktera</p>\r\n                </div>\r\n              </div>\r\n              <div>\r\n                <mat-form-field>\r\n                  <input type=\"text\" #grad formControlName=\"grad\" matInput [ngClass]=\"{ 'is-invalid': adresaSubmited && a.grad.errors }\"\r\n                    placeholder=\"Grad\">\r\n                </mat-form-field>\r\n                <div *ngIf=\"adresaSubmited && a.grad.errors\">\r\n                  <div *ngIf=\"a.grad.errors.required\">\r\n                    <p class=\"upozorenje\">\r\n                      <p class=\"upozorenje\">Naziv grada je obavezan</p>\r\n                  </div>\r\n                  <div *ngIf=\"a.grad.errors.minlength\">\r\n                    <p class=\"upozorenje\">\r\n                      <p class=\"upozorenje\">Naziv grada mora imati minimalno 2 karaktera</p>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n              <div class=\"button-div\">\r\n                <button class=\"button-glavni\" (click)=\"promeniAdresu(ulica.value, grad.value)\" mat-raised-button>Sacuvaj</button>\r\n                <button class=\"button-error float-right\" (click)=\"ulica.value = ''; grad.value = ''; adresaSubmited=false\"\r\n                  mat-raised-button>Poništi</button>\r\n              </div>\r\n            </form>\r\n\r\n          </mat-expansion-panel>\r\n          <mat-expansion-panel class=\"exp-panel\">\r\n            <mat-expansion-panel-header>\r\n              <mat-panel-title>\r\n                <p class=\"panel\">Promenite email</p>\r\n              </mat-panel-title>\r\n            </mat-expansion-panel-header>\r\n            <form role=\"form\" [formGroup]=\"emailForm\">\r\n              <div>\r\n                <mat-form-field>\r\n                  <input type=\"email\" #email formControlName=\"email\" matInput [ngClass]=\"{ 'is-invalid': emailSubmited && e.email.errors }\"\r\n                    placeholder=\"Novi email...\">\r\n                </mat-form-field>\r\n              </div>\r\n              <div *ngIf=\"emailSubmited && e.email.errors\">\r\n                <div *ngIf=\"e.email.errors.required\">\r\n                  <p class=\"upozorenje\">\r\n                    <p class=\"upozorenje\">Email je obavezan</p>\r\n                </div>\r\n                <div *ngIf=\"e.email.errors.email\">\r\n                  <p class=\"upozorenje\">\r\n                    <p class=\"upozorenje\">Email nije validan</p>\r\n                </div>\r\n              </div>\r\n              <div class=\"button-div\">\r\n                <button class=\"button-glavni\" (click)=\"promeniLEmail(email.value)\" mat-raised-button>Sacuvaj</button>\r\n                <button class=\"button-error float-right\" (click)=\"email.value = ''; emailSubmited=false\"\r\n                  mat-raised-button>Poništi</button>\r\n              </div>\r\n            </form>\r\n          </mat-expansion-panel>\r\n          <mat-expansion-panel class=\"exp-panel\">\r\n            <mat-expansion-panel-header>\r\n              <mat-panel-title>\r\n                <p class=\"panel\">Promenite korisničko ime</p>\r\n              </mat-panel-title>\r\n            </mat-expansion-panel-header>\r\n            <div>\r\n              <mat-radio-group class=\"radio-group\" [(ngModel)]=\"korisnickoImeMetod\">\r\n                <mat-radio-button color=\"primary\" value=\"email\">Koristi trenutni email</mat-radio-button>\r\n                <mat-radio-button color=\"primary\" value=\"novo\">\r\n                  <p>Kreirajte nov</p>\r\n                </mat-radio-button>\r\n              </mat-radio-group>\r\n            </div>\r\n\r\n            <form role=\"form\" [formGroup]=\"usernameForm\">\r\n              <div>\r\n                <mat-form-field *ngIf=\"korisnickoImeMetod != 'email'\">\r\n                  <input type=\"text\" #username formControlName=\"username\" [ngClass]=\"{ 'email-selected': korisnickoImeMetod === 'email'}\"\r\n                    [attr.disabled]=\"daLiKorisnickoImeTrebaDaBudeEmail() ? '' : null\" matInput placeholder=\"Novo korisničko ime\">\r\n                </mat-form-field>\r\n              </div>\r\n\r\n              <div *ngIf=\"usernameSubmited && u.username.errors\">\r\n                <div *ngIf=\"u.username.errors.required && korisnickoImeMetod != 'email'\">\r\n                  <p class=\"upozorenje\">\r\n                    <p class=\"upozorenje\">Korisničko ime je obavezno</p>\r\n                </div>\r\n                <div *ngIf=\"u.username.errors.minlength && korisnickoImeMetod != 'email'\">\r\n                  <p class=\"upozorenje\">Korisničko ime mora imati vise od 3 karaktera</p>\r\n                </div>\r\n              </div>\r\n              <div *ngIf=\"usernameSubmited && korisnickoImeJeZauzeto\">\r\n                <p class=\"upozorenje\">Korisničko ime je vec zazueto</p>\r\n              </div>\r\n              <div class=\"button-div\">\r\n                <button class=\"button-glavni\" (click)=\"promeniUsername()\" mat-raised-button>Sacuvaj</button>\r\n                <button *ngIf=\"korisnickoImeMetod != 'email'\" class=\"button-error float-right\" (click)=\"username.value = ''; usernameSubmited=false\"\r\n                  mat-raised-button>Poništi</button>\r\n              </div>\r\n            </form>\r\n          </mat-expansion-panel>\r\n          <mat-expansion-panel class=\"exp-panel\">\r\n            <mat-expansion-panel-header>\r\n              <mat-panel-title>\r\n                <p class=\"panel\">Promenite šifru</p>\r\n              </mat-panel-title>\r\n            </mat-expansion-panel-header>\r\n            <form role=\"form\" [formGroup]=\"passwordForm\">\r\n              <div>\r\n                <mat-form-field>\r\n                  <input matInput type=\"password\" #staraSifra formControlName=\"staraSifra\" placeholder=\"Stara šifra\">\r\n                </mat-form-field>\r\n                <div *ngIf=\"passwordSubmited && !s.staraSifra.errors && losaSifra\">\r\n                  <p class=\"upozorenje\">Stara šifra nije tačna</p>\r\n                </div>\r\n                <div *ngIf=\"passwordSubmited && s.staraSifra.errors\">\r\n                  <div *ngIf=\"s.staraSifra.errors.required\">\r\n                    <p class=\" upozorenje\">Stara šifra je obavezna</p>\r\n                  </div>\r\n                  <div *ngIf=\"s.staraSifra.errors.minlength\">\r\n                    <p class=\"upozorenje\">Korisničko ime mora imati vise od 3 karaktera</p>\r\n                  </div>\r\n                </div>\r\n                <div>\r\n                  <mat-form-field>\r\n                    <input matInput type=\"password\" #novaSifra formControlName=\"novaSifra\" placeholder=\"Nova šifra\">\r\n                  </mat-form-field>\r\n                </div>\r\n                <div *ngIf=\"passwordSubmited && s.novaSifra.errors\">\r\n                  <div *ngIf=\"s.novaSifra.errors.required\">\r\n                    <p class=\" upozorenje\">Nova šifra je obavezna</p>\r\n                  </div>\r\n                  <div *ngIf=\"s.novaSifra.errors.minlength\">\r\n                    <p class=\"upozorenje\">Nova sifra mora imati vise od 3 karaktera</p>\r\n                  </div>\r\n                </div>\r\n                <div>\r\n                  <mat-form-field>\r\n                    <input matInput type=\"password\" #novaSifra2 formControlName=\"novaSifra2\" placeholder=\"Ponovite novu šifru\">\r\n                  </mat-form-field>\r\n                </div>\r\n                <div *ngIf=\"passwordSubmited && s.novaSifra2.errors\">\r\n                  <div *ngIf=\"s.novaSifra2.errors.required\">\r\n                    <p class=\" upozorenje\">Nova šifra je obavezna</p>\r\n                  </div>\r\n                  <div *ngIf=\"s.novaSifra2.errors.minlength\">\r\n                    <p class=\"upozorenje\">Nova sifra mora imati vise od 3 karaktera</p>\r\n                  </div>\r\n                </div>\r\n                <div *ngIf=\"novaSifra.value != novaSifra2.value && !s.novaSifra.errors && !s.novaSifra2.errors  && passwordSubmited\">\r\n                  <p class=\"upozorenje\">Nova sifra nije ista</p>\r\n                </div>\r\n                <div class=\"button-div\">\r\n                  <button class=\"button-glavni\" (click)=\"promeniSifru(staraSifra.value, novaSifra.value, novaSifra2.value)\"\r\n                    mat-raised-button>Sacuvaj</button>\r\n                  <button *ngIf=\"korisnickoImeMetod != 'email'\" class=\"button-error float-right\" (click)=\"username.value = ''; passwordSubmited=false\"\r\n                    mat-raised-button>Poništi</button>\r\n                </div>\r\n              </div>\r\n            </form>\r\n          </mat-expansion-panel>\r\n        </mat-accordion>\r\n      </div>\r\n    </div>\r\n  </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/partner/partner.component.scss":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/partner/partner.component.scss ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  font-size: 25px;\n  color: #283b4e;\n  font-weight: bold;\n  text-align: center; }\n\nul {\n  list-style-type: none; }\n\nli {\n  padding: 10px;\n  margin-top: 12px; }\n\n.exp-panel {\n  margin-top: 12px; }\n\n.header2 {\n  text-align: center;\n  margin-top: 20px;\n  margin-bottom: 30px; }\n\n.leva-strana {\n  width: 80px;\n  float: left;\n  color: #3e5e9e;\n  font-weight: bold; }\n\n.desna-strana {\n  font-weight: bold; }\n\n.licni-podaci {\n  margin-top: 6%;\n  width: 80%;\n  margin-left: 10%; }\n\n.radio-group {\n  display: inline-flex;\n  flex-direction: column; }\n\n.panel {\n  color: #3e5e9e;\n  font-weight: bold; }\n\n.email-selected {\n  color: #8ea7b4 !important; }\n\n.dugovanje {\n  color: #b71c1c; }\n\n.button-div {\n  width: 70%;\n  margin-left: 15%; }\n\n.strana {\n  box-shadow: 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);\n  width: 90%;\n  margin-left: 10px;\n  height: 100%;\n  margin-top: 10px;\n  padding: 10px;\n  border-bottom: 0.5px solid #283b4e;\n  background-color: white; }\n\n.upozorenje {\n  text-align: left;\n  font-family: sans-serif;\n  font-size: 12px;\n  color: red;\n  margin-top: -15px;\n  margin-bottom: 0px; }\n\n@media only screen and (max-device-width: 640px) {\n  .strana {\n    width: 100%;\n    height: 100%;\n    margin-top: 10px;\n    border-bottom: 0.5px solid #283b4e;\n    background-color: white; }\n  li {\n    padding: 0px; }\n  ul {\n    margin: 0px;\n    padding: 2px; }\n  .licni-podaci {\n    margin-top: 1%;\n    width: 95%;\n    margin-left: 0%; } }\n"

/***/ }),

/***/ "./src/app/e-shop/partner/partner.component.ts":
/*!*****************************************************!*\
  !*** ./src/app/e-shop/partner/partner.component.ts ***!
  \*****************************************************/
/*! exports provided: PartnerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PartnerComponent", function() { return PartnerComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _service_partner_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/partner.service */ "./src/app/e-shop/service/partner.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var PartnerComponent = /** @class */ (function () {
    function PartnerComponent(loginServis, partnerServis, formBuilder, snackBar) {
        this.loginServis = loginServis;
        this.partnerServis = partnerServis;
        this.formBuilder = formBuilder;
        this.snackBar = snackBar;
        this.daLiDuguje = false;
        this.korisnickoImeMetod = 'novo';
        this.losaSifra = false;
        this.korisnickoImeJeZauzeto = false;
        this.ucitavanje = false;
        this.alive = true;
        this.adresaSubmited = false;
        this.emailSubmited = false;
        this.usernameSubmited = false;
        this.passwordSubmited = false;
    }
    PartnerComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        if (this.partner) {
            this.daLiDuguje = this.partner.stanje < 0;
        }
        this.inicijalizujSveRegistracioneForme();
    };
    PartnerComponent.prototype.inicijalizujSveRegistracioneForme = function () {
        this.adresaForm = this.formBuilder.group({
            ulica: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].minLength(3)]],
            grad: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].minLength(2)]]
        });
        this.emailForm = this.formBuilder.group({
            email: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].email]],
        });
        this.usernameForm = this.formBuilder.group({
            username: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].minLength(3)]],
        });
        this.passwordForm = this.formBuilder.group({
            staraSifra: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].minLength(3)]],
            novaSifra: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].minLength(3)]],
            novaSifra2: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].minLength(3)]],
        });
    };
    PartnerComponent.prototype.daLiKorisnickoImeTrebaDaBudeEmail = function () {
        return this.korisnickoImeMetod === 'email';
    };
    PartnerComponent.prototype.promeniAdresu = function (ulica, grad) {
        var poruka = 'Adresa uspesno promenjena.';
        this.adresaSubmited = true;
        if (this.adresaForm.invalid) {
            return;
        }
        this.partner.adresa = ulica + ', ' + grad;
        this.updejtPartnera(this.partner, poruka);
    };
    PartnerComponent.prototype.promeniLEmail = function (email) {
        var poruka = 'Email je uspesno promenjen.';
        this.emailSubmited = true;
        if (this.emailForm.invalid) {
            return;
        }
        this.partner.email = email;
        this.updejtPartnera(this.partner, poruka);
    };
    PartnerComponent.prototype.promeniUsername = function () {
        var _this = this;
        var username = '';
        this.usernameSubmited = true;
        if (this.korisnickoImeMetod === 'email') {
            username = this.partner.email;
        }
        else if (this.usernameForm.invalid) {
            return;
        }
        else if (this.usernameForm.controls.username.value) {
            username = this.usernameForm.controls.username.value;
        }
        var poruka = 'Vaše novo korisničko ime je: ' + username;
        this.partner.webKorisnik = username;
        this.partnerServis.updejtujPartnera(this.partner)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) {
            if (error.status === 400) {
                _this.korisnickoImeJeZauzeto = true;
                return rxjs__WEBPACK_IMPORTED_MODULE_4__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.korisnickoImeJeZauzeto = false;
            _this.partner = res;
            _this.otvoriSnackBar(poruka);
        }, function (error) {
            console.log('Updejtovanje partnera nije uspelo');
        });
    };
    PartnerComponent.prototype.promeniSifru = function (staraSifra, novaSifra, novaSifra2) {
        var _this = this;
        this.passwordSubmited = true;
        if (this.passwordForm.invalid ||
            novaSifra === staraSifra) {
            var a = this.s.staraSifra.errors.minLength;
            return;
        }
        this.partner.noviPassword = novaSifra;
        this.partner.stariPassword = staraSifra;
        var poruka = 'Vaša šifra je uspeno promenjena';
        this.partnerServis.updejtujPartnera(this.partner)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) {
            if (error.status === 400) {
                _this.losaSifra = true;
                return rxjs__WEBPACK_IMPORTED_MODULE_4__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.partner = res;
            _this.losaSifra = false;
            _this.otvoriSnackBar(poruka);
        }, function (error) {
            console.log('Updejtovanje partnera nije uspelo');
        });
    };
    PartnerComponent.prototype.updejtPartnera = function (partner, poruka) {
        var _this = this;
        this.partnerServis.updejtujPartnera(this.partner)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.partner = res;
            _this.otvoriSnackBar(poruka);
        }, function (error) {
            console.log('Updejtovanje partnera nije uspelo');
        });
    };
    PartnerComponent.prototype.otvoriSnackBar = function (poruka) {
        this.snackBar.open(poruka, '', {
            duration: 2000,
        });
    };
    Object.defineProperty(PartnerComponent.prototype, "a", {
        // convenience getter for easy access to form fields
        get: function () { return this.adresaForm.controls; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PartnerComponent.prototype, "e", {
        get: function () { return this.emailForm.controls; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PartnerComponent.prototype, "u", {
        get: function () { return this.usernameForm.controls; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PartnerComponent.prototype, "s", {
        get: function () { return this.passwordForm.controls; },
        enumerable: true,
        configurable: true
    });
    PartnerComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-partner',
            template: __webpack_require__(/*! ./partner.component.html */ "./src/app/e-shop/partner/partner.component.html"),
            styles: [__webpack_require__(/*! ./partner.component.scss */ "./src/app/e-shop/partner/partner.component.scss")]
        }),
        __metadata("design:paramtypes", [_service_login_service__WEBPACK_IMPORTED_MODULE_1__["LoginService"],
            _service_partner_service__WEBPACK_IMPORTED_MODULE_2__["PartnerService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormBuilder"],
            _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatSnackBar"]])
    ], PartnerComponent);
    return PartnerComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/akumulatori/akumulatori.component.css":
/*!*******************************************************************!*\
  !*** ./src/app/e-shop/roba/akumulatori/akumulatori.component.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/e-shop/roba/akumulatori/akumulatori.component.html":
/*!********************************************************************!*\
  !*** ./src/app/e-shop/roba/akumulatori/akumulatori.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n    <div class=\"d-flex align-items-center justify-content-center\">\r\n        <div class=\"forms-input\">\r\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                <button mat-mini-fab class=\"button-glavni\">\r\n                    <mat-icon>search</mat-icon>\r\n                </button>\r\n            </div>\r\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                <button *ngIf=\"!otvoriFilterDiv\" class=\"button-glavni\" mat-mini-fab>\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab class=\"button-polu-glavni\">\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n            </div>\r\n        </div>\r\n    </div>\r\n    <div class=\"d-flex justify-content-center\">\r\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\r\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n        </label>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\r\n        <div class=\"filter-div-test d-flex flex-column\">\r\n            <div class=\"d-flex justify-content-center\">\r\n                <h2>\r\n                    Filter\r\n                </h2>\r\n            </div>\r\n            <div class=\"input-group mb-3\">\r\n                <div class=\"input-group-prepend\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Proizvodjac: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\r\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\r\n                       {{proizvodjac.naziv}}\r\n                    </option>\r\n                </select>\r\n\r\n                <div class=\"input-group-prepend razmak\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Raspolozivost: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\r\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\r\n                </select>\r\n            </div>\r\n            <div class=\"d-flex justify-content-center\">\r\n                <div>\r\n                    <button mat-stroked-button class=\"button-glavni\" (click)='filtriraj()'>\r\n                        <p class=\"boja-kontra-bela\">Filtriraj</p>\r\n                    </button>\r\n                    <span class=\"col-2\"></span>\r\n                    <button mat-stroked-button class=\"button-error\" (click)='resetujFilter()'>\r\n                        <p class=\"boja-kontra-bela\">Ponisti</p>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n    <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n        <table mat-table [dataSource]=\"dataSource\">\r\n            <!-- Kataloski broj Column -->\r\n            <ng-container matColumnDef=\"katbr\">\r\n                <th mat-header-cell *matHeaderCellDef> Kataloski broj </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.katbr}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Kataloski broj proizvodjaca Column -->\r\n            <ng-container matColumnDef=\"katbrpro\">\r\n                <th mat-header-cell *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.katbrpro}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Naziv Column -->\r\n            <ng-container matColumnDef=\"naziv\">\r\n                <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Proizvodjac Column -->\r\n            <ng-container matColumnDef=\"proizvodjac\">\r\n                <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.proizvodjac.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"rabat\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Rabat </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.rabat | currency:\" \"}}%\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"cena\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.cena | currency:\" \"}} RSD\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Stanje Column -->\r\n            <ng-container matColumnDef=\"stanje\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\" class=\"text-center\">\r\n                        <mat-icon class=\"boja-confirm\">check_circle_outline</mat-icon>\r\n                    </div>\r\n                    <div *ngIf=\"roba.stanje == 0\" class=\"text-center\">\r\n                        <mat-icon class=\"boja-error\">remove_circle_outline</mat-icon>\r\n                    </div>\r\n                </td>\r\n            </ng-container>\r\n\r\n\r\n            <!-- Kolicina Column -->\r\n            <ng-container matColumnDef=\"kolicina\">\r\n                <th mat-header-cell *matHeaderCellDef>Kolicina </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <input type=\"number\" min=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\"\r\n                            placeholder=\"0\" [(ngModel)]=\"roba.kolicina\" />\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Kropa dugme Column -->\r\n            <ng-container matColumnDef=\"korpa\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <button mat-raised-button class=\"button-glavni\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Da li ima na stanju ikona -->\r\n            <ng-container matColumnDef=\"u-korpi\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"uKorpi(roba.katbr)\">\r\n                        <mat-icon class=\"boja-error\">add_shopping_cart</mat-icon>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n            <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n        </table>\r\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n        </mat-paginator>\r\n    </div>\r\n\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/roba/akumulatori/akumulatori.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/e-shop/roba/akumulatori/akumulatori.component.ts ***!
  \******************************************************************/
/*! exports provided: AkumulatoriComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AkumulatoriComponent", function() { return AkumulatoriComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _service_roba_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _service_data_data_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../service/proizvodjac.service */ "./src/app/e-shop/service/proizvodjac.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var AkumulatoriComponent = /** @class */ (function () {
    function AkumulatoriComponent(robaService, utilsService, loginServis, dataService, proizvodjacService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
        this.loginServis = loginServis;
        this.dataService = dataService;
        this.proizvodjacService = proizvodjacService;
        this.korpaSnackBar = korpaSnackBar;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        // Filteri
        this.izabraniProizvodjac = '';
        this.raspolozivost = ['Svi artikli', 'Ima na stanju'];
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilterDiv = false;
        // Tabela
        this.columnDefinitions = [
            { def: 'katbr', ifNotAuth: true },
            { def: 'katbrpro', ifNotAuth: true },
            { def: 'proizvodjac', ifNotAuth: true },
            { def: 'naziv', ifNotAuth: true },
            { def: 'rabat', ifNotAuth: false },
            { def: 'cena', ifNotAuth: true },
            { def: 'stanje', ifNotAuth: true },
            { def: 'kolicina', ifNotAuth: false },
            { def: 'korpa', ifNotAuth: false },
            { def: 'u-korpi', ifNotAuth: false },
        ];
        this.alive = true;
    }
    AkumulatoriComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.pronadjiSveProizvodjace();
    };
    AkumulatoriComponent.prototype.getDisplayedColumns = function () {
        var isPartner = this.partner.ppid != null;
        var dataColumns = this.columnDefinitions
            .filter(function (cd) { return isPartner || cd.ifNotAuth; })
            .map(function (cd) { return cd.def; });
        return dataColumns;
    };
    AkumulatoriComponent.prototype.pronandjiSveAkumulatore = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiAkumulatore(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    AkumulatoriComponent.prototype.pronadjiAkumulatorePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiAkumulatore(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    AkumulatoriComponent.prototype.pronadjiSveProizvodjace = function () {
        var _this = this;
        this.proizvodjacService.pronadjiSveProizvodjaceAkumulatora()
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
            _this.proizvodjaci = res;
            _this.izabraniProizvodjac = _this.proizvodjaci[0].naziv;
            _this.pronandjiSveAkumulatore();
        }, function (error) {
            _this.proizvodjaci = null;
            console.log('Pronaci svu robu je bacilo gresku', error);
        });
    };
    AkumulatoriComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.pronadjiAkumulatorePoPretrazi(searchValue);
    };
    AkumulatoriComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiAkumulatorePoPretrazi(this.searchValue);
    };
    AkumulatoriComponent.prototype.sortData = function (sort) {
        this.sort = sort;
        this.pronadjiAkumulatorePoPretrazi(this.searchValue);
    };
    AkumulatoriComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilterDiv = !this.otvoriFilterDiv;
    };
    AkumulatoriComponent.prototype.resetujFilter = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.filtriraj();
    };
    AkumulatoriComponent.prototype.filtriraj = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        var recZaPretragu;
        recZaPretragu = this.searchValue;
        this.pronadjiAkumulatorePoPretrazi(recZaPretragu);
    };
    AkumulatoriComponent.prototype.dodajUKorpu = function (roba) {
        var snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.openKorpaSnackBar(snackBarPoruka);
        this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
    };
    AkumulatoriComponent.prototype.openKorpaSnackBar = function (poruka) {
        this.korpaSnackBar.open(poruka, '', {
            duration: 2000,
        });
    };
    AkumulatoriComponent.prototype.uKorpi = function (katBr) {
        return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
    };
    AkumulatoriComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-akumulatori',
            template: __webpack_require__(/*! ./akumulatori.component.html */ "./src/app/e-shop/roba/akumulatori/akumulatori.component.html"),
            styles: [__webpack_require__(/*! ./akumulatori.component.css */ "./src/app/e-shop/roba/akumulatori/akumulatori.component.css")]
        }),
        __metadata("design:paramtypes", [_service_roba_service__WEBPACK_IMPORTED_MODULE_4__["RobaService"],
            _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            _service_login_service__WEBPACK_IMPORTED_MODULE_6__["LoginService"],
            _service_data_data_service__WEBPACK_IMPORTED_MODULE_7__["DataService"],
            _service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_8__["ProizvodjacService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]])
    ], AkumulatoriComponent);
    return AkumulatoriComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/filteri/filteri.component.css":
/*!***********************************************************!*\
  !*** ./src/app/e-shop/roba/filteri/filteri.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".example-radio-group {\r\n    display: inline-flex;\r\n    flex-direction: column;\r\n  }\r\n  \r\n  .example-radio-button {\r\n    margin: 5px;\r\n  }\r\n  \r\n  .example-selected-value {\r\n    margin: 15px 0;\r\n  }"

/***/ }),

/***/ "./src/app/e-shop/roba/filteri/filteri.component.html":
/*!************************************************************!*\
  !*** ./src/app/e-shop/roba/filteri/filteri.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <main>\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=\"button-glavni\">\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button *ngIf=\"!otvoriFilterDiv\" class=\"button-glavni\" mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab class=\"button-polu-glavni\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n\r\n        <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\r\n            <div class=\"filter-div-test d-flex flex-column\">\r\n                <div class=\"d-flex justify-content-center\">\r\n                    <h2>\r\n                        Filter\r\n                    </h2>\r\n                </div>\r\n                <div class=\"input-group mb-3\">\r\n                    <div class=\"input-group-prepend\">\r\n                        <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                            <p class=\"boja-kontra-bela\">Proizvodjac: </p>\r\n                        </label>\r\n                    </div>\r\n                    <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\r\n                        <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\r\n                            {{proizvodjac.naziv}}\r\n                        </option>\r\n                    </select>\r\n\r\n                    <div class=\"input-group-prepend razmak\">\r\n                        <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                            Raspolozivost:\r\n                        </label>\r\n                    </div>\r\n                    <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\r\n                        <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\r\n                    </select>\r\n                </div>\r\n                <div class=\"d-flex justify-content-center\">\r\n                    <div>\r\n                        <button mat-stroked-button class=\"button-glavni\" (click)='filtriraj()'>\r\n                            <p class=\"boja-kontra-bela\">Filtriraj</p>\r\n                        </button>\r\n                        <span class=\"col-2\"></span>\r\n                        <button mat-stroked-button class=\"button-error\" (click)='resetujFilter()'>\r\n                            <p class=\"boja-kontra-bela\">Ponisti</p>\r\n                        </button>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n\r\n        <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n            <i class=\"material-icons icon-size\">\r\n                error_outline\r\n            </i>\r\n            <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n        </div>\r\n    \r\n        <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n            <mat-spinner></mat-spinner>\r\n        </div>\r\n        <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n            <table mat-table [dataSource]=\"dataSource\"       >\r\n                <!-- Kataloski broj Column -->\r\n                <ng-container matColumnDef=\"katbr\">\r\n                    <th mat-header-cell    *matHeaderCellDef> Kataloski broj </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.katbr}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Kataloski broj proizvodjaca Column -->\r\n                <ng-container matColumnDef=\"katbrpro\">\r\n                    <th mat-header-cell    *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-1\">\r\n                            {{roba.katbrpro}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Naziv Column -->\r\n                <ng-container matColumnDef=\"naziv\">\r\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-1\">\r\n                            {{roba.naziv}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Proizvodjac Column -->\r\n                <ng-container matColumnDef=\"proizvodjac\">\r\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.proizvodjac.naziv}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Cena Column -->\r\n                <ng-container matColumnDef=\"rabat\">\r\n                    <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Rabat </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2 text-right iznos-margin\">\r\n                                {{roba.rabat | currency:\" \"}}%\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Cena Column -->\r\n                <ng-container matColumnDef=\"cena\">\r\n                    <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2 text-right iznos-margin\">\r\n                                {{roba.cena | currency:\" \"}} RSD\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Stanje Column -->\r\n                <ng-container matColumnDef=\"stanje\">\r\n                    <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\" class=\"text-center\">\r\n                            <mat-icon class=\"boja-confirm\">check_circle_outline</mat-icon>\r\n                        </div>\r\n                        <div *ngIf=\"roba.stanje == 0\" class=\"text-center\">\r\n                            <mat-icon class=\"boja-error\">remove_circle_outline</mat-icon>\r\n                        </div>\r\n                    </td>\r\n                </ng-container>\r\n\r\n\r\n                <!-- Kolicina Column -->\r\n                <ng-container matColumnDef=\"kolicina\">\r\n                    <th mat-header-cell *matHeaderCellDef>Kolicina </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\">\r\n                            <input type=\"number\" min=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\" />\r\n                        </div>\r\n                </ng-container>\r\n\r\n                <!-- Kropa dugme Column -->\r\n                <ng-container matColumnDef=\"korpa\">\r\n                    <th mat-header-cell *matHeaderCellDef> </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\">\r\n                            <button mat-raised-button class=\"button-glavni\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\r\n                        </div>\r\n                </ng-container>\r\n\r\n                <!-- Da li ima na stanju ikona -->\r\n                <ng-container matColumnDef=\"u-korpi\">\r\n                    <th mat-header-cell *matHeaderCellDef> </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"uKorpi(roba.katbr)\">\r\n                            <mat-icon class=\"boja-error\">add_shopping_cart</mat-icon>\r\n                        </div>\r\n                </ng-container>\r\n\r\n                <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n                <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n            </table>\r\n            <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n                [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n            </mat-paginator>\r\n        </div>\r\n    </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/roba/filteri/filteri.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/e-shop/roba/filteri/filteri.component.ts ***!
  \**********************************************************/
/*! exports provided: FilteriComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FilteriComponent", function() { return FilteriComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _service_roba_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var _service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../service/proizvodjac.service */ "./src/app/e-shop/service/proizvodjac.service.ts");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _service_data_data_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var FilteriComponent = /** @class */ (function () {
    function FilteriComponent(robaService, proizvodjacService, loginServis, dataService, utilsService, korpaSnackBar) {
        this.robaService = robaService;
        this.proizvodjacService = proizvodjacService;
        this.loginServis = loginServis;
        this.dataService = dataService;
        this.utilsService = utilsService;
        this.korpaSnackBar = korpaSnackBar;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        // Filteri
        this.izabraniProizvodjac = '';
        this.raspolozivost = ['Svi artikli', 'Ima na stanju'];
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilterDiv = false;
        // Tabela
        this.columnDefinitions = [
            { def: 'katbr', ifNotAuth: true },
            { def: 'katbrpro', ifNotAuth: true },
            { def: 'proizvodjac', ifNotAuth: true },
            { def: 'naziv', ifNotAuth: true },
            { def: 'rabat', ifNotAuth: false },
            { def: 'cena', ifNotAuth: true },
            { def: 'stanje', ifNotAuth: true },
            { def: 'kolicina', ifNotAuth: false },
            { def: 'korpa', ifNotAuth: false },
            { def: 'u-korpi', ifNotAuth: false },
        ];
        this.alive = true;
    }
    FilteriComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.pronadjiSveProizvodjace();
    };
    FilteriComponent.prototype.getDisplayedColumns = function () {
        var isPartner = this.partner.ppid != null;
        var dataColumns = this.columnDefinitions
            .filter(function (cd) { return isPartner || cd.ifNotAuth; })
            .map(function (cd) { return cd.def; });
        return dataColumns;
    };
    FilteriComponent.prototype.pronandjiSveFiltere = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiFiltere(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko', error);
        });
    };
    FilteriComponent.prototype.pronadjiFilterePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiFiltere(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    FilteriComponent.prototype.pronadjiSveProizvodjace = function () {
        var _this = this;
        this.proizvodjacService.pronadjiSveProizvodjaceFiltera()
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
            _this.proizvodjaci = res;
            _this.izabraniProizvodjac = _this.proizvodjaci[0].naziv;
            _this.pronandjiSveFiltere();
        }, function (error) {
            _this.proizvodjaci = null;
            console.log('Pronaci svu robu je bacilo gresku', error);
        });
    };
    FilteriComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.pronadjiFilterePoPretrazi(searchValue);
    };
    FilteriComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiFilterePoPretrazi(this.searchValue);
    };
    FilteriComponent.prototype.sortData = function (sort) {
        this.sort = sort;
        this.pronadjiFilterePoPretrazi(this.searchValue);
    };
    FilteriComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilterDiv = !this.otvoriFilterDiv;
    };
    FilteriComponent.prototype.resetujFilter = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.filtriraj();
    };
    FilteriComponent.prototype.filtriraj = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        var recZaPretragu;
        recZaPretragu = this.searchValue;
        this.pronadjiFilterePoPretrazi(recZaPretragu);
    };
    FilteriComponent.prototype.dodajUKorpu = function (roba) {
        var snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.openKorpaSnackBar(snackBarPoruka);
        this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
    };
    FilteriComponent.prototype.openKorpaSnackBar = function (poruka) {
        this.korpaSnackBar.open(poruka, '', {
            duration: 2000,
        });
    };
    FilteriComponent.prototype.uKorpi = function (katBr) {
        return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
    };
    FilteriComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-filteri',
            template: __webpack_require__(/*! ./filteri.component.html */ "./src/app/e-shop/roba/filteri/filteri.component.html"),
            styles: [__webpack_require__(/*! ./filteri.component.css */ "./src/app/e-shop/roba/filteri/filteri.component.css")]
        }),
        __metadata("design:paramtypes", [_service_roba_service__WEBPACK_IMPORTED_MODULE_4__["RobaService"],
            _service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_5__["ProizvodjacService"],
            _service_login_service__WEBPACK_IMPORTED_MODULE_6__["LoginService"],
            _service_data_data_service__WEBPACK_IMPORTED_MODULE_7__["DataService"],
            _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_8__["AppUtilsService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]])
    ], FilteriComponent);
    return FilteriComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component.html":
/*!***********************************************************************************************!*\
  !*** ./src/app/e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component.html ***!
  \***********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <main>\r\n        <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n            <button class=\"button-glavni nazad-button\" mat-raised-button (click)=\"idiNazad()\">\r\n                <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n            </button>\r\n        </div>\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=\"button-glavni\">\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button *ngIf=\"!otvoriFilterDiv\" class=\"button-glavni\" mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab class=\"button-polu-glavni\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n\r\n        <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\r\n            <div class=\"filter-div-test d-flex flex-column\">\r\n                <div class=\"d-flex justify-content-center\">\r\n                    <h2>\r\n                        Filter\r\n                    </h2>\r\n                </div>\r\n                <div class=\"input-group mb-3\">\r\n                    <div class=\"input-group-prepend\">\r\n                        <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                            <p class=\"boja-kontra-bela\">Proizvodjac: </p>\r\n                        </label>\r\n                    </div>\r\n                    <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\r\n                        <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\r\n                           {{proizvodjac.naziv}}\r\n                        </option>\r\n                    </select>\r\n\r\n                    <div class=\"input-group-prepend razmak\">\r\n                        <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                            <p class=\"boja-kontra-bela\">Raspolozivost: </p>\r\n                        </label>\r\n                    </div>\r\n                    <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\r\n                        <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\r\n                    </select>\r\n                </div>\r\n                <div class=\"d-flex justify-content-center\">\r\n                    <div>\r\n                        <button mat-stroked-button class=\"button-glavni\" (click)='filtriraj()'>\r\n                            <p class=\"boja-kontra-bela\">Filtriraj</p>\r\n                        </button>\r\n                        <span class=\"col-2\"></span>\r\n                        <button mat-stroked-button class=\"button-error\" (click)='resetujFilter()'>\r\n                            <p class=\"boja-kontra-bela\">Ponisti</p>\r\n                        </button>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n\r\n        <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n            <i class=\"material-icons icon-size\">\r\n                error_outline\r\n            </i>\r\n            <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n        </div>\r\n\r\n        <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n            <mat-spinner></mat-spinner>\r\n        </div>\r\n        <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n            <table mat-table [dataSource]=\"dataSource\">\r\n                <!-- Kataloski broj Column -->\r\n                <ng-container matColumnDef=\"katbr\">\r\n                    <th mat-header-cell *matHeaderCellDef> Kataloski broj </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.katbr}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Kataloski broj proizvodjaca Column -->\r\n                <ng-container matColumnDef=\"katbrpro\">\r\n                    <th mat-header-cell *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-1\">\r\n                            {{roba.katbrpro}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Naziv Column -->\r\n                <ng-container matColumnDef=\"naziv\">\r\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-1\">\r\n                            {{roba.naziv}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Proizvodjac Column -->\r\n                <ng-container matColumnDef=\"proizvodjac\">\r\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.proizvodjac.naziv}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Cena Column -->\r\n                <ng-container matColumnDef=\"cena\">\r\n                    <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.cena | currency:\" \"}} RSD\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Stanje Column -->\r\n                <ng-container matColumnDef=\"stanje\">\r\n                    <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\" class=\"text-center\">\r\n                            <mat-icon class=\"boja-confirm\">check_circle_outline</mat-icon>\r\n                        </div>\r\n                        <div *ngIf=\"roba.stanje == 0\" class=\"text-center\">\r\n                            <mat-icon class=\"boja-error\">remove_circle_outline</mat-icon>\r\n                        </div>\r\n                    </td>\r\n                </ng-container>\r\n\r\n\r\n                <!-- Kolicina Column -->\r\n                <ng-container matColumnDef=\"kolicina\">\r\n                    <th mat-header-cell *matHeaderCellDef>Kolicina </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\">\r\n                            <input type=\"number\" min=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\"\r\n                                [(ngModel)]=\"roba.kolicina\" />\r\n                        </div>\r\n                </ng-container>\r\n\r\n                <!-- Kropa dugme Column -->\r\n                <ng-container matColumnDef=\"korpa\">\r\n                    <th mat-header-cell *matHeaderCellDef> </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\">\r\n                            <button mat-raised-button class=\"button-glavni\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\r\n                        </div>\r\n                </ng-container>\r\n\r\n                <!-- Da li ima na stanju ikona -->\r\n                <ng-container matColumnDef=\"u-korpi\">\r\n                    <th mat-header-cell *matHeaderCellDef> </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"uKorpi(roba.katbr)\">\r\n                            <mat-icon class=\"boja-error\">add_shopping_cart</mat-icon>\r\n                        </div>\r\n                </ng-container>\r\n\r\n                <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n                <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n            </table>\r\n            <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n                [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n            </mat-paginator>\r\n        </div>\r\n    </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component.scss":
/*!***********************************************************************************************!*\
  !*** ./src/app/e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component.scss ***!
  \***********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".forms-input {\n  margin-top: 0px !important; }\n\n.nazad-button {\n  border-radius: 12px;\n  margin-right: 5%;\n  margin-top: 20px;\n  width: 120px !important;\n  height: 40px !important; }\n"

/***/ }),

/***/ "./src/app/e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component.ts":
/*!*********************************************************************************************!*\
  !*** ./src/app/e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component.ts ***!
  \*********************************************************************************************/
/*! exports provided: KategorijaSpecificnaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KategorijaSpecificnaComponent", function() { return KategorijaSpecificnaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/service/proizvodjac.service */ "./src/app/e-shop/service/proizvodjac.service.ts");
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};










var KategorijaSpecificnaComponent = /** @class */ (function () {
    function KategorijaSpecificnaComponent(route, proizvodjacService, loginServis, utilsService, dataService, robaServis, korpaSnackBar, router) {
        this.route = route;
        this.proizvodjacService = proizvodjacService;
        this.loginServis = loginServis;
        this.utilsService = utilsService;
        this.dataService = dataService;
        this.robaServis = robaServis;
        this.korpaSnackBar = korpaSnackBar;
        this.router = router;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        // Filteri
        this.izabraniProizvodjac = '';
        this.raspolozivost = ['Svi artikli', 'Ima na stanju'];
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilterDiv = false;
        // Tabela
        this.columnDefinitions = [
            { def: 'katbr', ifNotAuth: true },
            { def: 'katbrpro', ifNotAuth: true },
            { def: 'proizvodjac', ifNotAuth: true },
            { def: 'naziv', ifNotAuth: true },
            { def: 'cena', ifNotAuth: true },
            { def: 'stanje', ifNotAuth: true },
            { def: 'kolicina', ifNotAuth: false },
            { def: 'korpa', ifNotAuth: false },
            { def: 'u-korpi', ifNotAuth: false },
        ];
        this.alive = true;
    }
    KategorijaSpecificnaComponent.prototype.getDisplayedColumns = function () {
        var isPartner = this.partner.ppid != null;
        var dataColumns = this.columnDefinitions
            .filter(function (cd) { return isPartner || cd.ifNotAuth; })
            .map(function (cd) { return cd.def; });
        return dataColumns;
    };
    KategorijaSpecificnaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.pronadjiSveProizvodjace();
    };
    KategorijaSpecificnaComponent.prototype.pronadjiSveProizvodjace = function () {
        var _this = this;
        this.route.params.subscribe(function (params) {
            _this.proizvodjacService.pronadjiSveProizvodjaceKategorije(params.id)
                .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
                .subscribe(function (res) {
                _this.proizvodjaci = res;
                _this.izabraniProizvodjac = _this.proizvodjaci[0].naziv;
                _this.pronandjiRobu();
            }, function (error) {
                _this.proizvodjaci = null;
                console.log('Pronaci svu robu je bacilo gresku', error);
            });
        });
    };
    KategorijaSpecificnaComponent.prototype.pronandjiRobu = function () {
        var _this = this;
        this.route.params.subscribe(function (params) {
            _this.robaServis.pronadjiPoKategoriji(_this.sort, _this.rowsPerPage, _this.pageIndex, null, null, null, params.id)
                .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
                if (error.status === 404) {
                    _this.pronadjenaRoba = false;
                    return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
                }
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
                .subscribe(function (res) {
                _this.pronadjenaRoba = true;
                _this.roba = res.content;
                _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
                _this.dataSource = _this.roba;
                _this.rowsPerPage = res.size;
                _this.pageIndex = res.number;
                _this.tableLength = res.totalElements;
            }, function (error) {
                _this.roba = null;
                console.log('Podnaci robu izbacilo je gresko');
            });
        });
    };
    KategorijaSpecificnaComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.pronadjiSvuRobuPoPretrazi(searchValue);
    };
    KategorijaSpecificnaComponent.prototype.pronadjiSvuRobuPoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.route.params.subscribe(function (params) {
            _this.robaServis.pronadjiPoKategoriji(_this.sort, _this.rowsPerPage, _this.pageIndex, searchValue, naStanju, proizvodjacId, params.id)
                .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
                if (error.status === 404) {
                    _this.pronadjenaRoba = false;
                    return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
                }
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
            }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
                .subscribe(function (res) {
                _this.pronadjenaRoba = true;
                _this.roba = res.content;
                _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
                _this.dataSource = _this.roba;
                _this.rowsPerPage = res.size;
                _this.pageIndex = res.number;
                _this.tableLength = res.totalElements;
            }, function (error) {
                _this.roba = null;
                console.log('Podnaci robu izbacilo je gresko');
            });
        });
    };
    KategorijaSpecificnaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiSvuRobuPoPretrazi(this.searchValue);
    };
    KategorijaSpecificnaComponent.prototype.sortData = function (sort) {
        this.sort = sort;
        var searchTerm;
        if (this.lastSearchValue) {
            searchTerm = this.lastSearchValue;
        }
        else if (this.searchValue) {
            searchTerm = this.searchValue;
        }
        else {
            searchTerm = null;
        }
        this.pronadjiSvuRobuPoPretrazi(this.searchValue);
    };
    KategorijaSpecificnaComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilterDiv = !this.otvoriFilterDiv;
    };
    KategorijaSpecificnaComponent.prototype.resetujFilter = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.filtriraj();
    };
    KategorijaSpecificnaComponent.prototype.filtriraj = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        var recZaPretragu;
        recZaPretragu = this.searchValue;
        this.pronadjiSvuRobuPoPretrazi(recZaPretragu);
    };
    KategorijaSpecificnaComponent.prototype.dodajUKorpu = function (roba) {
        var snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.openKorpaSnackBar(snackBarPoruka);
        this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
    };
    KategorijaSpecificnaComponent.prototype.openKorpaSnackBar = function (poruka) {
        this.korpaSnackBar.open(poruka, '', {
            duration: 2000,
        });
    };
    KategorijaSpecificnaComponent.prototype.uKorpi = function (katBr) {
        return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
    };
    KategorijaSpecificnaComponent.prototype.idiNazad = function () {
        this.router.navigate(['/ostalo']);
    };
    KategorijaSpecificnaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-kategorija-specificna',
            template: __webpack_require__(/*! ./kategorija-specificna.component.html */ "./src/app/e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component.html"),
            styles: [__webpack_require__(/*! ./kategorija-specificna.component.scss */ "./src/app/e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"],
            src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_5__["ProizvodjacService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__["LoginService"],
            src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_7__["AppUtilsService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__["DataService"],
            src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_9__["RobaService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSnackBar"],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]])
    ], KategorijaSpecificnaComponent);
    return KategorijaSpecificnaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/ostalo/ostalo.component.html":
/*!**********************************************************!*\
  !*** ./src/app/e-shop/roba/ostalo/ostalo.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n  <main *ngIf=\"kategorije\">\r\n    <h1>Kategorije</h1>\r\n    <div *ngFor=\"let slovo of pocetnaSlova\">\r\n      <div class=\"d-flex flex-row\">\r\n        <div class=\"slovo\">\r\n          <h2>{{slovo}}</h2>\r\n        </div>\r\n        <div *ngFor=\"let kategorija of vratiKategorijuNaSlovo(slovo)\">\r\n          <a [routerLink]=\"[kategorija  | lowercase]\" mat-button color=\"primary\">{{\"kategorija_\" + kategorija | translate}}</a>\r\n        </div>\r\n      </div>\r\n      <hr>\r\n    </div>\r\n  </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/roba/ostalo/ostalo.component.scss":
/*!**********************************************************!*\
  !*** ./src/app/e-shop/roba/ostalo/ostalo.component.scss ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  margin-top: 20px;\n  margin-left: 20px;\n  margin-bottom: 50px; }\n\n.slovo {\n  width: 30px;\n  margin-top: 0px;\n  padding: 0px; }\n"

/***/ }),

/***/ "./src/app/e-shop/roba/ostalo/ostalo.component.ts":
/*!********************************************************!*\
  !*** ./src/app/e-shop/roba/ostalo/ostalo.component.ts ***!
  \********************************************************/
/*! exports provided: OstaloComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OstaloComponent", function() { return OstaloComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _service_roba_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var OstaloComponent = /** @class */ (function () {
    function OstaloComponent(robaServis) {
        this.robaServis = robaServis;
        this.alive = true;
        this.ucitavanje = false;
        this.pocetnaSlova = ['A', 'B', 'C', 'D', 'G', 'H', 'Z', 'I', 'K', 'L', 'M', 'P', 'R', 'S', 'T', 'V', 'Z'];
    }
    OstaloComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.robaServis.ostaleKategorije().pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.kategorije = res;
        }, function (error) {
            console.log('Podnaci kategorije je izbacilo je gresko');
        });
    };
    OstaloComponent.prototype.vratiKategorijuNaSlovo = function (slovo) {
        var kategorije = [];
        this.kategorije.forEach(function (kategorija) {
            if (kategorija[0] === slovo) {
                kategorije.push(kategorija);
            }
        });
        return kategorije;
    };
    OstaloComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-ostalo',
            template: __webpack_require__(/*! ./ostalo.component.html */ "./src/app/e-shop/roba/ostalo/ostalo.component.html"),
            styles: [__webpack_require__(/*! ./ostalo.component.scss */ "./src/app/e-shop/roba/ostalo/ostalo.component.scss")]
        }),
        __metadata("design:paramtypes", [_service_roba_service__WEBPACK_IMPORTED_MODULE_3__["RobaService"]])
    ], OstaloComponent);
    return OstaloComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/roba.component.css":
/*!************************************************!*\
  !*** ./src/app/e-shop/roba/roba.component.css ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/e-shop/roba/roba.component.html":
/*!*************************************************!*\
  !*** ./src/app/e-shop/roba/roba.component.html ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n    <div class=\"d-flex align-items-center justify-content-center\">\r\n        <div class=\"forms-input\">\r\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                <button mat-mini-fab class=\"button-glavni\">\r\n                    <mat-icon>search</mat-icon>\r\n                </button>\r\n            </div>\r\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                <button *ngIf=\"!otvoriFilterDiv\" class=\"button-glavni\" mat-mini-fab>\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab class=\"button-polu-glavni\">\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n            </div>\r\n        </div>\r\n    </div>\r\n    <div class=\"d-flex justify-content-center\">\r\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\r\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n        </label>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\r\n        <div class=\"filter-div-test d-flex flex-column\">\r\n            <div class=\"d-flex justify-content-center\">\r\n                <h2>\r\n                    Filter\r\n                </h2>\r\n            </div>\r\n            <div class=\"input-group mb-3\">\r\n                <div class=\"input-group-prepend\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Proizvodjac: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\r\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\r\n                       {{proizvodjac.naziv}}\r\n                    </option>\r\n                </select>\r\n\r\n                <div class=\"input-group-prepend razmak\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Raspolozivost: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\r\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\r\n                </select>\r\n            </div>\r\n            <div class=\"d-flex justify-content-center\">\r\n                <div>\r\n                    <button mat-stroked-button class=\"button-glavni\" (click)='filtriraj()'>\r\n                        <p class=\"boja-kontra-bela\">Filtriraj</p>\r\n                    </button>\r\n                    <span class=\"col-2\"></span>\r\n                    <button mat-stroked-button class=\"button-error\" (click)='resetujFilter()'>\r\n                        <p class=\"boja-kontra-bela\">Ponisti</p>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n    <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n        <table mat-table [dataSource]=\"dataSource\">\r\n\r\n            <!-- Kataloski broj Column -->\r\n            <ng-container matColumnDef=\"katbr\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.katbr}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Kataloski broj proizvodjaca Column -->\r\n            <ng-container matColumnDef=\"katbrpro\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.katbrpro}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Naziv Column -->\r\n            <ng-container matColumnDef=\"naziv\">\r\n                <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Proizvodjac Column -->\r\n            <ng-container matColumnDef=\"proizvodjac\">\r\n                <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.proizvodjac.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"rabat\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Rabat </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.rabat | currency:\" \"}}%\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"cena\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.cena | currency:\" \"}} RSD\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Stanje Column -->\r\n            <ng-container matColumnDef=\"stanje\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\" class=\"text-center\">\r\n                        <mat-icon class=\"boja-confirm\">check_circle_outline</mat-icon>\r\n                    </div>\r\n                    <div *ngIf=\"roba.stanje == 0\" class=\"text-center\">\r\n                        <mat-icon class=\"boja-error\">remove_circle_outline</mat-icon>\r\n                    </div>\r\n                </td>\r\n            </ng-container>\r\n\r\n\r\n            <!-- Kolicina Column -->\r\n            <ng-container matColumnDef=\"kolicina\">\r\n                <th mat-header-cell *matHeaderCellDef>Kolicina </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <input type=\"number\" min=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\"\r\n                            [(ngModel)]=\"roba.kolicina\" />\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Kropa dugme Column -->\r\n            <ng-container matColumnDef=\"korpa\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <button mat-raised-button class=\"button-glavni\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Da li ima na stanju ikona -->\r\n            <ng-container matColumnDef=\"u-korpi\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"uKorpi(roba.katbr)\">\r\n                        <mat-icon class=\"boja-error\">add_shopping_cart</mat-icon>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n            <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n        </table>\r\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n        </mat-paginator>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/roba/roba.component.ts":
/*!***********************************************!*\
  !*** ./src/app/e-shop/roba/roba.component.ts ***!
  \***********************************************/
/*! exports provided: RobaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RobaComponent", function() { return RobaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_roba_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../service/proizvodjac.service */ "./src/app/e-shop/service/proizvodjac.service.ts");
/* harmony import */ var _service_data_data_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../service/login.service */ "./src/app/e-shop/service/login.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var RobaComponent = /** @class */ (function () {
    function RobaComponent(robaService, proizvodjacService, loginServis, dataService, utilsService, korpaSnackBar) {
        this.robaService = robaService;
        this.proizvodjacService = proizvodjacService;
        this.loginServis = loginServis;
        this.dataService = dataService;
        this.utilsService = utilsService;
        this.korpaSnackBar = korpaSnackBar;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        // Filteri
        this.izabraniProizvodjac = '';
        this.raspolozivost = ['Svi artikli', 'Ima na stanju'];
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilterDiv = false;
        // Tabela
        this.columnDefinitions = [
            { def: 'katbr', ifNotAuth: true },
            { def: 'katbrpro', ifNotAuth: true },
            { def: 'proizvodjac', ifNotAuth: true },
            { def: 'naziv', ifNotAuth: true },
            { def: 'rabat', ifNotAuth: false },
            { def: 'cena', ifNotAuth: true },
            { def: 'stanje', ifNotAuth: true },
            { def: 'kolicina', ifNotAuth: false },
            { def: 'korpa', ifNotAuth: false },
            { def: 'u-korpi', ifNotAuth: false },
        ];
        this.alive = true;
    }
    RobaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.pronadjiSveProizvodjace();
    };
    RobaComponent.prototype.getDisplayedColumns = function () {
        var isPartner = this.partner.ppid != null;
        var dataColumns = this.columnDefinitions
            .filter(function (cd) { return isPartner || cd.ifNotAuth; })
            .map(function (cd) { return cd.def; });
        return dataColumns;
    };
    RobaComponent.prototype.pronadjiSvuRobu = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiSvuRobu(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    RobaComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.pronadjiSvuRobuPoPretrazi(searchValue);
    };
    RobaComponent.prototype.pronadjiSvuRobuPoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiSvuRobu(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    RobaComponent.prototype.pronadjiSveProizvodjace = function () {
        var _this = this;
        this.proizvodjacService.pronadjiSveProizvodjace()
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
            _this.proizvodjaci = res;
            _this.izabraniProizvodjac = _this.proizvodjaci[0].naziv;
            _this.pronadjiSvuRobu();
        }, function (error) {
            _this.proizvodjaci = null;
            console.log('Pronaci svu robu je bacilo gresku', error);
        });
    };
    RobaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiSvuRobuPoPretrazi(this.searchValue);
    };
    RobaComponent.prototype.sortData = function (sort) {
        this.sort = sort;
        var searchTerm;
        if (this.lastSearchValue) {
            searchTerm = this.lastSearchValue;
        }
        else if (this.searchValue) {
            searchTerm = this.searchValue;
        }
        else {
            searchTerm = null;
        }
        this.pronadjiSvuRobuPoPretrazi(this.searchValue);
    };
    RobaComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilterDiv = !this.otvoriFilterDiv;
    };
    RobaComponent.prototype.resetujFilter = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.filtriraj();
    };
    RobaComponent.prototype.filtriraj = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        var recZaPretragu;
        recZaPretragu = this.searchValue;
        this.pronadjiSvuRobuPoPretrazi(recZaPretragu);
    };
    RobaComponent.prototype.dodajUKorpu = function (roba) {
        var snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.openKorpaSnackBar(snackBarPoruka);
        this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
    };
    RobaComponent.prototype.openKorpaSnackBar = function (poruka) {
        this.korpaSnackBar.open(poruka, '', {
            duration: 2000,
        });
    };
    RobaComponent.prototype.uKorpi = function (katBr) {
        return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
    };
    RobaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-roba',
            template: __webpack_require__(/*! ./roba.component.html */ "./src/app/e-shop/roba/roba.component.html"),
            styles: [__webpack_require__(/*! ./roba.component.css */ "./src/app/e-shop/roba/roba.component.css")]
        }),
        __metadata("design:paramtypes", [_service_roba_service__WEBPACK_IMPORTED_MODULE_1__["RobaService"],
            _service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_5__["ProizvodjacService"],
            _service_login_service__WEBPACK_IMPORTED_MODULE_8__["LoginService"],
            _service_data_data_service__WEBPACK_IMPORTED_MODULE_6__["DataService"],
            _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_7__["AppUtilsService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSnackBar"]])
    ], RobaComponent);
    return RobaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/ulja/antifriz/antifriz.component.css":
/*!******************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/antifriz/antifriz.component.css ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/antifriz/antifriz.component.html":
/*!*******************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/antifriz/antifriz.component.html ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n    <div class=\"d-flex align-items-center justify-content-center\">\r\n        <div class=\"forms-input\">\r\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                <button mat-mini-fab class=\"button-glavni\">\r\n                    <mat-icon>search</mat-icon>\r\n                </button>\r\n            </div>\r\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                <button *ngIf=\"!otvoriFilterDiv\" class=\"button-glavni\" mat-mini-fab>\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab class=\"button-polu-glavni\">\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n            </div>\r\n        </div>\r\n    </div>\r\n    <div class=\"d-flex justify-content-center\">\r\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\r\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n        </label>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\r\n        <div class=\"filter-div-test d-flex flex-column\">\r\n            <div class=\"d-flex justify-content-center\">\r\n                <h2>\r\n                    Filter\r\n                </h2>\r\n            </div>\r\n            <div class=\"input-group mb-3\">\r\n                <div class=\"input-group-prepend\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Proizvodjac: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\r\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\r\n                       {{proizvodjac.naziv}}\r\n                    </option>\r\n                </select>\r\n\r\n                <div class=\"input-group-prepend razmak\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Raspolozivost: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\r\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\r\n                </select>\r\n            </div>\r\n            <div class=\"d-flex justify-content-center\">\r\n                <div>\r\n                    <button mat-stroked-button class=\"button-glavni\" (click)='filtriraj()'>\r\n                        <p class=\"boja-kontra-bela\">Filtriraj</p>\r\n                    </button>\r\n                    <span class=\"col-2\"></span>\r\n                    <button mat-stroked-button class=\"button-error\" (click)='resetujFilter()'>\r\n                        <p class=\"boja-kontra-bela\">Ponisti</p>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n    <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n        <table mat-table [dataSource]=\"dataSource\"       >\r\n            <!-- Kataloski broj Column -->\r\n            <ng-container matColumnDef=\"katbr\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.katbr}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Kataloski broj proizvodjaca Column -->\r\n            <ng-container matColumnDef=\"katbrpro\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.katbrpro}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Naziv Column -->\r\n            <ng-container matColumnDef=\"naziv\">\r\n                <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Proizvodjac Column -->\r\n            <ng-container matColumnDef=\"proizvodjac\">\r\n                <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.proizvodjac.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"rabat\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Rabat </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.rabat | currency:\" \"}}%\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"cena\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.cena | currency:\" \"}} RSD\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Stanje Column -->\r\n            <ng-container matColumnDef=\"stanje\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\" class=\"text-center\">\r\n                        <mat-icon class=\"boja-confirm\">check_circle_outline</mat-icon>\r\n                    </div>\r\n                    <div *ngIf=\"roba.stanje == 0\" class=\"text-center\">\r\n                        <mat-icon class=\"boja-error\">remove_circle_outline</mat-icon>\r\n                    </div>\r\n                </td>\r\n            </ng-container>\r\n\r\n\r\n            <!-- Kolicina Column -->\r\n            <ng-container matColumnDef=\"kolicina\">\r\n                <th mat-header-cell *matHeaderCellDef>Kolicina </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <input type=\"number\" min=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\"\r\n                            [(ngModel)]=\"roba.kolicina\" />\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Kropa dugme Column -->\r\n            <ng-container matColumnDef=\"korpa\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <button mat-raised-button class=\"button-glavni\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Da li ima na stanju ikona -->\r\n            <ng-container matColumnDef=\"u-korpi\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"uKorpi(roba.katbr)\">\r\n                        <mat-icon class=\"boja-error\">add_shopping_cart</mat-icon>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n            <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n        </table>\r\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n        </mat-paginator>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/antifriz/antifriz.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/antifriz/antifriz.component.ts ***!
  \*****************************************************************/
/*! exports provided: AntifrizComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AntifrizComponent", function() { return AntifrizComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/service/proizvodjac.service */ "./src/app/e-shop/service/proizvodjac.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var AntifrizComponent = /** @class */ (function () {
    function AntifrizComponent(robaService, utilsService, loginServis, proizvodjacService, dataService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
        this.loginServis = loginServis;
        this.proizvodjacService = proizvodjacService;
        this.dataService = dataService;
        this.korpaSnackBar = korpaSnackBar;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        // Filteri
        this.izabraniProizvodjac = '';
        this.raspolozivost = ['Svi artikli', 'Ima na stanju'];
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilterDiv = false;
        // Tabela
        this.columnDefinitions = [
            { def: 'katbr', ifNotAuth: true },
            { def: 'katbrpro', ifNotAuth: true },
            { def: 'proizvodjac', ifNotAuth: true },
            { def: 'naziv', ifNotAuth: true },
            { def: 'rabat', ifNotAuth: false },
            { def: 'cena', ifNotAuth: true },
            { def: 'stanje', ifNotAuth: true },
            { def: 'kolicina', ifNotAuth: false },
            { def: 'korpa', ifNotAuth: false },
            { def: 'u-korpi', ifNotAuth: false },
        ];
        this.alive = true;
        this.vrstaUlja = 'antifriz';
    }
    AntifrizComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.pronadjiSveProizvodjace();
    };
    AntifrizComponent.prototype.getDisplayedColumns = function () {
        var isPartner = this.partner.ppid != null;
        var dataColumns = this.columnDefinitions
            .filter(function (cd) { return isPartner || cd.ifNotAuth; })
            .map(function (cd) { return cd.def; });
        return dataColumns;
    };
    AntifrizComponent.prototype.pronandjiSavAntifriz = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    AntifrizComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    AntifrizComponent.prototype.pronadjiSveProizvodjace = function () {
        var _this = this;
        this.proizvodjacService.pronadjiSveProizvodjaceUljaPoVrsti(this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
            _this.proizvodjaci = res;
            _this.izabraniProizvodjac = _this.proizvodjaci[0].naziv;
            _this.pronandjiSavAntifriz();
        }, function (error) {
            _this.proizvodjaci = null;
            console.log('Pronaci svu robu je bacilo gresku', error);
        });
    };
    AntifrizComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.pronadjiEntitetePoPretrazi(searchValue);
    };
    AntifrizComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    AntifrizComponent.prototype.sortData = function (sort) {
        this.sort = sort;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    AntifrizComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilterDiv = !this.otvoriFilterDiv;
    };
    AntifrizComponent.prototype.resetujFilter = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.filtriraj();
    };
    AntifrizComponent.prototype.filtriraj = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        var recZaPretragu;
        recZaPretragu = this.searchValue;
        this.pronadjiEntitetePoPretrazi(recZaPretragu);
    };
    AntifrizComponent.prototype.dodajUKorpu = function (roba) {
        var snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.openKorpaSnackBar(snackBarPoruka);
        this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
    };
    AntifrizComponent.prototype.openKorpaSnackBar = function (poruka) {
        this.korpaSnackBar.open(poruka, '', {
            duration: 2000,
        });
    };
    AntifrizComponent.prototype.uKorpi = function (katBr) {
        return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
    };
    AntifrizComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-antifriz',
            template: __webpack_require__(/*! ./antifriz.component.html */ "./src/app/e-shop/roba/ulja/antifriz/antifriz.component.html"),
            styles: [__webpack_require__(/*! ./antifriz.component.css */ "./src/app/e-shop/roba/ulja/antifriz/antifriz.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_4__["RobaService"],
            src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__["LoginService"],
            src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_7__["ProizvodjacService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__["DataService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]])
    ], AntifrizComponent);
    return AntifrizComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/ulja/industrijska/industrijska.component.css":
/*!**************************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/industrijska/industrijska.component.css ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".smanji {\r\n    width: 450px;\r\n    float: right;\r\n}\r\n.forms-input-industrija {\r\n    display: flex;\r\n    border-radius: 45px;\r\n    padding: 1px;\r\n    margin-top: 5px;\r\n    background: white;\r\n    border:2px solid grey;\r\n    width: 40%;\r\n    font-weight: bold;\r\n    text-align: center;\r\n}\r\n@media only screen and (max-device-width :1025px) { \r\n\r\n    .forms-input-industrija {\r\n      display: flex;\r\n      border-radius: 45px;\r\n      padding: 1px;\r\n      margin-top: 30px;\r\n      background: white;\r\n      border:2px solid grey;\r\n      width: 80%;\r\n      font-weight: bold;\r\n      text-align: center;\r\n    }\r\n  }\r\n@media only screen and (max-device-width : 640px) { \r\n    .smanji {\r\n        width: 100%;\r\n    }\r\n    .forms-input-industrija {\r\n      border-radius: 45px;\r\n      background: white;\r\n      border:2px solid grey;\r\n      width:100%;\r\n      margin-top: 5px;\r\n      font-weight: bold;\r\n      text-align: center;\r\n      display: flex;\r\n      }  \r\n}"

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/industrijska/industrijska.component.html":
/*!***************************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/industrijska/industrijska.component.html ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <div class=\"d-flex col-lg p-2 justify-content-center smanji\">\r\n        <div class=\"input-group-prepend\">\r\n            <label class=\"pozadina-glavna boja-kontra-bela input-group-text \" for=\"inputGroupSelect01\">Izaberite vrstu\r\n                maziva:</label>\r\n        </div>\r\n        <select class=\"custom-select\" (change)=\"onChange()\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaVrsta\">\r\n            <option *ngFor=\"let izabranaVrsta of vrste\" [value]=\"izabranaVrsta\">{{izabranaVrsta}}</option>\r\n        </select>\r\n    </div>\r\n    <div class=\"d-flex align-items-center col-lg justify-content-center\">\r\n        <div class=\"forms-input-industrija\">\r\n            <input class=\"flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                <button mat-mini-fab class=\"button-glavni\">\r\n                    <mat-icon>search</mat-icon>\r\n                </button>\r\n            </div>\r\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                <button *ngIf=\"!otvoriFilterDiv\" class=\"button-glavni\" mat-mini-fab>\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab class=\"button-polu-glavni\">\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n            </div>\r\n        </div>\r\n    </div>\r\n    <div class=\"d-flex justify-content-center\">\r\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\r\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n        </label>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\r\n        <div class=\"filter-div-test d-flex flex-column\">\r\n            <div class=\"d-flex justify-content-center\">\r\n                <h2>\r\n                    Filter\r\n                </h2>\r\n            </div>\r\n            <div class=\"input-group mb-3\">\r\n                <div class=\"input-group-prepend\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Proizvodjac: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\r\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\r\n                        {{proizvodjac.naziv}}\r\n                    </option>\r\n                </select>\r\n\r\n                <div class=\"input-group-prepend razmak\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Raspolozivost: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\r\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\r\n                </select>\r\n            </div>\r\n            <div class=\"d-flex justify-content-center\">\r\n                <div>\r\n                    <button mat-stroked-button class=\"button-glavni\" (click)='filtriraj()'>\r\n                        <p class=\"boja-kontra-bela\">Filtriraj</p>\r\n                    </button>\r\n                    <span class=\"col-2\"></span>\r\n                    <button mat-stroked-button class=\"button-error\" (click)='resetujFilter()'>\r\n                        <p class=\"boja-kontra-bela\">Ponisti</p>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n    <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n        <table mat-table [dataSource]=\"dataSource\"       >\r\n            <!-- Kataloski broj Column -->\r\n            <ng-container matColumnDef=\"katbr\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.katbr}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Kataloski broj proizvodjaca Column -->\r\n            <ng-container matColumnDef=\"katbrpro\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.katbrpro}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Naziv Column -->\r\n            <ng-container matColumnDef=\"naziv\">\r\n                <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Proizvodjac Column -->\r\n            <ng-container matColumnDef=\"proizvodjac\">\r\n                <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.proizvodjac.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"rabat\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Rabat </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.rabat | currency:\" \"}}%\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"cena\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.cena | currency:\" \"}} RSD\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Stanje Column -->\r\n            <ng-container matColumnDef=\"stanje\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\" class=\"text-center\">\r\n                        <mat-icon class=\"boja-confirm\">check_circle_outline</mat-icon>\r\n                    </div>\r\n                    <div *ngIf=\"roba.stanje == 0\" class=\"text-center\">\r\n                        <mat-icon class=\"boja-error\">remove_circle_outline</mat-icon>\r\n                    </div>\r\n                </td>\r\n            </ng-container>\r\n\r\n\r\n            <!-- Kolicina Column -->\r\n            <ng-container matColumnDef=\"kolicina\">\r\n                <th mat-header-cell *matHeaderCellDef>Kolicina </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <input type=\"number\" min=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\" />\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Kropa dugme Column -->\r\n            <ng-container matColumnDef=\"korpa\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <button mat-raised-button class=\"button-glavni\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Da li ima na stanju ikona -->\r\n            <ng-container matColumnDef=\"u-korpi\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"uKorpi(roba.katbr)\">\r\n                        <mat-icon class=\"boja-error\">add_shopping_cart</mat-icon>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n            <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n        </table>\r\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n        </mat-paginator>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/industrijska/industrijska.component.ts":
/*!*************************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/industrijska/industrijska.component.ts ***!
  \*************************************************************************/
/*! exports provided: IndustrijskaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "IndustrijskaComponent", function() { return IndustrijskaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/service/proizvodjac.service */ "./src/app/e-shop/service/proizvodjac.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var IndustrijskaComponent = /** @class */ (function () {
    function IndustrijskaComponent(robaService, utilsService, loginServis, proizvodjacService, dataService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
        this.loginServis = loginServis;
        this.proizvodjacService = proizvodjacService;
        this.dataService = dataService;
        this.korpaSnackBar = korpaSnackBar;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        // Filteri
        this.izabraniProizvodjac = '';
        this.raspolozivost = ['Svi artikli', 'Ima na stanju'];
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilterDiv = false;
        // Tabela
        this.columnDefinitions = [
            { def: 'katbr', ifNotAuth: true },
            { def: 'katbrpro', ifNotAuth: true },
            { def: 'proizvodjac', ifNotAuth: true },
            { def: 'naziv', ifNotAuth: true },
            { def: 'rabat', ifNotAuth: false },
            { def: 'cena', ifNotAuth: true },
            { def: 'stanje', ifNotAuth: true },
            { def: 'kolicina', ifNotAuth: false },
            { def: 'korpa', ifNotAuth: false },
            { def: 'u-korpi', ifNotAuth: false },
        ];
        this.vrste = ['Hidraulično ulje', 'Kompresorkso ulje', 'Reduktorsko ulje',
            'Transformatorsko ulje', 'Turbinska ulja', 'Ulja za pneumatske alate', 'Ulja za klizne staze', 'Ulja za prenos toplote'];
        this.izabranaVrsta = this.vrste[0];
        this.vrsteUlja = [
            { 'url': 'hidraulicna', 'naziv': 'Hidraulično ulje' },
            { 'url': 'kompresorska', 'naziv': 'Kompresorkso ulje' },
            { 'url': 'redutktorska', 'naziv': 'Reduktorsko ulje' },
            { 'url': 'transformatorska', 'naziv': 'Transformatorsko ulje' },
            { 'url': 'turbinska', 'naziv': 'Turbinska ulja' },
            { 'url': 'pneumatska', 'naziv': 'Ulja za pneumatske alate' },
            { 'url': 'klizna', 'naziv': 'Ulja za klizne staze' },
            { 'url': 'prenosna', 'naziv': 'Ulja za prenos toplote' },
        ];
        this.alive = true;
        this.vrstaUlja = 'hidraulicna';
    }
    IndustrijskaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.pronadjiSveProizvodjace();
    };
    IndustrijskaComponent.prototype.getDisplayedColumns = function () {
        var isPartner = this.partner.ppid != null;
        var dataColumns = this.columnDefinitions
            .filter(function (cd) { return isPartner || cd.ifNotAuth; })
            .map(function (cd) { return cd.def; });
        return dataColumns;
    };
    IndustrijskaComponent.prototype.pronandjiUlja = function () {
        var _this = this;
        this.dataSource = null;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    IndustrijskaComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    IndustrijskaComponent.prototype.pronadjiSveProizvodjace = function () {
        var _this = this;
        this.proizvodjacService.pronadjiSveProizvodjaceUljaPoVrsti(this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
            _this.proizvodjaci = res;
            _this.izabraniProizvodjac = _this.proizvodjaci[0].naziv;
            _this.pronandjiUlja();
        }, function (error) {
            _this.proizvodjaci = null;
            console.log('Pronaci svu robu je bacilo gresku', error);
        });
    };
    IndustrijskaComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.pronadjiEntitetePoPretrazi(searchValue);
    };
    IndustrijskaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    IndustrijskaComponent.prototype.sortData = function (sort) {
        this.sort = sort;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    IndustrijskaComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilterDiv = !this.otvoriFilterDiv;
    };
    IndustrijskaComponent.prototype.resetujFilter = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.filtriraj();
    };
    IndustrijskaComponent.prototype.filtriraj = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        var recZaPretragu;
        recZaPretragu = this.searchValue;
        this.pronadjiEntitetePoPretrazi(recZaPretragu);
    };
    IndustrijskaComponent.prototype.onChange = function () {
        var _this = this;
        this.vrsteUlja.forEach(function (vrsta) {
            if (vrsta.naziv === _this.izabranaVrsta) {
                _this.vrstaUlja = vrsta.url;
            }
        });
        this.pronadjiSveProizvodjace();
    };
    IndustrijskaComponent.prototype.dodajUKorpu = function (roba) {
        var snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.openKorpaSnackBar(snackBarPoruka);
        this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
    };
    IndustrijskaComponent.prototype.openKorpaSnackBar = function (poruka) {
        this.korpaSnackBar.open(poruka, '', {
            duration: 2000,
        });
    };
    IndustrijskaComponent.prototype.uKorpi = function (katBr) {
        return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
    };
    IndustrijskaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-industrijska',
            template: __webpack_require__(/*! ./industrijska.component.html */ "./src/app/e-shop/roba/ulja/industrijska/industrijska.component.html"),
            styles: [__webpack_require__(/*! ./industrijska.component.css */ "./src/app/e-shop/roba/ulja/industrijska/industrijska.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_4__["RobaService"],
            src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__["LoginService"],
            src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_7__["ProizvodjacService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__["DataService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]])
    ], IndustrijskaComponent);
    return IndustrijskaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/ulja/kociona/kociona.component.css":
/*!****************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/kociona/kociona.component.css ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/kociona/kociona.component.html":
/*!*****************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/kociona/kociona.component.html ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n    <div class=\"d-flex align-items-center justify-content-center\">\r\n        <div class=\"forms-input\">\r\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                <button mat-mini-fab class=\"button-glavni\">\r\n                    <mat-icon>search</mat-icon>\r\n                </button>\r\n            </div>\r\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                <button *ngIf=\"!otvoriFilterDiv\" class=\"button-glavni\" mat-mini-fab>\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab class=\"button-polu-glavni\">\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n            </div>\r\n        </div>\r\n    </div>\r\n    <div class=\"d-flex justify-content-center\">\r\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\r\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n        </label>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\r\n        <div class=\"filter-div-test d-flex flex-column\">\r\n            <div class=\"d-flex justify-content-center\">\r\n                <h2>\r\n                    Filter\r\n                </h2>\r\n            </div>\r\n            <div class=\"input-group mb-3\">\r\n                <div class=\"input-group-prepend\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Proizvodjac: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\r\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\r\n                      {{proizvodjac.naziv}}\r\n                    </option>\r\n                </select>\r\n\r\n                <div class=\"input-group-prepend razmak\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Raspolozivost: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\r\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\r\n                </select>\r\n            </div>\r\n            <div class=\"d-flex justify-content-center\">\r\n                <div>\r\n                    <button mat-stroked-button class=\"button-glavni\" (click)='filtriraj()'>\r\n                        <p class=\"boja-kontra-bela\">Filtriraj</p>\r\n                    </button>\r\n                    <span class=\"col-2\"></span>\r\n                    <button mat-stroked-button class=\"button-error\" (click)='resetujFilter()'>\r\n                        <p class=\"boja-kontra-bela\">Ponisti</p>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n    <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n        <table mat-table [dataSource]=\"dataSource\"       >\r\n            <!-- Kataloski broj Column -->\r\n            <ng-container matColumnDef=\"katbr\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.katbr}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Kataloski broj proizvodjaca Column -->\r\n            <ng-container matColumnDef=\"katbrpro\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.katbrpro}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Naziv Column -->\r\n            <ng-container matColumnDef=\"naziv\">\r\n                <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Proizvodjac Column -->\r\n            <ng-container matColumnDef=\"proizvodjac\">\r\n                <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.proizvodjac.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"rabat\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Rabat </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.rabat | currency:\" \"}}%\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"cena\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.cena | currency:\" \"}} RSD\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Stanje Column -->\r\n            <ng-container matColumnDef=\"stanje\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\" class=\"text-center\">\r\n                        <mat-icon class=\"boja-confirm\">check_circle_outline</mat-icon>\r\n                    </div>\r\n                    <div *ngIf=\"roba.stanje == 0\" class=\"text-center\">\r\n                        <mat-icon class=\"boja-error\">remove_circle_outline</mat-icon>\r\n                    </div>\r\n                </td>\r\n            </ng-container>\r\n\r\n\r\n            <!-- Kolicina Column -->\r\n            <ng-container matColumnDef=\"kolicina\">\r\n                <th mat-header-cell *matHeaderCellDef>Kolicina </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <input type=\"number\" min=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\"\r\n                            [(ngModel)]=\"roba.kolicina\" />\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Kropa dugme Column -->\r\n            <ng-container matColumnDef=\"korpa\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <button mat-raised-button class=\"button-glavni\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Da li ima na stanju ikona -->\r\n            <ng-container matColumnDef=\"u-korpi\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"uKorpi(roba.katbr)\">\r\n                        <mat-icon class=\"boja-error\">add_shopping_cart</mat-icon>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n            <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n        </table>\r\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n        </mat-paginator>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/kociona/kociona.component.ts":
/*!***************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/kociona/kociona.component.ts ***!
  \***************************************************************/
/*! exports provided: KocionaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KocionaComponent", function() { return KocionaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/service/proizvodjac.service */ "./src/app/e-shop/service/proizvodjac.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var KocionaComponent = /** @class */ (function () {
    function KocionaComponent(robaService, utilsService, loginServis, proizvodjacService, dataService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
        this.loginServis = loginServis;
        this.proizvodjacService = proizvodjacService;
        this.dataService = dataService;
        this.korpaSnackBar = korpaSnackBar;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        // Filteri
        this.izabraniProizvodjac = '';
        this.raspolozivost = ['Svi artikli', 'Ima na stanju'];
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilterDiv = false;
        // Tabela
        this.columnDefinitions = [
            { def: 'katbr', ifNotAuth: true },
            { def: 'katbrpro', ifNotAuth: true },
            { def: 'proizvodjac', ifNotAuth: true },
            { def: 'naziv', ifNotAuth: true },
            { def: 'rabat', ifNotAuth: false },
            { def: 'cena', ifNotAuth: true },
            { def: 'stanje', ifNotAuth: true },
            { def: 'kolicina', ifNotAuth: false },
            { def: 'korpa', ifNotAuth: false },
            { def: 'u-korpi', ifNotAuth: false },
        ];
        this.alive = true;
        this.vrstaUlja = 'kociona';
    }
    KocionaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.pronadjiSveProizvodjace();
    };
    KocionaComponent.prototype.getDisplayedColumns = function () {
        var isPartner = this.partner.ppid != null;
        var dataColumns = this.columnDefinitions
            .filter(function (cd) { return isPartner || cd.ifNotAuth; })
            .map(function (cd) { return cd.def; });
        return dataColumns;
    };
    KocionaComponent.prototype.pronandjiSvaKocionaUlja = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    KocionaComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    KocionaComponent.prototype.pronadjiSveProizvodjace = function () {
        var _this = this;
        this.proizvodjacService.pronadjiSveProizvodjaceUljaPoVrsti(this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
            _this.proizvodjaci = res;
            _this.izabraniProizvodjac = _this.proizvodjaci[0].naziv;
            _this.pronandjiSvaKocionaUlja();
        }, function (error) {
            _this.proizvodjaci = null;
            console.log('Pronaci svu robu je bacilo gresku', error);
        });
    };
    KocionaComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.pronadjiEntitetePoPretrazi(searchValue);
    };
    KocionaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    KocionaComponent.prototype.sortData = function (sort) {
        this.sort = sort;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    KocionaComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilterDiv = !this.otvoriFilterDiv;
    };
    KocionaComponent.prototype.resetujFilter = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.filtriraj();
    };
    KocionaComponent.prototype.filtriraj = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        var recZaPretragu;
        recZaPretragu = this.searchValue;
        this.pronadjiEntitetePoPretrazi(recZaPretragu);
    };
    KocionaComponent.prototype.dodajUKorpu = function (roba) {
        var snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.openKorpaSnackBar(snackBarPoruka);
        this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
    };
    KocionaComponent.prototype.openKorpaSnackBar = function (poruka) {
        this.korpaSnackBar.open(poruka, '', {
            duration: 2000,
        });
    };
    KocionaComponent.prototype.uKorpi = function (katBr) {
        return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
    };
    KocionaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-kociona',
            template: __webpack_require__(/*! ./kociona.component.html */ "./src/app/e-shop/roba/ulja/kociona/kociona.component.html"),
            styles: [__webpack_require__(/*! ./kociona.component.css */ "./src/app/e-shop/roba/ulja/kociona/kociona.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_5__["RobaService"],
            src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__["AppUtilsService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__["LoginService"],
            src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_7__["ProizvodjacService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__["DataService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]])
    ], KocionaComponent);
    return KocionaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/ulja/menjacko/menjacko.component.css":
/*!******************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/menjacko/menjacko.component.css ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/menjacko/menjacko.component.html":
/*!*******************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/menjacko/menjacko.component.html ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n    <div class=\"d-flex align-items-center justify-content-center\">\r\n        <div class=\"forms-input\">\r\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                <button mat-mini-fab class=\"button-glavni\">\r\n                    <mat-icon>search</mat-icon>\r\n                </button>\r\n            </div>\r\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                <button *ngIf=\"!otvoriFilterDiv\" class=\"button-glavni\" mat-mini-fab>\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab class=\"button-polu-glavni\">\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n            </div>\r\n        </div>\r\n    </div>\r\n    <div class=\"d-flex justify-content-center\">\r\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\r\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n        </label>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\r\n        <div class=\"filter-div-test d-flex flex-column\">\r\n            <div class=\"d-flex justify-content-center\">\r\n                <h2>\r\n                    Filter\r\n                </h2>\r\n            </div>\r\n            <div class=\"input-group mb-3\">\r\n                <div class=\"input-group-prepend\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Proizvodjac: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\r\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\r\n                        {{proizvodjac.naziv}}\r\n                    </option>\r\n                </select>\r\n\r\n                <div class=\"input-group-prepend razmak\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Raspolozivost: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\r\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\r\n                </select>\r\n            </div>\r\n            <div class=\"d-flex justify-content-center\">\r\n                <div>\r\n                    <button mat-stroked-button class=\"button-glavni\" (click)='filtriraj()'>\r\n                        <p class=\"boja-kontra-bela\">Filtriraj</p>\r\n                    </button>\r\n                    <span class=\"col-2\"></span>\r\n                    <button mat-stroked-button class=\"button-error\" (click)='resetujFilter()'>\r\n                        <p class=\"boja-kontra-bela\">Ponisti</p>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n    <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n        <table mat-table [dataSource]=\"dataSource\"       >\r\n            <!-- Kataloski broj Column -->\r\n            <ng-container matColumnDef=\"katbr\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.katbr}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Kataloski broj proizvodjaca Column -->\r\n            <ng-container matColumnDef=\"katbrpro\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.katbrpro}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Naziv Column -->\r\n            <ng-container matColumnDef=\"naziv\">\r\n                <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Proizvodjac Column -->\r\n            <ng-container matColumnDef=\"proizvodjac\">\r\n                <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.proizvodjac.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"rabat\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Rabat </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.rabat | currency:\" \"}}%\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"cena\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.cena | currency:\" \"}} RSD\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n    \r\n                <!-- Stanje Column -->\r\n                <ng-container matColumnDef=\"stanje\">\r\n                    <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\" class=\"text-center\">\r\n                            <mat-icon class=\"boja-confirm\">check_circle_outline</mat-icon>\r\n                        </div>\r\n                        <div *ngIf=\"roba.stanje == 0\" class=\"text-center\">\r\n                            <mat-icon class=\"boja-error\">remove_circle_outline</mat-icon>\r\n                        </div>\r\n                    </td>\r\n                </ng-container>\r\n\r\n\r\n            <!-- Kolicina Column -->\r\n            <ng-container matColumnDef=\"kolicina\">\r\n                <th mat-header-cell *matHeaderCellDef>Kolicina </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <input type=\"number\" min=\"0\" placeholder=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\" />\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Kropa dugme Column -->\r\n            <ng-container matColumnDef=\"korpa\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <button mat-raised-button class=\"button-glavni\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Da li ima na stanju ikona -->\r\n            <ng-container matColumnDef=\"u-korpi\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"uKorpi(roba.katbr)\">\r\n                        <mat-icon class=\"boja-error\">add_shopping_cart</mat-icon>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n            <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n        </table>\r\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n        </mat-paginator>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/menjacko/menjacko.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/menjacko/menjacko.component.ts ***!
  \*****************************************************************/
/*! exports provided: MenjackoComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MenjackoComponent", function() { return MenjackoComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/service/proizvodjac.service */ "./src/app/e-shop/service/proizvodjac.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var MenjackoComponent = /** @class */ (function () {
    function MenjackoComponent(robaService, utilsService, proizvodjacService, loginServis, dataService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
        this.proizvodjacService = proizvodjacService;
        this.loginServis = loginServis;
        this.dataService = dataService;
        this.korpaSnackBar = korpaSnackBar;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        // Filteri
        this.izabraniProizvodjac = '';
        this.raspolozivost = ['Svi artikli', 'Ima na stanju'];
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilterDiv = false;
        // Tabela
        this.columnDefinitions = [
            { def: 'katbr', ifNotAuth: true },
            { def: 'katbrpro', ifNotAuth: true },
            { def: 'proizvodjac', ifNotAuth: true },
            { def: 'rabat', ifNotAuth: false },
            { def: 'naziv', ifNotAuth: true },
            { def: 'cena', ifNotAuth: true },
            { def: 'stanje', ifNotAuth: true },
            { def: 'kolicina', ifNotAuth: false },
            { def: 'korpa', ifNotAuth: false },
            { def: 'u-korpi', ifNotAuth: false },
        ];
        this.alive = true;
        this.vrstaUlja = 'menjacka';
    }
    MenjackoComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.pronadjiSveProizvodjace();
    };
    MenjackoComponent.prototype.getDisplayedColumns = function () {
        var isPartner = this.partner.ppid != null;
        var dataColumns = this.columnDefinitions
            .filter(function (cd) { return isPartner || cd.ifNotAuth; })
            .map(function (cd) { return cd.def; });
        return dataColumns;
    };
    MenjackoComponent.prototype.pronandjiSvaMenjackaUlja = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    MenjackoComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    MenjackoComponent.prototype.pronadjiSveProizvodjace = function () {
        var _this = this;
        this.proizvodjacService.pronadjiSveProizvodjaceUljaPoVrsti(this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
            _this.proizvodjaci = res;
            _this.izabraniProizvodjac = _this.proizvodjaci[0].naziv;
            _this.pronandjiSvaMenjackaUlja();
        }, function (error) {
            _this.proizvodjaci = null;
            console.log('Pronaci svu robu je bacilo gresku', error);
        });
    };
    MenjackoComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.pronadjiEntitetePoPretrazi(searchValue);
    };
    MenjackoComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    MenjackoComponent.prototype.sortData = function (sort) {
        this.sort = sort;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    MenjackoComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilterDiv = !this.otvoriFilterDiv;
    };
    MenjackoComponent.prototype.resetujFilter = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.filtriraj();
    };
    MenjackoComponent.prototype.filtriraj = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        var recZaPretragu;
        recZaPretragu = this.searchValue;
        this.pronadjiEntitetePoPretrazi(recZaPretragu);
    };
    MenjackoComponent.prototype.dodajUKorpu = function (roba) {
        var snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.openKorpaSnackBar(snackBarPoruka);
        this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
    };
    MenjackoComponent.prototype.openKorpaSnackBar = function (poruka) {
        this.korpaSnackBar.open(poruka, '', {
            duration: 2000,
        });
    };
    MenjackoComponent.prototype.uKorpi = function (katBr) {
        return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
    };
    MenjackoComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-menjacko',
            template: __webpack_require__(/*! ./menjacko.component.html */ "./src/app/e-shop/roba/ulja/menjacko/menjacko.component.html"),
            styles: [__webpack_require__(/*! ./menjacko.component.css */ "./src/app/e-shop/roba/ulja/menjacko/menjacko.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_4__["RobaService"],
            src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_7__["ProizvodjacService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__["LoginService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__["DataService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]])
    ], MenjackoComponent);
    return MenjackoComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/ulja/motorna/motorna.component.css":
/*!****************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/motorna/motorna.component.css ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/motorna/motorna.component.html":
/*!*****************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/motorna/motorna.component.html ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n    <div class=\"d-flex align-items-center justify-content-center\">\r\n        <div class=\"forms-input\">\r\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                <button mat-mini-fab class=\"button-glavni\">\r\n                    <mat-icon>search</mat-icon>\r\n                </button>\r\n            </div>\r\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                <button *ngIf=\"!otvoriFilterDiv\" class=\"button-glavni\" mat-mini-fab>\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab class=\"button-polu-glavni\">\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n            </div>\r\n        </div>\r\n    </div>\r\n    <div class=\"d-flex justify-content-center\">\r\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\r\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n        </label>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\r\n        <div class=\"filter-div-test d-flex flex-column\">\r\n            <div class=\"d-flex justify-content-center\">\r\n                <h2>\r\n                    Filter\r\n                </h2>\r\n            </div>\r\n            <div class=\"input-group mb-3\">\r\n                <div class=\"input-group-prepend\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Proizvodjac: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\r\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\r\n                       {{proizvodjac.naziv}}\r\n                    </option>\r\n                </select>\r\n\r\n                <div class=\"input-group-prepend razmak\">\r\n                    <label class=\"input-group-text button-glavni-50\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-kontra-bela\">Raspolozivost: </p>\r\n                    </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\r\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\r\n                </select>\r\n            </div>\r\n            <div class=\"d-flex justify-content-center\">\r\n                <div>\r\n                    <button mat-stroked-button class=\"button-glavni\" (click)='filtriraj()'>\r\n                        <p class=\"boja-kontra-bela\">Filtriraj</p>\r\n                    </button>\r\n                    <span class=\"col-2\"></span>\r\n                    <button mat-stroked-button class=\"button-error\" (click)='resetujFilter()'>\r\n                        <p class=\"boja-kontra-bela\">Ponisti</p>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n    <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n        <table mat-table [dataSource]=\"dataSource\"       >\r\n            <!-- Kataloski broj Column -->\r\n            <ng-container matColumnDef=\"katbr\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.katbr}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Kataloski broj proizvodjaca Column -->\r\n            <ng-container matColumnDef=\"katbrpro\">\r\n                <th mat-header-cell    *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.katbrpro}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Naziv Column -->\r\n            <ng-container matColumnDef=\"naziv\">\r\n                <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-1\">\r\n                        {{roba.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Proizvodjac Column -->\r\n            <ng-container matColumnDef=\"proizvodjac\">\r\n                <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2\">\r\n                        {{roba.proizvodjac.naziv}}\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"rabat\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Rabat </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.rabat | currency:\" \"}}%\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n\r\n            <!-- Cena Column -->\r\n            <ng-container matColumnDef=\"cena\">\r\n                <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <p class=\"mat-body-2 text-right iznos-margin\">\r\n                            {{roba.cena | currency:\" \"}} RSD\r\n                    </p>\r\n                </td>\r\n            </ng-container>\r\n    \r\n                <!-- Stanje Column -->\r\n                <ng-container matColumnDef=\"stanje\">\r\n                    <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\" class=\"text-center\">\r\n                            <mat-icon class=\"boja-confirm\">check_circle_outline</mat-icon>\r\n                        </div>\r\n                        <div *ngIf=\"roba.stanje == 0\" class=\"text-center\">\r\n                            <mat-icon class=\"boja-error\">remove_circle_outline</mat-icon>\r\n                        </div>\r\n                    </td>\r\n                </ng-container>\r\n\r\n\r\n            <!-- Kolicina Column -->\r\n            <ng-container matColumnDef=\"kolicina\">\r\n                <th mat-header-cell *matHeaderCellDef>Kolicina </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <input type=\"number\" min=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\"/>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Kropa dugme Column -->\r\n            <ng-container matColumnDef=\"korpa\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"roba.stanje > 0\">\r\n                        <button mat-raised-button class=\"button-glavni\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <!-- Da li ima na stanju ikona -->\r\n            <ng-container matColumnDef=\"u-korpi\">\r\n                <th mat-header-cell *matHeaderCellDef> </th>\r\n                <td mat-cell *matCellDef=\"let roba\">\r\n                    <div *ngIf=\"uKorpi(roba.katbr)\">\r\n                        <mat-icon class=\"boja-error\">add_shopping_cart</mat-icon>\r\n                    </div>\r\n            </ng-container>\r\n\r\n            <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n            <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n        </table>\r\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n        </mat-paginator>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/motorna/motorna.component.ts":
/*!***************************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/motorna/motorna.component.ts ***!
  \***************************************************************/
/*! exports provided: MotornaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MotornaComponent", function() { return MotornaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/service/proizvodjac.service */ "./src/app/e-shop/service/proizvodjac.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var MotornaComponent = /** @class */ (function () {
    function MotornaComponent(robaService, utilsService, proizvodjacService, loginServis, dataService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
        this.proizvodjacService = proizvodjacService;
        this.loginServis = loginServis;
        this.dataService = dataService;
        this.korpaSnackBar = korpaSnackBar;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        // Filteri
        this.izabraniProizvodjac = '';
        this.raspolozivost = ['Svi artikli', 'Ima na stanju'];
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilterDiv = false;
        // Tabela
        this.columnDefinitions = [
            { def: 'katbr', ifNotAuth: true },
            { def: 'katbrpro', ifNotAuth: true },
            { def: 'proizvodjac', ifNotAuth: true },
            { def: 'naziv', ifNotAuth: true },
            { def: 'rabat', ifNotAuth: false },
            { def: 'cena', ifNotAuth: true },
            { def: 'stanje', ifNotAuth: true },
            { def: 'kolicina', ifNotAuth: false },
            { def: 'korpa', ifNotAuth: false },
            { def: 'u-korpi', ifNotAuth: false },
        ];
        this.alive = true;
        this.vrstaUlja = 'motorna';
    }
    MotornaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
        this.pronadjiSveProizvodjace();
    };
    MotornaComponent.prototype.getDisplayedColumns = function () {
        var isPartner = this.partner.ppid != null;
        var dataColumns = this.columnDefinitions
            .filter(function (cd) { return isPartner || cd.ifNotAuth; })
            .map(function (cd) { return cd.def; });
        return dataColumns;
    };
    MotornaComponent.prototype.pronandjiSvoMotornoUlje = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    MotornaComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_3__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
        });
    };
    MotornaComponent.prototype.pronadjiSveProizvodjace = function () {
        var _this = this;
        this.proizvodjacService.pronadjiSveProizvodjaceUljaPoVrsti(this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
            _this.proizvodjaci = res;
            _this.izabraniProizvodjac = _this.proizvodjaci[0].naziv;
            _this.pronandjiSvoMotornoUlje();
        }, function (error) {
            _this.proizvodjaci = null;
            console.log('Pronaci svu robu je bacilo gresku', error);
        });
    };
    MotornaComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.pronadjiEntitetePoPretrazi(searchValue);
    };
    MotornaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    MotornaComponent.prototype.sortData = function (sort) {
        this.sort = sort;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    MotornaComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilterDiv = !this.otvoriFilterDiv;
    };
    MotornaComponent.prototype.resetujFilter = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.izabranaRaspolozivost = this.raspolozivost[1];
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.filtriraj();
    };
    MotornaComponent.prototype.filtriraj = function () {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        var recZaPretragu;
        recZaPretragu = this.searchValue;
        this.pronadjiEntitetePoPretrazi(recZaPretragu);
    };
    MotornaComponent.prototype.dodajUKorpu = function (roba) {
        var snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.openKorpaSnackBar(snackBarPoruka);
        this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
    };
    MotornaComponent.prototype.openKorpaSnackBar = function (poruka) {
        this.korpaSnackBar.open(poruka, '', {
            duration: 2000,
        });
    };
    MotornaComponent.prototype.uKorpi = function (katBr) {
        return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
    };
    MotornaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-motorna',
            template: __webpack_require__(/*! ./motorna.component.html */ "./src/app/e-shop/roba/ulja/motorna/motorna.component.html"),
            styles: [__webpack_require__(/*! ./motorna.component.css */ "./src/app/e-shop/roba/ulja/motorna/motorna.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_4__["RobaService"],
            src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_7__["ProizvodjacService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_6__["LoginService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_8__["DataService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]])
    ], MotornaComponent);
    return MotornaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/roba/ulja/ulja.component.css":
/*!*****************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/ulja.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".industrijski-stil {\r\n    width: 100%;\r\n    height: 100%;\r\n}\r\n.spusti {\r\n    margin-top: 0px;\r\n}\r\n@media only screen and (max-device-width :1025px) { \r\n    .spusti {\r\n        margin-top: 30px;\r\n    }\r\n}\r\n@media only screen and (max-device-width : 1000px) { \r\n    .spusti {\r\n        margin-top: 10px;\r\n    }\r\n}"

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/ulja.component.html":
/*!******************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/ulja.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main class=\"grid-container spusti\">\r\n    <mat-tab-group mat-stretch-tabs>\r\n        <mat-tab label=\"Motorna ulja\">\r\n            <app-motorna></app-motorna>\r\n        </mat-tab>\r\n        <mat-tab label=\"Menjacka ulja\">\r\n            <app-menjacko></app-menjacko>\r\n        </mat-tab>\r\n        <mat-tab label=\"Kociona ulja\">\r\n            <app-kociona></app-kociona>\r\n        </mat-tab>\r\n        <mat-tab label=\"Antifiriz\">\r\n            <app-antifriz></app-antifriz>\r\n        </mat-tab>\r\n        <mat-tab label=\"Industrijska ulja\">\r\n            <app-industrijska></app-industrijska>\r\n        </mat-tab>\r\n    </mat-tab-group>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/roba/ulja/ulja.component.ts":
/*!****************************************************!*\
  !*** ./src/app/e-shop/roba/ulja/ulja.component.ts ***!
  \****************************************************/
/*! exports provided: UljaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UljaComponent", function() { return UljaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var UljaComponent = /** @class */ (function () {
    function UljaComponent() {
        this.selectedTab = 0;
    }
    UljaComponent.prototype.changeTab = function (tabIndex) {
        this.selectedTab = tabIndex;
    };
    UljaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-ulja',
            template: __webpack_require__(/*! ./ulja.component.html */ "./src/app/e-shop/roba/ulja/ulja.component.html"),
            styles: [__webpack_require__(/*! ./ulja.component.css */ "./src/app/e-shop/roba/ulja/ulja.component.css")]
        })
    ], UljaComponent);
    return UljaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/service/data/data.service.ts":
/*!*****************************************************!*\
  !*** ./src/app/e-shop/service/data/data.service.ts ***!
  \*****************************************************/
/*! exports provided: DataService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DataService", function() { return DataService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _model_porudzbenica__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/porudzbenica */ "./src/app/e-shop/model/porudzbenica.ts");
/* harmony import */ var _local_storage_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./local-storage.service */ "./src/app/e-shop/service/data/local-storage.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var DOMAIN_URL = 'http://localhost:8080/api/informacije/';
var TIMEOUT = 15000;
var TIMEOUT_ERROR = 'Timeout error!';
var DataService = /** @class */ (function () {
    function DataService(korpaStorage, http) {
        this.korpaStorage = korpaStorage;
        this.http = http;
        this.korpa = this.korpaStorage.vratiKorpuIzMemorije() || new _model_porudzbenica__WEBPACK_IMPORTED_MODULE_3__["Korpa"]();
        this.korpaSubjekat = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](this.korpa);
        this.trenutnaKorpa = this.korpaSubjekat.asObservable();
    }
    DataService.prototype.ubaciUKorpu = function (robaKorpa) {
        if (this.korpa.roba.length === 0) {
            this.korpa.roba.push(robaKorpa);
        }
        else {
            var daLiPostojiVecUKorpi_1 = false;
            this.korpa.roba.forEach(function (roba) {
                if (roba.katbr === robaKorpa.katbr) {
                    roba.kolicina = roba.kolicina + robaKorpa.kolicina;
                    roba.cenaUkupno = roba.kolicina * robaKorpa.cenaKom;
                    daLiPostojiVecUKorpi_1 = true;
                }
            });
            if (daLiPostojiVecUKorpi_1 === false) {
                this.korpa.roba.push(robaKorpa);
            }
        }
        this.korpaStorage.cuvajKorpuULokalnojMemoriji(robaKorpa);
        this.korpaSubjekat.next(this.korpa);
    };
    DataService.prototype.skiniSaStanjaUkolikoJeUKorpi = function (robaBaza) {
        var korpa = this.korpaStorage.vratiKorpuIzMemorije();
        if (korpa && robaBaza) {
            korpa.roba.forEach(function (storage) {
                robaBaza.forEach(function (roba) {
                    if (storage.katbr === roba.katbr) {
                        roba.stanje = roba.stanje - storage.kolicina;
                    }
                });
            });
        }
    };
    DataService.prototype.izbaciIzKorpe = function (index) {
        this.korpa.roba.splice(index, 1);
        this.korpaStorage.izbaciIzMemorije(index);
        this.korpaSubjekat.next(this.korpa);
    };
    DataService.prototype.vratiOpsteInformacije = function (vrsta) {
        var fullUrl = DOMAIN_URL + vrsta;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    DataService.prototype.ocistiKorpu = function () {
        this.korpa = new _model_porudzbenica__WEBPACK_IMPORTED_MODULE_3__["Korpa"]();
        this.korpaSubjekat.next(this.korpa);
        this.korpaStorage.ocistiKorpuIzMemorije();
    };
    DataService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_local_storage_service__WEBPACK_IMPORTED_MODULE_4__["LocalStorageService"], _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClient"]])
    ], DataService);
    return DataService;
}());



/***/ }),

/***/ "./src/app/e-shop/service/data/local-storage.service.ts":
/*!**************************************************************!*\
  !*** ./src/app/e-shop/service/data/local-storage.service.ts ***!
  \**************************************************************/
/*! exports provided: LocalStorageService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LocalStorageService", function() { return LocalStorageService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var angular_webstorage_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! angular-webstorage-service */ "./node_modules/angular-webstorage-service/bundles/angular-webstorage-service.es5.js");
/* harmony import */ var _model_porudzbenica__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../model/porudzbenica */ "./src/app/e-shop/model/porudzbenica.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (undefined && undefined.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};



var KORPA_KLJUC = 'korpa_roba';
var PARTNER_KLJUC = 'partner_kljuc';
var LocalStorageService = /** @class */ (function () {
    function LocalStorageService(storage) {
        this.storage = storage;
    }
    LocalStorageService.prototype.sacuvajPartneraUMemoriju = function (partner) {
        if (partner != null && partner.ppid != null) {
            this.storage.set(PARTNER_KLJUC, partner);
        }
    };
    LocalStorageService.prototype.logout = function () {
        this.storage.remove(PARTNER_KLJUC);
        this.storage.remove(KORPA_KLJUC);
    };
    LocalStorageService.prototype.procitajPartneraIzMemorije = function () {
        return this.storage.get(PARTNER_KLJUC);
    };
    LocalStorageService.prototype.vratiKorpuIzMemorije = function () {
        return this.storage.get(KORPA_KLJUC);
    };
    LocalStorageService.prototype.cuvajKorpuULokalnojMemoriji = function (robaKorpa) {
        var trenutnaKorpa;
        if (this.storage.get(KORPA_KLJUC)) {
            trenutnaKorpa = this.storage.get(KORPA_KLJUC);
            this.ubaciRobuUMemoriju(trenutnaKorpa, robaKorpa);
        }
        else {
            trenutnaKorpa = new _model_porudzbenica__WEBPACK_IMPORTED_MODULE_2__["Korpa"]();
            trenutnaKorpa.roba.push(robaKorpa);
        }
        this.storage.set(KORPA_KLJUC, trenutnaKorpa);
    };
    LocalStorageService.prototype.ubaciRobuUMemoriju = function (trenutnaKorpa, robaKorpa) {
        var daLiPostojiVecUMemoriji = false;
        trenutnaKorpa.roba.forEach(function (storage) {
            if (storage.katbr === robaKorpa.katbr) {
                storage.kolicina = storage.kolicina + robaKorpa.kolicina;
                storage.cenaUkupno = storage.kolicina * robaKorpa.cenaKom;
                daLiPostojiVecUMemoriji = true;
            }
        });
        if (daLiPostojiVecUMemoriji === false) {
            trenutnaKorpa.roba.push(robaKorpa);
        }
    };
    LocalStorageService.prototype.izbaciIzMemorije = function (index) {
        var korpa = this.vratiKorpuIzMemorije();
        korpa.roba.splice(index, 1);
        this.storage.set(KORPA_KLJUC, korpa);
    };
    LocalStorageService.prototype.zameniArtikalSaNovim = function (robaKorpa) {
        var trenutnaKorpa = this.storage.get(KORPA_KLJUC);
        trenutnaKorpa.roba.forEach(function (storage) {
            if (storage.katbr === robaKorpa.katbr) {
                storage.kolicina = robaKorpa.kolicina;
                storage.cenaUkupno = robaKorpa.cenaUkupno;
            }
        });
        this.storage.set(KORPA_KLJUC, trenutnaKorpa);
    };
    LocalStorageService.prototype.ocistiKorpuIzMemorije = function () {
        this.storage.remove(KORPA_KLJUC);
    };
    LocalStorageService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __param(0, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(angular_webstorage_service__WEBPACK_IMPORTED_MODULE_1__["SESSION_STORAGE"])),
        __metadata("design:paramtypes", [Object])
    ], LocalStorageService);
    return LocalStorageService;
}());



/***/ }),

/***/ "./src/app/e-shop/service/email.service.ts":
/*!*************************************************!*\
  !*** ./src/app/e-shop/service/email.service.ts ***!
  \*************************************************/
/*! exports provided: EmailService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "EmailService", function() { return EmailService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var DOMAIN_URL = 'http://localhost:8080/api/email';
var REGISTRACIJA_URL = '/registracija';
var RESETOVANJE_SIFRE_URL = '/zaboravljena-sifra';
var TIMEOUT = 15000;
var TIMEOUT_ERROR = 'Timeout error!';
var EmailService = /** @class */ (function () {
    function EmailService(http) {
        this.http = http;
    }
    EmailService.prototype.posaljiMailZaRegistraciju = function (registracija) {
        var fullUrl = DOMAIN_URL + REGISTRACIJA_URL;
        return this.http.post(fullUrl, registracija)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error); }));
    };
    EmailService.prototype.posaljiMailZaResetovanjeSifre = function (email) {
        var fullUrl = DOMAIN_URL + RESETOVANJE_SIFRE_URL;
        return this.http.post(fullUrl, email)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error); }));
    };
    EmailService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], EmailService);
    return EmailService;
}());



/***/ }),

/***/ "./src/app/e-shop/service/faktura.service.ts":
/*!***************************************************!*\
  !*** ./src/app/e-shop/service/faktura.service.ts ***!
  \***************************************************/
/*! exports provided: FakturaService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FakturaService", function() { return FakturaService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var DOMAIN_URL = 'http://localhost:8080/api';
var FAKTURA_URL = '/fakture';
var TIMEOUT = 15000;
var TIMEOUT_ERROR = 'Timeout error!';
var FakturaService = /** @class */ (function () {
    function FakturaService(http, utils) {
        this.http = http;
        this.utils = utils;
    }
    FakturaService.prototype.vratiFaktureKorisnika = function (page, pageSize, ppid) {
        var parameterObject = {};
        parameterObject['page'] = page;
        parameterObject['pageSize'] = pageSize;
        var parametersString = this.utils.vratiKveriParametre(parameterObject);
        var fullUrl = DOMAIN_URL + FAKTURA_URL + '/' + ppid + parametersString;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    FakturaService.prototype.vratiFakturuPojedinacno = function (id, ppid) {
        var fullUrl = DOMAIN_URL + FAKTURA_URL + '/' + ppid + '/' + id;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    FakturaService.prototype.sacuvajFakturu = function (faktura) {
        var fullUrl = DOMAIN_URL + FAKTURA_URL;
        return this.http
            .post(fullUrl, faktura)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    FakturaService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"], _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__["AppUtilsService"]])
    ], FakturaService);
    return FakturaService;
}());



/***/ }),

/***/ "./src/app/e-shop/service/login.service.ts":
/*!*************************************************!*\
  !*** ./src/app/e-shop/service/login.service.ts ***!
  \*************************************************/
/*! exports provided: LoginService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginService", function() { return LoginService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../model/dto */ "./src/app/e-shop/model/dto.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _data_local_storage_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./data/local-storage.service */ "./src/app/e-shop/service/data/local-storage.service.ts");
/* harmony import */ var _data_data_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var TIMEOUT = 15000;
var TIMEOUT_ERROR = 'Timeout error!';
var DOMAIN_URL = 'http://localhost:8080';
var LOGIN_URL = '/login';
var LOGOUT_URL = '/logout';
var PARTNER_URL = '/api/partner';
var LoginService = /** @class */ (function () {
    function LoginService(http, router, utils, korpaServis, storageServis) {
        this.http = http;
        this.router = router;
        this.utils = utils;
        this.korpaServis = korpaServis;
        this.storageServis = storageServis;
        this.partner = this.storageServis.procitajPartneraIzMemorije() || new _model_dto__WEBPACK_IMPORTED_MODULE_2__["Partner"]();
        this.partnerSubjekat = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](this.partner);
        this.ulogovaniPartner = this.partnerSubjekat.asObservable();
        this.uspesnoLogovanje = true;
        this.logovanjeSubjekat = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](this.uspesnoLogovanje);
        this.daLiJeLogovanjeUspesno = this.logovanjeSubjekat.asObservable();
    }
    LoginService.prototype.ulogujSe = function (credentials) {
        var _this = this;
        var parameterObject = {};
        parameterObject['username'] = credentials.username;
        parameterObject['password'] = credentials.password;
        parameterObject['submit'] = 'Login';
        var parametersString = this.utils.vratiKveriParametre(parameterObject);
        var fullUrl = DOMAIN_URL + LOGIN_URL + parametersString;
        this.http.post(fullUrl, {}, { responseType: 'text' })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); })).subscribe(function (res) {
            _this.vratiUlogovanogKorisnika();
        }, function (error) {
            _this.logovanjeSubjekat.next(false);
            _this.storageServis.logout();
            console.log('Greska kod logovanja');
        });
    };
    LoginService.prototype.vratiUlogovanogKorisnika = function () {
        var _this = this;
        var fullUrl = DOMAIN_URL + PARTNER_URL;
        this.http.get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.logovanjeSubjekat.next(false);
                return rxjs__WEBPACK_IMPORTED_MODULE_1__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error);
        })).subscribe(function (res) {
            _this.partner = res;
            _this.storageServis.sacuvajPartneraUMemoriju(_this.partner);
            _this.partnerSubjekat.next(_this.partner);
            _this.router.navigateByUrl('naslovna');
        }, function (error) {
            console.log('Logovanje nije uspelo.');
        });
    };
    LoginService.prototype.logout = function () {
        var _this = this;
        var fullUrl = DOMAIN_URL + LOGOUT_URL;
        this.http.post(fullUrl, {}, { responseType: 'text' })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }))
            .subscribe(function () {
            _this.partner = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["Partner"]();
            _this.logovanjeSubjekat.next(true);
            _this.partnerSubjekat.next(_this.partner);
            _this.korpaServis.ocistiKorpu();
            _this.storageServis.logout();
            _this.router.navigateByUrl('naslovna');
        }, function (error) {
            _this.logovanjeSubjekat.next(false);
            console.log('Greska kod logout-a');
        });
    };
    LoginService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"],
            _angular_router__WEBPACK_IMPORTED_MODULE_6__["Router"],
            _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            _data_data_service__WEBPACK_IMPORTED_MODULE_8__["DataService"],
            _data_local_storage_service__WEBPACK_IMPORTED_MODULE_7__["LocalStorageService"]])
    ], LoginService);
    return LoginService;
}());



/***/ }),

/***/ "./src/app/e-shop/service/partner.service.ts":
/*!***************************************************!*\
  !*** ./src/app/e-shop/service/partner.service.ts ***!
  \***************************************************/
/*! exports provided: PartnerService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PartnerService", function() { return PartnerService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var DOMAIN_URL = 'http://localhost:8080/api';
var PARTNER_URL = '/partner';
var TIMEOUT = 15000;
var TIMEOUT_ERROR = 'Timeout error!';
var PartnerService = /** @class */ (function () {
    function PartnerService(http) {
        this.http = http;
    }
    PartnerService.prototype.updejtujPartnera = function (partner) {
        var fullUrl = DOMAIN_URL + PARTNER_URL;
        return this.http
            .put(fullUrl, partner)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    PartnerService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]])
    ], PartnerService);
    return PartnerService;
}());



/***/ }),

/***/ "./src/app/e-shop/service/proizvodjac.service.ts":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/service/proizvodjac.service.ts ***!
  \*******************************************************/
/*! exports provided: ProizvodjacService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProizvodjacService", function() { return ProizvodjacService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var DOMAIN_URL = 'http://localhost:8080/api';
var ROBA_URL = '/proizvodjaci';
var FILTERI_URL = '/filteri';
var AKUMULATORI_URL = '/akumulatori';
var ULJA_URL = '/ulja';
var KATEGORIJA_URL = '/kategorija';
var TIMEOUT = 15000;
var TIMEOUT_ERROR = 'Timeout error!';
var ProizvodjacService = /** @class */ (function () {
    function ProizvodjacService(http, utils) {
        this.http = http;
        this.utils = utils;
    }
    ProizvodjacService.prototype.pronadjiSveProizvodjace = function () {
        var fullUrl = DOMAIN_URL + ROBA_URL;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    ProizvodjacService.prototype.pronadjiSveProizvodjaceFiltera = function () {
        var fullUrl = DOMAIN_URL + ROBA_URL + FILTERI_URL;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    ProizvodjacService.prototype.pronadjiSveProizvodjaceKategorije = function (kategorija) {
        var fullUrl = DOMAIN_URL + ROBA_URL + KATEGORIJA_URL + '/' + kategorija.toUpperCase();
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    ProizvodjacService.prototype.pronadjiSveProizvodjaceAkumulatora = function () {
        var fullUrl = DOMAIN_URL + ROBA_URL + AKUMULATORI_URL;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    ProizvodjacService.prototype.pronadjiSveProizvodjaceUljaPoVrsti = function (vrstaUlja) {
        var fullUrl = DOMAIN_URL + ROBA_URL + ULJA_URL + this.utils.vratiPutDoResursaZaUlje(vrstaUlja);
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    ProizvodjacService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"], _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_3__["AppUtilsService"]])
    ], ProizvodjacService);
    return ProizvodjacService;
}());



/***/ }),

/***/ "./src/app/e-shop/service/roba.service.ts":
/*!************************************************!*\
  !*** ./src/app/e-shop/service/roba.service.ts ***!
  \************************************************/
/*! exports provided: RobaService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RobaService", function() { return RobaService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var DOMAIN_URL = 'http://localhost:8080/api';
var ROBA_URL = '/roba';
var FILTERI_URL = '/filteri';
var AKUMULATORI_URL = '/akumulatori';
var ULJA_URL = '/ulja';
var OSTALE_KATEGORIJE_URL = '/kategorije';
var TIMEOUT = 15000;
var TIMEOUT_ERROR = 'Timeout error!';
var RobaService = /** @class */ (function () {
    function RobaService(http, utils) {
        this.http = http;
        this.utils = utils;
    }
    RobaService.prototype.pronadjiSvuRobu = function (sort, pageSize, page, searchValue, naStanju, proizvodjacId) {
        var parameterObject = {};
        parameterObject['pageSize'] = pageSize;
        parameterObject['page'] = page;
        if (sort) {
            parameterObject['sortBy'] = sort.active.toLocaleUpperCase();
            parameterObject['sortDirection'] = sort.direction.toLocaleUpperCase();
        }
        parameterObject['searchTerm'] = searchValue;
        parameterObject['proizvodjac'] = proizvodjacId;
        parameterObject['naStanju'] = naStanju;
        var parametersString = this.utils.vratiKveriParametre(parameterObject);
        var fullUrl = DOMAIN_URL + ROBA_URL + parametersString;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    RobaService.prototype.pronadjiFiltere = function (sort, pageSize, page, searchValue, naStanju, proizvodjacId) {
        var parameterObject = {};
        parameterObject['pageSize'] = pageSize;
        parameterObject['page'] = page;
        if (sort) {
            parameterObject['sortBy'] = sort.active.toLocaleUpperCase();
            parameterObject['sortDirection'] = sort.direction.toLocaleUpperCase();
        }
        parameterObject['searchTerm'] = searchValue;
        parameterObject['proizvodjac'] = proizvodjacId;
        parameterObject['naStanju'] = naStanju;
        var parametersString = this.utils.vratiKveriParametre(parameterObject);
        var fullUrl = DOMAIN_URL + ROBA_URL + FILTERI_URL + parametersString;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    RobaService.prototype.pronadjiAkumulatore = function (sort, pageSize, page, searchValue, naStanju, proizvodjacId) {
        var parameterObject = {};
        parameterObject['pageSize'] = pageSize;
        parameterObject['page'] = page;
        if (sort) {
            parameterObject['sortBy'] = sort.active.toLocaleUpperCase();
            parameterObject['sortDirection'] = sort.direction.toLocaleUpperCase();
        }
        parameterObject['searchTerm'] = searchValue;
        parameterObject['proizvodjac'] = proizvodjacId;
        parameterObject['naStanju'] = naStanju;
        var parametersString = this.utils.vratiKveriParametre(parameterObject);
        var fullUrl = DOMAIN_URL + ROBA_URL + AKUMULATORI_URL + parametersString;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    RobaService.prototype.pronadjiUlje = function (sort, pageSize, page, searchValue, naStanju, proizvodjacId, vrstaUlja) {
        var parameterObject = {};
        parameterObject['pageSize'] = pageSize;
        parameterObject['page'] = page;
        if (sort) {
            parameterObject['sortBy'] = sort.active.toLocaleUpperCase();
            parameterObject['sortDirection'] = sort.direction.toLocaleUpperCase();
        }
        parameterObject['searchTerm'] = searchValue;
        parameterObject['proizvodjac'] = proizvodjacId;
        parameterObject['naStanju'] = naStanju;
        var parametersString = this.utils.vratiKveriParametre(parameterObject);
        var fullUrl = DOMAIN_URL + ROBA_URL + ULJA_URL + this.utils.vratiPutDoResursaZaUlje(vrstaUlja) + parametersString;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    RobaService.prototype.pronadjiPoKategoriji = function (sort, pageSize, page, searchValue, naStanju, proizvodjacId, kategorija) {
        var parameterObject = {};
        parameterObject['pageSize'] = pageSize;
        parameterObject['page'] = page;
        if (sort) {
            parameterObject['sortBy'] = sort.active.toLocaleUpperCase();
            parameterObject['sortDirection'] = sort.direction.toLocaleUpperCase();
        }
        parameterObject['searchTerm'] = searchValue;
        parameterObject['proizvodjac'] = proizvodjacId;
        parameterObject['naStanju'] = naStanju;
        var parametersString = this.utils.vratiKveriParametre(parameterObject);
        var fullUrl = DOMAIN_URL + OSTALE_KATEGORIJE_URL + '/' + kategorija.toUpperCase() + parametersString;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    RobaService.prototype.ostaleKategorije = function () {
        var fullUrl = DOMAIN_URL + OSTALE_KATEGORIJE_URL;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    RobaService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"], _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__["AppUtilsService"]])
    ], RobaService);
    return RobaService;
}());



/***/ }),

/***/ "./src/app/e-shop/utils/app-utils.service.ts":
/*!***************************************************!*\
  !*** ./src/app/e-shop/utils/app-utils.service.ts ***!
  \***************************************************/
/*! exports provided: AppUtilsService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppUtilsService", function() { return AppUtilsService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_porudzbenica__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../model/porudzbenica */ "./src/app/e-shop/model/porudzbenica.ts");
/* harmony import */ var _service_data_data_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AppUtilsService = /** @class */ (function () {
    function AppUtilsService(dataService) {
        this.dataService = dataService;
    }
    AppUtilsService.prototype.vratiIdProizvodjacaAkoPostoji = function (izabraniProizvodjac, proizvodjaci) {
        var proId = null;
        if (izabraniProizvodjac && izabraniProizvodjac === 'SVI') {
            proId = null;
        }
        else {
            proizvodjaci.forEach(function (pr) {
                if (pr.naziv === izabraniProizvodjac) {
                    proId = pr.proid;
                }
            });
        }
        return proId;
    };
    AppUtilsService.prototype.daLiRobaTrebaDaBudeNaStanju = function (raspolozivost, izabranaRaspolozivost) {
        if (raspolozivost && izabranaRaspolozivost === raspolozivost[1]) {
            return null;
        }
        else {
            return false;
        }
    };
    AppUtilsService.prototype.dodajUKorpu = function (roba) {
        var snackBarPoruka = 'Artikal je ubacen u korpu.';
        if (roba.kolicina == null || roba.kolicina <= 0) {
            roba.kolicina = 1;
        }
        if (roba.stanje < roba.kolicina) {
            snackBarPoruka = 'Maksimalan kolicina ' + roba.stanje + '. ' + snackBarPoruka;
            roba.kolicina = roba.stanje;
        }
        var robaKorpa = new _model_porudzbenica__WEBPACK_IMPORTED_MODULE_1__["RobaKorpa"](roba.robaid, roba.katbr, roba.katbrpro, roba.naziv, roba.proizvodjac, roba.kolicina, roba.rabat, roba.cena, roba.stanje);
        this.dataService.ubaciUKorpu(robaKorpa);
        return snackBarPoruka;
    };
    AppUtilsService.prototype.izbrisiRobuSaStanja = function (roba, robaUKorpi) {
        roba.forEach(function (robaBaza) {
            if (robaBaza.katbr === robaUKorpi.katbr) {
                robaBaza.stanje = robaBaza.stanje - robaUKorpi.kolicina;
            }
        });
    };
    AppUtilsService.prototype.daLiJeRobaUKorpi = function (korpa, katBr) {
        var uKorpi = false;
        korpa.roba.forEach(function (r) {
            if (r.katbr === katBr) {
                uKorpi = true;
            }
        });
        return uKorpi;
    };
    AppUtilsService.prototype.vratiKveriParametre = function (map) {
        var parameterString = '';
        Object.keys(map).forEach(function (elem, index) {
            var value = map[elem];
            if (value != null || value === 0) {
                if (parameterString) {
                    parameterString += '&';
                }
                parameterString += elem + '=' + value;
            }
        });
        if (parameterString) {
            parameterString = '?' + parameterString;
        }
        return parameterString;
    };
    AppUtilsService.prototype.vratiPutDoResursaZaUlje = function (vrstaUlja) {
        var url = '/motorna';
        if (vrstaUlja === 'motorna') {
            url = '/motorna';
        }
        else if (vrstaUlja === 'menjacka') {
            url = '/menjacka';
        }
        else if (vrstaUlja === 'kociona') {
            url = '/kociona';
        }
        else if (vrstaUlja === 'antifriz') {
            url = '/antifriz';
        }
        else if (vrstaUlja === 'hidraulicna') {
            url = '/hidraulicna';
        }
        else if (vrstaUlja === 'kompresorska') {
            url = '/kompresorska';
        }
        else if (vrstaUlja === 'redutktorska') {
            url = '/redutktorska';
        }
        else if (vrstaUlja === 'transformatorska') {
            url = '/transformatorska';
        }
        else if (vrstaUlja === 'turbinska') {
            url = '/turbinska';
        }
        else if (vrstaUlja === 'pneumatska') {
            url = '/pneumatska';
        }
        else if (vrstaUlja === 'klizna') {
            url = '/klizna';
        }
        else if (vrstaUlja === 'prenosna') {
            url = '/prenosna';
        }
        return url;
    };
    AppUtilsService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_service_data_data_service__WEBPACK_IMPORTED_MODULE_2__["DataService"]])
    ], AppUtilsService);
    return AppUtilsService;
}());



/***/ }),

/***/ "./src/app/navigacija/logout-modal/logout-modal.component.html":
/*!*********************************************************************!*\
  !*** ./src/app/navigacija/logout-modal/logout-modal.component.html ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <main>\n      <h1>Da li ste sigurni da zelite da se odjavite?</h1>\n    <div class=\"d-flex flex-row justify-content-center\">\n      <button mat-raised-button class=\"button-glavni\" (click)=\"logout()\">Odjava</button>\n      <span class=\"col-2\"></span>\n      <button mat-raised-button class=\"button-error\" (click)=\"ostaniUlogovan()\">Ponisti</button>\n    </div>\n  </main>\n</div>"

/***/ }),

/***/ "./src/app/navigacija/logout-modal/logout-modal.component.scss":
/*!*********************************************************************!*\
  !*** ./src/app/navigacija/logout-modal/logout-modal.component.scss ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "p {\n  text-align: center; }\n\nh1 {\n  text-align: center;\n  color: #283b4e !important;\n  font-size: 17px !important; }\n"

/***/ }),

/***/ "./src/app/navigacija/logout-modal/logout-modal.component.ts":
/*!*******************************************************************!*\
  !*** ./src/app/navigacija/logout-modal/logout-modal.component.ts ***!
  \*******************************************************************/
/*! exports provided: LogoutModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LogoutModalComponent", function() { return LogoutModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var LogoutModalComponent = /** @class */ (function () {
    function LogoutModalComponent(dialogRef, router, loginServis) {
        this.dialogRef = dialogRef;
        this.router = router;
        this.loginServis = loginServis;
    }
    LogoutModalComponent.prototype.ngOnInit = function () {
    };
    LogoutModalComponent.prototype.logout = function () {
        this.loginServis.logout();
        this.router.navigateByUrl('naslovna');
        this.dialogRef.close();
    };
    LogoutModalComponent.prototype.ostaniUlogovan = function () {
        this.dialogRef.close();
    };
    LogoutModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-logout-modal',
            template: __webpack_require__(/*! ./logout-modal.component.html */ "./src/app/navigacija/logout-modal/logout-modal.component.html"),
            styles: [__webpack_require__(/*! ./logout-modal.component.scss */ "./src/app/navigacija/logout-modal/logout-modal.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_3__["LoginService"]])
    ], LogoutModalComponent);
    return LogoutModalComponent;
}());



/***/ }),

/***/ "./src/app/navigacija/navigacija.component.html":
/*!******************************************************!*\
  !*** ./src/app/navigacija/navigacija.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-sidenav-container class=\"sidenav-container b-color\">\n  <mat-sidenav #drawer class=\"sidenav sidebar-color\" fixedInViewport=\"true\" [attr.role]=\"(isHandset$ | async) ? 'dialog' : 'navigation'\"\n    [mode]=\"(isHandset$ | async) ? 'over' : 'side'\" [opened]=\"!(isHandset$ | async)\">\n    <mat-toolbar *ngIf=\"partner.ppid\" class=\"side-toolbar sidebar-color header-pozicija\">\n      <div class=\"d-flex flex-column \">\n        <div class=\"d-flex justify-content-center header-sirina\">\n          <mat-icon class=\"icon-color\">person</mat-icon>\n        </div>\n        <p class=\"text-center header-navigacija\">{{partner.naziv}}</p>\n        <p class=\"text-center header-navigacija\">{{partner.email  | lowercase}}</p>\n      </div>\n    </mat-toolbar>\n    <mat-nav-list [class.margin-gore]=\"partner.ppid\">\n      <mat-divider *ngIf=\"partner.ppid\" class=\"icon-color\"></mat-divider>\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['naslovna']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>home</mat-icon>\n        <p mat-line>Naslovna</p>\n      </mat-list-item>\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['o-nama']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>book</mat-icon>\n        <p mat-line>O nama</p>\n      </mat-list-item>\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['kontakt']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>contact_phone</mat-icon>\n        <p mat-line>Kontakt</p>\n      </mat-list-item>\n    </mat-nav-list>\n\n    <mat-divider></mat-divider>\n    <mat-nav-list>\n      <h3 class=\"icon-color\" mat-subheader>Internet prodavnica</h3>\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['roba']\" [routerLinkActive]=\"['is-active']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>searche</mat-icon>\n        <p mat-line>Roba - pretraga</p>\n      </mat-list-item>\n\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['ulja']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>invert_colors</mat-icon>\n        <p mat-line>Ulja</p>\n      </mat-list-item>\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['filteri']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>layers</mat-icon>\n        <p mat-line>Filteri</p>\n      </mat-list-item>\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['akumulatori']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>battery_charging_full</mat-icon>\n        <p mat-line>Akumulatori</p>\n      </mat-list-item>\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['ostalo']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>category</mat-icon>\n        <p mat-line>Ostalo</p>\n      </mat-list-item>\n      <mat-list-item class=\"material-icons\" *ngIf=\"partner.ppid\" [routerLink]=\"['korpa']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon matBadgeColor=\"warn\" class=\"icon-color\" matBadge=\"{{korpaBadge}}\" mat-list-icon>shopping_cart</mat-icon>\n        <p mat-line>Korpa</p>\n      </mat-list-item>\n    </mat-nav-list>\n\n    <mat-divider></mat-divider>\n    <mat-nav-list *ngIf=\"partner.ppid\">\n      <h3 class=\"icon-color\" mat-subheader>Moj Profil</h3>\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['licni-podaci']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>person</mat-icon>\n        <p mat-line>Licni Podaci</p>\n      </mat-list-item>\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['porudzbenice']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>list</mat-icon>\n        <p mat-line>Porudzbine</p>\n      </mat-list-item>\n    </mat-nav-list>\n    <mat-divider></mat-divider>\n    <mat-nav-list>\n      <mat-list-item *ngIf=\"partner.ppid == null\" class=\"material-icons\" [routerLink]=\"['login']\" [routerLinkActive]=\"['is-active']\">\n        <mat-icon class=\"icon-color\" mat-list-icon>exit_to_app</mat-icon>\n        <p mat-line>Login</p>\n      </mat-list-item>\n      <mat-list-item *ngIf=\"partner.ppid\" class=\"material-icons\" (click)=\"otvoriDialog()\">\n        <mat-icon class=\"icon-color\" mat-list-icon>power_settings_new</mat-icon>\n        <p mat-line>Logout</p>\n      </mat-list-item>\n    </mat-nav-list>\n  </mat-sidenav>\n  <mat-sidenav-content>\n    <mat-toolbar *ngIf=\"isHandset$ | async\" class=\"header-pozicija sidebar-color\">\n      <button type=\"button\" aria-label=\"Toggle sidenav\" mat-icon-button (click)=\"drawer.toggle()\">\n        <mat-icon class=\"icon-color\" aria-label=\"Side nav toggle icon\">menu</mat-icon>\n      </button>\n    </mat-toolbar>\n    <router-outlet></router-outlet>\n  </mat-sidenav-content>\n</mat-sidenav-container>"

/***/ }),

/***/ "./src/app/navigacija/navigacija.component.scss":
/*!******************************************************!*\
  !*** ./src/app/navigacija/navigacija.component.scss ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sidenav-container {\n  height: 100%; }\n\n.sidenav {\n  width: 200px;\n  height: 100%; }\n\n.mat-toolbar.mat-primary {\n  position: -webkit-sticky;\n  position: sticky;\n  top: 0; }\n\n.header-navigacija {\n  font-size: 13px !important;\n  width: 160px; }\n\n.header-sirina {\n  width: 160px !important; }\n\np {\n  font-size: 14px;\n  padding: 0px;\n  margin: 0px;\n  color: #f8f8f8;\n  font-family: sans-serif;\n  display: block;\n  padding: 0px;\n  margin: 0px; }\n\n.is-active {\n  background-color: #547aa1 !important; }\n\nmat-divider {\n  border-width: 1px;\n  border-style: solid;\n  border-color: #cfd8dc; }\n\n.icon-color {\n  color: #cfd8dc; }\n\n.user-none {\n  font-size: 60px;\n  text-align: center; }\n\n.margin-gore {\n  margin-top: 120px; }\n\n.side-toolbar {\n  height: 120px;\n  width: 200px; }\n\n.sidebar-color {\n  background-color: #283b4e; }\n\n.header-pozicija {\n  top: 0px;\n  position: fixed;\n  z-index: 999; }\n"

/***/ }),

/***/ "./src/app/navigacija/navigacija.component.ts":
/*!****************************************************!*\
  !*** ./src/app/navigacija/navigacija.component.ts ***!
  \****************************************************/
/*! exports provided: NavigacijaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NavigacijaComponent", function() { return NavigacijaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/cdk/layout */ "./node_modules/@angular/cdk/esm5/layout.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./logout-modal/logout-modal.component */ "./src/app/navigacija/logout-modal/logout-modal.component.ts");
/* harmony import */ var _e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var NavigacijaComponent = /** @class */ (function () {
    function NavigacijaComponent(breakpointObserver, korpaServis, loginServis, dialog) {
        this.breakpointObserver = breakpointObserver;
        this.korpaServis = korpaServis;
        this.loginServis = loginServis;
        this.dialog = dialog;
        this.korpaBadge = 0;
        this.isHandset$ = this.breakpointObserver.observe(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["Breakpoints"].Handset)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (result) { return result.matches; }));
    }
    NavigacijaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.korpaServis.trenutnaKorpa.subscribe(function (korpa) { return _this.korpaBadge = korpa.roba.length; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
    };
    NavigacijaComponent.prototype.otvoriDialog = function () {
        var dialogRef = this.dialog.open(_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_4__["LogoutModalComponent"], {
            width: '400px'
        });
        dialogRef.afterClosed().subscribe(function (result) {
            console.log('The dialog was closed');
        });
    };
    NavigacijaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-navigacija',
            template: __webpack_require__(/*! ./navigacija.component.html */ "./src/app/navigacija/navigacija.component.html"),
            styles: [__webpack_require__(/*! ./navigacija.component.scss */ "./src/app/navigacija/navigacija.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["BreakpointObserver"],
            _e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_6__["DataService"],
            _e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_5__["LoginService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatDialog"]])
    ], NavigacijaComponent);
    return NavigacijaComponent;
}());



/***/ }),

/***/ "./src/app/pipes/DatePipe.ts":
/*!***********************************!*\
  !*** ./src/app/pipes/DatePipe.ts ***!
  \***********************************/
/*! exports provided: DatePipe */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DatePipe", function() { return DatePipe; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _e_shop_model_konstante__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../e-shop/model/konstante */ "./src/app/e-shop/model/konstante.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var DatePipe = /** @class */ (function () {
    function DatePipe() {
    }
    DatePipe.prototype.transform = function (value) {
        if (!value) {
            value = 'N/A';
        }
        else {
            var datumNVremeiz = value.split('T');
            var datumNiz = datumNVremeiz[0].split('-');
            datumNiz[1] = _e_shop_model_konstante__WEBPACK_IMPORTED_MODULE_1__["mesec"]['mesec_' + datumNiz[1]];
            value = datumNiz[0] + '-' + datumNiz[1] + '-' + datumNiz[2] + ' ' + datumNVremeiz[1].substr(0, 5);
        }
        return value;
    };
    DatePipe = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Pipe"])({ name: 'datum' })
    ], DatePipe);
    return DatePipe;
}());



/***/ }),

/***/ "./src/app/pipes/EmptyPipe.ts":
/*!************************************!*\
  !*** ./src/app/pipes/EmptyPipe.ts ***!
  \************************************/
/*! exports provided: EmptyPipe */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "EmptyPipe", function() { return EmptyPipe; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var EmptyPipe = /** @class */ (function () {
    function EmptyPipe() {
    }
    EmptyPipe.prototype.transform = function (value) {
        if (!value) {
            value = 'N/A';
        }
        return value;
    };
    EmptyPipe = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Pipe"])({ name: 'empty' })
    ], EmptyPipe);
    return EmptyPipe;
}());



/***/ }),

/***/ "./src/app/pipes/PrevodilacPipe.ts":
/*!*****************************************!*\
  !*** ./src/app/pipes/PrevodilacPipe.ts ***!
  \*****************************************/
/*! exports provided: TranslatePipe */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TranslatePipe", function() { return TranslatePipe; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _e_shop_model_konstante__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../e-shop/model/konstante */ "./src/app/e-shop/model/konstante.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var TranslatePipe = /** @class */ (function () {
    function TranslatePipe() {
    }
    TranslatePipe.prototype.transform = function (value) {
        return _e_shop_model_konstante__WEBPACK_IMPORTED_MODULE_1__["transformator"][value];
    };
    TranslatePipe = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Pipe"])({ name: 'translate' })
    ], TranslatePipe);
    return TranslatePipe;
}());



/***/ }),

/***/ "./src/app/shared/material/material.module.ts":
/*!****************************************************!*\
  !*** ./src/app/shared/material/material.module.ts ***!
  \****************************************************/
/*! exports provided: MaterialModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MaterialModule", function() { return MaterialModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/cdk/layout */ "./node_modules/@angular/cdk/esm5/layout.es5.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};





var MaterialModule = /** @class */ (function () {
    function MaterialModule() {
    }
    MaterialModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatButtonModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatCheckboxModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatExpansionModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatStepperModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatFormFieldModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatInputModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatFormFieldModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSnackBarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatChipsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatProgressSpinnerModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatBadgeModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatRadioModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSelectModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatAutocompleteModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatCheckboxModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatTableModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatTabsModule"],
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"],
                _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_3__["LayoutModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatToolbarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSidenavModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatIconModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatListModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatGridListModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatCardModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatMenuModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatPaginatorModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSortModule"]
            ],
            exports: [
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatButtonModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatCheckboxModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatProgressSpinnerModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatExpansionModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatStepperModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatInputModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatBadgeModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatRadioModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatFormFieldModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatChipsModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSnackBarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSelectModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatAutocompleteModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatCheckboxModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatTableModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatTabsModule"],
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_3__["LayoutModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatToolbarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatButtonModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSidenavModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatIconModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatListModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatGridListModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatCardModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatMenuModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatPaginatorModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSortModule"]
            ]
        })
    ], MaterialModule);
    return MaterialModule;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! hammerjs */ "./node_modules/hammerjs/hammer.js");
/* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(hammerjs__WEBPACK_IMPORTED_MODULE_4__);





if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! D:\Automaterijal\Project\automaterijal\src\main\ui\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map