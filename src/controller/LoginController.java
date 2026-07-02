package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
        // 1. RECEBIMENTO: Captura o que veio do formulário HTML
        String login = request.getParameter("campoUsuario");
        String senha = request.getParameter("campoSenha");

        // 2. VALIDAÇÃO: Chama o DAO que você acabou de construir
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioLogado = dao.autenticar(login, senha);

        // 3. DECISÃO: Se o DAO achou o usuário (não é nulo)
        if (usuarioLogado != null) {
            // Cria a SESSÃO (A memória do servidor)
            HttpSession session = request.getSession();
            
            // "Pendura" o objeto do usuário na sessão para ele ser lembrado nas outras páginas
            session.setAttribute("usuarioAutenticado", usuarioLogado);
            
            // Redireciona para o sistema
            response.sendRedirect("index.html");
            
        } else {
            // Se o usuário não existe ou senha errada, manda de volta para o login
            response.sendRedirect("login.html?erro=falha");
        }
    }
}