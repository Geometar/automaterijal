(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["e-commerce-kontakt-kontakt-module"],{

/***/ "./src/app/e-commerce/kontakt/kontakt.component.html":
/*!***********************************************************!*\
  !*** ./src/app/e-commerce/kontakt/kontakt.component.html ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<main>\r\n  <div class=\"headerKontankt\">\r\n    <h1>Kontaktirajte nas</h1>\r\n  </div>\r\n  <div class=\"pozadina-bela\">\r\n    <div class=\"d-flex flex-fill flex-column flex-lg-row informacije\">\r\n      <div class=\"align-self-center flex-fill informacije-deo\">\r\n        <h2>Informacije</h2>\r\n      </div>\r\n      <div class=\"granica-informacije\"></div>\r\n      <div class=\"flex-fill informacije-deo\">\r\n        <i class=\"material-icons  boja-glavna-100\">\r\n          place\r\n        </i>\r\n        <div class=\"adresa\">\r\n          <p>Prvomajska 61</p>\r\n          <p>15000 Šabac</p>\r\n        </div>\r\n      </div>\r\n      <div class=\"granica-informacije\"></div>\r\n      <div class=\"flex-fill informacije-deo\">\r\n        <i class=\"material-icons  boja-glavna-100\">\r\n          access_alarm\r\n        </i>\r\n        <div class=\"d-flex flex-row adresa\">\r\n          <div class=\"sirina-telefona\">\r\n            <p class=\"telefoni\">Radnim danom:</p>\r\n          </div>\r\n          <div>\r\n            <ul>\r\n              <li> 08-18h</li>\r\n            </ul>\r\n          </div>\r\n        </div>\r\n        <div class=\"d-flex flex-row \">\r\n          <div class=\"sirina-telefona\">\r\n            <p class=\"telefoni\">Subotom:</p>\r\n          </div>\r\n          <div>\r\n            <ul>\r\n              <li> 09-15h</li>\r\n            </ul>\r\n          </div>\r\n        </div>\r\n        <div class=\"d-flex flex-row \">\r\n          <div class=\"sirina-telefona\">\r\n            <p class=\"telefoni\">Nedelja:</p>\r\n          </div>\r\n          <div>\r\n            <ul>\r\n              <li>Neradan dan</li>\r\n            </ul>\r\n          </div>\r\n        </div>\r\n      </div>\r\n      <div class=\"granica-informacije\"></div>\r\n      <div class=\"flex-fill informacije-deo\">\r\n        <i class=\"material-icons boja-glavna-100\">\r\n          phone\r\n        </i>\r\n        <div class=\"d-flex flex-row \">\r\n          <div class=\"sirina-telefona\">\r\n            <p class=\"telefoni\">Malpoprodaja:</p>\r\n          </div>\r\n          <div>\r\n            <ul>\r\n              <li><a class=\"telefon\" href=\"tel:015334630\">015/334-630</a></li>\r\n              <li><a class=\"telefon\" href=\"tel:015310049\">015/310-049</a></li>\r\n            </ul>\r\n          </div>\r\n        </div>\r\n        <div class=\"d-flex flex-row veleprodaja-dole\">\r\n          <div class=\"sirina-telefona\">\r\n            <p class=\"telefoni\">Veleprodaja:</p>\r\n          </div>\r\n          <div>\r\n            <ul>\r\n              <li> <a class=\"telefon\" href=\"tel:015319000\">015/319-000</a></li>\r\n              <li class=\"telefon\">015/319-001 Fax </li>\r\n            </ul>\r\n          </div>\r\n        </div>\r\n        <div class=\"d-flex flex-row veleprodaja-dole\">\r\n          <div class=\"sirina-telefona\">\r\n            <p class=\"telefoni\">Email:</p>\r\n          </div>\r\n          <div>\r\n            <ul>\r\n              <li> office@automaterijal.com</li>\r\n            </ul>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n  <div class=\"google-mapa\">\r\n    <iframe\r\n      src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2833.8797026959655!2d19.695872!3d44.742471!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x6fb532b6b846f3cf!2sAutomaterijal!5e0!3m2!1sen!2sus!4v1548771004118\"\r\n      frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>\r\n  </div>\r\n\r\n  <div class=\"pozadina-bela\">\r\n    <div class=\"d-flex flex-fill flex-column flex-lg-row informacije\">\r\n      <div class=\"flex-fill poruke-deo\">\r\n        <h2>Pošalji poruku</h2>\r\n        <div class=\"poruka-div\">\r\n          <p class=\"poruka-informacije\">\r\n            <i class=\"material-icons poruka\">\r\n              mail_outline\r\n            </i>\r\n            Pošta </p>\r\n          <p class=\"poruka-objasnjenje\"> office@automaterijal.com </p>\r\n        </div>\r\n        <div class=\"poruka-div\">\r\n          <p class=\"poruka-informacije\">\r\n            <i class=\"material-icons poruka\">\r\n              chat_bubble_outline\r\n            </i>\r\n            Pratite nas </p>\r\n          <div>\r\n            <a href=\"https://sr-rs.facebook.com/automaterijal/\" target=\"_blank\" mat-fab id=\"drustvena-mreza\"\r\n              matTooltip=\"Facebook\" color=\"primary\">f</a>\r\n            <a href=\"https://www.instagram.com/automaterijal/\" target=\"_blank\" mat-fab id=\"drustvena-mreza\"\r\n              class=\"razmak-drus\" matTooltip=\"Instagram\" color=\"primary\">\r\n              <i class=\"material-icons instagram\">\r\n                photo_camera\r\n              </i>\r\n            </a>\r\n          </div>\r\n        </div>\r\n      </div>\r\n      <div class=\"flex-fill\">\r\n        <form role=\"form\" [formGroup]=\"porukaForm\">\r\n          <div class=\"forma-poruke\">\r\n            <table cellspacing=\"0\">\r\n              <tr>\r\n                <td>\r\n                  <mat-form-field>\r\n                    <input matInput formControlName=\"ime\" placeholder=\"Ime\">\r\n                  </mat-form-field>\r\n                </td>\r\n                <td>\r\n                  <mat-form-field>\r\n                    <input matInput formControlName=\"prezime\" placeholder=\"Prezime\">\r\n                  </mat-form-field>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n            <table cellspacing=\"0\">\r\n              <tr>\r\n                <td>\r\n                  <mat-form-field>\r\n                    <input matInput formControlName=\"firma\" placeholder=\"Ima firme\">\r\n                  </mat-form-field>\r\n                </td>\r\n                <td>\r\n                  <mat-form-field>\r\n                    <input matInput type=\"tel\" formControlName=\"telefon\" placeholder=\"Broj telefona\">\r\n                  </mat-form-field>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n            <div>\r\n              <mat-form-field class=\"duzina-input\">\r\n                <input matInput type=\"email\" formControlName=\"posta\" placeholder=\"Pošta\">\r\n              </mat-form-field>\r\n              <div *ngIf=\"porukaSubmited && p.posta.errors\">\r\n                <div *ngIf=\"p.posta.errors.required\">\r\n                  <p class=\"upozorenje\">Pošta je obavezna</p>\r\n                </div>\r\n                <div *ngIf=\"p.posta.errors.email\">\r\n                  <p class=\"upozorenje\">Pošta nije validna</p>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div>\r\n              <mat-form-field class=\"duzina-input\">\r\n                <textarea matInput formControlName=\"poruka\" rows=\"8\" placeholder=\"Poruka\"></textarea>\r\n              </mat-form-field>\r\n              <div *ngIf=\"porukaSubmited && p.poruka.errors\">\r\n                <div *ngIf=\"p.poruka.errors.required\">\r\n                  <p class=\"upozorenje\">Poruka je obavezna</p>\r\n                </div>\r\n                <div *ngIf=\"p.poruka.errors.minlength\">\r\n                  <p class=\"upozorenje\">Poruka mora imate minimalno 3 karaktera</p>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <button mat-flat-button class=\"duzina-input\" (click)=\"posaljiPoruku()\" color=\"primary\">Pošalji</button>\r\n          </div>\r\n        </form>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</main>"

/***/ }),

