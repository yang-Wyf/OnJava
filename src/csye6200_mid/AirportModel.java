package csye6200_mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * STUDENT SKELETON
 * 100 TOTAL POINTS AirportModel MidTerm
 *
 * Complete the following class (code fragment) to model an airport USE ONLY INNER-CLASSES and INNER INTERFACES.
 *
 * YOU Object Oriented DESIGN MUST INCLUDE:
 *
 * interface AirportAPI for abstractly getting airport ID, Name and Description
 * interface FlightAPI for abstractly getting flight ID, Origin, DepartureTime, Destination and ArrivalTime
 * interface AirCraftAPI for abstractly getting aircraft ID, Name, Description, Weight, MaxWeight, PassengerCount, PassengerMaxCount
 * interface AirCraftFactoryAPI for abstractly creating aircraft objects
 *
 * Complete the public static void demo() method:
 *
 * 20 POINTS:
 * design and create airports derived from AbstractAirportDataModel class:
 *
 * Logan ID=2 (AirportAPI object creation abstracted with an Enum Singleton factory)
 * LaGuardia ID=3 (AirportAPI object creation abstracted with a Lazy Singleton factory)
 * NOTE: each airport has it's own flights (airport class had flight inner classes)
 *
 * 30 POINTS:
 * add aircrafts to EACH airport IN THIS EXACT ORDER:
 * NOTE: each of the following aircraft is an AirCraftAPI object, derived from AirCraftBase and created abstractly with a Singleton factory
 *
 * NAME					Passenger Count [MAX Count] Weight 		[MAX Weight]
 * Cessna 172 airplane 	4 				[4] 		1500.0 		[4000.0]
 * Boeing 737 Jet 		168 			[200] 		129000.0 	[129000.0]
 * Boeing 747 Jet 		400 			[400] 		775000.0 	[775000.0]
 *
 * 10 POINTS:
 * sort Logan aircrafts BY NAME (alphabetical order using anonymous inner class)
 *
 * 10 POINTS:
 * sort LaGuardia aircrafts BY MAX Passenger Count using lambda (largest capacity first)
 *
 * 20 POINTS:
 * Design IN EACH AIRPORT FlightAPI flight inner classes (inner to each airport)
 * derived from GIVEN BaseFlightData class
 * and CREATE flight objects to be used in demo() to simulate departing flights.
 *
 * NOTE:
 * These Flight objects will be scheduled for departure flights by the code
 * already in demo() method.
 * demo() code already adds these departed flights:
 * 	STUDENT MUST CREATE INNER FLIGHT CLASSES IN EACH AIRPORT
 * 	STUDENT MUST DESIGN Airport with methods to conform to demo() code
 *  STUDENT MUST USE the following flights information (ID, etc.):
 *
 * Logan flights:
 Flight # 110 TO: BMI FROM: BOS AT: 0700 ARRIVING AT: 1840
 Flight # 120 TO: DCA FROM: BOS AT: 0600 ARRIVING AT: 0730
 Flight # 150 TO: RIC FROM: BOS AT: 0500 ARRIVING AT: 0730
 Flight # 130 TO: JFK FROM: BOS AT: 0600 ARRIVING AT: 0700
 *
 * LaGuardia flights:
 Flight # 160 TO: BMI FROM: LGA AT: 0500 ARRIVING AT: 0640
 Flight # 120 TO: DCA FROM: LGA AT: 0530 ARRIVING AT: 0700
 Flight # 130 TO: MHT FROM: LGA AT: 1000 ARRIVING AT: 1100
 Flight # 140 TO: RIC FROM: LGA AT: 0500 ARRIVING AT: 0630
 *
 * 10 POINTS:
 * add airports to airport model, SORT BY NAME and show model state.
 *
 * @author dgpeters
 *
 */
