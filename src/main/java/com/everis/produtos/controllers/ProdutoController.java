package com.everis.produtos.controllers;

import com.everis.produtos.dto.ProdutoDto;
import com.everis.produtos.services.ProdutoService;
import com.everis.produtos.entities.Produto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @ApiOperation(value = "Criar  Produto no Banco de Dados")
    @PostMapping
    public ResponseEntity<ProdutoDto> cricarProduto(@RequestBody ProdutoDto produtoDto){
        ProdutoDto produtoDto1 = produtoService.criarProduto(produtoDto);
        return ResponseEntity.ok(produtoDto1);
    }

    @ApiOperation(value = "Listar Todos os Produtos do Banco de Dados")
    @GetMapping
    public ResponseEntity<List<Produto>>listaProdutos(){
        List<Produto> produtos = produtoService.listarProdutos();
             return ResponseEntity.ok(produtos);
    }

    @ApiOperation(value = "Atualizar Produto no Banco de Dados")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ProdutoDto> atualizarProduto(@RequestBody ProdutoDto produtoDto){
        ProdutoDto produtoDto1 = produtoService.atualizarProduto(produtoDto);
        return ResponseEntity.ok(produtoDto1);

    }

    @ApiOperation(value = "Deletar Produto no Banco de Dados")
    @DeleteMapping("/{nome}")
    public void deletarProduto(@PathVariable String nome){
         produtoService.deletarProduto(nome);
    }

    @ApiOperation(value = "Buscar Por Um Produto no Banco de Dados")
    @GetMapping("/buscar/{nome}")
    public ResponseEntity<ProdutoDto> buscarProduto(@PathVariable String nome){
        ProdutoDto produtoDto = produtoService.buscarProduto(nome);
        return ResponseEntity.ok(produtoDto);
    }


}
