package JDBC;

import org.Martinez.Bizueto.Mireli.JDBC.DiscoJDBC;
import org.Martinez.Bizueto.Mireli.JDBC.Impl.DiscoJDBCImpl;
import org.Martinez.Bizueto.Mireli.model.Disco;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

class DiscoJDBCImplTest {

    @Test
    void getInstance() { assertNotNull(DiscoJDBCImpl.getInstance()); }

    @Test
    void findAll() {
        DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
        List<Disco> list = discoJDBC.findAll();
        if(list == null || list.isEmpty())
        {
            System.out.println("No hay elementos");
            return;
        }
        list.stream().forEach( e-> System.out.println(e.toString()));
        assertNotNull(list);
        assertTrue(list.size() >= 1);

    }

    @Test
    void save() {
        Disco disco = new Disco();
        boolean res = false;
        DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
        disco.setTitulo("Pokemon");
        disco.setPrecio(24.75F);
        disco.setExistencia(490);
        disco.setDescuento(0);
        disco.setFecha(Date.valueOf("2020-10-24").toLocalDate());
        disco.setImagen("Charizard");
        disco.setArtista_id(1);
        disco.setDisquera_id(1);
        disco.setGenero_id(1);
        res = discoJDBC.save(disco);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Disco disco = new Disco();
        boolean res = false;
        DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
        disco.setTitulo("Goku");
        disco.setPrecio(53.24F);
        disco.setExistencia(90);
        disco.setDescuento(0);
        disco.setFecha(Date.valueOf("2020-10-24").toLocalDate());
        disco.setImagen("squerlter");
        disco.setArtista_id(1);
        disco.setDisquera_id(1);
        disco.setGenero_id(1);
        disco.setId(1);
        res = discoJDBC.update(disco);
        assertEquals(true, res);
    }

}