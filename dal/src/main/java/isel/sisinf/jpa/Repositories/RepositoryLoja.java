package isel.sisinf.jpa.Repositories;

import dai.IRepository;
import isel.sisinf.jpa.Mappers.MapperLoja;
import isel.sisinf.model.loja;
import jakarta.persistence.EntityManager;
import isel.sisinf.jpa.DataScope;

import java.util.List;


public class RepositoryLoja implements IRepository<loja, Integer> {


    public List<loja> getAll() throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            List<loja> l = em.createQuery("select a from loja a", loja.class).getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }


    public loja find(Integer Id) throws Exception {
        MapperLoja m = new MapperLoja();

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


    public void create(loja a) throws Exception {
        MapperLoja m = new MapperLoja();

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



    public void update(loja a) throws Exception {
        MapperLoja m = new MapperLoja();

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

    public void delete(loja a) throws Exception {
        MapperLoja m = new MapperLoja();
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
