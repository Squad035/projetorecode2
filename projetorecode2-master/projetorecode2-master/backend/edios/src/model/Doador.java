package model;

import java.util.Objects;

public class Doador {

	private int id_doador;
	private String nome;
	private String email;
	
	
	public int getId_doador() {
		return id_doador;
	}
	public void setId_doador(int id_doador) {
		this.id_doador = id_doador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Doador [id_doador=" + id_doador + ", nome=" + nome + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id_doador, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doador other = (Doador) obj;
		return Objects.equals(email, other.email) && id_doador == other.id_doador && Objects.equals(nome, other.nome);
	}
	
}
