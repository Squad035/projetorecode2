package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Doador;
import util.Conexao;

public class DoadorController {

	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	public void save(Doador doador) {

		String sql = "INSERT INTO doador(nome,email)" + " VALUES(?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, doador.getNome());
			pstm.setString(2, doador.getEmail());
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

		String sql = "DELETE FROM doador WHERE id_doador = ?";

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

	
	public void update(Doador doador) {

		String sql = "UPDATE doador SET nome = ?, email= ?" + " WHERE id_doador = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, doador.getNome());
			pstm.setString(2, doador.getEmail());
			pstm.setInt(3, doador.getId_doador());
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

	
	public List<Doador> getDoador() {

		String sql = "SELECT * FROM doador";

		List<Doador> doador = new ArrayList<>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Doador d = new Doador();

				d.setId_doador(0);
				d.setNome(rset.getString("nome"));
				d.setEmail(rset.getString("email"));
				doador.add(d);
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

		return doador;

	}

	public Doador getClienteId(int id) {
		String sql = "SELECT * FROM doador where id_doador = ?";
		Doador doador = new Doador();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			doador.setNome(rset.getString("nome"));
			doador.setEmail(rset.getString("email"));

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
		return doador;
	}

}
