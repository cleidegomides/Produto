package com.everis.produtos.mappers;

import com.everis.produtos.dto.ProdutoDto;
import com.everis.produtos.entities.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperProdutoProdutoDto {

    ProdutoDto toDto(Produto produto);

    Produto toEntity (ProdutoDto produtoDto);
}