public class AirportModel {
    private final static int MAJOR;
    private final static int MINOR;
    private final static String REVISION;
    /**
     * GIVEN: Airport Codes and Names
     */
    private final static String BALTIMORE_CODE = "BMI";
    private final static String BALTIMORE_NAME = "Baltimore/Washington International Airport";
    private final static String BARBADOS_CODE = "BGI";
    private final static String BARBADOS_NAME = "Grantley Adams International Airport Barbados WI";
    private final static String BOSTON_CODE = "BOS";
    private final static String BOSTON_NAME = "Boston Logan International Airport";
    private final static String KENNEDY_CODE = "JFK";
    private final static String KENNEDY_NAME = "John F. Kennedy International Airport";
    private final static String LAGUARDIA_CODE = "LGA";
    private final static String LAGUARDIA_NAME = "LarGuardia Airport";
    private final static String MANCHESTER_CODE = "MHT";
    private final static String MANCHESTER_NAME = "Manchester-Boston Regional Airport";
    private final static String MONTEGO_BAY_CODE = "MBJ";
    private final static String MONTEGO_BAY_NAME = "Sangster International Airport Montego Bay Jamaica";
    private final static String ORLANDO_CODE = "MCO";
    private final static String ORLANDO_NAME = "Orlando International Airport";
    private final static String RICHMOND_CODE = "RIC";
    private final static String RICHMOND_NAME = "Richmond International Airport";
    private final static String REAGAN_CODE = "DCA";
    private final static String REAGAN_NAME = "Ronald Reagan Washington National Airport";
    static {
        MAJOR = 11;
        MINOR = 7;
        REVISION = MAJOR + "." + MINOR + "." + 6;
    }
    private List<AirportAPI> airportList;	// airports in model
    {
        airportList = new ArrayList<AirportAPI>();
    }
    /**
     * ** STUDENT TODO:
     * add airport to model
     * @param 	airport	airport to add
     * @return	AirportModel object
     */
    public AirportModel add(AirportAPI airport) {
        /* STUDENT TODO:*/
    }
    /**
     * ** STUDENT TODO:
     * sort all airports in model
     * @param 	c Comparator for sort Airports in model
     * @return	AirportModel object
     */
    public AirportModel sort(/*** STUDENT TODO:*/) {
        /** STUDENT TODO:*/
    }
    /**
     * return a String representation of the airport object model state
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.airportList.size()).append(" total airports in model.").append("\n");
        for (AirportAPI airport : this.airportList) {
            sb.append(airport).append("\n");
        }
        return sb.toString();
    }

    /**
     * AirportAPI interface is API implemented by each airport class
     */
    private interface AirportAPI {
        int getId();		// airport ID
        String getCode();	// airport code
        String getName();	// airport name
        /**
         * getFlight get a pre-configured airport flight to a specific destination airport
         *
         * @param airportCode 		flight destination (airport code)
         * @return					airport flight object
         */
        FlightAPI getFlight(String airportCode);
        /**
         * addScheduledToDeparteFlight add airport flight to airport's list of scheduled to depart flights
         *
         * @param flight			flight object
         * @return					airport object
         */
        AirportAPI addScheduledToDeparteFlight(FlightAPI flight);
        AirportAPI add(AirCraftAPI airCraft);
        void sort(Comparator<AirCraftAPI> c);
    }
    /**
     * FlightAPI interface API for all flight objects
     */
    private interface FlightAPI {
        int getId();
        String getOrigin();
        String getDepartureTime();
        String getDestination();
        String getArrivalTime();
    }
    /**
     * AirCraftAPI interface is API implemented by each flying vehicle approved to land at airport
     */
    private interface AirCraftAPI {
        int getId();
        String getName();
        String getDescription();
        double getWeight();
        double getMaxWeight();
        int getPassengerCount();
        int getMaxPassengerCount();
    }
    /**
     * AirCraftFactoryAPI interface is API implemented by each factory creating a flying vehicle approved to land at airport
     */
    private interface AirCraftFactoryAPI {
        AirCraftAPI getObject();
    }
    /**
     * ** STUDENT TODO:
     *
     * BaseFlightData class is super class for all flight classes
     */
    private static class BaseFlightData  /** STUDENT TODO:*/ {
        private int id;
        private String origin;
        private String departureTime;
        private String destination;
        private String arrivalTime;


        /** STUDENT TODO:*/


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Flight # ");

            sb.append(this.id);
            sb.append(" TO: ").append(this.destination);
            sb.append(" DEPARTING: ").append(this.origin);
            sb.append(" AT: ").append(departureTime);
            sb.append(" SCHEDULED ARRIVAL AT: ").append(this.arrivalTime);

