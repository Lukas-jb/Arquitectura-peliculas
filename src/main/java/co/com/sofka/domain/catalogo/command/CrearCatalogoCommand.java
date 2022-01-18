package co.com.sofka.domain.catalogo.command;

import co.com.sofka.domain.generic.Command;

public class CrearCatalogoCommand extends Command {

    private String catalogoTd;
    private String nombre;

    public CrearCatalogoCommand() {
    }

    public String getCatalogoTd() {
        return catalogoTd;
    }

    public void setCatalogoTd(String catalogoTd) {
        this.catalogoTd = catalogoTd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

