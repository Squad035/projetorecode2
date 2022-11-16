package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import util.Conexao;

public class AlunoController {

	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	public void save(Aluno aluno) {

		String sql = "INSERT INTO aluno(nome, idade, sexo)" + " VALUES(?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, aluno.getNome());
			pstm.setInt(2, aluno.getIdade());
			pstm.setString(3, aluno.getSexo());
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

		String sql = "DELETE FROM aluno WHERE id_aluno = ?";

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

	
	public void update(Aluno aluno) {

		String sql = "UPDATE aluno SET nome = ?, idade = ?, sexo = ?" + " WHERE id_aluno = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, aluno.getNome());
			pstm.setInt(2, aluno.getIdade());
			pstm.setString(3, aluno.getSexo());
			pstm.setInt(2, aluno.getId_aluno());
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

	
	public List<Aluno> getAluno() {

		String sql = "SELECT * FROM aluno";

		List<Aluno> aluno = new ArrayList<>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Aluno a = new Aluno();

				a.setId_aluno(0);
				a.setNome(rset.getString("nome"));
				a.setIdade(rset.getInt("idade"));
				a.setSexo(rset.getString("sexo"));
			    aluno.add(a);	
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

		return aluno;

	}

	public Aluno getAlunoId(int id) {
		String sql = "SELECT * FROM aluno where id_aluno = ?";
		Aluno aluno = new Aluno();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			aluno.setNome(rset.getString("nome"));
			aluno.setIdade(rset.getInt("idade"));
			aluno.setSexo(rset.getString("sexo"));

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
		return aluno;
	}

}
