package isel.sisinf.jpa.Mappers;

import dai.IMapper;
import isel.sisinf.jpa.DataScope;
import isel.sisinf.model.pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperPessoa implements IMapper<pessoa, Integer> {
    @Override
    public void create (pessoa x)throws Exception{
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();

            em.persist(x);
            em.flush();

            ds.validateWork();
            System.out.println(x + "+ created");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public pessoa read(Integer id) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            pessoa a =  em.find(pessoa.class, id, LockModeType.PESSIMISTIC_READ );

            ds.validateWork();
            return a;

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    public void update(pessoa x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();

            pessoa a =  em.find(pessoa.class, x.getId(), LockModeType.PESSIMISTIC_READ );
            if (a == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            a.setId(x.getId());
            a.setTelefone(x.getTelefone());
            a.setMorada(x.getMorada());
            a.setCC(x.getCc());
            a.setNome(x.getNome());
            a.setEmail(x.getEmail());
            a.setNacionalidade(x.getNacionalidade());
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(pessoa x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            pessoa a = em.find(pessoa.class, x.getId(),LockModeType.PESSIMISTIC_WRITE );
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
