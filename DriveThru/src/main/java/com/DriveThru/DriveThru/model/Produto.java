package com.DriveThru.DriveThru.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;
    @NotNull(message = "O campo nome não pode ser nulo.")
    @Column(nullable = false)
    private String nomeProduto;
    @NotNull(message = "O campo preço não pode ser nulo ")
    @Column(nullable = false)
    private float precoProduto;

    public Produto() {
    }

    public Produto(long idProduto, String nomeProduto, float precoProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }
}
