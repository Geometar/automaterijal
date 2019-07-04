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
/* harmony import */ var _e_shop_magacin_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./e-shop/magacin/filteri/filteri.component */ "./src/app/e-shop/magacin/filteri/filteri.component.ts");
/* harmony import */ var _e_shop_magacin_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./e-shop/magacin/akumulatori/akumulatori.component */ "./src/app/e-shop/magacin/akumulatori/akumulatori.component.ts");
/* harmony import */ var _e_shop_magacin_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./e-shop/magacin/ulja/ulja.component */ "./src/app/e-shop/magacin/ulja/ulja.component.ts");
/* harmony import */ var _e_shop_korpa_korpa_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./e-shop/korpa/korpa.component */ "./src/app/e-shop/korpa/korpa.component.ts");
/* harmony import */ var _e_shop_login_login_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./e-shop/login/login.component */ "./src/app/e-shop/login/login.component.ts");
/* harmony import */ var _e_shop_faktura_faktura_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./e-shop/faktura/faktura.component */ "./src/app/e-shop/faktura/faktura.component.ts");
/* harmony import */ var _e_shop_faktura_faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./e-shop/faktura/faktura-detalji/faktura-detalji.component */ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.ts");
/* harmony import */ var _e_shop_magacin_ostalo_ostalo_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./e-shop/magacin/ostalo/ostalo.component */ "./src/app/e-shop/magacin/ostalo/ostalo.component.ts");
/* harmony import */ var _e_shop_magacin_ostalo_kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component */ "./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.ts");
/* harmony import */ var _e_shop_partner_partner_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./e-shop/partner/partner.component */ "./src/app/e-shop/partner/partner.component.ts");
/* harmony import */ var _e_shop_magacin_roba_roba_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./e-shop/magacin/roba/roba.component */ "./src/app/e-shop/magacin/roba/roba.component.ts");
/* harmony import */ var _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./e-commerce/dasboard/dasboard.component */ "./src/app/e-commerce/dasboard/dasboard.component.ts");
/* harmony import */ var _e_shop_resetovanje_sfire_resetovanje_sfire_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./e-shop/resetovanje-sfire/resetovanje-sfire.component */ "./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.ts");
/* harmony import */ var _e_commerce_kontakt_kontakt_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./e-commerce/kontakt/kontakt.component */ "./src/app/e-commerce/kontakt/kontakt.component.ts");
/* harmony import */ var _e_commerce_o_nama_o_nama_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./e-commerce/o-nama/o-nama.component */ "./src/app/e-commerce/o-nama/o-nama.component.ts");
/* harmony import */ var _e_commerce_dasboard_clanak_clanak_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./e-commerce/dasboard/clanak/clanak.component */ "./src/app/e-commerce/dasboard/clanak/clanak.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


















var routes = [
    { path: '', redirectTo: '/naslovna', pathMatch: 'full' },
    { path: 'naslovna', component: _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_13__["DasboardComponent"] },
    { path: 'o-nama', component: _e_commerce_o_nama_o_nama_component__WEBPACK_IMPORTED_MODULE_16__["ONamaComponent"] },
    { path: 'kontakt', component: _e_commerce_kontakt_kontakt_component__WEBPACK_IMPORTED_MODULE_15__["KontaktComponent"] },
    { path: 'roba', component: _e_shop_magacin_roba_roba_component__WEBPACK_IMPORTED_MODULE_12__["RobaComponent"] },
    { path: 'filteri', component: _e_shop_magacin_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_2__["FilteriComponent"] },
    { path: 'ulja', component: _e_shop_magacin_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_4__["UljaComponent"] },
    { path: 'akumulatori', component: _e_shop_magacin_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_3__["AkumulatoriComponent"] },
    { path: 'ostalo', component: _e_shop_magacin_ostalo_ostalo_component__WEBPACK_IMPORTED_MODULE_9__["OstaloComponent"] },
    { path: 'ostalo/:id', component: _e_shop_magacin_ostalo_kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_10__["KategorijaSpecificnaComponent"] },
    { path: 'login', component: _e_shop_login_login_component__WEBPACK_IMPORTED_MODULE_6__["LoginComponent"] },
    { path: 'kontakt', component: _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_13__["DasboardComponent"] },
    { path: 'licni-podaci', component: _e_shop_partner_partner_component__WEBPACK_IMPORTED_MODULE_11__["PartnerComponent"] },
    { path: 'porudzbenice', component: _e_shop_faktura_faktura_component__WEBPACK_IMPORTED_MODULE_7__["FakturaComponent"] },
    { path: 'porudzbenice/:id', component: _e_shop_faktura_faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_8__["FakturaDetaljiComponent"] },
    { path: 'naslovna/:id', component: _e_commerce_dasboard_clanak_clanak_component__WEBPACK_IMPORTED_MODULE_17__["ClanakComponent"] },
    { path: 'korpa', component: _e_shop_korpa_korpa_component__WEBPACK_IMPORTED_MODULE_5__["KorpaComponent"] },
    { path: 'reset-sifre/:id', component: _e_shop_resetovanje_sfire_resetovanje_sfire_component__WEBPACK_IMPORTED_MODULE_14__["ResetovanjeSfireComponent"] },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"].forRoot(routes, { scrollPositionRestoration: 'enabled' })],
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
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

 // import Router and NavigationEnd

var AppComponent = /** @class */ (function () {
    function AppComponent(router) {
        this.router = router;
        this.title = 'Automaterijal';
        var navEndEvent$ = router.events.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["filter"])(function (e) { return e instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationEnd"]; }));
        navEndEvent$.subscribe(function (e) {
            gtag('config', 'UA-143220679-1', { 'page_path': e.urlAfterRedirects });
        });
    }
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]])
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
/* harmony import */ var _e_shop_magacin_roba_roba_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./e-shop/magacin/roba/roba.component */ "./src/app/e-shop/magacin/roba/roba.component.ts");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _e_shop_magacin_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./e-shop/magacin/filteri/filteri.component */ "./src/app/e-shop/magacin/filteri/filteri.component.ts");
/* harmony import */ var _e_shop_magacin_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./e-shop/magacin/akumulatori/akumulatori.component */ "./src/app/e-shop/magacin/akumulatori/akumulatori.component.ts");
/* harmony import */ var _e_shop_magacin_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./e-shop/magacin/ulja/ulja.component */ "./src/app/e-shop/magacin/ulja/ulja.component.ts");
/* harmony import */ var _e_shop_magacin_ulja_motorna_motorna_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./e-shop/magacin/ulja/motorna/motorna.component */ "./src/app/e-shop/magacin/ulja/motorna/motorna.component.ts");
/* harmony import */ var _e_shop_magacin_ulja_menjacko_menjacko_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./e-shop/magacin/ulja/menjacko/menjacko.component */ "./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.ts");
/* harmony import */ var _e_shop_magacin_ulja_kociona_kociona_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./e-shop/magacin/ulja/kociona/kociona.component */ "./src/app/e-shop/magacin/ulja/kociona/kociona.component.ts");
/* harmony import */ var _e_shop_magacin_ulja_antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./e-shop/magacin/ulja/antifriz/antifriz.component */ "./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.ts");
/* harmony import */ var _e_shop_magacin_ulja_industrijska_industrijska_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./e-shop/magacin/ulja/industrijska/industrijska.component */ "./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.ts");
/* harmony import */ var _e_shop_korpa_korpa_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./e-shop/korpa/korpa.component */ "./src/app/e-shop/korpa/korpa.component.ts");
/* harmony import */ var _e_shop_login_login_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./e-shop/login/login.component */ "./src/app/e-shop/login/login.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _e_shop_faktura_faktura_component__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./e-shop/faktura/faktura.component */ "./src/app/e-shop/faktura/faktura.component.ts");
/* harmony import */ var _shared_pipes_PrevodilacPipe__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./shared/pipes/PrevodilacPipe */ "./src/app/shared/pipes/PrevodilacPipe.ts");
/* harmony import */ var _shared_pipes_EmptyPipe__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./shared/pipes/EmptyPipe */ "./src/app/shared/pipes/EmptyPipe.ts");
/* harmony import */ var _e_shop_faktura_faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ./e-shop/faktura/faktura-detalji/faktura-detalji.component */ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.ts");
/* harmony import */ var _shared_pipes_DatePipe__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ./shared/pipes/DatePipe */ "./src/app/shared/pipes/DatePipe.ts");
/* harmony import */ var _e_shop_magacin_ostalo_ostalo_component__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! ./e-shop/magacin/ostalo/ostalo.component */ "./src/app/e-shop/magacin/ostalo/ostalo.component.ts");
/* harmony import */ var _e_shop_magacin_ostalo_kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! ./e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component */ "./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.ts");
/* harmony import */ var _e_shop_partner_partner_component__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! ./e-shop/partner/partner.component */ "./src/app/e-shop/partner/partner.component.ts");
/* harmony import */ var _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(/*! ./e-commerce/dasboard/dasboard.component */ "./src/app/e-commerce/dasboard/dasboard.component.ts");
/* harmony import */ var _e_shop_resetovanje_sfire_resetovanje_sfire_component__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(/*! ./e-shop/resetovanje-sfire/resetovanje-sfire.component */ "./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.ts");
/* harmony import */ var _e_commerce_kontakt_kontakt_component__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(/*! ./e-commerce/kontakt/kontakt.component */ "./src/app/e-commerce/kontakt/kontakt.component.ts");
/* harmony import */ var _footer_footer_component__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(/*! ./footer/footer.component */ "./src/app/footer/footer.component.ts");
/* harmony import */ var _shared_modal_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(/*! ./shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component */ "./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.ts");
/* harmony import */ var _shared_modal_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(/*! ./shared/modal/logout-modal/logout-modal.component */ "./src/app/shared/modal/logout-modal/logout-modal.component.ts");
/* harmony import */ var _shared_modal_uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_36__ = __webpack_require__(/*! ./shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component */ "./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.ts");
/* harmony import */ var _shared_modal_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_37__ = __webpack_require__(/*! ./shared/modal/registracija-modal/registracija-modal.component */ "./src/app/shared/modal/registracija-modal/registracija-modal.component.ts");
/* harmony import */ var _shared_modal_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_38__ = __webpack_require__(/*! ./shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component */ "./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.ts");
/* harmony import */ var _shared_modal_poruka_modal_poruka_modal_component__WEBPACK_IMPORTED_MODULE_39__ = __webpack_require__(/*! ./shared/modal/poruka-modal/poruka-modal.component */ "./src/app/shared/modal/poruka-modal/poruka-modal.component.ts");
/* harmony import */ var _e_commerce_o_nama_o_nama_component__WEBPACK_IMPORTED_MODULE_40__ = __webpack_require__(/*! ./e-commerce/o-nama/o-nama.component */ "./src/app/e-commerce/o-nama/o-nama.component.ts");
/* harmony import */ var ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_41__ = __webpack_require__(/*! ngx-owl-carousel */ "./node_modules/ngx-owl-carousel/index.js");
/* harmony import */ var ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_41___default = /*#__PURE__*/__webpack_require__.n(ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_41__);
/* harmony import */ var _shared_modal_brendovi_modal_brendovi_modal_component__WEBPACK_IMPORTED_MODULE_42__ = __webpack_require__(/*! ./shared/modal/brendovi-modal/brendovi-modal.component */ "./src/app/shared/modal/brendovi-modal/brendovi-modal.component.ts");
/* harmony import */ var ngx_bootstrap_carousel__WEBPACK_IMPORTED_MODULE_43__ = __webpack_require__(/*! ngx-bootstrap/carousel */ "./node_modules/ngx-bootstrap/carousel/fesm5/ngx-bootstrap-carousel.js");
/* harmony import */ var _e_commerce_dasboard_clanak_clanak_component__WEBPACK_IMPORTED_MODULE_44__ = __webpack_require__(/*! ./e-commerce/dasboard/clanak/clanak.component */ "./src/app/e-commerce/dasboard/clanak/clanak.component.ts");
/* harmony import */ var _e_commerce_dasboard_ponuda_ponuda_component__WEBPACK_IMPORTED_MODULE_45__ = __webpack_require__(/*! ./e-commerce/dasboard/ponuda/ponuda.component */ "./src/app/e-commerce/dasboard/ponuda/ponuda.component.ts");
/* harmony import */ var _e_commerce_dasboard_vesti_vesti_component__WEBPACK_IMPORTED_MODULE_46__ = __webpack_require__(/*! ./e-commerce/dasboard/vesti/vesti.component */ "./src/app/e-commerce/dasboard/vesti/vesti.component.ts");
/* harmony import */ var _shared_modal_upit_modal_upit_modal_component__WEBPACK_IMPORTED_MODULE_47__ = __webpack_require__(/*! ./shared/modal/upit-modal/upit-modal.component */ "./src/app/shared/modal/upit-modal/upit-modal.component.ts");
/* harmony import */ var _e_shop_magacin_shared_components_filter_filter_component__WEBPACK_IMPORTED_MODULE_48__ = __webpack_require__(/*! ./e-shop/magacin/shared-components/filter/filter.component */ "./src/app/e-shop/magacin/shared-components/filter/filter.component.ts");
/* harmony import */ var _e_shop_magacin_shared_components_tabela_tabela_component__WEBPACK_IMPORTED_MODULE_49__ = __webpack_require__(/*! ./e-shop/magacin/shared-components/tabela/tabela.component */ "./src/app/e-shop/magacin/shared-components/tabela/tabela.component.ts");
/* harmony import */ var _shared_modal_neuspesno_porucivanje_modal_neuspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_50__ = __webpack_require__(/*! ./shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component */ "./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.ts");
/* harmony import */ var _shared_modal_sesija_istekla_modal_sesija_istekla_modal_component__WEBPACK_IMPORTED_MODULE_51__ = __webpack_require__(/*! ./shared/modal/sesija-istekla-modal/sesija-istekla-modal.component */ "./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.ts");
/* harmony import */ var _shared_modal_prvo_logovanje_modal_prvo_logovanje_modal_component__WEBPACK_IMPORTED_MODULE_52__ = __webpack_require__(/*! ./shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component */ "./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.ts");
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
                _e_shop_magacin_roba_roba_component__WEBPACK_IMPORTED_MODULE_7__["RobaComponent"],
                _e_commerce_dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_30__["DasboardComponent"],
                _e_shop_magacin_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_11__["FilteriComponent"],
                _e_shop_magacin_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_12__["AkumulatoriComponent"],
                _e_shop_magacin_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_13__["UljaComponent"],
                _e_shop_magacin_ulja_motorna_motorna_component__WEBPACK_IMPORTED_MODULE_14__["MotornaComponent"],
                _e_shop_magacin_ulja_menjacko_menjacko_component__WEBPACK_IMPORTED_MODULE_15__["MenjackoComponent"],
                _e_shop_magacin_ulja_kociona_kociona_component__WEBPACK_IMPORTED_MODULE_16__["KocionaComponent"],
                _e_shop_magacin_ulja_antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_17__["AntifrizComponent"],
                _e_shop_magacin_ulja_industrijska_industrijska_component__WEBPACK_IMPORTED_MODULE_18__["IndustrijskaComponent"],
                _e_shop_korpa_korpa_component__WEBPACK_IMPORTED_MODULE_19__["KorpaComponent"],
                _shared_modal_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_34__["IzmenaKolicineModalComponent"],
                _e_shop_login_login_component__WEBPACK_IMPORTED_MODULE_20__["LoginComponent"],
                _shared_modal_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_35__["LogoutModalComponent"],
                _e_shop_faktura_faktura_component__WEBPACK_IMPORTED_MODULE_22__["FakturaComponent"],
                _shared_pipes_PrevodilacPipe__WEBPACK_IMPORTED_MODULE_23__["TranslatePipe"],
                _shared_pipes_EmptyPipe__WEBPACK_IMPORTED_MODULE_24__["EmptyPipe"],
                _shared_pipes_DatePipe__WEBPACK_IMPORTED_MODULE_26__["DatePipe"],
                _e_shop_faktura_faktura_detalji_faktura_detalji_component__WEBPACK_IMPORTED_MODULE_25__["FakturaDetaljiComponent"],
                _e_shop_magacin_ostalo_ostalo_component__WEBPACK_IMPORTED_MODULE_27__["OstaloComponent"],
                _e_shop_magacin_ostalo_kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_28__["KategorijaSpecificnaComponent"],
                _e_shop_partner_partner_component__WEBPACK_IMPORTED_MODULE_29__["PartnerComponent"],
                _shared_modal_uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_36__["UspesnoPorucivanjeModalComponent"],
                _shared_modal_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_37__["RegistracijaModalComponent"],
                _shared_modal_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_38__["ZaboravljenaSifraModalComponent"],
                _e_shop_resetovanje_sfire_resetovanje_sfire_component__WEBPACK_IMPORTED_MODULE_31__["ResetovanjeSfireComponent"],
                _e_commerce_kontakt_kontakt_component__WEBPACK_IMPORTED_MODULE_32__["KontaktComponent"],
                _footer_footer_component__WEBPACK_IMPORTED_MODULE_33__["FooterComponent"],
                _shared_modal_poruka_modal_poruka_modal_component__WEBPACK_IMPORTED_MODULE_39__["PorukaModalComponent"],
                _e_commerce_o_nama_o_nama_component__WEBPACK_IMPORTED_MODULE_40__["ONamaComponent"],
                _shared_modal_brendovi_modal_brendovi_modal_component__WEBPACK_IMPORTED_MODULE_42__["BrendoviModalComponent"],
                _e_commerce_dasboard_clanak_clanak_component__WEBPACK_IMPORTED_MODULE_44__["ClanakComponent"],
                _e_commerce_dasboard_ponuda_ponuda_component__WEBPACK_IMPORTED_MODULE_45__["PonudaComponent"],
                _e_commerce_dasboard_vesti_vesti_component__WEBPACK_IMPORTED_MODULE_46__["VestiComponent"],
                _shared_modal_upit_modal_upit_modal_component__WEBPACK_IMPORTED_MODULE_47__["UpitModalComponent"],
                _e_shop_magacin_shared_components_filter_filter_component__WEBPACK_IMPORTED_MODULE_48__["FilterComponent"],
                _e_shop_magacin_shared_components_tabela_tabela_component__WEBPACK_IMPORTED_MODULE_49__["TabelaComponent"],
                _shared_modal_neuspesno_porucivanje_modal_neuspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_50__["NeuspesnoPorucivanjeModalComponent"],
                _shared_modal_sesija_istekla_modal_sesija_istekla_modal_component__WEBPACK_IMPORTED_MODULE_51__["SesijaIsteklaModalComponent"],
                _shared_modal_prvo_logovanje_modal_prvo_logovanje_modal_component__WEBPACK_IMPORTED_MODULE_52__["PrvoLogovanjeModalComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_http__WEBPACK_IMPORTED_MODULE_8__["HttpModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_21__["HttpClientModule"],
                ngx_bootstrap_carousel__WEBPACK_IMPORTED_MODULE_43__["CarouselModule"],
                ngx_owl_carousel__WEBPACK_IMPORTED_MODULE_41__["OwlModule"],
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
                _shared_modal_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_38__["ZaboravljenaSifraModalComponent"],
                _shared_modal_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_37__["RegistracijaModalComponent"],
                _shared_modal_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_34__["IzmenaKolicineModalComponent"],
                _shared_modal_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_35__["LogoutModalComponent"],
                _shared_modal_uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_36__["UspesnoPorucivanjeModalComponent"],
                _shared_modal_neuspesno_porucivanje_modal_neuspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_50__["NeuspesnoPorucivanjeModalComponent"],
                _shared_modal_poruka_modal_poruka_modal_component__WEBPACK_IMPORTED_MODULE_39__["PorukaModalComponent"],
                _shared_modal_brendovi_modal_brendovi_modal_component__WEBPACK_IMPORTED_MODULE_42__["BrendoviModalComponent"],
                _shared_modal_upit_modal_upit_modal_component__WEBPACK_IMPORTED_MODULE_47__["UpitModalComponent"],
                _shared_modal_sesija_istekla_modal_sesija_istekla_modal_component__WEBPACK_IMPORTED_MODULE_51__["SesijaIsteklaModalComponent"],
                _shared_modal_prvo_logovanje_modal_prvo_logovanje_modal_component__WEBPACK_IMPORTED_MODULE_52__["PrvoLogovanjeModalComponent"]
            ]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

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

module.exports = "img {\n  width: 100%;\n  height: 300px; }\n\n.vest-sektor {\n  width: 50%;\n  margin-left: 25%; }\n\n/* :host /deep/ mySelector { */\n\n:host ::ng-deep ul {\n  list-style-type: circle;\n  padding: 0px 30px; }\n\n:host ::ng-deep p {\n  margin-top: 15px;\n  padding: 10px; }\n\n:host ::ng-deep h1 {\n  text-align: center;\n  margin-bottom: 20px; }\n\n@media only screen and (max-width: 1025px) {\n  .img {\n    width: 100%;\n    height: 100px; }\n  .vest-sektor {\n    width: 90%;\n    margin-left: 5%; } }\n"

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

module.exports = "<main>\n  <section class=\"d-flex flex-xl-row-reverse flex-column centar skecija-mala\">\n    <div class=\"pomeri-levo\">\n      <i class=\"material-icons velicina-ikone\">\n        place\n      </i>\n      <p class=\"header\">Prvomajska 61, Šabac</p>\n    </div>\n    <div class=\"pomeri-levo\">\n      <i class=\"material-icons velicina-ikone\">\n        email\n      </i>\n      <p class=\"header\">office@automaterijal.com</p>\n    </div>\n    <div class=\"pomeri-levo\">\n      <i class=\"material-icons velicina-ikone\">\n        phone\n      </i>\n      <p class=\"header\"> <a class=\"header\" href=\"tel:015334630\">015/334-630</a></p>\n    </div>\n  </section>\n  <section>\n    <carousel>\n      <slide class=\"animated fadeIn\" *ngFor=\"let brand of mySlidePagePapers;let i = index\">\n        <img src=\"{{brand.urlSlikePozadina}}\" alt=\"first slide\" style=\"display: block; width: 100%;\">\n      </slide>\n    </carousel>\n  </section>\n  <section class=\"d-flex flex-xl-row flex-column centar pozadina-bela skecija-srednja\">\n    <div class=\"flex-fill mobilni\">\n      <p class=\"inline-content paragraph text-center\">Posetite našu online prodavnicu i webshop katalog</p>\n      <button color=\"primary\" class=\"inline-content inline-button\" (click)=\"goToShoping()\" mat-mini-fab>\n        <mat-icon aria-label=\"Example icon-button with a heart icon\">shopping_cart</mat-icon>\n      </button>\n    </div>\n    <div class=\"flex-fill\">\n      <p class=\"inline-content paragraph text-center\">Pošaljite nam upit za deo koji trižite</p>\n      <button color=\"primary\" (click)=\"otvoriUpitModal()\" class=\"inline-content inline-button\" mat-mini-fab>\n        <mat-icon aria-label=\"Example icon-button with a heart icon\">question_answer</mat-icon>\n      </button>\n    </div>\n  </section>\n  <section class=\"sekcija\">\n    <app-ponuda></app-ponuda>\n  </section>\n  <section class=\"pozadina-bela sekcija\">\n    <app-vesti></app-vesti>\n  </section>\n</main>"

/***/ }),

/***/ "./src/app/e-commerce/dasboard/dasboard.component.scss":
/*!*************************************************************!*\
  !*** ./src/app/e-commerce/dasboard/dasboard.component.scss ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".animated {\n  -webkit-animation-duration: 1s;\n  animation-duration: 1s;\n  -webkit-animation-fill-mode: both;\n  animation-fill-mode: both; }\n\n@-webkit-keyframes fadeIn {\n  0% {\n    opacity: 0; }\n  100% {\n    opacity: 1; } }\n\n@Keyframes fadeIn {\n  0% {\n    opacity: 0; }\n  100% {\n    opacity: 1; } }\n\n.fadeIn {\n  -webkit-animation-name: fadeIn;\n  animation-name: fadeIn; }\n\nimg {\n  height: 300px;\n  vw: 100 !important; }\n\n.sekcija {\n  padding: 30px;\n  padding-bottom: 40px; }\n\n.skecija-mala {\n  padding: 10px; }\n\n.skecija-srednja {\n  padding: 20px; }\n\n.inline-content {\n  display: inline; }\n\n.paragraph {\n  font-size: 1.01em;\n  margin-right: 15px;\n  text-align: center; }\n\n.centar {\n  text-align: center; }\n\n.velicina-ikone {\n  font-size: 0.8em;\n  color: #345cac; }\n\n.header {\n  display: inline;\n  font-size: 0.9em;\n  margin-left: 5px;\n  color: black; }\n\n.pomeri-levo {\n  margin-right: 15px; }\n\n@media only screen and (max-width: 1025px) {\n  .paragraph {\n    font-size: 1em;\n    margin-right: 0px;\n    text-align: left; }\n  .inline-content {\n    display: block; }\n  .inline-button {\n    margin-left: 44%;\n    margin-bottom: 20px;\n    margin-top: 5px; }\n  .mobilni {\n    justify-content: center;\n    align-content: center;\n    text-align: center; } }\n"

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



/***/ }),

/***/ "./src/app/e-commerce/kontakt/kontakt.component.html":
/*!***********************************************************!*\
  !*** ./src/app/e-commerce/kontakt/kontakt.component.html ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\n    <h1>Kontaktirajte nas</h1>\n  <div class=\"pozadina-bela \">\n    <div class=\"d-flex flex-fill flex-column flex-lg-row informacije\">\n      <div class=\"align-self-center flex-fill informacije-deo\">\n        <h2>Informacije</h2>\n      </div>\n      <div class=\"granica-informacije\"></div>\n      <div class=\"flex-fill informacije-deo\">\n        <i class=\"material-icons  boja-glavna-100\">\n          place\n        </i>\n        <div class=\"adresa\">\n          <p>Prvomajska 61</p>\n          <p>15000 Šabac</p>\n        </div>\n      </div>\n      <div class=\"granica-informacije\"></div>\n      <div class=\"flex-fill informacije-deo\">\n        <i class=\"material-icons  boja-glavna-100\">\n          access_alarm\n        </i>\n        <div class=\"d-flex flex-row adresa\">\n          <div class=\"sirina-telefona\">\n            <p class=\"telefoni\">Radnim danom:</p>\n          </div>\n          <div>\n            <ul>\n              <li> 08-18h</li>\n            </ul>\n          </div>\n        </div>\n        <div class=\"d-flex flex-row \">\n          <div class=\"sirina-telefona\">\n            <p class=\"telefoni\">Subotom:</p>\n          </div>\n          <div>\n            <ul>\n              <li> 09-15h</li>\n            </ul>\n          </div>\n        </div>\n        <div class=\"d-flex flex-row \">\n          <div class=\"sirina-telefona\">\n            <p class=\"telefoni\">Nedelja:</p>\n          </div>\n          <div>\n            <ul>\n              <li>Neradan dan</li>\n            </ul>\n          </div>\n        </div>\n      </div>\n      <div class=\"granica-informacije\"></div>\n      <div class=\"flex-fill informacije-deo\">\n        <i class=\"material-icons boja-glavna-100\">\n          phone\n        </i>\n        <div class=\"d-flex flex-row \">\n          <div class=\"sirina-telefona\">\n            <p class=\"telefoni\">Malpoprodaja:</p>\n          </div>\n          <div>\n            <ul>\n              <li><a class=\"telefon\" href=\"tel:015334630\">015/334-630</a></li>\n              <li><a class=\"telefon\" href=\"tel:015310049\">015/310-049</a></li>\n            </ul>\n          </div>\n        </div>\n        <div class=\"d-flex flex-row veleprodaja-dole\">\n          <div class=\"sirina-telefona\">\n            <p class=\"telefoni\">Veleprodaja:</p>\n          </div>\n          <div>\n            <ul>\n              <li> <a class=\"telefon\" href=\"tel:015319000\">015/319-000</a></li>\n              <li class=\"telefon\">015/319-001 Fax </li>\n            </ul>\n          </div>\n        </div>\n        <div class=\"d-flex flex-row veleprodaja-dole\">\n          <div class=\"sirina-telefona\">\n            <p class=\"telefoni\">Email:</p>\n          </div>\n          <div>\n            <ul>\n              <li> office@automaterijal.com</li>\n            </ul>\n          </div>\n        </div>\n      </div>\n    </div>\n  </div>\n  <div class=\"google-mapa\">\n    <iframe\n      src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2833.8797026959655!2d19.695872!3d44.742471!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x6fb532b6b846f3cf!2sAutomaterijal!5e0!3m2!1sen!2sus!4v1548771004118\"\n      frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>\n  </div>\n\n  <div class=\"pozadina-bela\">\n    <div class=\"d-flex flex-fill flex-column flex-lg-row informacije\">\n      <div class=\"flex-fill poruke-deo\">\n        <h2>Pošalji poruku</h2>\n        <div class=\"poruka-div\">\n          <p class=\"poruka-informacije\">\n            <i class=\"material-icons poruka\">\n              mail_outline\n            </i>\n            Pošta </p>\n          <p class=\"poruka-objasnjenje\"> office@automaterijal.com </p>\n        </div>\n        <div class=\"poruka-div\">\n          <p class=\"poruka-informacije\">\n            <i class=\"material-icons poruka\">\n              chat_bubble_outline\n            </i>\n            Pratite nas </p>\n          <div>\n            <a href=\"https://sr-rs.facebook.com/automaterijal/\" target=\"_blank\" mat-fab id=\"drustvena-mreza\"\n              matTooltip=\"Facebook\" color=\"primary\">f</a>\n            <a href=\"https://www.instagram.com/automaterijal/\" target=\"_blank\" mat-fab id=\"drustvena-mreza\"\n              class=\"razmak-drus\" matTooltip=\"Instagram\" color=\"primary\">\n              <i class=\"material-icons instagram\">\n                photo_camera\n              </i>\n            </a>\n          </div>\n        </div>\n      </div>\n      <div class=\"flex-fill\">\n        <form role=\"form\" [formGroup]=\"porukaForm\">\n          <div class=\"forma-poruke\">\n            <table cellspacing=\"0\">\n              <tr>\n                <td>\n                  <mat-form-field>\n                    <input matInput formControlName=\"ime\" placeholder=\"Ime\">\n                  </mat-form-field>\n                </td>\n                <td>\n                  <mat-form-field>\n                    <input matInput formControlName=\"prezime\" placeholder=\"Prezime\">\n                  </mat-form-field>\n                </td>\n              </tr>\n            </table>\n            <table cellspacing=\"0\">\n              <tr>\n                <td>\n                  <mat-form-field>\n                    <input matInput formControlName=\"firma\" placeholder=\"Ima firme\">\n                  </mat-form-field>\n                </td>\n                <td>\n                  <mat-form-field>\n                    <input matInput type=\"tel\" formControlName=\"telefon\" placeholder=\"Broj telefona\">\n                  </mat-form-field>\n                </td>\n              </tr>\n            </table>\n            <div>\n              <mat-form-field class=\"duzina-input\">\n                <input matInput type=\"email\" formControlName=\"posta\" placeholder=\"Pošta\">\n              </mat-form-field>\n              <div *ngIf=\"porukaSubmited && p.posta.errors\">\n                <div *ngIf=\"p.posta.errors.required\">\n                  <p class=\"upozorenje\">Pošta je obavezna</p>\n                </div>\n                <div *ngIf=\"p.posta.errors.email\">\n                  <p class=\"upozorenje\">Pošta nije validna</p>\n                </div>\n              </div>\n            </div>\n            <div>\n              <mat-form-field class=\"duzina-input\">\n                <textarea matInput formControlName=\"poruka\" rows=\"8\" placeholder=\"Poruka\"></textarea>\n              </mat-form-field>\n              <div *ngIf=\"porukaSubmited && p.poruka.errors\">\n                <div *ngIf=\"p.poruka.errors.required\">\n                  <p class=\"upozorenje\">Poruka je obavezna</p>\n                </div>\n                <div *ngIf=\"p.poruka.errors.minlength\">\n                  <p class=\"upozorenje\">Poruka mora imate minimalno 3 karaktera</p>\n                </div>\n              </div>\n            </div>\n            <button mat-flat-button class=\"duzina-input\" (click)=\"posaljiPoruku()\" color=\"primary\">Pošalji</button>\n          </div>\n        </form>\n      </div>\n    </div>\n  </div>\n</main>"

/***/ }),

