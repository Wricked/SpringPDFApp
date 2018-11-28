package br.com.partners.springapppdf.controller;

import br.com.partners.springapppdf.model.ArquivoPDF;
import br.com.partners.springapppdf.model.Retangulo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Controller
public class UploadController {

    private ArquivoPDF arquivoPDF;

    private String nomeCliente;

    @GetMapping
    public String index() {
        return "upload";
     }

    @PostMapping("upload") //new annotation since 4.3
    public String singleFileUpload(@RequestParam("nomeCliente") String nomeCliente,
                                   @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/uploadStatus";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            //Save the uploaded file to this folder
            Path path = Paths.get("C://temp//" + file.getOriginalFilename());
            Files.write(path, bytes);

            this.nomeCliente = nomeCliente;
            this.arquivoPDF = new ArquivoPDF(path.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/dimensions";
    }

    @GetMapping("dimensions")
    public String redirection(Model model) {
        model.addAttribute("nomeCliente", nomeCliente);
        model.addAttribute("arquivoPDF", arquivoPDF);
        return "dimensions";
    }

    @PostMapping("dimensions")
    public String submit(@RequestParam("nomeRegiao") String nomeRegiao,
                         @RequestParam("x") Integer x,
                         @RequestParam("y") Integer y,
                         @RequestParam("altura") Integer altura,
                         @RequestParam("largura") Integer largura,

                         RedirectAttributes redirectAttributes){

            Retangulo retangulo = new Retangulo(nomeRegiao, x, y, altura, largura);
            if (this.arquivoPDF != null) {
                this.arquivoPDF.setRetangulos(new ArrayList<>());
                this.arquivoPDF.getRetangulos().add(retangulo);

                redirectAttributes.addFlashAttribute("message", "File upload successful!");
            } else {
                redirectAttributes.addFlashAttribute("message", "File not available!");
            }
            return "redirect:/uploadStatus";
    }

    @GetMapping("uploadStatus")
    public ModelAndView uploadStatus(Model model) {
        model.addAttribute("nomeCliente", nomeCliente);
        model.addAttribute("arquivoPDF", arquivoPDF);
        model.addAttribute("message", arquivoPDF.getArquivoPDF().getName() + " uploaded!\n");

        return new ModelAndView("uploadStatus");
}
/*
    @GetMapping("dimensions")
    public String dimensions() {
        return "dimensions";
    }
*/
}
