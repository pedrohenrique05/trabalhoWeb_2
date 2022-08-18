package trabalho.tvc8.pedro;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ControllerGeral {
    
    @RequestMapping({ "/", "/index.html" })
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("geral-index");
        mv.addObject("mensagem", "Sistema de cadastro de PROJETO!");
        return mv;
    }
    
    /**
     * Controller do CRUD de PROJETO
     */

    @Autowired
    private RepositoryProjetoGeral repProj;

    @RequestMapping("/indexprojeto.html")
    public ModelAndView indexProjeto() {
        ModelAndView mv = new ModelAndView("projeto-index");
        mv.addObject("mensagem", "Cadastro de Projeto!");
        return mv;
    }


    @GetMapping("/cadastrarprojeto.html")
    public ModelAndView novaGETProjeto() {
        ModelAndView mv = new ModelAndView("projeto-cadastro");
        ProjetoGeral pro = new ProjetoGeral();
        mv.addObject("projeto", pro);
        return mv;
    }
    
    @PostMapping("/cadastrarprojeto.html")
    public ModelAndView novaPOSTProjeto(@Valid ProjetoGeral pro, BindingResult binding) {
        ModelAndView mv = new ModelAndView("projeto-cadastro");
        if (binding.hasErrors()) {
            mv.setViewName("projeto-cadastro.html");
            mv.addObject("projeto", pro);
            return mv;
        }
        repProj.save(pro);
        mv.addObject("projeto", pro);
        mv.setViewName("redirect:/listarprojeto.html");
        
        return mv;
    }

    @GetMapping(path = "/listarprojeto.html")
    public ModelAndView listarProjeto() {
        ModelAndView mv = new ModelAndView("projeto-listar");
        List<ProjetoGeral> pro = repProj.findAll();
        mv.addObject("projetos", pro);
        return mv;
    }
    @GetMapping("/editarprojeto/{id}")
    public ModelAndView editarGETProjeto(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("projeto-editar");
        Optional<ProjetoGeral> projetoEditarOptional = repProj.findById(id);
        if (projetoEditarOptional.isPresent()) {
            ProjetoGeral pro = projetoEditarOptional.get();
            mv.setViewName("projeto-editar");
            mv.addObject("projeto", pro);
            return mv;
        }
        mv.setViewName("redirect:../listarprojeto.html");
        return mv;
    }

    @PostMapping("/editarprojeto/{id}")
    public ModelAndView editarPOST(@Valid ProjetoGeral pro, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("projeto-editar.html");
            mv.addObject("projeto", pro);
            return mv;
        }
        repProj.save(pro);
        mv.addObject("projeto", pro);
        mv.setViewName("redirect:../listarprojeto.html");
        return mv;
    }

    @GetMapping("/excluirprojeto/{id}")
    public ModelAndView excluirprojeto(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:../listarprojeto.html");

        Optional<ProjetoGeral> projetoexcluir = repProj.findById(id);

        if (projetoexcluir.isPresent()) {
            ProjetoGeral pro = projetoexcluir.get();
            repProj.delete(pro);
        }
        return mv;
    }


    @GetMapping(path = "/detalharProjeto/{idProjeto}")
    public ModelAndView listarProjetoDetalhado(@PathVariable Long idProjeto) {
        ModelAndView mv = new ModelAndView("projeto-listarObs");
        
        List<ObservacaoGeral> obs = repObs.findByIdProjeto(idProjeto);
        Optional<ProjetoGeral> projeto = repProj.findById(idProjeto);
        
        if(obs.size() != 0){
            System.out.println("Chamando a consulta: "+idProjeto);
            System.out.println("consulta válida");
            mv.addObject("observacoes", obs);
            ProjetoGeral pro = projeto.get();
            mv.addObject("projeto", pro);
            System.out.println("Total de Obsevações: "+obs.size());        
            System.out.println("Total do Projeto: "+pro.toString());        
            return mv;    
        }else{
            System.out.println("consulta vazia");
            mv.setViewName("redirect:../listarprojeto.html");
            return mv;
        }
    }


    
    /**
     * Controller CRUD Escala
     */

    @Autowired
    private RepositoryEscalaGeral repEsc;
    
    @RequestMapping("indexescala.html")
    public ModelAndView indexEscala() {
        ModelAndView mv = new ModelAndView("escala-index");
        mv.addObject("mensagem", "Cadastro de Escala!");
        return mv;
    }

    @GetMapping("/cadastrarescala.html")
    public ModelAndView novaGET() {
        ModelAndView mv = new ModelAndView("escala-cadastro");
        EscalaGeral esc = new EscalaGeral();
        mv.addObject("escala", esc);
        return mv;
    }
    
    @PostMapping("/cadastrarescala.html")
    public ModelAndView novaPOST(@Valid EscalaGeral esc, BindingResult binding) {
        ModelAndView mv = new ModelAndView("escala-cadastro");
        if (binding.hasErrors()) {
            mv.setViewName("escala-cadastro.html");
            mv.addObject("escala", esc);
            return mv;
        }
        repEsc.save(esc);
        mv.addObject("escala", esc);
        mv.setViewName("redirect:/listarescala.html");
        return mv;
    }

    @GetMapping(path = "/listarescala.html")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("escala-listar");
        List<EscalaGeral> esc = repEsc.findAll();
        mv.addObject("escalas", esc);
        return mv;
    }
    
    @GetMapping("/editarescala/{id}")
    public ModelAndView editarGET(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("escala-editar");

        Optional<EscalaGeral> escalaEditarOptional = repEsc.findById(id);
        if (escalaEditarOptional.isPresent()) {
            EscalaGeral esc = escalaEditarOptional.get();
            mv.setViewName("escala-editar");
            mv.addObject("escala", esc);
            return mv;
        }
        mv.setViewName("redirect:../listarescala.html");
        return mv;
    }

    @PostMapping("/editarescala/{id}")
    public ModelAndView editarPOST(@Valid EscalaGeral esc, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("escala-editar.html");
            mv.addObject("escala", esc);
            return mv;
        }
        repEsc.save(esc);
        mv.addObject("escala", esc);
        mv.setViewName("redirect:../listarescala.html");
        return mv;

    }

    @GetMapping("/excluirescala/{id}")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:../listarescala.html");

        Optional<EscalaGeral> escalaExcluir = repEsc.findById(id);

        if (escalaExcluir.isPresent()) {
            EscalaGeral esc = escalaExcluir.get();
            repEsc.delete(esc);
        }
        return mv;
    }

    @GetMapping("/cadastrarObservacaoProjeto/{id}")
    public ModelAndView chamaCadastroObservacao(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:../cadastrarobservacao.html/{id}");

        return mv;
    }
    /**
     * Controller CRUD OBSERVAÇÃO
     */
    
    @Autowired
    private RepositoryObservacaoGeral repObs;

    @RequestMapping("indexobservacao.html")
    public ModelAndView indexObservacao() {
        ModelAndView mv = new ModelAndView("observacao-index");
        mv.addObject("mensagem", "Observações!");
        return mv;
    }

    @GetMapping("/cadastrarobservacao.html/{id}")
    public ModelAndView novaGETObservacao(@PathVariable Long id) {
        
        List<EscalaGeral> esc = repEsc.findAll();
        
        ModelAndView mv = new ModelAndView("observacao-cadastro");
        if(esc.size() != 0){
            mv.addObject("escalas", esc);
            ObservacaoGeral obs = new ObservacaoGeral(id);
            mv.addObject("observacao", obs);
            return mv;
        }else{
            mv.setViewName("redirect:../cadastrarescala.html");    
            return mv;
        }
	    
    }
    
    @PostMapping("/cadastrarobservacao.html")
    public ModelAndView novaPOST(@Valid ObservacaoGeral obs, BindingResult binding) {
        ModelAndView mv = new ModelAndView("observacao-cadastro");
        if (binding.hasErrors()) {
            mv.setViewName("observacao-cadastro.html");
            mv.addObject("observacao", obs);
            System.out.println("Erro");
            return mv;
        }
        List<EscalaGeral> esc = repEsc.findAll();
        mv.addObject("escalas", esc);
        repObs.save(obs);
        mv.addObject("observacao", obs);
        mv.setViewName("redirect:../listarprojeto.html");
        return mv;
    }

    @GetMapping(path = "/listarobservacao.html")
    public ModelAndView listarObservacao() {
        ModelAndView mv = new ModelAndView("observacao-listar");
        List<ObservacaoGeral> obs = repObs.findAll();
        mv.addObject("observacoes", obs);
        return mv;
    }

    @GetMapping("/editarobservacao/{id}")
    public ModelAndView editarGETObservacao(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("observacao-editar");
        
        Optional<ObservacaoGeral> observacaoEditarOptional = repObs.findById(id);
        if (observacaoEditarOptional.isPresent()) {
            ObservacaoGeral obs = observacaoEditarOptional.get();
            mv.setViewName("observacao-editar");
            mv.addObject("observacao", obs);
            return mv;
        }
        mv.setViewName("redirect:../listarobservacao.html");
        return mv;
    }

    @PostMapping("/editarobservacao/{id}")
    public ModelAndView editarPOSTObservacao(@Valid ObservacaoGeral obs, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("observacao-editar.html");
            mv.addObject("observacao", obs);
            return mv;
        }
        Optional<EscalaGeral> escAux = repEsc.findById(obs.getEsc());
        mv.addObject("escalas", escAux);
        System.out.println("Escala: "+escAux.toString());
        repObs.save(obs);
        mv.addObject("observacao", obs);
        mv.setViewName("redirect:../listarobservacao.html");
        return mv;

    }

    @GetMapping("/excluirobservacao/{id}")
    public ModelAndView excluirObservacao(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:../listarobservacao.html");

        Optional<ObservacaoGeral> observacaoExcluir = repObs.findById(id);

        if (observacaoExcluir.isPresent()) {
            ObservacaoGeral obs = observacaoExcluir.get();
            repObs.delete(obs);
        }
        return mv;
    }

    /**
    * CRUD Razão
    */

    @Autowired
    private RepositoryRazao repRazao;

    @RequestMapping("/razaoobservacaoescala.html")
    public ModelAndView indexRazao() {
        ModelAndView mv = new ModelAndView("razaoescalaobservacao");
        mv.addObject("mensagem", "Em Desenvolvimento");
        return mv;
    }

    @RequestMapping("/cadastrarRazoes.html")
    public void registraRazoes(){
        //
    }

}
