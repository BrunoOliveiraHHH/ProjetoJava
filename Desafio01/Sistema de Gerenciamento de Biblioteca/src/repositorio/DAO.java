package repositorio;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface DAO<PersistentObject, IDType extends Serializable> {
	void update(PersistentObject obj);

	void insert(PersistentObject obj);

	void remove(PersistentObject obj);

	PersistentObject get(IDType id);

	List<PersistentObject> listByNamedQuery(String queryName, Map<String, Object> params);

	PersistentObject getByNamedQuery(String queryName, Map<String, Object> params);

	void flush();
}
