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
/* harmony import */ var _roba_roba_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./roba/roba.component */ "./src/app/roba/roba.component.ts");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _roba_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./roba/filteri/filteri.component */ "./src/app/roba/filteri/filteri.component.ts");
/* harmony import */ var _roba_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./roba/akumulatori/akumulatori.component */ "./src/app/roba/akumulatori/akumulatori.component.ts");
/* harmony import */ var _roba_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./roba/ulja/ulja.component */ "./src/app/roba/ulja/ulja.component.ts");
/* harmony import */ var _dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./dasboard/dasboard.component */ "./src/app/dasboard/dasboard.component.ts");
/* harmony import */ var _korpa_korpa_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./korpa/korpa.component */ "./src/app/korpa/korpa.component.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};









var routes = [
    { path: '', redirectTo: '/naslovna', pathMatch: 'full' },
    { path: 'naslovna', component: _dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_6__["DasboardComponent"] },
    { path: 'roba', component: _roba_roba_component__WEBPACK_IMPORTED_MODULE_1__["RobaComponent"] },
    { path: 'filteri', component: _roba_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_3__["FilteriComponent"] },
    { path: 'ulja', component: _roba_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_5__["UljaComponent"] },
    { path: 'akumulatori', component: _roba_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_4__["AkumulatoriComponent"] },
    { path: 'login', component: _login_login_component__WEBPACK_IMPORTED_MODULE_8__["LoginComponent"] },
    { path: 'korpa', component: _korpa_korpa_component__WEBPACK_IMPORTED_MODULE_7__["KorpaComponent"] }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
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
/* harmony import */ var _roba_roba_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./roba/roba.component */ "./src/app/roba/roba.component.ts");
/* harmony import */ var _dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./dasboard/dasboard.component */ "./src/app/dasboard/dasboard.component.ts");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _roba_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./roba/filteri/filteri.component */ "./src/app/roba/filteri/filteri.component.ts");
/* harmony import */ var _roba_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./roba/akumulatori/akumulatori.component */ "./src/app/roba/akumulatori/akumulatori.component.ts");
/* harmony import */ var _roba_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./roba/ulja/ulja.component */ "./src/app/roba/ulja/ulja.component.ts");
/* harmony import */ var _roba_ulja_motorna_motorna_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./roba/ulja/motorna/motorna.component */ "./src/app/roba/ulja/motorna/motorna.component.ts");
/* harmony import */ var _roba_ulja_menjacko_menjacko_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./roba/ulja/menjacko/menjacko.component */ "./src/app/roba/ulja/menjacko/menjacko.component.ts");
/* harmony import */ var _roba_ulja_kociona_kociona_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./roba/ulja/kociona/kociona.component */ "./src/app/roba/ulja/kociona/kociona.component.ts");
/* harmony import */ var _roba_ulja_antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./roba/ulja/antifriz/antifriz.component */ "./src/app/roba/ulja/antifriz/antifriz.component.ts");
/* harmony import */ var _roba_ulja_industrijska_industrijska_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./roba/ulja/industrijska/industrijska.component */ "./src/app/roba/ulja/industrijska/industrijska.component.ts");
/* harmony import */ var _korpa_korpa_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./korpa/korpa.component */ "./src/app/korpa/korpa.component.ts");
/* harmony import */ var _korpa_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./korpa/izmena-kolicine-modal/izmena-kolicine-modal.component */ "./src/app/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
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
                _roba_roba_component__WEBPACK_IMPORTED_MODULE_7__["RobaComponent"],
                _dasboard_dasboard_component__WEBPACK_IMPORTED_MODULE_8__["DasboardComponent"],
                _roba_filteri_filteri_component__WEBPACK_IMPORTED_MODULE_12__["FilteriComponent"],
                _roba_akumulatori_akumulatori_component__WEBPACK_IMPORTED_MODULE_13__["AkumulatoriComponent"],
                _roba_ulja_ulja_component__WEBPACK_IMPORTED_MODULE_14__["UljaComponent"],
                _roba_ulja_motorna_motorna_component__WEBPACK_IMPORTED_MODULE_15__["MotornaComponent"],
                _roba_ulja_menjacko_menjacko_component__WEBPACK_IMPORTED_MODULE_16__["MenjackoComponent"],
                _roba_ulja_kociona_kociona_component__WEBPACK_IMPORTED_MODULE_17__["KocionaComponent"],
                _roba_ulja_antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_18__["AntifrizComponent"],
                _roba_ulja_industrijska_industrijska_component__WEBPACK_IMPORTED_MODULE_19__["IndustrijskaComponent"],
                _korpa_korpa_component__WEBPACK_IMPORTED_MODULE_20__["KorpaComponent"],
                _korpa_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_21__["IzmenaKolicineModalComponent"],
                _login_login_component__WEBPACK_IMPORTED_MODULE_22__["LoginComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_http__WEBPACK_IMPORTED_MODULE_9__["HttpModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_23__["HttpClientModule"],
                angular_webstorage_service__WEBPACK_IMPORTED_MODULE_2__["StorageServiceModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["BrowserAnimationsModule"],
                _shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__["MaterialModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_10__["AppRoutingModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_11__["FormsModule"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]],
            entryComponents: [_korpa_izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_21__["IzmenaKolicineModalComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/dasboard/dasboard.component.css":
/*!*************************************************!*\
  !*** ./src/app/dasboard/dasboard.component.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".grid-container {\n  margin: 20px;\n}\n\n.dashboard-card {\n  position: absolute;\n  top: 15px;\n  left: 15px;\n  right: 15px;\n  bottom: 15px;\n}\n\n.more-button {\n  position: absolute;\n  top: 5px;\n  right: 10px;\n}\n\n.dashboard-card-content {\n  text-align: center;\n}"

/***/ }),

/***/ "./src/app/dasboard/dasboard.component.html":
/*!**************************************************!*\
  !*** ./src/app/dasboard/dasboard.component.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"grid-container\">\n  <h1 class=\"mat-h1\">Dashboard</h1>\n  <mat-grid-list cols=\"2\" rowHeight=\"350px\">\n    <mat-grid-tile *ngFor=\"let card of cards | async\" [colspan]=\"card.cols\" [rowspan]=\"card.rows\">\n      <mat-card class=\"dashboard-card\">\n        <mat-card-header>\n          <mat-card-title>\n            {{card.title}}\n            <button mat-icon-button class=\"more-button\" [matMenuTriggerFor]=\"menu\" aria-label=\"Toggle menu\">\n              <mat-icon>more_vert</mat-icon>\n            </button>\n            <mat-menu #menu=\"matMenu\" xPosition=\"before\">\n              <button mat-menu-item>Expand</button>\n              <button mat-menu-item>Remove</button>\n            </mat-menu>\n          </mat-card-title>\n        </mat-card-header>\n        <mat-card-content class=\"dashboard-card-content\">\n          <div>Card Content Here</div>\n        </mat-card-content>\n      </mat-card>\n    </mat-grid-tile>\n  </mat-grid-list>\n</div>"

/***/ }),

/***/ "./src/app/dasboard/dasboard.component.ts":
/*!************************************************!*\
  !*** ./src/app/dasboard/dasboard.component.ts ***!
  \************************************************/
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
            template: __webpack_require__(/*! ./dasboard.component.html */ "./src/app/dasboard/dasboard.component.html"),
            styles: [__webpack_require__(/*! ./dasboard.component.css */ "./src/app/dasboard/dasboard.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_2__["BreakpointObserver"]])
    ], DasboardComponent);
    return DasboardComponent;
}());



/***/ }),

/***/ "./src/app/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.css":
/*!*********************************************************************************!*\
  !*** ./src/app/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.css ***!
  \*********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "p {\r\n    text-align: center;\r\n}\r\n\r\n.pomeri {\r\n    margin-left: 10px;\r\n}"

/***/ }),

/***/ "./src/app/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.html":
/*!**********************************************************************************!*\
  !*** ./src/app/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.html ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <div>\n    <p class=\"mat-title\">\n      Artikal broj: {{data.katbr}}\n    </p>\n  </div>\n  <table class=\"table table-bordered\">\n    <tbody>\n      <tr>\n        <td>Proizvodjac</td>\n        <td>{{data.proizvodjac}}</td>\n      </tr>\n      <tr>\n        <td>Cena</td>\n        <td>{{data.cenaKom}}</td>\n      <tr>\n        <td>Kolicina</td>\n        <td>\n            <select class=\"custom-select custom-select-md\" [(ngModel)]=\"data.kolicina\">\n                <option *ngFor=\"let kolicina of stanje\" [value]=\"kolicina\">{{kolicina}}</option>\n            </select>\n        </td>\n      </tr>\n      <tr>\n        <td>Ukupno za placanje</td>\n        <td>{{data.kolicina * data.cenaKom}} DIN</td>\n      </tr>\n    </tbody>\n  </table>\n  <div class=\"d-flex flex-row justify-content-center\">\n    <button type=\"button\" class=\"btn btn-primary\" (click)=\"sacuvajIzmene()\">Sacuvaj</button>\n    <button type=\"button\" class=\"btn btn-danger pomeri\" (click)=\"bezIzmena()\">Ponisti</button>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.ts":
/*!********************************************************************************!*\
  !*** ./src/app/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.ts ***!
  \********************************************************************************/
/*! exports provided: IzmenaKolicineModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "IzmenaKolicineModalComponent", function() { return IzmenaKolicineModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var src_app_model_porudzbenica__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/model/porudzbenica */ "./src/app/model/porudzbenica.ts");
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




