package br.com.partners.springapppdf.model;

import javax.validation.constraints.NotNull;

public class Retangulo {

    @NotNull
    private String nome;
    @NotNull
    private Integer x;
    @NotNull
    private Integer y;
    @NotNull
    private Integer altura;
    @NotNull
    private Integer largura;

    public Retangulo(@NotNull String nome, @NotNull Integer x, @NotNull Integer y, @NotNull Integer altura, @NotNull Integer largura) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.altura = altura;
        this.largura = largura;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
