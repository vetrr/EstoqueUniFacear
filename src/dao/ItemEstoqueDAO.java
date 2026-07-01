package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItemEstoque;
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

public List<ItemEstoque> listarTodos(){
        List<ItemEstoque> listaEstoque = new ArrayList<>();

        String sqlSelect = "SELECT * FROM item_estoque";
        
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

            ResultSet resultadoBusca = stmt.executeQuery();

            while (resultadoBusca.next() == true) {
                ItemEstoque itemEstoque = new ItemEstoque();

                itemEstoque.setIdProdutoFK(resultadoBusca.getInt("id_produto"));
                itemEstoque.setIdEstoqueFK(resultadoBusca.getInt("id_estoque"));
                itemEstoque.setQuantidadeAtual(resultadoBusca.getInt("quantidade_atual"));
                itemEstoque.setQuantidadeMinimaAlerta(resultadoBusca.getInt("quantidade_minima_alerta"));
                itemEstoque.setDataValidade(resultadoBusca.getDate("data_validade"));

                listaEstoque.add(itemEstoque);

            }
            
            resultadoBusca.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os Itens do Estoque: " + e.getMessage());
        }
        return listaEstoque;
    }

public void excluir(Integer idProduto, Integer idEstoque){
    String sqlExcluir = "DELETE FROM item_estoque WHERE id_produto = ? AND id_estoque = ?";

        try {
            Connection conexao = ConnectionFactory.getConnection();//CONEXAO COM O BANCO
            PreparedStatement stmt = conexao.prepareStatement(sqlExcluir);//BUSCA SQL DE FORMA PROTEGIDA PARA EVITAR SQL INJECTION

            stmt.setInt(1, idProduto);//aqui estou dizendo que no lugar da ? estou atribuindo o id passado no cabeçalho da função
            stmt.setInt(2, idEstoque);

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

            System.out.println("Item deletado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Item: " + e.getMessage());
            
        }

}

}
