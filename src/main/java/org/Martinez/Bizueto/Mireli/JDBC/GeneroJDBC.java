package org.Martinez.Bizueto.Mireli.JDBC;

import org.Martinez.Bizueto.Mireli.model.Genero;

import java.util.List;

public interface GeneroJDBC
{

    List<Genero> findAll();
    Genero findById(Integer id);
    boolean save(Genero genero);
    boolean update(Genero genero);
    boolean delete(Genero genero);

}
