package isel.sisinf.jpa.Mappers;

import dai.IMapper;
import isel.sisinf.jpa.DataScope;
import isel.sisinf.model.clientereserva;
import isel.sisinf.model.clientereservaId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperClienteReserva implements IMapper<clientereserva, clientereservaId> {
    @Override
    public void create (clientereserva x)throws Exception{
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            em.persist(x);
            ds.validateWork();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public clientereserva read(clientereservaId id) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            clientereserva a =  em.find(clientereserva.class, id, LockModeType.PESSIMISTIC_READ );

            ds.validateWork();
            return a;

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    public void update(clientereserva x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();

            clientereserva a =  em.find(clientereserva.class, x.getReserva(), LockModeType.PESSIMISTIC_READ );
            if (a == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            a.setReserva(x.getReserva());
            a.setLoja(x.getLoja());
            a.setCliente(x.getCliente());
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(clientereserva x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            clientereserva a = em.find(clientereserva.class, x,LockModeType.PESSIMISTIC_WRITE );
            if (a == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(a);
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
