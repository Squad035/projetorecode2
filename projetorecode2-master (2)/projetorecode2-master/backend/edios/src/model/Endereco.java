package model;

import java.util.Objects;

public class Endereco {

	private int id_endereco;
	private String bairro;
	private String rua;
	private int numero;
	private String cidade;
	private String estado;
	
	
	public int getId_endereco() {
		return id_endereco;
	}
	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Endereco [id_endereco=" + id_endereco + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cidade, estado, id_endereco, numero, rua);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(estado, other.estado) && id_endereco == other.id_endereco && numero == other.numero
				&& Objects.equals(rua, other.rua);
	}
	
}
