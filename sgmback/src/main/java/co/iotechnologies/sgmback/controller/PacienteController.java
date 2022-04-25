package co.iotechnologies.sgmback.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.iotechnologies.sgmback.model.Paciente;
import co.iotechnologies.sgmback.repository.PacienteRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PacienteController {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@GetMapping("/pacientes")
	public ResponseEntity<List<Paciente>> getAllPacientes(@RequestParam(required = false) String emailpaciente) {
		try {
			List<Paciente> pacientes = new ArrayList<Paciente>();

			if (emailpaciente == null) {
				pacienteRepository.findAll().forEach(pacientes::add);
			} else {
				pacienteRepository.findByEmailpaciente(emailpaciente).forEach(pacientes::add);
			}

			if (pacientes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(pacientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/pacientes/id/{id}")
	public ResponseEntity<Paciente> getPacienteById(@PathVariable("id") String id) {
		Optional<Paciente> pacienteData = pacienteRepository.findById(id);

		if (pacienteData.isPresent()) {
			return new ResponseEntity<>(pacienteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/pacientes/nombre/{nombre}")
	public ResponseEntity<Paciente> getPacienteByPnombrepaciente(@PathVariable("nombre") String nombre) {
		Paciente aux=pacienteRepository.findByPnombrepaciente(nombre).get(0);
		Optional<Paciente> pacienteData =  Optional.of(aux);

		if (pacienteData.isPresent()) {
			return new ResponseEntity<>(pacienteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/pacientes/email/{email}")
	public ResponseEntity<Paciente> getPacienteByEmailpaciente(@PathVariable("email") String email) {
		Paciente aux=pacienteRepository.findByEmailpaciente(email).get(0);
		Optional<Paciente> pacienteData =  Optional.of(aux);

		if (pacienteData.isPresent()) {
			return new ResponseEntity<>(pacienteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/pacientes/cedula/{cedula}")
	public ResponseEntity<Paciente> getPacienteByNumdocpaciente(@PathVariable("cedula") Long cedula) {
		Paciente aux=pacienteRepository.findByNumdocpaciente(cedula).get(0);
		Optional<Paciente> pacienteData =  Optional.of(aux);

		if (pacienteData.isPresent()) {
			return new ResponseEntity<>(pacienteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/pacientes")
	public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente pacient) {
		try {
			Paciente _paciente = pacienteRepository.save(
					new Paciente(
							pacient.getNumdocpaciente(),
							pacient.getPnombrepaciente(),
							pacient.getSnombrepaciente(),
							pacient.getPapellidopaciente(),
							pacient.getSapellidopaciente(),
							pacient.getTipodocpaciente(),
							pacient.getBirthpaciente(),
							pacient.getGeneropaciente(),
							pacient.getPaispaciente(),
							pacient.getMovilpaciente(),
							pacient.getTelfijopaciente(),
							pacient.getDirpaciente(),
							pacient.getCiudadpaciente(),
							pacient.getSedepaciente(),
							pacient.getEmailpaciente(),
							pacient.isEstadopaciente(),
							pacient.isRecibircomunicados()));
							
			return new ResponseEntity<>(_paciente, HttpStatus.CREATED);
		} catch (DuplicateKeyException e) {
			return new ResponseEntity<>(null, HttpStatus.IM_USED);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//RECOMENDACIÓN, ENVIAR JSON SIN ID PERO EL SI ES OBLIGATORIO EN LA URL
		@PutMapping("/pacientes/id/{id}")
		public ResponseEntity<Paciente> updatePacienteById(@PathVariable("id") String id, @RequestBody Paciente pacient) {
			Optional<Paciente> pacienteData = pacienteRepository.findById(id);

			if (pacienteData.isPresent()) {
				Paciente _paciente = pacienteData.get();
				_paciente.setNumdocpaciente(pacient.getNumdocpaciente());
				_paciente.setPnombrepaciente(pacient.getPnombrepaciente());
				_paciente.setSnombrepaciente(pacient.getSnombrepaciente());
				_paciente.setPapellidopaciente(pacient.getPapellidopaciente());
				_paciente.setSapellidopaciente(pacient.getSapellidopaciente());
				_paciente.setTipodocpaciente(pacient.getTipodocpaciente());
				_paciente.setBirthpaciente(pacient.getBirthpaciente());
				_paciente.setPaispaciente(pacient.getPaispaciente());
				_paciente.setMovilpaciente(pacient.getMovilpaciente());
				_paciente.setTelfijopaciente(pacient.getTelfijopaciente());
				_paciente.setDirpaciente(pacient.getDirpaciente());
				_paciente.setCiudadpaciente(pacient.getCiudadpaciente());
				_paciente.setSedepaciente(pacient.getSedepaciente());
				_paciente.setEmailpaciente(pacient.getEmailpaciente());
				_paciente.setEstadopaciente(pacient.isEstadopaciente());
				_paciente.setRecibircomunicados(pacient.isRecibircomunicados());
								
				return new ResponseEntity<>(pacienteRepository.save(_paciente), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		
		@PutMapping("/pacientes/cedula/{cedula}")
		public ResponseEntity<Paciente> updatePacienteByNumdocpaciente(@PathVariable("cedula") long cedula, @RequestBody Paciente pacient) {
			Paciente aux=pacienteRepository.findByNumdocpaciente(cedula).get(0);
			Optional<Paciente> pacienteData =  Optional.of(aux);

			if (pacienteData.isPresent()) {
				Paciente _paciente = pacienteData.get();
				_paciente.setNumdocpaciente(pacient.getNumdocpaciente());
				_paciente.setPnombrepaciente(pacient.getPnombrepaciente());
				_paciente.setSnombrepaciente(pacient.getSnombrepaciente());
				_paciente.setPapellidopaciente(pacient.getPapellidopaciente());
				_paciente.setSapellidopaciente(pacient.getSapellidopaciente());
				_paciente.setTipodocpaciente(pacient.getTipodocpaciente());
				_paciente.setBirthpaciente(pacient.getBirthpaciente());
				_paciente.setPaispaciente(pacient.getPaispaciente());
				_paciente.setMovilpaciente(pacient.getMovilpaciente());
				_paciente.setTelfijopaciente(pacient.getTelfijopaciente());
				_paciente.setDirpaciente(pacient.getDirpaciente());
				_paciente.setCiudadpaciente(pacient.getCiudadpaciente());
				_paciente.setSedepaciente(pacient.getSedepaciente());
				_paciente.setEmailpaciente(pacient.getEmailpaciente());
				_paciente.setEstadopaciente(pacient.isEstadopaciente());
				_paciente.setRecibircomunicados(pacient.isRecibircomunicados());
				
				return new ResponseEntity<>(pacienteRepository.save(_paciente), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		
		@DeleteMapping("/pacientes/id/{id}")
		public ResponseEntity<HttpStatus> deletePacientesById(@PathVariable("id") String id) {
			try {
				pacienteRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/pacientes/cedula/{cedula}")
		public ResponseEntity<HttpStatus> deletePacientesByNumdocpaciente(@PathVariable("cedula") long cedula) {
			try {
				pacienteRepository.deleteByNumdocpaciente(cedula);
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/pacientes/nombre/{nombre}")
		public ResponseEntity<HttpStatus> deleteClientesByPnombrepaciente(@PathVariable("nombre") String nombre) {
			try {
				pacienteRepository.deleteByPnombrepaciente(nombre);
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/pacientes/email/{email}")
		public ResponseEntity<HttpStatus> deletePacientesByEmail(@PathVariable("email") String email) {
			try {
				pacienteRepository.deleteByEmailpaciente(email);
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/pacientes")
		public ResponseEntity<HttpStatus> deleteAllPacientes() {
			try {
				pacienteRepository.deleteAll();
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/pacientes/{primernompaciente}")
		public ResponseEntity<List<Paciente>> findByNombrecliente(@PathVariable("primernompaciente") String primernompaciente) {
			try {
				List<Paciente> pacientes = pacienteRepository.findByPnombrepaciente(primernompaciente);

				if (pacientes.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(pacientes, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}



}
