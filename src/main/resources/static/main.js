(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"./e-commerce/dasboard/dasboard.module": [
		"./src/app/e-commerce/dasboard/dasboard.module.ts",
		"default~e-commerce-dasboard-dasboard-module~e-commerce-o-nama-o-nama-module",
		"common",
		"e-commerce-dasboard-dasboard-module"
	],
	"./e-commerce/kontakt/kontakt.module": [
		"./src/app/e-commerce/kontakt/kontakt.module.ts",
		"e-commerce-kontakt-kontakt-module"
	],
	"./e-commerce/o-nama/o-nama.module": [
		"./src/app/e-commerce/o-nama/o-nama.module.ts",
		"default~e-commerce-dasboard-dasboard-module~e-commerce-o-nama-o-nama-module",
		"common",
		"e-commerce-o-nama-o-nama-module"
	],
	"./e-shop/faktura/fakture.module": [
		"./src/app/e-shop/faktura/fakture.module.ts",
		"common",
		"e-shop-faktura-fakture-module"
	],
	"./e-shop/korpa/korpa.module": [
		"./src/app/e-shop/korpa/korpa.module.ts",
		"common",
		"e-shop-korpa-korpa-module"
	],
	"./e-shop/login/login.module": [
		"./src/app/e-shop/login/login.module.ts",
		"e-shop-login-login-module"
	],
	"./e-shop/magacin/akumulatori/akumulatori.module": [
		"./src/app/e-shop/magacin/akumulatori/akumulatori.module.ts",
		"common",
		"e-shop-magacin-akumulatori-akumulatori-module"
	],
	"./e-shop/magacin/filteri/filteri.module": [
		"./src/app/e-shop/magacin/filteri/filteri.module.ts",
		"common",
		"e-shop-magacin-filteri-filteri-module"
	],
	"./e-shop/magacin/ostalo/ostalo.module": [
		"./src/app/e-shop/magacin/ostalo/ostalo.module.ts",
		"common",
		"e-shop-magacin-ostalo-ostalo-module"
	],
	"./e-shop/magacin/roba/roba.module": [
		"./src/app/e-shop/magacin/roba/roba.module.ts",
		"common",
		"e-shop-magacin-roba-roba-module"
	],
	"./e-shop/magacin/ulja/ulja.module": [
		"./src/app/e-shop/magacin/ulja/ulja.module.ts",
		"common",
		"e-shop-magacin-ulja-ulja-module"
	],
	"./e-shop/partner/partner.module": [
		"./src/app/e-shop/partner/partner.module.ts",
		"e-shop-partner-partner-module"
	],
	"./e-shop/resetovanje-sfire/reset-sifre.module": [
		"./src/app/e-shop/resetovanje-sfire/reset-sifre.module.ts",
		"e-shop-resetovanje-sfire-reset-sifre-module"
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];
	if(!ids) {
		return Promise.resolve().then(function() {
			var e = new Error("Cannot find module '" + req + "'");
			e.code = 'MODULE_NOT_FOUND';
			throw e;
		});
	}
	return Promise.all(ids.slice(1).map(__webpack_require__.e)).then(function() {
		var id = ids[0];
		return __webpack_require__(id);
	});
}
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
webpackAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";
module.exports = webpackAsyncContext;

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
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var routes = [
    { path: '', redirectTo: '/naslovna', pathMatch: 'full' },
    { path: 'naslovna', loadChildren: './e-commerce/dasboard/dasboard.module#DasboardModule' },
    { path: 'naslovna/:id', loadChildren: './e-commerce/dasboard/dasboard.module#DasboardModule' },
    { path: 'o-nama', loadChildren: './e-commerce/o-nama/o-nama.module#ONamaModule' },
    { path: 'kontakt', loadChildren: './e-commerce/kontakt/kontakt.module#KontaktModule' },
    { path: 'roba', loadChildren: './e-shop/magacin/roba/roba.module#RobaModule' },
    { path: 'filteri', loadChildren: './e-shop/magacin/filteri/filteri.module#FilteriModule' },
    { path: 'ulja', loadChildren: './e-shop/magacin/ulja/ulja.module#UljaModule' },
    { path: 'akumulatori', loadChildren: './e-shop/magacin/akumulatori/akumulatori.module#AkumulatoriModule' },
    { path: 'ostalo', loadChildren: './e-shop/magacin/ostalo/ostalo.module#OstaloModule' },
    { path: 'ostalo/:id', loadChildren: './e-shop/magacin/ostalo/ostalo.module#OstaloModule' },
    { path: 'login', loadChildren: './e-shop/login/login.module#LoginModule' },
    { path: 'licni-podaci', loadChildren: './e-shop/partner/partner.module#PartnerModule' },
    { path: 'porudzbenice', loadChildren: './e-shop/faktura/fakture.module#FaktureModule' },
    { path: 'porudzbenice/:id', loadChildren: './e-shop/faktura/fakture.module#FaktureModule' },
    { path: 'korpa', loadChildren: './e-shop/korpa/korpa.module#KorpaModule' },
    { path: 'reset-sifre/:id', loadChildren: './e-shop/resetovanje-sfire/reset-sifre.module#ResetSifreModule' },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"].forRoot(routes, { useHash: true, scrollPositionRestoration: 'enabled' })],
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
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _shared_modal_modal_module__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./shared/modal/modal.module */ "./src/app/shared/modal/modal.module.ts");
/* harmony import */ var _navigacija_navigacija_module__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./navigacija/navigacija.module */ "./src/app/navigacija/navigacija.module.ts");
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
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _shared_modal_modal_module__WEBPACK_IMPORTED_MODULE_8__["ModalModule"],
                _angular_http__WEBPACK_IMPORTED_MODULE_5__["HttpModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_7__["HttpClientModule"],
                _navigacija_navigacija_module__WEBPACK_IMPORTED_MODULE_9__["NavigacijaModule"],
                angular_webstorage_service__WEBPACK_IMPORTED_MODULE_2__["StorageServiceModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["BrowserAnimationsModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_6__["AppRoutingModule"],
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
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

/***/ "./src/app/e-shop/magacin/shared-components/filter/filter.component.html":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/filter/filter.component.html ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilter\">\n    <div class=\"filter-div-test d-flex flex-column\">\n        <div class=\"d-flex justify-content-center\">\n            <h2>\n                Filter\n            </h2>\n        </div>\n        <div class=\"d-flex flex-column flex-xl-row input-group mb-3\">\n                <div class=\"input-group-prepend\">\n                    <label class=\"input-group-text mobilna-duzina button-glavni-50\" for=\"inputGroupSelect01\">\n                        <p class=\"boja-siva-400\">Proizvodjač: </p>\n                    </label>\n                </div>\n                <select class=\"custom-select mobilna-duzina\" id=\"inputGroupSelect01\" [(ngModel)]=\"filter.proizvodjac\">\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">\n                        {{proizvodjac.naziv}}\n                    </option>\n                </select>\n                <div class=\"input-group-prepend razmak\">\n                    <label class=\"input-group-text mobilna-duzina button-glavni-50\" for=\"inputGroupSelect01\">\n                        Raspoloživost:\n                    </label>\n                </div>\n                <select class=\"custom-select mobilna-duzina\" id=\"inputGroupSelect01\" [(ngModel)]=\"filter.raspolozivost\">\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\n                </select>\n        </div>\n        <div class=\"d-flex justify-content-center\">\n            <div>\n                <button mat-stroked-button class=pozadina-glavna-100 (click)='filtriraj()'>\n                    <p class=\"boja-siva-400\">Filtriraj</p>\n                </button>\n                <span class=\"col-2\"></span>\n                <button mat-stroked-button class=button-crveni-50 (click)='resetujFilter()'>\n                    <p class=\"boja-siva-400\">Poništi</p>\n                </button>\n            </div>\n        </div>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/e-shop/magacin/shared-components/filter/filter.component.scss":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/filter/filter.component.scss ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ":host ::ng-deep .custom-select {\n  padding: 0rem 0rem 0rem 0.5rem !important; }\n\n@media only screen and (max-width: 1200px) {\n  :host ::ng-deep .custom-select {\n    padding: 0px;\n    width: 100%; }\n  .input-group-prepend {\n    display: inline; }\n  select {\n    display: inline; }\n  .razmak {\n    padding: 0px;\n    margin-left: 0px;\n    margin-top: 10px; } }\n"

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

/***/ "./src/app/e-shop/magacin/shared-components/shared-magacin.module.ts":
/*!***************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/shared-magacin.module.ts ***!
  \***************************************************************************/
/*! exports provided: SharedMagacinModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SharedMagacinModule", function() { return SharedMagacinModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _filter_filter_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./filter/filter.component */ "./src/app/e-shop/magacin/shared-components/filter/filter.component.ts");
/* harmony import */ var _tabela_tabela_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./tabela/tabela.component */ "./src/app/e-shop/magacin/shared-components/tabela/tabela.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/shared/material/material.module */ "./src/app/shared/material/material.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};






