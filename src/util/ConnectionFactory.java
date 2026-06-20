package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

public class ConnectionFactory {

    protected static String url = "jdbc:postgresql://10.20.2.64:5432/EstoqueUniFacear";
    protected static String usuario = "estoque";
    protected static String senha = "Unifacear@2026";

    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        }
        catch (SQLException e) {
            throw new RuntimeException("A conexão falhou: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        getConnection();
        List<Produto> listaProdutos = new ArrayList<>();
        
        ProdutoDAO dao = new ProdutoDAO();
        Produto prod = new Produto(10, "CELULAR", "Lacrado na caixa", 5.5, "KG", "Uso corporativo");

        dao.salvar(prod);
        listaProdutos.add(prod);
        listaProdutos=(dao.listarTodos());

        for (Produto i : listaProdutos) {
            System.out.println("Nome: "+i.getNome()+"| Uso: "+ i.getUtilizacao());
        }

    }

}
