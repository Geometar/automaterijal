import { Component, EventEmitter, Output, OnInit } from '@angular/core';

@Component({
  selector: 'app-pretraga',
  templateUrl: './pretraga.component.html',
  styleUrls: ['./pretraga.component.scss']
})
export class PretragaComponent implements OnInit {

  @Output() pretragaEvent = new EventEmitter<any>();
  @Output() filterEvent = new EventEmitter<any>();

  public searchValue = '';
  public otvoriFilter = false;
  public pocetnoPretrazivanje = true;
  public validnaPretaga = true;

  constructor() { }

  ngOnInit() {
    this.pocetnoPretrazivanje = true;
  }


  pronaciPoTrazenojReci(searchValue: string) {
    this.pocetnoPretrazivanje = false;
    if (searchValue == null
      || (searchValue.trim().length > 0 && searchValue.trim().length < 3)) {
      this.validnaPretaga = false;
      return;
    } else {
      this.validnaPretaga = true;
    }
    this.pretragaEvent.emit(searchValue);
  }

  toogleFilterDiv() {
    this.otvoriFilter = !this.otvoriFilter;
    this.filterEvent.emit(this.otvoriFilter);
  }
}
