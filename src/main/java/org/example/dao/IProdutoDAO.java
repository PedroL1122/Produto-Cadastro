package org.example.dao;

import java.util.List;

import org.example.dao.generic.IGenericDAO;
import org.example.model.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, Long>{

    List<Produto> filtrarProdutos(String query);

}
