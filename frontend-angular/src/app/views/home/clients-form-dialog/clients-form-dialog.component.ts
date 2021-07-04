import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
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
    public dialogRef: MatDialogRef<ClientsFormDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      
    }

   

  ngOnInit(): void {
    this.clientForm = this.fb.group({
      nome:['',[Validators.required]]
    })
  }

  createCliente(){
    if (this.data.insert == 0){
      this.rest.putClients(this.data.identificator,this.clientForm.value).subscribe(result => { });
    } else {
      this.rest.postClients(this.clientForm.value).subscribe(result => {});
      this.data.insert = 1;
    }
    this.dialogRef.close();
    this.clientForm.reset();
    window.location.reload();
  }


  cancel(): void {
    this.dialogRef.close();
    this.clientForm.reset();
  }




}
