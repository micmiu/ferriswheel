package com.micmiu.mvc.ferriswheel.orm.hibernate;


import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.SortType;
import com.micmiu.mvc.ferriswheel.core.service.BaseService;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 基本服务接口抽象实现类.
 *
 * @param <E>  实体类
 * @param <ID> 实体类ID类型
 * @author <a href="http://www.micmiu.com">Michael</a>
 */
@SuppressWarnings("unchecked")
public abstract class HibernateBaseService<E extends FerriswheelID, ID extends Serializable> implements BaseService<E, ID> {

	/**
	 * 实体Class.
	 */
	private final Class<E> clazz;

	/**
	 * 构造函数，确定实体类型.
	 */
	public HibernateBaseService() {
		this.clazz = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Hibernate Session Factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * DAO方法.
	 */

	/**
	 * 获取Hibernate Session.
	 *
	 * @return Hibernate Session
	 */
	protected Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 根据HQL生成Hibernate Query对象.
	 *
	 * @param hql    HQL
	 * @param values 查询属性
	 * @return Hibernate Query
	 */
	protected Query buildQuery(final String hql, final Object... values) {
		Query q = getSession().createQuery(hql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				q.setParameter(i, values[i]);
			}
		}
		return q;
	}

	/**
	 * 根据HQL生成Hibernate Query对象.
	 *
	 * @param hql      HQL
	 * @param paraMaps 查询属性
	 * @return Hibernate Query
	 */
	protected Query buildQuery(final String hql, final Map<String, Object> paraMaps) {
		Query q = getSession().createQuery(hql);
		if (paraMaps != null) {
			for (Entry<String, Object> entry : paraMaps.entrySet()) {
				if (entry.getValue() instanceof Collection) {
					q.setParameterList(entry.getKey(), (Collection<?>) entry.getValue());
				} else {
					q.setParameter(entry.getKey(), entry.getValue());
				}
			}
		}
		return q;
	}

	/**
	 * 生成Hibernate Criteria对象
	 *
	 * @return Hibernate Criteria
	 */
	protected Criteria buildCriteria() {
		return buildCriteria(null);
	}

	/**
	 * 按条件生成Hibernate Criteria对象
	 *
	 * @param propertyName 字段名
	 * @param value        字段值
	 * @return Hibernate Criteria
	 */
	@SuppressWarnings("serial")
	protected Criteria buildCriteria(final String propertyName,
									 final Object value) {
		return buildCriteria(new HashMap<String, Object>() {

			{
				put(propertyName, value);
			}
		});
	}

	/**
	 * 按条件生成Hibernate Criteria对象
	 *
	 * @param properties 查询属性
	 * @return Hibernate Criteria
	 */
	protected Criteria buildCriteria(Map<String, Object> properties) {
		return buildCriteria(properties, null);
	}

	/**
	 * 按条件生成Hibernate Criteria对象
	 *
	 * @param properties 查询属性
	 * @param orders     排序属性
	 * @return Hibernate Criteria
	 */
	protected Criteria buildCriteria(Map<String, Object> properties, Map<String, SortType> orders) {
		Criteria c = getSession().createCriteria(clazz);
		if (properties != null) {
			for (Entry<String, Object> entryProp : properties.entrySet()) {
				// 健壮性校验
				if (entryProp.getValue() != null) {
					handleProperty(c, entryProp.getKey(), entryProp.getValue());
				}
			}
		}
		if (orders != null) {
			for (Entry<String, SortType> entryOrder : orders.entrySet()) {
				Order o = handleOrder(entryOrder.getKey(),
						entryOrder.getValue());
				if (null != o) {
					c.addOrder(o);
				}
			}
		}
		return c;
	}

	/**
	 * 生成Hibernate排序对象.
	 *
	 * @param propertyName 字段名
	 * @param order        排序方式
	 * @return Hibernate Order
	 */
	protected Order handleOrder(String propertyName, SortType order) {
		if (SortType.ASC == order) {
			return Order.asc(propertyName);
		} else if (SortType.DESC == order) {
			return Order.desc(propertyName);
		} else {
			return null;
		}
	}

