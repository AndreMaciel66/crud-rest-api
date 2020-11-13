package br.com.unipac.crudalunosapi.api.resources;

import br.com.unipac.crudalunosapi.model.domain.Aluno;
import br.com.unipac.crudalunosapi.model.service.AlunoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Aluno>> list() {
        List<Aluno> list = alunoService.list();

        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.noContent().build();
        }
    };

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Aluno> findById(@PathVariable("id") Long id) {
        Optional<Aluno> aluno = alunoService.findById(id);

        if (aluno.isPresent()){
            return ResponseEntity.ok(aluno.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    };

    @PostMapping
    @ResponseBody
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno) {
        Aluno alunoCadastrado = alunoService.salvar(aluno);

        if (alunoCadastrado != null){
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoCadastrado.getId()).toUri();
            return ResponseEntity.created(uri).body(alunoCadastrado);
        } else {
            return ResponseEntity.noContent().build();
        }
    };

    @PostMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Aluno> editar(@PathVariable("id") Long id, @RequestBody Aluno aluno){
        Aluno alunoEditado = alunoService.editar(id, aluno);

        if(alunoEditado != null){
            return ResponseEntity.ok(alunoEditado);
        } else {
            return ResponseEntity.noContent().build();
        }
    };

    @DeleteMapping
    public ResponseEntity delete(Long id){
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    };
}
