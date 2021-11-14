package com.sistema.depfederal.controller;

import com.sistema.depfederal.exception.NomeBairroJaCadastradoException;
import com.sistema.depfederal.models.Bairro;
import com.sistema.depfederal.models.Cidade;
import com.sistema.depfederal.service.BairroService;
import com.sistema.depfederal.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bairros")
public class BairroController {

    @Autowired
    private BairroService bairroService;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("bairros", bairroService.buscarTodos());
        return "bairro/lista";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Bairro bairro, ModelMap model) {
        return "bairro/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Bairro bairro, BindingResult result, RedirectAttributes attr, ModelMap model) {
        try {
            if (result.hasErrors()) {
                return "bairro/cadastro";
            }
            bairroService.salvar(bairro);
            attr.addFlashAttribute("success", "Bairro inserido com sucesso.");
            return "redirect:/bairros/listar";
        } catch (NomeBairroJaCadastradoException e) {
            e.printStackTrace();
            model.addAttribute("fail", e.getMessage());
            return "bairro/cadastro";
        }
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("bairro", bairroService.buscarPorId(id));
        return "bairro/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Bairro bairro, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "bairro/cadastro";
        }

        bairroService.editar(bairro);
        attr.addFlashAttribute("success", "Bairro editado com sucesso.");
        return "redirect:/bairros/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        bairroService.excluir(id);
        attr.addFlashAttribute("success", "Bairro excluído com sucesso.");
        return "redirect:/bairros/listar";
    }

    @ModelAttribute("cidades")
    public List<Cidade> listaDeCidades() {
        return cidadeService.buscarTodos();
    }
}
