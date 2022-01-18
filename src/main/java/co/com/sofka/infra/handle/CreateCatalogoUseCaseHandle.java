package co.com.sofka.infra.handle;

import co.com.sofka.domain.catalogo.command.CrearCatalogoCommand;
import co.com.sofka.infra.generic.UseCaseHandle;

import co.com.sofka.useCases.CreateCatalogoUseCase;
import io.quarkus.vertx.ConsumeEvent;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateCatalogoUseCaseHandle extends UseCaseHandle {

    private final CreateCatalogoUseCase createCatalogoUseCase;

    public CreateCatalogoUseCaseHandle(CreateCatalogoUseCase createCatalogoUseCase) {
        this.createCatalogoUseCase = createCatalogoUseCase;
    }


    @ConsumeEvent(value = "sofkau.catalogo.crearCatalogo")
    void consumeBlocking(CrearCatalogoCommand command) {
        var events = createCatalogoUseCase.apply(command);
        saveCatalogo(command.getCatalogoTd(), events);
    }
}