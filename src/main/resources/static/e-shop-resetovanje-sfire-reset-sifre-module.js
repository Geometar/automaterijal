(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-shop-resetovanje-sfire-reset-sifre-module"],{

/***/ "./src/app/e-shop/resetovanje-sfire/reset-sifre.module.ts":
/*!****************************************************************!*\
  !*** ./src/app/e-shop/resetovanje-sfire/reset-sifre.module.ts ***!
  \****************************************************************/
/*! exports provided: ResetSifreModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ResetSifreModule", function() { return ResetSifreModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/shared/material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var _magacin_shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../magacin/shared-components/shared-magacin.module */ "./src/app/e-shop/magacin/shared-components/shared-magacin.module.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _resetovanje_sfire_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./resetovanje-sfire.component */ "./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var routes = [
    {
        path: '',
        component: _resetovanje_sfire_component__WEBPACK_IMPORTED_MODULE_6__["ResetovanjeSfireComponent"]
    }
];
var ResetSifreModule = /** @class */ (function () {
    function ResetSifreModule() {
    }
    ResetSifreModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_3__["MaterialModule"],
                _magacin_shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_4__["SharedMagacinModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_5__["RouterModule"].forChild(routes)
            ],
            declarations: [_resetovanje_sfire_component__WEBPACK_IMPORTED_MODULE_6__["ResetovanjeSfireComponent"]],
            exports: [_resetovanje_sfire_component__WEBPACK_IMPORTED_MODULE_6__["ResetovanjeSfireComponent"]]
        })
    ], ResetSifreModule);
    return ResetSifreModule;
}());



/***/ }),

/***/ "./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.html":
/*!***************************************************************************!*\
  !*** ./src/app/e-shop/resetovanje-sfire/resetovanje-sfire.component.html ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n  <div class=\"flex-login\">\r\n    <div class=\"login-form\">\r\n      <h1>Promeni šifru</h1>\r\n      <div class=\"alert alert-danger\" role=\"alert\" *ngIf=\"submitted == true && uspesnaPromena == false\">\r\n        <p>Promena šifre nije uspela, zahtevajte ponovo poštu za resetovanje šifre.</p>\r\n      </div>\r\n      <form role=\"form\" [formGroup]=\"promenaSifreForm\">\r\n        <div class=\"form-group\">\r\n          <input type=\"password\" #pass1 formControlName=\"pass1\" class=\"form-control rounded\" placeholder=\"Nova šifra\" id=\"pass1\"\r\n            name=\"pass1\" />\r\n          <div *ngIf=\"submitted && r.pass1.errors\">\r\n            <div *ngIf=\"r.pass1.errors.required\">\r\n              <p class=\"upozorenje\">Šifra je obavezna</p>\r\n            </div>\r\n            <div *ngIf=\"r.pass1.errors.minlength\">\r\n              <p class=\"upozorenje\">Šifra mora imati minimalno 3 karaktera</p>\r\n            </div>\r\n          </div>\r\n        </div>\r\n        <div class=\"form-group\">\r\n          <input type=\"password\" #pass2 formControlName=\"pass2\" class=\"form-control rounded\" placeholder=\"Ponovite šifru\"\r\n            id=\"password\" name=\"password\" />\r\n          <div *ngIf=\"submitted && r.pass2.errors\">\r\n            <div *ngIf=\"r.pass2.errors.required\">\r\n              <p class=\"upozorenje\">Šifra je obavezna</p>\r\n            </div>\r\n            <div *ngIf=\"r.pass2.errors.minlength\">\r\n              <p class=\"upozorenje\">Šifra mora imati minimalno 3 karaktera</p>\r\n            </div>\r\n          </div>\r\n          <div *ngIf=\"submitted && !r.pass2.errors && pass1.value != pass2.value\">\r\n            <p class=\"upozorenje\">Šifre nisu iste</p>\r\n          </div>\r\n        </div>\r\n        <div class=\"d-flex\">\r\n          <button mat-raised-button (click)=\"promeniSifru()\" class=\"rounded\" color=\"primary\">Promeni</button>\r\n        </div>\r\n      </form>\r\n    </div>\r\n  </div>\r\n</div>"

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



/***/ })

}]);
//# sourceMappingURL=e-shop-resetovanje-sfire-reset-sifre-module.js.map