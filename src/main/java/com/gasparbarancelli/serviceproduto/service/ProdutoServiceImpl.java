package com.gasparbarancelli.serviceproduto.service;

import com.gasparbarancelli.serviceproduto.model.Produto;
import com.gasparbarancelli.serviceproduto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto one(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Produto de código %d não encontrado", id)));
    }

    @Override
    public Produto inserir(Produto produto) {
        return produtoRepository.save(produto);
    }

}
