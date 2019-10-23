(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-shop-magacin-ulja-ulja-module"],{

/***/ "./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.css":
/*!*********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.css ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 130px;\r\n    background-image: url('/assets/slike/ui/pozadine/ulje.png');\r\n    background-repeat: no-repeat;\r\n    background-size: contain;\r\n}\r\n"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.html":
/*!**********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.html ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n\r\n    <div class=\"sekcija-pretraga ulje-pretraga-bar\">\r\n        <app-pretraga (pretragaEvent)=\"pronaciPoTrazenojReci($event)\" (filterEvent)=\"toogleFilterDiv($event)\">\r\n        </app-pretraga>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [vrstaUlja]=\"vrstaUlja\" [otvoriFilter]=\"otvoriFilter\"\r\n        (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

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
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
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
    function AntifrizComponent(robaService, dataService, loginService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.loginService = loginService;
        this.vrstaRobe = src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_5__["VrstaRobe"].ULJA;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_6__["Filter"]();
        this.searchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
        this.vrstaUlja = 'antifriz';
    }
    AntifrizComponent.prototype.ngOnInit = function () {
        this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji();
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
    AntifrizComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    AntifrizComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.searchValue = searchValue;
        this.pronadjiEntitetePoPretrazi(searchValue);
    };
    AntifrizComponent.prototype.toogleFilterDiv = function (otvoriFilter) {
        this.otvoriFilter = otvoriFilter;
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
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_7__["LoginService"]])
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

module.exports = ".sirina-odabira-vrste {\r\n  margin-top: 10px;\r\n  float: right;\r\n  width: 450px;\r\n}\r\n\r\n.input-group-prepend {\r\n  display: block;\r\n}\r\n\r\n.pretraga-bar-industrijska {\r\n  display: block;\r\n  padding-top: 10px;\r\n}\r\n\r\n.bg-image {\r\n  background-image: url('/assets/slike/ui/pozadine/ulje.png');\r\n  background-repeat: no-repeat;\r\n  background-size: contain;\r\n}\r\n\r\n.sekcija-pretraga {\r\n    height: 50px;\r\n}\r\n\r\n@media only screen and (max-device-width :1025px) { \r\n\r\n  .sekcija-pretraga {\r\n      height: 60px;\r\n  }\r\n\r\n    .mobilna-visina {\r\n      margin-top: 10px;\r\n    }\r\n  }\r\n\r\n@media only screen and (max-device-width : 640px) { \r\n\r\n\r\n  .mobilna-visina {\r\n    margin-top: 9px;\r\n  }\r\n  .input-group-text {\r\n    font-size: 0.9em;\r\n  }\r\n    \r\n    .sirina-odabira-vrste {\r\n        width: 100%;\r\n    }\r\n}\r\n"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.html":
/*!******************************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.html ***!
  \******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"bg-image\">\r\n        <div class=\"sekcija-pretraga\">\r\n            <div class=\"d-flex flex-row justify-content-end col-lg sirina-odabira-vrste\">\r\n                <div class=\"input-group-prepend\">\r\n                    <label class=\"pozadina-glavna-100 boja-siva-400 input-group-text \"\r\n                        for=\"inputGroupSelect01\">Izaberite\r\n                        vrstu\r\n                        maziva:</label>\r\n                </div>\r\n                <select class=\"custom-select mobilna-visina\" (change)=\"onChange()\" id=\"inputGroupSelect01\"\r\n                    [(ngModel)]=\"izabranaVrsta\">\r\n                    <option *ngFor=\"let izabranaVrsta of vrste\" [value]=\"izabranaVrsta\">{{izabranaVrsta}}</option>\r\n                </select>\r\n            </div>\r\n        </div>\r\n        <div class=\"pretraga-bar-industrijska\">\r\n            <app-pretraga (pretragaEvent)=\"pronaciPoTrazenojReci($event)\" (filterEvent)=\"toogleFilterDiv($event)\">\r\n            </app-pretraga>\r\n        </div>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [industrijkoUljeEvent]=\"vrstaIndustijskihUlja.asObservable()\" [vrstaRobe]=\"vrstaRobe\"\r\n        [vrstaUlja]=\"vrstaUlja\" [otvoriFilter]=\"otvoriFilter\" (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

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
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
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
    function IndustrijskaComponent(robaService, dataService, loginService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.loginService = loginService;
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
        this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji();
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
        this.searchValue = searchValue;
        this.pronadjiEntitetePoPretrazi(searchValue);
    };
    IndustrijskaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    IndustrijskaComponent.prototype.toogleFilterDiv = function (otvoriFilter) {
        this.otvoriFilter = otvoriFilter;
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
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_7__["LoginService"]])
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

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 130px;\r\n    background-image: url('/assets/slike/ui/pozadine/ulje.png');\r\n    background-repeat: no-repeat;\r\n    background-size: contain;\r\n}\r\n"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/kociona/kociona.component.html":
/*!********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/kociona/kociona.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"sekcija-pretraga ulje-pretraga-bar\">\r\n        <app-pretraga (pretragaEvent)=\"pronaciPoTrazenojReci($event)\" (filterEvent)=\"toogleFilterDiv($event)\">\r\n        </app-pretraga>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [vrstaUlja]=\"vrstaUlja\" [otvoriFilter]=\"otvoriFilter\"\r\n        (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

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
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
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
    function KocionaComponent(robaService, dataService, loginService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.loginService = loginService;
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
        this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji();
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
        this.searchValue = searchValue;
        this.pronadjiEntitetePoPretrazi(searchValue);
    };
    KocionaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    KocionaComponent.prototype.toogleFilterDiv = function (otvoriFilter) {
        this.otvoriFilter = otvoriFilter;
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
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_7__["LoginService"]])
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

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 130px;\r\n    background-image: url('/assets/slike/ui/pozadine/ulje.png');\r\n    background-repeat: no-repeat;\r\n    background-size: contain;\r\n}\r\n"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.html":
/*!**********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.html ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"sekcija-pretraga ulje-pretraga-bar\">\r\n        <app-pretraga (pretragaEvent)=\"pronaciPoTrazenojReci($event)\" (filterEvent)=\"toogleFilterDiv($event)\">\r\n        </app-pretraga>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [vrstaUlja]=\"vrstaUlja\" [otvoriFilter]=\"otvoriFilter\"\r\n        (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

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
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
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
    function MenjackoComponent(robaService, dataService, loginService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.loginService = loginService;
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
        this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji();
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
        this.searchValue = searchValue;
        this.pronadjiEntitetePoPretrazi(searchValue);
    };
    MenjackoComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    MenjackoComponent.prototype.toogleFilterDiv = function (otvoriFilter) {
        this.otvoriFilter = otvoriFilter;
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
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_7__["LoginService"]])
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

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 130px;\r\n    background-image: url('/assets/slike/ui/pozadine/ulje.png');\r\n    background-repeat: no-repeat;\r\n    background-size: contain;\r\n}\r\n"

/***/ }),