var IzmenaKolicineModalComponent = /** @class */ (function () {
    function IzmenaKolicineModalComponent(dialogRef, roba) {
        this.dialogRef = dialogRef;
        this.roba = roba;
        this.stanje = [];
    }
    IzmenaKolicineModalComponent.prototype.ngOnInit = function () {
        this.data = lodash__WEBPACK_IMPORTED_MODULE_3__["clone"](this.roba);
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
        this.data.kolicina = lodash__WEBPACK_IMPORTED_MODULE_3__["toNumber"](this.data.kolicina);
        this.data.cenaUkupno = this.data.kolicina * this.data.cenaKom;
        this.dialogRef.close(this.data);
    };
    IzmenaKolicineModalComponent.prototype.bezIzmena = function () {
        this.dialogRef.close();
    };
    IzmenaKolicineModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-izmena-kolicine-modal',
            template: __webpack_require__(/*! ./izmena-kolicine-modal.component.html */ "./src/app/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.html"),
            styles: [__webpack_require__(/*! ./izmena-kolicine-modal.component.css */ "./src/app/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.css")]
        }),
        __param(1, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MAT_DIALOG_DATA"])),
        __metadata("design:paramtypes", [_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialogRef"],
            src_app_model_porudzbenica__WEBPACK_IMPORTED_MODULE_2__["RobaKorpa"]])
    ], IzmenaKolicineModalComponent);
    return IzmenaKolicineModalComponent;
}());



/***/ }),

/***/ "./src/app/korpa/korpa.component.css":
/*!*******************************************!*\
  !*** ./src/app/korpa/korpa.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".razmakni {\r\n    margin-left: 5px;\r\n  }\r\n  p {\r\n    text-align: center;\r\n}"

/***/ }),

/***/ "./src/app/korpa/korpa.component.html":
/*!********************************************!*\
  !*** ./src/app/korpa/korpa.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"grid-container\">\n\n    <div *ngIf=\"dataSource.length == 0\">\n        <h1>Korpa je trenutno prazna</h1>-\n    </div>\n    <div class=\"tabela-div\" *ngIf=\"dataSource.length > 0\">\n        <div style=\"overflow-x:auto;\">\n            <table mat-table [dataSource]=\"dataSource\" matSort (matSortChange)=\"sortData($event)\" class=\"mat-elevation-z8\">\n                <!-- Kataloski broj Column -->\n                <ng-container matColumnDef=\"katbr\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.katbr}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Kataloski broj proizvodjaca Column -->\n                <ng-container matColumnDef=\"katbrpro\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj proizvodjaca </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.katbrpro}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Naziv Column -->\n                <ng-container matColumnDef=\"naziv\">\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.naziv}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Proizvodjac Column -->\n                <ng-container matColumnDef=\"proizvodjac\">\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.proizvodjac}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Cena Column -->\n                <ng-container matColumnDef=\"kolicina\">\n                    <th mat-header-cell *matHeaderCellDef> Kolicina </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.kolicina}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Cena Column -->\n                <ng-container matColumnDef=\"cena\">\n                    <th mat-header-cell *matHeaderCellDef> Ukupno </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.cenaUkupno}} DIN\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Kropa dugme Column -->\n                <ng-container matColumnDef=\"korpa\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <button mat-raised-button color=\"primary\">Dodaj u korpu</button>\n                        </div>\n                </ng-container>\n\n                <!-- Kolicina Column -->\n                <ng-container matColumnDef=\"izbaciDugme\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba; let i = index;\">\n                        <button type=\"button\" class=\"btn razmakni btn-primary btn-sm\" (click)=\"otvoriDialog(roba)\">Izmeni</button>\n                        <button type=\"button\" class=\"btn razmakni btn-danger btn-sm\" (click)='izbaciIzKorpe(i)'>Izbaci</button>\n                </ng-container>\n\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n            </table>\n        </div>\n        <div>\n            <table class=\"table table-bordered\">\n                <tbody>\n                    <tr>\n                        <td>Bez pdv-a: </td>\n                        <td>{{bezPdv}} RSD</td>\n                    </tr>\n                    <tr>\n                        <td>Pdv: </td>\n                        <td>{{bezPdv}} RSD</td>\n                    </tr>\n                    <tr>\n                        <td>Ukupno za uplatu: </td>\n                        <td>{{ukupno}} RSD</td>\n                    </tr>\n                </tbody>\n            </table>\n        </div>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/korpa/korpa.component.ts":
/*!******************************************!*\
  !*** ./src/app/korpa/korpa.component.ts ***!
  \******************************************/
/*! exports provided: KorpaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KorpaComponent", function() { return KorpaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_data_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../service/data.service */ "./src/app/service/data.service.ts");
/* harmony import */ var _service_local_storage_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/local-storage.service */ "./src/app/service/local-storage.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _izmena_kolicine_modal_izmena_kolicine_modal_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./izmena-kolicine-modal/izmena-kolicine-modal.component */ "./src/app/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component.ts");
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
    function KorpaComponent(dataService, storage, dialog) {
        this.dataService = dataService;
        this.storage = storage;
        this.dialog = dialog;
        this.displayedColumns = ['katbr', 'katbrpro', 'naziv',
            'proizvodjac', 'kolicina', 'cena', 'izbaciDugme'];
    }
    KorpaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) {
            _this.korpa = korpa;
            _this.preracunajUkupno();
            _this.dataSource = _this.korpa.roba;
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
        this.bezPdv = (this.korpa.ukupno / 1.2) + ',00';
        this.pdv = (this.korpa.ukupno - this.korpa.ukupno / 1.2) + ',00';
        this.ukupno = this.korpa.ukupno + ',00';
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])(_angular_material__WEBPACK_IMPORTED_MODULE_3__["MatTable"]),
        __metadata("design:type", _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatTable"])
    ], KorpaComponent.prototype, "table", void 0);
    KorpaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-korpa',
            template: __webpack_require__(/*! ./korpa.component.html */ "./src/app/korpa/korpa.component.html"),
            styles: [__webpack_require__(/*! ./korpa.component.css */ "./src/app/korpa/korpa.component.css")]
        }),
        __metadata("design:paramtypes", [_service_data_service__WEBPACK_IMPORTED_MODULE_1__["DataService"],
            _service_local_storage_service__WEBPACK_IMPORTED_MODULE_2__["LocalStorageService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatDialog"]])
    ], KorpaComponent);
    return KorpaComponent;
}());



/***/ }),

/***/ "./src/app/login/login.component.css":
/*!*******************************************!*\
  !*** ./src/app/login/login.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/login/login.component.html":
/*!********************************************!*\
  !*** ./src/app/login/login.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = " <div class=\"container\">\n<form role=\"form\" (submit)=\"login()\">\n\t<div class=\"form-group\">\n    <label for=\"username\">Username:</label> \n    <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" [(ngModel)]=\"credentials.username\"/>\n\t</div>\n\t<div class=\"form-group\">\n    <label for=\"password\">Password:</label> \n    <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" [(ngModel)]=\"credentials.password\"/>\n\t</div>\n\t<button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n</form>\n</div>"

/***/ }),

/***/ "./src/app/login/login.component.ts":
/*!******************************************!*\
  !*** ./src/app/login/login.component.ts ***!
  \******************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../service/login.service */ "./src/app/service/login.service.ts");
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
    function LoginComponent(loginService) {
        this.loginService = loginService;
        this.credentials = {};
        this.alive = true;
    }
    LoginComponent.prototype.ngOnInit = function () {
    };
    LoginComponent.prototype.login = function () {
        this.loginService.ulogujSe(this.credentials);
    };
    LoginComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/login/login.component.css")]
        }),
        __metadata("design:paramtypes", [_service_login_service__WEBPACK_IMPORTED_MODULE_1__["LoginService"]])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "./src/app/model/porudzbenica.ts":
/*!***************************************!*\
  !*** ./src/app/model/porudzbenica.ts ***!
  \***************************************/
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
    function RobaKorpa(katbr, katbrpro, naziv, proizvodjac, kolicina, cena, stanje) {
        this.katbr = katbr;
        this.katbrpro = katbrpro;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.kolicina = kolicina;
        this.cenaKom = cena;
        this.cenaUkupno = cena * kolicina;
        this.stanje = stanje;
    }
    return RobaKorpa;
}());



/***/ }),

/***/ "./src/app/navigacija/navigacija.component.css":
/*!*****************************************************!*\
  !*** ./src/app/navigacija/navigacija.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sidenav-container {\n  height: 100%;\n}\n\n.sidenav {\n  width: 200px;\n}\n\n.mat-toolbar.mat-primary {\n  position: -webkit-sticky;\n  position: sticky;\n  top: 0;\n}\n"

/***/ }),

