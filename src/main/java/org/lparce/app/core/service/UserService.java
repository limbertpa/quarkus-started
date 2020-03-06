package org.lparce.app.core.service;


import org.lparce.app.core.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    EntityManager em;

    @Transactional
    public void createUser(String name) {
        User user = new User();
        user.setName(name);
        this.em.persist(user);
    }

    @Transactional
    public User addUser(User user) {
        if (user != null) {
            em.persist(user);
        }
        return user;
    }

    public List<User> getUsers() {
        return this.em.createNativeQuery("select * from users", User.class).getResultList();
    }

    public List<User> list() {
        CriteriaQuery<User> query = em.getCriteriaBuilder().createQuery(User.class);
        TypedQuery<User> allQuery = em.createQuery(query.select(query.from(User.class)));
        return allQuery.getResultList();
    }

    @Transactional
    public void delete(String id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaDelete<User> deleteQuery = criteriaBuilder.createCriteriaDelete(User.class);
        Root<User> root = deleteQuery.from(User.class);
        deleteQuery.where(criteriaBuilder.equal(root.get("id"), id));
        em.createQuery(deleteQuery).executeUpdate();
    }
}
