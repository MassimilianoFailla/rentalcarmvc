package com.massimiliano.webapp.dao.impl;

import com.massimiliano.webapp.dao.AbstractDao;
import com.massimiliano.webapp.dao.PrenotazioneDao;
import com.massimiliano.webapp.entities.Prenotazione;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

//      qui si svilupperanno le query in criteria o in JSPQL
@Repository
public class PrenotazioneDaoImpl extends AbstractDao<Prenotazione, Integer> implements PrenotazioneDao {

    @Override
    public void Salva(Prenotazione prenotazione) {
        super.Inserisci(prenotazione);
    }

    @Override
    public void Aggiorna(Prenotazione prenotazione) {
        super.Aggiorna(prenotazione);
    }

    @Override
    public void Elimina(Prenotazione prenotazione) {
        super.Elimina(prenotazione);
    }

    @Override
    public Prenotazione trovaPrenotazionePerId(int id) {

        Prenotazione prenotazione;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Prenotazione> queryDef = cb.createQuery(Prenotazione.class);

        // utilizzo il Root
        Root<Prenotazione> recordSet = queryDef.from(Prenotazione.class);

        // equivalente di SELECT u FROM PRENOTAZIONE.u WHERE u.id : id ORDER BY ...
        queryDef.select(recordSet).where(cb.equal(recordSet.get("id"), id));

        prenotazione = entityManager.createQuery(queryDef).getSingleResult();

        entityManager.clear();

        return prenotazione;
    }

    @Override
    public List<Prenotazione> trovaPrenotazioniPerId(int id) {

        List<Prenotazione> listaPrenotazioni;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Prenotazione> queryDef = cb.createQuery(Prenotazione.class);

        // utilizzo il Root
        Root<Prenotazione> recordSet = queryDef.from(Prenotazione.class);

        // equivalente di SELECT u FROM PRENOTAZIONE.u WHERE u.id : id ORDER BY ...
        queryDef.select(recordSet).where(cb.equal(recordSet.get("id"), id));

        listaPrenotazioni = entityManager.createQuery(queryDef).getResultList();

        entityManager.clear();

        return listaPrenotazioni;
    }

    @Override
    public List<Prenotazione> selezionaPrenotazioni() {
        return super.SelezionaTutti();
    }
}