/***/ "./src/app/navigacija/navigacija.component.html":
/*!******************************************************!*\
  !*** ./src/app/navigacija/navigacija.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-sidenav-container class=\"sidenav-container\">\n  <mat-sidenav #drawer class=\"sidenav\" fixedInViewport=\"true\" [attr.role]=\"(isHandset$ | async) ? 'dialog' : 'navigation'\"\n    [mode]=\"(isHandset$ | async) ? 'over' : 'side'\" [opened]=\"!(isHandset$ | async)\">\n    <mat-toolbar color=\"primary\">Meni</mat-toolbar>\n    <mat-nav-list>\n      <h3 mat-subheader>Automaterijal</h3>\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['naslovna']\">\n        <mat-icon mat-list-icon>home</mat-icon>\n        <p mat-line>Naslovna</p>\n      </mat-list-item>\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['o-nama']\">\n        <mat-icon mat-list-icon>book</mat-icon>\n        <p mat-line>O nama</p>\n      </mat-list-item>\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['kontakt']\">\n        <mat-icon mat-list-icon>contact_phone</mat-icon>\n        <p mat-line>Kontakt</p>\n      </mat-list-item>\n    </mat-nav-list>\n\n    <mat-divider></mat-divider>\n    <mat-nav-list>\n      <h3 mat-subheader>Internet prodavnica</h3>\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['roba']\">\n        <mat-icon mat-list-icon>searche</mat-icon>\n        <p mat-line>Roba - pretraga</p>\n      </mat-list-item>\n      \n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['ulja']\">\n          <mat-icon mat-list-icon>invert_colors</mat-icon>\n          <p mat-line>Ulja</p>\n        </mat-list-item>        \n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['filteri']\">\n          <mat-icon mat-list-icon>layers</mat-icon>\n          <p mat-line>Filteri</p>\n      </mat-list-item>\n\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['akumulatori']\">\n          <mat-icon mat-list-icon>battery_charging_full</mat-icon>\n          <p mat-line>Akumulatori</p>\n        </mat-list-item>\n\n        <mat-list-item class=\"material-icons\" [routerLink]=\"['korpa']\">\n            <mat-icon mat-list-icon>category</mat-icon>\n            <p mat-line>Ostalo</p>\n          </mat-list-item>\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['korpa']\">\n        <mat-icon  matBadge=\"{{test}}\" matBadgeColor=\"warn\" mat-list-icon>shopping_cart</mat-icon>\n        <p mat-line>Korpa</p>\n      </mat-list-item>\n    </mat-nav-list>\n\n    <mat-divider></mat-divider>\n    <mat-nav-list>\n      <h3 mat-subheader>Moj Profil</h3>\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['korpa']\">\n        <mat-icon mat-list-icon>person</mat-icon>\n        <p mat-line>Licni Podaci</p>\n      </mat-list-item>\n      <mat-list-item class=\"material-icons\" [routerLink]=\"['korpa']\">\n        <mat-icon mat-list-icon>list</mat-icon>\n        <p mat-line>Porudzbine</p>\n      </mat-list-item>\n    </mat-nav-list>\n  </mat-sidenav>\n  <mat-sidenav-content>\n    <mat-toolbar color=\"primary\">\n      <button type=\"button\" aria-label=\"Toggle sidenav\" mat-icon-button (click)=\"drawer.toggle()\" *ngIf=\"isHandset$ | async\">\n        <mat-icon aria-label=\"Side nav toggle icon\">menu</mat-icon>\n      </button>\n      <span>Automaterijal - internet prodavnica</span>\n      <span><a [routerLink]=\"['login']\">Login</a></span>\n    </mat-toolbar>\n    <router-outlet></router-outlet>\n  </mat-sidenav-content>\n</mat-sidenav-container>"

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
/* harmony import */ var _service_data_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../service/data.service */ "./src/app/service/data.service.ts");
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
    function NavigacijaComponent(breakpointObserver, korpaServis) {
        this.breakpointObserver = breakpointObserver;
        this.korpaServis = korpaServis;
        this.test = 3;
        this.isHandset$ = this.breakpointObserver.observe(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["Breakpoints"].Handset)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (result) { return result.matches; }));
    }
    NavigacijaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.korpaServis.trenutnaKorpa.subscribe(function (korpa) { return _this.test = korpa.roba.length; });
    };
    NavigacijaComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-navigacija',
            template: __webpack_require__(/*! ./navigacija.component.html */ "./src/app/navigacija/navigacija.component.html"),
            styles: [__webpack_require__(/*! ./navigacija.component.css */ "./src/app/navigacija/navigacija.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["BreakpointObserver"], _service_data_service__WEBPACK_IMPORTED_MODULE_3__["DataService"]])
    ], NavigacijaComponent);
    return NavigacijaComponent;
}());



/***/ }),

/***/ "./src/app/roba/akumulatori/akumulatori.component.css":
/*!************************************************************!*\
  !*** ./src/app/roba/akumulatori/akumulatori.component.css ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/roba/akumulatori/akumulatori.component.html":
/*!*************************************************************!*\
  !*** ./src/app/roba/akumulatori/akumulatori.component.html ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n\n    <div class=\"d-flex align-items-center justify-content-center\">\n        <div class=\"forms-input\">\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\n                <button mat-mini-fab color=\"primary\">\n                    <mat-icon>search</mat-icon>\n                </button>\n            </div>\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\n                <button *ngIf=\"!otvoriFilterDiv\" mat-mini-fab color=\"primary\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab color=\"warn\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n            </div>\n        </div>\n    </div>\n    <div class=\"d-flex justify-content-center\">\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\n        </label>\n    </div>\n\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\n        <div class=\"filter-div-test d-flex flex-column\">\n            <div class=\"d-flex justify-content-center\">\n                <h4>\n                    Filter\n                </h4>\n            </div>\n            <div class=\"input-group mb-3\">\n                <div class=\"input-group-prepend\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Proizvodjac: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">{{proizvodjac.naziv}}</option>\n                </select>\n\n                <div class=\"input-group-prepend razmak\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Raspolozivost: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\n                </select>\n            </div>\n            <div class=\"d-flex justify-content-center\">\n                <div>\n                    <button mat-stroked-button color=\"primary\" (click)='filtriraj()'>Filtriraj</button>\n                    <span class=\"col-2\"></span>\n                    <button mat-stroked-button color=\"warn\" (click)='resetujFilter()'>Ponisti</button>\n                </div>\n            </div>\n        </div>\n    </div>\n\n\n    <div class=\"tabela-div mat-elevation-z8\">\n        <div style=\"overflow-x:auto;\">\n            <table mat-table [dataSource]=\"dataSource\" matSort (matSortChange)=\"sortData($event)\">\n                <!-- Kataloski broj Column -->\n                <ng-container matColumnDef=\"katbr\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.katbr}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Kataloski broj proizvodjaca Column -->\n                <ng-container matColumnDef=\"katbrpro\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj proizvodjaca </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.katbrpro}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Naziv Column -->\n                <ng-container matColumnDef=\"naziv\">\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.naziv}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Proizvodjac Column -->\n                <ng-container matColumnDef=\"proizvodjac\">\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.proizvodjac}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Cena Column -->\n                <ng-container matColumnDef=\"cena\">\n                    <th mat-header-cell *matHeaderCellDef> Cena </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.cena}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Stanje Column -->\n                <ng-container matColumnDef=\"stanje\">\n                    <th mat-header-cell *matHeaderCellDef> Stanje </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <mat-icon class=\"gren-icon\">check_circle_outline</mat-icon>\n                        </div>\n                        <div *ngIf=\"roba.stanje == 0\">\n                            <mat-icon color=\"accent\">remove_circle_outline</mat-icon>\n                        </div>\n                    </td>\n                </ng-container>\n\n\n                <!-- Kolicina Column -->\n                <ng-container matColumnDef=\"kolicina\">\n                    <th mat-header-cell *matHeaderCellDef>Kolicina </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <input type=\"number\" min=\"1\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\"\n                                class=\"kolicina-input\" />\n                        </div>\n                </ng-container>\n\n                <!-- Kropa dugme Column -->\n                <ng-container matColumnDef=\"korpa\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <button mat-raised-button color=\"primary\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\n                        </div>\n                </ng-container>\n\n                <!-- Da li ima na stanju ikona -->\n                <ng-container matColumnDef=\"u-korpi\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"uKorpi(roba.katbr)\">\n                            <mat-icon color=\"accent\">add_shopping_cart</mat-icon>\n                        </div>\n                </ng-container>\n\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n            </table>\n        </div>\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\n        </mat-paginator>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/roba/akumulatori/akumulatori.component.ts":
/*!***********************************************************!*\
  !*** ./src/app/roba/akumulatori/akumulatori.component.ts ***!
  \***********************************************************/
/*! exports provided: AkumulatoriComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AkumulatoriComponent", function() { return AkumulatoriComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/service/roba.service */ "./src/app/service/roba.service.ts");
/* harmony import */ var src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/proizvodjac.service */ "./src/app/service/proizvodjac.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/utils/app-utils.service */ "./src/app/utils/app-utils.service.ts");
/* harmony import */ var src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/service/data.service */ "./src/app/service/data.service.ts");
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
    function AkumulatoriComponent(robaService, utilsService, dataService, proizvodjacService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
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
        this.otvoriFilterDiv = false;
        this.displayedColumns = ['katbr', 'katbrpro', 'naziv',
            'proizvodjac', 'cena', 'stanje', 'kolicina', 'korpa', 'u-korpi'];
        this.alive = true;
    }
    AkumulatoriComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.pronadjiSveProizvodjace();
    };
    AkumulatoriComponent.prototype.pronandjiSveAkumulatore = function () {
        var _this = this;
        this.ucitavanje = true;
        this.dataSource = null;
        this.robaService.pronadjiAkumulatore(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
        this.robaService.pronadjiAkumulatore(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
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
            template: __webpack_require__(/*! ./akumulatori.component.html */ "./src/app/roba/akumulatori/akumulatori.component.html"),
            styles: [__webpack_require__(/*! ./akumulatori.component.css */ "./src/app/roba/akumulatori/akumulatori.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__["RobaService"],
            src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__["DataService"],
            src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__["ProizvodjacService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatSnackBar"]])
    ], AkumulatoriComponent);
    return AkumulatoriComponent;
}());



/***/ }),