/***/ "./src/app/e-shop/magacin/ulja/motorna/motorna.component.html":
/*!********************************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/motorna/motorna.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"sekcija-pretraga ulje-pretraga-bar\">\r\n        <app-pretraga (pretragaEvent)=\"pronaciPoTrazenojReci($event)\" (filterEvent)=\"toogleFilterDiv($event)\">\r\n        </app-pretraga>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [vrstaUlja]=\"vrstaUlja\" [otvoriFilter]=\"otvoriFilter\"\r\n        (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

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
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
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
    function MotornaComponent(robaService, dataService, loginService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.loginService = loginService;
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
        this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji();
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
        this.searchValue = searchValue;
        this.pronadjiEntitetePoPretrazi(searchValue);
    };
    MotornaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiEntitetePoPretrazi(this.searchValue);
    };
    MotornaComponent.prototype.toogleFilterDiv = function (otvoriFilter) {
        this.otvoriFilter = otvoriFilter;
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
            src_app_e_shop_service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_7__["LoginService"]])
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

module.exports = ".industrijski-stil {\r\n    width: 100%;\r\n    height: 100%;\r\n}\r\n.spusti {\r\n    margin-top: 0px;\r\n}\r\n.motorna-ulja {\r\n    background-image: url('/assets/slike/ui/tabovi/mu.png');\r\n    background-repeat: no-repeat;\r\n    background-size: contain;\r\n}\r\n@media only screen and (max-device-width :1025px) { \r\n    .spusti {\r\n        margin-top: 30px;\r\n    }\r\n}\r\n@media only screen and (max-device-width : 1000px) { \r\n    .spusti {\r\n        margin-top: 10px;\r\n    }\r\n}\r\n"

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

/***/ "./src/app/e-shop/magacin/ulja/ulja.module.ts":
/*!****************************************************!*\
  !*** ./src/app/e-shop/magacin/ulja/ulja.module.ts ***!
  \****************************************************/