            return sb.toString();
        }
    }

    /**
     * ** STUDENT TODO:
     * AbstractAirportDataModel is super class for all airport classes
     */
    private static abstract class AbstractAirportDataModel /*** STUDENT TODO:*/ {
        private int id;
        private String code;
        private String name;


        /*** STUDENT TODO:*/


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("Airport ID # ").append(id);
            sb.append(" ").append(code);
            sb.append(" ").append(name);
            sb.append("\n");

            if (null == airCraftList) {
                sb.append("no airCrafts available");
            } else {
                sb.append(airCraftList.size()).append(" aircrafts listed.").append("\n");
                for (AirCraftAPI a : airCraftList) {
                    sb.append(a).append("\n");
                }
            }
            sb.append("\n");

            if (null == departedFlightList) {
                sb.append("no flights scheduled to depart");
            } else {
                sb.append(departedFlightList.size()).append(" total flights scheduled to depart.").append("\n");
                for (FlightAPI flight : departedFlightList) {
                    sb.append(" ").append(flight).append("\n");
                }
            }

            return sb.toString();
        }
    }
    /**
     * ** STUDENT TODO:
     * LoganAirport class models flights departing Boston's Logan airport
     */
    private static class LoganAirport extends AbstractAirportDataModel {

        /*** STUDENT TODO:*/


        /**
         * ** STUDENT TODO:
         *
         * STUDENT MUST IMPLEMENT INNER FLIGHT CLASSES
         */

        /*** STUDENT TODO:*/


    }	// end class LoganAirport

    /**
     * ** STUDENT TODO:
     * LoganAirportEnumSingletonFactory enum
     */
    private enum LoganAirportEnumSingletonFactory {
        /*** STUDENT TODO:*/
    }

    /**
     * ** STUDENT TODO:
     * LaGuadiaAirport class models flights departing LarGuardia Airport
     */
    private static class LaGuadiaAirport extends AbstractAirportDataModel {

        /*** STUDENT TODO:*/

        /**
         * ** STUDENT TODO:
         * Student MUST IMPLEMENT INNER FLIGHT CLASSES
         */


        /*** STUDENT TODO:*/



    }	// end class LaGuadiaAirport
    /**
     * ** STUDENT TODO **
     *
     */
    private class LaGuardiaAirportLazySingletonFactory {
        /*** STUDENT TODO:*/
    }


    /**
     * ** STUDENT TODO **
     *
     * AirCraft class models an airport approved flying machine
     */
    private static class AirCraft /*** STUDENT TODO:*/ {
        private int id;
        private String name;
        private int passengerCount;
        private int maxPassengerCount;
        private double weight;
        private double maxWeight;
        private String description;


        /*** STUDENT TODO:*/


        @Override
        public String toString() {
            // "ID Name PassengerCount [MAX] Weight [MAX] Description"
            String sFmt = "# %d %s %3d [%3d] %6.1f [%6.1f] Lbs \'%s\'";
            return String.format(sFmt, id, name, passengerCount, maxPassengerCount, weight, maxWeight, description);
        }
    }

    /**
     * ** STUDENT TODO
     *
     * create aircrafts
     *
     * NAME					Passenger Count [MAX Count] Weight 		[MAX Weight]
     * Cessna 172 airplane 	4 				[4] 		1500.0 		[4000.0]
     * Boeing 737 Jet 		168 			[200] 		129000.0 	[129000.0]
     * Boeing 747 Jet 		400 			[400] 		775000.0 	[775000.0]
     */

    /**
     * Boeing737AirCraft class
     */
    private static class Boeing737AirCraft /*** STUDENT TODO:*/ {

        /*** STUDENT TODO:*/

    }
    /**
     * ** STUDENT TODO:
     * Boeing737AirCraftFactory class
     */
    private static class Boeing737AirCraftFactory /*** STUDENT TODO:*/ {

        /*** STUDENT TODO:*/
    }
    /**
     * ** STUDENT TODO:
     * enum Boeing737AirCraftFactoryEnumSingleton
     */
    private enum Boeing737AirCraftFactoryEnumSingleton {

        /*** STUDENT TODO:*/

    }
    /**
     * Boeing747AirCraft class
     */
    private static class Boeing747AirCraft /*** STUDENT TODO:*/{

        /*** STUDENT TODO:*/

    }
    /**
     * ** STUDENT TODO:
     * Boeing747AirCraftFactory class
     */
    private static class Boeing747AirCraftFactory /*** STUDENT TODO:*/{

        /*** STUDENT TODO:*/

    }
    /**
     * ** STUDENT TODO:
     * Boeing747AirCraftFactoryEnumSingleton enum
     */
    private enum Boeing747AirCraftFactoryEnumSingleton {
/*** STUDENT TODO:*/

    }
    /**
     * ** STUDENT TODO:
     * Cessna172AirCraft class
     */
    private static class Cessna172AirCraft /*** STUDENT TODO:*/ {

        /*** STUDENT TODO:*/

    }
    /**
     * ** STUDENT TODO:
     * Cessna172AirCraftFactory class
     */
    private static class Cessna172AirCraftFactory /*** STUDENT TODO:*/ {

        /*** STUDENT TODO:*/

    }
    /**
     * ** STUDENT TODO:
     * Boeing747AirCraftFactoryEnumSingleton enum
     */
    private enum Cessna172AirCraftFactoryEnumSingleton {

        /*** STUDENT TODO:*/

    }

    /**
     * ** STUDENT TODO:
     *
     * complete this code fragment by ADDING where specified (** STUDENT TODO:)
     * to demonstrate the use of this AirportModel class
     *
     * NOTE: altering any of the following code present results in 15 point deduction
     *
     */
    public static void demo() {
        System.out.println("\n\t" + AirportModel.class.getName() + ".demo() version [" + REVISION + "]...");
        AirportModel model = new AirportModel();
        System.out.println(model);	// show empty model

        /**
         * create airports
         * adding airCrafts to airports
         */
        System.out.println("add airCrafts to Logan airport IN ORDER: Cessna 172, Boeing 747 & Boeing 737 ...");
        AirportAPI logan = LoganAirportEnumSingletonFactory.INSTANCE.get()
                .add(Cessna172AirCraftFactoryEnumSingleton.INSTANCE.get().getObject())
                .add(Boeing747AirCraftFactoryEnumSingleton.INSTANCE.get().getObject())
                .add(Boeing737AirCraftFactoryEnumSingleton.INSTANCE.get().getObject());

        System.out.println("add airCrafts to LaGuardia airport IN ORDER: Cessna 172, Boeing 747 & Boeing 737 ...");
        AirportAPI laGuardia = LaGuardiaAirportLazySingletonFactory.getInstance()
                .add(Cessna172AirCraftFactoryEnumSingleton.INSTANCE.get().getObject())
                .add(Boeing747AirCraftFactoryEnumSingleton.INSTANCE.get().getObject())
                .add(Boeing737AirCraftFactoryEnumSingleton.INSTANCE.get().getObject());

        /**
         * add pre-configured airport flights
         * to airport list of flights scheduled to depart
         */
        System.out.println("add flights scheduled to depart Logan...");
        logan
                .addScheduledToDeparteFlight(logan.getFlight(BALTIMORE_CODE))
                .addScheduledToDeparteFlight(logan.getFlight(REAGAN_CODE))
                .addScheduledToDeparteFlight(logan.getFlight(RICHMOND_CODE))
                .addScheduledToDeparteFlight(logan.getFlight(KENNEDY_CODE));


        System.out.println("add flights scheduled to depart LaGuardia...");
        laGuardia
                .addScheduledToDeparteFlight(laGuardia.getFlight(BALTIMORE_CODE))
                .addScheduledToDeparteFlight(laGuardia.getFlight(REAGAN_CODE))
                .addScheduledToDeparteFlight(laGuardia.getFlight(MANCHESTER_CODE))
                .addScheduledToDeparteFlight(laGuardia.getFlight(RICHMOND_CODE));

        /**
         * add airports to model
         */
        System.out.println("add airports to model...\n");
        model
                .add(laGuardia)
                .add(logan);

        /**
         * ** STUDENT TODO:
         *
         * sort Logan airCraft BY NAME using anonymous inner class
         */
        System.out.println("use Lambda to SORT Logan airport airCrafts BY NAME...");


        /**
         * ** STUDENT TODO:
         *
         * use Lambda sort LaGuardia airCraft by MAX PASSENGER COUNT (largest capacity first)
         */
        System.out.println("use Lambda to SORT laGuardia airport airCrafts BY MAX PASSENGER COUNT (LARGEST FIRST)...");



        /**
         * ** STUDENT TODO:
         *
         * sort airports in model BY NAME
         */

        System.out.println(model);	// show configured model

        System.out.println("\t" + AirportModel.class.getName() + ".demo() version [" + REVISION + "]... done!");
    }	// end demo()
}
