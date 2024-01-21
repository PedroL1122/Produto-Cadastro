package org.example.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import org.example.exceptions.NegocioException;
import org.example.model.Persistente;

public interface IGenericDAO <T extends Persistente, E extends Serializable> {


    T cadastrar(T entity) throws NegocioException;


    void excluir(T entity) throws NegocioException;


    T alterar(T entity) throws NegocioException;


    T consultar(E id) throws NegocioException;


    Collection<T> buscarTodos() throws NegocioException;

}