/***/ "./src/app/e-commerce/kontakt/kontakt.component.scss":
/*!***********************************************************!*\
  !*** ./src/app/e-commerce/kontakt/kontakt.component.scss ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "h1 {\n  text-align: center;\n  padding-top: 1em;\n  padding-bottom: 1em; }\n\nh2 {\n  color: #345cac !important;\n  margin-top: 1em; }\n\nh3 {\n  color: #345cac; }\n\nul {\n  display: inline;\n  text-align: left;\n  margin: 0px;\n  padding: 0px; }\n\nli {\n  color: #263238;\n  margin-top: 2px; }\n\ntd {\n  margin: 0px !important;\n  padding: 0px !important; }\n\niframe {\n  width: 80%;\n  height: 450px; }\n\n.headerKontankt {\n  background-image: url(\"/assets/slike/ui/pozadine/kontakt.png\");\n  background-position: center;\n  background-repeat: no-repeat;\n  background-size: 100% 102px; }\n\n.telefon {\n  display: inline;\n  font-size: 1em;\n  margin-left: 5px;\n  color: black; }\n\n.informacije {\n  width: 100%; }\n\n.informacije-deo {\n  padding: 10px;\n  text-align: center; }\n\n.poruka-div {\n  margin-top: 40px; }\n\n.poruka {\n  color: #345cac !important;\n  font-size: 1.5em;\n  position: relative;\n  top: 5px; }\n\n.poruke-deo {\n  position: relative;\n  left: 16%; }\n\n.poruka-informacije {\n  display: inline;\n  font-size: 1.1em; }\n\n.poruka-objasnjenje {\n  color: #345cac !important; }\n\n#drustvena-mreza {\n  width: 45px;\n  height: 45px;\n  font-size: 1.8em; }\n\n#drustvena-mreza:hover {\n  background-color: #547aa1; }\n\n.razmak-drus {\n  margin-left: 10px; }\n\n.instagram {\n  top: -4px;\n  position: relative; }\n\n.mat-fab .mat-button-wrapper {\n  padding: 0px !important;\n  display: inline-block;\n  line-height: 24px;\n  border-radius: 50%; }\n\n.granica-informacije {\n  border-right: 1px solid #dfe5e7;\n  border-left: 1px solid #dfe5e7;\n  margin-top: 30px;\n  height: 130px; }\n\n.telefoni {\n  color: #263238; }\n\n.sirina-telefona {\n  width: 125px;\n  margin-left: 5%;\n  text-align: left; }\n\n.veleprodaja-dole {\n  margin-top: 15px; }\n\n.adresa {\n  margin-top: 10px; }\n\n.google-mapa {\n  margin-top: 1em;\n  text-align: center;\n  margin-bottom: 5em;\n  height: 405px; }\n\n.forma-poruke {\n  box-shadow: 0 0px 15px 2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);\n  width: 500px;\n  padding: 10px;\n  margin-top: 20px;\n  margin-left: 15%;\n  margin-bottom: 50px;\n  text-align: center; }\n\n.duzina-input {\n  width: 350px;\n  margin-bottom: 1rem; }\n\n.upozorenje {\n  text-align: left;\n  font-size: 0.8em !important;\n  color: red;\n  margin-top: -20px;\n  margin-bottom: 0px;\n  padding-left: 65px; }\n\n@media only screen and (max-width: 1400px) {\n  iframe {\n    width: 90%; }\n  .google-mapa {\n    margin-top: 25px; } }\n\n@media only screen and (max-width: 991px) {\n  .informacije-deo {\n    padding: 2px; }\n  .granica-informacije {\n    border-right: 0px solid #dfe5e7 !important;\n    border-left: 0px solid #dfe5e7 !important;\n    height: 60%; } }\n\n@media only screen and (max-width: 950px) {\n  h2 {\n    padding-left: 0em; }\n  .headerKontankt {\n    margin-top: 70px; }\n  iframe {\n    width: 100%;\n    height: 350px; }\n  .poruke-deo {\n    position: relative;\n    left: 1em; }\n  .google-mapa {\n    height: 305px;\n    margin-top: 5px;\n    text-align: center; }\n  .granica-informacije {\n    border-right: 0px solid #dfe5e7 !important;\n    border-left: 0px solid #dfe5e7 !important;\n    height: 60%; }\n  .informacije[_ngcontent-c9] {\n    width: 100%;\n    margin-left: 0%;\n    margin-top: 50px; }\n  .informacije-deo {\n    width: 100%;\n    text-align: center;\n    font-weight: 500; }\n  .forma-poruke {\n    width: 99%;\n    padding: 0px;\n    margin-left: 2px;\n    margin-right: 2px;\n    margin-top: 20px;\n    margin-bottom: 50px;\n    text-align: center; }\n  .my-snack-bar {\n    background-color: #b71c1c !important; }\n  .headerKontankt {\n    margin-top: 0px; } }\n"

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

/***/ "./src/app/e-commerce/kontakt/kontakt.module.ts":
/*!******************************************************!*\
  !*** ./src/app/e-commerce/kontakt/kontakt.module.ts ***!
  \******************************************************/
/*! exports provided: KontaktModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KontaktModule", function() { return KontaktModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _kontakt_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./kontakt.component */ "./src/app/e-commerce/kontakt/kontakt.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/shared/material/material.module */ "./src/app/shared/material/material.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};






var routes = [
    {
        path: '',
        component: _kontakt_component__WEBPACK_IMPORTED_MODULE_3__["KontaktComponent"]
    }
];
var KontaktModule = /** @class */ (function () {
    function KontaktModule() {
    }
    KontaktModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"],
                src_app_shared_material_material_module__WEBPACK_IMPORTED_MODULE_5__["MaterialModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forChild(routes)
            ],
            declarations: [_kontakt_component__WEBPACK_IMPORTED_MODULE_3__["KontaktComponent"]],
            exports: [_kontakt_component__WEBPACK_IMPORTED_MODULE_3__["KontaktComponent"]]
        })
    ], KontaktModule);
    return KontaktModule;
}());



/***/ })

}]);
//# sourceMappingURL=e-commerce-kontakt-kontakt-module.js.map