/***/ "./src/app/e-commerce/kontakt/kontakt.component.scss":
/*!***********************************************************!*\
  !*** ./src/app/e-commerce/kontakt/kontakt.component.scss ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  text-align: center;\n  margin-top: 1em; }\n\nh2 {\n  color: #345cac !important;\n  margin-top: 1em; }\n\nh3 {\n  color: #345cac; }\n\nul {\n  display: inline;\n  text-align: left;\n  margin: 0px;\n  padding: 0px; }\n\nli {\n  color: #263238;\n  margin-top: 2px; }\n\ntd {\n  margin: 0px !important;\n  padding: 0px !important; }\n\niframe {\n  width: 80%;\n  height: 450px; }\n\n.telefon {\n  display: inline;\n  font-size: 1em;\n  margin-left: 5px;\n  color: black; }\n\n.informacije {\n  width: 100%;\n  margin-top: 50px; }\n\n.informacije-deo {\n  padding: 10px;\n  text-align: center; }\n\n.poruka-div {\n  margin-top: 40px; }\n\n.poruka {\n  color: #345cac !important;\n  font-size: 1.5em;\n  position: relative;\n  top: 5px; }\n\n.poruke-deo {\n  position: relative;\n  left: 16%; }\n\n.poruka-informacije {\n  display: inline;\n  font-size: 1.1em; }\n\n.poruka-objasnjenje {\n  color: #345cac !important; }\n\n#drustvena-mreza {\n  width: 45px;\n  height: 45px;\n  font-size: 1.8em; }\n\n#drustvena-mreza:hover {\n  background-color: #547aa1; }\n\n.razmak-drus {\n  margin-left: 10px; }\n\n.instagram {\n  top: -4px;\n  position: relative; }\n\n.mat-fab .mat-button-wrapper {\n  padding: 0px !important;\n  display: inline-block;\n  line-height: 24px;\n  border-radius: 50%; }\n\n.granica-informacije {\n  border-right: 1px solid #dfe5e7;\n  border-left: 1px solid #dfe5e7;\n  margin-top: 30px;\n  height: 130px; }\n\n.telefoni {\n  color: #263238; }\n\n.sirina-telefona {\n  width: 125px;\n  margin-left: 5%;\n  text-align: left; }\n\n.veleprodaja-dole {\n  margin-top: 15px; }\n\n.adresa {\n  margin-top: 10px; }\n\n.google-mapa {\n  margin-top: 5px;\n  margin-left: 15%;\n  height: 405px; }\n\n.forma-poruke {\n  box-shadow: 0 0px 15px 2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);\n  width: 500px;\n  padding: 10px;\n  margin-top: 20px;\n  margin-left: 15%;\n  margin-bottom: 50px;\n  text-align: center; }\n\n.duzina-input {\n  width: 350px;\n  margin-bottom: 1rem; }\n\n.upozorenje {\n  text-align: left;\n  font-size: 0.8em !important;\n  color: red;\n  margin-top: -20px;\n  margin-bottom: 0px;\n  padding-left: 65px; }\n\n@media only screen and (max-width: 1000px) {\n  h2 {\n    padding-left: 0em; }\n  iframe {\n    width: 100%;\n    height: 350px; }\n  .poruke-deo {\n    position: relative;\n    left: 1em; }\n  .google-mapa {\n    height: 305px;\n    margin-top: 5px;\n    margin-left: 0px; }\n  .granica-informacije {\n    border-right: 0px solid #dfe5e7 !important;\n    border-left: 0px solid #dfe5e7 !important;\n    height: 60%; }\n  .informacije[_ngcontent-c9] {\n    width: 100%;\n    margin-left: 0%;\n    margin-top: 50px; }\n  .informacije-deo {\n    width: 100%;\n    text-align: center;\n    font-weight: 500; }\n  .forma-poruke {\n    width: 99%;\n    padding: 0px;\n    margin-left: 2px;\n    margin-right: 2px;\n    margin-top: 20px;\n    margin-bottom: 50px;\n    text-align: center; }\n  .my-snack-bar {\n    background-color: #b71c1c !important; } }\n"

/***/ }),

/***/ "./src/app/e-commerce/kontakt/kontakt.component.ts":
/*!*********************************************************!*\
  !*** ./src/app/e-commerce/kontakt/kontakt.component.ts ***!
  \*********************************************************/
/*! exports provided: KontaktComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KontaktComponent", function() { return KontaktComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_shared_service_email_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/shared/service/email.service */ "./src/app/shared/service/email.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../model/dto */ "./src/app/e-commerce/model/dto.ts");
/* harmony import */ var src_app_shared_service_notifikacija_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/shared/service/notifikacija.service */ "./src/app/shared/service/notifikacija.service.ts");
/* harmony import */ var src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/shared/model/konstante */ "./src/app/shared/model/konstante.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var KontaktComponent = /** @class */ (function () {
    function KontaktComponent(formBuilder, emailServis, notifikacijaServis) {
        this.formBuilder = formBuilder;
        this.emailServis = emailServis;
        this.notifikacijaServis = notifikacijaServis;
        this.porukaSubmited = false;
        this.alive = true;
        this.ucitavanje = false;
    }
    KontaktComponent.prototype.ngOnInit = function () {
        this.inicijalizujForme();
    };
    KontaktComponent.prototype.inicijalizujForme = function () {
        this.porukaForm = this.formBuilder.group({
            ime: [''],
            prezime: [''],
            firma: [''],
            telefon: [''],
            posta: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].email]],
            poruka: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]]
        });
    };
    KontaktComponent.prototype.posaljiPoruku = function () {
        var _this = this;
        this.porukaSubmited = true;
        if (this.porukaForm.invalid) {
            return;
        }
        var poruka = this.popuniPoruku();
        this.emailServis.posaljiPoruku(poruka)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["finalize"])(function () { return _this.ucitavanje = false; })).subscribe(function (res) {
        }, function (error) {
            _this.notifikacijaServis.notify('Poruka nije poslata, pokusajte kasnije.', src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_7__["MatSnackBarKlase"].Crvena);
        });
        this.notifikacijaServis.notify('Poruka uspešno poslatata', src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_7__["MatSnackBarKlase"].Plava);
        this.porukaForm.reset();
        this.porukaSubmited = false;
    };
    KontaktComponent.prototype.popuniPoruku = function () {
        var poruka = new _model_dto__WEBPACK_IMPORTED_MODULE_5__["Poruka"]();
        poruka.ime = this.p.ime.value;
        poruka.prezime = this.p.prezime.value;
        poruka.firma = this.p.firma.value;
        poruka.telefon = this.p.telefon.value;
        poruka.posta = this.p.posta.value;
        poruka.poruka = this.p.poruka.value;
        return poruka;
    };
    Object.defineProperty(KontaktComponent.prototype, "p", {
        // convenience getter for easy access to form fields
        get: function () { return this.porukaForm.controls; },
        enumerable: true,
        configurable: true
    });
    KontaktComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-kontakt',
            template: __webpack_require__(/*! ./kontakt.component.html */ "./src/app/e-commerce/kontakt/kontakt.component.html"),
            styles: [__webpack_require__(/*! ./kontakt.component.scss */ "./src/app/e-commerce/kontakt/kontakt.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"],
            src_app_shared_service_email_service__WEBPACK_IMPORTED_MODULE_2__["EmailService"],
            src_app_shared_service_notifikacija_service__WEBPACK_IMPORTED_MODULE_6__["NotifikacijaService"]])
    ], KontaktComponent);
    return KontaktComponent;
}());



/***/ }),

/***/ "./src/app/e-commerce/model/dto.ts":
/*!*****************************************!*\
  !*** ./src/app/e-commerce/model/dto.ts ***!
  \*****************************************/
/*! exports provided: Poruka, Upit, Brend, VestiNaslovna, Vest */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Poruka", function() { return Poruka; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Upit", function() { return Upit; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Brend", function() { return Brend; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "VestiNaslovna", function() { return VestiNaslovna; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Vest", function() { return Vest; });
var Poruka = /** @class */ (function () {
    function Poruka() {
    }
    return Poruka;
}());

var Upit = /** @class */ (function () {
    function Upit() {
    }
    return Upit;
}());

var Brend = /** @class */ (function () {
    function Brend() {
    }
    return Brend;
}());

var VestiNaslovna = /** @class */ (function () {
    function VestiNaslovna() {
    }
    return VestiNaslovna;
}());

var Vest = /** @class */ (function () {
    function Vest() {
    }
    return Vest;
}());



/***/ }),

/***/ "./src/app/e-commerce/o-nama/o-nama.component.html":
/*!*********************************************************!*\
  !*** ./src/app/e-commerce/o-nama/o-nama.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n  <h1>O nama</h1>\r\n  <div class=\"d-flex flex-column flex-lg-row pozadina-bela\">\r\n    <div class=\"parcele\">\r\n      <div class=\"parcela-ikona\">\r\n        <i class=\"material-icons ikona\">\r\n          account_balance\r\n        </i>\r\n        <h2>Istorija</h2>\r\n      </div>\r\n    </div>\r\n    <div class=\"parcele\">\r\n      <p>\r\n        <b>AUTOMATERIJAL d.o.o. </b> Šabac je osnovano 1990. godine i, sada već preko 29 godina, bavi se snabdevanjem\r\n        našeg tržišta kvalitetnim delovima, mazivima materijalom za održavanje motornih vozila.\r\n      </p>\r\n      <p class=\"drugi-stih\">Poslujemo kao maloprodaja i veleprodaja. Kao veleprodaja razvili smo svoju prodajnu mrežu na\r\n        regionu Zapadne Srbije (mačvanski, sremski, kolubarski i zlatiborski okrug). Naši partneri u ovom poslu su\r\n        fizička lica, ovlašćeni i nezavisni serviseri, vlasnici voznih parkova, proizvođačka industrijska preduzeća,\r\n        veleprodaje i maloprodaje delova i materijala za popravku motornih vozila.\r\n      </p>\r\n    </div>\r\n  </div>\r\n  <div class=\"d-flex flex-column-reverse flex-lg-row\">\r\n    <div class=\"parcele\">\r\n      <p>\r\n        Mi zadovoljavamo potrebe naših partnera koje se najvećim delom odnose na delove i materijal za održavanje i\r\n        popravku motora i stajnog trapa, prvenstveno putničkih motornih vozila proizvedenih u Nemačkoj a sve više smo\r\n        snabdeveni i odgovarajućim artiklima za vozila proizvedena u drugim evropskim zemljama, npr.: Škoda, Fiat,\r\n        Renault, Peugeot, Citroen, Alfa Romeo, Saab, Volvo itd., kao i za vozila proizvedena u Japanu, Koreji i širom\r\n        sveta: Toyota, Honda, Mazda, Nissan, Mitsubishi, Suzuki, Kia, Hyundai, Chevrolet - Daewoo, Chrysler, Rover,\r\n        Daihatsu, Subaru, itd.\r\n      </p>\r\n      <p class=\"drugi-stih\">Uz našu robu uvek plasiramo i dodatnu uslugu, prvenstveno se to odnosi na svaku vrstu pomoći\r\n        u pronalaženju odgovarajućeg artikla i pored svog angažmana u tu svrhu obezbeđujemo odgovarajuću dokumentaciju i\r\n        kataloge za servisere i trgovce. Zatim, organizujemo i realizujemo razne vrste obuka za servisere i trgovce, u\r\n        saradnji sa proizvođačima – uvoznicima učestvujemo u ugovornom opremanju poslovnog – radnog prostora naših\r\n        partnera, istrajavamo u potpunom realizovanju svih ugovorenih garancija i drugo.\r\n      </p>\r\n    </div>\r\n    <div class=\"parcele\">\r\n      <div class=\"parcela-ikona\">\r\n        <i class=\"material-icons ikona\">\r\n          work\r\n        </i>\r\n        <h2>Usluge</h2>\r\n      </div>\r\n    </div>\r\n  </div>\r\n  <div class=\"d-flex flex-column flex-lg-row pozadina-bela\">\r\n    <div class=\"parcele\">\r\n      <div class=\"parcela-ikona\">\r\n        <i class=\"material-icons ikona\">\r\n          build\r\n        </i>\r\n        <h2>Proizvodi</h2>\r\n      </div>\r\n    </div>\r\n    <div class=\"parcele\">\r\n      <p>\r\n        Za neke brendove smo se zaštitili kao ovlašćeni uvoznici i distributeri za definisanu teritoriju, a sa nekim\r\n        konkurentima i sarađujemo, tako da smo vremenom izgradili poziciju nezaobilaznog faktora na svom terenu u\r\n        oblasti kojom se bavimo. AUTOMATERIJAL d.o.o. je direktni uvoznik, iz Nemačke, od proizvođača \"Kolbenschmidt\",\r\n        \"Pierburg\", i \"Victor Reinz\", iz Italije \"DeDaX\", zastupnik koncerna \"Bilstein\" i \"Febi\", uključujući i brend\r\n        \"Blue Print\", regionalni zastupnik - ovlašćeni distributer „Magneti Marelli“, regionalni zastupnik - ovlašćeni\r\n        distributer „Shell“, „Castrol“ „TOTAL“, „Fuchs“, „LukOil“ i „ENEOS“ maziva, ovlašćeni distributer i serviser\r\n        „energizer“ akumulatora, regionalni zastupnik - originalih BMW rezervnih delova. U našoj prodaji se nalaze\r\n        proizvodi raznih renomiranih proizvodjača rezervnih delova i opreme.</p>\r\n    </div>\r\n  </div>\r\n  <div class=\"pozadina-bela\">\r\n    <div class=\"d-flex justify-content-center logoi\">\r\n      <div class=\"owl-carousel-moj\">\r\n        <owl-carousel [options]=\"mySlideOptions\"[carouselClasses]=\"['owl-theme']\">\r\n          <div class=\"item\" *ngFor=\"let brand of mySlideBrands;let i = index\">\r\n            <div class=\"dobavljaci-logo\">\r\n                <button mat-button class=\"dugme\" (click)=\"otvoriDialog(brand)\">\r\n                <img width=\"65px\" height=\"65px\" src={{brand.urlSlikeLogo}} />\r\n              </button>\r\n            </div>\r\n          </div>\r\n        </owl-carousel>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</main>"

/***/ }),

