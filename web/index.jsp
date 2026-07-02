<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Estoque</title>
    <style>
        body { 
            font-family: 'Courier New', Courier, monospace; 
            background-color: #e5e5df; 
            color: #222; 
            padding: 40px; 
        }
        .painel { 
            border: 2px solid #222; 
            padding: 20px; 
            background-color: #f4f4f0;
            display: inline-block; 
            box-shadow: 4px 4px 0px #222;
        }
    </style>
</head>
<body>
    <div class="painel">
        <h2>SISTEMA DE ESTOQUE</h2>
        <hr style="border: 1px dashed #222;">
        <p>> USUÁRIO: <strong>${usuarioAutenticado.nomeCompleto}</strong></p>
        <p>> PERFIL.: [ ${usuarioAutenticado.perfil} ]</p>

        <br>
        <a href="LogOutController">Sair do Sistema</a>
    </div>

    <div class="painel">
    <h2>SISTEMA DE ESTOQUE</h2>
    <%
        // 1. Você precisa resgatar o usuário da sessão para o Java conseguir ler
        Usuario logado = (Usuario) session.getAttribute("usuarioAutenticado");
        
        // 2. Você faz a pergunta (o IF)
        SE (logado != nulo E o perfil do logado for "Administrador") {
    %>
    <br>
    <h3>Menu do Administrador</h3>
    <a href="ListarCampiController">> OP: GERENCIAR CAMPI</a> <br>
    <a href="ListarUsuariosController">> OP: GERENCIAR USUÁRIOS</a> <br>
    <a href="ListarEstoqueController">> OP: ACESSAR ESTOQUE</a> <br>

    <%
        } // fim do if do Administrador
    %>
    </div>

</body>
</html>