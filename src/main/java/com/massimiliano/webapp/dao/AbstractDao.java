package com.massimiliano.webapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<I extends Serializable, Id extends Serializable>
        implements GenericDao<I, Id> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected final Class<I> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.entityClass = (Class<I>) ((ParameterizedType)
                this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public List<I> SelezionaTutti() {

        // equivalente di SELECT * FROM ....
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<I> query = builder.createQuery(this.entityClass);

        return this.entityManager.createQuery(
                query.select(query.from(this.entityClass))).getResultList();
    }

    @Override
    public I SelezionaById(Id id) {

        // equivalente di SELECT * FROM ... WHERE ...id : id
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<I> query = builder.createQuery(this.entityClass);

        return this.entityManager.createQuery(
                query.where(
                        builder.equal(
                                query.from(this.entityClass).
                                        get("id"), id))).
                getSingleResult();

    }

    @Override
    public void Inserisci(I entity) {
        this.entityManager.persist(entity);
        flushAndClear();
    }

    @Override
    public void Aggiorna(I entity) {
        this.entityManager.merge(entity);
        flushAndClear();
    }

    @Override
    public void Elimina(I entity) {

        this.entityManager.remove(this.entityManager.contains(entity) ? entity : this.entityManager.merge(entity));
        flushAndClear();

    }

    @Override
    public void EliminaById(Id id) {

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaDelete<I> query = builder.createCriteriaDelete(this.entityClass);

        this.entityManager.createQuery(
                query.where(
                        builder.equal(
                                query.from(this.entityClass)
                                        .get("id"), id)
                )).executeUpdate();

        flushAndClear();
    }

    private void flushAndClear() {

        // pulisci e sistema
        entityManager.flush();
        entityManager.clear();
    }
}
