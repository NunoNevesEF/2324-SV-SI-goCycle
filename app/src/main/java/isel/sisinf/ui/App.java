/*
MIT License

Copyright (c) 2024, Nuno Datia, Matilde Pato, ISEL

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package isel.sisinf.ui;

import isel.sisinf.jpa.DataScope;
import isel.sisinf.model.BicicletaInfo;
import isel.sisinf.model.ReservaInfo;
import isel.sisinf.model.pessoa;
import isel.sisinf.model.reserva;
import jakarta.persistence.EntityManager;
import isel.sisinf.jpa.Utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;

interface DbWorker
{
    void doWork();
}
class UI
{
    private enum Option
    {
        // DO NOT CHANGE ANYTHING!
        Unknown,
        Exit,
        createCostumer,
        listExistingBikes,
        checkBikeAvailability,
        obtainBookings,
        makeBooking,
        cancelBooking,
        about
    }

    private static UI __instance = null;
    private HashMap<Option,DbWorker> __dbMethods;
    private Scanner scanner;  // Add a single Scanner instance

    private UI()
    {
        // DO NOT CHANGE ANYTHING!
        __dbMethods = new HashMap<Option,DbWorker>();
        __dbMethods.put(Option.createCostumer, () -> UI.this.createCostumer());
        __dbMethods.put(Option.listExistingBikes, () -> UI.this.listExistingBikes());
        __dbMethods.put(Option.checkBikeAvailability, () -> UI.this.checkBikeAvailability());
        __dbMethods.put(Option.obtainBookings, new DbWorker() {public void doWork() {UI.this.obtainBookings();}});
        __dbMethods.put(Option.makeBooking, new DbWorker() {public void doWork() {UI.this.makeBooking();}});
        __dbMethods.put(Option.cancelBooking, new DbWorker() {public void doWork() {UI.this.cancelBooking();}});
        __dbMethods.put(Option.about, new DbWorker() {public void doWork() {UI.this.about();}});

        scanner = new Scanner(System.in);  // Initialize the Scanner
    }

    // ADDED CODE TO UI CLASS HERE
    private String __connectionString;
    public String getConnectionString()
    {
        return __connectionString;
    }
    public void setConnectionString(String s)
    {
        __connectionString = s;
    }
    // END OF ADDED CODE TO UI CLASS

    public static UI getInstance()
    {
        // DO NOT CHANGE ANYTHING!
        if(__instance == null)
        {
            __instance = new UI();
        }
        return __instance;
    }

    private Option DisplayMenu()
    {
        Option option = Option.Unknown;
        try
        {
            // DO NOT CHANGE ANYTHING!
            System.out.println("Bicycle reservation");
            System.out.println();
            System.out.println("1. Exit");
            System.out.println("2. Create Costumer");
            System.out.println("3. List Existing Bikes");
            System.out.println("4. Check Bike Availability");
            System.out.println("5. Current Bookings");
            System.out.println("6. Make a booking");
            System.out.println("7. Cancel Booking");
            System.out.println("8. About");
            System.out.print(">");
            int result = scanner.nextInt();
            option = Option.values()[result];
        }
        catch(RuntimeException ex)
        {
            //nothing to do.
        }
        return option;
    }

    private static void clearConsole() throws Exception
    {
        // DO NOT CHANGE ANYTHING!
        for (int y = 0; y < 25; y++) //console is 80 columns and 25 lines
            System.out.println("\n");
    }

    public void Run() throws Exception
    {
        // DO NOT CHANGE ANYTHING!
        Option userInput;
        do
        {
            clearConsole();
            userInput = DisplayMenu();
            clearConsole();
            try
            {
                __dbMethods.get(userInput).doWork();
                System.in.read();
            }
            catch(NullPointerException ex)
            {
                //Nothing to do. The option was not a valid one. Read another.
            }

        }while(userInput!=Option.Exit);
    }

    /**
     To implement from this point forward. Do not need to change the code above.
     -------------------------------------------------------------------------------
     IMPORTANT:
     --- DO NOT MOVE IN THE CODE ABOVE. JUST HAVE TO IMPLEMENT THE METHODS BELOW ---
     --- Other Methods and properties can be added to support implementation -------
     -------------------------------------------------------------------------------

     */

    private static final int TAB_SIZE = 24;

    private void createCostumer() {
        System.out.println("createCostumer()");
        System.out.println("Please write the params below in the same order");
        System.out.println("nome,telefone,morada,cc,email,nacionalidade");


        String[] params = Utils.getUserInputWithNoSpaces();

        if (params.length != 6) {
            System.out.println("Error: Invalid number of parameters. Please provide all parameters separated by commas.");
        } else {
            pessoa pessoa = new pessoa();

            String nome = params[0].trim();
            int telefone = Integer.parseInt(params[1].trim());
            String morada = params[2].trim();
            int cc = Integer.parseInt(params[3].trim());
            String email = params[4].trim();
            String nacionalidade = params[5].trim();

            pessoa.setNome(nome);
            pessoa.setTelefone(telefone);
            pessoa.setMorada(morada);
            pessoa.setCC(cc);
            pessoa.setEmail(email);
            pessoa.setNacionalidade(nacionalidade);

            try (DataScope ds = new DataScope()) {
                Utils.createCustomer(pessoa);
                ds.validateWork();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("Customer was created.");
        }
    }

    private void listExistingBikes()
    {
        System.out.println("listExistingBikes()");
        try (DataScope ds = new DataScope()) {
            List<BicicletaInfo> displayInfo =  Utils.listExistingBikes();
            ds.validateWork();
            if(displayInfo.isEmpty()) {
                System.out.println("There are no existing bikes.");
            } else {
                System.out.println("---------------/-------------");
                System.out.println("The existing Bikes are the following ->");
                for (BicicletaInfo info : displayInfo) {
                    System.out.println(info.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void checkBikeAvailability()
    {
        System.out.println("checkBikeAvailability()");
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            List<BicicletaInfo> displayInfo =  Utils.checkBikeAvailability(em);
            ds.validateWork();
            if(displayInfo.isEmpty()) {
                System.out.println("There are no bikes available.");
            } else {
                System.out.println("---------------/-------------");
                System.out.println("The available bikes are the following ->");
                for (BicicletaInfo info : displayInfo) {
                    System.out.println(info.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void obtainBookings() {
        System.out.println("obtainBookings()");
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            List<ReservaInfo> displayInfo =  Utils.obtainBookings(em);
            ds.validateWork();
            if(displayInfo.isEmpty()) {
                System.out.println("Currently there are no bookings.");
            } else {
                System.out.println("---------------/-------------");
                System.out.println("The current bookings are the following ->");
                for (ReservaInfo info : displayInfo) {
                    System.out.println(info.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void makeBooking() {
        // 2025-12-12/21:21:21,2026-12-12/21:21:21,65.00,1 USAR PARA TESTES
        System.out.println("makeBooking()");
        System.out.println("Please write the params below in the same order");
        System.out.println("dtinicio,dtfim,valor,bicicleta");
        System.out.println("examples of date ->YYYY-MM-DD/HH:MM:SS");

        String line = scanner.next().replace("/", " "); // trocar pois não pode haver espaços

        String[] params = line.split(",");

        if (params.length != 4) {
            System.out.println("Error: Invalid number of parameters. Please provide all parameters separated by commas.");
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            BigDecimal valor = new BigDecimal(params[2].trim());
            int bicicleta = Integer.parseInt(params[3].trim());

            try (DataScope ds = new DataScope()) {
                Timestamp dtinicio = new Timestamp(dateFormat.parse(params[0].trim()).getTime());
                Timestamp dtfim = new Timestamp(dateFormat.parse(params[1].trim()).getTime());

                reserva reserva = new reserva();
                reserva.setDtinicio(dtinicio);
                reserva.setDtfim(dtfim);
                reserva.setValor(valor);
                reserva.setBicicletaId(bicicleta);

                Utils.makeBooking(reserva);
                ds.validateWork();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("Booking was made.");
        }
    }


    // FALTA DAR UPDATE NA BICICLETA PARA O ESTADO LIVRE
    private void cancelBooking()
    {
        System.out.println("cancelBooking");
        System.out.println("Please write the id of the booking you want to cancel.");

        String[] params = Utils.getUserInputWithNoSpaces();

        if (params.length != 1) {
            System.out.println("Error: Invalid number of parameters. Please provide all parameters separated by commas.");
        } else {
            try (DataScope ds = new DataScope()) {
                int id = Integer.parseInt(params[0].trim());
                EntityManager em = ds.getEntityManager();
                Utils.cancelBooking(id, em);
                ds.validateWork();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("Booking was cancelled.");
        }

    }

    private void about()
    {
        System.out.println("Group ID: G16T42D");
        System.out.println("--------------- /Members/ ---------------");
        System.out.println("Eduardo Ramos");
        System.out.println("Gonçalo Carvalho");
        System.out.println("Nuno Neves");
        System.out.println("-----------------------------------------");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        //String url = "jdbc:postgresql://sisinfvlab1.dyn.fil.isel.pt:5432/?user=G16T42D&password=G16T42D&ssl=false";
        String url = "jdbc:postgresql://localhost:5432/?user=postgres&password=postgres&ssl=false";
        UI.getInstance().setConnectionString(url);
        UI.getInstance().Run();
    }
}