/***/ "./src/app/roba/filteri/filteri.component.css":
/*!****************************************************!*\
  !*** ./src/app/roba/filteri/filteri.component.css ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/roba/filteri/filteri.component.html":
/*!*****************************************************!*\
  !*** ./src/app/roba/filteri/filteri.component.html ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n\n    <div class=\"d-flex align-items-center justify-content-center\">\n        <div class=\"forms-input\">\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\n                <button mat-mini-fab color=\"primary\">\n                    <mat-icon>search</mat-icon>\n                </button>\n            </div>\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\n                <button *ngIf=\"!otvoriFilterDiv\" mat-mini-fab color=\"primary\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab color=\"warn\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n            </div>\n        </div>\n    </div>\n    <div class=\"d-flex justify-content-center\">\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\n        </label>\n    </div>\n\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\n        <div class=\"filter-div-test d-flex flex-column\">\n            <div class=\"d-flex justify-content-center\">\n                <section class=\"mat-typography\">\n                    <h1>Filter</h1>\n                </section>\n            </div>\n            <div class=\"input-group mb-3\">\n                    <div class=\"input-group-prepend\">\n                        <label class=\"input-group-text\" for=\"inputGroupSelect01\">Proizvodjac: </label>\n                    </div>\n                    <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\n                        <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">{{proizvodjac.naziv}}</option>\n                    </select>\n                    <div class=\"input-group-prepend razmak\">\n                        <label class=\"input-group-text\" for=\"inputGroupSelect01\">Raspolozivost: </label>\n                    </div>\n                    <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\n                        <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\n                    </select>\n            </div>\n            <div class=\"d-flex justify-content-center\">\n                <div>\n                    <button mat-stroked-button color=\"primary\" (click)='filtriraj()'>Filtriraj</button>\n                    <span class=\"col-2\"></span>\n                    <button mat-stroked-button color=\"warn\" (click)='resetujFilter()'>Ponisti</button>\n                </div>\n            </div>\n        </div>\n    </div>\n\n\n    <div class=\"mat-elevation-z8\">\n        <div class=\"tabela-div\" style=\"overflow-x:auto;\">\n            <table mat-table [dataSource]=\"dataSource\" matSort (matSortChange)=\"sortData($event)\">\n                <!-- Kataloski broj Column -->\n                <ng-container matColumnDef=\"katbr\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.katbr}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Kataloski broj proizvodjaca Column -->\n                <ng-container matColumnDef=\"katbrpro\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj proizvodjaca </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.katbrpro}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Naziv Column -->\n                <ng-container matColumnDef=\"naziv\">\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.naziv}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Proizvodjac Column -->\n                <ng-container matColumnDef=\"proizvodjac\">\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.proizvodjac}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Cena Column -->\n                <ng-container matColumnDef=\"cena\">\n                    <th mat-header-cell *matHeaderCellDef> Cena </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.cena}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Stanje Column -->\n                <ng-container matColumnDef=\"stanje\">\n                    <th mat-header-cell *matHeaderCellDef> Stanje </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <mat-icon class=\"gren-icon\">check_circle_outline</mat-icon>\n                        </div>\n                        <div *ngIf=\"roba.stanje == 0\">\n                            <mat-icon color=\"accent\">remove_circle_outline</mat-icon>\n                        </div>\n                    </td>\n                </ng-container>\n\n\n                <!-- Kolicina Column -->\n                <ng-container matColumnDef=\"kolicina\">\n                    <th mat-header-cell *matHeaderCellDef>Kolicina </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <input type=\"number\" min=\"1\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\"\n                                class=\"kolicina-input\" />\n                        </div>\n                </ng-container>\n\n                <!-- Kropa dugme Column -->\n                <ng-container matColumnDef=\"korpa\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <button mat-raised-button color=\"primary\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\n                        </div>\n                </ng-container>\n\n                <!-- Da li ima na stanju ikona -->\n                <ng-container matColumnDef=\"u-korpi\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"uKorpi(roba.katbr)\">\n                            <mat-icon color=\"accent\">add_shopping_cart</mat-icon>\n                        </div>\n                </ng-container>\n\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n            </table>\n        </div>\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\n        </mat-paginator>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/roba/filteri/filteri.component.ts":
/*!***************************************************!*\
  !*** ./src/app/roba/filteri/filteri.component.ts ***!
  \***************************************************/
/*! exports provided: FilteriComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FilteriComponent", function() { return FilteriComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/service/roba.service */ "./src/app/service/roba.service.ts");
/* harmony import */ var src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/proizvodjac.service */ "./src/app/service/proizvodjac.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_service_data_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/service/data.service */ "./src/app/service/data.service.ts");
/* harmony import */ var src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/utils/app-utils.service */ "./src/app/utils/app-utils.service.ts");
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
    function FilteriComponent(robaService, proizvodjacService, dataService, utilsService, korpaSnackBar) {
        this.robaService = robaService;
        this.proizvodjacService = proizvodjacService;
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
        this.otvoriFilterDiv = false;
        this.displayedColumns = ['katbr', 'katbrpro', 'naziv',
            'proizvodjac', 'cena', 'stanje', 'kolicina', 'korpa', 'u-korpi'];
        this.alive = true;
    }
    FilteriComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.pronadjiSveProizvodjace();
    };
    FilteriComponent.prototype.pronandjiSveFiltere = function () {
        var _this = this;
        this.ucitavanje = true;
        this.dataSource = null;
        this.robaService.pronadjiFiltere(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
            _this.roba = res.content;
            _this.dataService.skiniSaStanjaUkolikoJeUKorpi(_this.roba);
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
    FilteriComponent.prototype.pronadjiFilterePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.robaService.pronadjiFiltere(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
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
            template: __webpack_require__(/*! ./filteri.component.html */ "./src/app/roba/filteri/filteri.component.html"),
            styles: [__webpack_require__(/*! ./filteri.component.css */ "./src/app/roba/filteri/filteri.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__["RobaService"],
            src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__["ProizvodjacService"],
            src_app_service_data_service__WEBPACK_IMPORTED_MODULE_5__["DataService"],
            src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_6__["AppUtilsService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatSnackBar"]])
    ], FilteriComponent);
    return FilteriComponent;
}());



/***/ }),

/***/ "./src/app/roba/roba.component.css":
/*!*****************************************!*\
  !*** ./src/app/roba/roba.component.css ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/roba/roba.component.html":
/*!******************************************!*\
  !*** ./src/app/roba/roba.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n    <div class=\"d-flex align-items-center justify-content-center\">\r\n        <div class=\"forms-input\">\r\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                <button mat-mini-fab color=\"primary\">\r\n                    <mat-icon>search</mat-icon>\r\n                </button>\r\n            </div>\r\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                <button *ngIf=\"!otvoriFilterDiv\" mat-mini-fab color=\"primary\">\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab color=\"warn\">\r\n                    <mat-icon>view_headline</mat-icon>\r\n                </button>\r\n            </div>\r\n        </div>\r\n    </div>\r\n    <div class=\"d-flex justify-content-center\">\r\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\r\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\r\n        </label>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\r\n        <div class=\"filter-div-test d-flex flex-column\">\r\n            <div class=\"d-flex justify-content-center\">\r\n                <h4>\r\n                    Filter\r\n                </h4>\r\n            </div>\r\n            <div class=\"input-group mb-3\">\r\n                <div class=\"input-group-prepend\">\r\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Proizvodjac: </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\r\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">{{proizvodjac.naziv}}</option>\r\n                </select>\r\n\r\n                <div class=\"input-group-prepend razmak\">\r\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Raspolozivost: </label>\r\n                </div>\r\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\r\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\r\n                </select>\r\n            </div>\r\n            <div class=\"d-flex justify-content-center\">\r\n                <div>\r\n                    <button mat-stroked-button color=\"primary\" (click)='filtriraj()'>Filtriraj</button>\r\n                    <span class=\"col-2\"></span>\r\n                    <button mat-stroked-button color=\"warn\" (click)='resetujFilter()'>Ponisti</button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n\r\n\r\n    <div class=\"tabela-div mat-elevation-z8\">\r\n        <div style=\"overflow-x:auto;\">\r\n            <table mat-table [dataSource]=\"dataSource\" matSort (matSortChange)=\"sortData($event)\">\r\n                <!-- Kataloski broj Column -->\r\n                <ng-container matColumnDef=\"katbr\">\r\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.katbr}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Kataloski broj proizvodjaca Column -->\r\n                <ng-container matColumnDef=\"katbrpro\">\r\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj proizvodjaca </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-1\">\r\n                            {{roba.katbrpro}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Naziv Column -->\r\n                <ng-container matColumnDef=\"naziv\">\r\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-1\">\r\n                            {{roba.naziv}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Proizvodjac Column -->\r\n                <ng-container matColumnDef=\"proizvodjac\">\r\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.proizvodjac}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Cena Column -->\r\n                <ng-container matColumnDef=\"cena\">\r\n                    <th mat-header-cell *matHeaderCellDef> Cena </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <p class=\"mat-body-2\">\r\n                            {{roba.cena}}\r\n                        </p>\r\n                    </td>\r\n                </ng-container>\r\n\r\n                <!-- Stanje Column -->\r\n                <ng-container matColumnDef=\"stanje\">\r\n                    <th mat-header-cell *matHeaderCellDef> Stanje </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\">\r\n                            <mat-icon color=\"primary\">check_circle_outline</mat-icon>\r\n                        </div>\r\n                        <div *ngIf=\"roba.stanje == 0\">\r\n                            <mat-icon color=\"accent\">remove_circle_outline</mat-icon>\r\n                        </div>\r\n                    </td>\r\n                </ng-container>\r\n\r\n\r\n                <!-- Kolicina Column -->\r\n                <ng-container matColumnDef=\"kolicina\">\r\n                    <th mat-header-cell *matHeaderCellDef>Kolicina </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\">\r\n                            <input type=\"number\" min=\"1\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\"\r\n                                class=\"kolicina-input\" />\r\n                        </div>\r\n                </ng-container>\r\n\r\n                <!-- Kropa dugme Column -->\r\n                <ng-container matColumnDef=\"korpa\">\r\n                    <th mat-header-cell *matHeaderCellDef> </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"roba.stanje > 0\">\r\n                            <button mat-raised-button color=\"primary\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\r\n                        </div>\r\n                </ng-container>\r\n\r\n                <!-- Da li ima na stanju ikona -->\r\n                <ng-container matColumnDef=\"u-korpi\">\r\n                    <th mat-header-cell *matHeaderCellDef> </th>\r\n                    <td mat-cell *matCellDef=\"let roba\">\r\n                        <div *ngIf=\"uKorpi(roba.katbr)\">\r\n                            <mat-icon color=\"accent\">add_shopping_cart</mat-icon>\r\n                        </div>\r\n                </ng-container>\r\n\r\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\r\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\r\n            </table>\r\n        </div>\r\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\r\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\r\n        </mat-paginator>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "./src/app/roba/roba.component.ts":
/*!****************************************!*\
  !*** ./src/app/roba/roba.component.ts ***!
  \****************************************/
