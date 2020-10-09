package com.everis.produtos.services;

import com.everis.produtos.dto.ProdutoDto;
import com.everis.produtos.exceptions.ResourceNotFoundException;
import com.everis.produtos.mappers.MapperProdutoProdutoDto;
import com.everis.produtos.repositories.ProdutoRepository;
import com.everis.produtos.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private MapperProdutoProdutoDto mapperProdutoProdutoDto;

    public ProdutoDto criarProduto(ProdutoDto produtoDto){
        Produto produto = mapperProdutoProdutoDto.toEntity(produtoDto);

        produto = produtoRepository.save(produto);
        produtoDto.setId(produto.getId());

        return produtoDto;
    }

    public List<Produto> listarProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
       return produtos;
    }

    public ProdutoDto atualizarProduto(ProdutoDto produtoD) {
        Produto produto = produtoRepository.findById(produtoD.getId()).get();

        if (produto == null){
            throw new ResourceAccessException("Produto não encontrado.");
        }

        produto.setId(produtoD.getId());
        produto.setNome(produtoD.getNome());
        produto.setQuantidade(produtoD.getQuantidade());
        produto.setValor(produtoD.getValor());

        produtoRepository.save(produto);
        return produtoD;

    }

    public void deletarProduto(String nome){
        Produto produto = produtoRepository.findByNomeEquals(nome);

        if (produto == null){
           throw  new ResourceNotFoundException("Produto não encontrado");
        }

        produtoRepository.delete(produto);
    }

    public ProdutoDto buscarProduto(String nome) {
        Produto produto = produtoRepository.findByNomeEquals(nome);

        if (produto == null){
            throw new ResourceNotFoundException("Produto não encontrado.");
        }

        ProdutoDto produtoDto = mapperProdutoProdutoDto.toDto(produto);

        return produtoDto;
    }
}
