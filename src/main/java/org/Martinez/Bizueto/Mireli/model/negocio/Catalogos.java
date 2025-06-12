package org.Martinez.Bizueto.Mireli.model.negocio;


import org.Martinez.Bizueto.Mireli.JDBC.*;
import org.Martinez.Bizueto.Mireli.JDBC.Impl.*;
import org.Martinez.Bizueto.Mireli.ReadUtil.ReadUtil;
import org.Martinez.Bizueto.Mireli.model.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Catalogos<T extends Catalogo>extends LecturaAccion
{
    protected List<T> list;
    protected T t;
    protected boolean flag2;
    ListaCatalogos listaCatalogos=ListaCatalogos.getInstance();

    public Catalogos()
    {
        list=new ArrayList<>();
    }

    public boolean isListEmpty() {
        return list.isEmpty();
    }

    public void print()
    {
        if(isListEmpty())
        {
           list= processList();
           if(list == null || list.isEmpty())
           {
               System.out.println("No hay elementos");
               return;
           }
        }
            list.stream().forEach( e-> System.out.println(e.toString()));
    }

    public abstract T newT();
    public abstract boolean processNewT (T t);
    public abstract void processEditT(T t);
    public abstract List<T> processList();

    public void add()
    {
        t=newT();
        if(processNewT(t))
        {
            switch (listaCatalogos.tipo)
            {
                case 1:
                    ArtistaJDBC artistaJDBC= ArtistaJDBCImpl.getInstance();
                    artistaJDBC.save((Artista)t);
                    break;
                case 2:
                    DisqueraJDBC disqueraJDBC= DisqueraJDBCImpl.getInstance();
                    disqueraJDBC.save((Disquera)t);
                    break;
                case 3:
                    GeneroJDBC generoJDBC= GeneroJDBCImpl.getInstance();
                    generoJDBC.save((Genero)t);
                    break;
                case 4:
                    DiscoJDBC discoJDBC= DiscoJDBCImpl.getInstance();
                    discoJDBC.save((Disco)t);
                    break;
                case 5:
                    CancionJDBC cancionJDBC= CancionJDBCImpl.getInstance();
                    cancionJDBC.save((Cancion)t);
                    break;
            }
            System.out.println("Nuevo elemento añadido!");
            list=processList();
        }
    }

    public void edit()
    {
        if(isListEmpty())
        {
            list=processList();
            if(list==null || list.isEmpty()) {
                System.out.println("No hay elementos");
                return;
            }
        }
        flag2=true;
        while (flag2)
        {
            System.out.println("Ingrese el id del elemento a editar");
            print();
            int busca= ReadUtil.readInt();
            t=list.stream().filter(e->e.getId().equals(busca)).findFirst().orElse(null);
            if (t==null)
            {
                System.out.println("Id incorrecto, intente de nuevo");
            }
            else
            {
                processEditT(t);
                flag2=false;
                System.out.println("Elemento modificado");
                switch (listaCatalogos.tipo){
                    case 1:
                        ArtistaJDBC artistaJDBC= ArtistaJDBCImpl.getInstance();
                        artistaJDBC.update((Artista)t);
                        break;
                    case 2:
                        DisqueraJDBC disqueraJDBC= DisqueraJDBCImpl.getInstance();
                        disqueraJDBC.update((Disquera)t);
                        break;
                    case 3:
                        GeneroJDBC generoJDBC=GeneroJDBCImpl.getInstance();
                        generoJDBC.update((Genero)t);
                        break;
                    case 4:
                        DiscoJDBC discoJDBC=DiscoJDBCImpl.getInstance();
                        discoJDBC.update((Disco) t);
                        break;
                    case 5:
                        CancionJDBC cancionJDBC=CancionJDBCImpl.getInstance();
                        cancionJDBC.update((Cancion)t);
                        break;
                }
            }
        }
    }

    public void remove()
    {
        if (list.isEmpty())
        {
            list=processList();
            if(list==null || list.isEmpty()) {
                System.out.println("No hay elementos");
                return;
            }
        }
        flag2=true;
        while (flag2)
        {
            System.out.println("Ingrese el elemento a borrar");
            print();
            int busca=ReadUtil.readInt();
            t=list.stream().filter(e->e.getId().equals(busca)).findFirst().orElse(null);
            if(t==null)
            {
                System.out.println("-------------------");
                System.out.println("Id incorrecto, intente nuevamente");
                System.out.println("-------------------");
            }
            else
            {
                list.remove(t);
                flag2=false;
                System.out.println("Elemento borrado");
                switch (listaCatalogos.tipo) {
                    case 1:
                        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
                        artistaJDBC.delete((Artista) t);
                        break;
                    case 2:
                        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
                        disqueraJDBC.delete((Disquera) t);
                        break;
                    case 3:
                        GeneroJDBC generoJDBC=GeneroJDBCImpl.getInstance();
                        generoJDBC.delete((Genero)t);
                        break;
                    case 4:
                        DiscoJDBC discoJDBC= DiscoJDBCImpl.getInstance();
                        discoJDBC.delete((Disco) t);
                        break;
                    case 5:
                        CancionJDBC cancionJDBC=CancionJDBCImpl.getInstance();
                        cancionJDBC.delete((Cancion)t);
                        break;
                }
            }
        }

    }

    @Override
    public void despliegaMenu() {
        System.out.println("Seleccione una opcion");
        System.out.println("1.-Agregar");
        System.out.println("2.-Editar");
        System.out.println("3.-Borrar");
        System.out.println("4.-Imprimir");
        System.out.println("5.-Salir");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 5;
    }

    @Override
    public void procesaOpcion() {
        switch (opcion)
        {
            case 1:
                add();
                break;
            case 2:
                edit();
                break;
            case 3:
                remove();
                break;
            case 4:
                print();
                break;
        }
    }
}