/*! exports provided: RobaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RobaComponent", function() { return RobaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_roba_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../service/roba.service */ "./src/app/service/roba.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../service/proizvodjac.service */ "./src/app/service/proizvodjac.service.ts");
/* harmony import */ var _service_data_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../service/data.service */ "./src/app/service/data.service.ts");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../utils/app-utils.service */ "./src/app/utils/app-utils.service.ts");
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
    function RobaComponent(robaService, proizvodjacService, dataService, utilsService, korpaSnackBar) {
        this.robaService = robaService;
        this.proizvodjacService = proizvodjacService;
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
        this.otvoriFilterDiv = false;
        this.displayedColumns = ['katbr', 'katbrpro', 'naziv',
            'proizvodjac', 'cena', 'stanje', 'kolicina', 'korpa', 'u-korpi'];
        this.alive = true;
    }
    RobaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.pronadjiSveProizvodjace();
    };
    RobaComponent.prototype.pronadjiSvuRobu = function () {
        var _this = this;
        this.robaService.pronadjiSvuRobu(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
        this.ucitavanje = true;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.robaService.pronadjiSvuRobu(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
            template: __webpack_require__(/*! ./roba.component.html */ "./src/app/roba/roba.component.html"),
            styles: [__webpack_require__(/*! ./roba.component.css */ "./src/app/roba/roba.component.css")]
        }),
        __metadata("design:paramtypes", [_service_roba_service__WEBPACK_IMPORTED_MODULE_1__["RobaService"],
            _service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_4__["ProizvodjacService"],
            _service_data_service__WEBPACK_IMPORTED_MODULE_5__["DataService"],
            _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_6__["AppUtilsService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatSnackBar"]])
    ], RobaComponent);
    return RobaComponent;
}());



/***/ }),

/***/ "./src/app/roba/ulja/antifriz/antifriz.component.css":
/*!***********************************************************!*\
  !*** ./src/app/roba/ulja/antifriz/antifriz.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/roba/ulja/antifriz/antifriz.component.html":
/*!************************************************************!*\
  !*** ./src/app/roba/ulja/antifriz/antifriz.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n\n    <div class=\"d-flex align-items-center justify-content-center\">\n        <div class=\"forms-input\">\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\n                <button mat-mini-fab color=\"primary\">\n                    <mat-icon>search</mat-icon>\n                </button>\n            </div>\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\n                <button *ngIf=\"!otvoriFilterDiv\" mat-mini-fab color=\"primary\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab color=\"warn\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n            </div>\n        </div>\n    </div>\n    <div class=\"d-flex justify-content-center\">\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\n        </label>\n    </div>\n\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\n        <div class=\"filter-div-test d-flex flex-column\">\n            <div class=\"d-flex justify-content-center\">\n                <h4>\n                    Filter\n                </h4>\n            </div>\n            <div class=\"input-group mb-3\">\n                <div class=\"input-group-prepend\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Proizvodjac: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">{{proizvodjac.naziv}}</option>\n                </select>\n\n                <div class=\"input-group-prepend razmak\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Raspolozivost: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\n                </select>\n            </div>\n            <div class=\"d-flex justify-content-center\">\n                <div>\n                    <button mat-stroked-button color=\"primary\" (click)='filtriraj()'>Filtriraj</button>\n                    <span class=\"col-2\"></span>\n                    <button mat-stroked-button color=\"warn\" (click)='resetujFilter()'>Ponisti</button>\n                </div>\n            </div>\n        </div>\n    </div>\n\n\n    <div class=\"tabela-div mat-elevation-z8\">\n        <div style=\"overflow-x:auto;\">\n            <table mat-table [dataSource]=\"dataSource\" matSort (matSortChange)=\"sortData($event)\">\n                <!-- Kataloski broj Column -->\n                <ng-container matColumnDef=\"katbr\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.katbr}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Kataloski broj proizvodjaca Column -->\n                <ng-container matColumnDef=\"katbrpro\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj proizvodjaca </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.katbrpro}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Naziv Column -->\n                <ng-container matColumnDef=\"naziv\">\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.naziv}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Proizvodjac Column -->\n                <ng-container matColumnDef=\"proizvodjac\">\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.proizvodjac}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Cena Column -->\n                <ng-container matColumnDef=\"cena\">\n                    <th mat-header-cell *matHeaderCellDef> Cena </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.cena}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Stanje Column -->\n                <ng-container matColumnDef=\"stanje\">\n                    <th mat-header-cell *matHeaderCellDef> Stanje </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <mat-icon class=\"gren-icon\">check_circle_outline</mat-icon>\n                        </div>\n                        <div *ngIf=\"roba.stanje == 0\">\n                            <mat-icon color=\"accent\">remove_circle_outline</mat-icon>\n                        </div>\n                    </td>\n                </ng-container>\n\n\n                <!-- Kolicina Column -->\n                <ng-container matColumnDef=\"kolicina\">\n                    <th mat-header-cell *matHeaderCellDef>Kolicina </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <input type=\"number\" min=\"1\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\"\n                                class=\"kolicina-input\" />\n                        </div>\n                </ng-container>\n\n                <!-- Kropa dugme Column -->\n                <ng-container matColumnDef=\"korpa\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <button mat-raised-button color=\"primary\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\n                        </div>\n                </ng-container>\n\n                <!-- Da li ima na stanju ikona -->\n                <ng-container matColumnDef=\"u-korpi\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"uKorpi(roba.katbr)\">\n                            <mat-icon color=\"accent\">add_shopping_cart</mat-icon>\n                        </div>\n                </ng-container>\n\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n            </table>\n        </div>\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\n        </mat-paginator>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/roba/ulja/antifriz/antifriz.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/roba/ulja/antifriz/antifriz.component.ts ***!
  \**********************************************************/
/*! exports provided: AntifrizComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AntifrizComponent", function() { return AntifrizComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/service/roba.service */ "./src/app/service/roba.service.ts");
/* harmony import */ var src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/proizvodjac.service */ "./src/app/service/proizvodjac.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/utils/app-utils.service */ "./src/app/utils/app-utils.service.ts");
/* harmony import */ var src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/service/data.service */ "./src/app/service/data.service.ts");
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
    function AntifrizComponent(robaService, utilsService, proizvodjacService, dataService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
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
        this.otvoriFilterDiv = false;
        this.displayedColumns = ['katbr', 'katbrpro', 'naziv',
            'proizvodjac', 'cena', 'stanje', 'kolicina', 'korpa', 'u-korpi'];
        this.alive = true;
        this.vrstaUlja = 'antifriz';
    }
    AntifrizComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.pronadjiSveProizvodjace();
    };
    AntifrizComponent.prototype.pronandjiSavAntifriz = function () {
        var _this = this;
        this.ucitavanje = true;
        this.dataSource = null;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
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
            template: __webpack_require__(/*! ./antifriz.component.html */ "./src/app/roba/ulja/antifriz/antifriz.component.html"),
            styles: [__webpack_require__(/*! ./antifriz.component.css */ "./src/app/roba/ulja/antifriz/antifriz.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__["RobaService"],
            src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__["ProizvodjacService"],
            src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__["DataService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatSnackBar"]])
    ], AntifrizComponent);
    return AntifrizComponent;
}());



/***/ }),

/***/ "./src/app/roba/ulja/industrijska/industrijska.component.css":
/*!*******************************************************************!*\
  !*** ./src/app/roba/ulja/industrijska/industrijska.component.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".smanji {\r\n    width: 30%;\r\n    float: right;\r\n}\r\n\r\n@media only screen and (max-device-width : 640px) { \r\n    .smanji {\r\n        width: 100%;\r\n    }\r\n    \r\n}"

/***/ }),

/***/ "./src/app/roba/ulja/industrijska/industrijska.component.html":
/*!********************************************************************!*\
  !*** ./src/app/roba/ulja/industrijska/industrijska.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n    <div class=\"d-flex col-lg p-2 justify-content-center smanji\">\n        <div class=\"input-group-prepend\">\n            <label class=\"input-group-text\" for=\"inputGroupSelect01\">Izaberite vrstu maziva:</label>\n        </div>\n        <select class=\"custom-select\" (change)=\"onChange()\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaVrsta\">\n            <option *ngFor=\"let izabranaVrsta of vrste\" [value]=\"izabranaVrsta\">{{izabranaVrsta}}</option>\n        </select>\n    </div>\n    <div class=\"d-flex align-items-center col-lg justify-content-center\">\n        <div class=\"forms-input\">\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\n                <button mat-mini-fab color=\"primary\">\n                    <mat-icon>search</mat-icon>\n                </button>\n            </div>\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\n                <button *ngIf=\"!otvoriFilterDiv\" mat-mini-fab color=\"primary\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab color=\"warn\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n            </div>\n        </div>\n    </div>\n    <div class=\"d-flex justify-content-center\">\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\n        </label>\n    </div>\n\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\n        <div class=\"filter-div-test d-flex flex-column\">\n            <div class=\"d-flex justify-content-center\">\n                <h4>\n                    Filter\n                </h4>\n            </div>\n            <div class=\"input-group mb-3\">\n                <div class=\"input-group-prepend\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Proizvodjac: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">{{proizvodjac.naziv}}</option>\n                </select>\n\n                <div class=\"input-group-prepend razmak\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Raspolozivost: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\n                </select>\n            </div>\n            <div class=\"d-flex justify-content-center\">\n                <div>\n                    <button mat-stroked-button color=\"primary\" (click)='filtriraj()'>Filtriraj</button>\n                    <span class=\"col-2\"></span>\n                    <button mat-stroked-button color=\"warn\" (click)='resetujFilter()'>Ponisti</button>\n                </div>\n            </div>\n        </div>\n    </div>\n\n\n    <div class=\"tabela-div mat-elevation-z8\">\n        <div style=\"overflow-x:auto;\">\n            <table mat-table [dataSource]=\"dataSource\" matSort (matSortChange)=\"sortData($event)\">\n                <!-- Kataloski broj Column -->\n                <ng-container matColumnDef=\"katbr\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.katbr}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Kataloski broj proizvodjaca Column -->\n                <ng-container matColumnDef=\"katbrpro\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj proizvodjaca </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.katbrpro}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Naziv Column -->\n                <ng-container matColumnDef=\"naziv\">\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.naziv}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Proizvodjac Column -->\n                <ng-container matColumnDef=\"proizvodjac\">\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.proizvodjac}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Cena Column -->\n                <ng-container matColumnDef=\"cena\">\n                    <th mat-header-cell *matHeaderCellDef> Cena </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.cena}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Stanje Column -->\n                <ng-container matColumnDef=\"stanje\">\n                    <th mat-header-cell *matHeaderCellDef> Stanje </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <mat-icon class=\"gren-icon\">check_circle_outline</mat-icon>\n                        </div>\n                        <div *ngIf=\"roba.stanje == 0\">\n                            <mat-icon color=\"accent\">remove_circle_outline</mat-icon>\n                        </div>\n                    </td>\n                </ng-container>\n\n\n                <!-- Kolicina Column -->\n                <ng-container matColumnDef=\"kolicina\">\n                    <th mat-header-cell *matHeaderCellDef>Kolicina </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <input type=\"number\" min=\"1\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\"\n                                class=\"kolicina-input\" />\n                        </div>\n                </ng-container>\n\n                <!-- Kropa dugme Column -->\n                <ng-container matColumnDef=\"korpa\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <button mat-raised-button color=\"primary\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\n                        </div>\n                </ng-container>\n\n                <!-- Da li ima na stanju ikona -->\n                <ng-container matColumnDef=\"u-korpi\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"uKorpi(roba.katbr)\">\n                            <mat-icon color=\"accent\">add_shopping_cart</mat-icon>\n                        </div>\n                </ng-container>\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n            </table>\n        </div>\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\n        </mat-paginator>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/roba/ulja/industrijska/industrijska.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/roba/ulja/industrijska/industrijska.component.ts ***!
  \******************************************************************/