var SharedMagacinModule = /** @class */ (function () {
    function SharedMagacinModule() {
    }
    SharedMagacinModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__["MaterialModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"]
            ],
            declarations: [
                _filter_filter_component__WEBPACK_IMPORTED_MODULE_2__["FilterComponent"],
                _tabela_tabela_component__WEBPACK_IMPORTED_MODULE_3__["TabelaComponent"]
            ],
            exports: [
                _filter_filter_component__WEBPACK_IMPORTED_MODULE_2__["FilterComponent"],
                _tabela_tabela_component__WEBPACK_IMPORTED_MODULE_3__["TabelaComponent"]
            ]
        })
    ], SharedMagacinModule);
    return SharedMagacinModule;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/shared-components/tabela/tabela.component.html":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/tabela/tabela.component.html ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"tabela-div\" *ngIf=\"dataSource != null && dataSource.length > 0\">\r\n  <p class=\"pdv\"><i>Sve cene su prikazane sa pdv-om.</i></p>\r\n  <table mat-table [dataSource]=\"dataSource\">\r\n    <!-- Kataloski broj Column -->\r\n    <ng-container matColumnDef=\"katbr\">\r\n      <th mat-header-cell *matHeaderCellDef> Kataloški broj </th>\r\n      <td data-label=\"Kataloški broj\" mat-cell *matCellDef=\"let roba\">\r\n        <p class=\"mat-body-2\">\r\n          {{roba.katbr}}\r\n        </p>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Kataloski broj proizvodjaca Column -->\r\n    <ng-container matColumnDef=\"katbrpro\">\r\n      <th mat-header-cell *matHeaderCellDef> Kataloški broj proizvodjača </th>\r\n      <td data-label=\"Kataloški broj proizvodjača\" mat-cell *matCellDef=\"let roba\">\r\n        <p>\r\n          {{roba.katbrpro}}\r\n        </p>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Naziv Column -->\r\n    <ng-container matColumnDef=\"naziv\">\r\n      <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n      <td data-label=\"Naziv\" mat-cell *matCellDef=\"let roba\">\r\n        <p>\r\n          {{roba.naziv}}\r\n        </p>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Proizvodjač Column -->\r\n    <ng-container matColumnDef=\"proizvodjac\">\r\n      <th mat-header-cell *matHeaderCellDef> Proizvodjač </th>\r\n      <td data-label=\"Proizvodjač\" mat-cell *matCellDef=\"let roba\">\r\n        <p class=\"mat-body-2\">\r\n          {{roba.proizvodjac.naziv}}\r\n        </p>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Cena Column -->\r\n    <ng-container matColumnDef=\"cena\">\r\n      <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Cena </th>\r\n      <td data-label=\"Cena\" mat-cell *matCellDef=\"let roba\">\r\n        <p class=\"mat-body-2 text-right iznos-margin\">\r\n          {{roba.cena | currency:\" \"}} RSD\r\n        </p>\r\n      </td>\r\n    </ng-container>\r\n\r\n    <!-- Stanje Column -->\r\n    <ng-container matColumnDef=\"stanje\">\r\n      <th mat-header-cell *matHeaderCellDef class=\"text-center\"> Stanje </th>\r\n      <td data-label=\"Stanje\" mat-cell *matCellDef=\"let roba\">\r\n        <div *ngIf=\"roba.stanje > 0\" class=\"text-center tabela-u-korpi\">\r\n          <mat-icon matTooltip=\"Ima na stanju\" class=\"boja-zelena-50\">check_circle_outline</mat-icon>\r\n        </div>\r\n        <div *ngIf=\"roba.stanje == 0\" class=\"text-center tabela-u-korpi\">\r\n          <mat-icon matTooltip=\"Nema na stanju\" class=\"boja-crvena-50\">remove_circle_outline</mat-icon>\r\n        </div>\r\n      </td>\r\n    </ng-container>\r\n\r\n\r\n    <!-- Kolicina Column -->\r\n    <ng-container matColumnDef=\"kolicina\">\r\n      <th mat-header-cell *matHeaderCellDef>Količina </th>\r\n      <td class=\"visina-div-kolicine\" data-label=\"Količina\" mat-cell *matCellDef=\"let roba\">\r\n        <div *ngIf=\"roba.stanje > 0\">\r\n          <input type=\"number\" min=\"0\" placeholder=\"0\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\"\r\n            [(ngModel)]=\"roba.kolicina\" />\r\n        </div>\r\n    </ng-container>\r\n\r\n    <!-- Kropa dugme Column -->\r\n    <ng-container matColumnDef=\"korpa\">\r\n      <th mat-header-cell *matHeaderCellDef> </th>\r\n      <td class=\"visina-div-dugmeta\" mat-cell *matCellDef=\"let roba\">\r\n        <div class=\"dugme-mobilni\" *ngIf=\"roba.stanje > 0\">\r\n          <button mat-raised-button class=\"velicina-dugmeta button-glavni-100\" (click)='dodajUKorpu(roba)'>Dodaj u\r\n            korpu</button>\r\n        </div>\r\n    </ng-container>\r\n\r\n    <!-- Da li ima na stanju ikona -->\r\n    <ng-container matColumnDef=\"u-korpi\">\r\n      <th mat-header-cell *matHeaderCellDef> </th>\r\n      <td mat-cell *matCellDef=\"let roba\">\r\n        <div class=\"dugme-mobilni\" *ngIf=\"uKorpi(roba.katbr)\">\r\n          <mat-icon matTooltip=\"U korpi\" class=\"tabela-u-korpi boja-crvena-50\">add_shopping_cart</mat-icon>\r\n        </div>\r\n    </ng-container>\r\n\r\n    <tr mat-header-row *matHeaderRowDef=\"getDisplayedColumns()\"></tr>\r\n    <tr mat-row *matRowDef=\"let row; columns: getDisplayedColumns();\"></tr>\r\n  </table>\r\n  <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n    [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n  </mat-paginator>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/magacin/shared-components/tabela/tabela.component.scss":
