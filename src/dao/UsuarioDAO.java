package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;
import util.ConnectionFactory;


public class UsuarioDAO {

public Usuario autenticar(String login, String senha) {
    String sqlSelect = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
    
    try (Connection conexao = ConnectionFactory.getConnection();
         PreparedStatement stmt = conexao.prepareStatement(sqlSelect)) {
        
        stmt.setString(1, login);
        stmt.setString(2, senha);
        ResultSet resultadoBusca = stmt.executeQuery();

        if (resultadoBusca.next()) {
            Usuario usuario = new Usuario();

            usuario.setIdUsuario(resultadoBusca.getInt("id_usuario"));
            usuario.setNomeCompleto(resultadoBusca.getString("nome_completo"));
            usuario.setLogin(resultadoBusca.getString("login"));
            usuario.setPerfil(resultadoBusca.getString("perfil"));
            return usuario;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }

public void salvar(Usuario usuario) {
    String sql = "INSERT INTO usuario (nome_completo, login, senha, perfil) VALUES (?, ?, ?, ?)";
    
    try (Connection conexao = ConnectionFactory.getConnection();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {
        
        stmt.setString(1, usuario.getNomeCompleto());
        stmt.setString(2, usuario.getLogin());
        stmt.setString(3, usuario.getSenha());
        stmt.setString(4, usuario.getPerfil());
        
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public Usuario buscarPorId(Integer id) {
    String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
    
    try (Connection conexao = ConnectionFactory.getConnection();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            Usuario u = new Usuario();
            u.setIdUsuario(rs.getInt("id_usuario"));
            u.setNomeCompleto(rs.getString("nome_completo"));
            u.setLogin(rs.getString("login"));
            u.setPerfil(rs.getString("perfil"));
            return u;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

public void deletar(Integer id) {
    String sql = "DELETE FROM usuario WHERE id_usuario = ?";
    
    try (Connection conexao = ConnectionFactory.getConnection();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



}
