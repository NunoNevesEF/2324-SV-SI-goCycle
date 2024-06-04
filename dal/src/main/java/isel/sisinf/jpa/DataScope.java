package isel.sisinf.jpa;

import isel.sisinf.jpa.Mappers.*;
import isel.sisinf.jpa.Repositories.*;
import isel.sisinf.model.*;

import java.util.List;

public class DataScope extends AbstractDataScope implements AutoCloseable {
    public DataScope() {
        super();
    }


    public List<bicicleta> getAllBicicleta() throws Exception {
        return new RepositoryBicicleta().getAll();
    }

    public bicicleta findBicicleta(Integer id) throws Exception {
        return new MapperBicicleta().read(id);
    }

    public void insertBicicleta(bicicleta bicicleta) throws Exception {
        new MapperBicicleta().create(bicicleta);
    }

    public void updateBicicleta(bicicleta bicicleta) throws Exception {
        new MapperBicicleta().update(bicicleta);
    }

    public void deleteBicicleta(bicicleta bicicleta) throws Exception {
        new MapperBicicleta().delete(bicicleta);
    }

    /*__________________________________________________*/

    public List<clientereserva> getAllClienteReserva() throws Exception {
        return new RepositoryClienteReserva().getAll();
    }

    public clientereserva findClienteReserva(clientereservaId id) throws Exception {
        return new MapperClienteReserva().read(id);
    }

    public void insertClienteReserva(clientereserva clientereserva) throws Exception {
        new MapperClienteReserva().create(clientereserva);
    }

    public void updateClienteReserva(clientereserva clientereserva) throws Exception {
        new MapperClienteReserva().update(clientereserva);
    }

    public void deleteClienteReserva(clientereserva clientereserva) throws Exception {
        new MapperClienteReserva().delete(clientereserva);
    }

    /*__________________________________________________*/

    public List<dispositivo> getAllDispositivo() throws Exception {
        return new RepositoryDispositivo().getAll();
    }

    public dispositivo findDispositivo(Integer id) throws Exception {
        return new MapperDispositivo().read(id);
    }

    public void insertDispositivo(dispositivo dispositivo) throws Exception {
        new MapperDispositivo().create(dispositivo);
    }

    public void updateDispositivo(dispositivo dispositivo) throws Exception {
        new MapperDispositivo().update(dispositivo);
    }

    public void deleteDispositivo(dispositivo dispositivo) throws Exception {
        new MapperDispositivo().delete(dispositivo);
    }

    /*__________________________________________________*/

    public List<loja> getAllLoja() throws Exception {
        return new RepositoryLoja().getAll();
    }

    public loja findLoja(Integer id) throws Exception {
        return new MapperLoja().read(id);
    }

    public void insertLoja(loja loja) throws Exception {
        new MapperLoja().create(loja);
    }

    public void updateLoja(loja loja) throws Exception {
        new MapperLoja().update(loja);
    }

    public void deleteLoja(loja loja) throws Exception {
        new MapperLoja().delete(loja);
    }

    /*__________________________________________________*/

    public List<pessoa> getAllPessoa() throws Exception {
        return new RepositoryPessoa().getAll();
    }

    public pessoa findPessoa(Integer id) throws Exception {
        return new MapperPessoa().read(id);
    }

    public void insertPessoa(pessoa pessoa) throws Exception {
        new MapperPessoa().create(pessoa);
    }

    public void updatePessoa(pessoa pessoa) throws Exception {
        new MapperPessoa().update(pessoa);
    }

    public void deletePessoa(pessoa pessoa) throws Exception {
        new MapperPessoa().delete(pessoa);
    }

    /*__________________________________________________*/

    public List<reserva> getAllReserva() throws Exception {
        return new RepositoryReserva().getAll();
    }

    public reserva findReserva(Integer id) throws Exception {
        return new MapperReserva().read(id);
    }

    public void insertReserva(reserva reserva) throws Exception {
        new MapperReserva().create(reserva);
    }

    public void updateReserva(reserva reserva) throws Exception {
        new MapperReserva().update(reserva);
    }

    public void deleteReserva(reserva reserva) throws Exception {
        new MapperReserva().delete(reserva);
    }
}
