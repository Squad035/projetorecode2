package model;

import java.util.Objects;

public class Aluno {

	private int id_aluno;
	private String nome;
	private String sexo;
	private int idade;
	
	
	public int getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	@Override
	public String toString() {
		return "Aluno [id_aluno=" + id_aluno + ", nome=" + nome + ", sexo=" + sexo + ", idade=" + idade + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id_aluno, idade, nome, sexo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return id_aluno == other.id_aluno && idade == other.idade && Objects.equals(nome, other.nome)
				&& Objects.equals(sexo, other.sexo);
	}
	
}
