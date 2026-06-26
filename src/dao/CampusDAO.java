package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Campus;
import util.ConnectionFactory;

public class CampusDAO {
    //MÉTODO PARA SALVAR UM OBJETO CAMPUS NO BANCO DE DADOS
    public void salvar(Campus campus) {
        
        String sqlInsert = "INSERT INTO campus (nome) VALUES (?)";

        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlInsert);
            
            // relacionando a ? com os tipos de dados da classe Campus
            stmt.setString(1, campus.getNome());

            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
            System.out.println("Campus salvo no banco de dados com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar Campus: " + e.getMessage());
        }
    }

    public List<Campus> listarTodos(){
        List<Campus> listaCampus = new ArrayList<>();

        String sqlSelect = "SELECT * FROM campus";
        
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlSelect);

            ResultSet resultadoBusca = stmt.executeQuery();

            while (resultadoBusca.next() == true) {
                Campus campus = new Campus();

                campus.setIdCampus(resultadoBusca.getInt("id_campus"));
                campus.setNome(resultadoBusca.getString("nome"));

                listaCampus.add(campus);
            }
            
            resultadoBusca.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os Campus: " + e.getMessage());
        }
        return listaCampus;
    }

    public void atualizar(Campus campus){
        String sqlAtualizar = "UPDATE campus SET nome = ? WHERE id_campus = ?";
        try {
            Connection conexao = ConnectionFactory.getConnection();//CONEXAO COM O BANCO
            PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar);//BUSCA SQL DE FORMA PROTEGIDA PARA EVITAR SQL INJECTION

            stmt.setString(1, campus.getNome());
            stmt.setInt(2, campus.getIdCampus());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            
            System.out.println("Campus atualizado no banco de dados com sucesso!");
    
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Campus: " + e.getMessage());
        }
    }

    public void excluir(Integer id){
        String sqlExcluir = "DELETE FROM campus WHERE id_campus = ?";

        try {
            Connection conexao = ConnectionFactory.getConnection();//CONEXAO COM O BANCO
            PreparedStatement stmt = conexao.prepareStatement(sqlExcluir);//BUSCA SQL DE FORMA PROTEGIDA PARA EVITAR SQL INJECTION

            stmt.setInt(1, id);//aqui estou dizendo que no lugar da ? estou atribuindo o id passado no cabeçalho da função

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

            System.out.println("Campus deletado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Campus: " + e.getMessage());
            
        }
    }


}
