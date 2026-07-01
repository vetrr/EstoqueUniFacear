package model;

import java.util.Date;

public class ItemEstoque {
    private Integer idProdutoFK;
    private Integer idEstoqueFK;
    private Integer quantidadeAtual;
    private Integer quantidadeMinimaAlerta;
    private Date dataValidade;
    
    public ItemEstoque() {
    }

    public ItemEstoque(Integer idProdutoFK, Integer idEstoqueFK, Integer quantidadeAtual, Integer quantidadeMinimaAlerta, Date dataValidade) {
        this.idProdutoFK = idProdutoFK;
        this.idEstoqueFK = idEstoqueFK;
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMinimaAlerta = quantidadeMinimaAlerta;
        this.dataValidade = dataValidade;
    }

    public Integer getIdProdutoFK() {
        return idProdutoFK;
    }
    public void setIdProdutoFK(Integer idProdutoFK) {
        this.idProdutoFK = idProdutoFK;
    }
    public Integer getIdEstoqueFK() {
        return idEstoqueFK;
    }
    public void setIdEstoqueFK(Integer idEstoqueFK) {
        this.idEstoqueFK = idEstoqueFK;
    }
    public Integer getQuantidadeAtual() {
        return quantidadeAtual;
    }
    public void setQuantidadeAtual(Integer quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }
    public Integer getQuantidadeMinimaAlerta() {
        return quantidadeMinimaAlerta;
    }
    public void setQuantidadeMinimaAlerta(Integer quantidadeMinimaAlerta) {
        this.quantidadeMinimaAlerta = quantidadeMinimaAlerta;
    }
    public Date getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
}
