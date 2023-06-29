package br.com.projet.onibus.viewcontroller;


import br.com.projet.onibus.proprietario.DadosCadastrarProprietario;
import br.com.projet.onibus.proprietario.IProprietarioRepository;
import br.com.projet.onibus.proprietario.Proprietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/viewproprietarios")
public class VProprietario {


    @Autowired
    private IProprietarioRepository iProprietarioRepository;

    @GetMapping
    public String getAllProprietarios(@RequestBody  Model model){
        model.addAttribute("lista", iProprietarioRepository.findAll());
        return "/viewproprietarios/listagem";
    }

    @PostMapping
    public String insertProprietario(@RequestBody DadosCadastrarProprietario dados){
        var proprietario = new Proprietario(dados);
        iProprietarioRepository.save(proprietario);
        return "redirect:/viewproprietarios";
    }
}
