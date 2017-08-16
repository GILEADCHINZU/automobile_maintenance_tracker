package pojos;

import java.util.HashMap;
import java.util.Map;

public enum MaintenanceType {

    OIL_CHANGE("Oil Change"), TIRE_ROTATION("Tire Rotation");
    public final String representation;
    
    MaintenanceType(String representation){
        this.representation = representation;
    }

    public static Map<String, String> getMaintenanceTypesAsMap(){
        Map<String, String> maintenanceTypeHashMap = new HashMap<>();
        for(MaintenanceType maintenanceType : MaintenanceType.values()){
            maintenanceTypeHashMap.put(maintenanceType.toString(), maintenanceType.representation);

        }
        return maintenanceTypeHashMap;
    }
}