/*! exports provided: IndustrijskaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "IndustrijskaComponent", function() { return IndustrijskaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/service/roba.service */ "./src/app/service/roba.service.ts");
/* harmony import */ var src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/proizvodjac.service */ "./src/app/service/proizvodjac.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/utils/app-utils.service */ "./src/app/utils/app-utils.service.ts");
/* harmony import */ var src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/service/data.service */ "./src/app/service/data.service.ts");
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
    function IndustrijskaComponent(robaService, utilsService, proizvodjacService, dataService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
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
        this.otvoriFilterDiv = false;
        this.displayedColumns = ['katbr', 'katbrpro', 'naziv',
            'proizvodjac', 'cena', 'stanje', 'kolicina', 'korpa', 'u-korpi'];
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
        this.pronadjiSveProizvodjace();
    };
    IndustrijskaComponent.prototype.pronandjiUlja = function () {
        var _this = this;
        this.ucitavanje = true;
        this.dataSource = null;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
    IndustrijskaComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
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
            template: __webpack_require__(/*! ./industrijska.component.html */ "./src/app/roba/ulja/industrijska/industrijska.component.html"),
            styles: [__webpack_require__(/*! ./industrijska.component.css */ "./src/app/roba/ulja/industrijska/industrijska.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__["RobaService"],
            src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__["ProizvodjacService"],
            src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__["DataService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatSnackBar"]])
    ], IndustrijskaComponent);
    return IndustrijskaComponent;
}());



/***/ }),

/***/ "./src/app/roba/ulja/kociona/kociona.component.css":
/*!*********************************************************!*\
  !*** ./src/app/roba/ulja/kociona/kociona.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/roba/ulja/kociona/kociona.component.html":
/*!**********************************************************!*\
  !*** ./src/app/roba/ulja/kociona/kociona.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n\n    <div class=\"d-flex align-items-center justify-content-center\">\n        <div class=\"forms-input\">\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\n                <button mat-mini-fab color=\"primary\">\n                    <mat-icon>search</mat-icon>\n                </button>\n            </div>\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\n                <button *ngIf=\"!otvoriFilterDiv\" mat-mini-fab color=\"primary\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab color=\"warn\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n            </div>\n        </div>\n    </div>\n    <div class=\"d-flex justify-content-center\">\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\n        </label>\n    </div>\n\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\n        <div class=\"filter-div-test d-flex flex-column\">\n            <div class=\"d-flex justify-content-center\">\n                <h4>\n                    Filter\n                </h4>\n            </div>\n            <div class=\"input-group mb-3\">\n                <div class=\"input-group-prepend\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Proizvodjac: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">{{proizvodjac.naziv}}</option>\n                </select>\n\n                <div class=\"input-group-prepend razmak\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Raspolozivost: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\n                </select>\n            </div>\n            <div class=\"d-flex justify-content-center\">\n                <div>\n                    <button mat-stroked-button color=\"primary\" (click)='filtriraj()'>Filtriraj</button>\n                    <span class=\"col-2\"></span>\n                    <button mat-stroked-button color=\"warn\" (click)='resetujFilter()'>Ponisti</button>\n                </div>\n            </div>\n        </div>\n    </div>\n\n\n    <div class=\"tabela-div mat-elevation-z8\">\n        <div style=\"overflow-x:auto;\">\n            <table mat-table [dataSource]=\"dataSource\" matSort (matSortChange)=\"sortData($event)\">\n                <!-- Kataloski broj Column -->\n                <ng-container matColumnDef=\"katbr\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.katbr}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Kataloski broj proizvodjaca Column -->\n                <ng-container matColumnDef=\"katbrpro\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj proizvodjaca </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.katbrpro}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Naziv Column -->\n                <ng-container matColumnDef=\"naziv\">\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.naziv}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Proizvodjac Column -->\n                <ng-container matColumnDef=\"proizvodjac\">\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.proizvodjac}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Cena Column -->\n                <ng-container matColumnDef=\"cena\">\n                    <th mat-header-cell *matHeaderCellDef> Cena </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.cena}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Stanje Column -->\n                <ng-container matColumnDef=\"stanje\">\n                    <th mat-header-cell *matHeaderCellDef> Stanje </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <mat-icon class=\"gren-icon\">check_circle_outline</mat-icon>\n                        </div>\n                        <div *ngIf=\"roba.stanje == 0\">\n                            <mat-icon color=\"accent\">remove_circle_outline</mat-icon>\n                        </div>\n                    </td>\n                </ng-container>\n\n\n                <!-- Kolicina Column -->\n                <ng-container matColumnDef=\"kolicina\">\n                    <th mat-header-cell *matHeaderCellDef>Kolicina </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <input type=\"number\" min=\"1\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\"\n                                class=\"kolicina-input\" />\n                        </div>\n                </ng-container>\n\n                <!-- Kropa dugme Column -->\n                <ng-container matColumnDef=\"korpa\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <button mat-raised-button color=\"primary\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\n                        </div>\n                </ng-container>\n\n                <!-- Da li ima na stanju ikona -->\n                <ng-container matColumnDef=\"u-korpi\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"uKorpi(roba.katbr)\">\n                            <mat-icon color=\"accent\">add_shopping_cart</mat-icon>\n                        </div>\n                </ng-container>\n\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n            </table>\n        </div>\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\n        </mat-paginator>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/roba/ulja/kociona/kociona.component.ts":
/*!********************************************************!*\
  !*** ./src/app/roba/ulja/kociona/kociona.component.ts ***!
  \********************************************************/
/*! exports provided: KocionaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KocionaComponent", function() { return KocionaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/service/roba.service */ "./src/app/service/roba.service.ts");
/* harmony import */ var src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/proizvodjac.service */ "./src/app/service/proizvodjac.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/utils/app-utils.service */ "./src/app/utils/app-utils.service.ts");
/* harmony import */ var src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/service/data.service */ "./src/app/service/data.service.ts");
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
    function KocionaComponent(robaService, utilsService, proizvodjacService, dataService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
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
        this.otvoriFilterDiv = false;
        this.displayedColumns = ['katbr', 'katbrpro', 'naziv',
            'proizvodjac', 'cena', 'stanje', 'kolicina', 'korpa', 'u-korpi'];
        this.alive = true;
        this.vrstaUlja = 'kociona';
    }
    KocionaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.pronadjiSveProizvodjace();
    };
    KocionaComponent.prototype.pronandjiSvaKocionaUlja = function () {
        var _this = this;
        this.ucitavanje = true;
        this.dataSource = null;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
    KocionaComponent.prototype.pronadjiEntitetePoPretrazi = function (searchValue) {
        var _this = this;
        this.pocetnoPretrazivanje = false;
        this.lastSearchValue = searchValue;
        this.ucitavanje = true;
        this.dataSource = null;
        var naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
        var proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
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
            template: __webpack_require__(/*! ./kociona.component.html */ "./src/app/roba/ulja/kociona/kociona.component.html"),
            styles: [__webpack_require__(/*! ./kociona.component.css */ "./src/app/roba/ulja/kociona/kociona.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__["RobaService"],
            src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__["ProizvodjacService"],
            src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__["DataService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatSnackBar"]])
    ], KocionaComponent);
    return KocionaComponent;
}());



/***/ }),

