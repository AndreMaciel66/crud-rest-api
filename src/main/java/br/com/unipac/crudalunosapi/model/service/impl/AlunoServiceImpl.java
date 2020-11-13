package br.com.unipac.crudalunosapi.model.service.impl;

import br.com.unipac.crudalunosapi.model.dao.AlunoDao;
import br.com.unipac.crudalunosapi.model.domain.Aluno;
import br.com.unipac.crudalunosapi.model.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoDao alunoDao;

    @Override
    public Aluno salvar(Aluno aluno) {
        return alunoDao.save(aluno);
    }

    @Override
    public Aluno editar(Long id, Aluno aluno) {
        aluno.setId(id);
        return alunoDao.save(aluno);
    }

    @Override
    public List<Aluno> list() {
        return alunoDao.findAll();
    }

    @Override
    public Optional<Aluno> findById(Long id) {
        return alunoDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        alunoDao.deleteById(id);
    }
}
