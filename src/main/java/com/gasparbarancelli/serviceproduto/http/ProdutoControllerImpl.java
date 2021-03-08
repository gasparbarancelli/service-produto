package com.gasparbarancelli.serviceproduto.http;

import com.gasparbarancelli.serviceproduto.http.data.request.ProdutoPersistDto;
import com.gasparbarancelli.serviceproduto.http.data.response.ProdutoResponseDto;
import com.gasparbarancelli.serviceproduto.model.Produto;
import com.gasparbarancelli.serviceproduto.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produto")
public class ProdutoControllerImpl {

    private final ProdutoService produtoService;

    public ProdutoControllerImpl(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoResponseDto inserir(@RequestBody ProdutoPersistDto dto) {
        Produto produto = new Produto(dto.getDescricao(), dto.getValor());
        Produto produtoPersistido = produtoService.inserir(produto);
        return new ProdutoResponseDto(produtoPersistido.getId(), produtoPersistido.getDescricao());
    }
}