/***/ "./src/app/e-commerce/o-nama/o-nama.component.scss":
/*!*********************************************************!*\
  !*** ./src/app/e-commerce/o-nama/o-nama.component.scss ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  text-align: center;\n  margin-top: 1em;\n  margin-bottom: 1em; }\n\nh2 {\n  color: #345cac; }\n\np {\n  text-align: justify; }\n\n.parcele {\n  width: 50%;\n  padding: 3%; }\n\n.parcela-ikona {\n  text-align: center;\n  position: relative;\n  bottom: -30%; }\n\n.drugi-stih {\n  margin-top: 1rem; }\n\n.ikona {\n  font-size: 3rem;\n  color: #345cac;\n  text-align: center; }\n\n.dobavljaci-logo {\n  width: 65px;\n  height: 65px; }\n\n.logoi {\n  width: 80%;\n  margin-left: 10%; }\n\n.owl-carousel-moj {\n  width: 930px !important; }\n\n.dugme {\n  padding: 0 11px; }\n\n@media only screen and (max-device-width: 1025px) {\n  .owl-carousel-moj {\n    width: 500px !important; }\n  .parcele {\n    width: 100%;\n    padding: 3%; }\n  .logoi {\n    width: 100%;\n    margin-left: 0%; }\n  .owl-carousel-moj {\n    width: 100% !important; } }\n\n@media only screen and (max-width: 1025px) {\n  .owl-carousel-moj {\n    width: 100% !important; }\n  .parcele {\n    width: 100%;\n    padding: 3%; }\n  .logoi {\n    width: 100%;\n    margin-left: 0%; } }\n"

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
        this.mySlideOptions = null;
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
        if (this.innerWidth < 500) {
            this.mySlideOptions = {
                items: 3, margin: 5,
                dots: true, nav: false, autoplay: true,
                autoplayTimeout: 2500, rewind: true
            };
        }
        else {
            this.mySlideOptions = {
                items: 7, margin: 20,
                dots: true, nav: false, autoplay: true,
                autoplayTimeout: 2500, rewind: true
            };
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

/***/ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.html":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.html ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <main>\r\n        <div *ngIf=\"faktura && fakturaDetalji && dataSource != null && dataSource.length > 0\">\r\n            <h1>Detalji fakture: {{faktura.id}}</h1>\r\n            <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n                <button class=\"button-glavni-100 nazad-button\" mat-raised-button (click)=\"idiNazad()\">\r\n                    <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n                </button>\r\n            </div>\r\n\r\n            <div class=\"d-flex flex-wrap bd-highlight flex-sm-row flex-column detalji-div\">\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-100\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.status\" class=\"boja-siva-400\">Status: {{faktura.status.naziv}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-100\" for=\"inputGroupSelect01\">\r\n                        <p class=\"boja-siva-400\">Datum: {{faktura.vremePorucivanja | datum}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-100\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.nacinPlacanja\" class=\"boja-siva-400\">Nacin placanja:\r\n                            {{faktura.nacinPlacanja.naziv}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-100\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.nacinPrevoza\" class=\"boja-siva-400\">Nacin prevoza: {{\"prevoz_\" +\r\n                            faktura.nacinPrevoza.id | translate}}</p>\r\n                    </label>\r\n                </div>\r\n                <div class=\"p-1 flex-fill bd-highlight\">\r\n                    <label class=\"input-group-text button-glavni-100\" for=\"inputGroupSelect01\">\r\n                        <p *ngIf=\"faktura.adresa\" class=\"boja-siva-400\">Adresa: {{faktura.adresa.naziv}}</p>\r\n                    </label>\r\n                </div>\r\n            </div>\r\n            <div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n                <table mat-table [dataSource]=\"dataSource\">\r\n\r\n                    <!-- Kataloski broj Column -->\r\n                    <ng-container matColumnDef=\"robaId\">\r\n                        <th mat-header-cell *matHeaderCellDef> Kataloski Broj </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{faktura.kataloskiBroj}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Kataloski broj Column -->\r\n                    <ng-container matColumnDef=\"proizvodjac\">\r\n                        <th mat-header-cell *matHeaderCellDef> Proizvodjač </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p >\r\n                                {{faktura.proizvodjac.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Narucena Kolicina Column -->\r\n                    <ng-container matColumnDef=\"kolicina\">\r\n                        <th mat-header-cell *matHeaderCellDef> Narucena Kolicina</th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p >\r\n                                {{faktura.kolicina}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Potvrdjena Kolicina Column -->\r\n                    <ng-container matColumnDef=\"potvrdjenaKolicina\">\r\n                        <th mat-header-cell *matHeaderCellDef> Potvrdjena Kolicina </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p >\r\n                                {{faktura.potvrdjenaKolicina}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Rabat Column -->\r\n                    <ng-container matColumnDef=\"rabat\">\r\n                        <th mat-header-cell *matHeaderCellDef> Rabat </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p >\r\n                                {{faktura.rabat}}%\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"cena\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-1 text-right iznos-margin\">\r\n                                {{faktura.cena | currency:\" \"}} RSD\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- tatus Column -->\r\n                    <ng-container matColumnDef=\"status\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\">Status</th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"text-center mat-body-1\">\r\n                                {{faktura.status.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n                    <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n                </table>\r\n                <div class=\"d-flex flex-column flex-sm-row\">\r\n                    <div class=\"d-flex flex-fill justify-content-end\">\r\n                    </div>\r\n                    <div class=\"d-flex flex-fill justify-content-end\">\r\n                        <table class=\"table sirina-cena\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td class=\"pozadina-glavna-50 boja-siva-400\">Ukupnan iznos: </td>\r\n                                    <td class=\"text-right\"><b>{{faktura.iznosPotvrdjen | currency:\" \"}} RSD</b></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div *ngIf=\"dataSource == null || dataSource.length == 0\">\r\n            <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n                <button class=\"button-glavni-100 nazad-button nazad-dugme-dole\" mat-raised-button (click)=\"idiNazad()\">\r\n                    <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n                </button>\r\n            </div>\r\n            <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n                <i class=\"material-icons icon-size\">\r\n                    error_outline\r\n                </i>\r\n                <h1 class=\"h1-faktura-upozorenje\">Porudzbenica je prazna</h1>\r\n            </div>\r\n        </div>\r\n        <div *ngIf=\"error\">\r\n            <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n                <button class=\"button-glavni-100 nazad-button greska-dugme-pozicija\" mat-raised-button (click)=\"idiNazad()\">\r\n                    <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n                </button>\r\n            </div>\r\n            <div class=\"d-flex flex-column prazna-tabela\">\r\n                <i class=\"material-icons icon-size\">\r\n                    error_outline\r\n                </i>\r\n                <h1 class=\"h1-faktura-upozorenje\">Porudzbenica ne postoji</h1>\r\n            </div>\r\n        </div>\r\n    </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.scss":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura-detalji/faktura-detalji.component.scss ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  margin-left: 5%;\n  margin-top: 0.5em; }\n\np {\n  font-size: 0.92em; }\n\ntable {\n  margin: 0px !important; }\n\n.nazad-dugme-dole {\n  top: 40px; }\n\n.greska-dugme-pozicija {\n  position: relative;\n  top: 50px; }\n\n.detalji-div {\n  width: 90%;\n  margin-left: 5%; }\n\n@media only screen and (max-device-width: 640px) {\n  h1 {\n    margin-top: 0px; }\n  .nazad-dugme-dole {\n    top: 10px; }\n  .greska-dugme-pozicija {\n    position: relative;\n    top: 5px; } }\n"

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
            }, function (error) {
                _this.error = true;
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

module.exports = "<div class=\"container-fluid\">\r\n    <main>\r\n        <div *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n            <h1>Moje porudzbenice</h1>\r\n            <div class=\"tabela-div\">\r\n                <table mat-table [dataSource]=\"dataSource\">\r\n\r\n                    <!-- Kataloski broj Column -->\r\n                    <ng-container matColumnDef=\"orderId\">\r\n                        <th mat-header-cell *matHeaderCellDef> Broj Fakture </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{faktura.orderId}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Broj stavki Column -->\r\n                    <ng-container matColumnDef=\"brojStavki\">\r\n                        <th mat-header-cell *matHeaderCellDef>Broj stavki</th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p >\r\n                                {{faktura.brojStavki}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"iznosNarucen\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Iznos narucen </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2 text-right iznos-margin\">\r\n                                {{faktura.iznosNarucen | currency:\" \"}} RSD\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    \r\n                    <!-- Cena Column -->\r\n                    <ng-container matColumnDef=\"iznosPotvrdjen\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Iznos potvrdjen </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2 text-right iznos-margin\">\r\n                                {{faktura.iznosPotvrdjen | currency:\" \"}} RSD\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Vreme porucivanja Column -->\r\n                    <ng-container matColumnDef=\"vremePorucivanja\">\r\n                        <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Datum </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p  class=\"text-center\">\r\n                                {{faktura.vremePorucivanja | datum}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Status Column -->\r\n                    <ng-container matColumnDef=\"status\">\r\n                        <th mat-header-cell *matHeaderCellDef> Status </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <p class=\"mat-body-2\">\r\n                                {{faktura.status.naziv}}\r\n                            </p>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <!-- Akcije Column -->\r\n                    <ng-container matColumnDef=\"ackije\">\r\n                        <th mat-header-cell *matHeaderCellDef> </th>\r\n                        <td mat-cell *matCellDef=\"let faktura\">\r\n                            <button class=\"button-glavni-100\" mat-raised-button (click)=\"detaljiFakture(faktura.id)\">Detalji</button>\r\n                        </td>\r\n                    </ng-container>\r\n\r\n                    <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n                    <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n                </table>\r\n                <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n                    [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n                </mat-paginator>\r\n            </div>\r\n        </div>\r\n\r\n        <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"error\">\r\n            <i class=\"material-icons icon-size\">\r\n                error_outline\r\n            </i>\r\n            <h1 class=\"h1-faktura-upozorenje\">Istorija porucivanja je prazna</h1>\r\n        </div>\r\n    </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/faktura/faktura.component.scss":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/faktura/faktura.component.scss ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".napomena {\n  width: 300px; }\n\nh1 {\n  margin-top: 30px;\n  margin-left: 5%; }\n\n@media only screen and (max-device-width: 640px) {\n  h1 {\n    margin-top: 0px; } }\n"

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
        this.displayedColumns = ['orderId', 'brojStavki', 'iznosNarucen', 'iznosPotvrdjen', 'vremePorucivanja', 'status', 'ackije'];
    }
    FakturaComponent.prototype.ngOnInit = function () {
        var _this = this;
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
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
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

/***/ "./src/app/e-shop/korpa/korpa.component.html":
/*!***************************************************!*\
  !*** ./src/app/e-shop/korpa/korpa.component.html ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"dataSource.length == 0\">\r\n        <i class=\"material-icons icon-size\">\r\n            shopping_cart\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Korpa je trenutno prazna</h1>\r\n    </div>\r\n    <div class=\"tabela-div\" *ngIf=\"dataSource.length > 0\">\r\n        <i class=\"material-icons korpa-h1\">\r\n            shopping_cart\r\n        </i>\r\n        <div class=\"margin-bottom--10\" style=\"overflow-x:auto;\">\r\n            <p class=\"pdv\"><i>Sve cene su prikazane sa pdv-om.</i></p>\r\n            <table mat-table [dataSource]=\"dataSource\" class=\"mat-elevation-z8\">\r\n                <!-- Kataloski broj Column -->\r\n                <ng-container matColumnDef=\"katbr\">\r\n                    <th mat-header-cell *matHeaderCellDef> Kataloski broj </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.katbr}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Kataloski broj proizvodjaca Column -->\r\n                <ng-container matColumnDef=\"katbrpro\">\r\n                    <th mat-header-cell *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p>\r\n                            {{roba.katbrpro}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Naziv Column -->\r\n                <ng-container matColumnDef=\"naziv\">\r\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p>\r\n                            {{roba.naziv}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Proizvodjač Column -->\r\n                <ng-container matColumnDef=\"proizvodjac\">\r\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjač </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.proizvodjac.naziv}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Cena Column -->\r\n                <ng-container matColumnDef=\"kolicina\">\r\n                    <th mat-header-cell *matHeaderCellDef> Kolicina </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.kolicina}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Cena Column -->\r\n                <ng-container matColumnDef=\"cena\">\r\n                    <th mat-header-cell *matHeaderCellDef> Ukupno </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.cenaUkupno | currency:\" \"}} DIN\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Kolicina Column -->\r\n                <ng-container matColumnDef=\"izbaciDugme\">\r\n                    <th mat-header-cell *matHeaderCellDef> </th>\r\n                    <td mat-cell *matCellDef=\"let roba; let i = index;\">\r\n                        <div class=\"d-flex flex-column flex-lg-row bd-highlight\">\r\n                            <div class=\"p-1 bd-highlight\">\r\n                                <button class=\"button-glavni-100\" mat-raised-button\r\n                                    (click)=\"otvoriDialog(roba)\">Izmeni</button>\r\n                            </div>\r\n                            <div class=\"p-1 bd-highlight\">\r\n                                <button class=\"button-crveni-50\" mat-raised-button\r\n                                    (click)='izbaciIzKorpe(i)'>Izbaci</button>\r\n                            </div>\r\n                        </div>\r\n\r\n                </ng-container>\r\n\r\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n            </table>\r\n        </div>\r\n        <div class=\"d-flex flex-column flex-xl-row\">\r\n            <div class=\"d-flex flex-column flex-xl-row flex-fill \">\r\n                <div class=\"flex-fill\">\r\n                    <div class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                        <div *ngIf=\"nacinPlacanja && nacinPlacanja.length > 0\" class=\"granice\">\r\n                            <h3>Način plaćanja</h3>\r\n                            <hr>\r\n                            <mat-radio-group class=\"radio-grupa\" [(ngModel)]=\"izabranNacinPlacanja\">\r\n                                <mat-radio-button color=\"primary\" class=\"radio-dugme\"\r\n                                    *ngFor=\"let placanje of nacinPlacanja\" [value]=\"placanje\">\r\n                                    {{placanje.naziv}}\r\n                                </mat-radio-button>\r\n                            </mat-radio-group>\r\n                        </div>\r\n                    </div>\r\n                    <div *ngIf=\"nacinPrevoza && nacinPrevoza.length > 0\"\r\n                        class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                        <div class=\"granice visina-prevoza\">\r\n                            <h3>Način prevoza</h3>\r\n                            <hr>\r\n                            <mat-radio-group class=\"radio-grupa\" [(ngModel)]=\"izabranNacinPrevoza\">\r\n                                <mat-radio-button color=\"primary\" class=\"radio-dugme\"\r\n                                    *ngFor=\"let prevoz of nacinPrevoza\" [value]=\"prevoz\">\r\n                                    {{\"prevoz_\" + prevoz.id | translate}}\r\n                                </mat-radio-button>\r\n                            </mat-radio-group>\r\n                        </div>\r\n                        <div *ngIf=\"izabranNacinPrevoza.id === 2\" class=\"granice pomeri-dole\">\r\n                            <h4>Izaberite način dostave</h4>\r\n                            <mat-radio-group class=\"radio-grupa\" [(ngModel)]=\"izabranaTrecaLiceOpcija\">\r\n                                <mat-radio-button color=\"primary\" class=\"radio-dugme\"\r\n                                    *ngFor=\"let opcije of treceLiceOpcije\" [value]=\"opcije\">\r\n                                    {{opcije}}\r\n                                </mat-radio-button>\r\n                            </mat-radio-group>\r\n                            <div>\r\n                                <div *ngIf=\"izabranaTrecaLiceOpcija === treceLiceOpcije[0]\">\r\n                                    <mat-form-field>\r\n                                        <mat-select placeholder=\"Kurirske sluzbe\" [(ngModel)]=\"izabraneKurirskeSluzbe\">\r\n                                            <mat-option *ngFor=\"let sluzbe of kurirskeSluzbe\" [value]=\"sluzbe\">\r\n                                                {{sluzbe}}\r\n                                            </mat-option>\r\n                                        </mat-select>\r\n                                    </mat-form-field>\r\n                                </div>\r\n                                <div *ngIf=\"izabranaTrecaLiceOpcija === treceLiceOpcije[1]\">\r\n                                    <mat-form-field role=\"form\" [formGroup]=\"drugiNacinPrevoza\">\r\n                                        <textarea matInput #prevoz formControlName=\"prevoz\"\r\n                                            placeholder=\"Upišite drugi način prevoza...\"></textarea>\r\n                                    </mat-form-field>\r\n                                    <div *ngIf=\"dugmeZaPorucivanjeStisnuto && d.prevoz.errors\">\r\n                                        <div *ngIf=\"d.prevoz.errors.required\">\r\n                                            <p class=\"upozorenje\">Ovo polje je obavezno</p>\r\n                                        </div>\r\n                                        <div *ngIf=\"d.prevoz.errors.minlength\">\r\n                                            <p class=\"upozorenje\">Minimalno 3 karaktera</p>\r\n                                        </div>\r\n                                    </div>\r\n                                </div>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n                <div class=\"flex-fill\">\r\n                    <div class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                        <div *ngIf=\"nacinPlacanja && nacinPlacanja.length > 0\" class=\"granice visina\">\r\n                            <h3>Napomena</h3>\r\n                            <hr>\r\n                            <mat-form-field class=\"sirina-cena\">\r\n                                <textarea matInput class=\"napomena\" [(ngModel)]=\"napomena\"\r\n                                    placeholder=\"Unesite napomenu...\"></textarea>\r\n                            </mat-form-field>\r\n                        </div>\r\n                    </div>\r\n                    <div class=\"d-flex flex-fill flex-column pomeri-dole\">\r\n                        <div *ngIf=\"nacinPlacanja && nacinPlacanja.length > 0\" class=\"granice\">\r\n                            <h3>Izaberite adresu dostave</h3>\r\n                            <hr>\r\n                            <mat-radio-group class=\"radio-grupa\" [(ngModel)]=\"izabraneAdresaDostave\">\r\n                                <mat-radio-button color=\"primary\" class=\"radio-dugme\"\r\n                                    *ngFor=\"let adresa of adresaDostave\" [value]=\"adresa\">\r\n                                    {{adresa}}\r\n                                </mat-radio-button>\r\n                            </mat-radio-group>\r\n                        </div>\r\n                        <div class=\"granice pomeri-dole\">\r\n                            <div *ngIf=\"izabraneAdresaDostave === adresaDostave[0]\" class=\"pomeri-dole\">\r\n                                <h4>Adresa</h4>\r\n                                <label> {{partner.adresa}}</label>\r\n                            </div>\r\n                            <div *ngIf=\"izabraneAdresaDostave === adresaDostave[1]\" class=\"pomeri-dole\">\r\n                                <h4>Druga adresa dostave</h4>\r\n                                <form role=\"form\" [formGroup]=\"adresaForm\">\r\n                                    <div>\r\n                                        <mat-form-field role=\"form\">\r\n                                            <input type=\"text\" #ulica formControlName=\"ulica\" matInput\r\n                                                placeholder=\"Ulica i broj\">\r\n                                        </mat-form-field>\r\n                                    </div>\r\n                                    <div *ngIf=\"dugmeZaPorucivanjeStisnuto && a.ulica.errors\">\r\n                                        <div *ngIf=\"a.ulica.errors.required\">\r\n                                            <p class=\"upozorenje\">Naziv ulice je obavezan</p>\r\n                                        </div>\r\n                                        <div *ngIf=\"a.ulica.errors.minlength\">\r\n                                            <p class=\"upozorenje\">Naziv ulice mora imati minimalno 3 karaktera</p>\r\n                                        </div>\r\n                                    </div>\r\n                                    <div>\r\n                                        <mat-form-field role=\"form\">\r\n                                            <input type=\"text\" #grad formControlName=\"grad\" matInput placeholder=\"Grad\">\r\n                                        </mat-form-field>\r\n                                    </div>\r\n                                    <div *ngIf=\"dugmeZaPorucivanjeStisnuto && a.grad.errors\">\r\n                                        <div *ngIf=\"a.grad.errors.required\">\r\n                                            <p class=\"upozorenje\">Naziv grada je obavezan</p>\r\n                                        </div>\r\n                                        <div *ngIf=\"a.grad.errors.minlength\">\r\n                                            <p class=\"upozorenje\">Naziv grada mora imati minimalno 2 karaktera</p>\r\n                                        </div>\r\n                                    </div>\r\n                                </form>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n            <div class=\"d-flex flex-fill flex-column\">\r\n                <table class=\"table sirina-cena\">\r\n                    <tbody>\r\n                        <tr>\r\n                            <td class=\"pozadina-glavna-50 boja-siva-400\">Bez pdv-a: </td>\r\n                            <td class=\"text-right\">{{bezPdv | currency:\" \"}} RSD</td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td class=\"pozadina-glavna-50 boja-siva-400\">Pdv: </td>\r\n                            <td class=\"text-right\">{{pdv | currency:\" \"}} RSD</td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td class=\"pozadina-glavna-50 boja-siva-400\">Ukupno za uplatu: </td>\r\n                            <td class=\"text-right\"><b>{{ukupno | currency:\" \"}} RSD</b></td>\r\n                        </tr>\r\n                    </tbody>\r\n                </table>\r\n                <div>\r\n                    <button class=\"button-glavni-100 dugme-sirina float-right\" mat-raised-button\r\n                        (click)=\"posaljiPorudzbinu(roba)\">Potvrdi</button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/korpa/korpa.component.scss":
/*!***************************************************!*\
  !*** ./src/app/e-shop/korpa/korpa.component.scss ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".korpa-h1 {\n  margin-top: 0.5em;\n  font-size: 3.5em;\n  color: #345cac; }\n\np {\n  text-align: left !important; }\n\nh3 {\n  font-weight: bold;\n  padding-left: 10px;\n  padding-top: 10px;\n  color: #345cac; }\n\nhr {\n  width: 90%;\n  margin-bottom: 5px;\n  margin-top: 5px; }\n\nh4 {\n  font-size: 1em;\n  font-weight: bold;\n  padding-left: 1em;\n  color: #345cac; }\n\ntextarea {\n  color: #273747; }\n\nlabel {\n  color: #273747;\n  font-weight: bold; }\n\n.radio-grupa {\n  display: inline-flex;\n  flex-direction: column; }\n\n.radio-dugme {\n  margin: 2px;\n  font-size: 0.8em !important; }\n\n.sirina-cena {\n  width: 95%; }\n\n.dugme-sirina {\n  width: 150px;\n  height: 40px;\n  border-radius: 5px; }\n\n.granice {\n  box-shadow: 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);\n  background-color: white;\n  padding-left: 5px;\n  width: 95%;\n  margin: 5px; }\n\n.pomeri-dole {\n  margin-top: 7px; }\n\n.visina {\n  height: 181px; }\n\n.visina-prevoza {\n  height: 193px; }\n\n.napomena {\n  height: 80px; }\n\n.google-mapa {\n  margin-left: 10%;\n  width: 80%; }\n\n@media only screen and (max-device-width: 640px) {\n  .korpa-h1 {\n    margin-top: 0.5em; }\n  .sirina-cena {\n    width: 95%;\n    margin-left: 2%; } }\n"

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
                _this.inicijalizujKorup();
            }
            else {
                _this.router.navigate(['/login']);
                _this.loginServis.izbaciPartnerIzSesije();
            }
        });
    };
    KorpaComponent.prototype.inicijalizujKorup = function () {
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

/***/ "./src/app/e-shop/login/login.component.css":
/*!**************************************************!*\
  !*** ./src/app/e-shop/login/login.component.css ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".flex-login {\r\n    margin-top: 10%;\r\n    display: flex;\r\n    justify-content: center;\r\n}\r\n.login-form {\r\n    width: 400px;\r\n    justify-content: center;\r\n}\r\nh1 {\r\n    text-align: center;\r\n\ttext-transform: uppercase;\r\n}\r\nbutton{\r\n    margin:auto;\r\n    display:block;\r\n}\r\np {\r\n      text-align: center;\r\n}\r\n.is-invalid {\r\n    border: 1px solid red;\r\n}\r\n.upozorenje {\r\n    text-align: left;\r\n    font-size: 0.8em;\r\n    margin:0px !important;\r\n    color: red;\r\n}\r\n"

/***/ }),

/***/ "./src/app/e-shop/login/login.component.html":
/*!***************************************************!*\
  !*** ./src/app/e-shop/login/login.component.html ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n\t<div class=\"flex-login\">\r\n\t\t<div class=\"login-form\">\r\n\t\t\t<h1>Prijavi se</h1>\r\n\t\t\t<div class=\"alert alert-danger\" role=\"alert\" *ngIf=\"!uspesnoLogovanje\">\r\n\t\t\t\t<p>Korisničko ime ili šifra je pogrešna.</p>\r\n\t\t\t</div>\r\n\t\t\t<form role=\"form\" (keydown)=\"enterNaFormi($event)\" [formGroup]=\"registerForm\">\r\n\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t<input type=\"text\" formControlName=\"username\" class=\"form-control rounded\" placeholder=\"Korisničko ime\" id=\"username\"\r\n\t\t\t\t\t name=\"username\" [(ngModel)]=\"credentials.username\" [ngClass]=\"{ 'is-invalid': submitted && registerForm.controls.username.errors }\" />\r\n\t\t\t\t\t<div *ngIf=\"submitted && registerForm.controls.username.errors\">\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.username.errors.required\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Korisničko ime je obavezno</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.username.errors.minlength\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Korisničko ime mora imati minimalno 3 karaktera</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t<input type=\"password\" formControlName=\"password\" class=\"form-control rounded\" placeholder=\"Šifra\" id=\"password\"\r\n\t\t\t\t\t name=\"password\" [(ngModel)]=\"credentials.password\" [ngClass]=\"{ 'is-invalid': submitted && registerForm.controls.password.errors }\" />\r\n\t\t\t\t\t<div *ngIf=\"submitted && registerForm.controls.password.errors\">\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.password.errors.required\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Šifra je obavezna</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.password.errors.minlength\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Šifra mora imati minimalno 3 karaktera</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"d-flex\">\r\n\t\t\t\t\t<button mat-button type=\"button\" (click)=\"otvoriResgracijaDialog()\" class=\"boja-glavna-100\">Nemate nalog?</button>\r\n\t\t\t\t\t<button mat-raised-button (click)=\"login()\" class=\"rounded button-glavni-100\">Prijava</button>\r\n\t\t\t\t\t<button mat-button type=\"button\" (click)=\"otvoriZaboravljenuSifruDialog()\" class=\"boja-glavna-100\">Zaboravili ste šifru?</button>\r\n\t\t\t\t</div>\r\n\t\t\t</form>\r\n\t\t</div>\r\n\t</div>\r\n</div>"

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
/* harmony import */ var src_app_shared_modal_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/shared/modal/registracija-modal/registracija-modal.component */ "./src/app/shared/modal/registracija-modal/registracija-modal.component.ts");
/* harmony import */ var src_app_shared_modal_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component */ "./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _service_data_local_storage_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../service/data/local-storage.service */ "./src/app/e-shop/service/data/local-storage.service.ts");
/* harmony import */ var src_app_shared_modal_prvo_logovanje_modal_prvo_logovanje_modal_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component */ "./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.ts");
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
    function LoginComponent(loginServis, formBuilder, dataService, router, dialog) {
        this.loginServis = loginServis;
        this.formBuilder = formBuilder;
        this.dataService = dataService;
        this.router = router;
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
        this.uspesnoLogovanje = true;
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
        this.loginServis.ulogujSe(this.credentials).subscribe(function () {
            _this.vratiKorisnika();
        });
    };
    LoginComponent.prototype.vratiKorisnika = function () {
        var _this = this;
        this.dataService.ocistiKorpuIzMemorije();
        this.loginServis.vratiUlogovanogKorisnika(true)
            .subscribe(function (res) {
            if (res !== null) {
                _this.partner = res;
                _this.uspesnoLogovanje = true;
                _this.loginServis.setDaLiJeUserLogovan(true);
                _this.loginServis.setUlogovanogPartner(_this.partner);
                if (_this.partner.loginCount === 0) {
                    _this.dialog.open(src_app_shared_modal_prvo_logovanje_modal_prvo_logovanje_modal_component__WEBPACK_IMPORTED_MODULE_8__["PrvoLogovanjeModalComponent"], {
                        width: '600px',
                        data: _this.partner,
                        disableClose: true
                    });
                }
                _this.router.navigateByUrl('naslovna');
            }
            else {
                _this.uspesnoLogovanje = false;
                _this.loginServis.setDaLiJeUserLogovan(false);
                _this.dataService.logout();
            }
        });
    };
    LoginComponent.prototype.otvoriResgracijaDialog = function () {
        this.dialog.open(src_app_shared_modal_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_4__["RegistracijaModalComponent"], {
            width: '400px'
        });
    };
    LoginComponent.prototype.otvoriZaboravljenuSifruDialog = function () {
        this.dialog.open(src_app_shared_modal_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_5__["ZaboravljenaSifraModalComponent"], {
            width: '400px'
        });
    };
    LoginComponent.prototype.enterNaFormi = function (event) {
        if (event.keyCode === 13) {
            this.login();
        }
    };
    LoginComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/e-shop/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/e-shop/login/login.component.css")]
        }),
        __metadata("design:paramtypes", [_service_login_service__WEBPACK_IMPORTED_MODULE_1__["LoginService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _service_data_local_storage_service__WEBPACK_IMPORTED_MODULE_7__["LocalStorageService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_6__["Router"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatDialog"]])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/akumulatori/akumulatori.component.css":
/*!**********************************************************************!*\
  !*** ./src/app/e-shop/magacin/akumulatori/akumulatori.component.css ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 150px;\r\n    background-image: url('/automaterijal/assets/slike/ui/pozadine/akumulatori.png');\r\n    background-repeat: no-repeat;\r\n    background-size: cover;\r\n}"

/***/ }),

/***/ "./src/app/e-shop/magacin/akumulatori/akumulatori.component.html":
/*!***********************************************************************!*\
  !*** ./src/app/e-shop/magacin/akumulatori/akumulatori.component.html ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n\r\n    <div class=\"sekcija-pretraga\">\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\"\r\n                    (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=pozadina-glavna-100>\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button matTooltip=\"Filter\" *ngIf=\"!otvoriFilter\" class=pozadina-glavna-100 mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilter\" mat-mini-fab class=\"button-glavni-200\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n    </div>\r\n\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [otvoriFilter]=\"otvoriFilter\" (filterEvent)=\"filtriraj($event)\"></app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/magacin/akumulatori/akumulatori.component.ts":
/*!*********************************************************************!*\
  !*** ./src/app/e-shop/magacin/akumulatori/akumulatori.component.ts ***!
  \*********************************************************************/
/*! exports provided: AkumulatoriComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AkumulatoriComponent", function() { return AkumulatoriComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _service_roba_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var _service_data_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _model_roba_enum__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../model/roba.enum */ "./src/app/e-shop/model/roba.enum.ts");
/* harmony import */ var _model_filter__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../model/filter */ "./src/app/e-shop/model/filter.ts");
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
    function AkumulatoriComponent(robaService, dataService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.vrstaRobe = _model_roba_enum__WEBPACK_IMPORTED_MODULE_5__["VrstaRobe"].AKUMULATORI;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new _model_filter__WEBPACK_IMPORTED_MODULE_6__["Filter"]();
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
    }
    AkumulatoriComponent.prototype.ngOnInit = function () {
        this.pocetnoPretrazivanje = true;
        this.pronandjiSveAkumulatore();
    };
    AkumulatoriComponent.prototype.pronandjiSveAkumulatore = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiAkumulatore(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
        });
    };
    AkumulatoriComponent.prototype.pronadjiAkumulatorePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiAkumulatore(this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
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
    AkumulatoriComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilter = !this.otvoriFilter;
    };
    AkumulatoriComponent.prototype.filtriraj = function (filter) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.filter = filter;
        this.pronadjiAkumulatorePoPretrazi(this.searchValue);
    };
    AkumulatoriComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-akumulatori',
            template: __webpack_require__(/*! ./akumulatori.component.html */ "./src/app/e-shop/magacin/akumulatori/akumulatori.component.html"),
            styles: [__webpack_require__(/*! ./akumulatori.component.css */ "./src/app/e-shop/magacin/akumulatori/akumulatori.component.css")]
        }),
        __metadata("design:paramtypes", [_service_roba_service__WEBPACK_IMPORTED_MODULE_3__["RobaService"],
            _service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"]])
    ], AkumulatoriComponent);
    return AkumulatoriComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/filteri/filteri.component.css":
/*!**************************************************************!*\
  !*** ./src/app/e-shop/magacin/filteri/filteri.component.css ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 150px;\r\n    background-image: url('/automaterijal/assets/slike/ui/pozadine/filteri.png');\r\n    background-repeat: no-repeat;\r\n    background-size: cover;\r\n}\r\n@media only screen and (max-device-width :1025px) { \r\n    .mobilna-duzina {\r\n        width: 100%;\r\n    }\r\n    .input-group-prepend {\r\n        margin-top: 10px;\r\n        margin-left: 0px;\r\n    }\r\n}"

/***/ }),

/***/ "./src/app/e-shop/magacin/filteri/filteri.component.html":
/*!***************************************************************!*\
  !*** ./src/app/e-shop/magacin/filteri/filteri.component.html ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"sekcija-pretraga\">\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\"\r\n                    (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=pozadina-glavna-100>\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button matTooltip=\"Filter\" *ngIf=\"!otvoriFilter\" class=pozadina-glavna-100 mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilter\" mat-mini-fab class=\"button-glavni-200\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [otvoriFilter]=\"otvoriFilter\" (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/magacin/filteri/filteri.component.ts":
/*!*************************************************************!*\
  !*** ./src/app/e-shop/magacin/filteri/filteri.component.ts ***!
  \*************************************************************/
/*! exports provided: FilteriComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FilteriComponent", function() { return FilteriComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _service_roba_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var _service_data_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _model_roba_enum__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../model/roba.enum */ "./src/app/e-shop/model/roba.enum.ts");
/* harmony import */ var _model_filter__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../model/filter */ "./src/app/e-shop/model/filter.ts");
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
    function FilteriComponent(robaService, dataService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.vrstaRobe = _model_roba_enum__WEBPACK_IMPORTED_MODULE_5__["VrstaRobe"].FILTERI;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new _model_filter__WEBPACK_IMPORTED_MODULE_6__["Filter"]();
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
    }
    FilteriComponent.prototype.ngOnInit = function () {
        this.pocetnoPretrazivanje = true;
        this.pronandjiSveFiltere();
    };
    FilteriComponent.prototype.pronandjiSveFiltere = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiFiltere(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
        });
    };
    FilteriComponent.prototype.pronadjiFilterePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiFiltere(this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
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
    FilteriComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilter = !this.otvoriFilter;
    };
    FilteriComponent.prototype.filtriraj = function (filter) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.filter = filter;
        this.pronadjiFilterePoPretrazi(this.searchValue);
    };
    FilteriComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-filteri',
            template: __webpack_require__(/*! ./filteri.component.html */ "./src/app/e-shop/magacin/filteri/filteri.component.html"),
            styles: [__webpack_require__(/*! ./filteri.component.css */ "./src/app/e-shop/magacin/filteri/filteri.component.css")]
        }),
        __metadata("design:paramtypes", [_service_roba_service__WEBPACK_IMPORTED_MODULE_3__["RobaService"],
            _service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"]])
    ], FilteriComponent);
    return FilteriComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.html":
/*!**************************************************************************************************!*\
  !*** ./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.html ***!
  \**************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <main>\r\n        <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n            <button class=\"button-glavni-100 nazad-button\" mat-raised-button (click)=\"idiNazad()\">\r\n                <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n            </button>\r\n        </div>\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=pozadina-glavna-100>\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button matTooltip=\"Filter\" *ngIf=\"!otvoriFilter\" class=pozadina-glavna-100 mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilter\" mat-mini-fab class=\"button-glavni-200\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n        \r\n        <!-- Filter komponenta izdvojena -->\r\n        <app-filter [vrstaRobe]=\"vrstaRobe\" [otvoriFilter]=\"otvoriFilter\" (filterEvent)=\"filtriraj($event)\">\r\n        </app-filter>\r\n\r\n        <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n            <i class=\"material-icons icon-size\">\r\n                error_outline\r\n            </i>\r\n            <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n        </div>\r\n\r\n        <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n            <mat-spinner></mat-spinner>\r\n        </div>\r\n        \r\n        <app-tabela \r\n        [rowsPerPage]=\"rowsPerPage\"\r\n        [pageIndex]=\"pageIndex\"\r\n        [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\"\r\n        [roba]=\"roba\"\r\n        (magacinEvent)=\"paginatorEvent($event)\"\r\n        ></app-tabela>\r\n    </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.scss":
/*!**************************************************************************************************!*\
  !*** ./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.scss ***!
  \**************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".forms-input {\n  margin-top: 0px !important; }\n"

/***/ }),

/***/ "./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.ts":
/*!************************************************************************************************!*\
  !*** ./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.ts ***!
  \************************************************************************************************/
/*! exports provided: KategorijaSpecificnaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KategorijaSpecificnaComponent", function() { return KategorijaSpecificnaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/model/roba.enum */ "./src/app/e-shop/model/roba.enum.ts");
/* harmony import */ var src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/model/filter */ "./src/app/e-shop/model/filter.ts");
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
    function KategorijaSpecificnaComponent(route, dataService, robaServis, router) {
        this.route = route;
        this.dataService = dataService;
        this.robaServis = robaServis;
        this.router = router;
        this.vrstaRobe = src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_6__["VrstaRobe"].OSTALO;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_7__["Filter"]();
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
    }
    KategorijaSpecificnaComponent.prototype.ngOnInit = function () {
        this.pocetnoPretrazivanje = true;
        this.pronandjiRobu();
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
                _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
                _this.dataSource = _this.roba;
                _this.rowsPerPage = res.size;
                _this.pageIndex = res.number;
                _this.tableLength = res.totalElements;
            }, function (error) {
                _this.roba = null;
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
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.route.params.subscribe(function (params) {
            _this.robaServis.pronadjiPoKategoriji(_this.sort, _this.rowsPerPage, _this.pageIndex, searchValue, _this.filter.naStanju, _this.filter.proizvodjacId, params.id)
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
                _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
                _this.dataSource = _this.roba;
                _this.rowsPerPage = res.size;
                _this.pageIndex = res.number;
                _this.tableLength = res.totalElements;
            }, function (error) {
                _this.roba = null;
            });
        });
    };
    KategorijaSpecificnaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiSvuRobuPoPretrazi(this.searchValue);
    };
    KategorijaSpecificnaComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilter = !this.otvoriFilter;
    };
    KategorijaSpecificnaComponent.prototype.filtriraj = function (filter) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.filter = filter;
        this.pronadjiSvuRobuPoPretrazi(this.searchValue);
    };
    KategorijaSpecificnaComponent.prototype.idiNazad = function () {
        this.router.navigate(['/ostalo']);
    };
    KategorijaSpecificnaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-kategorija-specificna',
            template: __webpack_require__(/*! ./kategorija-specificna.component.html */ "./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.html"),
            styles: [__webpack_require__(/*! ./kategorija-specificna.component.scss */ "./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"],
            src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_5__["RobaService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]])
    ], KategorijaSpecificnaComponent);
    return KategorijaSpecificnaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/ostalo/ostalo.component.html":
/*!*************************************************************!*\
  !*** ./src/app/e-shop/magacin/ostalo/ostalo.component.html ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n  <main *ngIf=\"kategorije\">\r\n    <h1>Kategorije</h1>\r\n    <div *ngFor=\"let slovo of pocetnaSlova\">\r\n      <div class=\"d-flex flex-row flex-wrap\">\r\n        <div class=\"slovo\">\r\n          <h2>{{slovo}}</h2>\r\n        </div>\r\n        <div *ngFor=\"let kategorija of vratiKategorijuNaSlovo(slovo)\">\r\n          <a [routerLink]=\"[kategorija  | lowercase]\" mat-button>{{\"kategorija_\" + kategorija | translate}}</a>\r\n        </div>\r\n      </div>\r\n      <hr>\r\n    </div>\r\n  </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/magacin/ostalo/ostalo.component.scss":
/*!*************************************************************!*\
  !*** ./src/app/e-shop/magacin/ostalo/ostalo.component.scss ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  margin-top: 20px;\n  margin-left: 20px;\n  margin-bottom: 50px; }\n\na {\n  color: #345cac; }\n\n.slovo {\n  width: 30px;\n  margin-top: 0px;\n  padding: 0px; }\n"

/***/ }),

