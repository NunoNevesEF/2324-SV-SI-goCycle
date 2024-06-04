package isel.sisinf.jpa.Mappers;

import dai.IMapper;
import isel.sisinf.jpa.DataScope;
import isel.sisinf.model.reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperReserva implements IMapper<reserva, Integer> {
    @Override
    public void create (reserva x)throws Exception{
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            em.persist(x);
            ds.validateWork();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public reserva read(Integer id) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            reserva a =  em.find(reserva.class, id, LockModeType.PESSIMISTIC_READ );

            ds.validateWork();
            return a;

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    public void update(reserva x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();

            reserva a =  em.find(reserva.class, x.getNumero(), LockModeType.PESSIMISTIC_READ );
            if (a == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            a.setNumero(x.getNumero());
            a.setDtinicio(x.getDtinicio());
            a.setDtfim(x.getDtfim());
            a.setValor(x.getValor());
            a.setBicicleta(x.getBicicleta());
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(reserva x) throws Exception {
        try (DataScope ds = new DataScope())
        {
            EntityManager em = ds.getEntityManager();
            em.flush();
            reserva a = em.find(reserva.class, x.getNumero(),LockModeType.PESSIMISTIC_WRITE );
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