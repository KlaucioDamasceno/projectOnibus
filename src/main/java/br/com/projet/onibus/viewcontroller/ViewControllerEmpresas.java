package br.com.projet.onibus.viewcontroller;
import br.com.projet.onibus.empresa.DadosAtualizacaoEmpresa;
import br.com.projet.onibus.empresa.DadosCadastroEmpresa;
import br.com.projet.onibus.empresa.Empresa;
import br.com.projet.onibus.empresa.IEmpresaRepository;
import br.com.projet.onibus.endereco.DadosEndereco;
import br.com.projet.onibus.endereco.Endereco;
import br.com.projet.onibus.onibus.DadosAtualizaOnibus;
import br.com.projet.onibus.onibus.DadosCadastroOnibus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("viewempresas")
public class ViewControllerEmpresas {
    @Autowired
    private IEmpresaRepository iEmpresaRepository;


    @GetMapping
    public String getAllEmpresas(Model model){
        model.addAttribute("lista", iEmpresaRepository.findAllByAtivoTrue());
        return "/viewempresas/listagem";
    }

    @GetMapping("/formulario")
    public String loadForm(Long id, Model model){
        if(id != null){
            var empresa = iEmpresaRepository.getReferenceById(id);
            model.addAttribute("empresa",empresa);
            var endereco = empresa.getEndereco();
            System.out.println(endereco);
            model.addAttribute("endereco",endereco);

        }
        return "/viewempresas/formulario";
    }

    @PostMapping
    @Transactional
    public String insertEmpresa(DadosCadastroEmpresa dados, DadosEndereco endereco){
        var empresa = new Empresa(dados, endereco);
        iEmpresaRepository.save(empresa);
        return "redirect:/viewempresas";
    }

    @PutMapping
    @Transactional
    public String updateEmpresa(DadosAtualizacaoEmpresa dados, DadosEndereco endereco){
        var empresa = iEmpresaRepository.getReferenceById(dados.id());
        empresa.atualizarInformacoes(dados, endereco);
        return "redirect:/viewempresas";
    }

    @DeleteMapping
    @Transactional
    public String deleteEmpresa(Long id){
        var empresa = iEmpresaRepository.getReferenceById(id);
        empresa.delete();
        return "redirect:/viewempresas";
    }
}
