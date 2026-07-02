package model;

public class Usuario {
    private Integer idUsuario;
    private String nomeCompleto;
    private String login;
    private String senha;
    private String perfil;

    public Usuario(){

    }

    public Usuario(Integer idUsuario, String nomeCompleto, String login, String senha, String perfil) {
        this.idUsuario = idUsuario;
        this.nomeCompleto = nomeCompleto;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }
}