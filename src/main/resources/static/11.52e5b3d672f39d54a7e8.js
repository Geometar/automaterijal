(window.webpackJsonp=window.webpackJsonp||[]).push([[11],{SDMI:function(n,e,a){"use strict";a.r(e);var t=a("CcnG"),l=a("jvbL"),i=a("9Z1F"),r=a("2WpN"),o=a("G5J1"),d=a("XlPw"),p=a("1Is/"),u=a("me6m"),c=a("mM42"),s=a("dL++"),m=a("zF8A"),b=function(){function n(n,e,a){this.robaService=n,this.dataService=e,this.loginService=a,this.vrstaRobe=c.a.FILTERI,this.rowsPerPage=10,this.pageIndex=0,this.sort=null,this.filter=new s.a,this.searchValue="",this.ucitavanje=!1,this.pronadjenaRoba=!0,this.otvoriFilter=!1,this.alive=!0}return n.prototype.ngOnInit=function(){this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji(),this.pronandjiSveFiltere()},n.prototype.pronandjiSveFiltere=function(){var n=this;this.ucitavanje=!0,this.pronadjenaRoba=!0,this.robaService.pronadjiFiltere(this.sort,this.rowsPerPage,this.pageIndex,null,null,null).pipe(Object(l.a)(function(){return n.alive}),Object(i.a)(function(e){return 404===e.status?(n.pronadjenaRoba=!1,o.a):Object(d.a)(e)}),Object(r.a)(function(){return n.ucitavanje=!1})).subscribe(function(e){n.pronadjenaRoba=!0,n.roba=e.content,n.roba=n.dataService.skiniSaStanjaUkolikoJeUKorpi(n.roba),n.dataSource=n.roba,n.rowsPerPage=e.size,n.pageIndex=e.number,n.tableLength=e.totalElements},function(e){n.roba=null})},n.prototype.pronadjiFilterePoPretrazi=function(n){var e=this;this.ucitavanje=!0,this.dataSource=null,this.ucitavanje=!0,this.pronadjenaRoba=!0,this.robaService.pronadjiFiltere(this.sort,this.rowsPerPage,this.pageIndex,n,this.filter.naStanju,this.filter.proizvodjacId).pipe(Object(l.a)(function(){return e.alive}),Object(i.a)(function(n){return 404===n.status?(e.pronadjenaRoba=!1,o.a):Object(d.a)(n)}),Object(r.a)(function(){return e.ucitavanje=!1})).subscribe(function(n){e.pronadjenaRoba=!0,e.roba=n.content,e.roba=e.dataService.skiniSaStanjaUkolikoJeUKorpi(e.roba),e.dataSource=e.roba,e.rowsPerPage=n.size,e.pageIndex=n.number,e.tableLength=n.totalElements},function(n){e.roba=null})},n.prototype.pronaciPoTrazenojReci=function(n){this.dataSource&&(this.pageIndex=0),this.searchValue=n,this.pronadjiFilterePoPretrazi(n)},n.prototype.paginatorEvent=function(n){this.dataSource=[],this.rowsPerPage=n.pageSize,this.pageIndex=n.pageIndex,this.pronadjiFilterePoPretrazi(this.searchValue)},n.prototype.toogleFilterDiv=function(n){this.otvoriFilter=n},n.prototype.filtriraj=function(n){this.dataSource&&(this.pageIndex=0),this.filter=n,this.pronadjiFilterePoPretrazi(this.searchValue)},n}(),g=function(){},v=a("NcP4"),f=a("t68o"),h=a("xYTU"),j=a("pMnS"),P=a("NvT6"),S=a("Blfk"),I=a("dWZg"),w=a("Ip0R"),F=a("wFw1"),x=a("AzfJ"),R=a("2MH0"),E=a("JovF"),z=a("M95+"),k=a("ZYCi"),C=a("o5Qa"),y=a("sDaS"),L=a("I/CJ"),O=a("QOyY"),M=a("A6ij"),N=t["\u0275crt"]({encapsulation:0,styles:[[".sekcija-pretraga[_ngcontent-%COMP%]{height:150px;background-image:url(/assets/slike/ui/pozadine/filteri.png);background-repeat:no-repeat;background-size:contain}@media only screen and (max-device-width :1025px){.mobilna-duzina[_ngcontent-%COMP%]{width:100%}.input-group-prepend[_ngcontent-%COMP%]{margin-top:10px;margin-left:0}}"]],data:{}});function A(n){return t["\u0275vid"](0,[(n()(),t["\u0275eld"](0,0,null,null,4,"div",[["class","d-flex flex-column prazna-tabela"]],null,null,null,null,null)),(n()(),t["\u0275eld"](1,0,null,null,1,"i",[["class","material-icons icon-size"]],null,null,null,null,null)),(n()(),t["\u0275ted"](-1,null,[" error_outline "])),(n()(),t["\u0275eld"](3,0,null,null,1,"h1",[["class","h1-upozorenje"]],null,null,null,null,null)),(n()(),t["\u0275ted"](-1,null,["Artikal ne postoji"]))],null,null)}function _(n){return t["\u0275vid"](0,[(n()(),t["\u0275eld"](0,0,null,null,2,"div",[["class","d-flex justify-content-center prazna-tabela"]],null,null,null,null,null)),(n()(),t["\u0275eld"](1,0,null,null,1,"mat-spinner",[["class","mat-spinner mat-progress-spinner"],["mode","indeterminate"],["role","progressbar"]],[[2,"_mat-animation-noopable",null],[4,"width","px"],[4,"height","px"]],null,null,P.b,P.a)),t["\u0275did"](2,49152,null,0,S.d,[t.ElementRef,I.a,[2,w.DOCUMENT],[2,F.a],S.a],null,null)],null,function(n,e){n(e,1,0,t["\u0275nov"](e,2)._noopAnimations,t["\u0275nov"](e,2).diameter,t["\u0275nov"](e,2).diameter)})}function D(n){return t["\u0275vid"](0,[(n()(),t["\u0275eld"](0,0,null,null,11,"main",[],null,null,null,null,null)),(n()(),t["\u0275eld"](1,0,null,null,2,"div",[["class","sekcija-pretraga pretraga-bar"]],null,null,null,null,null)),(n()(),t["\u0275eld"](2,0,null,null,1,"app-pretraga",[],null,[[null,"pretragaEvent"],[null,"filterEvent"]],function(n,e,a){var t=!0,l=n.component;return"pretragaEvent"===e&&(t=!1!==l.pronaciPoTrazenojReci(a)&&t),"filterEvent"===e&&(t=!1!==l.toogleFilterDiv(a)&&t),t},x.b,x.a)),t["\u0275did"](3,114688,null,0,R.a,[],null,{pretragaEvent:"pretragaEvent",filterEvent:"filterEvent"}),(n()(),t["\u0275eld"](4,0,null,null,1,"app-filter",[],null,[[null,"filterEvent"]],function(n,e,a){var t=!0;return"filterEvent"===e&&(t=!1!==n.component.filtriraj(a)&&t),t},E.b,E.a)),t["\u0275did"](5,114688,null,0,z.a,[k.a,C.a,y.a],{otvoriFilter:[0,"otvoriFilter"],vrstaRobe:[1,"vrstaRobe"]},{filterEvent:"filterEvent"}),(n()(),t["\u0275and"](16777216,null,null,1,null,A)),t["\u0275did"](7,16384,null,0,w.NgIf,[t.ViewContainerRef,t.TemplateRef],{ngIf:[0,"ngIf"]},null),(n()(),t["\u0275and"](16777216,null,null,1,null,_)),t["\u0275did"](9,16384,null,0,w.NgIf,[t.ViewContainerRef,t.TemplateRef],{ngIf:[0,"ngIf"]},null),(n()(),t["\u0275eld"](10,0,null,null,1,"app-tabela",[],null,[[null,"magacinEvent"]],function(n,e,a){var t=!0;return"magacinEvent"===e&&(t=!1!==n.component.paginatorEvent(a)&&t),t},L.b,L.a)),t["\u0275did"](11,114688,null,0,O.a,[y.a,m.a,M.a,u.a,k.l],{dataSource:[0,"dataSource"],roba:[1,"roba"],rowsPerPage:[2,"rowsPerPage"],pageIndex:[3,"pageIndex"],tableLength:[4,"tableLength"]},{magacinEvent:"magacinEvent"})],function(n,e){var a=e.component;n(e,3,0),n(e,5,0,a.otvoriFilter,a.vrstaRobe),n(e,7,0,!a.pronadjenaRoba),n(e,9,0,a.ucitavanje),n(e,11,0,a.dataSource,a.roba,a.rowsPerPage,a.pageIndex,a.tableLength)},null)}var T=t["\u0275ccf"]("app-filteri",b,function(n){return t["\u0275vid"](0,[(n()(),t["\u0275eld"](0,0,null,null,1,"app-filteri",[],null,null,null,D,N)),t["\u0275did"](1,114688,null,0,b,[p.a,u.a,m.a],null,null)],function(n,e){n(e,1,0)},null)},{},{},[]),J=a("gIcY"),U=a("M2Lx"),V=a("eDkP"),Y=a("Fzqc"),q=a("v9Dh"),K=a("wmQ5"),Z=a("Wf4p"),G=a("o3x0"),Q=a("uGex"),W=a("4tE/"),H=a("mVsa"),B=a("4epT"),X=a("OkvK"),$=a("UodH"),nn=a("lLAP"),en=a("4c35"),an=a("qAlS"),tn=a("de3e"),ln=a("YhbO"),rn=a("jlZm"),on=a("Lwpp"),dn=a("SMsm"),pn=a("seP3"),un=a("/VYK"),cn=a("b716"),sn=a("vARd"),mn=a("/dO6"),bn=a("6Wmm"),gn=a("9It4"),vn=a("y4qS"),fn=a("BHnd"),hn=a("La40"),jn=a("vGXY"),Pn=a("8mMr"),Sn=a("Nsh5"),In=a("LC5p"),wn=a("0/Q6"),Fn=a("r43C"),xn=a("FVSy"),Rn=a("jAig"),En=a("7kDf"),zn=a("YSh2");a.d(e,"FilteriModuleNgFactory",function(){return kn});var kn=t["\u0275cmf"](g,[],function(n){return t["\u0275mod"]([t["\u0275mpd"](512,t.ComponentFactoryResolver,t["\u0275CodegenComponentFactoryResolver"],[[8,[v.a,f.a,h.a,h.b,j.a,T]],[3,t.ComponentFactoryResolver],t.NgModuleRef]),t["\u0275mpd"](4608,w.NgLocalization,w.NgLocaleLocalization,[t.LOCALE_ID,[2,w["\u0275angular_packages_common_common_a"]]]),t["\u0275mpd"](4608,J.e,J.e,[]),t["\u0275mpd"](4608,J.w,J.w,[]),t["\u0275mpd"](4608,U.c,U.c,[]),t["\u0275mpd"](4608,V.c,V.c,[V.i,V.e,t.ComponentFactoryResolver,V.h,V.f,t.Injector,t.NgZone,w.DOCUMENT,Y.b]),t["\u0275mpd"](5120,V.j,V.k,[V.c]),t["\u0275mpd"](5120,q.b,q.c,[V.c]),t["\u0275mpd"](4608,K.f,K.f,[]),t["\u0275mpd"](4608,Z.d,Z.d,[]),t["\u0275mpd"](5120,G.c,G.d,[V.c]),t["\u0275mpd"](4608,G.e,G.e,[V.c,t.Injector,[2,w.Location],[2,G.b],G.c,[3,G.e],V.e]),t["\u0275mpd"](5120,Q.a,Q.b,[V.c]),t["\u0275mpd"](5120,W.a,W.b,[V.c]),t["\u0275mpd"](5120,H.a,H.c,[V.c]),t["\u0275mpd"](5120,B.c,B.a,[[3,B.c]]),t["\u0275mpd"](5120,X.b,X.a,[[3,X.b]]),t["\u0275mpd"](1073742336,w.CommonModule,w.CommonModule,[]),t["\u0275mpd"](1073742336,J.t,J.t,[]),t["\u0275mpd"](1073742336,J.q,J.q,[]),t["\u0275mpd"](1073742336,J.h,J.h,[]),t["\u0275mpd"](1073742336,Y.a,Y.a,[]),t["\u0275mpd"](1073742336,Z.l,Z.l,[[2,Z.e]]),t["\u0275mpd"](1073742336,I.b,I.b,[]),t["\u0275mpd"](1073742336,Z.x,Z.x,[]),t["\u0275mpd"](1073742336,$.c,$.c,[]),t["\u0275mpd"](1073742336,U.d,U.d,[]),t["\u0275mpd"](1073742336,nn.a,nn.a,[]),t["\u0275mpd"](1073742336,en.g,en.g,[]),t["\u0275mpd"](1073742336,an.b,an.b,[]),t["\u0275mpd"](1073742336,V.g,V.g,[]),t["\u0275mpd"](1073742336,q.e,q.e,[]),t["\u0275mpd"](1073742336,tn.a,tn.a,[]),t["\u0275mpd"](1073742336,ln.c,ln.c,[]),t["\u0275mpd"](1073742336,rn.a,rn.a,[]),t["\u0275mpd"](1073742336,on.d,on.d,[]),t["\u0275mpd"](1073742336,dn.b,dn.b,[]),t["\u0275mpd"](1073742336,K.g,K.g,[]),t["\u0275mpd"](1073742336,pn.d,pn.d,[]),t["\u0275mpd"](1073742336,un.c,un.c,[]),t["\u0275mpd"](1073742336,cn.b,cn.b,[]),t["\u0275mpd"](1073742336,G.i,G.i,[]),t["\u0275mpd"](1073742336,sn.e,sn.e,[]),t["\u0275mpd"](1073742336,mn.b,mn.b,[]),t["\u0275mpd"](1073742336,S.c,S.c,[]),t["\u0275mpd"](1073742336,bn.b,bn.b,[]),t["\u0275mpd"](1073742336,gn.c,gn.c,[]),t["\u0275mpd"](1073742336,Z.v,Z.v,[]),t["\u0275mpd"](1073742336,Z.s,Z.s,[]),t["\u0275mpd"](1073742336,Q.d,Q.d,[]),t["\u0275mpd"](1073742336,W.c,W.c,[]),t["\u0275mpd"](1073742336,vn.p,vn.p,[]),t["\u0275mpd"](1073742336,fn.l,fn.l,[]),t["\u0275mpd"](1073742336,hn.j,hn.j,[]),t["\u0275mpd"](1073742336,jn.c,jn.c,[]),t["\u0275mpd"](1073742336,Pn.b,Pn.b,[]),t["\u0275mpd"](1073742336,Sn.h,Sn.h,[]),t["\u0275mpd"](1073742336,Z.n,Z.n,[]),t["\u0275mpd"](1073742336,In.b,In.b,[]),t["\u0275mpd"](1073742336,wn.d,wn.d,[]),t["\u0275mpd"](1073742336,Fn.a,Fn.a,[]),t["\u0275mpd"](1073742336,xn.f,xn.f,[]),t["\u0275mpd"](1073742336,H.b,H.b,[]),t["\u0275mpd"](1073742336,B.d,B.d,[]),t["\u0275mpd"](1073742336,X.c,X.c,[]),t["\u0275mpd"](1073742336,Rn.a,Rn.a,[]),t["\u0275mpd"](1073742336,En.a,En.a,[]),t["\u0275mpd"](1073742336,k.p,k.p,[[2,k.v],[2,k.l]]),t["\u0275mpd"](1073742336,g,g,[]),t["\u0275mpd"](256,mn.a,{separatorKeyCodes:[zn.f]},[]),t["\u0275mpd"](1024,k.j,function(){return[[{path:"",component:b}]]},[])])})}}]);