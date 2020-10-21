package farm;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class FarmMain {
    private static List<Vegetable> getVegetables1() {
        return Arrays.asList(
                new Vegetable(1, "Potatoes", 10),
                new Vegetable(2, "Tomatoes", 5),
                new Vegetable(3, "Cucumber", 8),
                new Vegetable(4, "Lemon", 4),
                new Vegetable(5, "Onion", 1));
    }

    private static List<Vegetable> getVegetables2() {
        return Arrays.asList(
                new Vegetable(6, "Potatoes2", 10),
                new Vegetable(7, "Tomatoes2", 5),
                new Vegetable(8, "Cucumber2", 8),
                new Vegetable(9, "Lemon2", 4),
                new Vegetable(10, "Onion2", 1));
    }

    private static List<Vegetable> getVegetables3() {
        return Arrays.asList(
                new Vegetable(11, "Potatoes3", 10),
                new Vegetable(12, "Tomatoes3", 5),
                new Vegetable(13, "Cucumber3", 8),
                new Vegetable(14, "Lemon3", 4),
                new Vegetable(15, "Onion3", 1));
    }

    private static List<Fertilizer> getFertilizers1() {
        return Arrays.asList(
                new Fertilizer(1, "Fertilizer1", true),
                new Fertilizer(2, "Fertilizer2", true),
                new Fertilizer(3, "Fertilizer3", false),
                new Fertilizer(4, "Fertilizer4", true),
                new Fertilizer(5, "Fertilizer5", false));
    }

    private static List<Fertilizer> getFertilizers2() {
        return Arrays.asList(
                new Fertilizer(6, "Fertilizer6", true),
                new Fertilizer(7, "Fertilizer7", true),
                new Fertilizer(8, "Fertilizer8", true));
    }

    private static List<Fertilizer> getFertilizers3() {
        return Arrays.asList(
                new Fertilizer(9, "Fertilizer9", true),
                new Fertilizer(10, "Fertilizer10", true),
                new Fertilizer(11, "Fertilizer11", true),
                new Fertilizer(12, "Fertilizer12", true),
                new Fertilizer());
    }

    private static List<Farmer> getFarmers() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();
        try {
            date1 = dateformat.parse("17/07/1920");
            date2 = dateformat.parse("15/10/1961");
            date3 = dateformat.parse("28/09/1948");
        } catch (ParseException e) {
        }
        return Arrays.asList(
                new Farmer(1, "Licence1", "Name1", "LastName1", date1, getVegetables1(), getFertilizers1()),
                new Farmer(2, "Licence2", "Name2", "LastName2", date2, getVegetables2(), getFertilizers2()),
                new Farmer(3, "Licence3", "Name3", "LastName3", date3, getVegetables3(), getFertilizers3()));
    }

    public static void main(String[] str) {
        ServisFarmer.getFarmerUseOrganic(getFarmers()).forEach(System.out::println);
        ObjectMapper mapper = new ObjectMapper();
        List<Farmer>farmers = null;

        try {
            //mapper.writeValue(new File("c:\\test\\farmer2.json"), getFarmers());

           farmers = mapper.readValue(new File("c:\\test\\farmer.json"), new TypeReference<List<Farmer>>() {});

            for (Farmer f: farmers) {
                System.out.println(f);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(strEq());
    }


    public static Map<String, Long> strEq() {
        String s = "The fly flies but the flies fly. fly the the";
        String[] str = s.split(" ");
        Map<String, Integer> strHash = new HashMap<>();

        Map<String, Long> collect = Arrays.stream(str).collect(Collectors.groupingBy(Function.identity(), counting()));

        for (String string : str) {
            if (strHash.get(string) == null) {
                strHash.put(string, 1);
            } else {
                strHash.put(string, strHash.get(string) + 1);
            }
        }
        return collect;
    }
}
