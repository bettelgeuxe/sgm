import { ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Paciente } from '../interfaces/paciente.interface';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush

})
export class PacienteComponent implements OnInit {
  @Input() paciente!: Paciente;


  constructor() { }

  ngOnInit(): void {
  }

}
