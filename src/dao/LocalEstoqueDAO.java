package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LocalEstoque;
import util.ConnectionFactory;

public class LocalEstoqueDAO {
    public void cadastrarLocal(LocalEstoque local){
        String sqlInsert = "INSERT INTO local_estoque (nome_local, tipo, id_campus) VALUES (?, ?, ?)";

        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

            stmt.setString(1, local.getNomeLocal());
            stmt.setString(2, local.getTipo());
            stmt.setInt(3, local.getId_campus());

            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
            System.out.println("Local salvo no banco de dados com sucesso!");


        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o local: " + e.getMessage());
        }
    }

    public List<LocalEstoque> listarTodos(){
        List<LocalEstoque> listaLocais = new ArrayList<>();

        String sqlSelect = "SELECT * FROM local_estoque";
        
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

            ResultSet resultadoBusca = stmt.executeQuery();

            while (resultadoBusca.next() == true) {
                LocalEstoque localEstoque = new LocalEstoque();

                localEstoque.setIdEstoque(resultadoBusca.getInt("id_estoque"));
                localEstoque.setNomeLocal(resultadoBusca.getString("nome_local"));
                localEstoque.setTipo(resultadoBusca.getString("tipo"));
                localEstoque.setId_campus(resultadoBusca.getInt("id_campus"));

                listaLocais.add(localEstoque);

            }
            
            resultadoBusca.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar locais: " + e.getMessage());
        }
        return listaLocais;
    }

        public void atualizar(LocalEstoque localEstoque){
        String sqlAtualizar = "UPDATE local_estoque SET nome_local= ?, tipo= ? WHERE id_estoque= ?";
        try {
            Connection conexao = ConnectionFactory.getConnection();//CONEXAO COM O BANCO
            PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar);//BUSCA SQL DE FORMA PROTEGIDA PARA EVITAR SQL INJECTION

            stmt.setString(1, localEstoque.getNomeLocal());
            stmt.setString(2, localEstoque.getTipo());
            stmt.setInt(3, localEstoque.getIdEstoque());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            
            System.out.println("Local atualizado no banco de dados com sucesso!");
    
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Local: " + e.getMessage());
        }
    }

    public void excluir(Integer id){
        String sqlExcluir = "DELETE FROM local_estoque WHERE id_estoque = ?";

        try {
            Connection conexao = ConnectionFactory.getConnection();//CONEXAO COM O BANCO
            PreparedStatement stmt = conexao.prepareStatement(sqlExcluir);//BUSCA SQL DE FORMA PROTEGIDA PARA EVITAR SQL INJECTION

            stmt.setInt(1, id);//aqui estou dizendo que no lugar da ? estou atribuindo o id passado no cabeçalho da função

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

            System.out.println("Local deletado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Local: " + e.getMessage());
            
        }
    }


}
