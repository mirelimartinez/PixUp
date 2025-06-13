package org.Martinez.Bizueto.Mireli.JDBC;


import org.Martinez.Bizueto.Mireli.model.Cancion;

import java.util.List;

public interface CancionJDBC {
    List<Cancion> findAll();
    Cancion findById(Integer id);
    boolean save(Cancion cancion);
    boolean update(Cancion cancion);
    boolean savetest(Cancion cancion);
    boolean updatetest(Cancion cancion);
    boolean delete(Cancion cancion);
}