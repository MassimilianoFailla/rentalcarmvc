package com.massimiliano.webapp.dao.impl;

import com.massimiliano.webapp.dao.AbstractDao;
import com.massimiliano.webapp.dao.VeicoloDao;
import com.massimiliano.webapp.entities.Veicolo;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

//      qui si svilupperanno le query in criteria o in JSPQL

@Repository
public class VeicoloDaoImpl extends AbstractDao<Veicolo, Integer> implements VeicoloDao {


    @Override
    public void Salva(Veicolo veicolo) {
        super.Inserisci(veicolo);
    }

    @Override
    public void Aggiorna(Veicolo veicolo) {
        super.Aggiorna(veicolo);
    }

    @Override
    public void Elimina(Veicolo veicolo) {
        super.Elimina(veicolo);
    }

    @Override
    public Veicolo trovaById(int id) {

        Veicolo veicolo;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Veicolo> queryDef = cb.createQuery(Veicolo.class);

        // utilizzo il Root
        Root<Veicolo> recordSet = queryDef.from(Veicolo.class);

        // equivalente di SELECT u FROM VEICOLO.u WHERE u.id : id ORDER BY ...
        queryDef.select(recordSet).where(cb.equal(recordSet.get("id"), id));

        veicolo = entityManager.createQuery(queryDef).getSingleResult();

        entityManager.clear();

        return veicolo;
    }

    @Override
    public Veicolo trovaPerTarga(String targa) {
        Veicolo veicolo;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Veicolo> queryDef = cb.createQuery(Veicolo.class);

        // utilizzo il Root
        Root<Veicolo> recordSet = queryDef.from(Veicolo.class);

        // equivalente di SELECT u FROM VEICOLO.u WHERE u.targa : targa ORDER BY ...
        queryDef.select(recordSet).where(cb.equal(recordSet.get("targa"), targa));

        veicolo = entityManager.createQuery(queryDef).getSingleResult();

        entityManager.clear();

        return veicolo;
    }

    @Override
    public List<Veicolo> trovaMezzi() {

        return super.SelezionaTutti();
    }

    @Override
    public List<Veicolo> trovaPerModello(String modello) {

        List<Veicolo> listaVeicoli;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Veicolo> queryDef = cb.createQuery(Veicolo.class);

        // utilizzo il Root
        Root<Veicolo> recordSet = queryDef.from(Veicolo.class);

        // equivalente di SELECT u FROM VEICOLO.u WHERE u.modello : modello ORDER BY ...
        queryDef.select(recordSet).where(cb.equal(recordSet.get("modello"), modello));

        listaVeicoli = entityManager.createQuery(queryDef).getResultList();

        entityManager.clear();

        return listaVeicoli;
    }

    @Override
    public List<Veicolo> trovaPerCasaCostruttrice(String casaCostruttrice) {

        List<Veicolo> listaVeicoli;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Veicolo> queryDef = cb.createQuery(Veicolo.class);

        // utilizzo il Root
        Root<Veicolo> recordSet = queryDef.from(Veicolo.class);

        // equivalente di SELECT u FROM VEICOLO.u WHERE u.casaCostruttrice : casaCostruttrice ORDER BY ...
        queryDef.select(recordSet).where(cb.equal(recordSet.get("casaCostruttrice"), casaCostruttrice));

        listaVeicoli = entityManager.createQuery(queryDef).getResultList();

        entityManager.clear();

        return listaVeicoli;
    }

    @Override
    public List<Veicolo> trovaPerAnnoImmatricolazione(String annoImmatricolazione) {

        List<Veicolo> listaVeicoli;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Veicolo> queryDef = cb.createQuery(Veicolo.class);

        // utilizzo il Root
        Root<Veicolo> recordSet = queryDef.from(Veicolo.class);

        // equivalente di SELECT u FROM VEICOLO.u WHERE u.annoImmatricolazione : annoImmatricolazione ORDER BY ...
        queryDef.select(recordSet).where(cb.equal(recordSet.get("annoImmatricolazione"), annoImmatricolazione));

        listaVeicoli = entityManager.createQuery(queryDef).getResultList();

        entityManager.clear();

        return listaVeicoli;
    }
}