package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.helpers.Helper;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

  @Autowired
  EntityManager entityManager;

  @Transactional
  public List<Whisky> findWhiskiesFromDistilleryAndAged(String distilleryName, int age) {
    List<Whisky> result = null;

    Session session = entityManager.unwrap(Session.class);

    distilleryName = Helper.capitalise(distilleryName);

    try {
      Criteria criteria = session.createCriteria(Whisky.class);
      criteria.createAlias("distillery", "distilleryAlias");
      criteria.add(Restrictions.eq("distilleryAlias.name", distilleryName));
      criteria.add(Restrictions.eq("age", age));

      result = criteria.list();
    } catch (HibernateException ex) {
      ex.printStackTrace();
    }

    return result;
  }

  @Transactional
  public List<Whisky> findWhiskiesByRegion(String region) {
    List<Whisky> result = null;

    Session session = entityManager.unwrap(Session.class);

    region = Helper.capitalise(region);

    try {
      Criteria criteria = session.createCriteria(Whisky.class);
      criteria.createAlias("distillery", "distilleryAlias");
      criteria.add(Restrictions.eq("distilleryAlias.region", region));

      result = criteria.list();
    } catch (HibernateException ex) {
      ex.printStackTrace();
    }

    return result;
  }
}
