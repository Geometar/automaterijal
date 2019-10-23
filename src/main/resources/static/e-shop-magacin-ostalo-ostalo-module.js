(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-shop-magacin-ostalo-ostalo-module"],{

/***/ "./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.html":
/*!**************************************************************************************************!*\
  !*** ./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.html ***!
  \**************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n  <div class=\"sekcija-pretraga\">\r\n    <div class=\"d-flex flex-row-reverse bd-highlight\">\r\n      <button class=\"button-glavni-100 nazad-button\" mat-raised-button (click)=\"idiNazad()\">\r\n        <mat-icon>keyboard_arrow_left</mat-icon> Nazad\r\n      </button>\r\n    </div>\r\n    <div class=\"kategorija-pregraga-bar\">\r\n      <app-pretraga (pretragaEvent)=\"pronaciPoTrazenojReci($event)\" (filterEvent)=\"toogleFilterDiv($event)\">\r\n      </app-pretraga>\r\n    </div>\r\n  </div>\r\n\r\n  <!-- Filter komponenta izdvojena -->\r\n  <app-filter class=\"margin-top--20\" [vrstaRobe]=\"vrstaRobe\" [otvoriFilter]=\"otvoriFilter\"\r\n    (filterEvent)=\"filtriraj($event)\">\r\n  </app-filter>\r\n\r\n  <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n    <i class=\"material-icons icon-size\">\r\n      error_outline\r\n    </i>\r\n    <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n  </div>\r\n\r\n  <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n    <mat-spinner></mat-spinner>\r\n  </div>\r\n\r\n  <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\" [dataSource]=\"dataSource\"\r\n    [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

/***/ }),

/***/ "./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.scss":
/*!**************************************************************************************************!*\
  !*** ./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.scss ***!
  \**************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".forms-input {\n  margin-top: 0px !important; }\n\n.kategorija-pregraga-bar {\n  padding-top: 10px; }\n\n.sekcija-pretraga {\n  height: 160px;\n  background-image: url(\"/assets/slike/ui/pozadine/roba.png\");\n  background-repeat: no-repeat;\n  background-size: contain; }\n\n@media only screen and (max-width: 950px) {\n  .sekcija-pretraga {\n    background-image: none; } }\n"

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
/* harmony import */ var src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/e-shop/service/login.service */ "./src/app/e-shop/service/login.service.ts");
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
    function KategorijaSpecificnaComponent(route, dataService, robaServis, router, loginService) {
        this.route = route;
        this.dataService = dataService;
        this.robaServis = robaServis;
        this.router = router;
        this.loginService = loginService;
        this.vrstaRobe = src_app_e_shop_model_roba_enum__WEBPACK_IMPORTED_MODULE_6__["VrstaRobe"].OSTALO;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new src_app_e_shop_model_filter__WEBPACK_IMPORTED_MODULE_7__["Filter"]();
        this.searchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
    }
    KategorijaSpecificnaComponent.prototype.ngOnInit = function () {
        this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji();
        this.pronandjiRobu();
    };
    KategorijaSpecificnaComponent.prototype.pronandjiRobu = function () {
        var _this = this;
        this.route.params.subscribe(function (params) {
            _this.ucitavanje = true;
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
    KategorijaSpecificnaComponent.prototype.pronadjiSvuRobuPoPretrazi = function (searchValue) {
        var _this = this;
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
    KategorijaSpecificnaComponent.prototype.pronaciPoTrazenojReci = function (searchValue) {
        if (this.dataSource) {
            this.pageIndex = 0;
        }
        this.searchValue = searchValue;
        this.pronadjiSvuRobuPoPretrazi(searchValue);
    };
    KategorijaSpecificnaComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiSvuRobuPoPretrazi(this.searchValue);
    };
    KategorijaSpecificnaComponent.prototype.toogleFilterDiv = function (otvoriFilter) {
        this.otvoriFilter = otvoriFilter;
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
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"],
            src_app_e_shop_service_login_service__WEBPACK_IMPORTED_MODULE_8__["LoginService"]])
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

module.exports = "<div class=\"container-fluid\">\r\n  <main *ngIf=\"kategorije\">\r\n    <div class=\"sekcija-pretraga\">\r\n      <h1>Kategorije</h1>\r\n    </div>\r\n    <div *ngFor=\"let slovo of pocetnaSlova\">\r\n      <div class=\"d-flex flex-row flex-wrap\">\r\n        <div class=\"slovo\">\r\n          <h2>{{slovo}}</h2>\r\n        </div>\r\n        <div *ngFor=\"let kategorija of vratiKategorijuNaSlovo(slovo)\">\r\n          <a [routerLink]=\"[kategorija  | lowercase]\" mat-button>{{\"kategorija_\" + kategorija | translate}}</a>\r\n        </div>\r\n      </div>\r\n      <hr>\r\n    </div>\r\n  </main>\r\n</div>"

/***/ }),

/***/ "./src/app/e-shop/magacin/ostalo/ostalo.component.scss":
/*!*************************************************************!*\
  !*** ./src/app/e-shop/magacin/ostalo/ostalo.component.scss ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  padding-top: 20px;\n  margin-left: 20px;\n  margin-bottom: 50px; }\n\n.sekcija-pretraga {\n  height: 120px;\n  background-image: url(/assets/slike/ui/pozadine/roba.png);\n  background-repeat: no-repeat;\n  background-position: center;\n  background-size: 100% 120px; }\n\na {\n  color: #345cac; }\n\n.slovo {\n  width: 30px;\n  margin-top: 0px;\n  padding: 0px; }\n\n@media only screen and (max-width: 950px) {\n  .sekcija-pretraga {\n    height: 100px;\n    background-size: 120% 100px; } }\n"

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

/***/ "./src/app/e-shop/magacin/ostalo/ostalo.module.ts":
/*!********************************************************!*\
  !*** ./src/app/e-shop/magacin/ostalo/ostalo.module.ts ***!
  \********************************************************/
/*! exports provided: OstaloModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OstaloModule", function() { return OstaloModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _ostalo_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./ostalo.component */ "./src/app/e-shop/magacin/ostalo/ostalo.component.ts");
/* harmony import */ var _kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./kategorija-specificna/kategorija-specificna.component */ "./src/app/e-shop/magacin/ostalo/kategorija-specificna/kategorija-specificna.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! src/app/shared/material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var _shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../shared-components/shared-magacin.module */ "./src/app/e-shop/magacin/shared-components/shared-magacin.module.ts");
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
        component: _ostalo_component__WEBPACK_IMPORTED_MODULE_3__["OstaloComponent"]
    },
    {
        path: ':id',
        component: _kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_4__["KategorijaSpecificnaComponent"]
    }
];
var OstaloModule = /** @class */ (function () {
    function OstaloModule() {
    }
    OstaloModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_5__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_6__["MaterialModule"],
                _shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_7__["SharedMagacinModule"],
                src_app_shared_pipes_pipe_module__WEBPACK_IMPORTED_MODULE_8__["PipeModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)
            ],
            declarations: [_ostalo_component__WEBPACK_IMPORTED_MODULE_3__["OstaloComponent"], _kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_4__["KategorijaSpecificnaComponent"]],
            exports: [_ostalo_component__WEBPACK_IMPORTED_MODULE_3__["OstaloComponent"], _kategorija_specificna_kategorija_specificna_component__WEBPACK_IMPORTED_MODULE_4__["KategorijaSpecificnaComponent"]]
        })
    ], OstaloModule);
    return OstaloModule;
}());



/***/ })

}]);
//# sourceMappingURL=e-shop-magacin-ostalo-ostalo-module.js.map