/***/ "./src/app/e-shop/magacin/ostalo/ostalo.component.ts":
/*!***********************************************************!*\
  !*** ./src/app/e-shop/magacin/ostalo/ostalo.component.ts ***!
  \***********************************************************/
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
            template: __webpack_require__(/*! ./ostalo.component.html */ "./src/app/e-shop/magacin/ostalo/ostalo.component.html"),
            styles: [__webpack_require__(/*! ./ostalo.component.scss */ "./src/app/e-shop/magacin/ostalo/ostalo.component.scss")]
        }),
        __metadata("design:paramtypes", [_service_roba_service__WEBPACK_IMPORTED_MODULE_3__["RobaService"]])
    ], OstaloComponent);
    return OstaloComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/roba/roba.component.css":
/*!********************************************************!*\
  !*** ./src/app/e-shop/magacin/roba/roba.component.css ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sekcija-pretraga {\r\n    height: 150px;\r\n    background-image: url('/automaterijal/assets/slike/ui/pozadine/roba.png');\r\n    background-repeat: no-repeat;\r\n    background-size: cover;\r\n}"

/***/ }),

/***/ "./src/app/e-shop/magacin/roba/roba.component.html":
/*!*********************************************************!*\
  !*** ./src/app/e-shop/magacin/roba/roba.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"sekcija-pretraga\">\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\"\r\n                    (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=pozadina-glavna-100>\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button matTooltip=\"Filter\" *ngIf=\"!otvoriFilter\" class=\"pozadina-glavna-100\" mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilter\" mat-mini-fab class=\"button-glavni-200\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [otvoriFilter]=\"otvoriFilter\" (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/magacin/roba/roba.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/magacin/roba/roba.component.ts ***!
  \*******************************************************/
/*! exports provided: RobaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RobaComponent", function() { return RobaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_roba_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _service_data_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _model_roba_enum__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../model/roba.enum */ "./src/app/e-shop/model/roba.enum.ts");
/* harmony import */ var _model_filter__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../model/filter */ "./src/app/e-shop/model/filter.ts");
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
    function RobaComponent(robaService, dataService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.vrstaRobe = _model_roba_enum__WEBPACK_IMPORTED_MODULE_5__["VrstaRobe"].SVE;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new _model_filter__WEBPACK_IMPORTED_MODULE_6__["Filter"]();
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
    }
    RobaComponent.prototype.ngOnInit = function () {
        this.pocetnoPretrazivanje = true;
        this.pronadjiSvuRobu();
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
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
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
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiSvuRobu(this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId)
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
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
        });
    };
    RobaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiSvuRobuPoPretrazi(this.searchValue);
    };
    RobaComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilter = !this.otvoriFilter;
    };
    RobaComponent.prototype.filtriraj = function (filter) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.filter = filter;
        this.pronadjiSvuRobuPoPretrazi(this.searchValue);
    };
    RobaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-roba',
            template: __webpack_require__(/*! ./roba.component.html */ "./src/app/e-shop/magacin/roba/roba.component.html"),
            styles: [__webpack_require__(/*! ./roba.component.css */ "./src/app/e-shop/magacin/roba/roba.component.css")]
        }),
        __metadata("design:paramtypes", [_service_roba_service__WEBPACK_IMPORTED_MODULE_1__["RobaService"],
            _service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"]])
    ], RobaComponent);
    return RobaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/shared-components/filter/filter.component.html":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/filter/filter.component.html ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilter\">\n  <div class=\"filter-div-test d-flex flex-column\">\n      <div class=\"d-flex justify-content-center\">\n          <h2>\n              Filter\n          </h2>\n      </div>\n      <div class=\"d-flex flex-column flex-xl-row input-group mb-3\">\n          <div class=\"input-group-prepend\">\n              <label class=\"input-group-text mobilna-duzina button-glavni-50\" for=\"inputGroupSelect01\">\n                  <p class=\"boja-siva-400\">Proizvodjač: </p>\n              </label>\n          </div>\n          <select class=\"custom-select mobilna-duzina\" id=\"inputGroupSelect01\" [(ngModel)]=\"filter.proizvodjac\">\n              <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\n                  {{proizvodjac.naziv}}\n              </option>\n          </select>\n\n          <div class=\"input-group-prepend razmak\">\n              <label class=\"input-group-text mobilna-duzina button-glavni-50\" for=\"inputGroupSelect01\">\n                  Raspoloživost:\n              </label>\n          </div>\n          <select class=\"custom-select mobilna-duzina\" id=\"inputGroupSelect01\" [(ngModel)]=\"filter.raspolozivost\">\n              <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\n          </select>\n      </div>\n      <div class=\"d-flex justify-content-center\">\n          <div>\n              <button mat-stroked-button class=pozadina-glavna-100 (click)='filtriraj()'>\n                  <p class=\"boja-siva-400\">Filtriraj</p>\n              </button>\n              <span class=\"col-2\"></span>\n              <button mat-stroked-button class=button-crveni-50 (click)='resetujFilter()'>\n                  <p class=\"boja-siva-400\">Poništi</p>\n              </button>\n          </div>\n      </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/e-shop/magacin/shared-components/filter/filter.component.scss":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/filter/filter.component.scss ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ":host ::ng-deep .custom-select {\n  padding: 0rem 0rem 0rem 0.5rem !important; }\n"

/***/ }),

/***/ "./src/app/e-shop/magacin/shared-components/filter/filter.component.ts":
/*!*****************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/filter/filter.component.ts ***!
  \*****************************************************************************/
/*! exports provided: FilterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FilterComponent", function() { return FilterComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/e-shop/service/proizvodjac.service */ "./src/app/e-shop/service/proizvodjac.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/e-shop/model/roba.enum */ "./src/app/e-shop/model/roba.enum.ts");
/* harmony import */ var src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/model/filter */ "./src/app/e-shop/model/filter.ts");
/* harmony import */ var src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var FilterComponent = /** @class */ (function () {
    function FilterComponent(route, proizvodjacService, utilsService) {
        this.route = route;
        this.proizvodjacService = proizvodjacService;
        this.utilsService = utilsService;
        this.filterEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.filter = new src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_4__["Filter"]();
        this.raspolozivost = ['Svi artikli', 'Ima na stanju'];
        this.alive = true;
    }
    FilterComponent.prototype.ngOnInit = function () {
        var _this = this;
        if (this.industrijkoUljeEvent) {
            this.industrijkoUljeEvent.subscribe(function (vrstaUlja) {
                _this.vrstaUlja = vrstaUlja;
                _this.filter.raspolozivost = _this.raspolozivost[1];
                _this.pronadjiProizvodjace();
            });
        }
        this.filter.raspolozivost = this.raspolozivost[1];
        this.pronadjiProizvodjace();
    };
    FilterComponent.prototype.pronadjiProizvodjace = function () {
        var _this = this;
        if (this.vrstaRobe === src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_3__["VrstaRobe"].AKUMULATORI) {
            this.proizvodjacService.pronadjiSveProizvodjaceAkumulatora()
                .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
                .subscribe(function (res) {
                _this.proizvodjaci = res;
                _this.filter.proizvodjac = _this.proizvodjaci[0].naziv;
            }, function (error) {
                _this.proizvodjaci = null;
            });
        }
        else if (this.vrstaRobe === src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_3__["VrstaRobe"].FILTERI) {
            this.proizvodjacService.pronadjiSveProizvodjaceFiltera()
                .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
                .subscribe(function (res) {
                _this.proizvodjaci = res;
                _this.filter.proizvodjac = _this.proizvodjaci[0].naziv;
            }, function (error) {
                _this.proizvodjaci = null;
            });
        }
        else if (this.vrstaRobe === src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_3__["VrstaRobe"].SVE) {
            this.proizvodjacService.pronadjiSveProizvodjace()
                .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
                .subscribe(function (res) {
                _this.proizvodjaci = res;
                _this.filter.proizvodjac = _this.proizvodjaci[0].naziv;
            }, function (error) {
                _this.proizvodjaci = null;
            });
        }
        else if (this.vrstaRobe === src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_3__["VrstaRobe"].ULJA) {
            this.proizvodjacService.pronadjiSveProizvodjaceUljaPoVrsti(this.vrstaUlja)
                .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
                .subscribe(function (res) {
                _this.proizvodjaci = res;
                _this.filter.proizvodjac = _this.proizvodjaci[0].naziv;
            }, function (error) {
                _this.proizvodjaci = null;
            });
        }
        else if (this.vrstaRobe === src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_3__["VrstaRobe"].OSTALO) {
            this.route.params.subscribe(function (params) {
                _this.proizvodjacService.pronadjiSveProizvodjaceKategorije(params.id)
                    .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
                    .subscribe(function (res) {
                    _this.proizvodjaci = res;
                    _this.filter.proizvodjac = _this.proizvodjaci[0].naziv;
                }, function (error) {
                    _this.proizvodjaci = null;
                });
            });
        }
    };
    FilterComponent.prototype.filtriraj = function () {
        this.filter.naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.filter.raspolozivost);
        this.filter.proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.filter.proizvodjac, this.proizvodjaci);
        this.filterEvent.emit(this.filter);
    };
    FilterComponent.prototype.resetujFilter = function () {
        this.filter.raspolozivost = this.raspolozivost[1];
        this.filter.proizvodjac = this.proizvodjaci[0].naziv;
        this.filter.naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.filter.raspolozivost);
        this.filter.proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.filter.proizvodjac, this.proizvodjaci);
        this.filterEvent.emit(this.filter);
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], FilterComponent.prototype, "otvoriFilter", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], FilterComponent.prototype, "vrstaRobe", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], FilterComponent.prototype, "vrstaUlja", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", rxjs__WEBPACK_IMPORTED_MODULE_6__["Observable"])
    ], FilterComponent.prototype, "industrijkoUljeEvent", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
        __metadata("design:type", Object)
    ], FilterComponent.prototype, "filterEvent", void 0);
    FilterComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-filter',
            template: __webpack_require__(/*! ./filter.component.html */ "./src/app/e-shop/magacin/shared-components/filter/filter.component.html"),
            styles: [__webpack_require__(/*! ./filter.component.scss */ "./src/app/e-shop/magacin/shared-components/filter/filter.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_7__["ActivatedRoute"],
            src_app_e_shop_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_1__["ProizvodjacService"],
            src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"]])
    ], FilterComponent);
    return FilterComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/shared-components/tabela/tabela.component.html":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/tabela/tabela.component.html ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n  <p class=\"pdv\"><i>Sve cene su prikazane sa pdv-om.</i></p>\r\n  <table mat-table [dataSource]=\"dataSource\">\r\n    <!-- Kataloski broj Column -->\r\n    <ng-container matColumnDef=\"katbr\">\r\n      <th mat-header-cell *matHeaderCellDef> Kataloški broj </th>\r\n      <td mat-cell *matCellDef=\"let roba\">\r\n        <p class=\"mat-body-2\">\r\n          {{roba.katbr}}\r\n        </p>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Kataloski broj proizvodjaca Column -->\r\n    <ng-container matColumnDef=\"katbrpro\">\r\n      <th mat-header-cell *matHeaderCellDef> Kataloški broj proizvodjača </th>\r\n      <td mat-cell *matCellDef=\"let roba\">\r\n        <p>\r\n          {{roba.katbrpro}}\r\n        </p>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Naziv Column -->\r\n    <ng-container matColumnDef=\"naziv\">\r\n      <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n      <td mat-cell *matCellDef=\"let roba\">\r\n        <p>\r\n          {{roba.naziv}}\r\n        </p>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Proizvodjač Column -->\r\n    <ng-container matColumnDef=\"proizvodjac\">\r\n      <th mat-header-cell *matHeaderCellDef> Proizvodjač </th>\r\n      <td mat-cell *matCellDef=\"let roba\">\r\n        <p class=\"mat-body-2\">\r\n          {{roba.proizvodjac.naziv}}\r\n        </p>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Cena Column -->\r\n    <ng-container matColumnDef=\"cena\">\r\n      <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n      <td mat-cell *matCellDef=\"let roba\">\r\n        <p class=\"mat-body-2 text-right iznos-margin\">\r\n          {{roba.cena | currency:\" \"}} RSD\r\n        </p>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Stanje Column -->\r\n    <ng-container matColumnDef=\"stanje\">\r\n      <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n      <td mat-cell *matCellDef=\"let roba\">\r\n        <div *ngIf=\"roba.stanje > 0\" class=\"text-center\">\r\n          <mat-icon class=\"boja-zelena-50\">check_circle_outline</mat-icon>\r\n        </div>\r\n        <div *ngIf=\"roba.stanje == 0\" class=\"text-center\">\r\n          <mat-icon class=\"boja-crvena-50\">remove_circle_outline</mat-icon>\r\n        </div>\r\n      </td>\r\n    </ng-container>\r\n\r\n\r\n    <!-- Kolicina Column -->\r\n    <ng-container matColumnDef=\"kolicina\">\r\n      <th mat-header-cell *matHeaderCellDef>Količina </th>\r\n      <td mat-cell *matCellDef=\"let roba\">\r\n        <div *ngIf=\"roba.stanje > 0\">\r\n          <input type=\"number\" min=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\"\r\n            [(ngModel)]=\"roba.kolicina\" />\r\n        </div>\r\n    </ng-container>\r\n\r\n    <!-- Kropa dugme Column -->\r\n    <ng-container matColumnDef=\"korpa\">\r\n      <th mat-header-cell *matHeaderCellDef> </th>\r\n      <td mat-cell *matCellDef=\"let roba\">\r\n        <div *ngIf=\"roba.stanje > 0\">\r\n          <button mat-raised-button class=\"button-glavni-100\" (click)='dodajUKorpu(roba)'>Dodaj u\r\n            korpu</button>\r\n        </div>\r\n    </ng-container>\r\n\r\n    <!-- Da li ima na stanju ikona -->\r\n    <ng-container matColumnDef=\"u-korpi\">\r\n      <th mat-header-cell *matHeaderCellDef> </th>\r\n      <td mat-cell *matCellDef=\"let roba\">\r\n        <div *ngIf=\"uKorpi(roba.katbr)\">\r\n          <mat-icon class=\"boja-crvena-50\">add_shopping_cart</mat-icon>\r\n        </div>\r\n    </ng-container>\r\n\r\n    <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n    <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n  </table>\r\n  <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n    [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n  </mat-paginator>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/magacin/shared-components/tabela/tabela.component.scss":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/tabela/tabela.component.scss ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/e-shop/magacin/shared-components/tabela/tabela.component.ts":
/*!*****************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/tabela/tabela.component.ts ***!
  \*****************************************************************************/
/*! exports provided: TabelaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TabelaComponent", function() { return TabelaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/e-shop/utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var src_app_shared_service_notifikacija_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/service/notifikacija.service */ "./src/app/shared/service/notifikacija.service.ts");
/* harmony import */ var src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/shared/model/konstante */ "./src/app/shared/model/konstante.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var TabelaComponent = /** @class */ (function () {
    function TabelaComponent(utilsService, loginServis, notifikacijaServis, dataService, router) {
        this.utilsService = utilsService;
        this.loginServis = loginServis;
        this.notifikacijaServis = notifikacijaServis;
        this.dataService = dataService;
        this.router = router;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.magacinEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.partnerLogovan = false;
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
    }
    TabelaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.loginServis.daLiJePartnerUlogovan.subscribe(function (bool) { return _this.partnerLogovan = bool; });
    };
    TabelaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.magacinEvent.emit(pageEvent);
    };
    TabelaComponent.prototype.getDisplayedColumns = function () {
        var _this = this;
        var dataColumns = this.columnDefinitions
            .filter(function (cd) { return _this.partnerLogovan || cd.ifNotAuth; })
            .map(function (cd) { return cd.def; });
        return dataColumns;
    };
    TabelaComponent.prototype.dodajUKorpu = function (roba) {
        var _this = this;
        this.loginServis.vratiUlogovanogKorisnika(false).subscribe(function (partner) {
            if (partner) {
                var snackBarPoruka = _this.utilsService.dodajUKorpu(roba);
                _this.notifikacijaServis.notify(snackBarPoruka, src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_4__["MatSnackBarKlase"].Zelena);
                _this.utilsService.izbrisiRobuSaStanja(_this.roba, roba);
            }
            else {
                _this.router.navigate(['/login']);
                _this.loginServis.izbaciPartnerIzSesije();
            }
        });
    };
    TabelaComponent.prototype.uKorpi = function (katBr) {
        return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Array)
    ], TabelaComponent.prototype, "dataSource", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Array)
    ], TabelaComponent.prototype, "roba", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], TabelaComponent.prototype, "rowsPerPage", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], TabelaComponent.prototype, "pageIndex", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], TabelaComponent.prototype, "tableLength", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
        __metadata("design:type", Object)
    ], TabelaComponent.prototype, "magacinEvent", void 0);
    TabelaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-tabela',
            template: __webpack_require__(/*! ./tabela.component.html */ "./src/app/e-shop/magacin/shared-components/tabela/tabela.component.html"),
            styles: [__webpack_require__(/*! ./tabela.component.scss */ "./src/app/e-shop/magacin/shared-components/tabela/tabela.component.scss")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_2__["AppUtilsService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_1__["LoginService"],
            src_app_shared_service_notifikacija_service__WEBPACK_IMPORTED_MODULE_3__["NotifikacijaService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_5__["DataService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_6__["Router"]])
    ], TabelaComponent);
    return TabelaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.css":
/*!*********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.css ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 130px;\r\n    background-image: url('/automaterijal/assets/slike/ui/pozadine/ulje.png');\r\n    background-repeat: no-repeat;\r\n    background-size: cover;\r\n}"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.html":
/*!**********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.html ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n\r\n    <div class=\"sekcija-pretraga\">\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"ulja-forms forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\"\r\n                    (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=pozadina-glavna-100>\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button matTooltip=\"Filter\" *ngIf=\"!otvoriFilter\" class=pozadina-glavna-100 mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilter\" mat-mini-fab class=\"button-glavni-200\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [vrstaUlja]=\"vrstaUlja\" [otvoriFilter]=\"otvoriFilter\"\r\n        (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.ts":
/*!********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.ts ***!
  \********************************************************************/
/*! exports provided: AntifrizComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AntifrizComponent", function() { return AntifrizComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/model/roba.enum */ "./src/app/e-shop/model/roba.enum.ts");
/* harmony import */ var src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/model/filter */ "./src/app/e-shop/model/filter.ts");
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
    function AntifrizComponent(robaService, dataService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.vrstaRobe = src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__["VrstaRobe"].ULJA;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__["Filter"]();
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
        this.vrstaUlja = 'antifriz';
    }
    AntifrizComponent.prototype.ngOnInit = function () {
        this.pocetnoPretrazivanje = true;
        this.pronandjiSavAntifriz();
    };
    AntifrizComponent.prototype.pronandjiSavAntifriz = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
        });
    };
    AntifrizComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
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
    AntifrizComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilter = !this.otvoriFilter;
    };
    AntifrizComponent.prototype.filtriraj = function (filter) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.filter = filter;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    AntifrizComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-antifriz',
            template: __webpack_require__(/*! ./antifriz.component.html */ "./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.html"),
            styles: [__webpack_require__(/*! ./antifriz.component.css */ "./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_3__["RobaService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"]])
    ], AntifrizComponent);
    return AntifrizComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.css":
/*!*****************************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.css ***!
  \*****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sirina-odabira-vrste {\r\n    width: 450px;\r\n    float: right;\r\n}\r\n.forms-input-industrija {\r\n    display: flex;\r\n    border-radius: 45px;\r\n    padding: 1px;\r\n    margin-top: 5px;\r\n    background: white;\r\n    border:2px solid grey;\r\n    width: 40%;\r\n    font-weight: bold;\r\n    text-align: center;\r\n}\r\n.col-lg {\r\n  padding: 0px !important;\r\n}\r\n.sekcija-pretraga {\r\n    height: 130px;\r\n    background-image: url('/automaterijal/assets/slike/ui/pozadine/ulje.png');\r\n    background-repeat: no-repeat;\r\n    background-size: cover;\r\n}\r\n@media only screen and (max-device-width :1025px) { \r\n\r\n    .mobilna-visina {\r\n      margin-top: 10px;\r\n    }\r\n\r\n    .forms-input-industrija {\r\n      display: flex;\r\n      border-radius: 45px;\r\n      padding: 1px;\r\n      margin-top: 30px;\r\n      background: white;\r\n      border:2px solid grey;\r\n      width: 80%;\r\n      font-weight: bold;\r\n      text-align: center;\r\n    }\r\n  }\r\n@media only screen and (max-device-width : 640px) { \r\n\r\n    .mobilna-visina {\r\n      margin-top: 10px;\r\n    }\r\n    \r\n    .sirina-odabira-vrste {\r\n        width: 100%;\r\n    }\r\n    .forms-input-industrija {\r\n      border-radius: 45px;\r\n      background: white;\r\n      border:2px solid grey;\r\n      width:100%;\r\n      margin-top: 5px;\r\n      font-weight: bold;\r\n      text-align: center;\r\n      display: flex;\r\n      }  \r\n}"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.html":
/*!******************************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.html ***!
  \******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"margin-bottom--10 sekcija-pretraga\">\r\n        <div class=\"d-flex col-lg p-2 justify-content-center sirina-odabira-vrste\">\r\n            <div class=\"input-group-prepend\">\r\n                <label class=\"pozadina-glavna-100 boja-siva-400 input-group-text \" for=\"inputGroupSelect01\">Izaberite\r\n                    vrstu\r\n                    maziva:</label>\r\n            </div>\r\n            <select class=\"custom-select mobilna-visina\" (change)=\"onChange()\" id=\"inputGroupSelect01\"\r\n                [(ngModel)]=\"izabranaVrsta\">\r\n                <option *ngFor=\"let izabranaVrsta of vrste\" [value]=\"izabranaVrsta\">{{izabranaVrsta}}</option>\r\n            </select>\r\n        </div>\r\n        <div class=\"d-flex align-items-center col-lg justify-content-center\">\r\n            <div class=\"forms-input-industrija\">\r\n                <input class=\"flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\"\r\n                    (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=pozadina-glavna-100>\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button matTooltip=\"Filter\" *ngIf=\"!otvoriFilter\" class=pozadina-glavna-100 mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilter\" mat-mini-fab class=\"button-glavni-200\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [industrijkoUljeEvent]=\"vrstaIndustijskihUlja.asObservable()\" [vrstaRobe]=\"vrstaRobe\"\r\n        [vrstaUlja]=\"vrstaUlja\" [otvoriFilter]=\"otvoriFilter\" (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.ts":
/*!****************************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.ts ***!
  \****************************************************************************/
/*! exports provided: IndustrijskaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "IndustrijskaComponent", function() { return IndustrijskaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/model/roba.enum */ "./src/app/e-shop/model/roba.enum.ts");
/* harmony import */ var src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/model/filter */ "./src/app/e-shop/model/filter.ts");
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
    function IndustrijskaComponent(robaService, dataService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.vrstaRobe = src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__["VrstaRobe"].ULJA;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__["Filter"]();
        this.vrstaIndustijskihUlja = new rxjs__WEBPACK_IMPORTED_MODULE_2__["Subject"]();
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
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
        this.pocetnoPretrazivanje = true;
        this.pronandjiUlja();
    };
    IndustrijskaComponent.prototype.pronandjiUlja = function () {
        var _this = this;
        this.dataSource = null;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
        });
    };
    IndustrijskaComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.dataSource = null;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
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
    IndustrijskaComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilter = !this.otvoriFilter;
    };
    IndustrijskaComponent.prototype.filtriraj = function (filter) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.filter = filter;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    IndustrijskaComponent.prototype.onChange = function () {
        var _this = this;
        this.vrsteUlja.forEach(function (vrsta) {
            if (vrsta.naziv === _this.izabranaVrsta) {
                _this.vrstaUlja = vrsta.url;
                _this.vrstaIndustijskihUlja.next(_this.vrstaUlja);
            }
        });
        this.pronandjiUlja();
    };
    IndustrijskaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-industrijska',
            template: __webpack_require__(/*! ./industrijska.component.html */ "./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.html"),
            styles: [__webpack_require__(/*! ./industrijska.component.css */ "./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_3__["RobaService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"]])
    ], IndustrijskaComponent);
    return IndustrijskaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/kociona/kociona.component.css":
/*!*******************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/kociona/kociona.component.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 130px;\r\n    background-image: url('/automaterijal/assets/slike/ui/pozadine/ulje.png');\r\n    background-repeat: no-repeat;\r\n    background-size: cover;\r\n}"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/kociona/kociona.component.html":
/*!********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/kociona/kociona.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"sekcija-pretraga\">\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"ulja-forms forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\"\r\n                    (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=pozadina-glavna-100>\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button matTooltip=\"Filter\" *ngIf=\"!otvoriFilter\" class=pozadina-glavna-100 mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilter\" mat-mini-fab class=\"button-glavni-200\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [vrstaUlja]=\"vrstaUlja\" [otvoriFilter]=\"otvoriFilter\"\r\n        (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/kociona/kociona.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/kociona/kociona.component.ts ***!
  \******************************************************************/
/*! exports provided: KocionaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KocionaComponent", function() { return KocionaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/model/roba.enum */ "./src/app/e-shop/model/roba.enum.ts");
/* harmony import */ var src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/model/filter */ "./src/app/e-shop/model/filter.ts");
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
    function KocionaComponent(robaService, dataService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.vrstaRobe = src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__["VrstaRobe"].ULJA;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__["Filter"]();
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
        this.vrstaUlja = 'kociona';
    }
    KocionaComponent.prototype.ngOnInit = function () {
        this.pocetnoPretrazivanje = true;
        this.pronandjiSvaKocionaUlja();
    };
    KocionaComponent.prototype.pronandjiSvaKocionaUlja = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
        });
    };
    KocionaComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.dataSource = null;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
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
    KocionaComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilter = !this.otvoriFilter;
    };
    KocionaComponent.prototype.filtriraj = function (filter) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.filter = filter;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    KocionaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-kociona',
            template: __webpack_require__(/*! ./kociona.component.html */ "./src/app/e-shop/magacin/ulja/kociona/kociona.component.html"),
            styles: [__webpack_require__(/*! ./kociona.component.css */ "./src/app/e-shop/magacin/ulja/kociona/kociona.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_3__["RobaService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"]])
    ], KocionaComponent);
    return KocionaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.css":
/*!*********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.css ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 130px;\r\n    background-image: url('/automaterijal/assets/slike/ui/pozadine/ulje.png');\r\n    background-repeat: no-repeat;\r\n    background-size: cover;\r\n}"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.html":
/*!**********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.html ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"sekcija-pretraga\">\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"ulja-forms forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\"\r\n                    (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=pozadina-glavna-100>\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button matTooltip=\"Filter\" *ngIf=\"!otvoriFilter\" class=pozadina-glavna-100 mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilter\" mat-mini-fab class=\"button-glavni-200\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [vrstaUlja]=\"vrstaUlja\" [otvoriFilter]=\"otvoriFilter\"\r\n        (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.ts":
/*!********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.ts ***!
  \********************************************************************/
/*! exports provided: MenjackoComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MenjackoComponent", function() { return MenjackoComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/model/roba.enum */ "./src/app/e-shop/model/roba.enum.ts");
/* harmony import */ var src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/model/filter */ "./src/app/e-shop/model/filter.ts");
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
    function MenjackoComponent(robaService, dataService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.vrstaRobe = src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__["VrstaRobe"].ULJA;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.searchValue = '';
        this.lastSearchValue = '';
        this.filter = new src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__["Filter"]();
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
        this.vrstaUlja = 'menjacka';
    }
    MenjackoComponent.prototype.ngOnInit = function () {
        this.pocetnoPretrazivanje = true;
        this.pronandjiSvaMenjackaUlja();
    };
    MenjackoComponent.prototype.pronandjiSvaMenjackaUlja = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
        });
    };
    MenjackoComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
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
    MenjackoComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilter = !this.otvoriFilter;
    };
    MenjackoComponent.prototype.filtriraj = function (filter) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.filter = filter;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    MenjackoComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-menjacko',
            template: __webpack_require__(/*! ./menjacko.component.html */ "./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.html"),
            styles: [__webpack_require__(/*! ./menjacko.component.css */ "./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_3__["RobaService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"]])
    ], MenjackoComponent);
    return MenjackoComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/motorna/motorna.component.css":
