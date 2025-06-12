package JDBC;

import org.Martinez.Bizueto.Mireli.JDBC.DisqueraJDBC;
import org.Martinez.Bizueto.Mireli.JDBC.Impl.DisqueraJDBCImpl;
import org.Martinez.Bizueto.Mireli.model.Disquera;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

class DisqueraJDBCImplTest {

    @Test
    void getInstance() {assertNotNull(DisqueraJDBCImpl.getInstance());    }

    @Test
    void findAll() {
        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
        List<Disquera> list = disqueraJDBC.findAll();
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
        Disquera disquera = new Disquera();
        boolean res = false;
        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
        disquera.setNombre("Billie Eilish");
        res = disqueraJDBC.save(disquera);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Disquera disquera = new Disquera();
        boolean res = false;
        disquera.setNombre("Apple Music");
        disquera.setId(1);
        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
        res = disqueraJDBC.update(disquera);
        assertEquals(true, res);
    }

}