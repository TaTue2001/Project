package com.example.Project.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.example.Project.Interface.Repository.IBaseRepository;

public class BaseRepository<T> implements IBaseRepository<T>, Serializable {
	@PersistenceContext
	private EntityManager entityManager;
//	private Class<T> entityClass;
//	@Override
//	public List<T> FindAll(Class entityClass) {
//		String Entity=entityClass.getName();
//		String query = "from " + Entity;
//		List<T> list = entityManager.createQuery(query).getResultList();
//		return list;
//	}
//
//	@Override
//	public T GetById(Class entityClass, String Id) {
//		try {
//			UUID ID = UUID.fromString(Id);
//			String Entity=entityClass.getName();
//			String fieldCode= Entity+"Id";
//			String queryString="SELECT e  FROM " + Entity + " e WHERE e." + Entity + "Id = :entityId";
//			TypedQuery<T> query = (TypedQuery<T>) entityManager.createQuery(queryString);
//	        query.setParameter("entityId",Id);
//	        List<T> result = query.getResultList();
//	        if(result.size() > 0){
//	            return result.get(0);
//	        }
//	        return null;
//
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//

//	@Override
//	public List<T> SortByField(Class entityClass, String field, int page, int pageSize) {
//		try {
//			String Entity = entityClass.getName();
//			String queryString = "SELECT e  FROM " + Entity + " e Order By e." + field + " ASC";
//			TypedQuery<T> query = (TypedQuery<T>) entityManager.createQuery(queryString);
//			query.setFirstResult((page - 1) * pageSize);
//			query.setMaxResults(pageSize);
//			List<T> result = query.getResultList();
//			return result;
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	@Override
	public T FindById(Class entityClass, String Id) {
		UUID ID = UUID.fromString(Id);
		return (T) entityManager.find(entityClass, ID);
	}

	@Transactional
	public int Delete(Class entityClass, String Id) {
		T t = FindById(entityClass, Id);
		if (t != null) {
			entityManager.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional
	public int Insert(T model) {
		entityManager.merge(model);
		return 1;
	}

	@Override
	@Transactional
	public int Update(Class entityClass, T model, String Id) {
		T t = FindById(entityClass, Id);
		if (t != null) {
			for (java.lang.reflect.Field field : model.getClass().getDeclaredFields()) {
				try {
					field.setAccessible(true);
					Object value = field.get(model);
					if (value != null) {
						field.set(t, value);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}

			return 1;
		}
		return 0;
	}

	@Override
	public List<T> Active(Class entityClass, String field, String value, int page, int pageSize) {
		try {
			String Entity = entityClass.getName();
			String queryString = "SELECT e FROM " + Entity + " e";
			if (!field.isEmpty() && !value.isEmpty()) {
				if ("sort".equals(value)) {
					queryString += " Order By e." + field + " ASC";
				} else {
					queryString += " WHERE e." + field + "= :value";
				}
			}
			TypedQuery<T> query = (TypedQuery<T>) entityManager.createQuery(queryString);
			if (!value.isEmpty() && !("sort".equals(value))) {
				if ((field.substring(field.length() - 2)).equals("Id")) {
					UUID Value = UUID.fromString(value);
					query.setParameter("value", Value);
				} else {
					query.setParameter("value", value);
				}
			}

			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
			List<T> result = query.getResultList();
			return result;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



}
