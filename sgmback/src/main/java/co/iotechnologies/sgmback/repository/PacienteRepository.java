package co.iotechnologies.sgmback.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.iotechnologies.sgmback.model.Paciente;

public interface PacienteRepository extends MongoRepository <Paciente, String> {
	
	List<Paciente> findByNumdocpaciente(Long numdocpaciente);
	List<Paciente> findByEmailpaciente(String emailpaciente);
	List<Paciente> findByPnombrepaciente(String pnombrepaciente);
	void deleteByNumdocpaciente(Long numdocpaciente);
	void deleteByEmailpaciente(String emailpaciente);
	void deleteByPnombrepaciente(String pnombrepaciente);
	
	

}
