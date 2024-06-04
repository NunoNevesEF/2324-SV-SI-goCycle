package isel.sisinf.jpa.Repositories;

import dai.IRepository;
import isel.sisinf.jpa.Mappers.MapperPessoa;
import isel.sisinf.model.pessoa;
import jakarta.persistence.EntityManager;
import isel.sisinf.jpa.DataScope;

import java.util.List;


public class RepositoryPessoa implements IRepository<pessoa, Integer> {


    public List<pessoa> getAll() throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            List<pessoa> l = em.createQuery("select a from pessoa a", pessoa.class).getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }


    public pessoa find(Integer Id) throws Exception {
        MapperPessoa m = new MapperPessoa();

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


    public void create(pessoa a) throws Exception {
        MapperPessoa m = new MapperPessoa();

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



    public void update(pessoa a) throws Exception {
        MapperPessoa m = new MapperPessoa();

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

    public void delete(pessoa a) throws Exception {
        MapperPessoa m = new MapperPessoa();
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