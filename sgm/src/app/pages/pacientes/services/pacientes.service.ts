import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Paciente } from '../interfaces/paciente.interface';

const API_BASE = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class PacientesService {

  constructor(private http:HttpClient) { }

  getPacientes():Observable<Paciente[]>{

    return this.http.get<Paciente[]>(`${API_BASE}/pacientes`);
  }

  createPaciente(paciente: Paciente){
    return this.http.post<Paciente[]>(`${API_BASE}/pacientes`, paciente);
  }

  updatePaciente(id: string, paciente: Paciente){
    return this.http.put<Paciente[]>(`${API_BASE}/pacientes/${id}`, paciente)
  }

  deletePaciente(id: string){
    return this.http.delete<Paciente[]>(`${API_BASE}/pacientes/${id}`);
  }
}
