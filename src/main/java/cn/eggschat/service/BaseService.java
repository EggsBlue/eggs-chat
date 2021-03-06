package cn.eggschat.service;

import org.nutz.dao.Chain;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.FieldFilter;
import org.nutz.dao.entity.Record;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    Dao dao();

    int count(Condition cnd);

    int count();

    int count(String tableName, Condition cnd);

    int count(String tableName);

    T fetch(long id);

    T fetch(String id);

    <T> T fetchLinks(T obj, String regex);

    <T> T fetchLinks(T obj, String regex, Condition cnd);

    T fetch(Condition cnd);

    T fetchx(Object... pks);

    boolean exists(Object... pks);

    <T> T insert(T obj);

    <T> T insert(T obj, FieldFilter filter);

    <T> T insertOrUpdate(T obj);

    <T> T insertOrUpdate(T obj, FieldFilter insertFieldFilter, FieldFilter updateFieldFilter);

    void insert(String tableName, Chain chain);

    <T> T fastInsert(T obj);

    <T> T insertWith(T obj, String regex);

    <T> T insertLinks(T obj, String regex);

    <T> T insertRelation(T obj, String regex);

    int update(Object obj);

    int updateIgnoreNull(Object obj);

    int update(Chain chain, Condition cnd);

    int update(String tableName, Chain chain, Condition cnd);

    <T> T updateWith(T obj, String regex);

    <T> T updateLinks(T obj, String regex);

    int updateRelation(Class<?> classOfT, String regex, Chain chain, Condition cnd);

    int updateWithVersion(Object obj);

    int updateWithVersion(Object obj, FieldFilter filter);

    int updateAndIncrIfMatch(Object obj, FieldFilter fieldFilter, String fieldName);

    int getMaxId();

    int delete(long id);

    int delete(int id);

    int delete(String id);

    void delete(Integer[] ids);

    void delete(Long[] ids);

    void delete(String[] ids);

    int clear();

    int clear(String tableName);

    int clear(Condition cnd);

    int clear(String tableName, Condition cnd);

    int vDelete(String id);

    int vDelete(String[] ids);

    T getField(String fieldName, long id);

    T getField(String fieldName, int id);

    T getField(String fieldName, String name);

    T getField(String fieldName, Condition cnd);

    List<T> query(String fieldName, Condition cnd);

    List<T> query(Condition cnd);

    List<T> query();

    List<T> query(Condition cnd, String linkName);

    List<T> query(String linkName);

    List<T> query(Condition cnd, String linkName, Pager pager);

    List<T> query(Condition cnd, Pager pager);

    int count(Sql sql);

    List<Record> list(Sql sql);

    Map getMap(Sql sql);
}
