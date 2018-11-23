package br.com.partners.springapppdf.model;

import java.io.File;
import java.util.ArrayList;

public class ArquivoPDF {

    private File arquivoPDF;
    private ArrayList<Retangulo> retangulos;

    public ArquivoPDF(File arquivoPDF, ArrayList<Retangulo> retangulos) {
        this.arquivoPDF = arquivoPDF;
        this.retangulos = retangulos;
    }

    public File getArquivoPDF() {
        return arquivoPDF;
    }

    public void setArquivoPDF(File arquivoPDF) {
        this.arquivoPDF = arquivoPDF;
    }

    public ArrayList<Retangulo> getRetangulos() {
        return retangulos;
    }

    public void setRetangulos(ArrayList<Retangulo> retangulos) {
        this.retangulos = retangulos;
    }
}
