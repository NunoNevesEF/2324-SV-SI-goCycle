package isel.sisinf.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import isel.sisinf.model.*;
import jakarta.persistence.StoredProcedureQuery;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static class AppException extends Exception {
        public AppException(String ErrorMessage) {
            super(ErrorMessage);
        }
    }

    public static void createCustomer(String nome, Integer telefone, String morada, int cc, String email, String nacionalidade, EntityManager em) {
        Query query = em.createNativeQuery("INSERT INTO pessoa (nome, telefone, morada, cc, email, nacionalidade) VALUES (?1, ?2, ?3, ?4, ?5, ?6)");
        query.setParameter(1, nome);
        query.setParameter(2, telefone);
        query.setParameter(3, morada);
        query.setParameter(4, cc);
        query.setParameter(5, email);
        query.setParameter(6, nacionalidade);
        query.executeUpdate();
    }

    public static List<BicicletaInfo> listExistingBikes(EntityManager em) {
        Query query = em.createNativeQuery("SELECT * FROM bicicleta");
        List<Object[]> results = query.getResultList();

        List<BicicletaInfo> bicicletaInfo = new ArrayList<>();
        for (Object[] result : results) {
            Integer id = (Integer) result[0];
            String modelo = (String) result[1];
            double peso = (double) result[2];
            String marca = (String) result[3];
            String estado = (String) result[4];
            String sisMudancas = (String) result[5];
            char atrDisc = ((String) result[6]).charAt(0);
            Double velMax = (Double) result[7];
            Double autonomia = (Double) result[8];
            Integer gps = (Integer) result[9];

            BicicletaInfo bikeInfo = new BicicletaInfo(id, modelo, peso, marca, estado, sisMudancas, atrDisc, velMax, autonomia,gps);
            bicicletaInfo.add(bikeInfo);
        }

        return bicicletaInfo;
    }

    public static List<BicicletaInfo> checkBikeAvailability(EntityManager em){
        StoredProcedureQuery query = em.createStoredProcedureQuery("checkBikeAvailability");
        query.execute();
        List<Object[]> results = query.getResultList();

        List<BicicletaInfo> availableBikes = new ArrayList<>();

        for (Object[] result : results) {
            Integer id = (Integer) result[0];
            String modelo = (String) result[1];
            Double peso = (Double) result[2];
            String marca = (String) result[3];
            String estado = (String) result[4];
            String sisMudancas = (String) result[5];
            char atrDisc = ((String) result[6]).charAt(0);
            Double velMax = (Double) result[7];
            Double autonomia = (Double) result[8];
            Integer gps = (Integer) result[9];

            BicicletaInfo bikeInfo = new BicicletaInfo(id, modelo, peso, marca, estado, sisMudancas, atrDisc, velMax, autonomia, gps);
            availableBikes.add(bikeInfo);
        }
        return availableBikes;
    }

    public static List<ReservaInfo> obtainBookings(EntityManager em) {
        Query query = em.createNativeQuery("SELECT * FROM reserva");
        List<Object[]> results = query.getResultList();

        List<ReservaInfo> bookings = new ArrayList<>();
        for (Object[] result : results) {
            Integer numero = (Integer) result[0];
            String dtInicio = String.valueOf(result[1]);
            String dtFim = String.valueOf(result[2]);
            BigDecimal valor = convertMoneyToBigDecimal((Double) result[3]);
            Integer bicicletaId = (Integer) result[4];

            ReservaInfo reservaInfo = new ReservaInfo(numero, dtInicio, dtFim, valor, bicicletaId);
            bookings.add(reservaInfo);
        }
        return bookings;
    }

    public static void makeBooking(Integer bicicletaId, Timestamp dtInicio, Timestamp dtFim, BigDecimal valor, EntityManager em) {
        reserva reserva = new reserva();
        reserva.setBicicletaId(bicicletaId);
        reserva.setDtinicio(dtInicio);
        reserva.setDtfim(dtFim);
        reserva.setValor(valor);

        em.getTransaction().begin();
        em.persist(reserva);
        em.getTransaction().commit();
    }

    public static void cancelBooking(Integer reservaId,EntityManager em) {
        em.getTransaction().begin();

        reserva reserva = em.find(reserva.class, reservaId);
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não encontrada para o ID: " + reservaId);
        }

        em.remove(reserva);
        em.getTransaction().commit();
    }


    // READ USER INPUT
    public static String[] getUserInput() {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        System.out.println("line = " + line);

        return line.split(",");
    }

    private static BigDecimal convertMoneyToBigDecimal(Double moneyValue) {
        if (moneyValue != null) {
            return BigDecimal.valueOf(moneyValue).setScale(2);
        } else {
            return BigDecimal.ZERO;
        }
    }

}