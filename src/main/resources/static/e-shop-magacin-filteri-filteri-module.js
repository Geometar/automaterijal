(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-shop-magacin-filteri-filteri-module"],{

/***/ "./src/app/e-shop/magacin/filteri/filteri.component.css":
/*!**************************************************************!*\
  !*** ./src/app/e-shop/magacin/filteri/filteri.component.css ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n.sekcija-pretraga {\r\n    height: 150px;\r\n    background-image: url('/assets/slike/ui/pozadine/filteri.png');\r\n    background-repeat: no-repeat;\r\n    background-size: contain;\r\n}\r\n@media only screen and (max-device-width :1025px) { \r\n    .mobilna-duzina {\r\n        width: 100%;\r\n    }\r\n    .input-group-prepend {\r\n        margin-top: 10px;\r\n        margin-left: 0px;\r\n    }\r\n}\r\n"

/***/ }),

/***/ "./src/app/e-shop/magacin/filteri/filteri.component.html":
/*!***************************************************************!*\
  !*** ./src/app/e-shop/magacin/filteri/filteri.component.html ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n\r\n    <div class=\"sekcija-pretraga pretraga-bar\">\r\n        <app-pretraga (pretragaEvent)=\"pronaciPoTrazenojReci($event)\" (filterEvent)=\"toogleFilterDiv($event)\">\r\n        </app-pretraga>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [otvoriFilter]=\"otvoriFilter\" (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

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
/* harmony import */ var _service_login_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../service/login.service */ "./src/app/e-shop/service/login.service.ts");
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
    function FilteriComponent(robaService, dataService, loginService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.loginService = loginService;
        this.vrstaRobe = _model_roba_enum__WEBPACK_IMPORTED_MODULE_5__["VrstaRobe"].FILTERI;
        // Paging and Sorting elements
        this.rowsPerPage = 10;
        this.pageIndex = 0;
        this.sort = null;
        this.filter = new _model_filter__WEBPACK_IMPORTED_MODULE_6__["Filter"]();
        this.searchValue = '';
        this.ucitavanje = false;
        this.pronadjenaRoba = true;
        this.otvoriFilter = false;
        this.alive = true;
    }
    FilteriComponent.prototype.ngOnInit = function () {
        this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji();
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
        this.searchValue = searchValue;
        this.pronadjiFilterePoPretrazi(searchValue);
    };
    FilteriComponent.prototype.paginatorEvent = function (pageEvent) {
        this.dataSource = [];
        this.rowsPerPage = pageEvent.pageSize;
        this.pageIndex = pageEvent.pageIndex;
        this.pronadjiFilterePoPretrazi(this.searchValue);
    };
    FilteriComponent.prototype.toogleFilterDiv = function (otvoriFilter) {
        this.otvoriFilter = otvoriFilter;
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
            _service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"],
            _service_login_service__WEBPACK_IMPORTED_MODULE_7__["LoginService"]])
    ], FilteriComponent);
    return FilteriComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/filteri/filteri.module.ts":
/*!**********************************************************!*\
  !*** ./src/app/e-shop/magacin/filteri/filteri.module.ts ***!
  \**********************************************************/
/*! exports provided: FilteriModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FilteriModule", function() { return FilteriModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _filteri_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./filteri.component */ "./src/app/e-shop/magacin/filteri/filteri.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/shared/material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var _shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../shared-components/shared-magacin.module */ "./src/app/e-shop/magacin/shared-components/shared-magacin.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var routes = [
    {
        path: '',
        component: _filteri_component__WEBPACK_IMPORTED_MODULE_3__["FilteriComponent"]
    }
];
var FilteriModule = /** @class */ (function () {
    function FilteriModule() {
    }
    FilteriModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__["MaterialModule"],
                _shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_6__["SharedMagacinModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)
            ],
            declarations: [_filteri_component__WEBPACK_IMPORTED_MODULE_3__["FilteriComponent"]],
            exports: [_filteri_component__WEBPACK_IMPORTED_MODULE_3__["FilteriComponent"]]
        })
    ], FilteriModule);
    return FilteriModule;
}());



/***/ })

}]);
//# sourceMappingURL=e-shop-magacin-filteri-filteri-module.js.map