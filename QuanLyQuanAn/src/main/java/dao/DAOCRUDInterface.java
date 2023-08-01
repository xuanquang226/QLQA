package dao;

public interface DAOCRUDInterface<T> {
	T get(long id);
	void put(T t, long id);
	void delete(long id);
	void post(T t);
}
