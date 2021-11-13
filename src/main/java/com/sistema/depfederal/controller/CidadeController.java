package com.sistema.depfederal.controller;

import com.sistema.depfederal.exception.NomeCidadeJaCadastradoException;
import com.sistema.depfederal.models.Cidade;
import com.sistema.depfederal.service.CidadeService;
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
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    @Autowired
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("cidades", cidadeService.buscarTodos());
        return "cidade/lista";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Cidade cidade, ModelMap model) {
        return "cidade/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "cidade/cadastro";
        }
        try {
            cidadeService.salvar(cidade);
        } catch (NomeCidadeJaCadastradoException e){
            result.reject("nome",
                    e.getMessage());
            return "cidade/cadastro";
        }
        attr.addFlashAttribute("success", "Cidade inserida com sucesso.");
        return "redirect:/cidades/listar";
    }
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cidade", cidadeService.buscarPorId(id));
        return "cidade/cadastro";
    }
    @PostMapping("/editar")
    public String editar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "cidade/cadastro";
        }

        try {
            cidadeService.editar(cidade);
        } catch (NomeCidadeJaCadastradoException e){
            result.reject("nome",
                    e.getMessage());
            return "cidade/cadastro";
        }
        attr.addFlashAttribute("success", "Cidade editada com sucesso.");
        return "redirect:/cidades/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        cidadeService.excluir(id);
        attr.addFlashAttribute("success", "Cidade excluída com sucesso.");
        return "redirect:/cidades/listar";
    }

}