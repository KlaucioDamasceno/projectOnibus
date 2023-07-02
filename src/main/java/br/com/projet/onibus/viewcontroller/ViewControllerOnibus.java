package br.com.projet.onibus.viewcontroller;

import br.com.projet.onibus.onibus.DadosAtualizaOnibus;
import br.com.projet.onibus.onibus.DadosCadastroOnibus;
import br.com.projet.onibus.onibus.IOnibusRepository;
import br.com.projet.onibus.onibus.Onibus;
import br.com.projet.onibus.rota.IRotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("viewonibus")
public class ViewControllerOnibus {

    @Autowired
    private IOnibusRepository ionibusRepository;
    @Autowired
    private IRotaRepository iRotaRepository;


    @GetMapping
    public String getAllOnibus(Model model){
        model.addAttribute("lista", ionibusRepository.findAll());
        return "/viewonibus/listagem";
    }

    @GetMapping("/formulario")
    public String loadForm(Long id, Model model){
        if(id != null){
            model.addAttribute("onibus", ionibusRepository.getReferenceById(id));
            model.addAttribute("rotas", iRotaRepository.findAll());
        }
        model.addAttribute("rotas", iRotaRepository.findAll());
        return "/viewonibus/formulario";
    }

    @PostMapping
    @Transactional
    public String insertOnibus(DadosCadastroOnibus dados, Long rotaid){
        var rota = iRotaRepository.getReferenceById(rotaid);
        var onibus = new Onibus(dados, rota);

        ionibusRepository.save(onibus);
        return "redirect:/viewonibus";
    }

    @PutMapping
    @Transactional
    public String updateOnibus(DadosAtualizaOnibus dados, Long rotaid){
       var rota = iRotaRepository.getReferenceById(rotaid);
       var onibus = ionibusRepository.getReferenceById(dados.id());
       onibus.atualizarInformacoes(dados, rota);
        return "redirect:/viewonibus";
    }

    @DeleteMapping
    @Transactional
    public String deleteOnibus(Long id){
        var onibus = ionibusRepository.getReferenceById(id);
        onibus.excluir();
        return "redirect:/viewonibus";
    }

}
