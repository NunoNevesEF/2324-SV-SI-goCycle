package isel.sisinf.jpa.Repositories;

import dai.IRepository;
import isel.sisinf.jpa.Mappers.MapperDispositivo;
import isel.sisinf.model.dispositivo;
import jakarta.persistence.EntityManager;
import isel.sisinf.jpa.DataScope;

import java.util.List;


public class RepositoryDispositivo implements IRepository<dispositivo, Integer> {


    public List<dispositivo> getAll() throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            List<dispositivo> l = em.createQuery("select a from dispositivo a", dispositivo.class).getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }


    public dispositivo find(Integer Id) throws Exception {
        MapperDispositivo m = new MapperDispositivo();

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


    public void create(dispositivo a) throws Exception {
        MapperDispositivo m = new MapperDispositivo();

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



    public void update(dispositivo a) throws Exception {
        MapperDispositivo m = new MapperDispositivo();

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

    public void delete(dispositivo a) throws Exception {
        MapperDispositivo m = new MapperDispositivo();
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
