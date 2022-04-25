package co.iotechnologies.sgmback.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pacientes")
public class Paciente {
	
	@Id
	String id;
	
	@Indexed(unique=true)
	private long numdocpaciente;
	
	private String pnombrepaciente;
	private String snombrepaciente;
	private String papellidopaciente;
	private String sapellidopaciente;
	private String tipodocpaciente;
	private String birthpaciente;
	private String generopaciente;
	private String paispaciente;
	private long movilpaciente;
	private long telfijopaciente;
	private String dirpaciente;
	private String ciudadpaciente;
	private String sedepaciente;
	private String emailpaciente;
	private boolean estadopaciente;
	private boolean recibircomunicados;
	
	public Paciente() {
		
	}
	
	public Paciente(long numdocpaciente, String pnombrepaciente, String snombrepaciente, String papellidopaciente,
			String sapellidopaciente, String tipodocpaciente, String birthpaciente, String generopaciente,
			String paispaciente, long movilpaciente, long telfijopaciente, String dirpaciente, String ciudadpaciente,
			String sedepaciente, String emailpaciente, boolean estadopaciente, boolean recibircomunicados) {
		super();
		this.numdocpaciente = numdocpaciente;
		this.pnombrepaciente = pnombrepaciente;
		this.snombrepaciente = snombrepaciente;
		this.papellidopaciente = papellidopaciente;
		this.sapellidopaciente = sapellidopaciente;
		this.tipodocpaciente = tipodocpaciente;
		this.birthpaciente = birthpaciente;
		this.generopaciente = generopaciente;
		this.paispaciente = paispaciente;
		this.movilpaciente = movilpaciente;
		this.telfijopaciente = telfijopaciente;
		this.dirpaciente = dirpaciente;
		this.ciudadpaciente = ciudadpaciente;
		this.sedepaciente = sedepaciente;
		this.emailpaciente = emailpaciente;
		this.estadopaciente = estadopaciente;
		this.recibircomunicados = recibircomunicados;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getNumdocpaciente() {
		return numdocpaciente;
	}
	public void setNumdocpaciente(long numdocpaciente) {
		this.numdocpaciente = numdocpaciente;
	}
	public String getPnombrepaciente() {
		return pnombrepaciente;
	}
	public void setPnombrepaciente(String pnombrepaciente) {
		this.pnombrepaciente = pnombrepaciente;
	}
	public String getSnombrepaciente() {
		return snombrepaciente;
	}
	public void setSnombrepaciente(String snombrepaciente) {
		this.snombrepaciente = snombrepaciente;
	}
	public String getPapellidopaciente() {
		return papellidopaciente;
	}
	public void setPapellidopaciente(String papellidopaciente) {
		this.papellidopaciente = papellidopaciente;
	}
	public String getSapellidopaciente() {
		return sapellidopaciente;
	}
	public void setSapellidopaciente(String sapellidopaciente) {
		this.sapellidopaciente = sapellidopaciente;
	}
	public String getTipodocpaciente() {
		return tipodocpaciente;
	}
	public void setTipodocpaciente(String tipodocpaciente) {
		this.tipodocpaciente = tipodocpaciente;
	}
	public String getBirthpaciente() {
		return birthpaciente;
	}
	public void setBirthpaciente(String birthpaciente) {
		this.birthpaciente = birthpaciente;
	}
	public String getGeneropaciente() {
		return generopaciente;
	}
	public void setGeneropaciente(String generopaciente) {
		this.generopaciente = generopaciente;
	}
	public String getPaispaciente() {
		return paispaciente;
	}
	public void setPaispaciente(String paispaciente) {
		this.paispaciente = paispaciente;
	}
	public long getMovilpaciente() {
		return movilpaciente;
	}
	public void setMovilpaciente(long movilpaciente) {
		this.movilpaciente = movilpaciente;
	}
	public long getTelfijopaciente() {
		return telfijopaciente;
	}
	public void setTelfijopaciente(long telfijopaciente) {
		this.telfijopaciente = telfijopaciente;
	}
	public String getDirpaciente() {
		return dirpaciente;
	}
	public void setDirpaciente(String dirpaciente) {
		this.dirpaciente = dirpaciente;
	}
	public String getCiudadpaciente() {
		return ciudadpaciente;
	}
	public void setCiudadpaciente(String ciudadpaciente) {
		this.ciudadpaciente = ciudadpaciente;
	}
	public String getSedepaciente() {
		return sedepaciente;
	}
	public void setSedepaciente(String sedepaciente) {
		this.sedepaciente = sedepaciente;
	}
	public String getEmailpaciente() {
		return emailpaciente;
	}
	public void setEmailpaciente(String emailpaciente) {
		this.emailpaciente = emailpaciente;
	}
	public boolean isEstadopaciente() {
		return estadopaciente;
	}
	public void setEstadopaciente(boolean estadopaciente) {
		this.estadopaciente = estadopaciente;
	}
	public boolean isRecibircomunicados() {
		return recibircomunicados;
	}
	public void setRecibircomunicados(boolean recibircomunicados) {
		this.recibircomunicados = recibircomunicados;
	}
	
	
	
	
	

}
