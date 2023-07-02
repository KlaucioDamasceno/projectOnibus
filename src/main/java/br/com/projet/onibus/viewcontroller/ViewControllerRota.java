package br.com.projet.onibus.viewcontroller;

import br.com.projet.onibus.onibus.DadosAtualizaOnibus;
import br.com.projet.onibus.onibus.DadosCadastroOnibus;
import br.com.projet.onibus.onibus.IOnibusRepository;
import br.com.projet.onibus.onibus.Onibus;
import br.com.projet.onibus.rota.DadosAtualizacaoRota;
import br.com.projet.onibus.rota.DadosCadastroRota;
import br.com.projet.onibus.rota.IRotaRepository;
import br.com.projet.onibus.rota.Rota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("viewrotas")
public class ViewControllerRota {


    @Autowired
    private IRotaRepository iRotaRepository;

    @GetMapping
    public String getAllRotas(Model model){
        model.addAttribute("lista", iRotaRepository.findAll());
        return "/viewrotas/listagem";
    }

    @GetMapping("/formulario")
    public String loadForm(Long id, Model model){
        if(id != null){
            model.addAttribute("rota", iRotaRepository.getReferenceById(id));
        }
        return "/viewrotas/formulario";
    }

    @PostMapping
    @Transactional
    public String insertRota(DadosCadastroRota dados){
        System.out.println(dados);
        var rota = new Rota(dados);
        iRotaRepository.save(rota);
        return "redirect:/viewrotas";
    }

    @PutMapping
    @Transactional
    public String updateRota(DadosAtualizacaoRota dados){
      var rota = iRotaRepository.getReferenceById(dados.id());
      rota.atualizarInformacoes(dados);
      return "redirect:/viewrotas";
    }

    @DeleteMapping
    @Transactional
    public String deleteRota(Long id){
        var rota = iRotaRepository.getReferenceById(id);
        //rota.delete();
        iRotaRepository.delete(rota);
        return "redirect:/viewrotas";
    }

}
