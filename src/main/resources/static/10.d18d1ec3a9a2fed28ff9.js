(window.webpackJsonp=window.webpackJsonp||[]).push([[10],{"4oMt":function(n,l,e){"use strict";e.r(l);var a=e("CcnG"),t=e("1Is/"),o=e("jvbL"),u=e("9Z1F"),i=e("2WpN"),r=e("G5J1"),d=e("XlPw"),c=e("me6m"),p=e("mM42"),s=e("dL++"),m=e("zF8A"),b=function(){function n(n,l,e){this.robaService=n,this.dataService=l,this.loginService=e,this.vrstaRobe=p.a.SVE,this.rowsPerPage=10,this.pageIndex=0,this.sort=null,this.filter=new s.a,this.searchValue="",this.lastSearchValue="",this.ucitavanje=!1,this.pronadjenaRoba=!0,this.otvoriFilter=!1,this.alive=!0}return n.prototype.ngOnInit=function(){this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji(),this.pocetnoPretrazivanje=!0,this.pronadjiSvuRobu()},n.prototype.pronadjiSvuRobu=function(){var n=this;this.ucitavanje=!0,this.pronadjenaRoba=!0,this.robaService.pronadjiSvuRobu(this.sort,this.rowsPerPage,this.pageIndex,null,null,null).pipe(Object(o.a)(function(){return n.alive}),Object(u.a)(function(l){return 404===l.status?(n.pronadjenaRoba=!1,r.a):Object(d.a)(l)}),Object(i.a)(function(){return n.ucitavanje=!1})).subscribe(function(l){n.pronadjenaRoba=!0,n.roba=l.content,n.roba=n.dataService.skiniSaStanjaUkolikoJeUKorpi(n.roba),n.dataSource=n.roba,n.rowsPerPage=l.size,n.pageIndex=l.number,n.tableLength=l.totalElements},function(l){n.roba=null})},n.prototype.pronaciPoTrazenojReci=function(n){this.dataSource&&(this.pageIndex=0),this.pronadjiSvuRobuPoPretrazi(n)},n.prototype.pronadjiSvuRobuPoPretrazi=function(n){var l=this;this.pocetnoPretrazivanje=!1,this.lastSearchValue=n,this.dataSource=null,this.ucitavanje=!0,this.pronadjenaRoba=!0,this.robaService.pronadjiSvuRobu(this.sort,this.rowsPerPage,this.pageIndex,n,this.filter.naStanju,this.filter.proizvodjacId).pipe(Object(o.a)(function(){return l.alive}),Object(u.a)(function(n){return 404===n.status?(l.pronadjenaRoba=!1,r.a):Object(d.a)(n)}),Object(i.a)(function(){return l.ucitavanje=!1})).subscribe(function(n){l.pronadjenaRoba=!0,l.roba=n.content,l.roba=l.dataService.skiniSaStanjaUkolikoJeUKorpi(l.roba),l.dataSource=l.roba,l.rowsPerPage=n.size,l.pageIndex=n.number,l.tableLength=n.totalElements},function(n){l.roba=null})},n.prototype.paginatorEvent=function(n){this.dataSource=[],this.rowsPerPage=n.pageSize,this.pageIndex=n.pageIndex,this.pronadjiSvuRobuPoPretrazi(this.searchValue)},n.prototype.toogleFilterDiv=function(){this.otvoriFilter=!this.otvoriFilter},n.prototype.filtriraj=function(n){this.dataSource&&(this.pageIndex=0),this.filter=n,this.pronadjiSvuRobuPoPretrazi(this.searchValue)},n}(),v=function(){},f=e("NcP4"),g=e("t68o"),h=e("xYTU"),j=e("pMnS"),R=e("bujt"),S=e("UodH"),P=e("dWZg"),I=e("lLAP"),w=e("wFw1"),k=e("v9Dh"),C=e("eDkP"),y=e("qAlS"),z=e("Fzqc"),x=e("Mr+X"),E=e("SMsm"),_=e("NvT6"),F=e("Blfk"),M=e("Ip0R"),N=e("gIcY"),V=e("JovF"),L=e("M95+"),O=e("ZYCi"),T=e("o5Qa"),A=e("sDaS"),U=e("I/CJ"),D=e("QOyY"),J=e("A6ij"),Y=a["\u0275crt"]({encapsulation:0,styles:[[".sekcija-pretraga[_ngcontent-%COMP%]{height:150px;background-image:url(/automaterijal/assets/slike/ui/pozadine/roba.png);background-repeat:no-repeat;background-size:cover}"]],data:{}});function K(n){return a["\u0275vid"](0,[(n()(),a["\u0275eld"](0,16777216,null,null,5,"button",[["class","pozadina-glavna-100"],["mat-mini-fab",""],["matTooltip","Filter"]],[[8,"disabled",0],[2,"_mat-animation-noopable",null]],[[null,"longpress"],[null,"keydown"],[null,"touchend"]],function(n,l,e){var t=!0;return"longpress"===l&&(t=!1!==a["\u0275nov"](n,2).show()&&t),"keydown"===l&&(t=!1!==a["\u0275nov"](n,2)._handleKeydown(e)&&t),"touchend"===l&&(t=!1!==a["\u0275nov"](n,2)._handleTouchend()&&t),t},R.d,R.b)),a["\u0275did"](1,180224,null,0,S.b,[a.ElementRef,P.a,I.f,[2,w.a]],null,null),a["\u0275did"](2,147456,null,0,k.d,[C.c,a.ElementRef,y.c,a.ViewContainerRef,a.NgZone,P.a,I.c,I.f,k.b,[2,z.b],[2,k.a]],{message:[0,"message"]},null),(n()(),a["\u0275eld"](3,0,null,0,2,"mat-icon",[["class","mat-icon"],["role","img"]],[[2,"mat-icon-inline",null]],null,null,x.b,x.a)),a["\u0275did"](4,638976,null,0,E.a,[a.ElementRef,E.c,[8,null]],null,null),(n()(),a["\u0275ted"](-1,0,["view_headline"])),(n()(),a["\u0275and"](0,null,null,0))],function(n,l){n(l,2,0,"Filter"),n(l,4,0)},function(n,l){n(l,0,0,a["\u0275nov"](l,1).disabled||null,"NoopAnimations"===a["\u0275nov"](l,1)._animationMode),n(l,3,0,a["\u0275nov"](l,4).inline)})}function Z(n){return a["\u0275vid"](0,[(n()(),a["\u0275eld"](0,0,null,null,4,"button",[["class","button-glavni-200"],["mat-mini-fab",""]],[[8,"disabled",0],[2,"_mat-animation-noopable",null]],null,null,R.d,R.b)),a["\u0275did"](1,180224,null,0,S.b,[a.ElementRef,P.a,I.f,[2,w.a]],null,null),(n()(),a["\u0275eld"](2,0,null,0,2,"mat-icon",[["class","mat-icon"],["role","img"]],[[2,"mat-icon-inline",null]],null,null,x.b,x.a)),a["\u0275did"](3,638976,null,0,E.a,[a.ElementRef,E.c,[8,null]],null,null),(n()(),a["\u0275ted"](-1,0,["view_headline"]))],function(n,l){n(l,3,0)},function(n,l){n(l,0,0,a["\u0275nov"](l,1).disabled||null,"NoopAnimations"===a["\u0275nov"](l,1)._animationMode),n(l,2,0,a["\u0275nov"](l,3).inline)})}function q(n){return a["\u0275vid"](0,[(n()(),a["\u0275eld"](0,0,null,null,2,"label",[],null,null,null,null,null)),(n()(),a["\u0275eld"](1,0,null,null,1,"font",[["color","#424242"]],null,null,null,null,null)),(n()(),a["\u0275ted"](-1,null,[" Ukucajte kataloski broj"]))],null,null)}function G(n){return a["\u0275vid"](0,[(n()(),a["\u0275eld"](0,0,null,null,4,"div",[["class","d-flex flex-column prazna-tabela"]],null,null,null,null,null)),(n()(),a["\u0275eld"](1,0,null,null,1,"i",[["class","material-icons icon-size"]],null,null,null,null,null)),(n()(),a["\u0275ted"](-1,null,[" error_outline "])),(n()(),a["\u0275eld"](3,0,null,null,1,"h1",[["class","h1-upozorenje"]],null,null,null,null,null)),(n()(),a["\u0275ted"](-1,null,["Artikal ne postoji"]))],null,null)}function Q(n){return a["\u0275vid"](0,[(n()(),a["\u0275eld"](0,0,null,null,2,"div",[["class","d-flex justify-content-center prazna-tabela"]],null,null,null,null,null)),(n()(),a["\u0275eld"](1,0,null,null,1,"mat-spinner",[["class","mat-spinner mat-progress-spinner"],["mode","indeterminate"],["role","progressbar"]],[[2,"_mat-animation-noopable",null],[4,"width","px"],[4,"height","px"]],null,null,_.b,_.a)),a["\u0275did"](2,49152,null,0,F.d,[a.ElementRef,P.a,[2,M.DOCUMENT],[2,w.a],F.a],null,null)],null,function(n,l){n(l,1,0,a["\u0275nov"](l,2)._noopAnimations,a["\u0275nov"](l,2).diameter,a["\u0275nov"](l,2).diameter)})}function W(n){return a["\u0275vid"](0,[(n()(),a["\u0275eld"](0,0,null,null,31,"main",[],null,null,null,null,null)),(n()(),a["\u0275eld"](1,0,null,null,22,"div",[["class","sekcija-pretraga"]],null,null,null,null,null)),(n()(),a["\u0275eld"](2,0,null,null,18,"div",[["class","d-flex align-items-center justify-content-center"]],null,null,null,null,null)),(n()(),a["\u0275eld"](3,0,null,null,17,"div",[["class","forms-input"]],null,null,null,null,null)),(n()(),a["\u0275eld"](4,0,null,null,5,"input",[["class","p-1 flex-grow-1 search__input"],["type","search"]],[[2,"ng-untouched",null],[2,"ng-touched",null],[2,"ng-pristine",null],[2,"ng-dirty",null],[2,"ng-valid",null],[2,"ng-invalid",null],[2,"ng-pending",null]],[[null,"ngModelChange"],[null,"keyup.enter"],[null,"input"],[null,"blur"],[null,"compositionstart"],[null,"compositionend"]],function(n,l,e){var t=!0,o=n.component;return"input"===l&&(t=!1!==a["\u0275nov"](n,5)._handleInput(e.target.value)&&t),"blur"===l&&(t=!1!==a["\u0275nov"](n,5).onTouched()&&t),"compositionstart"===l&&(t=!1!==a["\u0275nov"](n,5)._compositionStart()&&t),"compositionend"===l&&(t=!1!==a["\u0275nov"](n,5)._compositionEnd(e.target.value)&&t),"ngModelChange"===l&&(t=!1!==(o.searchValue=e)&&t),"keyup.enter"===l&&(t=!1!==o.pronaciPoTrazenojReci(o.searchValue)&&t),t},null,null)),a["\u0275did"](5,16384,null,0,N.d,[a.Renderer2,a.ElementRef,[2,N.a]],null,null),a["\u0275prd"](1024,null,N.j,function(n){return[n]},[N.d]),a["\u0275did"](7,671744,null,0,N.o,[[8,null],[8,null],[8,null],[6,N.j]],{model:[0,"model"]},{update:"ngModelChange"}),a["\u0275prd"](2048,null,N.k,null,[N.o]),a["\u0275did"](9,16384,null,0,N.l,[[4,N.k]],null,null),(n()(),a["\u0275eld"](10,0,null,null,5,"div",[["class","p-1"]],null,[[null,"click"]],function(n,l,e){var a=!0,t=n.component;return"click"===l&&(a=!1!==t.pronaciPoTrazenojReci(t.searchValue)&&a),a},null,null)),(n()(),a["\u0275eld"](11,0,null,null,4,"button",[["class","pozadina-glavna-100"],["mat-mini-fab",""]],[[8,"disabled",0],[2,"_mat-animation-noopable",null]],null,null,R.d,R.b)),a["\u0275did"](12,180224,null,0,S.b,[a.ElementRef,P.a,I.f,[2,w.a]],null,null),(n()(),a["\u0275eld"](13,0,null,0,2,"mat-icon",[["class","mat-icon"],["role","img"]],[[2,"mat-icon-inline",null]],null,null,x.b,x.a)),a["\u0275did"](14,638976,null,0,E.a,[a.ElementRef,E.c,[8,null]],null,null),(n()(),a["\u0275ted"](-1,0,["search"])),(n()(),a["\u0275eld"](16,0,null,null,4,"div",[["class","p-1"]],null,[[null,"click"]],function(n,l,e){var a=!0;return"click"===l&&(a=!1!==n.component.toogleFilterDiv()&&a),a},null,null)),(n()(),a["\u0275and"](16777216,null,null,1,null,K)),a["\u0275did"](18,16384,null,0,M.NgIf,[a.ViewContainerRef,a.TemplateRef],{ngIf:[0,"ngIf"]},null),(n()(),a["\u0275and"](16777216,null,null,1,null,Z)),a["\u0275did"](20,16384,null,0,M.NgIf,[a.ViewContainerRef,a.TemplateRef],{ngIf:[0,"ngIf"]},null),(n()(),a["\u0275eld"](21,0,null,null,2,"div",[["class","d-flex justify-content-center"]],null,null,null,null,null)),(n()(),a["\u0275and"](16777216,null,null,1,null,q)),a["\u0275did"](23,16384,null,0,M.NgIf,[a.ViewContainerRef,a.TemplateRef],{ngIf:[0,"ngIf"]},null),(n()(),a["\u0275eld"](24,0,null,null,1,"app-filter",[],null,[[null,"filterEvent"]],function(n,l,e){var a=!0;return"filterEvent"===l&&(a=!1!==n.component.filtriraj(e)&&a),a},V.b,V.a)),a["\u0275did"](25,114688,null,0,L.a,[O.a,T.a,A.a],{otvoriFilter:[0,"otvoriFilter"],vrstaRobe:[1,"vrstaRobe"]},{filterEvent:"filterEvent"}),(n()(),a["\u0275and"](16777216,null,null,1,null,G)),a["\u0275did"](27,16384,null,0,M.NgIf,[a.ViewContainerRef,a.TemplateRef],{ngIf:[0,"ngIf"]},null),(n()(),a["\u0275and"](16777216,null,null,1,null,Q)),a["\u0275did"](29,16384,null,0,M.NgIf,[a.ViewContainerRef,a.TemplateRef],{ngIf:[0,"ngIf"]},null),(n()(),a["\u0275eld"](30,0,null,null,1,"app-tabela",[],null,[[null,"magacinEvent"]],function(n,l,e){var a=!0;return"magacinEvent"===l&&(a=!1!==n.component.paginatorEvent(e)&&a),a},U.b,U.a)),a["\u0275did"](31,114688,null,0,D.a,[A.a,m.a,J.a,c.a,O.l],{dataSource:[0,"dataSource"],roba:[1,"roba"],rowsPerPage:[2,"rowsPerPage"],pageIndex:[3,"pageIndex"],tableLength:[4,"tableLength"]},{magacinEvent:"magacinEvent"})],function(n,l){var e=l.component;n(l,7,0,e.searchValue),n(l,14,0),n(l,18,0,!e.otvoriFilter),n(l,20,0,e.otvoriFilter),n(l,23,0,e.pocetnoPretrazivanje),n(l,25,0,e.otvoriFilter,e.vrstaRobe),n(l,27,0,!e.pronadjenaRoba),n(l,29,0,e.ucitavanje),n(l,31,0,e.dataSource,e.roba,e.rowsPerPage,e.pageIndex,e.tableLength)},function(n,l){n(l,4,0,a["\u0275nov"](l,9).ngClassUntouched,a["\u0275nov"](l,9).ngClassTouched,a["\u0275nov"](l,9).ngClassPristine,a["\u0275nov"](l,9).ngClassDirty,a["\u0275nov"](l,9).ngClassValid,a["\u0275nov"](l,9).ngClassInvalid,a["\u0275nov"](l,9).ngClassPending),n(l,11,0,a["\u0275nov"](l,12).disabled||null,"NoopAnimations"===a["\u0275nov"](l,12)._animationMode),n(l,13,0,a["\u0275nov"](l,14).inline)})}var X=a["\u0275ccf"]("app-roba",b,function(n){return a["\u0275vid"](0,[(n()(),a["\u0275eld"](0,0,null,null,1,"app-roba",[],null,null,null,W,Y)),a["\u0275did"](1,114688,null,0,b,[t.a,c.a,m.a],null,null)],function(n,l){n(l,1,0)},null)},{},{},[]),B=e("M2Lx"),H=e("wmQ5"),$=e("Wf4p"),nn=e("o3x0"),ln=e("uGex"),en=e("4tE/"),an=e("mVsa"),tn=e("4epT"),on=e("OkvK"),un=e("4c35"),rn=e("de3e"),dn=e("YhbO"),cn=e("jlZm"),pn=e("Lwpp"),sn=e("seP3"),mn=e("/VYK"),bn=e("b716"),vn=e("vARd"),fn=e("/dO6"),gn=e("6Wmm"),hn=e("9It4"),jn=e("y4qS"),Rn=e("BHnd"),Sn=e("La40"),Pn=e("vGXY"),In=e("8mMr"),wn=e("Nsh5"),kn=e("LC5p"),Cn=e("0/Q6"),yn=e("r43C"),zn=e("FVSy"),xn=e("jAig"),En=e("7kDf"),_n=e("YSh2");e.d(l,"RobaModuleNgFactory",function(){return Fn});var Fn=a["\u0275cmf"](v,[],function(n){return a["\u0275mod"]([a["\u0275mpd"](512,a.ComponentFactoryResolver,a["\u0275CodegenComponentFactoryResolver"],[[8,[f.a,g.a,h.a,h.b,j.a,X]],[3,a.ComponentFactoryResolver],a.NgModuleRef]),a["\u0275mpd"](4608,M.NgLocalization,M.NgLocaleLocalization,[a.LOCALE_ID,[2,M["\u0275angular_packages_common_common_a"]]]),a["\u0275mpd"](4608,N.e,N.e,[]),a["\u0275mpd"](4608,N.w,N.w,[]),a["\u0275mpd"](4608,B.c,B.c,[]),a["\u0275mpd"](4608,C.c,C.c,[C.i,C.e,a.ComponentFactoryResolver,C.h,C.f,a.Injector,a.NgZone,M.DOCUMENT,z.b]),a["\u0275mpd"](5120,C.j,C.k,[C.c]),a["\u0275mpd"](5120,k.b,k.c,[C.c]),a["\u0275mpd"](4608,H.f,H.f,[]),a["\u0275mpd"](4608,$.d,$.d,[]),a["\u0275mpd"](5120,nn.c,nn.d,[C.c]),a["\u0275mpd"](4608,nn.e,nn.e,[C.c,a.Injector,[2,M.Location],[2,nn.b],nn.c,[3,nn.e],C.e]),a["\u0275mpd"](5120,ln.a,ln.b,[C.c]),a["\u0275mpd"](5120,en.a,en.b,[C.c]),a["\u0275mpd"](5120,an.a,an.c,[C.c]),a["\u0275mpd"](5120,tn.c,tn.a,[[3,tn.c]]),a["\u0275mpd"](5120,on.b,on.a,[[3,on.b]]),a["\u0275mpd"](1073742336,M.CommonModule,M.CommonModule,[]),a["\u0275mpd"](1073742336,N.t,N.t,[]),a["\u0275mpd"](1073742336,N.q,N.q,[]),a["\u0275mpd"](1073742336,N.h,N.h,[]),a["\u0275mpd"](1073742336,z.a,z.a,[]),a["\u0275mpd"](1073742336,$.l,$.l,[[2,$.e]]),a["\u0275mpd"](1073742336,P.b,P.b,[]),a["\u0275mpd"](1073742336,$.x,$.x,[]),a["\u0275mpd"](1073742336,S.c,S.c,[]),a["\u0275mpd"](1073742336,B.d,B.d,[]),a["\u0275mpd"](1073742336,I.a,I.a,[]),a["\u0275mpd"](1073742336,un.g,un.g,[]),a["\u0275mpd"](1073742336,y.b,y.b,[]),a["\u0275mpd"](1073742336,C.g,C.g,[]),a["\u0275mpd"](1073742336,k.e,k.e,[]),a["\u0275mpd"](1073742336,rn.a,rn.a,[]),a["\u0275mpd"](1073742336,dn.c,dn.c,[]),a["\u0275mpd"](1073742336,cn.a,cn.a,[]),a["\u0275mpd"](1073742336,pn.d,pn.d,[]),a["\u0275mpd"](1073742336,E.b,E.b,[]),a["\u0275mpd"](1073742336,H.g,H.g,[]),a["\u0275mpd"](1073742336,sn.d,sn.d,[]),a["\u0275mpd"](1073742336,mn.c,mn.c,[]),a["\u0275mpd"](1073742336,bn.b,bn.b,[]),a["\u0275mpd"](1073742336,nn.i,nn.i,[]),a["\u0275mpd"](1073742336,vn.e,vn.e,[]),a["\u0275mpd"](1073742336,fn.b,fn.b,[]),a["\u0275mpd"](1073742336,F.c,F.c,[]),a["\u0275mpd"](1073742336,gn.b,gn.b,[]),a["\u0275mpd"](1073742336,hn.c,hn.c,[]),a["\u0275mpd"](1073742336,$.v,$.v,[]),a["\u0275mpd"](1073742336,$.s,$.s,[]),a["\u0275mpd"](1073742336,ln.d,ln.d,[]),a["\u0275mpd"](1073742336,en.c,en.c,[]),a["\u0275mpd"](1073742336,jn.p,jn.p,[]),a["\u0275mpd"](1073742336,Rn.l,Rn.l,[]),a["\u0275mpd"](1073742336,Sn.j,Sn.j,[]),a["\u0275mpd"](1073742336,Pn.c,Pn.c,[]),a["\u0275mpd"](1073742336,In.b,In.b,[]),a["\u0275mpd"](1073742336,wn.h,wn.h,[]),a["\u0275mpd"](1073742336,$.n,$.n,[]),a["\u0275mpd"](1073742336,kn.b,kn.b,[]),a["\u0275mpd"](1073742336,Cn.d,Cn.d,[]),a["\u0275mpd"](1073742336,yn.a,yn.a,[]),a["\u0275mpd"](1073742336,zn.f,zn.f,[]),a["\u0275mpd"](1073742336,an.b,an.b,[]),a["\u0275mpd"](1073742336,tn.d,tn.d,[]),a["\u0275mpd"](1073742336,on.c,on.c,[]),a["\u0275mpd"](1073742336,xn.a,xn.a,[]),a["\u0275mpd"](1073742336,En.a,En.a,[]),a["\u0275mpd"](1073742336,O.p,O.p,[[2,O.v],[2,O.l]]),a["\u0275mpd"](1073742336,v,v,[]),a["\u0275mpd"](256,fn.a,{separatorKeyCodes:[_n.f]},[]),a["\u0275mpd"](1024,O.j,function(){return[[{path:"",component:b}]]},[])])})}}]);