package isel.sisinf.jpa.Mappers;

import dai.IMapper;
import isel.sisinf.model.bicicleta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import isel.sisinf.jpa.DataScope;


public class MapperBicicleta implements IMapper<bicicleta, Integer> {
    @Override
    public void create (bicicleta x)throws Exception{
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


    public bicicleta read(Integer id) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            bicicleta a =  em.find(bicicleta.class, id, LockModeType.PESSIMISTIC_READ );

            ds.validateWork();
            return a;

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    public void update(bicicleta x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();

            bicicleta a =  em.find(bicicleta.class, x.getId(), LockModeType.PESSIMISTIC_READ );
            if (a == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            a.setId(x.getId());
            a.setModelo(x.getModelo());
            a.setPeso(x.getPeso());
            a.setMarca(x.getMarca());
            a.setEstado(x.getEstado());
            a.setSisMudancas(x.getSisMudancas());
            a.setAtrDisc(x.getAtrDisc());
            a.setVelMax(x.getVelMax());
            a.setAutonomia(x.getAutonomia());
            a.setGps(x.getGps());
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(bicicleta x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            bicicleta a = em.find(bicicleta.class, x.getId(),LockModeType.PESSIMISTIC_WRITE );
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