	/**
	 * 生成Hibernate查询条件对象. 各实现类针对所管理的实体对象，实现支持查询字段的处理逻辑.
	 *
	 * @param currentCriteria 当前Hibernate Criteria对象
	 * @param propertyName    字段名
	 * @param value           字段值
	 * @return Hibernate Criteria
	 */
	protected abstract Criteria handleProperty(Criteria currentCriteria, String propertyName, Object value);

	/**
	 * 创建实体对象.
	 *
	 * @param entity
	 */
	@Override
	public ID create(E entity) {
		return (ID) getSession().save(entity);
	}

	/**
	 * 更新实体对象.
	 *
	 * @param entity
	 */
	@Override
	public void update(E entity) {
		getSession().merge(entity);
	}

	/**
	 * 按ID删除实体对象.
	 *
	 * @param id
	 */
	@Override
	public void delete(ID id) {
		E e = find(id);
		if (null != e) {
			getSession().delete(e);
		}
	}

	/**
	 * 按ID批量删除实体对象.
	 *
	 * @param ids 实体id数组
	 */
	@Override
	public void delete(ID[] ids) {
		for (ID id : ids) {
			delete(id);
		}
	}

	/**
	 * 按ID返回实体对象.
	 *
	 * @param id
	 * @return T 按返回实体。
	 */
	@Override
	public E find(ID id) {
		return (E) getSession().get(clazz, id);
	}

	/**
	 * 按属性查找实体对象.
	 *
	 * @param propertyName 字段名
	 * @param value        字段值
	 * @return E 实体对象
	 */
	@Override
	public E find(String propertyName, Object value) {
		return (E) buildCriteria(propertyName, value).uniqueResult();
	}

	/**
	 * 查询所有对象实体.
	 *
	 * @return List<E> 所有对象实体
	 */
	@Override
	public List<E> queryAll() {
		return buildCriteria().list();
	}

	/**
	 * 按字段查找实体列表.
	 *
	 * @param propertyName 字段名
	 * @param value        字段值
	 * @return 实体列表
	 */
	@Override
	public List<E> query(String propertyName, Object value) {
		return buildCriteria(propertyName, value).list();
	}

	/**
	 * 按字段查找实体列表.
	 *
	 * @param properties 查询字段 <字段名,字段值>
	 * @return 实体列表
	 */
	@Override
	public List<E> query(Map<String, Object> properties) {
		return buildCriteria(properties).list();
	}

	/**
	 * 按字段查找实体列表.
	 *
	 * @param properties     查询字段 <字段名,字段值>
	 * @param sortProperties 排序字段 <字段名,DESC/ASC>
	 * @return 实体列表
	 */
	@Override
	public List<E> query(Map<String, Object> properties, Map<String, SortType> sortProperties) {
		return buildCriteria(properties, sortProperties).list();
	}

	/**
	 * 按字段查找实体列表.
	 *
	 * @param properties     查询字段 <字段名,字段值>
	 * @param sortProperties 排序字段 <字段名,DESC/ASC>
	 * @param start          记录开始数
	 * @param rows           查询记录数
	 * @return 实体列表
	 */
	@Override
	public List<E> query(Map<String, Object> properties, Map<String, SortType> sortProperties, int start, int rows) {
		return buildCriteria(properties, sortProperties).setFirstResult(start)
				.setMaxResults(rows).list();
	}

	/**
	 * 获取所有记录数.
	 *
	 * @return 所有记录数.
	 */
	@Override
	public Long countAll() {
		return (Long) buildCriteria().setProjection(Projections.rowCount()).uniqueResult();
	}

	/**
	 * 按条件获取记录数.
	 *
	 * @param properties 查询字段 <字段名,字段值>
	 * @return 记录数.
	 */
	@Override
	public Long count(Map<String, Object> properties) {
		return (Long) buildCriteria(properties).setProjection(Projections.rowCount()).uniqueResult();
	}

}