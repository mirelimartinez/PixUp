package org.Martinez.Bizueto.Mireli.model.Catalogo;

import org.Martinez.Bizueto.Mireli.JDBC.CancionJDBC;
import org.Martinez.Bizueto.Mireli.JDBC.Impl.CancionJDBCImpl;
import org.Martinez.Bizueto.Mireli.JDBC.Impl.DiscoJDBCImpl;
import org.Martinez.Bizueto.Mireli.ReadUtil.ReadUtil;
import org.Martinez.Bizueto.Mireli.model.Cancion;
import org.Martinez.Bizueto.Mireli.model.Disco;
import org.Martinez.Bizueto.Mireli.model.negocio.Catalogos;

import java.util.List;

public class CancionCatalogo extends Catalogos<Cancion>
{
    private static CancionCatalogo cancionCatalogo;
    private static CancionJDBC cancionJDBC;

    public static CancionCatalogo getInstance()
    {
        if(cancionCatalogo==null)
        {
            cancionCatalogo=new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    public Cancion newT() {
        return new Cancion();
    }

    @Override
    public boolean processNewT(Cancion cancion) {
        System.out.println("Teclee el nombre de la cancion");
        cancion.setTitulo(ReadUtil.read());
        System.out.println("Teclee la duracion de la cancion HH:mm:ss");
        cancion.setDuracion(ReadUtil.readTime());
        boolean flag3=true;
        while (flag3) {
            System.out.println("Escriba el id del disco al que pertenece la cancion");
            int idDisco =ReadUtil.readInt();
            Disco disco= DiscoJDBCImpl.getInstance().findById(idDisco);
            if(disco!=null)
            {
                cancion.setDisco(disco);
                flag3=false;
            }
            else{
                System.out.println("Disco no encontrado");
            }
        }
        return true;
    }

    @Override
    public void processEditT(Cancion cancion) {
        System.out.println("-------------------");
        System.out.println("Id de la cancion "+cancion.getId());
        System.out.println("Cancion a editar: " + cancion.getTitulo());
        System.out.println("Teclee el valor nuevo del titulo");
        cancion.setTitulo(ReadUtil.read());
        System.out.println("Teclee la nueva duracion");
        cancion.setDuracion(ReadUtil.readTime());
        System.out.println("Teclee el nuevo disco al que pertenece");
        boolean flag3=true;
        while (flag3) {
            System.out.println("Escriba el id del nuevo disco al que pertenece la cancion");
            int idDisco =ReadUtil.readInt();
            Disco disco=DiscoJDBCImpl.getInstance().findById(idDisco);
            if (disco != null) {
                cancion.setDisco(disco);
                flag3=false;
            } else {
                System.out.println("Disco no encontrado");
            }
        }
    }

    @Override
    public List<Cancion> processList()
    {
        if(cancionJDBC==null)
        {
            if(!loadCancionJDBC())
            {
                System.out.println("Error al cargar CancionJDBC");
            }
        }
        return cancionJDBC.findAll();
    }

    private boolean loadCancionJDBC()
    {
        cancionJDBC= CancionJDBCImpl.getInstance();
        return cancionJDBC!=null;
    }
}
