package com.sistema.depfederal.controller;

import com.sistema.depfederal.models.*;
import com.sistema.depfederal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/eleitores")
public class EleitorController {

    private final EleitorService eleitorService;
    private final HistoricoService historicoService;
    private final ParenteService parenteService;
    private final CidadeService cidadeService;
    private final BairroService bairroService;

    @Autowired
    public EleitorController(EleitorService eleitorService, ParenteService parenteService,
                             HistoricoService historicoService, CidadeService cidadeService,
                             BairroService bairroService) {
        this.eleitorService = eleitorService;
        this.historicoService = historicoService;
        this.parenteService = parenteService;
        this.cidadeService = cidadeService;
        this.bairroService = bairroService;
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("eleitor", eleitorService.buscarTodos());
        return "eleitor/lista";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Eleitor eleitor, ModelMap model) {

        return "eleitor/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Eleitor eleitor, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "eleitor/cadastro";
        }

        eleitorService.salvar(eleitor);
        attr.addFlashAttribute("success", "Eleitor inserido com sucesso.");
        return "redirect:/eleitores/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("bairro", eleitorService.buscarPorId(id));
        return "eleitor/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Eleitor eleitor, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "eleitor/cadastro";
        }

        eleitorService.editar(eleitor);
        attr.addFlashAttribute("success", "Eleitor editado com sucesso.");
        return "redirect:/eleitores/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        eleitorService.excluir(id);
        attr.addFlashAttribute("success", "Eleitor excluído com sucesso.");
        return "redirect:/eleitores/listar";
    }

    @ModelAttribute("sexos")
    public List<Sexo> listaDeCargos() {
        List<Sexo> sexos = new ArrayList<Sexo>();
        for (Sexo sexo : Sexo.values()) {
            sexos.add(sexo);
        }

        return sexos;
    }

    @ModelAttribute("parentes")
    public List<Parente> listaDeParentes() {
        return parenteService.buscarTodos();
    }
    @ModelAttribute("historicos")
    public List<Historico> listaDeHistorico() {
        return historicoService.buscarTodos();
    }
    @ModelAttribute("cidades")
    public List<Cidade> listaDeCidades() {
        return cidadeService.buscarTodos();
    }
    @ModelAttribute("bairros")
    public List<Bairro> listaDeBairros() {
        return bairroService.buscarTodos();
    }

}

