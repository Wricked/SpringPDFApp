package br.com.partners.springapppdf.controller;

import br.com.partners.springapppdf.model.ArquivoPDF;
import br.com.partners.springapppdf.model.Retangulo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Controller
public class UploadController {

    @GetMapping
    public String index() {
        return "upload";
     }

    @PostMapping("upload") //new annotation since 4.3
    public String singleFileUpload(@RequestParam("nomeCliente") String name, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
                                   @Valid @ModelAttribute("retangulo") ArquivoPDF arquivoPDF, HttpSession session) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return null;
        }
        try {
            session.setAttribute("name", name);

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            //Save the uploaded file to this folder
            String UPLOADED_FOLDER = "C://temp//";
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            arquivoPDF.setArquivoPDF(path.toFile());

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:dimensions";
    }

    @PostMapping("/dimensions")
    public String submit(@Valid @ModelAttribute("retangulo") ArquivoPDF arquivoPDF, ModelMap model) {
        arquivoPDF.setRetangulos(new ArrayList<>());
        Retangulo retangulo = new Retangulo();
        arquivoPDF.getRetangulos().add(retangulo);

        model.addAttribute("nome", arquivoPDF.getRetangulos().get(0).getNome());
        model.addAttribute("x", arquivoPDF.getRetangulos().get(0).getX());
        model.addAttribute("y", arquivoPDF.getRetangulos().get(0).getY());
        model.addAttribute("altura", arquivoPDF.getRetangulos().get(0).getAltura());
        model.addAttribute("largura", arquivoPDF.getRetangulos().get(0).getLargura());

        return "uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    @GetMapping("/dimensions")
    public String dimensions() {
        return "dimensions";
    }

}
