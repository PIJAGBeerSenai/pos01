package br.senai.sc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pre_Requisito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uc_id;

	public Integer getUc_id() {
		return uc_id;
	}

	public void setUc_id(Integer uc_id) {
		this.uc_id = uc_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uc_id == null) ? 0 : uc_id.hashCode());
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
		Pre_Requisito other = (Pre_Requisito) obj;
		if (uc_id == null) {
			if (other.uc_id != null)
				return false;
		} else if (!uc_id.equals(other.uc_id))
			return false;
		return true;
	}
	
	

}
