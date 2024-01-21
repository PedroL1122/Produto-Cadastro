package org.example.controller;


import  java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.exceptions.NegocioException;
import org.example.model.Produto;
import org.example.services.IProdutoService;
import org.example.utility.Message;

@Named(value = "bean")
@SessionScoped
public class ProdutoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Produto produto;

    @Inject
    private IProdutoService service;

    private Collection<Produto> produtos;

    @PostConstruct
    public void init() throws NegocioException {
        produtos = service.buscarTodos();
    }

    public void adicionar() {
        try {
            service.cadastrar(produto);
            produto = new Produto();
            init();
            Message.info("Salvo com sucesso");

        } catch (NegocioException e) {
            Message.erro(e.getMessage());
        }
    }

    public void excluir() {
        try {
            service.excluir(produto);
            init();
            Message.info(produto.getNome() + " foi removido com sucesso.");

        } catch (NegocioException e) {
            Message.erro(e.getMessage());
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Collection<Produto> getProdutos() {
        return produtos;
    }



}
