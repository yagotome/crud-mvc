package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Pessoa;

public class PessoaDAO {
	private Connection connection;
	
	public PessoaDAO(Connection connection) {
		this.connection = connection;		
	}
	
	public void insere(Pessoa pessoa) {
		String sql = "INSERT INTO pessoa(nome, email, data_nascimento, sexo) VALUES (?,?,?,?)";
		try (PreparedStatement st = connection.prepareStatement(sql)) {
			st.setString(1, pessoa.getNome());
			st.setString(2, pessoa.getEmail());
			long dateInMillis = pessoa.getDataNascimento().getTimeInMillis();
			st.setDate(3, new Date(dateInMillis));
			st.setString(4, pessoa.getSexo());
			st.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro de inserção.");
		}		
	}
	
	public void atualiza(Pessoa pessoa) {
		String sql = "UPDATE pessoa"
				+ " SET nome=?, email=?, data_nascimento=?, sexo=?"
				+ " WHERE id=?";
		try (PreparedStatement st = connection.prepareStatement(sql)) {
			st.setString(1, pessoa.getNome());
			st.setString(2, pessoa.getEmail());
			long dateInMillis = pessoa.getDataNascimento().getTimeInMillis();
			st.setDate(3, new Date(dateInMillis));
			st.setString(4, pessoa.getSexo());
			st.setInt(5, pessoa.getId());			
			st.execute();			
		} catch (SQLException e) {
			throw new RuntimeException("Erro de update.");
		}		
	}
	
	public void exclui(Pessoa pessoa) {
		String sql = "DELETE FROM pessoa"
				+ " WHERE id=?";
		try (PreparedStatement st = connection.prepareStatement(sql)) {
			st.setInt(1, pessoa.getId());
			st.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro de exclusão.");
		}		
	}
	
	public List<Pessoa> getLista() {
		String sql = "SELECT * FROM pessoa";
		List<Pessoa> pessoas = new ArrayList<>();
		try (PreparedStatement st = connection.prepareStatement(sql);
				ResultSet rs = st.executeQuery()) {
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setEmail(rs.getString("email"));
				p.setSexo(rs.getString("sexo"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_nascimento"));
				p.setDataNascimento(data);
				pessoas.add(p);
			}
		} catch (SQLException e) {			
			throw new RuntimeException("Erro de update.\n" + e.getMessage());
		}
		return pessoas;
	}

}
