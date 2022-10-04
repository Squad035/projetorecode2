package model;

import java.util.Objects;

public class Escola {

	private int id_escola;
	private String nomeEscola;
	
	
	public int getId_escola() {
		return id_escola;
	}
	public void setId_escola(int id_escola) {
		this.id_escola = id_escola;
	}
	public String getNomeEscola() {
		return nomeEscola;
	}
	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}
	
	@Override
	public String toString() {
		return "Escola [id_escola=" + id_escola + ", nomeEscola=" + nomeEscola + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_escola, nomeEscola);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Escola other = (Escola) obj;
		return id_escola == other.id_escola && Objects.equals(nomeEscola, other.nomeEscola);
	}
	
}
