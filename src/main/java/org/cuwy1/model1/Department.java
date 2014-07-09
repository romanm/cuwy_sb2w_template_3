package org.cuwy1.model1;

import java.util.List;

public class Department {
	private String name;
	private List<PatientsDiagnosis> patientsDiagnoses;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PatientsDiagnosis> getPatientsDiagnoses() {
		return patientsDiagnoses;
	}
	public void setPatientsDiagnoses(List<PatientsDiagnosis> patientesDiagnoses) {
		this.patientsDiagnoses = patientesDiagnoses;
	}
}
