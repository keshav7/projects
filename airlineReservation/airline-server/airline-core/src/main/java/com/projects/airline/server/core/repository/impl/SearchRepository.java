package com.projects.airline.server.core.repository.impl;

import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
public class SearchRepository {

    @Autowired
    @PersistenceContext
    @Getter
    public EntityManager entityManager;

    public <T> List<T> find(final Integer firstResult, final Integer maxResults, final String queryStr, final Map<String, ?> params) throws AirlineException {
        try {
            Query query = entityManager.createQuery(queryStr);
            for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
                query.setParameter(param.getKey(), param.getValue());
            }

            log.info("Query params = {}", params);
            log.info("Query = {}", queryStr);
            if (firstResult != null) {
                query.setFirstResult(firstResult);
            }
            if (maxResults != null) {
                query.setMaxResults(maxResults);
            }

            final List<T> result = (List) query.getResultList();
            return ((result != null) ? result : Collections.EMPTY_LIST);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    public Long getCount(final String queryStr, final Map<String, ?> params) throws AirlineException {
        try {
            Query query = entityManager.createQuery(queryStr);

            for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
                query.setParameter(param.getKey(), param.getValue());
            }

            log.info("Query params = {}", params);
            log.info("Query = {}", queryStr);
            final Long result = (Long) query.getSingleResult();
            return ((result != null) ? result : 0);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