/***/ "./src/app/roba/ulja/menjacko/menjacko.component.css":
/*!***********************************************************!*\
  !*** ./src/app/roba/ulja/menjacko/menjacko.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/roba/ulja/menjacko/menjacko.component.html":
/*!************************************************************!*\
  !*** ./src/app/roba/ulja/menjacko/menjacko.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n\n    <div class=\"d-flex align-items-center justify-content-center\">\n        <div class=\"forms-input\">\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\n                <button mat-mini-fab color=\"primary\">\n                    <mat-icon>search</mat-icon>\n                </button>\n            </div>\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\n                <button *ngIf=\"!otvoriFilterDiv\" mat-mini-fab color=\"primary\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab color=\"warn\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n            </div>\n        </div>\n    </div>\n    <div class=\"d-flex justify-content-center\">\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\n        </label>\n    </div>\n\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\n        <div class=\"filter-div-test d-flex flex-column\">\n            <div class=\"d-flex justify-content-center\">\n                <h4>\n                    Filter\n                </h4>\n            </div>\n            <div class=\"input-group mb-3\">\n                <div class=\"input-group-prepend\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Proizvodjac: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">{{proizvodjac.naziv}}</option>\n                </select>\n\n                <div class=\"input-group-prepend razmak\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Raspolozivost: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\n                </select>\n            </div>\n            <div class=\"d-flex justify-content-center\">\n                <div>\n                    <button mat-stroked-button color=\"primary\" (click)='filtriraj()'>Filtriraj</button>\n                    <span class=\"col-2\"></span>\n                    <button mat-stroked-button color=\"warn\" (click)='resetujFilter()'>Ponisti</button>\n                </div>\n            </div>\n        </div>\n    </div>\n\n\n    <div class=\"tabela-div mat-elevation-z8\">\n        <div style=\"overflow-x:auto;\">\n            <table mat-table [dataSource]=\"dataSource\" matSort (matSortChange)=\"sortData($event)\">\n                <!-- Kataloski broj Column -->\n                <ng-container matColumnDef=\"katbr\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.katbr}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Kataloski broj proizvodjaca Column -->\n                <ng-container matColumnDef=\"katbrpro\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj proizvodjaca </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.katbrpro}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Naziv Column -->\n                <ng-container matColumnDef=\"naziv\">\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.naziv}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Proizvodjac Column -->\n                <ng-container matColumnDef=\"proizvodjac\">\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.proizvodjac}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Cena Column -->\n                <ng-container matColumnDef=\"cena\">\n                    <th mat-header-cell *matHeaderCellDef> Cena </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.cena}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Stanje Column -->\n                <ng-container matColumnDef=\"stanje\">\n                    <th mat-header-cell *matHeaderCellDef> Stanje </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <mat-icon class=\"gren-icon\">check_circle_outline</mat-icon>\n                        </div>\n                        <div *ngIf=\"roba.stanje == 0\">\n                            <mat-icon color=\"accent\">remove_circle_outline</mat-icon>\n                        </div>\n                    </td>\n                </ng-container>\n\n\n                <!-- Kolicina Column -->\n                <ng-container matColumnDef=\"kolicina\">\n                    <th mat-header-cell *matHeaderCellDef>Kolicina </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <input type=\"number\" min=\"1\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\"\n                                class=\"kolicina-input\" />\n                        </div>\n                </ng-container>\n\n                <!-- Kropa dugme Column -->\n                <ng-container matColumnDef=\"korpa\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <button mat-raised-button color=\"primary\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\n                        </div>\n                </ng-container>\n\n                <!-- Da li ima na stanju ikona -->\n                <ng-container matColumnDef=\"u-korpi\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"uKorpi(roba.katbr)\">\n                            <mat-icon color=\"accent\">add_shopping_cart</mat-icon>\n                        </div>\n                </ng-container>\n\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n            </table>\n        </div>\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\n        </mat-paginator>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/roba/ulja/menjacko/menjacko.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/roba/ulja/menjacko/menjacko.component.ts ***!
  \**********************************************************/
/*! exports provided: MenjackoComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MenjackoComponent", function() { return MenjackoComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/service/roba.service */ "./src/app/service/roba.service.ts");
/* harmony import */ var src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/proizvodjac.service */ "./src/app/service/proizvodjac.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/utils/app-utils.service */ "./src/app/utils/app-utils.service.ts");
/* harmony import */ var src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/service/data.service */ "./src/app/service/data.service.ts");
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
    function MenjackoComponent(robaService, utilsService, proizvodjacService, dataService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
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
        this.otvoriFilterDiv = false;
        this.displayedColumns = ['katbr', 'katbrpro', 'naziv',
            'proizvodjac', 'cena', 'stanje', 'kolicina', 'korpa', 'u-korpi'];
        this.alive = true;
        this.vrstaUlja = 'menjacka';
    }
    MenjackoComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.pronadjiSveProizvodjace();
    };
    MenjackoComponent.prototype.pronandjiSvaMenjackaUlja = function () {
        var _this = this;
        this.ucitavanje = true;
        this.dataSource = null;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
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
            template: __webpack_require__(/*! ./menjacko.component.html */ "./src/app/roba/ulja/menjacko/menjacko.component.html"),
            styles: [__webpack_require__(/*! ./menjacko.component.css */ "./src/app/roba/ulja/menjacko/menjacko.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__["RobaService"],
            src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__["ProizvodjacService"],
            src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__["DataService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatSnackBar"]])
    ], MenjackoComponent);
    return MenjackoComponent;
}());



/***/ }),

/***/ "./src/app/roba/ulja/motorna/motorna.component.css":
/*!*********************************************************!*\
  !*** ./src/app/roba/ulja/motorna/motorna.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/roba/ulja/motorna/motorna.component.html":
/*!**********************************************************!*\
  !*** ./src/app/roba/ulja/motorna/motorna.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n\n    <div class=\"d-flex align-items-center justify-content-center\">\n        <div class=\"forms-input\">\n            <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\" (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\n            <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\n                <button mat-mini-fab color=\"primary\">\n                    <mat-icon>search</mat-icon>\n                </button>\n            </div>\n            <div class=\"p-1\" (click)='toogleFilterDiv()'>\n                <button *ngIf=\"!otvoriFilterDiv\" mat-mini-fab color=\"primary\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n                <button *ngIf=\"otvoriFilterDiv\" mat-mini-fab color=\"warn\">\n                    <mat-icon>view_headline</mat-icon>\n                </button>\n            </div>\n        </div>\n    </div>\n    <div class=\"d-flex justify-content-center\">\n        <label *ngIf=\"pocetnoPretrazivanje\" class=\"mat-caption\">\n            <font color=\"#424242\"> Ukucajte kataloski broj</font>\n        </label>\n    </div>\n\n    <div class=\"d-flex justify-content-center\" *ngIf=\"otvoriFilterDiv\">\n        <div class=\"filter-div-test d-flex flex-column\">\n            <div class=\"d-flex justify-content-center\">\n                <h4>\n                    Filter\n                </h4>\n            </div>\n            <div class=\"input-group mb-3\">\n                <div class=\"input-group-prepend\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Proizvodjac: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabraniProizvodjac\">\n                    <option *ngFor=\"let proizvodjac of proizvodjaci\" [value]=\"proizvodjac.naziv\">{{proizvodjac.naziv}}</option>\n                </select>\n\n                <div class=\"input-group-prepend razmak\">\n                    <label class=\"input-group-text\" for=\"inputGroupSelect01\">Raspolozivost: </label>\n                </div>\n                <select class=\"custom-select\" id=\"inputGroupSelect01\" [(ngModel)]=\"izabranaRaspolozivost\">\n                    <option *ngFor=\"let raspoloziv of raspolozivost\" [value]=\"raspoloziv\">{{raspoloziv}}</option>\n                </select>\n            </div>\n            <div class=\"d-flex justify-content-center\">\n                <div>\n                    <button mat-stroked-button color=\"primary\" (click)='filtriraj()'>Filtriraj</button>\n                    <span class=\"col-2\"></span>\n                    <button mat-stroked-button color=\"warn\" (click)='resetujFilter()'>Ponisti</button>\n                </div>\n            </div>\n        </div>\n    </div>\n\n\n    <div class=\"tabela-div mat-elevation-z8\">\n        <div style=\"overflow-x:auto;\">\n            <table mat-table [dataSource]=\"dataSource\" matSort (matSortChange)=\"sortData($event)\">\n                <!-- Kataloski broj Column -->\n                <ng-container matColumnDef=\"katbr\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.katbr}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Kataloski broj proizvodjaca Column -->\n                <ng-container matColumnDef=\"katbrpro\">\n                    <th mat-header-cell mat-sort-header *matHeaderCellDef> Kataloski broj proizvodjaca </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.katbrpro}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Naziv Column -->\n                <ng-container matColumnDef=\"naziv\">\n                    <th mat-header-cell *matHeaderCellDef> Naziv </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-1\">\n                            {{roba.naziv}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Proizvodjac Column -->\n                <ng-container matColumnDef=\"proizvodjac\">\n                    <th mat-header-cell *matHeaderCellDef> Proizvodjac </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.proizvodjac}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Cena Column -->\n                <ng-container matColumnDef=\"cena\">\n                    <th mat-header-cell *matHeaderCellDef> Cena </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <p class=\"mat-body-2\">\n                            {{roba.cena}}\n                        </p>\n                    </td>\n                </ng-container>\n\n                <!-- Stanje Column -->\n                <ng-container matColumnDef=\"stanje\">\n                    <th mat-header-cell *matHeaderCellDef> Stanje </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <mat-icon class=\"gren-icon\">check_circle_outline</mat-icon>\n                        </div>\n                        <div *ngIf=\"roba.stanje == 0\">\n                            <mat-icon color=\"accent\">remove_circle_outline</mat-icon>\n                        </div>\n                    </td>\n                </ng-container>\n\n\n                <!-- Kolicina Column -->\n                <ng-container matColumnDef=\"kolicina\">\n                    <th mat-header-cell *matHeaderCellDef>Kolicina </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <input type=\"number\" min=\"1\" max=\"{{roba.stanje}}\" class=\"kolicina-labela\" [(ngModel)]=\"roba.kolicina\"\n                                class=\"kolicina-input\" />\n                        </div>\n                </ng-container>\n\n                <!-- Kropa dugme Column -->\n                <ng-container matColumnDef=\"korpa\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"roba.stanje > 0\">\n                            <button mat-raised-button color=\"primary\" (click)='dodajUKorpu(roba)'>Dodaj u korpu</button>\n                        </div>\n                </ng-container>\n\n                <!-- Da li ima na stanju ikona -->\n                <ng-container matColumnDef=\"u-korpi\">\n                    <th mat-header-cell *matHeaderCellDef> </th>\n                    <td mat-cell *matCellDef=\"let roba\">\n                        <div *ngIf=\"uKorpi(roba.katbr)\">\n                            <mat-icon color=\"accent\">add_shopping_cart</mat-icon>\n                        </div>\n                </ng-container>\n\n                <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n                <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n            </table>\n        </div>\n        <mat-paginator #paginator [length]=\"tableLength\" [pageSize]=\"rowsPerPage\" [pageSizeOptions]=\"[5, 10, 25]\"\n            [pageIndex]=\"pageIndex\" [length]=\"tableLength\" [showFirstLastButtons]=\"true\" (page)=\"paginatorEvent($event)\">\n        </mat-paginator>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/roba/ulja/motorna/motorna.component.ts":
/*!********************************************************!*\
  !*** ./src/app/roba/ulja/motorna/motorna.component.ts ***!
  \********************************************************/
