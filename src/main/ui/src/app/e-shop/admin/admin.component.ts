import { Component, OnInit, OnDestroy } from '@angular/core';
import { AdminServiceService } from '../service/admin-service.service';
import { LogovanjaPage, Logovanja } from '../model/dto';
import { takeWhile } from 'rxjs/operators';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit, OnDestroy {

  public logovanja: Logovanja[];
  public ulogovaniPartneri: string[];
  public dataSource: any;

  public ucitavanjeLogovanja = false;
  public ucitavanjeSesija = false;

  // Paging and Sorting elements
  public displayedColumns: string[] = ['ppid', 'naziv', 'vreme'];
  public rowsPerPage = 10;
  public pageIndex = 0;
  public tableLength;

  // boolean za unistavanje observera
  private alive = true;

  constructor(private adminServis: AdminServiceService) { }

  ngOnInit() {
    this.uzmiSveAdminPodatke();
  }

  uzmiSveAdminPodatke() {
    this.ucitavanjeLogovanja = true;
    this.adminServis.vratiSvaLogovanja(this.pageIndex, this.rowsPerPage)
      .pipe(takeWhile(() => this.alive))
      .subscribe((res: LogovanjaPage) => {
        this.logovanja = res.content;
        this.dataSource = this.logovanja;
        this.rowsPerPage = res.size;
        this.pageIndex = res.number;
        this.tableLength = res.totalElements;
        this.ucitavanjeLogovanja = false;
      });

    this.ucitavanjeSesija = true;
    this.adminServis.vratiSveUlogovanePartnere()
      .pipe(takeWhile(() => this.alive))
      .subscribe((res: string[]) => {
        this.ulogovaniPartneri = res;
        this.ucitavanjeSesija = false;
      });
  }

  paginatorEvent(pageEvent) {
    this.dataSource = [];
    this.rowsPerPage = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
    this.uzmiSveAdminPodatke();
  }

  ngOnDestroy() {
    this.alive = false;
  }

}
