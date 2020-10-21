package farm;

import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ServisFarmer {

    public static List<Farmer> getFarmerOlder(List<Farmer> farmerList, int age) {
        return farmerList.stream()
                .filter(p -> getAge(p.getBirthday()) > age)
                .collect(Collectors.toList());
    }

    public static List<Vegetable> getFarmerUseOrganic(List<Farmer> farmerList) {
        if (CollectionUtils.isEmpty(farmerList)) {
            return Collections.emptyList();
            //throw new IllegalArgumentException("Can't farmers");
        }
        return getFarmerOlder(farmerList, 50).stream()
                .filter(farmer -> farmer.getFertilizers().stream()
                        .allMatch(Fertilizer::isOrganic))
                .flatMap(p -> p.getVegetables().stream())
                .collect(Collectors.toList());
    }

    public static int getAge(Date bDate) {
        LocalDate now = LocalDate.now();
        LocalDate born = null;

        if (bDate == null) {
            throw new IllegalArgumentException("Can't be date");
        }

        born = bDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (born.isAfter(now)) {
            throw new IllegalArgumentException("Can't be born in the future");
        }
        return Period.between(born, now).getYears();
    }

    public static boolean isContainsOrganic(Farmer farmer) {
        return farmer.getFertilizers()
                .stream()
                .allMatch(Fertilizer::isOrganic);
    }
}

