package br.com.partners.springapppdf.controller;

import br.com.partners.springapppdf.model.ArquivoPDF;
import br.com.partners.springapppdf.model.Retangulo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class RetanguloController {

    @RequestMapping(value = "/page2", method = RequestMethod.POST)
    public String uploadFile(@Valid @ModelAttribute("arquivoPDF") ArquivoPDF arquivoPDF, ModelMap model) {
        model.addAttribute("nomePDF", arquivoPDF.getArquivoPDF());

        return "page2";
    }

    @RequestMapping(value = "/page1", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("retangulo") ArquivoPDF arquivoPDF, ModelMap model) {
        arquivoPDF.setRetangulos(new ArrayList<>());
        Retangulo retangulo = new Retangulo();
        arquivoPDF.getRetangulos().add(retangulo);

        model.addAttribute("nome", arquivoPDF.getRetangulos().get(0).getNome());
        model.addAttribute("x", arquivoPDF.getRetangulos().get(0).getX());
        model.addAttribute("y", arquivoPDF.getRetangulos().get(0).getY());
        model.addAttribute("altura", arquivoPDF.getRetangulos().get(0).getAltura());
        model.addAttribute("largura", arquivoPDF.getRetangulos().get(0).getLargura());

        return "page1";
    }
}
