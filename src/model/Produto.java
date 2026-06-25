package model;

public class Produto {
    private Integer idProduto;
    private String nome;
    private String apresentacao;
    private Double volume;
    private String unidadeMedida;
    private String utilizacao;
    private Integer idSubLocalFk;
    
    
    public Produto() {
    }  
    
    public Produto(Integer idProduto, String nome, String apresentacao, Double volume, String unidadeMedida, String utilizacao, Integer idSubLocalFk) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.apresentacao = apresentacao;
        this.volume = volume;
        this.unidadeMedida = unidadeMedida;
        this.utilizacao = utilizacao;
        this.idSubLocalFk = idSubLocalFk;
    }
    
    public Integer getIdSubLocalFk() {
        return idSubLocalFk;
    }

    public void setIdSubLocalFk(Integer idSubLocalFk) {
        this.idSubLocalFk = idSubLocalFk;
    }

    
    public Integer getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getApresentacao() {
        return apresentacao;
    }
    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }
    public Double getVolume() {
        return volume;
    }
    public void setVolume(Double volume) {
        this.volume = volume;
    }
    public String getUnidadeMedida() {
        return unidadeMedida;
    }
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    public String getUtilizacao() {
        return utilizacao;
    }
    public void setUtilizacao(String utilizacao) {
        this.utilizacao = utilizacao;
    }
}
