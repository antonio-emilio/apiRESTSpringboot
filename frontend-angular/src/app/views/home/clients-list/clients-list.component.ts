import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog/dialog';
import { Clients } from 'src/app/shared/clients.model';
import { ClientsService } from 'src/app/shared/service/clients.service'
import { ClientsFormDialogComponent } from '../clients-form-dialog/clients-form-dialog.component';

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit {


  clientsNow!: Clients[];
  cli: boolean = false;
  dialog!: MatDialog;

  constructor(
    private rest: ClientsService,
    public clientsService: ClientsService,
  ) { }

  ngOnInit(): void {
    this.getClients();
  }

  /*Get all clients*/
  getClients() {
    this.clientsService.getClientsWithFlag().subscribe(data => {
      this.clientsNow = data.content;
      this.cli = true;
    });
  }
  
  /*Delete one client*/
  deleteCliente(id: any) {
    this.rest.deleteClient(id).subscribe(result => { });
    window.location.reload();
  }

}
