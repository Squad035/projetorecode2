package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Equipamento;
import util.Conexao;

public class EquipamentoController {

	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	public void save(Equipamento equipamento) {

		String sql = "INSERT INTO equipamento(descricao)" + " VALUES(?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, equipamento.getDescricao());
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void removeById(int id) {

		String sql = "DELETE FROM equipamento WHERE id_equipamento = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	
	public void update(Equipamento equipamento) {

		String sql = "UPDATE equipamento SET descricao = ?" + " WHERE id_equipamento = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, equipamento.getDescricao());
			pstm.setInt(2, equipamento.getId_equipamento());
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	
	public List<Equipamento> getEquipamento() {

		String sql = "SELECT * FROM equipamento";

		List<Equipamento> equipamento = new ArrayList<>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Equipamento e = new Equipamento();

				e.setId_equipamento(0);
				e.setDescricao(rset.getString("descricao"));
			    equipamento.add(e);	
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return equipamento;

	}

	public Equipamento getEquipamentoId(int id) {
		String sql = "SELECT * FROM equipamento where id_equipamento = ?";
		Equipamento equipamento = new Equipamento();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			equipamento.setDescricao(rset.getString("nome"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return equipamento;
	}

}
