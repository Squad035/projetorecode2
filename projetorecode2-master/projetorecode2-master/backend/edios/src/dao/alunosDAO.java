package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Alunos;
public class alunosDAO {

	public void save(Alunos aluno) {
		String sql = "INSERT INTO aluno (nome_aluno) values (?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, aluno.getNome());
			
			pstm.execute();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public List<Alunos> getAulunos() {
		String sql = "select * from alunos;";

		List<Alunos> alunos = new ArrayList<Alunos>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Alunos luno = new Alunos();

				aluno.setId(rset.getInt("id_aluno"));

				aluno.setNome(rset.getString("nome_aluno"));

				aluno.add(autor);

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

		return alunos;
	}
	
}

public void update(Alunos aluno) {
	String sql = "UPDATE alunos set nome_aluno = ? where id_aluno = ?;";

	try {
		conn = ConnectionMySQL.createConnectionMySQL();

		pstm = conn.prepareStatement(sql);

		pstm.setString(1, aluno.getNome());

		pstm.setInt(2, aluno.getId());

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

public void deleteById(int id) {
	String sql = "DELETE FROM alunos WHERE id_aluno = ?";

	try {
		conn = ConnectionMySQL.createConnectionMySQL();

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

public Alunos getAlunoById(int id) {
	String sql = "SELECT * FROM alunos WHERE id_aluno = ?;";

	Alunos autor = new Alunos();

	ResultSet rset = null;

	try {
		conn = ConnectionMySQL.createConnectionMySQL();

		pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		rset = pstm.executeQuery();

		rset.next();

		autor.setId(rset.getInt("id_aluno"));

		autor.setNome(rset.getString("nome_aluno"));

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

	return aluno;
}
