import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { ClientsService } from 'src/app/shared/service/clients.service';

@Component({
  selector: 'app-clients-form-dialog',
  templateUrl: './clients-form-dialog.component.html',
  styleUrls: ['./clients-form-dialog.component.css']
})
export class ClientsFormDialogComponent implements OnInit {

  public clientForm!: FormGroup;


  constructor(
    private fb: FormBuilder,
    private rest: ClientsService,
    public dialogRef: MatDialogRef<ClientsFormDialogComponent>
  ) { }

  ngOnInit(): void {
    this.clientForm = this.fb.group({
      nome:['',[Validators.required]]
    })
  }

  createCliente(){
    this.rest.postClients(this.clientForm.value).subscribe(result => {});
    this.dialogRef.close();
    this.clientForm.reset();
    window.location.reload();
  }

  cancel(): void {
    this.dialogRef.close();
    this.clientForm.reset();
  }


}
