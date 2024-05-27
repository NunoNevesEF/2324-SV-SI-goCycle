package dai;

public interface IUnitOfWork {

    void notifyInsert(Object entity);

    void notifyUpdate(Object entity);

    void notifyDelete(Object entity);

    void commit();

    void rollback();
}