/*! exports provided: MotornaComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MotornaComponent", function() { return MotornaComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/service/roba.service */ "./src/app/service/roba.service.ts");
/* harmony import */ var src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/service/proizvodjac.service */ "./src/app/service/proizvodjac.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/utils/app-utils.service */ "./src/app/utils/app-utils.service.ts");
/* harmony import */ var src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/service/data.service */ "./src/app/service/data.service.ts");
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
    function MotornaComponent(robaService, utilsService, proizvodjacService, dataService, korpaSnackBar) {
        this.robaService = robaService;
        this.utilsService = utilsService;
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
        this.otvoriFilterDiv = false;
        this.displayedColumns = ['katbr', 'katbrpro', 'naziv',
            'proizvodjac', 'cena', 'stanje', 'kolicina', 'korpa', 'u-korpi'];
        this.alive = true;
        this.vrstaUlja = 'motorna';
    }
    MotornaComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.pocetnoPretrazivanje = true;
        this.dataService.trenutnaKorpa.subscribe(function (korpa) { return _this.korpa = korpa; });
        this.pronadjiSveProizvodjace();
    };
    MotornaComponent.prototype.pronandjiSvoMotornoUlje = function () {
        var _this = this;
        this.ucitavanje = true;
        this.dataSource = null;
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
        this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, this.vrstaUlja)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
            .subscribe(function (res) {
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["takeWhile"])(function () { return _this.alive; }))
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
            template: __webpack_require__(/*! ./motorna.component.html */ "./src/app/roba/ulja/motorna/motorna.component.html"),
            styles: [__webpack_require__(/*! ./motorna.component.css */ "./src/app/roba/ulja/motorna/motorna.component.css")]
        }),
        __metadata("design:paramtypes", [src_app_service_roba_service__WEBPACK_IMPORTED_MODULE_1__["RobaService"],
            src_app_utils_app_utils_service__WEBPACK_IMPORTED_MODULE_5__["AppUtilsService"],
            src_app_service_proizvodjac_service__WEBPACK_IMPORTED_MODULE_2__["ProizvodjacService"],
            src_app_service_data_service__WEBPACK_IMPORTED_MODULE_6__["DataService"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatSnackBar"]])
    ], MotornaComponent);
    return MotornaComponent;
}());



/***/ }),

/***/ "./src/app/roba/ulja/ulja.component.css":
/*!**********************************************!*\
  !*** ./src/app/roba/ulja/ulja.component.css ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".industrijski-stil {\r\n    width: 100%;\r\n    height: 100%;\r\n}"

/***/ }),

/***/ "./src/app/roba/ulja/ulja.component.html":
/*!***********************************************!*\
  !*** ./src/app/roba/ulja/ulja.component.html ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"grid-container\">\n    <mat-tab-group mat-stretch-tabs>\n        <mat-tab label=\"Motorna ulja\">\n            <app-motorna></app-motorna>\n        </mat-tab>\n        <mat-tab label=\"Menjacka ulja\">\n            <app-menjacko></app-menjacko>\n        </mat-tab>\n        <mat-tab label=\"Kociona ulja\">\n            <app-kociona></app-kociona>\n        </mat-tab>\n        <mat-tab label=\"Antifiriz\">\n            <app-antifriz></app-antifriz>\n        </mat-tab>\n        <mat-tab label=\"Industrijska ulja\">\n            <app-industrijska></app-industrijska>\n        </mat-tab>\n    </mat-tab-group>\n</div>"

/***/ }),

/***/ "./src/app/roba/ulja/ulja.component.ts":
/*!*********************************************!*\
  !*** ./src/app/roba/ulja/ulja.component.ts ***!
  \*********************************************/
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
            template: __webpack_require__(/*! ./ulja.component.html */ "./src/app/roba/ulja/ulja.component.html"),
            styles: [__webpack_require__(/*! ./ulja.component.css */ "./src/app/roba/ulja/ulja.component.css")]
        })
    ], UljaComponent);
    return UljaComponent;
}());



/***/ }),

/***/ "./src/app/service/data.service.ts":
/*!*****************************************!*\
  !*** ./src/app/service/data.service.ts ***!
  \*****************************************/
/*! exports provided: DataService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DataService", function() { return DataService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _model_porudzbenica__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../model/porudzbenica */ "./src/app/model/porudzbenica.ts");
/* harmony import */ var _local_storage_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./local-storage.service */ "./src/app/service/local-storage.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var DataService = /** @class */ (function () {
    function DataService(korpaStorage) {
        this.korpaStorage = korpaStorage;
        this.korpa = this.korpaStorage.vratiKorpuIzMemorije() || new _model_porudzbenica__WEBPACK_IMPORTED_MODULE_2__["Korpa"]();
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
    DataService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_local_storage_service__WEBPACK_IMPORTED_MODULE_3__["LocalStorageService"]])
    ], DataService);
    return DataService;
}());



/***/ }),

/***/ "./src/app/service/local-storage.service.ts":
/*!**************************************************!*\
  !*** ./src/app/service/local-storage.service.ts ***!
  \**************************************************/
/*! exports provided: LocalStorageService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LocalStorageService", function() { return LocalStorageService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var angular_webstorage_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! angular-webstorage-service */ "./node_modules/angular-webstorage-service/bundles/angular-webstorage-service.es5.js");
/* harmony import */ var _model_porudzbenica__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../model/porudzbenica */ "./src/app/model/porudzbenica.ts");
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
var LocalStorageService = /** @class */ (function () {
    function LocalStorageService(storage) {
        this.storage = storage;
    }
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

/***/ "./src/app/service/login.service.ts":
/*!******************************************!*\
  !*** ./src/app/service/login.service.ts ***!
  \******************************************/
/*! exports provided: LoginService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginService", function() { return LoginService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var DOMAIN_URL = 'http://localhost:8080';
var LOGIN_URL = '/login';
var LoginService = /** @class */ (function () {
    function LoginService(http) {
        this.http = http;
    }
    LoginService.prototype.ulogujSe = function (credentials) {
        var fullUrl = DOMAIN_URL + LOGIN_URL;
        fullUrl = fullUrl + '?' +
            'username=' + credentials.username +
            '&password=' + credentials.password +
            '&submit=' + 'Login';
        return this.http.post(fullUrl, {}).subscribe(function (response) {
            console.log('EVO me');
        });
    };
    LoginService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], LoginService);
    return LoginService;
}());



/***/ }),

/***/ "./src/app/service/proizvodjac.service.ts":
/*!************************************************!*\
  !*** ./src/app/service/proizvodjac.service.ts ***!
  \************************************************/
/*! exports provided: ProizvodjacService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProizvodjacService", function() { return ProizvodjacService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../utils/app-utils.service */ "./src/app/utils/app-utils.service.ts");
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
var MOTORNA_UTL = '/motorna';
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (response) { return response.json(); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    ProizvodjacService.prototype.pronadjiSveProizvodjaceFiltera = function () {
        var fullUrl = DOMAIN_URL + ROBA_URL + FILTERI_URL;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (response) { return response.json(); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    ProizvodjacService.prototype.pronadjiSveProizvodjaceAkumulatora = function () {
        var fullUrl = DOMAIN_URL + ROBA_URL + AKUMULATORI_URL;
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (response) { return response.json(); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    ProizvodjacService.prototype.pronadjiSveProizvodjaceUljaPoVrsti = function (vrstaUlja) {
        var fullUrl = DOMAIN_URL + ROBA_URL + ULJA_URL + this.utils.vratiPutDoResursaZaUlje(vrstaUlja);
        return this.http
            .get(fullUrl)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (response) { return response.json(); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    ProizvodjacService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_http__WEBPACK_IMPORTED_MODULE_1__["Http"], _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__["AppUtilsService"]])
    ], ProizvodjacService);
    return ProizvodjacService;
}());



/***/ }),

/***/ "./src/app/service/roba.service.ts":
/*!*****************************************!*\
  !*** ./src/app/service/roba.service.ts ***!
  \*****************************************/
/*! exports provided: RobaService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RobaService", function() { return RobaService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../utils/app-utils.service */ "./src/app/utils/app-utils.service.ts");
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (response) { return response.json(); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (response) { return response.json(); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (response) { return response.json(); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
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
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (response) { return response.json(); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["timeoutWith"])(TIMEOUT, Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(TIMEOUT_ERROR)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(function (error) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(error); }));
    };
    RobaService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_http__WEBPACK_IMPORTED_MODULE_1__["Http"], _utils_app_utils_service__WEBPACK_IMPORTED_MODULE_4__["AppUtilsService"]])
    ], RobaService);
    return RobaService;
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
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatFormFieldModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSnackBarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatChipsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"],
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
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatExpansionModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"],
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

/***/ "./src/app/utils/app-utils.service.ts":
/*!********************************************!*\
  !*** ./src/app/utils/app-utils.service.ts ***!
  \********************************************/
/*! exports provided: AppUtilsService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppUtilsService", function() { return AppUtilsService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_porudzbenica__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../model/porudzbenica */ "./src/app/model/porudzbenica.ts");
/* harmony import */ var _service_data_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/data.service */ "./src/app/service/data.service.ts");
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
        if (roba.kolicina == null) {
            roba.kolicina = 1;
        }
        if (roba.stanje < roba.kolicina) {
            snackBarPoruka = 'Maksimalan kolicina ' + roba.stanje + '. ' + snackBarPoruka;
            roba.kolicina = roba.stanje;
        }
        var robaKorpa = new _model_porudzbenica__WEBPACK_IMPORTED_MODULE_1__["RobaKorpa"](roba.katbr, roba.katbrpro, roba.naziv, roba.proizvodjac, roba.kolicina, roba.cena, roba.stanje);
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
            if (value || value === 0) {
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
        __metadata("design:paramtypes", [_service_data_service__WEBPACK_IMPORTED_MODULE_2__["DataService"]])
    ], AppUtilsService);
    return AppUtilsService;
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