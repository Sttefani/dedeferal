package com.sistema.depfederal.controller;


import com.sistema.depfederal.models.Historico;
import com.sistema.depfederal.service.EleitorService;
import com.sistema.depfederal.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/historicos")
public class HistoricoController {

    private final HistoricoService historicoService;
    private final EleitorService eleitorService;

    @Autowired
    public HistoricoController(HistoricoService historicoService, EleitorService eleitorService) {
        this.historicoService = historicoService;
        this.eleitorService = eleitorService;
    }


    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("historicos", historicoService.buscarTodos());
        return "historico/lista";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Historico historico, ModelMap model) {
        return "historico/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Historico historico, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "historico/cadastro";
        }

        historicoService.salvar(historico);
        attr.addFlashAttribute("success", "Histórico inserido com sucesso.");
        return "redirect:/historicos/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("historico", historicoService.buscarPorId(id));
        return "historico/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Historico historico, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "historico/cadastro";
        }

        historicoService.editar(historico);
        attr.addFlashAttribute("success", "Histórico editado com sucesso.");
        return "redirect:/bairros/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        historicoService.excluir(id);
        attr.addFlashAttribute("success", "Histórico excluído com sucesso.");
        return "redirect:/bairros/listar";
    }

}