/*!*******************************************************************************!*\
  !*** ./src/app/e-shop/magacin/shared-components/tabela/tabela.component.scss ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@media screen and (max-width: 900px) {\n  .pdv {\n    float: none; }\n  p {\n    font-size: 0.85em;\n    font-weight: bold; }\n  tr.mat-header-row {\n    height: 0px; } }\n"

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
        window.scroll(0, 0);
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
    LoginService.prototype.izbaciPartneraIzSesiseAkoJeUMemoriji = function () {
        var _this = this;
        this.vratiUlogovanogKorisnika(false)
            .subscribe(function (res) {
            var partner = res;
            if (partner === null) {
                var partnerStorage = _this.storageServis.procitajPartneraIzMemorije();
                if (partnerStorage !== null && partnerStorage.ppid) {
                    _this.izbaciPartnerIzSesije();
                }
            }
        });
    };
    LoginService.prototype.izbaciPartnerIzSesije = function () {
        this.storageServis.logout();
        this.logovanjeSubjekat.next(false);
        this.partnerSubjekat.next(null);
        this.dialog.open(src_app_shared_modal_sesija_istekla_modal_sesija_istekla_modal_component__WEBPACK_IMPORTED_MODULE_9__["SesijaIsteklaModalComponent"], {
            width: '400px'
        });
    };
    LoginService.prototype.logout = function () {
        var _this = this;
        var fullUrl = LOGOUT_URL;
        this.http.post(fullUrl, {}, { responseType: 'text' })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(error); }))
            .subscribe(function () {
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

/***/ "./src/app/footer/footer.module.ts":
/*!*****************************************!*\
  !*** ./src/app/footer/footer.module.ts ***!
  \*****************************************/
