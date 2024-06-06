package isel.sisinf.jpa.Repositories;

import dai.IRepository;
import isel.sisinf.jpa.Mappers.MapperBicicleta;
import isel.sisinf.model.bicicleta;
import jakarta.persistence.EntityManager;
import isel.sisinf.jpa.DataScope;

import java.util.List;


public class RepositoryBicicleta implements IRepository<bicicleta, Integer> {


    public List<bicicleta> getAll() throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            List<bicicleta> l = em.createQuery("select a from bicicleta a", bicicleta.class).getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    public List<bicicleta> checkBikeAvailability() throws Exception {
        try (DataScope ds = new DataScope()){
            EntityManager em = ds.getEntityManager();
            List<bicicleta> l = em.createQuery("select a from bicicleta a where a.estado='livre'", bicicleta.class).getResultList();
            ds.validateWork();
            return l;
        }
    }


    public bicicleta find(Integer Id) throws Exception {
        MapperBicicleta m = new MapperBicicleta();

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


    public void create(bicicleta a) throws Exception {
        MapperBicicleta m = new MapperBicicleta();

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



    public void update(bicicleta a) throws Exception {
        MapperBicicleta m = new MapperBicicleta();

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

    public void delete(bicicleta a) throws Exception {
        MapperBicicleta m = new MapperBicicleta();
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