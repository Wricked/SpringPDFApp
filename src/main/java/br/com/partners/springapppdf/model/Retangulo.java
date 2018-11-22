package br.com.partners.springapppdf.model;

import javax.validation.constraints.NotNull;

public class Retangulo {

    @NotNull
    private Integer x;
    @NotNull
    private Integer y;
    @NotNull
    private Integer altura;
    @NotNull
    private Integer largura;

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
}
