export class Filter {
    proizvodjacId?: string;
    proizvodjac?: string;
    raspolozivost?: string;
    naStanju?: boolean;

    Filter() {
        this.proizvodjac = '';
        this.raspolozivost = 'Svi artikli';
    }
}
