package com.massimiliano.webapp.dao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

// interefaccia generica per le operazioni fondamentali per le query

public interface GenericDao<I extends Serializable, E extends Serializable> {
    @NotNull
    List<I> SelezionaTutti();

    void Inserisci(@NotNull I entity);

    void Aggiorna(@NotNull I entity);

    void Elimina(@NotNull I entity);

    void EliminaById(@NotNull E Id);

    I SelezionaById(@NotNull E Id);
}
