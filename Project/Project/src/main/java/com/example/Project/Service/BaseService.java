package com.example.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.Project.Interface.Repository.IBaseRepository;
import com.example.Project.Interface.Service.IBaseService;

enum PageSize{
	small(30),
	medium(50),
	big(70);
	int rowOfPage;
	PageSize(int rowOfPage) {
		this.rowOfPage=rowOfPage;
	}
}
@Service
@Primary
public class BaseService<T> implements IBaseService<T> {
	@Autowired
	private IBaseRepository<T> repo;
	
	@Override
	public List<T> Sort(Class entityClass, String field, int page) {
		List<T> ResultOfSort=repo.Active(entityClass, field, "sort", page,PageSize.small.rowOfPage);
		return ResultOfSort;
	}

	@Override
	public List<T> Search(Class entityClass, String field, String value, int page) {
		List<T> resultOfSearch=repo.Active(entityClass, field, value, page,PageSize.small.rowOfPage);
		return resultOfSearch;
	}
	@Override
	public List<T> GetAll(Class entityClass, int page) {
		List<T> All=repo.Active(entityClass, "", "", page, PageSize.small.rowOfPage);
		return All;
	}
}
