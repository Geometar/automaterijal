(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-shop-login-login-module"],{

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

module.exports = "<div class=\"container\">\r\n\t<div class=\"flex-login\">\r\n\t\t<div class=\"login-form\">\r\n\t\t\t<h1>Prijavi se</h1>\r\n\t\t\t<div class=\"alert alert-danger\" role=\"alert\" *ngIf=\"!uspesnoLogovanje\">\r\n\t\t\t\t<p>Korisničko ime ili šifra je pogrešna.</p>\r\n\t\t\t</div>\r\n\t\t\t<div class=\"alert alert-danger\" role=\"alert\" *ngIf=\"uspesnoLogovanje && partner && partner.webStatus === 4\">\r\n\t\t\t\t<p>Vaš nalog trenutno ima zabranu pristupa.</p>\r\n\t\t\t</div>\r\n\t\t\t<form role=\"form\" (keydown)=\"enterNaFormi($event)\" [formGroup]=\"registerForm\">\r\n\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t<input type=\"text\" formControlName=\"username\" class=\"form-control rounded\" placeholder=\"Korisničko ime\" id=\"username\"\r\n\t\t\t\t\t name=\"username\" [(ngModel)]=\"credentials.username\" [ngClass]=\"{ 'is-invalid': submitted && registerForm.controls.username.errors }\" />\r\n\t\t\t\t\t<div *ngIf=\"submitted && registerForm.controls.username.errors\">\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.username.errors.required\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Korisničko ime je obavezno</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.username.errors.minlength\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Korisničko ime mora imati minimalno 3 karaktera</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t<input type=\"password\" formControlName=\"password\" class=\"form-control rounded\" placeholder=\"Šifra\" id=\"password\"\r\n\t\t\t\t\t name=\"password\" [(ngModel)]=\"credentials.password\" [ngClass]=\"{ 'is-invalid': submitted && registerForm.controls.password.errors }\" />\r\n\t\t\t\t\t<div *ngIf=\"submitted && registerForm.controls.password.errors\">\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.password.errors.required\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Šifra je obavezna</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div *ngIf=\"registerForm.controls.password.errors.minlength\">\r\n\t\t\t\t\t\t\t\t<p class=\"upozorenje\">Šifra mora imati minimalno 3 karaktera</p>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"d-flex\">\r\n\t\t\t\t\t<button mat-button type=\"button\" (click)=\"otvoriResgracijaDialog()\" class=\"boja-glavna-100\">Nemate nalog?</button>\r\n\t\t\t\t\t<button mat-raised-button (click)=\"login()\" class=\"rounded button-glavni-100\">Prijava</button>\r\n\t\t\t\t\t<button mat-button type=\"button\" (click)=\"otvoriZaboravljenuSifruDialog()\" class=\"boja-glavna-100\">Zaboravili ste šifru?</button>\r\n\t\t\t\t</div>\r\n\t\t\t</form>\r\n\t\t</div>\r\n\t</div>\r\n</div>"

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
        this.loginServis.vratiUlogovanogKorisnika(true)
            .subscribe(function (res) {
            if (res !== null) {
                _this.partner = res;
                _this.uspesnoLogovanje = true;
                if (_this.partner.webStatus !== 4) {
                    _this.router.navigateByUrl('naslovna');
                    _this.loginServis.setDaLiJeUserLogovan(true);
                    _this.loginServis.setUlogovanogPartner(_this.partner);
                    if (_this.partner.loginCount === 0) {
                        _this.dialog.open(src_app_shared_modal_prvo_logovanje_modal_prvo_logovanje_modal_component__WEBPACK_IMPORTED_MODULE_8__["PrvoLogovanjeModalComponent"], {
                            width: '600px',
                            data: _this.partner,
                            disableClose: true
                        });
                    }
                }
                else {
                    _this.loginServis.setDaLiJeUserLogovan(false);
                    _this.dataService.logout();
                }
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

/***/ "./src/app/e-shop/login/login.module.ts":
/*!**********************************************!*\
  !*** ./src/app/e-shop/login/login.module.ts ***!
  \**********************************************/
/*! exports provided: LoginModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginModule", function() { return LoginModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _login_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./login.component */ "./src/app/e-shop/login/login.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/shared/material/material.module */ "./src/app/shared/material/material.module.ts");
/* harmony import */ var _magacin_shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../magacin/shared-components/shared-magacin.module */ "./src/app/e-shop/magacin/shared-components/shared-magacin.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var routes = [
    {
        path: '',
        component: _login_component__WEBPACK_IMPORTED_MODULE_3__["LoginComponent"]
    }
];
var LoginModule = /** @class */ (function () {
    function LoginModule() {
    }
    LoginModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__["MaterialModule"],
                _magacin_shared_components_shared_magacin_module__WEBPACK_IMPORTED_MODULE_6__["SharedMagacinModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)
            ],
            declarations: [_login_component__WEBPACK_IMPORTED_MODULE_3__["LoginComponent"]],
            exports: [_login_component__WEBPACK_IMPORTED_MODULE_3__["LoginComponent"]]
        })
    ], LoginModule);
    return LoginModule;
}());



/***/ })

}]);
//# sourceMappingURL=e-shop-login-login-module.js.map