/*! exports provided: FooterModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FooterModule", function() { return FooterModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _footer_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./footer.component */ "./src/app/footer/footer.component.ts");
/* harmony import */ var _shared_material_material_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../shared/material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};





var FooterModule = /** @class */ (function () {
    function FooterModule() {
    }
    FooterModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterModule"],
                _shared_material_material_module__WEBPACK_IMPORTED_MODULE_3__["MaterialModule"]
            ],
            declarations: [_footer_component__WEBPACK_IMPORTED_MODULE_2__["FooterComponent"]],
            exports: [_footer_component__WEBPACK_IMPORTED_MODULE_2__["FooterComponent"]]
        })
    ], FooterModule);
    return FooterModule;
}());



/***/ }),

/***/ "./src/app/navigacija/navigacija.component.html":
/*!******************************************************!*\
  !*** ./src/app/navigacija/navigacija.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-sidenav-container class=\"sidenav-container pozadina-siva-400\">\r\n  <mat-sidenav #drawer class=\"sidenav pozadina-glavna-50\" fixedInViewport=\"true\" [mode]=\"openSideNav ? 'over' : 'side'\"\r\n    [opened]=\"!openSideNav\">\r\n    <mat-toolbar *ngIf=\"partnerUlogovan\" class=\"side-toolbar pozadina-glavna-50 header-glavni\">\r\n      <div class=\"d-flex flex-column justify-content-center\">\r\n        <div class=\"d-flex justify-content-center header-sirina\">\r\n          <mat-icon class=\"boja-siva-300\">person</mat-icon>\r\n        </div>\r\n        <div>\r\n          <p class=\"text-center header-navigacija\">{{partner.naziv}}</p>\r\n        </div>\r\n      </div>\r\n    </mat-toolbar>\r\n    <mat-nav-list [class.margin-gore]=\"partnerUlogovan\">\r\n      <mat-divider *ngIf=\"partnerUlogovan\" class=\"pozadina-siva-300\"></mat-divider>\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['naslovna']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>home</mat-icon>\r\n        <p mat-line>Naslovna</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['o-nama']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>book</mat-icon>\r\n        <p mat-line>O nama</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['kontakt']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>contact_phone</mat-icon>\r\n        <p mat-line>Kontakt</p>\r\n      </mat-list-item>\r\n    </mat-nav-list>\r\n\r\n    <mat-divider></mat-divider>\r\n    <mat-nav-list>\r\n      <h3 class=\"pozadina-glavna-50 boja-siva-300\" mat-subheader>Internet prodavnica</h3>\r\n\r\n      <mat-list-item class=\"material-icons\" *ngIf=\"partnerUlogovan\" [routerLink]=\"['korpa']\"\r\n        [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon matBadgeColor=\"warn\" class=\"boja-siva-300\" matBadge=\"{{korpaBadge}}\" mat-list-icon>shopping_cart\r\n        </mat-icon>\r\n        <p mat-line>Korpa</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['roba']\" [routerLinkActive]=\"['pozadina-glavna-200']\"\r\n        [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>searche</mat-icon>\r\n        <p mat-line>Pretraga</p>\r\n      </mat-list-item>\r\n\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['ulja']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>invert_colors</mat-icon>\r\n        <p mat-line>Ulja</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['filteri']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>layers</mat-icon>\r\n        <p mat-line>Filteri</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['akumulatori']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>battery_charging_full</mat-icon>\r\n        <p mat-line>Akumulatori</p>\r\n      </mat-list-item>\r\n\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['ostalo']\" [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>category</mat-icon>\r\n        <p mat-line>Ostalo</p>\r\n      </mat-list-item>\r\n    </mat-nav-list>\r\n\r\n    <mat-divider></mat-divider>\r\n    <mat-nav-list *ngIf=\"partnerUlogovan\">\r\n      <h3 class=\"pozadina-glavna-50 boja-siva-300\" mat-subheader>Moj Profil</h3>\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['licni-podaci']\"\r\n        [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>person</mat-icon>\r\n        <p mat-line>Licni Podaci</p>\r\n      </mat-list-item>\r\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['porudzbenice']\"\r\n        [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>list</mat-icon>\r\n        <p mat-line>Porudzbine</p>\r\n      </mat-list-item>\r\n    </mat-nav-list>\r\n    <mat-divider></mat-divider>\r\n    <mat-nav-list>\r\n      <mat-list-item *ngIf=\"partnerUlogovan === false\" class=\"material-icons\" [routerLink]=\"['login']\"\r\n        [routerLinkActive]=\"['pozadina-glavna-200']\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>exit_to_app</mat-icon>\r\n        <p mat-line>Login</p>\r\n      </mat-list-item>\r\n      <mat-list-item *ngIf=\"partnerUlogovan\" class=\"material-icons\" (click)=\"otvoriDialog()\">\r\n        <mat-icon class=\"boja-siva-300\" mat-list-icon>power_settings_new</mat-icon>\r\n        <p mat-line>Logout</p>\r\n      </mat-list-item>\r\n    </mat-nav-list>\r\n  </mat-sidenav>\r\n  <mat-sidenav-content>\r\n    <mat-toolbar *ngIf=\"openSideNav\" class=\"header-pozicija pozadina-glavna-50\">\r\n      <button type=\"button\" aria-label=\"Toggle sidenav\" mat-icon-button (click)=\"drawer.toggle()\">\r\n        <mat-icon class=\"boja-siva-300\" aria-label=\"Side nav toggle icon\">menu</mat-icon>\r\n      </button>\r\n    </mat-toolbar>\r\n    <div class=\"pozicija\">\r\n      <router-outlet></router-outlet>\r\n    </div>\r\n    <app-footer></app-footer>\r\n  </mat-sidenav-content>\r\n</mat-sidenav-container>"

/***/ }),