/*!*******************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/motorna/motorna.component.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 130px;\r\n    background-image: url('/automaterijal/assets/slike/ui/pozadine/ulje.png');\r\n    background-repeat: no-repeat;\r\n    background-size: cover;\r\n}"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/motorna/motorna.component.html":
/*!********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/motorna/motorna.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"sekcija-pretraga\">\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"ulja-forms forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\"\r\n                    (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=pozadina-glavna-100>\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button matTooltip=\"Filter\" *ngIf=\"!otvoriFilter\" class=pozadina-glavna-100 mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilter\" mat-mini-fab class=\"button-glavni-200\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\">\r\n                <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n            </label>\r\n        </div>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [vrstaUlja]=\"vrstaUlja\" [otvoriFilter]=\"otvoriFilter\"\r\n        (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/motorna/motorna.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/motorna/motorna.component.ts ***!
  \******************************************************************/
/*! exports provided: MotornaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MotornaComponent", function() { return MotornaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/e-shop/service/roba.service */ "./src/app/e-shop/service/roba.service.ts");
/* harmony import */ var src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/model/roba.enum */ "./src/app/e-shop/model/roba.enum.ts");
/* harmony import */ var src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/model/filter */ "./src/app/e-shop/model/filter.ts");
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
    function MotornaComponent(robaService, dataService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.vrstaRobe = src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__["VrstaRobe"].ULJA;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__["Filter"]();
        this.searchValue = '';
        this.lastSearchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
        this.vrstaUlja = 'motorna';
    }
    MotornaComponent.prototype.ngOnInit = function () {
        this.pocetnoPretrazivanje = true;
        this.pronandjiSvoMotornoUlje();
    };
    MotornaComponent.prototype.pronandjiSvoMotornoUlje = function () {
        var _this = this;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
        });
    };
    MotornaComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["catchError"])(function (error) {
            if (error.status === 404) {
                _this.pronadjenaRoba = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_2__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.pronadjenaRoba = true;
            _this.roba = res.content;
            _this.roba = _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
            _this.dataSource = _this.roba;
            _this.rowsPerPage = res.size;
            _this.pageIndex = res.number;
            _this.tableLength = res.totalElements;
        }, function (error) {
            _this.roba = null;
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
    MotornaComponent.prototype.toogleFilterDiv = function () {
        this.otvoriFilter = !this.otvoriFilter;
    };
    MotornaComponent.prototype.filtriraj = function (filter) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.filter = filter;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    MotornaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-motorna',
            template: __webpack_require__(/*! ./motorna.component.html */ "./src/app/e-shop/magacin/ulja/motorna/motorna.component.html"),
            styles: [__webpack_require__(/*! ./motorna.component.css */ "./src/app/e-shop/magacin/ulja/motorna/motorna.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_e_shop_service_roba_service__WEBPACK_IMPORTED_MODULE_3__["RobaService"],
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"]])
    ], MotornaComponent);
    return MotornaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/ulja.component.css":
/*!********************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/ulja.component.css ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".industrijski-stil {\r\n    width: 100%;\r\n    height: 100%;\r\n}\r\n.spusti {\r\n    margin-top: 0px;\r\n}\r\n.motorna-ulja {\r\n    background-image: url('/automaterijal/assets/slike/ui/tabovi/mu.png');\r\n    background-repeat: no-repeat;\r\n    background-size: cover;\r\n}\r\n@media only screen and (max-device-width :1025px) { \r\n    .spusti {\r\n        margin-top: 30px;\r\n    }\r\n}\r\n@media only screen and (max-device-width : 1000px) { \r\n    .spusti {\r\n        margin-top: 10px;\r\n    }\r\n}"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/ulja.component.html":
/*!*********************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/ulja.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main class=\"spusti\">\r\n    <mat-tab-group mat-stretch-tabs>\r\n        <mat-tab label=\"Motorna ulja\">\r\n            <ng-template mat-tab-label>\r\n                <img width=\"200\" [src]=\"slike.motorna_ulja\">\r\n            </ng-template>\r\n            <app-motorna></app-motorna>\r\n        </mat-tab>\r\n        <mat-tab label=\"Menjačka ulja\">\r\n            <ng-template mat-tab-label>\r\n                <img width=\"200\" [src]=\"slike.menjacka_ulja\">\r\n            </ng-template>\r\n            <app-menjacko></app-menjacko>\r\n        </mat-tab>\r\n        <mat-tab label=\"Kočiona ulja\">\r\n            <ng-template mat-tab-label>\r\n                <img width=\"200\" [src]=\"slike.kociona_ulja\">\r\n            </ng-template>\r\n            <app-kociona></app-kociona>\r\n        </mat-tab>\r\n        <mat-tab label=\"Antifiriz\">\r\n            <ng-template mat-tab-label>\r\n                <img width=\"200\" [src]=\"slike.antifriz\">\r\n            </ng-template>\r\n            <app-antifriz></app-antifriz>\r\n        </mat-tab>\r\n        <mat-tab label=\"Industrijska ulja\">\r\n            <ng-template mat-tab-label>\r\n                <img width=\"200\" [src]=\"slike.industrijska_ulja\">\r\n            </ng-template>\r\n            <app-industrijska></app-industrijska>\r\n        </mat-tab>\r\n    </mat-tab-group>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/ulja.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/ulja.component.ts ***!
  \*******************************************************/
/*! exports provided: UljaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UljaComponent", function() { return UljaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var UljaComponent = /** @class */ (function () {
    function UljaComponent() {
        this.selectedTab = 0;
        this.baseUrl = src_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].baseUrl;
        this.slike = {
            motorna_ulja: this.baseUrl + '/assets/slike/ui/tabovi/mu.png',
            menjacka_ulja: this.baseUrl + '/assets/slike/ui/tabovi/MEU.png',
            kociona_ulja: this.baseUrl + '/assets/slike/ui/tabovi/KU.png',
            antifriz: this.baseUrl + '/assets/slike/ui/tabovi/ANTI.png',
            industrijska_ulja: this.baseUrl + '/assets/slike/ui/tabovi/INDUSTR.png',
        };
    }
    UljaComponent.prototype.changeTab = function (tabIndex) {
        this.selectedTab = tabIndex;
    };
    UljaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-ulja',
            template: __webpack_require__(/*! ./ulja.component.html */ "./src/app/e-shop/magacin/ulja/ulja.component.html"),
            styles: [__webpack_require__(/*! ./ulja.component.css */ "./src/app/e-shop/magacin/ulja/ulja.component.css")]
        })
    ], UljaComponent);
    return UljaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/model/dto.ts":
/*!*************************************!*\
  !*** ./src/app/e-shop/model/dto.ts ***!
  \*************************************/
/*! exports provided: ValueHelp, Roba, RobaPage, Partner, Fakutra, FakturaPage, FakturaDetalji, Proizvodjac, Registracija, ResetSifre, PromenaSifre */
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
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PromenaSifre", function() { return PromenaSifre; });
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

var PromenaSifre = /** @class */ (function () {
    function PromenaSifre() {
    }
    return PromenaSifre;
}());



/***/ }),

/***/ "./src/app/e-shop/model/filter.ts":
/*!****************************************!*\
  !*** ./src/app/e-shop/model/filter.ts ***!
  \****************************************/
/*! exports provided: Filter */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Filter", function() { return Filter; });
var Filter = /** @class */ (function () {
    function Filter() {
    }
    Filter.prototype.Filter = function () {
        this.proizvodjac = '';
        this.raspolozivost = 'Svi artikli';
    };
    return Filter;
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
    kategorija_BRAVA: 'Brava vrata i elek. uložak brave',
    kategorija_BREGASTA: 'Bregasta osovina',
    kategorija_BRISAC: 'Brisači - metlice',
    kategorija_CILINDAR: 'Cilindri-kočioni',
    kategorija_DIHTUNG: 'Dihtunzi',
    kategorija_DISK_PLOCICE: 'Disk pločice',
    kategorija_DISKOVI: 'Diskovi',
    kategorija_DVOTAKTOL: 'Dvotaktol ulje',
    kategorija_GREJAC: 'Grejači',
    kategorija_GUMICE: 'Gumice',
    kategorija_HEMIJA: 'Hemija za automobile',
    kategorija_HIDROPODIZAC: 'Hidropodizači ventila',
    kategorija_HLADNJAK: 'Hladnjak',
    kategorija_ZGLOB: 'Zglob homokinetički',
    kategorija_INTERKULER: 'Interkuler',
    kategorija_KABLOVI: 'Kablovi za svećice',
    kategorija_KARIKE: 'Karike',
    kategorija_KARTER: 'Karter',
    kategorija_KLACKALICA: 'Klackalica',
    kategorija_KVACILO: 'Kvačilo - Zamajci',
    kategorija_KLIP: 'Klip',
    kategorija_KOZMETIKA: 'Kozmetika',
    kategorija_KUGLA: 'Kugla',
    kategorija_LANAC: 'Lanac - klizači, setovi',
    kategorija_LETVA: 'Letva volana - spone',
    kategorija_LEZAJEVI: 'Ležajevi radilice',
    kategorija_MANZENTA: 'Manžetne',
    kategorija_PAKNOVI: 'Paknovi',
    kategorija_PREKIDAC: 'Prekidači',
    kategorija_PROTOKOMER: 'Protokomer',
    kategorija_PUMPA: 'Pumpa za vodu',
    kategorija_RAME: 'Rame',
    kategorija_RAZVODNIK: 'Razvodnik paljenja',
    kategorija_REMENICA: 'Remenice',
    kategorija_SEMERING: 'Semering',
    kategorija_SVECICA: 'Svećice i kablovi',
    kategorija_SIJALICA: 'Sijalice',
    kategorija_SILEN: 'Silen blokovi',
    kategorija_STABILIZATOR: 'Stabilizator',
    kategorija_TERMODAVAC: 'Termodavač',
    kategorija_TERMOSTAT: 'Termostat',
    kategorija_VENTIL: 'Ventili',
    kategorija_VENTILATOR: 'Ventilator',
    kategorija_ZUPCANIK: 'Zupčanici',
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
/*! exports provided: Korpa, RobaKorpa, RobaPromena */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Korpa", function() { return Korpa; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RobaKorpa", function() { return RobaKorpa; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RobaPromena", function() { return RobaPromena; });
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

var RobaPromena = /** @class */ (function () {
    function RobaPromena() {
        this.katbr = null;
        this.opis = null;
        this.rapolozivaKolicina = null;
        this.trazenaKolicina = null;
    }
    return RobaPromena;
}());



/***/ }),

/***/ "./src/app/e-shop/model/roba.enum.ts":
/*!*******************************************!*\
  !*** ./src/app/e-shop/model/roba.enum.ts ***!
  \*******************************************/
/*! exports provided: VrstaRobe */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "VrstaRobe", function() { return VrstaRobe; });
var VrstaRobe;
(function (VrstaRobe) {
    VrstaRobe[VrstaRobe["SVE"] = 0] = "SVE";
    VrstaRobe[VrstaRobe["FILTERI"] = 1] = "FILTERI";
    VrstaRobe[VrstaRobe["AKUMULATORI"] = 2] = "AKUMULATORI";
    VrstaRobe[VrstaRobe["ULJA"] = 3] = "ULJA";
    VrstaRobe[VrstaRobe["OSTALO"] = 4] = "OSTALO";
})(VrstaRobe || (VrstaRobe = {}));


/***/ }),

/***/ "./src/app/e-shop/partner/partner.component.html":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/partner/partner.component.html ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n  <main *ngIf=\"partner\" class=\"licni-podaci\">\r\n    <div class=\"d-flex flex-column  flex-xl-row\">\r\n      <div class=\"strana\">\r\n        <div class=\"header2\">\r\n          <h1>Licni podaci</h1>\r\n        </div>\r\n        <ul>\r\n          <li>\r\n            <span class=\"leva-strana\">\r\n              Naziv:\r\n            </span> <span class=\"desna-strana\"> {{partner.naziv | titlecase}} </span>\r\n          </li>\r\n          <li><span class=\"leva-strana\">Adresa:</span> \r\n            <span *ngIf =\"partner.adresa\">{{partner.adresa | titlecase}}</span>\r\n            <span *ngIf =\"!partner.adresa\" class=\"boja-siva-200\">Ne postoji podatak</span>\r\n          </li>\r\n          <li>\r\n            <span class=\"leva-strana\">Email:</span> \r\n            <span *ngIf =\"partner.email\">{{partner.email | lowercase}}</span>\r\n            <span *ngIf =\"!partner.email\" class=\"boja-siva-200\">Ne postoji podatak</span>\r\n          </li>\r\n          <li><span class=\"leva-strana\">Stanje:</span> \r\n            <span *ngIf =\"partner.stanje\" [ngClass]=\"{'dugovanje': daLiDuguje}\"><b>{{partner.stanje | currency:\" \"}} RSD</b></span>\r\n            <span *ngIf =\"!partner.stanje\" class=\"boja-siva-200\">Ne postoji podatak</span>\r\n          </li>\r\n        </ul>\r\n      </div>\r\n      <div class=\"strana2\">\r\n        <div class=\"header2\">\r\n          <h1>Akcije</h1>\r\n        </div>\r\n        <mat-accordion>\r\n          <mat-expansion-panel class=\"exp-panel\">\r\n            <mat-expansion-panel-header>\r\n              <mat-panel-title>\r\n                <p class=\"panel\">Promenite adresu</p>\r\n              </mat-panel-title>\r\n            </mat-expansion-panel-header>\r\n            <form role=\"form\" [formGroup]=\"adresaForm\">\r\n              <div>\r\n                <mat-form-field>\r\n                  <input type=\"text\" #ulica formControlName=\"ulica\" [ngClass]=\"{ 'is-invalid': adresaSubmited && a.ulica.errors }\"\r\n                    matInput placeholder=\"Ulica i broj\">\r\n                </mat-form-field>\r\n              </div>\r\n              <div *ngIf=\"adresaSubmited && a.ulica.errors\">\r\n                <div *ngIf=\"a.ulica.errors.required\">\r\n                    <p class=\"upozorenje\">Naziv ulice je obavezan</p>\r\n                </div>\r\n                <div *ngIf=\"a.ulica.errors.minlength\">\r\n                    <p class=\"upozorenje\">Naziv ulice mora imati minimalno 3 karaktera</p>\r\n                </div>\r\n              </div>\r\n              <div>\r\n                <mat-form-field>\r\n                  <input type=\"text\" #grad formControlName=\"grad\" matInput [ngClass]=\"{ 'is-invalid': adresaSubmited && a.grad.errors }\"\r\n                    placeholder=\"Grad\">\r\n                </mat-form-field>\r\n                <div *ngIf=\"adresaSubmited && a.grad.errors\">\r\n                  <div *ngIf=\"a.grad.errors.required\">\r\n                      <p class=\"upozorenje\">Naziv grada je obavezan</p>\r\n                  </div>\r\n                  <div *ngIf=\"a.grad.errors.minlength\">\r\n                      <p class=\"upozorenje\">Naziv grada mora imati minimalno 2 karaktera</p>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n              <div class=\"button-div\">\r\n                <button class=\"button-glavni-100\" (click)=\"promeniAdresu(ulica.value, grad.value)\" mat-raised-button>Sacuvaj</button>\r\n                <button class=\"button-crveni-50 float-right\" (click)=\"ulica.value = ''; grad.value = ''; adresaSubmited=false\"\r\n                  mat-raised-button>Poništi</button>\r\n              </div>\r\n            </form>\r\n\r\n          </mat-expansion-panel>\r\n          <mat-expansion-panel class=\"exp-panel\">\r\n            <mat-expansion-panel-header>\r\n              <mat-panel-title>\r\n                <p class=\"panel\">Promenite email</p>\r\n              </mat-panel-title>\r\n            </mat-expansion-panel-header>\r\n            <form role=\"form\" [formGroup]=\"emailForm\">\r\n              <div>\r\n                <mat-form-field>\r\n                  <input type=\"email\" #email formControlName=\"email\" matInput [ngClass]=\"{ 'is-invalid': emailSubmited && e.email.errors }\"\r\n                    placeholder=\"Novi email...\">\r\n                </mat-form-field>\r\n              </div>\r\n              <div *ngIf=\"emailSubmited && e.email.errors\">\r\n                <div *ngIf=\"e.email.errors.required\">\r\n                    <p class=\"upozorenje\">Email je obavezan</p>\r\n                </div>\r\n                <div *ngIf=\"e.email.errors.email\">\r\n                    <p class=\"upozorenje\">Email nije validan</p>\r\n                </div>\r\n              </div>\r\n              <div class=\"button-div\">\r\n                <button class=\"button-glavni-100\" (click)=\"promeniLEmail(email.value)\" mat-raised-button>Sacuvaj</button>\r\n                <button class=\"button-crveni-50 float-right\" (click)=\"email.value = ''; emailSubmited=false\"\r\n                  mat-raised-button>Poništi</button>\r\n              </div>\r\n            </form>\r\n          </mat-expansion-panel>\r\n          <mat-expansion-panel class=\"exp-panel\">\r\n            <mat-expansion-panel-header>\r\n              <mat-panel-title>\r\n                <p class=\"panel\">Promenite korisničko ime</p>\r\n              </mat-panel-title>\r\n            </mat-expansion-panel-header>\r\n            <div>\r\n              <mat-radio-group class=\"radio-group\" [(ngModel)]=\"korisnickoImeMetod\">\r\n                <mat-radio-button color=\"primary\" *ngIf =\"partner.email\" value=\"email\">Koristi trenutni email</mat-radio-button>\r\n                <mat-radio-button color=\"primary\" value=\"novo\">\r\n                  <p>Kreirajte novo</p>\r\n                </mat-radio-button>\r\n              </mat-radio-group>\r\n            </div>\r\n\r\n            <form role=\"form\" [formGroup]=\"usernameForm\">\r\n              <div>\r\n                <mat-form-field *ngIf=\"korisnickoImeMetod != 'email'\">\r\n                  <input type=\"text\" #username formControlName=\"username\" [ngClass]=\"{ 'email-selected': korisnickoImeMetod === 'email'}\"\r\n                    [attr.disabled]=\"daLiKorisnickoImeTrebaDaBudeEmail() ? '' : null\" matInput placeholder=\"Novo korisničko ime\">\r\n                </mat-form-field>\r\n              </div>\r\n\r\n              <div *ngIf=\"usernameSubmited && u.username.errors\">\r\n                <div *ngIf=\"u.username.errors.required && korisnickoImeMetod != 'email'\">\r\n                    <p class=\"upozorenje\">Korisničko ime je obavezno</p>\r\n                </div>\r\n                <div *ngIf=\"u.username.errors.minlength && korisnickoImeMetod != 'email'\">\r\n                  <p class=\"upozorenje\">Korisničko ime mora imati vise od 3 karaktera</p>\r\n                </div>\r\n              </div>\r\n              <div *ngIf=\"usernameSubmited && korisnickoImeJeZauzeto\">\r\n                <p class=\"upozorenje\">Korisničko ime je vec zazueto</p>\r\n              </div>\r\n              <div class=\"button-div\">\r\n                <button class=\"button-glavni-100\" (click)=\"promeniUsername()\" mat-raised-button>Sacuvaj</button>\r\n                <button *ngIf=\"korisnickoImeMetod != 'email'\" class=\"button-crveni-50 float-right\" (click)=\"username.value = ''; usernameSubmited=false\"\r\n                  mat-raised-button>Poništi</button>\r\n              </div>\r\n            </form>\r\n          </mat-expansion-panel>\r\n          <mat-expansion-panel class=\"exp-panel\">\r\n            <mat-expansion-panel-header>\r\n              <mat-panel-title>\r\n                <p class=\"panel\">Promenite šifru</p>\r\n              </mat-panel-title>\r\n            </mat-expansion-panel-header>\r\n            <form role=\"form\" [formGroup]=\"passwordForm\">\r\n              <div>\r\n                <mat-form-field>\r\n                  <input matInput type=\"password\" #staraSifra formControlName=\"staraSifra\" placeholder=\"Stara šifra\">\r\n                </mat-form-field>\r\n                <div *ngIf=\"passwordSubmited && !s.staraSifra.errors && losaSifra\">\r\n                  <p class=\"upozorenje\">Stara šifra nije tačna</p>\r\n                </div>\r\n                <div *ngIf=\"passwordSubmited && s.staraSifra.errors\">\r\n                  <div *ngIf=\"s.staraSifra.errors.required\">\r\n                    <p class=\" upozorenje\">Stara šifra je obavezna</p>\r\n                  </div>\r\n                  <div *ngIf=\"s.staraSifra.errors.minlength\">\r\n                    <p class=\"upozorenje\">Korisničko ime mora imati vise od 3 karaktera</p>\r\n                  </div>\r\n                </div>\r\n                <div>\r\n                  <mat-form-field>\r\n                    <input matInput type=\"password\" #novaSifra formControlName=\"novaSifra\" placeholder=\"Nova šifra\">\r\n                  </mat-form-field>\r\n                </div>\r\n                <div *ngIf=\"passwordSubmited && s.novaSifra.errors\">\r\n                  <div *ngIf=\"s.novaSifra.errors.required\">\r\n                    <p class=\" upozorenje\">Nova šifra je obavezna</p>\r\n                  </div>\r\n                  <div *ngIf=\"s.novaSifra.errors.minlength\">\r\n                    <p class=\"upozorenje\">Nova sifra mora imati vise od 3 karaktera</p>\r\n                  </div>\r\n                </div>\r\n                <div>\r\n                  <mat-form-field>\r\n                    <input matInput type=\"password\" #novaSifra2 formControlName=\"novaSifra2\" placeholder=\"Ponovite novu šifru\">\r\n                  </mat-form-field>\r\n                </div>\r\n                <div *ngIf=\"passwordSubmited && s.novaSifra2.errors\">\r\n                  <div *ngIf=\"s.novaSifra2.errors.required\">\r\n                    <p class=\" upozorenje\">Nova šifra je obavezna</p>\r\n                  </div>\r\n                  <div *ngIf=\"s.novaSifra2.errors.minlength\">\r\n                    <p class=\"upozorenje\">Nova sifra mora imati vise od 3 karaktera</p>\r\n                  </div>\r\n                </div>\r\n                <div *ngIf=\"novaSifra.value != novaSifra2.value && !s.novaSifra.errors && !s.novaSifra2.errors  && passwordSubmited\">\r\n                  <p class=\"upozorenje\">Nova sifra nije ista</p>\r\n                </div>\r\n                <div class=\"button-div\">\r\n                  <button class=\"button-glavni-100\" (click)=\"promeniSifru(staraSifra.value, novaSifra.value, novaSifra2.value)\"\r\n                    mat-raised-button>Sacuvaj</button>\r\n                  <button *ngIf=\"korisnickoImeMetod != 'email'\" class=\"button-crveni-50 float-right\" (click)=\"username.value = ''; passwordSubmited=false\"\r\n                    mat-raised-button>Poništi</button>\r\n                </div>\r\n              </div>\r\n            </form>\r\n          </mat-expansion-panel>\r\n        </mat-accordion>\r\n      </div>\r\n    </div>\r\n  </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/partner/partner.component.scss":
/*!*******************************************************!*\
  !*** ./src/app/e-shop/partner/partner.component.scss ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  font-size: 1.3em;\n  color: #273747;\n  font-weight: bold;\n  text-align: center; }\n\nli {\n  padding: 10px;\n  margin-top: 12px; }\n\n.exp-panel {\n  margin-top: 12px; }\n\n.header2 {\n  text-align: center;\n  margin-top: 20px;\n  margin-bottom: 30px; }\n\n.leva-strana {\n  width: 80px;\n  float: left;\n  color: #345cac;\n  font-weight: bold; }\n\n.desna-strana {\n  font-weight: bold; }\n\n.licni-podaci {\n  margin-top: 6%;\n  width: 80%;\n  margin-left: 10%; }\n\n.radio-group {\n  display: inline-flex;\n  flex-direction: column; }\n\n.panel {\n  color: #345cac;\n  font-weight: bold; }\n\n.email-selected {\n  color: #8ea7b4 !important; }\n\n.dugovanje {\n  color: #b71c1c; }\n\n.button-div {\n  width: 70%;\n  margin-left: 15%; }\n\n.strana {\n  box-shadow: 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);\n  width: 90%;\n  height: 340px;\n  margin-left: 10px;\n  margin-top: 10px;\n  padding: 10px;\n  border-bottom: 0.5px solid #273747;\n  background-color: white; }\n\n.strana2 {\n  box-shadow: 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);\n  width: 90%;\n  margin-left: 10px;\n  margin-top: 10px;\n  padding: 10px;\n  border-bottom: 0.5px solid #273747;\n  background-color: white; }\n\n@media only screen and (max-device-width: 640px) {\n  .strana {\n    width: 100%;\n    height: 100%;\n    margin-top: 10px;\n    border-bottom: 0.5px solid #273747;\n    background-color: white; }\n  li {\n    padding: 0px; }\n  ul {\n    margin: 0px;\n    padding: 2px; }\n  .licni-podaci {\n    margin-top: 1%;\n    width: 95%;\n    margin-left: 0%; } }\n"

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
/* harmony import */ var src_app_shared_service_notifikacija_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/shared/service/notifikacija.service */ "./src/app/shared/service/notifikacija.service.ts");
/* harmony import */ var src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/shared/model/konstante */ "./src/app/shared/model/konstante.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
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
    function PartnerComponent(loginServis, partnerServis, formBuilder, notifikacijaServis, router) {
        this.loginServis = loginServis;
        this.partnerServis = partnerServis;
        this.formBuilder = formBuilder;
        this.notifikacijaServis = notifikacijaServis;
        this.router = router;
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
        this.loginServis.vratiUlogovanogKorisnika(false)
            .subscribe(function (res) {
            if (res !== null) {
                _this.partner = res;
                _this.daLiDuguje = _this.partner.stanje < 0;
                _this.inicijalizujSveRegistracioneForme();
            }
            else {
                _this.router.navigate(['/login']);
                _this.loginServis.izbaciPartnerIzSesije();
            }
        });
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
            _this.notifikacijaServis.notify(poruka, src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_7__["MatSnackBarKlase"].Zelena);
        }, function (error) {
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
            _this.notifikacijaServis.notify(poruka, src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_7__["MatSnackBarKlase"].Zelena);
        }, function (error) {
        });
    };
    PartnerComponent.prototype.updejtPartnera = function (partner, poruka) {
        var _this = this;
        this.partnerServis.updejtujPartnera(this.partner)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.partner = res;
            _this.notifikacijaServis.notify(poruka, src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_7__["MatSnackBarKlase"].Zelena);
        }, function (error) {
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
            src_app_shared_service_notifikacija_service__WEBPACK_IMPORTED_MODULE_6__["NotifikacijaService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_8__["Router"]])
    ], PartnerComponent);
    return PartnerComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.html":
/*!***************************************************************************!*\
  !*** ./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.html ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <div class=\"flex-login\">\n    <div class=\"login-form\">\n      <h1>Promeni šifru</h1>\n      <div class=\"alert alert-danger\" role=\"alert\" *ngIf=\"submitted == true && uspesnaPromena == false\">\n        <p>Promena šifre nije uspela, zahtevajte ponovo poštu za resetovanje šifre.</p>\n      </div>\n      <form role=\"form\" [formGroup]=\"promenaSifreForm\">\n        <div class=\"form-group\">\n          <input type=\"password\" #pass1 formControlName=\"pass1\" class=\"form-control rounded\" placeholder=\"Nova šifra\" id=\"pass1\"\n            name=\"pass1\" />\n          <div *ngIf=\"submitted && r.pass1.errors\">\n            <div *ngIf=\"r.pass1.errors.required\">\n              <p class=\"upozorenje\">Šifra je obavezna</p>\n            </div>\n            <div *ngIf=\"r.pass1.errors.minlength\">\n              <p class=\"upozorenje\">Šifra mora imati minimalno 3 karaktera</p>\n            </div>\n          </div>\n        </div>\n        <div class=\"form-group\">\n          <input type=\"password\" #pass2 formControlName=\"pass2\" class=\"form-control rounded\" placeholder=\"Ponovite šifru\"\n            id=\"password\" name=\"password\" />\n          <div *ngIf=\"submitted && r.pass2.errors\">\n            <div *ngIf=\"r.pass2.errors.required\">\n              <p class=\"upozorenje\">Šifra je obavezna</p>\n            </div>\n            <div *ngIf=\"r.pass2.errors.minlength\">\n              <p class=\"upozorenje\">Šifra mora imati minimalno 3 karaktera</p>\n            </div>\n          </div>\n          <div *ngIf=\"submitted && !r.pass2.errors && pass1.value != pass2.value\">\n            <p class=\"upozorenje\">Šifre nisu iste</p>\n          </div>\n        </div>\n        <div class=\"d-flex\">\n          <button mat-raised-button (click)=\"promeniSifru()\" class=\"rounded\" color=\"primary\">Promeni</button>\n        </div>\n      </form>\n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.scss":
/*!***************************************************************************!*\
  !*** ./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.scss ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".flex-login {\n  margin-top: 10%;\n  display: flex;\n  justify-content: center; }\n\n.login-form {\n  width: 400px;\n  justify-content: center; }\n\nh1 {\n  text-align: center;\n  text-transform: uppercase; }\n\nbutton {\n  margin: auto;\n  display: block; }\n\np {\n  text-align: center; }\n\n.is-invalid {\n  border: 1px solid red; }\n\n.upozorenje {\n  text-align: left;\n  font-size: 0.8em;\n  color: red;\n  margin: 0px !important; }\n"

/***/ }),