/*! exports provided: UljaModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UljaModule", function() { return UljaModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var _shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../shared-components/shared-magacin.module */ "./src/app/e-shop/magacin/shared-components/shared-magacin.module.ts");
/* harmony import */ var _ulja_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./ulja.component */ "./src/app/e-shop/magacin/ulja/ulja.component.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _motorna_motorna_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./motorna/motorna.component */ "./src/app/e-shop/magacin/ulja/motorna/motorna.component.ts");
/* harmony import */ var _antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./antifriz/antifriz.component */ "./src/app/e-shop/magacin/ulja/antifriz/antifriz.component.ts");
/* harmony import */ var _menjacko_menjacko_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./menjacko/menjacko.component */ "./src/app/e-shop/magacin/ulja/menjacko/menjacko.component.ts");
/* harmony import */ var _industrijska_industrijska_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./industrijska/industrijska.component */ "./src/app/e-shop/magacin/ulja/industrijska/industrijska.component.ts");
/* harmony import */ var _kociona_kociona_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./kociona/kociona.component */ "./src/app/e-shop/magacin/ulja/kociona/kociona.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};












var routes = [
    {
        path: '',
        component: _ulja_component__WEBPACK_IMPORTED_MODULE_5__["UljaComponent"]
    }
];
var UljaModule = /** @class */ (function () {
    function UljaModule() {
    }
    UljaModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_3__["MaterialModule"],
                _shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_4__["SharedMagacinModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_6__["RouterModule"].forChild(routes)
            ],
            declarations: [
                _ulja_component__WEBPACK_IMPORTED_MODULE_5__["UljaComponent"],
                _motorna_motorna_component__WEBPACK_IMPORTED_MODULE_7__["MotornaComponent"],
                _antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_8__["AntifrizComponent"],
                _menjacko_menjacko_component__WEBPACK_IMPORTED_MODULE_9__["MenjackoComponent"],
                _kociona_kociona_component__WEBPACK_IMPORTED_MODULE_11__["KocionaComponent"],
                _industrijska_industrijska_component__WEBPACK_IMPORTED_MODULE_10__["IndustrijskaComponent"],
                _antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_8__["AntifrizComponent"]
            ],
            exports: [
                _ulja_component__WEBPACK_IMPORTED_MODULE_5__["UljaComponent"],
                _motorna_motorna_component__WEBPACK_IMPORTED_MODULE_7__["MotornaComponent"],
                _antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_8__["AntifrizComponent"],
                _menjacko_menjacko_component__WEBPACK_IMPORTED_MODULE_9__["MenjackoComponent"],
                _kociona_kociona_component__WEBPACK_IMPORTED_MODULE_11__["KocionaComponent"],
                _industrijska_industrijska_component__WEBPACK_IMPORTED_MODULE_10__["IndustrijskaComponent"],
                _antifriz_antifriz_component__WEBPACK_IMPORTED_MODULE_8__["AntifrizComponent"]
            ],
        })
    ], UljaModule);
    return UljaModule;
}());



/***/ })

}]);
//# sourceMappingURL=e-shop-magacin-ulja-ulja-module.js.map