/***/ "./src/app/navigacija/navigacija.component.scss":
/*!******************************************************!*\
  !*** ./src/app/navigacija/navigacija.component.scss ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sidenav-container {\n  height: 100%; }\n\n.pozicija {\n  margin: 0 auto;\n  padding-bottom: 220px; }\n\n.sidenav {\n  width: 200px;\n  height: 100%; }\n\n.mat-toolbar.mat-primary {\n  position: -webkit-sticky;\n  position: sticky;\n  top: 0; }\n\n.header-navigacija {\n  font-size: 0.6em !important;\n  width: 200pxpx; }\n\n.header-sirina {\n  width: 200px !important; }\n\np {\n  color: #f6f6f6 !important;\n  height: 18px; }\n\nmat-divider {\n  border-width: 1px;\n  border-style: solid;\n  border-color: #dfe5e7; }\n\n.margin-gore {\n  margin-top: 70px; }\n\n.side-toolbar {\n  height: 75px;\n  width: 200px;\n  padding: 0px 0px !important; }\n\n.header-pozicija {\n  top: 0px;\n  position: fixed;\n  z-index: 999 !important; }\n\n.header-glavni {\n  top: 0px;\n  position: absolute;\n  z-index: 999 !important; }\n\n@media screen and (max-width: 1000px) {\n  .pozicija {\n    padding-bottom: 490px; } }\n\n@media screen and (max-width: 950px) {\n  .pozicija {\n    margin-top: 66px;\n    padding-bottom: 490px; } }\n"

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
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
/* harmony import */ var _e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../e-shop/service/data/data.service */ "./src/app/e-shop/service/data/data.service.ts");
/* harmony import */ var _shared_modal_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../shared/modal/logout-modal/logout-modal.component */ "./src/app/shared/modal/logout-modal/logout-modal.component.ts");
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
    function NavigacijaComponent(korpaServis, loginServis, dialog) {
        this.korpaServis = korpaServis;
        this.loginServis = loginServis;
        this.dialog = dialog;
        this.korpaBadge = 0;
        this.partnerUlogovan = false;
        this.openSideNav = false;
    }
    NavigacijaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.openSideNav = window.innerWidth < 950;
        this.korpaServis.trenutnaKorpa.subscribe(function (korpa) { return _this.korpaBadge = korpa.roba.length; });
        this.loginServis.daLiJePartnerUlogovan.subscribe(function (bool) { return _this.partnerUlogovan = bool; });
        this.loginServis.ulogovaniPartner.subscribe(function (partner) { return _this.partner = partner; });
    };
    NavigacijaComponent.prototype.onResize = function (event) {
        this.openSideNav = window.innerWidth < 950;
    };
    NavigacijaComponent.prototype.otvoriDialog = function () {
        var dialogRef = this.dialog.open(_shared_modal_logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_4__["LogoutModalComponent"], {
            width: '400px'
        });
        dialogRef.afterClosed().subscribe(function () {
        });
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["HostListener"])('window:resize', ['$event']),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", [Object]),
        __metadata("design:returntype", void 0)
    ], NavigacijaComponent.prototype, "onResize", null);
    NavigacijaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-navigacija',
            template: __webpack_require__(/*! ./navigacija.component.html */ "./src/app/navigacija/navigacija.component.html"),
            styles: [__webpack_require__(/*! ./navigacija.component.scss */ "./src/app/navigacija/navigacija.component.scss")]
        }),
        __metadata("design:paramtypes", [_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_3__["DataService"],
            _e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_2__["LoginService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialog"]])
    ], NavigacijaComponent);
    return NavigacijaComponent;
}());



