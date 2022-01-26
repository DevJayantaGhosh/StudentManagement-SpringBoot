package com.student.management.repository;

public interface GenericRepository {

	<T> T save(Object object);
	<T> T fetchById(Class<T> className, int id);
}
