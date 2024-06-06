package isel.sisinf.jpa.Mappers;

import dai.IMapper;
import isel.sisinf.jpa.DataScope;
import isel.sisinf.model.loja;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperLoja implements IMapper<loja, Integer> {
    @Override
    public void create (loja x)throws Exception{
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            em.persist(x);
            em.flush();
            ds.validateWork();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public loja read(Integer id) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            loja a =  em.find(loja.class, id, LockModeType.PESSIMISTIC_READ );

            ds.validateWork();
            return a;

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    public void update(loja x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();

            loja a =  em.find(loja.class, x.getCodigo(), LockModeType.PESSIMISTIC_READ );
            if (a == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            a.setCodigo(x.getCodigo());
            a.setTelefone(x.getTelefone());
            a.setEmail(x.getEmail());
            a.setEndereco(x.getEndereco());
            a.setLocalidade(x.getLocalidade());
            a.setGestor(x.getGestor());
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(loja x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            loja a = em.find(loja.class, x.getCodigo(),LockModeType.PESSIMISTIC_WRITE );
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
