package dao;

import model.Produto;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    public void salvar(Produto obj) {
        
        String sqlInsert = "INSERT INTO produto (nome, apresentacao, volume, unidade_medida, utilizacao) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conexao = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);
            
            // relacionando a ? com os tipos de dados da classe Produto
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getApresentacao());
            stmt.setDouble(3, obj.getVolume());
            stmt.setString(4, obj.getUnidadeMedida());
            stmt.setString(5, obj.getUtilizacao());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
            System.out.println("Produto salvo no banco de dados com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o produto: " + e.getMessage());
        }
    }
}