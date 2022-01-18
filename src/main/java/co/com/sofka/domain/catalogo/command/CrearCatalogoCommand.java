package co.com.sofka.domain.catalogo.command;

public class CrearCatalogoCommand {

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

