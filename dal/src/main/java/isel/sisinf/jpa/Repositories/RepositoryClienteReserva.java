package isel.sisinf.jpa.Repositories;

import dai.IRepository;
import isel.sisinf.jpa.Mappers.MapperClienteReserva;
import isel.sisinf.model.clientereserva;
import isel.sisinf.model.clientereservaId;
import jakarta.persistence.EntityManager;
import isel.sisinf.jpa.DataScope;

import java.util.List;


public class RepositoryClienteReserva implements IRepository<clientereserva, clientereservaId> {


    public List<clientereserva> getAll() throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            List<clientereserva> l = em.createQuery("select a from clientereserva a", clientereserva.class).getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }


    public clientereserva find(clientereservaId Id) throws Exception {
        MapperClienteReserva m = new MapperClienteReserva();

        try
        {
            return m.read(Id);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }


    public void create(clientereserva a) throws Exception {
        MapperClienteReserva m = new MapperClienteReserva();

        try
        {
            m.create(a);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }



    public void update(clientereserva a) throws Exception {
        MapperClienteReserva m = new MapperClienteReserva();

        try
        {
            m.update(a);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    public void delete(clientereserva a) throws Exception {
        MapperClienteReserva m = new MapperClienteReserva();
        try
        {
            m.delete(a);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}