import { Component, OnInit } from '@angular/core';
import { Clients } from 'src/app/shared/clients.model';
import { ClientsService } from 'src/app/shared/service/clients.service'

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit {

  clientsNow!: Clients[];
  cli: boolean = false;

  constructor(
    public clientsService: ClientsService
    ) { }

  ngOnInit(): void {
    this.getClients();
  }

  getClients(){
    this.clientsService.getClientsWithFlag().subscribe(data => {
        this.clientsNow = data.content;
        this.cli = true;
    });
  }

}
