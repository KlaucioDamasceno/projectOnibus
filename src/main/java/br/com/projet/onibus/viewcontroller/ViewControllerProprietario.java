package br.com.projet.onibus.viewcontroller;


import br.com.projet.onibus.proprietario.DadosAtualizaProprietario;
import br.com.projet.onibus.proprietario.DadosCadastrarProprietario;
import br.com.projet.onibus.proprietario.IProprietarioRepository;
import br.com.projet.onibus.proprietario.Proprietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/viewproprietarios")
public class ViewControllerProprietario {


    @Autowired
    private IProprietarioRepository iProprietarioRepository;

    @GetMapping
    public String getAllProprietarios(Model model){
        model.addAttribute("lista", iProprietarioRepository.findAllByAtivoTrue());
        return "/viewproprietarios/listagem";
    }

    @GetMapping("/formulario")
    public String loadForm(Long id, Model model){
        if(id != null){
            model.addAttribute("proprietario", iProprietarioRepository.getReferenceById(id));
        }
        return "/viewproprietarios/formulario";
    }

    @PostMapping
    @Transactional
    public String insertProprietario(DadosCadastrarProprietario dados){
        var proprietario = new Proprietario(dados);
        iProprietarioRepository.save(proprietario);
        return "redirect:/viewproprietarios";
    }

    @PutMapping
    @Transactional
    public String updateProprietario(DadosAtualizaProprietario dados){
        var proprietario = iProprietarioRepository.getReferenceById(dados.id());
        proprietario.atualizarInformacoes(dados);
        return "redirect:/viewproprietarios";
    }

    @DeleteMapping
    @Transactional
    public String deleteProprietario(Long id){
        //iProprietarioRepository.deleteById(id);
        var proprietario = iProprietarioRepository.getReferenceById(id);
        proprietario.excluir();
        return "redirect:/viewproprietarios";
    }

}
