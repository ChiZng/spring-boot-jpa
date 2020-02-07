package com.zchi.qhdfldemo.dynamicquery;

import java.util.List;

/**
 * @description: 扩展SpringDataJpa, 支持动态jpql/nativesql查询并支持分页查询
 * 使用方法： 注入ServiceImpl
 * @author: zchi
 * @create: 2020-02-07
 */
public interface DynamicQuery {

    public void save(Object dataModel);

    public void update(Object dataModel);

    public <T> void delete(Class<T> dataModelClass, Object dataModelId);

    public <T> void delete(Class<T> dataModelClass, Object[] dataModelIds);

    /**
     * 查询对象列表，返回List
     * @param nativeSql
     * @param params
     * @param <T>
     * @return List<T>
     */
    <T> List<T> nativeQueryList(String nativeSql, Object... params);

    /**
     * 查询对象列表，返回List<Map<key,value>>
     * @param nativeSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> nativeQueryListMap(String nativeSql,Object... params);

    /**
     * 查询对象列表，返回List<组合对象>
     * @param resultClass
     * @param nativeSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> nativeQueryListModel(Class<T> resultClass, String nativeSql, Object... params);
}
