package dai;

public interface IMapper<Table,TableId> {
    void create(Table e) throws Exception;

    Table read(TableId id) throws Exception;

    void update(Table e) throws Exception;

    void delete(Table e) throws Exception;
}
