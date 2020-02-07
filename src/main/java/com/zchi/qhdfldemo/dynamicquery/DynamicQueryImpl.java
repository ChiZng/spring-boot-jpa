package com.zchi.qhdfldemo.dynamicquery;

import lombok.Getter;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @description: 动态jpql/nativesql查询的实现类
 * @author: zchi
 * @create: 2020-02-07
 */
@Getter
@Repository
public class DynamicQueryImpl implements DynamicQuery {

    Logger logger = LoggerFactory.getLogger(DynamicQueryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Object dataModel) {
        em.persist(dataModel);
    }

    @Override
    public void update(Object dataModel) {
        em.merge(dataModel);
    }

    @Override
    public <T> void delete(Class<T> dataModelClass, Object dataModelId) {
        delete(dataModelClass, new Object[]{dataModelId});
    }

    @Override
    public <T> void delete(Class<T> dataModelClass, Object[] dataModelIds) {
        for (Object id : dataModelIds) {
            em.remove(em.getReference(dataModelClass, id));
        }

    }

    private Query createNativeQuery(String sql, Object... params) {
        Query q = em.createNativeQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i + 1, params[i]); // 与Hiberante不同,jpa
                // query从位置1开始
            }
        }
        return q;
    }

    @Override
    public <T> List<T> nativeQueryList(String nativeSql, Object... params) {
        Query q = createNativeQuery(nativeSql, params);
        q.unwrap(SQLQuery.class).setResultTransformer(Transformers.TO_LIST);
        return q.getResultList();
    }

    @Override
    public <T> List<T> nativeQueryListMap(String nativeSql, Object... params) {
        Query q = createNativeQuery(nativeSql, params);
        q.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return q.getResultList();
    }

    @Override
    public <T> List<T> nativeQueryListModel(Class<T> resultClass, String nativeSql, Object... params) {
        Query q = createNativeQuery(nativeSql, params);;
        q.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(resultClass));
        return q.getResultList();
    }
}
