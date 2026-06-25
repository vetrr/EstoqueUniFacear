package model;

public class LocalEstoque {
    private Integer idEstoque;
    private String nomeLocal;
    private String tipo;
    private Integer id_campus;
    
    public LocalEstoque() {
    }
    
    public LocalEstoque(Integer idEstoque, String nomeLocal, String tipo, Integer id_campus) {
        this.idEstoque = idEstoque;
        this.nomeLocal = nomeLocal;
        this.tipo = tipo;
        this.id_campus = id_campus;
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }
    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }
    public String getNomeLocal() {
        return nomeLocal;
    }
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Integer getId_campus() {
        return id_campus;
    }
    public void setId_campus(Integer id_campus) {
        this.id_campus = id_campus;
    }
}