/***/ }),

/***/ "./src/app/navigacija/navigacija.module.ts":
/*!*************************************************!*\
  !*** ./src/app/navigacija/navigacija.module.ts ***!
  \*************************************************/
/*! exports provided: NavigacijaModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NavigacijaModule", function() { return NavigacijaModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _navigacija_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./navigacija.component */ "./src/app/navigacija/navigacija.component.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _shared_material_material_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../shared/material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var _footer_footer_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../footer/footer.module */ "./src/app/footer/footer.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};






var NavigacijaModule = /** @class */ (function () {
    function NavigacijaModule() {
    }
    NavigacijaModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"],
                _footer_footer_module__WEBPACK_IMPORTED_MODULE_5__["FooterModule"],
                _shared_material_material_module__WEBPACK_IMPORTED_MODULE_4__["MaterialModule"]
            ],
            declarations: [_navigacija_component__WEBPACK_IMPORTED_MODULE_2__["NavigacijaComponent"]],
            exports: [_navigacija_component__WEBPACK_IMPORTED_MODULE_2__["NavigacijaComponent"]]
        })
    ], NavigacijaModule);
    return NavigacijaModule;
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

module.exports = "<div class=\"container\">\n  <main>\n    <div class=\"header\">\n      <p>Da li ste sigurni da želite da se odjavite?</p>\n      <button type=\"button\" class=\"close\" (click)=\"ostaniUlogovan()\">\n        <span aria-hidden=\"true\">&times;</span>\n      </button>\n    </div>\n    <div class=\"d-flex flex-row justify-content-center margin-top--15\">\n      <button mat-raised-button class=\"button-glavni-100\" (click)=\"logout()\">Odjava</button>\n      <span class=\"col-2\"></span>\n      <button mat-raised-button class=\"button-crveni-50\" (click)=\"ostaniUlogovan()\">Poništi</button>\n    </div>\n  </main>\n</div>"

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

