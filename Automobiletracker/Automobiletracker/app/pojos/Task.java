package pojos;

import play.data.validation.Constraints;

import javax.annotation.Resource;

public class Task {

    public Long id;
    @Constraints.Required
    public String make;
    @Constraints.Required
    public String model;
    @Constraints.Required
    public String year;
    @Constraints.Required
    public String odometer;
    @Constraints.Required
    public VehicleType vehicleType;
    @Constraints.Required
    public MaintenanceType maintenanceType;
    
}
