package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LocalEstoque;
import model.Produto;
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

                localEstoque.setIdProduto(resultadoBusca.getInt("id_produto"));
                localEstoque.setNome(resultadoBusca.getString("nome"));
                localEstoque.setApresentacao(resultadoBusca.getString("apresentacao"));
                localEstoque.setVolume(resultadoBusca.getDouble("volume"));
                localEstoque.setUnidadeMedida(resultadoBusca.getString("unidade_medida"));
                localEstoque.setUtilizacao(resultadoBusca.getString("utilizacao"));
                localEstoque.setIdSubLocalFk(resultadoBusca.getInt("id_sublocal_fk"));

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


}
