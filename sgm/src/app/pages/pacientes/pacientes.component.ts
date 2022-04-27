import { Component, OnInit } from '@angular/core';
import { Paciente } from './interfaces/paciente.interface';
import { PacientesService } from './services/pacientes.service';

@Component({
  selector: 'app-pacientes',
  templateUrl: './pacientes.component.html',
  styleUrls: ['./pacientes.component.css']
})
export class PacientesComponent implements OnInit {

  pacientes!: Paciente[];

  pacientebeta= {
    id: '',
    numdocpaciente: 123456,
    pnombrepaciente: '',
    snombrepaciente: '',
    papellidopaciente: '',
    sapellidopaciente: '',
    tipodocpaciente: '',
    birthpaciente: '',
    generopaciente: '',
    paispaciente: '',
    movilpaciente: 3333333,
    telfijopaciente: 55555,
    dirpaciente: '',
    ciudadpaciente: '',
    sedepaciente: '',
    emailpaciente: '',
    estadopaciente: false,
    recibircomunicados: false
  }

  constructor(private pacienteSvc: PacientesService) { }

  ngOnInit(): void {
    this.pacienteSvc.getPacientes()
    .subscribe((data:Paciente[]) => this.pacientes = data);
  }

  getPacientes(){
    this.pacienteSvc.getPacientes()
    .subscribe((data: Paciente[]) =>this.pacientes = data);
  }

  createPaciente(){
    this.pacienteSvc.createPaciente(this.pacientebeta)
    .subscribe(() => this.getPacientes());

    this.pacientebeta = {
    id: '',
    numdocpaciente: 123456,
    pnombrepaciente: '',
    snombrepaciente: '',
    papellidopaciente: '',
    sapellidopaciente: '',
    tipodocpaciente: '',
    birthpaciente: '',
    generopaciente: '',
    paispaciente: '',
    movilpaciente: 3333333,
    telfijopaciente: 55555,
    dirpaciente: '',
    ciudadpaciente: '',
    sedepaciente: '',
    emailpaciente: '',
    estadopaciente: false,
    recibircomunicados: false
    }
  }

  savePaciente(){
    if(this.pacientebeta.id!=''){
      this.pacienteSvc.updatePaciente(this.pacientebeta.id, this.pacientebeta)
      .subscribe(() => this.getPacientes());
    }else{
      this.pacienteSvc.createPaciente(this.pacientebeta)
      .subscribe(() => this.getPacientes());
    }
    this.pacientebeta = {
    id: '',
    numdocpaciente: 123456,
    pnombrepaciente: '',
    snombrepaciente: '',
    papellidopaciente: '',
    sapellidopaciente: '',
    tipodocpaciente: '',
    birthpaciente: '',
    generopaciente: '',
    paispaciente: '',
    movilpaciente: 3333333,
    telfijopaciente: 55555,
    dirpaciente: '',
    ciudadpaciente: '',
    sedepaciente: '',
    emailpaciente: '',
    estadopaciente: false,
    recibircomunicados: false
    }
  }

  updatePaciente(patient : any){
    this.pacientebeta = {
      ...patient
    };
  }

   deletePaciente(patient : any){
    this.pacienteSvc.deletePaciente(patient.id)
    .subscribe(() => this.getPacientes());
    }


  }







