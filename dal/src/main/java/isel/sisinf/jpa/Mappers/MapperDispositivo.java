package isel.sisinf.jpa.Mappers;

import dai.IMapper;
import isel.sisinf.jpa.DataScope;
import isel.sisinf.model.dispositivo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperDispositivo implements IMapper<dispositivo, Integer> {
    @Override
    public void create (dispositivo x)throws Exception{
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


    public dispositivo read(Integer id) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            dispositivo a =  em.find(dispositivo.class, id, LockModeType.PESSIMISTIC_READ );

            ds.validateWork();
            return a;

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    public void update(dispositivo x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();

            dispositivo a =  em.find(dispositivo.class, x.getNoserie(), LockModeType.PESSIMISTIC_READ );
            if (a == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            a.setNoserie(x.getNoserie());
            a.setBateria(x.getBateria());
            a.setLatitude(x.getLatitude());
            a.setLongitude(x.getLongitude());
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(dispositivo x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            dispositivo a = em.find(dispositivo.class, x.getNoserie(),LockModeType.PESSIMISTIC_WRITE );
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
