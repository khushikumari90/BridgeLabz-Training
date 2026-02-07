package unit_conversion_tool;
interface UnitConverter {

    // Convert kilometers to miles
    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    // Convert kilograms to pounds
    static double kgToPounds(double kg) {
        return kg * 2.20462;
    }
}
