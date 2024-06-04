package isel.sisinf.jpa.Repositories;

import dai.IRepository;
import isel.sisinf.jpa.Mappers.MapperReserva;
import isel.sisinf.model.reserva;
import jakarta.persistence.EntityManager;
import isel.sisinf.jpa.DataScope;

import java.util.List;


public class RepositoryReserva implements IRepository<reserva, Integer> {


    public List<reserva> getAll() throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            List<reserva> l = em.createQuery("select a from reserva a", reserva.class).getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }


    public reserva find(Integer Id) throws Exception {
        MapperReserva m = new MapperReserva();

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


    public void create(reserva a) throws Exception {
        MapperReserva m = new MapperReserva();

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



    public void update(reserva a) throws Exception {
        MapperReserva m = new MapperReserva();

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

    public void delete(reserva a) throws Exception {
        MapperReserva m = new MapperReserva();
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
