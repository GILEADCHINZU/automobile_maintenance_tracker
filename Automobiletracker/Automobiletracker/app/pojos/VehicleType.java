package pojos;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by toletdeveloper2 on 6/29/17.
 */
public enum VehicleType {

    GAS("Gas"), ELECTRIC("Electric"), DIESEL("Diesel");
    public final String representation;

    VehicleType(String representation){
        this.representation = representation;
    }

    public static Map<String, String> getVehicleTypesAsMap(){
        Map<String, String> vehicleTypeMap = new HashMap<>();
        for(VehicleType maintenanceType : VehicleType.values()){
            vehicleTypeMap.put(maintenanceType.toString(), maintenanceType.representation);

        }
        return vehicleTypeMap;
    }
}