/***/ "./src/app/shared/modal/modal.module.ts":
/*!**********************************************!*\
  !*** ./src/app/shared/modal/modal.module.ts ***!
  \**********************************************/
/*! exports provided: ModalModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ModalModule", function() { return ModalModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./zaboravljena-sifra-modal/zaboravljena-sifra-modal.component */ "./src/app/shared/modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component.ts");
/* harmony import */ var _registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./registracija-modal/registracija-modal.component */ "./src/app/shared/modal/registracija-modal/registracija-modal.component.ts");
/* harmony import */ var _izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./izmena-kolicine-modal/izmena-kolicine-modal.component */ "./src/app/shared/modal/izmena-kolicine-modal/izmena-kolicine-modal.component.ts");
/* harmony import */ var _logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./logout-modal/logout-modal.component */ "./src/app/shared/modal/logout-modal/logout-modal.component.ts");
/* harmony import */ var _uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./uspesno-porucivanje-modal/uspesno-porucivanje-modal.component */ "./src/app/shared/modal/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component.ts");
/* harmony import */ var _neuspesno_porucivanje_modal_neuspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component */ "./src/app/shared/modal/neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component.ts");
/* harmony import */ var _poruka_modal_poruka_modal_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./poruka-modal/poruka-modal.component */ "./src/app/shared/modal/poruka-modal/poruka-modal.component.ts");
/* harmony import */ var _brendovi_modal_brendovi_modal_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./brendovi-modal/brendovi-modal.component */ "./src/app/shared/modal/brendovi-modal/brendovi-modal.component.ts");
/* harmony import */ var _upit_modal_upit_modal_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./upit-modal/upit-modal.component */ "./src/app/shared/modal/upit-modal/upit-modal.component.ts");
/* harmony import */ var _sesija_istekla_modal_sesija_istekla_modal_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./sesija-istekla-modal/sesija-istekla-modal.component */ "./src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component.ts");
/* harmony import */ var _prvo_logovanje_modal_prvo_logovanje_modal_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./prvo-logovanje-modal/prvo-logovanje-modal.component */ "./src/app/shared/modal/prvo-logovanje-modal/prvo-logovanje-modal.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _material_material_module__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var src_app_e_shop_magacin_shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! src/app/e-shop/magacin/shared-components/shared-magacin.module */ "./src/app/e-shop/magacin/shared-components/shared-magacin.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
















