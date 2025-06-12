package org.Martinez.Bizueto.Mireli.model;

import org.Martinez.Bizueto.Mireli.model.negocio.Catalogo;

public class Artista extends Catalogo
{
    private String nombre;

    public Artista() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "artista='"+nombre+'\''+
                ", id="+id;
    }
}
