package br.senai.sc.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Time horario_inicio_aula;
	private Time horario_final_aula;
	private Date dia_aula;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Time getHorario_inicio_aula() {
		return horario_inicio_aula;
	}
	public void setHorario_inicio_aula(Time horario_inicio_aula) {
		this.horario_inicio_aula = horario_inicio_aula;
	}
	public Time getHorario_final_aula() {
		return horario_final_aula;
	}
	public void setHorario_final_aula(Time horario_final_aula) {
		this.horario_final_aula = horario_final_aula;
	}
	public Date getDia_aula() {
		return dia_aula;
	}
	public void setDia_aula(Date dia_aula) {
		this.dia_aula = dia_aula;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dia_aula == null) ? 0 : dia_aula.hashCode());
		result = prime
				* result
				+ ((horario_final_aula == null) ? 0 : horario_final_aula
						.hashCode());
		result = prime
				* result
				+ ((horario_inicio_aula == null) ? 0 : horario_inicio_aula
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (dia_aula == null) {
			if (other.dia_aula != null)
				return false;
		} else if (!dia_aula.equals(other.dia_aula))
			return false;
		if (horario_final_aula == null) {
			if (other.horario_final_aula != null)
				return false;
		} else if (!horario_final_aula.equals(other.horario_final_aula))
			return false;
		if (horario_inicio_aula == null) {
			if (other.horario_inicio_aula != null)
				return false;
		} else if (!horario_inicio_aula.equals(other.horario_inicio_aula))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
