package br.com.partners.springapppdf.controller;

import br.com.partners.springapppdf.model.Retangulo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/addHello", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("retangulo")Retangulo retangulo,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error2";
        }
        model.addAttribute("x", retangulo.getX());
        model.addAttribute("y", retangulo.getY());
        model.addAttribute("altura", retangulo.getAltura());
        model.addAttribute("largura", retangulo.getLargura());

        return "error";
    }

}
