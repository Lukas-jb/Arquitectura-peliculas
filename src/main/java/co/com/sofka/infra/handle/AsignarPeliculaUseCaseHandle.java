package co.com.sofka.infra.handle;

import co.com.sofka.domain.catalogo.command.AsignarPeliculaCommand;
import co.com.sofka.infra.generic.UseCaseHandle;
import co.com.sofka.useCases.ExtraerCatalogoUsecase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AssignScoreUseCaseHandle extends UseCaseHandle {
    private final ExtraerCatalogoUsecase extraerCatalogoUsecase;

    public AssignScoreUseCaseHandle(ExtraerCatalogoUsecase extraerCatalogoUsecase) {
        this.extraerCatalogoUsecase = extraerCatalogoUsecase;
    }


    @ConsumeEvent(value = "sofkau.program.assignscore")
    void consumeBlocking(AsignarPeliculaCommand command) {
        var events = extraerCatalogoUsecase.apply(command);
        saveCatalogo(command.getCatalogoId(), events);
    }


}