var ModalModule = /** @class */ (function () {
    function ModalModule() {
    }
    ModalModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_13__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_13__["FormsModule"],
                _material_material_module__WEBPACK_IMPORTED_MODULE_14__["MaterialModule"],
                src_app_e_shop_magacin_shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_15__["SharedMagacinModule"],
            ],
            declarations: [
                _zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_2__["ZaboravljenaSifraModalComponent"],
                _registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_3__["RegistracijaModalComponent"],
                _izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_4__["IzmenaKolicineModalComponent"],
                _logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_5__["LogoutModalComponent"],
                _uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_6__["UspesnoPorucivanjeModalComponent"],
                _neuspesno_porucivanje_modal_neuspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_7__["NeuspesnoPorucivanjeModalComponent"],
                _poruka_modal_poruka_modal_component__WEBPACK_IMPORTED_MODULE_8__["PorukaModalComponent"],
                _brendovi_modal_brendovi_modal_component__WEBPACK_IMPORTED_MODULE_9__["BrendoviModalComponent"],
                _upit_modal_upit_modal_component__WEBPACK_IMPORTED_MODULE_10__["UpitModalComponent"],
                _sesija_istekla_modal_sesija_istekla_modal_component__WEBPACK_IMPORTED_MODULE_11__["SesijaIsteklaModalComponent"],
                _prvo_logovanje_modal_prvo_logovanje_modal_component__WEBPACK_IMPORTED_MODULE_12__["PrvoLogovanjeModalComponent"]
            ],
            entryComponents: [
                _zaboravljena_sifra_modal_zaboravljena_sifra_modal_component__WEBPACK_IMPORTED_MODULE_2__["ZaboravljenaSifraModalComponent"],
                _registracija_modal_registracija_modal_component__WEBPACK_IMPORTED_MODULE_3__["RegistracijaModalComponent"],
                _izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_4__["IzmenaKolicineModalComponent"],
                _logout_modal_logout_modal_component__WEBPACK_IMPORTED_MODULE_5__["LogoutModalComponent"],
                _uspesno_porucivanje_modal_uspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_6__["UspesnoPorucivanjeModalComponent"],
                _neuspesno_porucivanje_modal_neuspesno_porucivanje_modal_component__WEBPACK_IMPORTED_MODULE_7__["NeuspesnoPorucivanjeModalComponent"],
                _poruka_modal_poruka_modal_component__WEBPACK_IMPORTED_MODULE_8__["PorukaModalComponent"],
                _brendovi_modal_brendovi_modal_component__WEBPACK_IMPORTED_MODULE_9__["BrendoviModalComponent"],
                _upit_modal_upit_modal_component__WEBPACK_IMPORTED_MODULE_10__["UpitModalComponent"],
                _sesija_istekla_modal_sesija_istekla_modal_component__WEBPACK_IMPORTED_MODULE_11__["SesijaIsteklaModalComponent"],
                _prvo_logovanje_modal_prvo_logovanje_modal_component__WEBPACK_IMPORTED_MODULE_12__["PrvoLogovanjeModalComponent"]
            ]
        })
    ], ModalModule);
    return ModalModule;
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
        dto.ppid = this.partner.ppid;
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
    // baseUrl: ''
    baseUrl: 'http://localhost:8080'
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