/***/ "./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.ts":
/*!*************************************************************************!*\
  !*** ./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.ts ***!
  \*************************************************************************/
/*! exports provided: ResetovanjeSfireComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ResetovanjeSfireComponent", function() { return ResetovanjeSfireComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _model_dto__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../model/dto */ "./src/app/e-shop/model/dto.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _service_partner_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../service/partner.service */ "./src/app/e-shop/service/partner.service.ts");
/* harmony import */ var src_app_shared_service_notifikacija_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/shared/service/notifikacija.service */ "./src/app/shared/service/notifikacija.service.ts");
/* harmony import */ var src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/shared/model/konstante */ "./src/app/shared/model/konstante.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var ResetovanjeSfireComponent = /** @class */ (function () {
    function ResetovanjeSfireComponent(formBuilder, route, partnerServis, notifikacijaServis, router) {
        this.formBuilder = formBuilder;
        this.route = route;
        this.partnerServis = partnerServis;
        this.notifikacijaServis = notifikacijaServis;
        this.router = router;
        this.submitted = false;
        this.uspesnoLogovanje = true;
        this.ucitavanje = false;
        this.alive = true;
        this.uspesnaPromena = true;
    }
    ResetovanjeSfireComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.promenaSifreForm = this.formBuilder.group({
            pass1: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]],
            pass2: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]]
        });
        this.route.params.subscribe(function (params) {
            _this.staraSifra = params.id;
        });
        this.route.queryParams.subscribe(function (params) {
            _this.ppid = params.id;
        });
    };
    Object.defineProperty(ResetovanjeSfireComponent.prototype, "r", {
        // convenience getter for easy access to form fields
        get: function () { return this.promenaSifreForm.controls; },
        enumerable: true,
        configurable: true
    });
    ResetovanjeSfireComponent.prototype.promeniSifru = function () {
        var _this = this;
        this.submitted = true;
        // stop here if form is invalid
        if (this.promenaSifreForm.invalid || this.r.pass1.value !== this.r.pass2.value) {
            return;
        }
        var dto = this.napraviDto();
        this.partnerServis.promeniSifru(dto, false).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) {
            if (error.status === 400) {
                _this.uspesnaPromena = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_4__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function (res) {
            _this.uspesnaPromena = true;
            _this.notifikacijaServis.notify('Šifra uspešno promenjena', src_app_shared_model_konstante__WEBPACK_IMPORTED_MODULE_8__["MatSnackBarKlase"].Zelena);
            _this.router.navigate(['/login']);
        }, function (error) {
            _this.uspesnaPromena = false;
        });
    };
    ResetovanjeSfireComponent.prototype.napraviDto = function () {
        var dto = new _model_dto__WEBPACK_IMPORTED_MODULE_2__["PromenaSifre"]();
        dto.sifra = this.r.pass1.value;
        dto.ponovljenjaSifra = this.r.pass2.value;
        dto.ppid = this.ppid;
        dto.staraSifra = this.staraSifra;
        return dto;
    };
    ResetovanjeSfireComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-resetovanje-sfire',
            template: __webpack_require__(/*! ./resetovanje-sfire.component.html */ "./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.html"),
            styles: [__webpack_require__(/*! ./resetovanje-sfire.component.scss */ "./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"],
            _angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"],
            _service_partner_service__WEBPACK_IMPORTED_MODULE_6__["PartnerService"],
            src_app_shared_service_notifikacija_service__WEBPACK_IMPORTED_MODULE_7__["NotifikacijaService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"]])
    ], ResetovanjeSfireComponent);
    return ResetovanjeSfireComponent;
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
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var DOMAIN_URL = src_environments_environment__WEBPACK_IMPORTED_MODULE_6__["environment"].baseUrl + '/api/informacije/';
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
        return robaBaza;
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
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! lodash */ "./node_modules/lodash/lodash.js");
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_3__);
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
        var partnerCopy = lodash__WEBPACK_IMPORTED_MODULE_3__["cloneDeep"](partner);
        if (partnerCopy != null && partnerCopy.ppid != null) {
            partnerCopy.loginCount = null;
            this.storage.set(PARTNER_KLJUC, partnerCopy);
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
        __param(0, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(angular_webstorage_service__WEBPACK_IMPORTED_MODULE_1__["LOCAL_STORAGE"])),
        __metadata("design:paramtypes", [Object])
    ], LocalStorageService);
    return LocalStorageService;
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
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var DOMAIN_URL = src_environments_environment__WEBPACK_IMPORTED_MODULE_5__["environment"].baseUrl + '/api';
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
    FakturaService.prototype.submitujFakturu = function (faktura) {
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
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _data_local_storage_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./data/local-storage.service */ "./src/app/e-shop/service/data/local-storage.service.ts");
/* harmony import */ var _data_data_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var src_app_shared_modal_sesija_istekla_modal_sesija_istekla_modal_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component */ "./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.ts");
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
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
var LOGIN_URL = src_environments_environment__WEBPACK_IMPORTED_MODULE_10__["environment"].baseUrl + '/login';
var LOGOUT_URL = src_environments_environment__WEBPACK_IMPORTED_MODULE_10__["environment"].baseUrl + '/logout';
var PARTNER_URL = src_environments_environment__WEBPACK_IMPORTED_MODULE_10__["environment"].baseUrl + '/api/partner';
var LoginService = /** @class */ (function () {
    function LoginService(http, router, utils, korpaServis, storageServis, dialog) {
        this.http = http;
        this.router = router;
        this.utils = utils;
        this.korpaServis = korpaServis;
        this.storageServis = storageServis;
        this.dialog = dialog;
        this.partner = this.storageServis.procitajPartneraIzMemorije() || null;
        this.partnerSubjekat = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](this.partner);
        this.ulogovaniPartner = this.partnerSubjekat.asObservable();
        this.logovanjeSubjekat = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](this.partner !== null);
        this.daLiJePartnerUlogovan = this.logovanjeSubjekat.asObservable();
    }
    LoginService.prototype.ulogujSe = function (credentials) {
        var parameterObject = {};
        parameterObject['username'] = credentials.username;
        parameterObject['password'] = credentials.password;
        parameterObject['submit'] = 'Login';
        var parametersString = this.utils.vratiKveriParametre(parameterObject);
        var fullUrl = LOGIN_URL + parametersString;
        return this.http.post(fullUrl, {}, { responseType: 'text' })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    LoginService.prototype.vratiUlogovanogKorisnika = function (daLiJePrviRequest) {
        var parameterObject = {};
        parameterObject['prviRequest'] = daLiJePrviRequest;
        var parametersString = this.utils.vratiKveriParametre(parameterObject);
        var fullUrl = PARTNER_URL + parametersString;
        return this.http.get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    LoginService.prototype.setDaLiJeUserLogovan = function (bool) {
        this.logovanjeSubjekat.next(bool);
    };
    LoginService.prototype.setUlogovanogPartner = function (partner) {
        this.partnerSubjekat.next(partner);
        this.storageServis.sacuvajPartneraUMemoriju(partner);
    };
    LoginService.prototype.izbaciPartnerIzSesije = function () {
        var _this = this;
        var sesijaDialog = this.dialog.open(src_app_shared_modal_sesija_istekla_modal_sesija_istekla_modal_component__WEBPACK_IMPORTED_MODULE_9__["SesijaIsteklaModalComponent"], {
            width: '400px'
        });
        sesijaDialog.afterClosed().subscribe(function () {
            _this.logovanjeSubjekat.next(false);
            _this.partnerSubjekat.next(null);
            _this.storageServis.logout();
        });
    };
    LoginService.prototype.logout = function () {
        var _this = this;
        var fullUrl = LOGOUT_URL;
        this.http.post(fullUrl, {}, { responseType: 'text' })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }))
            .subscribe(function () {
            _this.korpaServis.ocistiKorpu();
            _this.logovanjeSubjekat.next(false);
            _this.partnerSubjekat.next(null);
            _this.storageServis.logout();
            _this.router.navigateByUrl('naslovna');
        });
    };
    LoginService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"],
            _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"],
            _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__["AppUtilsService"],
            _data_data_service__WEBPACK_IMPORTED_MODULE_7__["DataService"],
            _data_local_storage_service__WEBPACK_IMPORTED_MODULE_6__["LocalStorageService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_8__["MatDialog"]])
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
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../utils/app-utils.service */ "./src/app/e-shop/utils/app-utils.service.ts");
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var PARTNER_URL = src_environments_environment__WEBPACK_IMPORTED_MODULE_5__["environment"].baseUrl + '/api/partner';
var RESETOVANJE_SIFRE_URL = '/promena-sifre';
var TIMEOUT = 15000;
var TIMEOUT_ERROR = 'Timeout error!';
var PartnerService = /** @class */ (function () {
    function PartnerService(http, utils) {
        this.http = http;
        this.utils = utils;
    }
    PartnerService.prototype.updejtujPartnera = function (partner) {
        var fullUrl = PARTNER_URL;
        return this.http
            .put(fullUrl, partner)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    PartnerService.prototype.promeniSifru = function (reset, isPrvaPromena) {
        var parameterObject = {};
        parameterObject['isPrvaPromena'] = isPrvaPromena;
        var parametersString = this.utils.vratiKveriParametre(parameterObject);
        var fullUrl = PARTNER_URL + RESETOVANJE_SIFRE_URL + parametersString;
        return this.http
            .put(fullUrl, reset)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }));
    };
    PartnerService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"],
            _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__["AppUtilsService"]])
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
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var DOMAIN_URL = src_environments_environment__WEBPACK_IMPORTED_MODULE_5__["environment"].baseUrl + '/api';
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
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var DOMAIN_URL = src_environments_environment__WEBPACK_IMPORTED_MODULE_5__["environment"].baseUrl + '/api';
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

/***/ "./src/app/footer/footer.component.html":
/*!**********************************************!*\
  !*** ./src/app/footer/footer.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<footer>\n  <div class=\"granica\"></div>\n  <div class=\"d-flex flex-lg-row flex-column\">\n    <div class=\"slika-div\">\n      <img [src]=\"img_logo\" alt=\"Automaterijal\">\n    </div>\n    <div class=\"flex-fill\">\n      <ul>\n        <li class=\"naslov\">Adresa</li>\n        <li class=\"detalji\">Prvomajska 61</li>\n        <li class=\"detalji\">15000 Šabac</li>\n        <li class=\"detalji\"><a class=\"header\" href=\"tel:015334630\">015/334-630</a></li>\n        <li class=\"detalji\">office@automaterijal.com</li>\n      </ul>\n    </div>\n    <div class=\"flex-fill\">\n      <ul>\n        <li class=\"naslov\">Korisni Linkovi</li>\n        <li class=\"detalji\">\n          <a [routerLink]=\"['/naslovna']\">Naslovna</a>\n        </li>\n        <li class=\"detalji\">\n          <a [routerLink]=\"['/o-nama']\">O nama</a>\n        </li>\n        <li class=\"detalji\">\n          <a [routerLink]=\"['/kontakt']\">Kontakt</a>\n        </li>\n        <li class=\"detalji\">\n          <a [routerLink]=\"['/roba']\">E-prodavnica</a>\n        </li>\n      </ul>\n    </div>\n    <div class=\"flex-fill\">\n      <ul>\n        <li class=\"naslov\">Korisni Upiti</li>\n        <li class=\"detalji\">\n          <a (click)=\"otvoriUpitDialog()\">Upit za ponudu</a>\n        </li>\n        <li class=\"detalji\">\n          <a (click)=\"otvoriPorukuDialog()\">Poruka</a>\n        </li>\n        <li class=\"detalji\">\n          <a (click)=\"otvoriResgracijaDialog()\">Registracija</a>\n        </li>\n        <li class=\"detalji\">\n          <a (click)=\"otvoriZaboravljenuSifruDialog()\">Zaboravljen šifra</a>\n        </li>\n      </ul>\n    </div>\n  </div>\n</footer>"

/***/ }),

/***/ "./src/app/footer/footer.component.scss":
/*!**********************************************!*\
  !*** ./src/app/footer/footer.component.scss ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "footer {\n  padding: 2% 8%;\n  position: absolute;\n  right: 0;\n  bottom: 0;\n  left: 0; }\n\n.granica {\n  margin-bottom: 2rem;\n  width: 100%;\n  border-top: 1px solid #dfe5e7; }\n\n.naslov {\n  font-size: 1.1em;\n  font-weight: bold;\n  margin-bottom: 0.5em; }\n\n.detalji {\n  font-size: 1em;\n  margin-left: 0.2em;\n  color: #435d69; }\n\nul {\n  list-style-type: none; }\n\na {\n  color: #435d69;\n  cursor: pointer; }\n\nimg {\n  margin-right: 3em;\n  padding: 0px;\n  margin-top: 3%;\n  width: 250px;\n  height: 90px;\n  display: block; }\n\n.slika-div {\n  width: 25%;\n  padding: 0px;\n  margin: 0px; }\n\na:hover {\n  color: #345cac !important;\n  text-decoration: none; }\n\n@media screen and (max-width: 990px) {\n  ul {\n    text-align: center;\n    margin: 0px;\n    margin-top: 5px;\n    padding: 0px; }\n  .slika-div {\n    margin-left: auto;\n    margin-right: auto;\n    width: 100%; }\n  img {\n    margin-left: auto;\n    margin-right: auto;\n    width: 250px;\n    height: 90px; }\n  .detalji {\n    margin-left: 0em; } }\n"

/***/ }),

/***/ "./src/app/footer/footer.component.ts":
/*!********************************************!*\
  !*** ./src/app/footer/footer.component.ts ***!
  \********************************************/
/*! exports provided: FooterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FooterComponent", function() { return FooterComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _shared_modal_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shared/modal/registracija-modal/registracija-modal.component */ "./src/app/shared/modal/registracija-modal/registracija-modal.component.ts");
/* harmony import */ var _shared_modal_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component */ "./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.ts");
/* harmony import */ var _shared_modal_poruka_modal_poruka_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../shared/modal/poruka-modal/poruka-modal.component */ "./src/app/shared/modal/poruka-modal/poruka-modal.component.ts");
/* harmony import */ var _shared_modal_upit_modal_upit_modal_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../shared/modal/upit-modal/upit-modal.component */ "./src/app/shared/modal/upit-modal/upit-modal.component.ts");
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var FooterComponent = /** @class */ (function () {
    function FooterComponent(dialog) {
        this.dialog = dialog;
        this.img_logo = src_environments_environment__WEBPACK_IMPORTED_MODULE_6__["environment"].baseUrl + '/assets/slike/logo/automaterijal.png';
    }
    FooterComponent.prototype.ngOnInit = function () {
    };
    FooterComponent.prototype.otvoriPorukuDialog = function () {
        this.dialog.open(_shared_modal_poruka_modal_poruka_modal_component__WEBPACK_IMPORTED_MODULE_4__["PorukaModalComponent"], {
            width: '400px'
        });
    };
    FooterComponent.prototype.otvoriResgracijaDialog = function () {
        this.dialog.open(_shared_modal_registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_2__["RegistracijaModalComponent"], {
            width: '400px'
        });
    };
    FooterComponent.prototype.otvoriZaboravljenuSifruDialog = function () {
        this.dialog.open(_shared_modal_zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_3__["ZaboravljenaSifraModalComponent"], {
            width: '400px'
        });
    };
    FooterComponent.prototype.otvoriUpitDialog = function () {
        this.dialog.open(_shared_modal_upit_modal_upit_modal_component__WEBPACK_IMPORTED_MODULE_5__["UpitModalComponent"], {
            width: '400px'
        });
    };
    FooterComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-footer',
            template: __webpack_require__(/*! ./footer.component.html */ "./src/app/footer/footer.component.html"),
            styles: [__webpack_require__(/*! ./footer.component.scss */ "./src/app/footer/footer.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialog"]])
    ], FooterComponent);
    return FooterComponent;
}());



/***/ }),

/***/ "./src/app/navigacija/navigacija.component.html":
/*!******************************************************!*\
  !*** ./src/app/navigacija/navigacija.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-sidenav-container class=\"sidenav-container pozadina-siva-400\">\r\n  <mat-sidenav #drawer class=\"sidenav pozadina-glavna-50\" fixedInViewport=\"true\"\r\n    [attr.role]=\"(isHandset$ | async) ? 'dialog' : 'navigation'\" [mode]=\"(isHandset$ | async) ? 'over' : 'side'\"\r\n    [opened]=\"!(isHandset$ | async)\">\r\n    <mat-toolbar *ngIf=\"partnerUlogovan\" class=\"side-toolbar pozadina-glavna-50 header-pozicija\">\r\n      <div class=\"d-flex flex-column justify-content-center\">\r\n        <div class=\"d-flex justify-content-center header-sirina\">\r\n          <mat-icon class=\"boja-siva-300\">person</mat-icon>\r\n        </div>\r\n        <div><p class=\"text-center header-navigacija\">{{partner.naziv}}</p></div>\r\n      </div>\r\n    </mat-toolbar>\r\n    <mat-nav-list [class.margin-gore]=\"partnerUlogovan\">\r\n      <mat-divider *ngIf=\"partnerUlogovan\" class=\"pozadina-siva-300\"></mat-divider>\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['naslovna']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>home</mat-icon>\r\n        <p mat-line>Naslovna</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['o-nama']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>book</mat-icon>\r\n        <p mat-line>O nama</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['kontakt']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>contact_phone</mat-icon>\r\n        <p mat-line>Kontakt</p>\r\n      </mat-list-item>\r\n    </mat-nav-list>\r\n\r\n    <mat-divider></mat-divider>\r\n    <mat-nav-list>\r\n      <h3 class=\"pozadina-glavna-50 boja-siva-300\" mat-subheader>Internet prodavnica</h3>\r\n\r\n      <mat-list-item class=\"material-icons\" *ngIf=\"partnerUlogovan\" [routerLink]=\"['korpa']\"\r\n        [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon matBadgeColor=\"warn\" class=\"boja-siva-300\" matBadge=\"{{korpaBadge}}\" mat-list-icon>shopping_cart\r\n        </mat-icon>\r\n        <p mat-line>Korpa</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['roba']\" [routerLinkActive]=\"['pozadina-glavna-200']\"\r\n        [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>searche</mat-icon>\r\n        <p mat-line>Roba - pretraga</p>\r\n      </mat-list-item>\r\n\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['ulja']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>invert_colors</mat-icon>\r\n        <p mat-line>Ulja</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['filteri']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>layers</mat-icon>\r\n        <p mat-line>Filteri</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['akumulatori']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>battery_charging_full</mat-icon>\r\n        <p mat-line>Akumulatori</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['ostalo']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>category</mat-icon>\r\n        <p mat-line>Ostalo</p>\r\n      </mat-list-item>\r\n    </mat-nav-list>\r\n\r\n    <mat-divider></mat-divider>\r\n    <mat-nav-list *ngIf=\"partnerUlogovan\">\r\n      <h3 class=\"pozadina-glavna-50 boja-siva-300\" mat-subheader>Moj Profil</h3>\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['licni-podaci']\"\r\n        [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>person</mat-icon>\r\n        <p mat-line>Licni Podaci</p>\r\n      </mat-list-item>\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['porudzbenice']\"\r\n        [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>list</mat-icon>\r\n        <p mat-line>Porudzbine</p>\r\n      </mat-list-item>\r\n    </mat-nav-list>\r\n    <mat-divider></mat-divider>\r\n    <mat-nav-list>\r\n      <mat-list-item *ngIf=\"partnerUlogovan === false\" class=\"material-icons\" [routerLink]=\"['login']\"\r\n        [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>exit_to_app</mat-icon>\r\n        <p mat-line>Login</p>\r\n      </mat-list-item>\r\n      <mat-list-item *ngIf=\"partnerUlogovan\" class=\"material-icons\" (click)=\"otvoriDialog()\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>power_settings_new</mat-icon>\r\n        <p mat-line>Logout</p>\r\n      </mat-list-item>\r\n    </mat-nav-list>\r\n  </mat-sidenav>\r\n  <mat-sidenav-content>\r\n    <mat-toolbar *ngIf=\"isHandset$ | async\" class=\"header-pozicija pozadina-glavna-50\">\r\n      <button type=\"button\" aria-label=\"Toggle sidenav\" mat-icon-button (click)=\"drawer.toggle()\">\r\n        <mat-icon class=\"boja-siva-300\" aria-label=\"Side nav toggle icon\">menu</mat-icon>\r\n      </button>\r\n    </mat-toolbar>\r\n    <div class=\"pozicija\">\r\n    <router-outlet></router-outlet>\r\n  </div>\r\n    <app-footer></app-footer>\r\n  </mat-sidenav-content>\r\n</mat-sidenav-container>"

/***/ }),

/***/ "./src/app/navigacija/navigacija.component.scss":
/*!******************************************************!*\
  !*** ./src/app/navigacija/navigacija.component.scss ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sidenav-container {\n  height: 100%; }\n\n.pozicija {\n  margin: 0 auto;\n  padding-bottom: 220px; }\n\n.sidenav {\n  width: 200px;\n  height: 100%; }\n\n.mat-toolbar.mat-primary {\n  position: -webkit-sticky;\n  position: sticky;\n  top: 0; }\n\n.header-navigacija {\n  font-size: 0.6em !important;\n  width: 200pxpx; }\n\n.header-sirina {\n  width: 200px !important; }\n\np {\n  color: #f6f6f6 !important;\n  height: 18px; }\n\nmat-divider {\n  border-width: 1px;\n  border-style: solid;\n  border-color: #dfe5e7; }\n\n.margin-gore {\n  margin-top: 70px; }\n\n.side-toolbar {\n  height: 75px;\n  width: 200px;\n  padding: 0px 0px !important; }\n\n.header-pozicija {\n  top: 0px;\n  position: fixed;\n  z-index: 999; }\n\n@media screen and (max-device-width: 1000px) {\n  .pozicija {\n    padding-bottom: 490px; } }\n\n@media screen and (max-width: 990px) {\n  .pozicija {\n    padding-bottom: 500px; } }\n"

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
/* harmony import */ var _e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _shared_modal_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../shared/modal/logout-modal/logout-modal.component */ "./src/app/shared/modal/logout-modal/logout-modal.component.ts");
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
        this.partnerUlogovan = false;
        this.isHandset$ = this.breakpointObserver.observe(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["Breakpoints"].Handset)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (result) { return result.matches; }));
    }
    NavigacijaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.korpaServis.trenutnaKorpa.subscribe(function (korpa) { return _this.korpaBadge = korpa.roba.length; });
        this.loginServis.daLiJePartnerUlogovan.subscribe(function (bool) { return _this.partnerUlogovan = bool; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
    };
    NavigacijaComponent.prototype.otvoriDialog = function () {
        var dialogRef = this.dialog.open(_shared_modal_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_6__["LogoutModalComponent"], {
            width: '400px'
        });
        dialogRef.afterClosed().subscribe(function () {
        });
    };
    NavigacijaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-navigacija',
            template: __webpack_require__(/*! ./navigacija.component.html */ "./src/app/navigacija/navigacija.component.html"),
            styles: [__webpack_require__(/*! ./navigacija.component.scss */ "./src/app/navigacija/navigacija.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["BreakpointObserver"],
            _e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_5__["DataService"],
            _e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_4__["LoginService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatDialog"]])
    ], NavigacijaComponent);
    return NavigacijaComponent;
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
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatTooltipModule"],
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
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatTooltipModule"],
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

/***/ "./src/app/shared/modal/brendovi-modal/brendovi-modal.component.html":
/*!***************************************************************************!*\
  !*** ./src/app/shared/modal/brendovi-modal/brendovi-modal.component.html ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"header\">\n    <h1>{{brend.ime}}</h1>\n    <button type=\"button\" class=\"close\" (click)=\"zatvoriDialog()\">\n        <span aria-hidden=\"true\">&times;</span>\n    </button>\n</div>\n<mat-dialog-content>\n    <img [src]=\"brend.urlSlikePozadina\" />\n    <div [innerHTML]=\"brend.opis\"></div>\n</mat-dialog-content>"

/***/ }),

/***/ "./src/app/shared/modal/brendovi-modal/brendovi-modal.component.scss":
/*!***************************************************************************!*\
  !*** ./src/app/shared/modal/brendovi-modal/brendovi-modal.component.scss ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  color: #345cac;\n  text-align: center;\n  display: inline; }\n\np {\n  margin-top: 20px; }\n\n.header {\n  height: 3em;\n  text-align: center; }\n\n.mat-dialog-content {\n  max-height: 75vh; }\n\n/* :host /deep/ mySelector { */\n\n:host ::ng-deep p {\n  margin-top: 20px; }\n\nimg {\n  width: 100%;\n  height: 100%; }\n"

/***/ }),

/***/ "./src/app/shared/modal/brendovi-modal/brendovi-modal.component.ts":
/*!*************************************************************************!*\
  !*** ./src/app/shared/modal/brendovi-modal/brendovi-modal.component.ts ***!
  \*************************************************************************/
/*! exports provided: BrendoviModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BrendoviModalComponent", function() { return BrendoviModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var src_app_e_commerce_model_dto__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/e-commerce/model/dto */ "./src/app/e-commerce/model/dto.ts");
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



var BrendoviModalComponent = /** @class */ (function () {
    function BrendoviModalComponent(dialogRef, brend) {
        this.dialogRef = dialogRef;
        this.brend = brend;
    }
    BrendoviModalComponent.prototype.ngOnInit = function () {
    };
    BrendoviModalComponent.prototype.zatvoriDialog = function () {
        this.dialogRef.close();
    };
    BrendoviModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-brendovi-modal',
            template: __webpack_require__(/*! ./brendovi-modal.component.html */ "./src/app/shared/modal/brendovi-modal/brendovi-modal.component.html"),
            styles: [__webpack_require__(/*! ./brendovi-modal.component.scss */ "./src/app/shared/modal/brendovi-modal/brendovi-modal.component.scss")]
        }),
        __param(1, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MAT_DIALOG_DATA"])),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"],
            src_app_e_commerce_model_dto__WEBPACK_IMPORTED_MODULE_2__["Brend"]])
    ], BrendoviModalComponent);
    return BrendoviModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.html":
/*!*****************************************************************************************!*\
  !*** ./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.html ***!
  \*****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n  <main>\r\n    <div class=\"header\">\r\n      <button type=\"button\" class=\"close\" (click)=\"bezIzmena()\">\r\n        <span aria-hidden=\"true\">&times;</span>\r\n      </button>\r\n    </div>\r\n    <div class=\"pozadina-glavna-50 boja-siva-400\">\r\n      <h1>Artikal broj: {{data.katbr}}</h1>\r\n    </div>\r\n    <table class=\"table\">\r\n      <tbody>\r\n        <tr>\r\n          <td>Proizvodjač</td>\r\n          <td>{{data.proizvodjac.naziv}}</td>\r\n        </tr>\r\n        <tr>\r\n          <td>Cena</td>\r\n          <td>{{data.cenaKom | currency:\" \"}} RSD</td>\r\n        <tr>\r\n          <td>Kolicina</td>\r\n          <td>\r\n            <select class=\"custom-select custom-select-md\" [(ngModel)]=\"data.kolicina\">\r\n              <option *ngFor=\"let kolicina of stanje\" [value]=\"kolicina\">{{kolicina}}</option>\r\n            </select>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>Ukupno za placanje</td>\r\n          <td><b>{{data.kolicina * data.cenaKom | currency:\" \"}} RSD</b></td>\r\n        </tr>\r\n      </tbody>\r\n    </table>\r\n    <div class=\"d-flex flex-row justify-content-center\">\r\n      <button class=\"button-glavni-100\" mat-raised-button (click)=\"sacuvajIzmene()\">Sacuvaj</button>\r\n      <span class=\"col-2\"></span>\r\n      <button class=\"button-crveni-50\" mat-raised-button (click)=\"bezIzmena()\">Poništi</button>\r\n    </div>\r\n  </main>\r\n</div>"

/***/ }),

/***/ "./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.scss":
/*!*****************************************************************************************!*\
  !*** ./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.scss ***!
  \*****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "p {\n  text-align: center; }\n\nh1 {\n  text-align: center;\n  font-size: 1.2em;\n  color: white;\n  padding: 10px; }\n\ntd {\n  font-size: 1em; }\n\n.header {\n  height: 2em; }\n\n.pomeri {\n  margin-left: 10px; }\n"

/***/ }),

