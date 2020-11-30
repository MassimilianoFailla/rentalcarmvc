package com.massimiliano.webapp.dao.impl;

import com.massimiliano.webapp.dao.AbstractDao;
import com.massimiliano.webapp.dao.UtenteDao;
import com.massimiliano.webapp.entities.Utente;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

//    qui invece si svilupperanno le query
//    e questa invece sarà una repository

@Repository
public class UtenteDaoImpl extends AbstractDao<Utente, Integer> implements UtenteDao {


    public UtenteDaoImpl() {
    }

    @Override
    public List<Utente> selezionaUtenti() {
        return super.SelezionaTutti();
    }


    @Override
    public Utente selezionaById(int id) {

        Utente retVal;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Utente> queryDef = cb.createQuery(Utente.class);

        // utilizzo il Root
        Root<Utente> recordSet = queryDef.from(Utente.class);

        queryDef.select(recordSet).where(cb.equal(recordSet.get("id"), id));

        retVal = entityManager.createQuery(queryDef).getSingleResult();

        entityManager.clear();

        return retVal;
    }

    @Override
    public void Salva(Utente utente) {
        super.Inserisci(utente);
    }

    @Override
    public void Aggiorna(Utente utente) {
        super.Aggiorna(utente);
    }

    @Override
    public void Elimina(Utente utente) {
        super.Elimina(utente);
    }

    @Override
    public Utente validate(String username, String password) {

        Utente utente = null;
        Transaction tranaction = null;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Utente> queryDef = cb.createQuery(Utente.class);

        // utilizzo il Root
        Root<Utente> recordSet = queryDef.from(Utente.class);

        queryDef.select(recordSet).where(cb.equal(recordSet.get("username"), username));

        utente = entityManager.createQuery(queryDef).getSingleResult();

        if (utente != null && utente.getPassword().equals(password)) {
            return utente;
        }

        tranaction.commit();

        entityManager.clear();

        return null;
    }

    @Override
    public List<Utente> selezionaUtentiByRole(String role) {

        List<Utente> listaUtenti;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Utente> queryDef = cb.createQuery(Utente.class);

        // utilizzo il Root
        Root<Utente> recordSet = queryDef.from(Utente.class);

        // equivalente di SELECT u FROM UTENTE.u WHERE u.role : role
        queryDef.select(recordSet).where(cb.equal(recordSet.get("role"), role));

        listaUtenti = entityManager.createQuery(queryDef).getResultList();

        entityManager.clear();

        return listaUtenti;
    }

    @Override
    public List<Utente> trovaPerNome(String nome) {

        List<Utente> listaUtenti;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Utente> queryDef = cb.createQuery(Utente.class);

        // utilizzo il Root
        Root<Utente> recordSet = queryDef.from(Utente.class);

        // equivalente di SELECT u FROM UTENTE.u WHERE u.nome : nome
        queryDef.select(recordSet).where(cb.equal(recordSet.get("nome"), nome));

        listaUtenti = entityManager.createQuery(queryDef).getResultList();

        entityManager.clear();

        return listaUtenti;
    }

    @Override
    public List<Utente> trovaPerCognome(String cognome) {

        List<Utente> listaUtenti;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Utente> queryDef = cb.createQuery(Utente.class);

        // utilizzo il Root
        Root<Utente> recordSet = queryDef.from(Utente.class);

        // equivalente di SELECT u FROM UTENTE.u WHERE u.cognome : cognome
        queryDef.select(recordSet).where(cb.equal(recordSet.get("cognome"), cognome));

        listaUtenti = entityManager.createQuery(queryDef).getResultList();

        entityManager.clear();

        return listaUtenti;
    }

    @Override
    public Utente trovaPerEmail(String email) {

        Utente utente;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Utente> queryDef = cb.createQuery(Utente.class);

        // utilizzo il Root
        Root<Utente> recordSet = queryDef.from(Utente.class);

        // equivalente di SELECT u FROM UTENTE.u WHERE u.email : email ORDER BY ...
        queryDef.select(recordSet).where(cb.equal(recordSet.get("email"), email));

        utente = entityManager.createQuery(queryDef).getSingleResult();

        entityManager.clear();

        return utente;

    }

    @Override
    public List<Utente> trovaPerAnnoNascita(Date annoNascita) {
        List<Utente> listaUtenti;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Utente> queryDef = cb.createQuery(Utente.class);

        // utilizzo il Root
        Root<Utente> recordSet = queryDef.from(Utente.class);

        // equivalente di SELECT u FROM UTENTE.u WHERE u.annoNascita : annoNascita
        queryDef.select(recordSet).where(cb.equal(recordSet.get("annoNascita"), annoNascita));

        listaUtenti = entityManager.createQuery(queryDef).getResultList();

        entityManager.clear();

        return listaUtenti;
    }

    @Override
    public Utente trovaPerPassword(String password) {

        Utente utente;

        // utilizzo il criteria Builders per le query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Utente> queryDef = cb.createQuery(Utente.class);

        // utilizzo il Root
        Root<Utente> recordSet = queryDef.from(Utente.class);

        // equivalente di SELECT u FROM UTENTE.u WHERE u.password : password ORDER BY ...
        queryDef.select(recordSet).where(cb.equal(recordSet.get("password"), password));

        utente = entityManager.createQuery(queryDef).getSingleResult();

        entityManager.clear();

        return utente;
    }

}
