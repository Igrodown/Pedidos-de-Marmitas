package application.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.models.Marmita;
import application.respositories.MarmitaRepository;

@Controller
@RequestMapping("/Marmita")
public class MarmitaController {
    @Autowired
    private MarmitaRepository MarmitasRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("Marmita", MarmitasRepo.findAll());
        return "list.jsp"; 
    }

    @RequestMapping("/insert")
    public String formInsert() {
        return "insert.jsp";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("Tamanho") String Tamanho) {
        Marmita Marmita = new Marmita();
        Marmita.setTamanho(Tamanho);

        MarmitasRepo.save(Marmita);

        return "redirect:/livro/list";
    }

    @RequestMapping("/update/{id}")
    public String formUpdate(Model model, @PathVariable int id) {
        Optional<Marmita> Marmita = MarmitasRepo.findById(id);
        if(!Marmita.isPresent())
            return "redirect:/Marmita/list";
        model.addAttribute("Marmita", Marmita.get());
        return "/Marmita/update.jsp";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveUpdate(@RequestParam("titulo") String Tamanho, @RequestParam("id") int id) {
        Optional<Marmita> Marmita = MarmitasRepo.findById(id);
        if(!Marmita.isPresent())
            return "redirect:/Marmita/list";
        Marmita.get().setTamanho(Tamanho);

        MarmitasRepo.save(Marmita.get());

        return "redirect:/Marmita/list";
    }

    @RequestMapping("/delete/{id}")
    public String formDelete(Model model, @PathVariable int id) {
        Optional<Marmita> livro = MarmitasRepo.findById(id);
        if(!livro.isPresent())
            return "redirect:/Mamita/list";
        model.addAttribute("Mamita", Marmita.get());
        return "/Mamita/delete.jsp";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String confirmDelete(@RequestParam("id") int id) {
        MarmitasRepo.deleteById(id);
        return "redirect:/Mamita/list";
    }
}