/***/ "./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.ts":
/*!***************************************************************************************!*\
  !*** ./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.ts ***!
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
/* harmony import */ var src_app_e_shop_model_porudzbenica__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/e-shop/model/porudzbenica */ "./src/app/e-shop/model/porudzbenica.ts");
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
            template: __webpack_require__(/*! ./izmena-kolicine-modal.component.html */ "./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.html"),
            styles: [__webpack_require__(/*! ./izmena-kolicine-modal.component.scss */ "./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.scss")]
        }),
        __param(1, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MAT_DIALOG_DATA"])),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"],
            src_app_e_shop_model_porudzbenica__WEBPACK_IMPORTED_MODULE_3__["RobaKorpa"]])
    ], IzmenaKolicineModalComponent);
    return IzmenaKolicineModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/modal/logout-modal/logout-modal.component.html":
/*!***********************************************************************!*\
  !*** ./src/app/shared/modal/logout-modal/logout-modal.component.html ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <main>\n    <div class=\"header\">\n      <p>Da li ste sigurni da zelite da se odjavite?</p>\n      <button type=\"button\" class=\"close\" (click)=\"ostaniUlogovan()\">\n        <span aria-hidden=\"true\">&times;</span>\n      </button>\n    </div>\n    <div class=\"d-flex flex-row justify-content-center margin-top--15\">\n      <button mat-raised-button class=\"button-glavni-100\" (click)=\"logout()\">Odjava</button>\n      <span class=\"col-2\"></span>\n      <button mat-raised-button class=\"button-crveni-50\" (click)=\"ostaniUlogovan()\">Poništi</button>\n    </div>\n  </main>\n</div>"

/***/ }),

/***/ "./src/app/shared/modal/logout-modal/logout-modal.component.scss":
/*!***********************************************************************!*\
  !*** ./src/app/shared/modal/logout-modal/logout-modal.component.scss ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "p {\n  text-align: center;\n  display: inline; }\n\n.header {\n  height: 2em; }\n\nh1 {\n  text-align: center; }\n"

/***/ }),

/***/ "./src/app/shared/modal/logout-modal/logout-modal.component.ts":
/*!*********************************************************************!*\
  !*** ./src/app/shared/modal/logout-modal/logout-modal.component.ts ***!
  \*********************************************************************/
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
        var _this = this;
        this.loginServis.vratiUlogovanogKorisnika(false).subscribe(function (partner) {
            if (partner === null) {
                _this.dialogRef.close();
                _this.router.navigateByUrl('naslovna');
                _this.loginServis.izbaciPartnerIzSesije();
            }
        });
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
            template: __webpack_require__(/*! ./logout-modal.component.html */ "./src/app/shared/modal/logout-modal/logout-modal.component.html"),
            styles: [__webpack_require__(/*! ./logout-modal.component.scss */ "./src/app/shared/modal/logout-modal/logout-modal.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_3__["LoginService"]])
    ], LogoutModalComponent);
    return LogoutModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.html":
/*!*****************************************************************************************************!*\
  !*** ./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.html ***!
  \*****************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"header\">\n  <h3>Obaveštenje</h3>\n  <button type=\"button\" class=\"close\" (click)=\"zatvoriDialog()\">\n    <span aria-hidden=\"true\">&times;</span>\n  </button>\n</div>\n<p>Došlo je do promene količina traženih artikala.</p>\n<mat-dialog-content>\n  <table mat-table [dataSource]=\"dataSource\" class=\"mat-elevation-z8\">\n\n    <!--- Note that these columns can be defined in any order.\n        The actual rendered columns are set as a property on the row definition\" -->\n\n    <!-- Position Column -->\n    <ng-container matColumnDef=\"katBr\">\n      <th mat-header-cell *matHeaderCellDef> Kat. br. </th>\n      <td mat-cell *matCellDef=\"let roba\"> {{roba.katbr}} </td>\n    </ng-container>\n\n    <!-- Weight Column -->\n    <ng-container matColumnDef=\"trazeno\">\n      <th mat-header-cell *matHeaderCellDef> Traženo </th>\n      <td mat-cell *matCellDef=\"let roba\"> {{roba.trazenaKolicina}} </td>\n    </ng-container>\n\n    <!-- Symbol Column -->\n    <ng-container matColumnDef=\"raspolozivo\">\n      <th mat-header-cell *matHeaderCellDef> Raspoloživo </th>\n      <td mat-cell *matCellDef=\"let roba\">\n        <p class=\"boja-crvena-50\">{{roba.rapolozivaKolicina}}</p>\n      </td>\n    </ng-container>\n\n    <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n    <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n  </table>\n  <div class=\"text-center pomeri-dole\">\n    <button mat-raised-button (click)=\"zatvoriDialog()\" class=\"button-glavni-100\">Zatvori</button>\n  </div>\n</mat-dialog-content>"

/***/ }),

/***/ "./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.scss":
/*!*****************************************************************************************************!*\
  !*** ./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.scss ***!
  \*****************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "th {\n  text-align: center; }\n\ntd {\n  text-align: center; }\n\n.pomeri-dole {\n  margin-top: 20px; }\n\nh3 {\n  color: #273747;\n  text-align: center;\n  display: inline; }\n\n.header {\n  height: 3em;\n  text-align: center; }\n"

/***/ }),

/***/ "./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.ts":
/*!***************************************************************************************************!*\
  !*** ./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.ts ***!
  \***************************************************************************************************/
/*! exports provided: NeuspesnoPorucivanjeModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NeuspesnoPorucivanjeModalComponent", function() { return NeuspesnoPorucivanjeModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var src_app_e_shop_model_porudzbenica__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/e-shop/model/porudzbenica */ "./src/app/e-shop/model/porudzbenica.ts");
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



var NeuspesnoPorucivanjeModalComponent = /** @class */ (function () {
    function NeuspesnoPorucivanjeModalComponent(dialogRef, data) {
        this.dialogRef = dialogRef;
        this.data = data;
        this.robaPromena = [];
        this.displayedColumns = ['katBr', 'trazeno', 'raspolozivo'];
        this.dataSource = [];
    }
    NeuspesnoPorucivanjeModalComponent.prototype.ngOnInit = function () {
        this.fakturaModal = this.data.faktura;
        this.robaModal = this.data.roba;
        this.popuniPromene();
    };
    NeuspesnoPorucivanjeModalComponent.prototype.popuniPromene = function () {
        var _this = this;
        this.robaModal.forEach(function (roba) {
            _this.fakturaModal.detalji.forEach(function (detalji) {
                if (detalji.robaId === roba.robaid) {
                    var robaPromena = new src_app_e_shop_model_porudzbenica__WEBPACK_IMPORTED_MODULE_2__["RobaPromena"]();
                    robaPromena.katbr = roba.katbr;
                    robaPromena.opis = roba.naziv;
                    robaPromena.rapolozivaKolicina = roba.stanje;
                    robaPromena.trazenaKolicina = detalji.kolicina;
                    _this.robaPromena.push(robaPromena);
                }
            });
        });
        this.dataSource = this.robaPromena;
    };
    NeuspesnoPorucivanjeModalComponent.prototype.zatvoriDialog = function () {
        this.dialogRef.close();
    };
    NeuspesnoPorucivanjeModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-neuspesno-porucivanje-modal',
            template: __webpack_require__(/*! ./neuspesno-porucivanje-modal.component.html */ "./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.html"),
            styles: [__webpack_require__(/*! ./neuspesno-porucivanje-modal.component.scss */ "./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.scss")]
        }),
        __param(1, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MAT_DIALOG_DATA"])),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"], Object])
    ], NeuspesnoPorucivanjeModalComponent);
    return NeuspesnoPorucivanjeModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/modal/poruka-modal/poruka-modal.component.html":
/*!***********************************************************************!*\
  !*** ./src/app/shared/modal/poruka-modal/poruka-modal.component.html ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-dialog-content>\n  <section *ngIf=\"!porukaPoslata && !ucitavanje\">\n    <div class=\"header\">\n      <h1>Pošalji poruku</h1>\n      <button type=\"button\" class=\"close\" (click)=\"zatvoriDialog()\">\n        <span aria-hidden=\"true\">&times;</span>\n      </button>\n    </div>\n    <form role=\"form\" [formGroup]=\"porukaForm\">\n      <div class=\"forma-poruke\">\n        <table cellspacing=\"0\">\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <input matInput formControlName=\"ime\" placeholder=\"Ime\">\n              </mat-form-field>\n            </td>\n          </tr>\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <input matInput formControlName=\"prezime\" placeholder=\"Prezime\">\n              </mat-form-field>\n            </td>\n          </tr>\n        </table>\n        <table cellspacing=\"0\">\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <input matInput formControlName=\"firma\" placeholder=\"Ima firme\">\n              </mat-form-field>\n            </td>\n          </tr>\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <input matInput type=\"tel\" formControlName=\"telefon\" placeholder=\"Broj telefona\">\n              </mat-form-field>\n            </td>\n          </tr>\n        </table>\n        <div>\n          <mat-form-field class=\"sirina-polja-unosa\">\n            <input matInput type=\"email\" formControlName=\"posta\" placeholder=\"Pošta\">\n          </mat-form-field>\n          <div *ngIf=\"porukaSubmited && p.posta.errors\">\n            <div *ngIf=\"p.posta.errors.required\">\n              <p class=\"upozorenje\">Pošta je obavezna</p>\n            </div>\n            <div *ngIf=\"p.posta.errors.email\">\n              <p class=\"upozorenje\">Pošta nije validna</p>\n            </div>\n          </div>\n        </div>\n        <div>\n          <mat-form-field class=\"sirina-polja-unosa\">\n            <textarea matInput formControlName=\"poruka\" rows=\"6\" placeholder=\"Poruka\"></textarea>\n          </mat-form-field>\n          <div *ngIf=\"porukaSubmited && p.poruka.errors\">\n            <div *ngIf=\"p.poruka.errors.required\">\n              <p class=\"upozorenje\">Poruka je obavezna</p>\n            </div>\n            <div *ngIf=\"p.poruka.errors.minlength\">\n              <p class=\"upozorenje\">Poruka mora imate minimalno 3 karaktera</p>\n            </div>\n          </div>\n        </div>\n        <button mat-flat-button class=\"sirina-polja-unosa\" (click)=\"posaljiPoruku()\" color=\"primary\">Pošalji</button>\n      </div>\n    </form>\n  </section>\n  <section *ngIf=\"porukaPoslata\">\n    <button type=\"button\" class=\"close\" (click)=\"zatvoriDialog()\">\n      <span aria-hidden=\"true\">&times;</span>\n    </button>\n    <p>Poruka je uspešno poslata. Odgovrićemo vam u najkraćem mogućem roku.</p>\n    <div class=\"text-center margin-top--15\">\n      <button mat-flat-button color=\"primary\" (click)=\"zatvoriDialog()\">Zatvori</button>\n    </div>\n  </section>\n</mat-dialog-content>\n<section *ngIf=\"ucitavanje\">\n  <div class=\"d-flex justify-content-center margin-bottom--10 margin-top--10\">\n    <mat-spinner></mat-spinner>\n  </div>\n</section>"

/***/ }),

/***/ "./src/app/shared/modal/poruka-modal/poruka-modal.component.scss":
/*!***********************************************************************!*\
  !*** ./src/app/shared/modal/poruka-modal/poruka-modal.component.scss ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  display: inline;\n  font-size: 1.5em;\n  color: #345cac; }\n\n.sirina-polja-unosa {\n  width: 350px !important; }\n\n.header {\n  height: 3em;\n  padding: 3%;\n  text-align: center; }\n\n@media only screen and (max-device-width: 1025px) {\n  .sirina-polja-unosa {\n    width: 250px !important; } }\n"

/***/ }),

/***/ "./src/app/shared/modal/poruka-modal/poruka-modal.component.ts":
/*!*********************************************************************!*\
  !*** ./src/app/shared/modal/poruka-modal/poruka-modal.component.ts ***!
  \*********************************************************************/
/*! exports provided: PorukaModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PorukaModalComponent", function() { return PorukaModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_e_commerce_model_dto__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/e-commerce/model/dto */ "./src/app/e-commerce/model/dto.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_shared_service_email_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/shared/service/email.service */ "./src/app/shared/service/email.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _service_notifikacija_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../service/notifikacija.service */ "./src/app/shared/service/notifikacija.service.ts");
/* harmony import */ var _model_konstante__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../model/konstante */ "./src/app/shared/model/konstante.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var PorukaModalComponent = /** @class */ (function () {
    function PorukaModalComponent(dialogRef, formBuilder, emailServis, notifikacijaServis) {
        this.dialogRef = dialogRef;
        this.formBuilder = formBuilder;
        this.emailServis = emailServis;
        this.notifikacijaServis = notifikacijaServis;
        this.porukaSubmited = false;
        this.porukaPoslata = false;
        this.alive = true;
        this.ucitavanje = false;
    }
    PorukaModalComponent.prototype.ngOnInit = function () {
        this.inicijalizujForme();
    };
    PorukaModalComponent.prototype.inicijalizujForme = function () {
        this.porukaForm = this.formBuilder.group({
            ime: [''],
            prezime: [''],
            firma: [''],
            telefon: [''],
            posta: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].email]],
            poruka: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]]
        });
    };
    PorukaModalComponent.prototype.posaljiPoruku = function () {
        var _this = this;
        this.porukaSubmited = true;
        if (this.porukaForm.invalid) {
            return;
        }
        var poruka = this.popuniPoruku();
        this.ucitavanje = true;
        this.emailServis.posaljiPoruku(poruka)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["finalize"])(function () { return _this.ucitavanje = false; })).subscribe(function (res) {
            _this.porukaPoslata = true;
            _this.porukaForm.reset();
            _this.porukaSubmited = false;
            _this.notifikacijaServis.notify('Poruka je uspešno poslata', _model_konstante__WEBPACK_IMPORTED_MODULE_8__["MatSnackBarKlase"].Zelena);
        }, function (error) {
            _this.notifikacijaServis.notify('Došlo je do greške, poruka nije poslata', _model_konstante__WEBPACK_IMPORTED_MODULE_8__["MatSnackBarKlase"].Crvena);
            _this.dialogRef.close();
        });
    };
    PorukaModalComponent.prototype.popuniPoruku = function () {
        var poruka = new src_app_e_commerce_model_dto__WEBPACK_IMPORTED_MODULE_2__["Poruka"]();
        poruka.ime = this.p.ime.value;
        poruka.prezime = this.p.prezime.value;
        poruka.firma = this.p.firma.value;
        poruka.telefon = this.p.telefon.value;
        poruka.posta = this.p.posta.value;
        poruka.poruka = this.p.poruka.value;
        return poruka;
    };
    Object.defineProperty(PorukaModalComponent.prototype, "p", {
        // convenience getter for easy access to form fields
        get: function () { return this.porukaForm.controls; },
        enumerable: true,
        configurable: true
    });
    PorukaModalComponent.prototype.zatvoriDialog = function () {
        this.dialogRef.close();
    };
    PorukaModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-poruka-modal',
            template: __webpack_require__(/*! ./poruka-modal.component.html */ "./src/app/shared/modal/poruka-modal/poruka-modal.component.html"),
            styles: [__webpack_require__(/*! ./poruka-modal.component.scss */ "./src/app/shared/modal/poruka-modal/poruka-modal.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_6__["MatDialogRef"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"],
            src_app_shared_service_email_service__WEBPACK_IMPORTED_MODULE_5__["EmailService"],
            _service_notifikacija_service__WEBPACK_IMPORTED_MODULE_7__["NotifikacijaService"]])
    ], PorukaModalComponent);
    return PorukaModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.html":
/*!***************************************************************************************!*\
  !*** ./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.html ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<section>\n    <mat-horizontal-stepper [linear]=\"true\" #stepper>\n        <mat-step>\n          <form >\n            <ng-template matStepLabel>Obaveštenje</ng-template>\n            <div>\n              <h1>Poštovani</h1>\n              <p>Dobrodošli u internet prodavnicu Automaterijala.</p>\n              <p class=\"margin-top--10\">Da bi Vaš nalog bio kompletno fukncionalan neophodno je da promenite vašu šifru. \n                Klikom na dugme dalje, prelazite na sledeći korak gde možete da ukucate vašu novu šifru.</p>\n            </div>\n            <div class=\"margin-top--15\">\n              <button mat-flat-button color=\"primary\" matStepperNext>Dalje</button>\n            </div>\n          </form>\n        </mat-step>\n        <mat-step [stepControl]=\"promenaSifreForm\">\n          <form [formGroup]=\"promenaSifreForm\" role=\"form\">\n            <ng-template matStepLabel>Promena</ng-template>\n            <h1>Promena šifre</h1>\n            <div class=\"form-group\">\n                <input type=\"password\" #pass1 formControlName=\"pass1\" class=\"form-control rounded\" placeholder=\"Nova šifra\" id=\"pass1\"\n                  name=\"pass1\" />\n                <div *ngIf=\"submitted && r.pass1.errors\">\n                  <div *ngIf=\"r.pass1.errors.required\">\n                    <p class=\"upozorenje\">Šifra je obavezna</p>\n                  </div>\n                  <div *ngIf=\"r.pass1.errors.minlength\">\n                    <p class=\"upozorenje\">Šifra mora imati minimalno 3 karaktera</p>\n                  </div>\n                </div>\n              </div>\n              <div class=\"form-group\">\n                <input type=\"password\" #pass2 formControlName=\"pass2\" class=\"form-control rounded\" placeholder=\"Ponovite šifru\"\n                  id=\"password\" name=\"password\" />\n                <div *ngIf=\"submitted && r.pass2.errors\">\n                  <div *ngIf=\"r.pass2.errors.required\">\n                    <p class=\"upozorenje\">Šifra je obavezna</p>\n                  </div>\n                  <div *ngIf=\"r.pass2.errors.minlength\">\n                    <p class=\"upozorenje\">Šifra mora imati minimalno 3 karaktera</p>\n                  </div>\n                </div>\n                <div *ngIf=\"submitted && !r.pass2.errors && pass1.value != pass2.value\">\n                  <p class=\"upozorenje\">Šifre nisu iste</p>\n                </div>\n              </div>\n            <div>\n              <button mat-flat-button color=\"warm\" matStepperPrevious>Back</button>\n              <button mat-flat-button color=\"primary\" (click)=\"promeniSifru()\" matStepperNext>Next</button>\n            </div>\n          </form>\n        </mat-step>\n        <mat-step>\n          <ng-template matStepLabel>Konačno</ng-template>\n          <div>\n              <h1>Čestitamo</h1>\n              <p>Šifra je uspešno promenjena. Vaš nalog je podešen i aktiviran.</p>\n            </div>\n          <div class=\"d-flex justify-content-center margin-top--15\">\n            <button mat-flat-button color=\"primary\" (click)=\"zatvoriDialog()\" matStepperNext>Zatvori</button>\n          </div>\n        </mat-step>\n      </mat-horizontal-stepper>\n</section>\n"

/***/ }),

/***/ "./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.scss":
/*!***************************************************************************************!*\
  !*** ./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.scss ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  font-size: 1.4em;\n  text-align: center;\n  color: #345cac; }\n\n.upozorenje {\n  text-align: left;\n  font-size: 0.8em;\n  color: red;\n  margin-top: 2px; }\n"

/***/ }),

/***/ "./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.ts":
/*!*************************************************************************************!*\
  !*** ./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.ts ***!
  \*************************************************************************************/
/*! exports provided: PrvoLogovanjeModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PrvoLogovanjeModalComponent", function() { return PrvoLogovanjeModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var src_app_e_shop_service_partner_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/e-shop/service/partner.service */ "./src/app/e-shop/service/partner.service.ts");
/* harmony import */ var src_app_e_shop_model_dto__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/e-shop/model/dto */ "./src/app/e-shop/model/dto.ts");
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
var __param = (undefined && undefined.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};







var PrvoLogovanjeModalComponent = /** @class */ (function () {
    function PrvoLogovanjeModalComponent(dialogRef, partnerServis, formBuilder, data) {
        this.dialogRef = dialogRef;
        this.partnerServis = partnerServis;
        this.formBuilder = formBuilder;
        this.data = data;
        this.submitted = false;
        this.alive = true;
        this.uspesnaPromena = true;
        this.ucitavanje = false;
    }
    PrvoLogovanjeModalComponent.prototype.ngOnInit = function () {
        this.partner = this.data;
        this.inicijalizujForme();
    };
    PrvoLogovanjeModalComponent.prototype.inicijalizujForme = function () {
        this.promenaSifreForm = this.formBuilder.group({
            pass1: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]],
            pass2: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(3)]]
        }, { validator: this.proveriSifre });
    };
    PrvoLogovanjeModalComponent.prototype.proveriSifre = function (group) {
        var pass = group.controls.pass1.value;
        var confirmPass = group.controls.pass2.value;
        return pass === confirmPass ? null : { notSame: true };
    };
    PrvoLogovanjeModalComponent.prototype.promeniSifru = function () {
        this.submitted = true;
        if (this.promenaSifreForm.invalid || this.r.pass1.value !== this.r.pass2.value) {
            return;
        }
        this.pozoviServisIPromeniSifru();
    };
    PrvoLogovanjeModalComponent.prototype.pozoviServisIPromeniSifru = function () {
        var _this = this;
        var dto = this.napraviDto();
        this.partnerServis.promeniSifru(dto, true).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["catchError"])(function (error) {
            if (error.status === 400) {
                _this.uspesnaPromena = false;
                return rxjs__WEBPACK_IMPORTED_MODULE_6__["EMPTY"];
            }
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_6__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["finalize"])(function () { return _this.ucitavanje = false; }))
            .subscribe(function () {
            _this.uspesnaPromena = true;
        }, function () {
            _this.uspesnaPromena = false;
        });
    };
    PrvoLogovanjeModalComponent.prototype.zatvoriDialog = function () {
        this.dialogRef.close();
    };
    PrvoLogovanjeModalComponent.prototype.napraviDto = function () {
        var dto = new src_app_e_shop_model_dto__WEBPACK_IMPORTED_MODULE_4__["PromenaSifre"]();
        dto.sifra = this.r.pass1.value;
        dto.ponovljenjaSifra = this.r.pass2.value;
        dto.ppid = 933;
        return dto;
    };
    Object.defineProperty(PrvoLogovanjeModalComponent.prototype, "r", {
        get: function () { return this.promenaSifreForm.controls; },
        enumerable: true,
        configurable: true
    });
    PrvoLogovanjeModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-prvo-logovanje-modal',
            template: __webpack_require__(/*! ./prvo-logovanje-modal.component.html */ "./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.html"),
            styles: [__webpack_require__(/*! ./prvo-logovanje-modal.component.scss */ "./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.scss")]
        }),
        __param(3, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_2__["MAT_DIALOG_DATA"])),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogRef"],
            src_app_e_shop_service_partner_service__WEBPACK_IMPORTED_MODULE_3__["PartnerService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"], Object])
    ], PrvoLogovanjeModalComponent);
    return PrvoLogovanjeModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/modal/registracija-modal/registracija-modal.component.html":
/*!***********************************************************************************!*\
  !*** ./src/app/shared/modal/registracija-modal/registracija-modal.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-dialog-content>\n  <main>\n    <div class=\"modal-naslov\">\n      <h1 class=\"h1-modal-naslov\">Registracija</h1>\n      <button type=\"button\" class=\"close\" (click)=\"zatvoriDialog()\">\n        <span aria-hidden=\"true\">&times;</span>\n      </button>\n    </div>\n    <mat-horizontal-stepper [linear]=\"true\" #stepper>\n      <mat-step>\n        <ng-template matStepLabel>Vrsta</ng-template>\n        <mat-radio-group class=\"radio-group\" [(ngModel)]=\"vrstaRegistracije\">\n          <mat-radio-button color=\"primary\" *ngFor=\"let registracija of registracije\" [value]=\"registracija\">\n            {{registracija}}\n          </mat-radio-button>\n        </mat-radio-group>\n        <div>\n          <button mat-button class=\"boja-glavna-100\" (click)=\"odrediFormu()\" matStepperNext>Dalje</button>\n        </div>\n      </mat-step>\n      <mat-step [stepControl]=\"odredjenaForma\">\n        <ng-template matStepLabel>Forma</ng-template>\n        <form role=\"form\" [formGroup]=\"privatnoLiceForm\" *ngIf=\"vrstaRegistracije == registracije[0]\">\n          <mat-form-field class=\"puna-duzina\">\n            <input #imeIPrezime formControlName=\"imeIPrezime\" matInput placeholder=\"Ime i prezime\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && privatno.imeIPrezime.errors\">\n            <div *ngIf=\"privatno.imeIPrezime.errors.required\">\n              <p class=\"upozorenje\">Ime i prezime je obavezno</p>\n            </div>\n            <div *ngIf=\"privatno.imeIPrezime.errors.minlength\">\n              <p class=\"upozorenje\">Ime i prezime mora imati minimalno 3 karaktera</p>\n            </div>\n          </div>\n\n          <mat-form-field class=\"puna-duzina\">\n            <input #grad formControlName=\"grad\" matInput placeholder=\"Grad\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && privatno.grad.errors\">\n            <div *ngIf=\"privatno.grad.errors.required\">\n              <p class=\"upozorenje\">Naziv grada je obavezan</p>\n            </div>\n            <div *ngIf=\"privatno.grad.errors.minlength\">\n              <p class=\"upozorenje\">Grad mora imati minimalno 2 karaktera</p>\n            </div>\n          </div>\n\n          <mat-form-field class=\"puna-duzina\">\n            <input #adresa formControlName=\"adresa\" matInput placeholder=\"Adresa\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && privatno.adresa.errors\">\n            <div *ngIf=\"privatno.adresa.errors.required\">\n              <p class=\"upozorenje\">Adresa je obavezna</p>\n            </div>\n            <div *ngIf=\"privatno.adresa.errors.minlength\">\n              <p class=\"upozorenje\">Adresa mora imati minimalno 3 karaktera</p>\n            </div>\n          </div>\n\n          <mat-form-field class=\"puna-duzina\">\n            <input #email formControlName=\"email\" matInput type=\"email\" placeholder=\"Email\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && privatno.email.errors\">\n            <div *ngIf=\"privatno.email.errors.required\">\n              <p class=\"upozorenje\">Email je obavezan</p>\n            </div>\n            <div *ngIf=\"privatno.email.errors.email\">\n              <p class=\"upozorenje\">Email nije validan</p>\n            </div>\n          </div>\n\n          <mat-form-field class=\"puna-duzina\">\n            <input #kontaktTelefon formControlName=\"kontaktTelefon\" matInput type=\"tel\" placeholder=\"Broj telefona\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && privatno.kontaktTelefon.errors\">\n            <div *ngIf=\"privatno.kontaktTelefon.errors.required\">\n              <p class=\"upozorenje\">Broj telefona je obavezan</p>\n            </div>\n            <div *ngIf=\"privatno.kontaktTelefon.errors.minlength\">\n              <p class=\"upozorenje\">Broj telefona mora imati vise od 5 karakera</p>\n            </div>\n          </div>\n\n        </form>\n        <form role=\"form\" [formGroup]=\"parvnoLiceForm\" *ngIf=\"vrstaRegistracije == registracije[1]\">\n          <mat-form-field class=\"puna-duzina\">\n            <input #grad formControlName=\"nazivFirme\" matInput placeholder=\"Naziv firme\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && pravno.nazivFirme.errors\">\n            <div *ngIf=\"pravno.nazivFirme.errors.required\">\n              <p class=\"upozorenje\">Naziv firme je obavezan</p>\n            </div>\n            <div *ngIf=\"pravno.nazivFirme.errors.minlength\">\n              <p class=\"upozorenje\">Ime i prezime mora imati minimalno 3 karaktera</p>\n            </div>\n          </div>\n          <mat-form-field class=\"puna-duzina\">\n            <input #pib formControlName=\"pib\" matInput placeholder=\"Pib\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && pravno.pib.errors\">\n            <div *ngIf=\"pravno.pib.errors.required\">\n              <p class=\"upozorenje\">Pib je obavezan</p>\n            </div>\n            <div *ngIf=\"pravno.pib.errors.minlength\">\n              <p class=\"upozorenje\">Pib mora imati minimalno 3 karaktera</p>\n            </div>\n          </div>\n\n          <mat-form-field class=\"puna-duzina\">\n            <input #grad formControlName=\"grad\" matInput placeholder=\"Grad\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && pravno.grad.errors\">\n            <div *ngIf=\"pravno.grad.errors.required\">\n              <p class=\"upozorenje\">Naziv grada je obavezan</p>\n            </div>\n            <div *ngIf=\"pravno.grad.errors.minlength\">\n              <p class=\"upozorenje\">Grad mora imati minimalno 2 karaktera</p>\n            </div>\n          </div>\n\n          <mat-form-field class=\"puna-duzina\">\n            <input #adresa formControlName=\"adresa\" matInput placeholder=\"Adresa\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && pravno.adresa.errors\">\n            <div *ngIf=\"pravno.adresa.errors.required\">\n              <p class=\"upozorenje\">Adresa je obavezna</p>\n            </div>\n            <div *ngIf=\"pravno.adresa.errors.minlength\">\n              <p class=\"upozorenje\">Adresa mora imati minimalno 3 karaktera</p>\n            </div>\n          </div>\n\n          <mat-form-field class=\"puna-duzina\">\n            <input #email formControlName=\"email\" matInput type=\"email\" placeholder=\"Email\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && pravno.email.errors\">\n            <div *ngIf=\"pravno.email.errors.required\">\n              <p class=\"upozorenje\">Email je obavezan</p>\n            </div>\n            <div *ngIf=\"pravno.email.errors.email\">\n              <p class=\"upozorenje\">Email nije validan</p>\n            </div>\n          </div>\n          <mat-form-field class=\"puna-duzina\">\n            <input #kontaktTelefon formControlName=\"kontaktTelefon\" matInput type=\"tel\" placeholder=\"Broj telefona\">\n          </mat-form-field>\n          <div *ngIf=\"formaSubmited && pravno.kontaktTelefon.errors\">\n            <div *ngIf=\"pravno.kontaktTelefon.errors.required\">\n              <p class=\"upozorenje\">Telefon je obavezan</p>\n            </div>\n            <div *ngIf=\"pravno.kontaktTelefon.errors.minlength\">\n              <p class=\"upozorenje\">>Telefon mora imati minimalno 5 karaktera</p>\n            </div>\n          </div>\n        </form>\n        <div>\n          <button mat-button matStepperPrevious>Nazad</button>\n          <button mat-button class=\"boja-glavna-100\" (click)=\"registracijaKorisnika()\" matStepperNext>Registruj\n            se</button>\n        </div>\n      </mat-step>\n      <mat-step>\n        <ng-template matStepLabel>Uspešno</ng-template>\n        <h3>Registracija je uspešno poslata</h3>\n        <p> U narednih 24h vaš zahtev će biti obradjen i dobićete mail sa detaljima vašeg naloga.</p>\n        <div>\n          <button mat-button class=\"boja-glavna-100\" (click)=\"zatvoriDialog()\">Zatvori</button>\n        </div>\n      </mat-step>\n    </mat-horizontal-stepper>\n  </main>\n</mat-dialog-content>"

/***/ }),

