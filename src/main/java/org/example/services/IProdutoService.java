package org.example.services;

import java.util.List;

import org.example.model.Produto;
import org.example.services.generics.IGenericService;

public interface IProdutoService extends IGenericService<Produto, Long> {

    List<Produto> filtrarProdutos(String query);
}
