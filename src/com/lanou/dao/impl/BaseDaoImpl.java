package com.lanou.dao.impl;

import com.lanou.dao.BaseDao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public class BaseDaoImpl<T> implements BaseDao<T>{
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    /**
     * 查询所有
     * @param hql 查询语句
     * @return 返回结果集
     */
    @Override
    public List<T> findAll(String hql) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<T> tList = query.list();
        transaction.commit();
        return tList; // 返回查询结果
    }

    /**
     *  条件查询
     * @param hql 查询语句
     * @param params 查询语句的参数列表
     * @return 返回结果集
     */
    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        // 设置参数列表
        if (params != null && !params.isEmpty()){
            // 遍历参数
            for (String key : params.keySet()) {
                // 设置查询语句中的key域value
                query.setParameter(key,params.get(key));
            }
        }
        List<T> tList = query.list();
        transaction.commit();
        return tList; //返回结果集
    }

    /**
     * 条件查询
     * @param hql 查询语句
     * @param params 查询语句的参数列表
     * @return 返回单个对象
     */
    @Override
    public T findSingle(String hql, Map<String, Object> params) {
        List<T> tList = find(hql, params); // 调用条件查询
        if (tList.size() > 0){
            return tList.get(0); //返回查询结果集的第一个对象
        }
        return null; // 查询结果为空时返回null
    }

    /**
     * 条件查询
     * @param id 要查询的主键id
     * @param tClass 返回对象的类声明
     * @return 返回单个对象
     */
    @Override
    public T findById(Serializable id, Class<T> tClass) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        // 根据主键id查询某个对象
        T t = session.get(tClass, id);
        transaction.commit();
        return t;
    }

    @Override
    public void save(T t) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        // 根据主键id查询某个对象
        session.save(t);
        transaction.commit();

    }


}
