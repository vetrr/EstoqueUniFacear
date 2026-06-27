package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ItemEstoque;
import model.Produto;
import util.ConnectionFactory;

public class ItemEstoqueDAO {

    public void salvar(ItemEstoque item) {
        
        String sqlInsert = "INSERT INTO item_estoque (id_produto, id_estoque, quantidade_atual, quantidade_minima_alerta, data_validade) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);
            
            // relacionando a ? com os tipos de dados da classe ItemEstoque
            stmt.setInt(1, item.getIdProdutoFK());
            stmt.setInt(2, item.getIdEstoqueFK());
            stmt.setInt(3, item.getQuantidadeAtual());
            stmt.setInt(4, item.getQuantidadeMinimaAlerta());
            stmt.setDate(5, new java.sql.Date(item.getDataValidade().getTime()));//instancia uma nova data no momento que a linha rodar
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
            System.out.println("Item Estoque salvo no banco de dados com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar Item Estoque: " + e.getMessage());
        }
    }

public void atualizar(ItemEstoque item){
        String sqlAtualizar = "UPDATE item_estoque SET quantidade_atual = ?, quantidade_minima_alerta = ?, data_validade = ? WHERE id_produto = ? AND id_estoque = ?";
        
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar);

            stmt.setInt(1, item.getQuantidadeAtual());
            stmt.setInt(2, item.getQuantidadeMinimaAlerta());
            stmt.setDate(3, new java.sql.Date(item.getDataValidade().getTime()));
            stmt.setInt(4, item.getIdProdutoFK());
            stmt.setInt(5, item.getIdEstoqueFK());

            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
            System.out.println("Quantidade do Item atualizada no estoque com sucesso!");
    
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Item Estoque: " + e.getMessage());
        }
    }

}
