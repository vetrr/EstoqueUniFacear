package dao;

import model.Produto;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ProdutoDAO {

    //MÉTODO PARA SALVAR UM OBJETO PRODUTO NO BANCO DE DADOS
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

    //MÉTODO PARA LISTAR OS PRODUTOS DA TABELA produto
    public List<Produto> listarTodos(){
        List<Produto> listaProdutos = new ArrayList<>();

        String sqlSelect = "SELECT * FROM produto";
        
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

            ResultSet resultadoBusca = stmt.executeQuery();

            while (resultadoBusca.next() == true) {
                Produto produto = new Produto();

                produto.setIdProduto(resultadoBusca.getInt("id_produto"));
                produto.setNome(resultadoBusca.getString("nome"));
                produto.setApresentacao(resultadoBusca.getString("apresentacao"));
                produto.setVolume(resultadoBusca.getDouble("volume"));
                produto.setUnidadeMedida(resultadoBusca.getString("unidade_medida"));
                produto.setUtilizacao(resultadoBusca.getString("utilizacao"));

                listaProdutos.add(produto);

            }
            
            resultadoBusca.close();
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar os produtos: " + e.getMessage());
        }
        return listaProdutos;
    }

    public Produto buscarPorId(Integer id){
        Produto produtoEncontrado = null;

        String sqlBucarId = "SELECT * FROM produto WHERE id_produto = ?";

        try {
            
        Connection conexao = ConnectionFactory.getConnection();//CONEXAO COM O BANCO

        PreparedStatement stmt = conexao.prepareStatement(sqlBucarId);//BUSCA SQL DE FORMA PROTEGIDA PARA EVITAR SQL INJECTION
        stmt.setInt(1, id);

        ResultSet resultadoBusca = stmt.executeQuery();//DEVOLVE UM OBJETO COM A BUSCA SQL

        
        if (resultadoBusca.next() == true) {
            Produto produto = new Produto();
            
            produto.setIdProduto(resultadoBusca.getInt("id_produto"));//Fui na coluna idProduto e fiz o objeto produto ter o mesmo idProduto da colna
            produto.setNome(resultadoBusca.getString("nome"));
            produto.setApresentacao(resultadoBusca.getString("apresentacao"));
            produto.setVolume(resultadoBusca.getDouble("volume"));
            produto.setUnidadeMedida(resultadoBusca.getString("unidade_medida"));
            produto.setUtilizacao(resultadoBusca.getString("utilizacao"));
            
            produtoEncontrado = produto;
            
        }
                
        resultadoBusca.close();
        stmt.close();
        conexao.close();
        
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao listar os produtos: " + e.getMessage());

    }
        return produtoEncontrado;
    
    }

}