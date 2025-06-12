package JDBC;

import org.Martinez.Bizueto.Mireli.JDBC.CancionJDBC;
import org.Martinez.Bizueto.Mireli.JDBC.Impl.CancionJDBCImpl;
import org.Martinez.Bizueto.Mireli.model.Cancion;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

import static org.junit.Assert.*;

class CancionJDBCImplTest {

    @Test
    void getInstance() {assertNotNull(CancionJDBCImpl.getInstance());
    }

    @Test
    void findAll() {
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        List<Cancion> list = cancionJDBC.findAll();
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
        Cancion cancion = new Cancion();
        boolean res = false;
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        cancion.setTitulo("LLoloso");
        cancion.setDuracion(Time.valueOf("00:12:42"));
        cancion.setDisco_id(1);
        res = cancionJDBC.save(cancion);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Cancion cancion = new Cancion();
        boolean res = false;
        cancion.setTitulo("Fine");
        cancion.setDuracion(Time.valueOf("00:02:53"));
        cancion.setDisco_id(1);
        cancion.setId(1);
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        res = cancionJDBC.update(cancion);
        assertEquals(true, res);
    }

}