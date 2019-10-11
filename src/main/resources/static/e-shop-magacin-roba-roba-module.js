(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-shop-magacin-roba-roba-module"],{

/***/ "./src/app/e-shop/magacin/roba/roba.component.css":
/*!********************************************************!*\
  !*** ./src/app/e-shop/magacin/roba/roba.component.css ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sekcija-pretraga {\r\n    height: 150px;\r\n    background-image: url('/assets/slike/ui/pozadine/roba.png');\r\n    /* background-image: url('/assets/slike/ui/pozadine/roba.png'); */\r\n    background-repeat: no-repeat;\r\n    background-position: top;\r\n    background-size: 120%;\r\n}\r\n"

/***/ }),

/***/ "./src/app/e-shop/magacin/roba/roba.component.html":
/*!*********************************************************!*\
  !*** ./src/app/e-shop/magacin/roba/roba.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n    <div class=\"sekcija-pretraga\">\r\n        <div class=\"d-flex align-items-center justify-content-center\">\r\n            <div class=\"forms-input\">\r\n                <input class=\"p-1 flex-grow-1 search__input\" type=\"search\" [(ngModel)]=\"searchValue\"\r\n                    (keyup.enter)=\"pronaciPoTrazenojReci(searchValue)\" />\r\n                <div class=\"p-1\" (click)='pronaciPoTrazenojReci(searchValue)'>\r\n                    <button mat-mini-fab class=pozadina-glavna-100>\r\n                        <mat-icon>search</mat-icon>\r\n                    </button>\r\n                </div>\r\n                <div class=\"p-1\" (click)='toogleFilterDiv()'>\r\n                    <button matTooltip=\"Filter\" *ngIf=\"!otvoriFilter\" class=\"pozadina-glavna-100\" mat-mini-fab>\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                    <button *ngIf=\"otvoriFilter\" mat-mini-fab class=\"button-glavni-200\">\r\n                        <mat-icon>view_headline</mat-icon>\r\n                    </button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"d-flex justify-content-center\">\r\n            <label *ngIf=\"pocetnoPretrazivanje\">\r\n                <font color=\"#424242\"> Ukucajte kataloški broj</font>\r\n            </label>\r\n        </div>\r\n    </div>\r\n\r\n    <!-- Filter komponenta izdvojena -->\r\n    <app-filter [vrstaRobe]=\"vrstaRobe\" [otvoriFilter]=\"otvoriFilter\" (filterEvent)=\"filtriraj($event)\">\r\n    </app-filter>\r\n\r\n    <div class=\"d-flex flex-column prazna-tabela\" *ngIf=\"!pronadjenaRoba\">\r\n        <i class=\"material-icons icon-size\">\r\n            error_outline\r\n        </i>\r\n        <h1 class=\"h1-upozorenje\">Artikal ne postoji</h1>\r\n    </div>\r\n\r\n    <div class=\"d-flex justify-content-center prazna-tabela\" *ngIf=\"ucitavanje\">\r\n        <mat-spinner></mat-spinner>\r\n    </div>\r\n\r\n    <app-tabela [rowsPerPage]=\"rowsPerPage\" [pageIndex]=\"pageIndex\" [tableLength]=\"tableLength\"\r\n        [dataSource]=\"dataSource\" [roba]=\"roba\" (magacinEvent)=\"paginatorEvent($event)\"></app-tabela>\r\n</main>"

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








var RobaComponent = /** @class */ (function () {
    function RobaComponent(robaService, dataService, loginService) {
        this.robaService = robaService;
        this.dataService = dataService;
        this.loginService = loginService;
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
        this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji();
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
            _service_data_data_service__WEBPACK_IMPORTED_MODULE_4__["DataService"],
            _service_login_service__WEBPACK_IMPORTED_MODULE_7__["LoginService"]])
    ], RobaComponent);
    return RobaComponent;
}());



/***/ }),

/***/ "./src/app/e-shop/magacin/roba/roba.module.ts":
/*!****************************************************!*\
  !*** ./src/app/e-shop/magacin/roba/roba.module.ts ***!
  \****************************************************/
/*! exports provided: RobaModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RobaModule", function() { return RobaModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _roba_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./roba.component */ "./src/app/e-shop/magacin/roba/roba.component.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
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
        component: _roba_component__WEBPACK_IMPORTED_MODULE_2__["RobaComponent"]
    }
];
var RobaModule = /** @class */ (function () {
    function RobaModule() {
    }
    RobaModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__["MaterialModule"],
                _shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_6__["SharedMagacinModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forChild(routes)
            ],
            declarations: [_roba_component__WEBPACK_IMPORTED_MODULE_2__["RobaComponent"]],
            exports: [_roba_component__WEBPACK_IMPORTED_MODULE_2__["RobaComponent"]]
        })
    ], RobaModule);
    return RobaModule;
}());



/***/ })

}]);
//# sourceMappingURL=e-shop-magacin-roba-roba-module.js.map