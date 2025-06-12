package org.Martinez.Bizueto.Mireli.JDBC;


import org.Martinez.Bizueto.Mireli.model.Disco;

import java.util.List;

public interface DiscoJDBC
{

    List<Disco>findAll();
    Disco findById(Integer id);
    boolean save(Disco disco);
    boolean update(Disco disco);
    boolean delete(Disco disco);

}