/***/ "./src/app/shared/modal/registracija-modal/registracija-modal.component.scss":
/*!***********************************************************************************!*\
  !*** ./src/app/shared/modal/registracija-modal/registracija-modal.component.scss ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h3 {\n  font-size: 1.2em;\n  font-weight: bold; }\n\n.radio-group {\n  display: inline-flex;\n  flex-direction: column; }\n\n.puna-duzina {\n  width: 100%; }\n"

/***/ }),

/***/ "./src/app/shared/modal/registracija-modal/registracija-modal.component.ts":
/*!*********************************************************************************!*\
  !*** ./src/app/shared/modal/registracija-modal/registracija-modal.component.ts ***!
  \*********************************************************************************/
/*! exports provided: RegistracijaModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RegistracijaModalComponent", function() { return RegistracijaModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_e_shop_model_dto__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/e-shop/model/dto */ "./src/app/e-shop/model/dto.ts");
/* harmony import */ var src_app_shared_service_email_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/shared/service/email.service */ "./src/app/shared/service/email.service.ts");
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
        this.registracija = new src_app_e_shop_model_dto__WEBPACK_IMPORTED_MODULE_5__["Registracija"]();
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
        this.odredjenaForma = this.parvnoLiceForm;
    };
    RegistracijaModalComponent.prototype.registracijaKorisnika = function () {
        var _this = this;
        this.formaSubmited = true;
        if (this.vrstaRegistracije === this.registracije[0]) {
            if (this.privatnoLiceForm.invalid) {
                return;
            }
            else {
                this.registracija = new src_app_e_shop_model_dto__WEBPACK_IMPORTED_MODULE_5__["Registracija"]();
                this.popuniRegistracijuZaPrivatnaLica();
            }
        }
        else {
            if (this.parvnoLiceForm.invalid) {
                return;
            }
            else {
                this.registracija = new src_app_e_shop_model_dto__WEBPACK_IMPORTED_MODULE_5__["Registracija"]();
                this.popuniRegistracijuZaPravnaLica();
            }
        }
        this.emailService.posaljiMailZaRegistraciju(this.registracija).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["finalize"])(function () { return _this.ucitavanje = false; })).subscribe(function (res) {
        }, function (error) {
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
            template: __webpack_require__(/*! ./registracija-modal.component.html */ "./src/app/shared/modal/registracija-modal/registracija-modal.component.html"),
            styles: [__webpack_require__(/*! ./registracija-modal.component.scss */ "./src/app/shared/modal/registracija-modal/registracija-modal.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogRef"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"],
            src_app_shared_service_email_service__WEBPACK_IMPORTED_MODULE_6__["EmailService"]])
    ], RegistracijaModalComponent);
    return RegistracijaModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.html":
/*!***************************************************************************************!*\
  !*** ./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.html ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"header\">\n  <h3>Poštovani</h3>\n  <button type=\"button\" class=\"close\" (click)=\"zatvoriDialog()\">\n    <span aria-hidden=\"true\">&times;</span>\n  </button>\n</div>\n<p>Vaša sesija je istekla. Molimo ulogujte se ponovo.</p>\n<div class=\"d-flex justify-content-center margin-top--10\">\n  <button mat-raised-button color=\"primary\" (click)=\"zatvoriDialog()\">Zatvori</button>\n</div>"

/***/ }),

/***/ "./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.scss":
/*!***************************************************************************************!*\
  !*** ./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.scss ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".header {\n  height: 3em;\n  padding: 3%;\n  text-align: center; }\n\nh3 {\n  display: inline;\n  color: #345cac; }\n"

/***/ }),

/***/ "./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.ts":
/*!*************************************************************************************!*\
  !*** ./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.ts ***!
  \*************************************************************************************/
/*! exports provided: SesijaIsteklaModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SesijaIsteklaModalComponent", function() { return SesijaIsteklaModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var SesijaIsteklaModalComponent = /** @class */ (function () {
    function SesijaIsteklaModalComponent(dialogRef) {
        this.dialogRef = dialogRef;
    }
    SesijaIsteklaModalComponent.prototype.ngOnInit = function () {
    };
    SesijaIsteklaModalComponent.prototype.zatvoriDialog = function () {
        this.dialogRef.close();
    };
    SesijaIsteklaModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-sesija-istekla-modal',
            template: __webpack_require__(/*! ./sesija-istekla-modal.component.html */ "./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.html"),
            styles: [__webpack_require__(/*! ./sesija-istekla-modal.component.scss */ "./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"]])
    ], SesijaIsteklaModalComponent);
    return SesijaIsteklaModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/modal/upit-modal/upit-modal.component.html":
/*!*******************************************************************!*\
  !*** ./src/app/shared/modal/upit-modal/upit-modal.component.html ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-dialog-content *ngIf=\"!ucitavanje\">\n  <section *ngIf=\"!porukaJePoslata\">\n    <div class=\"header\">\n      <h1>Pošalji upit</h1>\n      <button type=\"button\" class=\"close\" (click)=\"zatvoriUpitDialog()\">\n        <span aria-hidden=\"true\">&times;</span>\n      </button>\n    </div>\n    <form role=\"form\" [formGroup]=\"upitForm\">\n      <div class=\"forma-poruke\">\n        <table cellspacing=\"0\">\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <input matInput formControlName=\"email_telefon\" placeholder=\"Vaš email ili broj telefona\">\n              </mat-form-field>\n              <div *ngIf=\"upitSubmited && u.email_telefon.errors\">\n                <div *ngIf=\"u.email_telefon.errors.required\">\n                  <p class=\"upozorenje\">Email ili telefon je obavezan</p>\n                </div>\n              </div>\n            </td>\n          </tr>\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <input matInput formControlName=\"marka_model\" placeholder=\"Marka i model automobila - (Fiat Punto)\">\n              </mat-form-field>\n              <div *ngIf=\"upitSubmited && u.marka_model.errors\">\n                <div *ngIf=\"u.marka_model.errors.required\">\n                  <p class=\"upozorenje\">Marka и model automobila je obavezan</p>\n                </div>\n              </div>\n            </td>\n          </tr>\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <input matInput formControlName=\"godiste\" placeholder=\"Godište\">\n              </mat-form-field>\n              <div *ngIf=\"upitSubmited && u.godiste.errors\">\n                <div *ngIf=\"u.godiste.errors.required\">\n                  <p class=\"upozorenje\">Godište automobila je obavezana</p>\n                </div>\n              </div>\n            </td>\n          </tr>\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <input matInput formControlName=\"kubikaza\" placeholder=\"Kubikaža\">\n              </mat-form-field>\n              <div *ngIf=\"upitSubmited && u.kubikaza.errors\">\n                <div *ngIf=\"u.kubikaza.errors.required\">\n                  <p class=\"upozorenje\">Kubikaža automobila je obavezana</p>\n                </div>\n              </div>\n            </td>\n          </tr>\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <input matInput formControlName=\"kilovati\" placeholder=\"Kilovati\">\n              </mat-form-field>\n              <div *ngIf=\"upitSubmited && u.kilovati.errors\">\n                <div *ngIf=\"u.kilovati.errors.required\">\n                  <p class=\"upozorenje\">Broj kilovata automobila je obavezan</p>\n                </div>\n              </div>\n            </td>\n          </tr>\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <mat-select placeholder=\"Izaberite vrstu goriva\" formControlName=\"gorivo\" name=\"gorivo\" multiple>\n                  <mat-option *ngFor=\"let gor of gorivo\" [value]=\"gor\">\n                    {{gor}}\n                  </mat-option>\n                </mat-select>\n              </mat-form-field>\n              <div *ngIf=\"upitSubmited && u.gorivo.errors\">\n                <div *ngIf=\"u.gorivo.errors.required\">\n                  <p class=\"upozorenje\">Vrsta goriva je obavezna</p>\n                </div>\n              </div>\n            </td>\n          </tr>\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <mat-select placeholder=\"Izaberite vrstu pogona automobila\" formControlName=\"pogon\" name=\"pogon\"\n                  multiple>\n                  <mat-option *ngFor=\"let pogon of pogoni\" [value]=\"pogon\">\n                    {{pogon}}\n                  </mat-option>\n                </mat-select>\n              </mat-form-field>\n              <div *ngIf=\"upitSubmited && u.pogon.errors\">\n                <div *ngIf=\"u.pogon.errors.required\">\n                  <p class=\"upozorenje\">Vrsta pogona automobila je obavezna</p>\n                </div>\n              </div>\n            </td>\n          </tr>\n          <tr>\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <mat-select placeholder=\"Izaberite šta vas interesuje\" formControlName=\"interesuje_me\" name=\"gorivo\"\n                  multiple>\n                  <mat-option *ngFor=\"let ponuda of ponude\" [value]=\"ponuda\">\n                    {{ponuda}}\n                  </mat-option>\n                </mat-select>\n              </mat-form-field>\n              <div *ngIf=\"upitSubmited && u.interesuje_me.errors\">\n                <div *ngIf=\"u.interesuje_me.errors.required\">\n                  <p class=\"upozorenje\">Morate izabrati bar jednu opciju</p>\n                </div>\n              </div>\n            </td>\n          </tr>\n          <tr *ngIf=\"daLiJeObelezenoDrugo()\">\n            <td>\n              <mat-form-field class=\"sirina-polja-unosa\">\n                <textarea matInput class=\"visina-textarea\" formControlName=\"drugo\"\n                  placeholder=\"Interesuje me...\"></textarea>\n              </mat-form-field>\n            </td>\n          </tr>\n        </table>\n        <button mat-flat-button class=\"sirina-polja-unosa\" (click)=\"posaljiUpit()\" color=\"primary\">Pošalji</button>\n      </div>\n    </form>\n  </section>\n  <section *ngIf=\"porukaJePoslata\">\n    <p>Ukoro ćemo obraditi vaš upit i odgovoriti vam u najkraćem mogućem roku. Hvala na poverenju.</p>\n    <div class=\"text-center\">\n      <button mat-flat-button class=\"zatvori-button\"color=\"primary\" (click)=\"zatvoriUpitDialog()\">Zatvori</button>\n    </div>\n  </section>\n</mat-dialog-content>\n<section *ngIf=\"ucitavanje\">\n  <div class=\"d-flex justify-content-center margin-bottom--10 margin-top--10\">\n    <mat-spinner></mat-spinner>\n  </div>\n</section>"

/***/ }),

/***/ "./src/app/shared/modal/upit-modal/upit-modal.component.scss":
/*!*******************************************************************!*\
  !*** ./src/app/shared/modal/upit-modal/upit-modal.component.scss ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  display: inline;\n  font-size: 1.5em;\n  color: #345cac; }\n\n.sirina-polja-unosa {\n  width: 350px !important; }\n\n.header {\n  height: 3em;\n  padding: 3%;\n  text-align: center; }\n\n.visina-textarea {\n  height: 150px; }\n\n.mat-dialog-content {\n  max-height: 90vh; }\n\n.zatvori-button {\n  margin-top: 15px; }\n\n@media only screen and (max-device-width: 1025px) {\n  .sirina-polja-unosa {\n    width: 250px !important; } }\n"

/***/ }),

/***/ "./src/app/shared/modal/upit-modal/upit-modal.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/shared/modal/upit-modal/upit-modal.component.ts ***!
  \*****************************************************************/
/*! exports provided: UpitModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UpitModalComponent", function() { return UpitModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_e_commerce_model_dto__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/e-commerce/model/dto */ "./src/app/e-commerce/model/dto.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var src_app_shared_service_email_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/shared/service/email.service */ "./src/app/shared/service/email.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _service_notifikacija_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../service/notifikacija.service */ "./src/app/shared/service/notifikacija.service.ts");
/* harmony import */ var _model_konstante__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../model/konstante */ "./src/app/shared/model/konstante.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









var UpitModalComponent = /** @class */ (function () {
    function UpitModalComponent(dialogRef, formBuilder, emailServis, notifikacijaServis) {
        this.dialogRef = dialogRef;
        this.formBuilder = formBuilder;
        this.emailServis = emailServis;
        this.notifikacijaServis = notifikacijaServis;
        this.upitSubmited = false;
        this.porukaJePoslata = false;
        this.alive = true;
        this.ucitavanje = false;
        this.pogoni = [
            '2WD',
            '4WD'
        ];
        this.gorivo = [
            'Benzin', 'Dizel', 'Benzin+Gas(TNG)',
            'Metan CNG', 'Električni pogon', 'Električni pogon', 'Hibridni pogon'
        ];
        this.ponude = [
            'Mali servis', 'Veliki servis', 'Prednje kočnice',
            'Zadnje kočnice', 'Set kvačila', 'Zamajac', 'Drugo'
        ];
    }
    UpitModalComponent.prototype.ngOnInit = function () {
        this.inicijalizujForme();
    };
    UpitModalComponent.prototype.inicijalizujForme = function () {
        this.upitForm = this.formBuilder.group({
            marka_model: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]],
            godiste: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]],
            kubikaza: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]],
            kilovati: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]],
            gorivo: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]],
            pogon: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]],
            interesuje_me: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]],
            email_telefon: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]],
            drugo: ['']
        });
    };
    UpitModalComponent.prototype.posaljiUpit = function () {
        var _this = this;
        this.upitSubmited = true;
        if (this.upitForm.invalid) {
            return;
        }
        var upit = this.popuniUpit();
        this.ucitavanje = true;
        this.emailServis.posaljiUpit(upit)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_6__["throwError"])(error); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["finalize"])(function () { return _this.ucitavanje = false; })).subscribe(function (res) {
            _this.upitForm.reset();
            _this.upitSubmited = false;
            _this.porukaJePoslata = true;
            _this.notifikacijaServis.notify('Upit je uspešno poslat', _model_konstante__WEBPACK_IMPORTED_MODULE_8__["MatSnackBarKlase"].Plava);
        }, function (error) {
            _this.notifikacijaServis.notify('Došlo je do greške, upit nije poslat', _model_konstante__WEBPACK_IMPORTED_MODULE_8__["MatSnackBarKlase"].Crvena);
            _this.dialogRef.close();
        });
    };
    UpitModalComponent.prototype.popuniUpit = function () {
        var upit = new src_app_e_commerce_model_dto__WEBPACK_IMPORTED_MODULE_1__["Upit"]();
        upit.emailTelefon = this.u.email_telefon.value;
        upit.markaModel = this.u.marka_model.value;
        upit.godiste = this.u.godiste.value;
        upit.kubikaza = this.u.kubikaza.value;
        upit.kilovati = this.u.kilovati.value;
        upit.gorivo = this.u.gorivo.value;
        upit.pogon = this.u.pogon.value;
        upit.interesujeMe = this.u.interesuje_me.value;
        if (this.u.drugo.value) {
            upit.drugo = this.u.drugo.value;
        }
        return upit;
    };
    Object.defineProperty(UpitModalComponent.prototype, "u", {
        // convenience getter for easy access to form fields
        get: function () { return this.upitForm.controls; },
        enumerable: true,
        configurable: true
    });
    UpitModalComponent.prototype.daLiJeObelezenoDrugo = function () {
        var interesujeMe = this.u.interesuje_me.value;
        return interesujeMe.includes('Drugo');
    };
    UpitModalComponent.prototype.zatvoriUpitDialog = function () {
        this.dialogRef.close();
    };
    UpitModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-upit-modal',
            template: __webpack_require__(/*! ./upit-modal.component.html */ "./src/app/shared/modal/upit-modal/upit-modal.component.html"),
            styles: [__webpack_require__(/*! ./upit-modal.component.scss */ "./src/app/shared/modal/upit-modal/upit-modal.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_3__["MatDialogRef"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            src_app_shared_service_email_service__WEBPACK_IMPORTED_MODULE_4__["EmailService"],
            _service_notifikacija_service__WEBPACK_IMPORTED_MODULE_7__["NotifikacijaService"]])
    ], UpitModalComponent);
    return UpitModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.html":
/*!*************************************************************************************************!*\
  !*** ./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.html ***!
  \*************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n  <main class=\"text-center\">\r\n      <p>Porudžbina je uspešno poslata i uskoro će biti obradjena.</p>\r\n    <div class=\"d-flex flex-row justify-content-center\">\r\n      <button mat-raised-button class=\"button-glavni-100 pomeri\" (click)=\"zatvori()\">Zatvori</button>\r\n      </div>\r\n  </main>\r\n</div>"

/***/ }),

/***/ "./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.scss":
/*!*************************************************************************************************!*\
  !*** ./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.scss ***!
  \*************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".pomeri {\n  margin-top: 15px; }\n"

/***/ }),

/***/ "./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.ts":
/*!***********************************************************************************************!*\
  !*** ./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.ts ***!
  \***********************************************************************************************/
/*! exports provided: UspesnoPorucivanjeModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UspesnoPorucivanjeModalComponent", function() { return UspesnoPorucivanjeModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var UspesnoPorucivanjeModalComponent = /** @class */ (function () {
    function UspesnoPorucivanjeModalComponent(dialogRef) {
        this.dialogRef = dialogRef;
    }
    UspesnoPorucivanjeModalComponent.prototype.ngOnInit = function () {
    };
    UspesnoPorucivanjeModalComponent.prototype.zatvori = function () {
        this.dialogRef.close();
    };
    UspesnoPorucivanjeModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-uspesno-porucivanje-modal',
            template: __webpack_require__(/*! ./uspesno-porucivanje-modal.component.html */ "./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.html"),
            styles: [__webpack_require__(/*! ./uspesno-porucivanje-modal.component.scss */ "./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"]])
    ], UspesnoPorucivanjeModalComponent);
    return UspesnoPorucivanjeModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.html":
/*!***********************************************************************************************!*\
  !*** ./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.html ***!
  \***********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-dialog-content *ngIf=\"!ucitavanje\">\n  <main>\n    <div class=\"modal-naslov\">\n      <button type=\"button\" class=\"close\" (click)=\"zatvoriDialog()\">\n        <span aria-hidden=\"true\">&times;</span>\n      </button>\n    </div>\n    <section *ngIf=\"!mailUspesnoPoslat\">\n      <h1>Pronađi svoj Automaterijal nalog</h1>\n      <p>Unesi svoju e-mail ili korisničko ime</p>\n      <form role=\"form\" [formGroup]=\"zaboravljeSifraForma\">\n        <mat-form-field class=\"email-input\">\n          <input #email formControlName=\"email\" matInput type=\"email\" placeholder=\"E-mail ili korisničko ime\">\n        </mat-form-field>\n        <div *ngIf=\"formaSubmited && zaboravljeno.email.errors\">\n          <div *ngIf=\"zaboravljeno.email.errors.required\">\n            <p class=\"upozorenje\">Podatak je obavezan</p>\n          </div>\n          <div *ngIf=\"zaboravljeno.email.errors.minlength\">\n            <p class=\"upozorenje\">Podatak mora da ima vise od 3 karaktera</p>\n          </div>\n        </div>\n        <div class=\"pomeri-dole\">\n          <button mat-raised-button (click)=\"posaljiMailZaboravljenaSifra()\" class=\"button-glavni-100\">Potvrdi</button>\n        </div>\n      </form>\n    </section>\n    <section *ngIf=\"mailUspesnoPoslat\">\n      <h1>Mail uspešno poslat</h1>\n      <p>Uskoro će vam stići mail sa linkom gde možete promeniti vašu šifru.</p>\n      <div class=\"pomeri-dole\">\n        <button mat-raised-button (click)=\"zatvoriDialog()\" class=\"button-glavni-100\">Zatvori</button>\n      </div>\n    </section>\n  </main>\n</mat-dialog-content>\n<section *ngIf=\"ucitavanje\">\n  <div class=\"d-flex justify-content-center margin-bottom--10 margin-top--10\">\n    <mat-spinner></mat-spinner>\n  </div>\n</section>"

/***/ }),

/***/ "./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.scss":
/*!***********************************************************************************************!*\
  !*** ./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.scss ***!
  \***********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  color: #273747 !important;\n  font-size: 1.1em;\n  font-weight: bold;\n  margin-bottom: 25px; }\n\np {\n  margin-bottom: 0.5em; }\n\n.email-input {\n  width: 80%; }\n\n.pomeri-dole {\n  margin-top: 0.5em; }\n"

/***/ }),

/***/ "./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.ts":
/*!*********************************************************************************************!*\
  !*** ./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.ts ***!
  \*********************************************************************************************/
/*! exports provided: ZaboravljenaSifraModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ZaboravljenaSifraModalComponent", function() { return ZaboravljenaSifraModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var src_app_shared_service_email_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/shared/service/email.service */ "./src/app/shared/service/email.service.ts");
/* harmony import */ var src_app_e_shop_model_dto__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/e-shop/model/dto */ "./src/app/e-shop/model/dto.ts");
/* harmony import */ var _service_notifikacija_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../service/notifikacija.service */ "./src/app/shared/service/notifikacija.service.ts");
/* harmony import */ var _model_konstante__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../model/konstante */ "./src/app/shared/model/konstante.ts");
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
    function ZaboravljenaSifraModalComponent(dialogRef, formBuilder, emailService, notifikacijaServis) {
        this.dialogRef = dialogRef;
        this.formBuilder = formBuilder;
        this.emailService = emailService;
        this.notifikacijaServis = notifikacijaServis;
        this.resetSifre = new src_app_e_shop_model_dto__WEBPACK_IMPORTED_MODULE_6__["ResetSifre"]();
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
            email: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].minLength(3)]],
        });
    };
    ZaboravljenaSifraModalComponent.prototype.posaljiMailZaboravljenaSifra = function () {
        var _this = this;
        this.formaSubmited = true;
        if (this.zaboravljeSifraForma.invalid) {
            return;
        }
        this.ucitavanje = true;
        this.resetSifre.email = this.zaboravljeno.email.value;
        this.emailService
            .posaljiMailZaResetovanjeSifre(this.resetSifre)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["takeWhile"])(function () { return _this.alive; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) {
            if (error.status === 400 || error.status === 404) {
                var snackPoruka = 'E-mail ili korisničko ime ne postoji u našoj bazi.';
                _this.notifikacijaServis.notify(snackPoruka, _model_konstante__WEBPACK_IMPORTED_MODULE_8__["MatSnackBarKlase"].Crvena);
                return rxjs__WEBPACK_IMPORTED_MODULE_4__["EMPTY"];
            }
            Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["throwError"])(error);
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["finalize"])(function () { return _this.ucitavanje = false; })).subscribe(function (res) {
            _this.mailUspesnoPoslat = true;
        }, function (error) {
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
    ZaboravljenaSifraModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-zaboravljena-sifra-modal',
            template: __webpack_require__(/*! ./zaboravljena-sifra-modal.component.html */ "./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.html"),
            styles: [__webpack_require__(/*! ./zaboravljena-sifra-modal.component.scss */ "./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            src_app_shared_service_email_service__WEBPACK_IMPORTED_MODULE_5__["EmailService"],
            _service_notifikacija_service__WEBPACK_IMPORTED_MODULE_7__["NotifikacijaService"]])
    ], ZaboravljenaSifraModalComponent);
    return ZaboravljenaSifraModalComponent;
}());



/***/ }),

/***/ "./src/app/shared/model/konstante.ts":
/*!*******************************************!*\
  !*** ./src/app/shared/model/konstante.ts ***!
  \*******************************************/
/*! exports provided: MatSnackBarKlase */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MatSnackBarKlase", function() { return MatSnackBarKlase; });
var MatSnackBarKlase = /** @class */ (function () {
    function MatSnackBarKlase() {
    }
    MatSnackBarKlase.Zelena = 'green-snackbar';
    MatSnackBarKlase.Plava = 'primary-snackbar';
    MatSnackBarKlase.Crvena = 'red-snackbar';
    return MatSnackBarKlase;
}());



/***/ }),

/***/ "./src/app/shared/pipes/DatePipe.ts":
/*!******************************************!*\
  !*** ./src/app/shared/pipes/DatePipe.ts ***!
  \******************************************/
/*! exports provided: DatePipe */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DatePipe", function() { return DatePipe; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _e_shop_model_konstante__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../e-shop/model/konstante */ "./src/app/e-shop/model/konstante.ts");
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
            value = datumNiz[2] + '-' + datumNiz[1] + '-' + datumNiz[0] + ' ' + datumNVremeiz[1].substr(0, 5);
        }
        return value;
    };
    DatePipe = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Pipe"])({ name: 'datum' })
    ], DatePipe);
    return DatePipe;
}());



/***/ }),

/***/ "./src/app/shared/pipes/EmptyPipe.ts":
/*!*******************************************!*\
  !*** ./src/app/shared/pipes/EmptyPipe.ts ***!
  \*******************************************/
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

/***/ "./src/app/shared/pipes/PrevodilacPipe.ts":
/*!************************************************!*\
  !*** ./src/app/shared/pipes/PrevodilacPipe.ts ***!
  \************************************************/
/*! exports provided: TranslatePipe */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TranslatePipe", function() { return TranslatePipe; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _e_shop_model_konstante__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../e-shop/model/konstante */ "./src/app/e-shop/model/konstante.ts");
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

/***/ "./src/app/shared/service/email.service.ts":
/*!*************************************************!*\
  !*** ./src/app/shared/service/email.service.ts ***!
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
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var DOMAIN_URL = src_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].baseUrl + '/api/email';
var REGISTRACIJA_URL = '/registracija';
var RESETOVANJE_SIFRE_URL = '/zaboravljena-sifra';
var PORUKA_URL = '/poruka';
var UPIT_URL = '/upit';
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
    EmailService.prototype.posaljiPoruku = function (poruka) {
        var fullUrl = DOMAIN_URL + PORUKA_URL;
        return this.http.post(fullUrl, poruka)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error); }));
    };
    EmailService.prototype.posaljiUpit = function (upit) {
        var fullUrl = DOMAIN_URL + UPIT_URL;
        return this.http.post(fullUrl, upit)
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

/***/ "./src/app/shared/service/notifikacija.service.ts":
/*!********************************************************!*\
  !*** ./src/app/shared/service/notifikacija.service.ts ***!
  \********************************************************/
/*! exports provided: NotifikacijaService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NotifikacijaService", function() { return NotifikacijaService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var NotifikacijaService = /** @class */ (function () {
    function NotifikacijaService(snackBar) {
        this.snackBar = snackBar;
    }
    NotifikacijaService.prototype.notify = function (poruka, klasaBoja) {
        this.snackBar.open(poruka, '', {
            duration: 2000,
            panelClass: [klasaBoja]
        });
    };
    NotifikacijaService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]])
    ], NotifikacijaService);
    return NotifikacijaService;
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
    production: false,
    baseUrl: '/automaterijal'
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