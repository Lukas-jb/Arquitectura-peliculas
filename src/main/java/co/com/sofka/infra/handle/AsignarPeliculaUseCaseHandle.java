package co.com.sofka.infra.handle;

import co.com.sofka.domain.catalogo.command.AsignarPeliculaCommand;
import co.com.sofka.infra.generic.UseCaseHandle;
import co.com.sofka.useCases.ExtraerCatalogoUsecase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AsignarPeliculaUseCaseHandle extends UseCaseHandle {
    private final ExtraerCatalogoUsecase extraerCatalogoUsecase;

    public AsignarPeliculaUseCaseHandle(ExtraerCatalogoUsecase extraerCatalogoUsecase) {
        this.extraerCatalogoUsecase = extraerCatalogoUsecase;
    }


    @ConsumeEvent(value = "sofkau.catalogo.asignarpelicula")
    void consumeBlocking(AsignarPeliculaCommand command) {
        var events = extraerCatalogoUsecase.apply(command);
        saveCatalogo(command.getCatalogoId(), events);
    }


}