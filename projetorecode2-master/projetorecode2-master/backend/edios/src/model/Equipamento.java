package model;

import java.util.Objects;

public class Equipamento {

	private int id_equipamento;
	private String descricao;
	
	public int getId_equipamento() {
		return id_equipamento;
	}
	public void setId_equipamento(int id_equipamento) {
		this.id_equipamento = id_equipamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Equipamento [id_equipamento=" + id_equipamento + ", descricao=" + descricao + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(descricao, id_equipamento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipamento other = (Equipamento) obj;
		return Objects.equals(descricao, other.descricao) && id_equipamento == other.id_equipamento;
	}
	
	
}
