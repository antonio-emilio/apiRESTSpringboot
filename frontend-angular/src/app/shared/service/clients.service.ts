import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Clients } from '../clients.model';
import { ResponsePageable } from '../responsePageable.model';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  apiUrl = 'http://localhost:8080/clientes';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  };

  constructor(
    private httpClient: HttpClient

  ) { }

    public getClientsWithFlag(): Observable<ResponsePageable> {
      return this.httpClient.get<ResponsePageable>(this.apiUrl)
    }

    public postClients(clients: any): Observable<Clients> {
      return this.httpClient.post<any>(this.apiUrl,clients,this.httpOptions)
    }

}
