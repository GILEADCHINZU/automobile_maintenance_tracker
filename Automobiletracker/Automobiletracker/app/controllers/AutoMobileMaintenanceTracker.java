package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import pojos.MaintenanceType;
import pojos.Task;
import pojos.VehicleType;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoMobileMaintenanceTracker extends Controller {

    public static List<Task> taskList = new ArrayList<>();
    private FormFactory formFactory;
    private static Long currentIndex = 0L;

    @Inject
    public AutoMobileMaintenanceTracker(FormFactory formFactory){
        this.formFactory = formFactory;
    }

    public Result index(){
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("taskList", taskList);
        return ok(views.html.index.render(modelMap));
    }

    public Result addTaskForm(){
        Map<String, Object> modelMap = new HashMap<>();
        Form<Task> taskForm = formFactory.form(Task.class);
        modelMap.put("taskForm", taskForm);
        modelMap.put("vehicleTypes", VehicleType.getVehicleTypesAsMap());
        modelMap.put("maintenanceTypes", MaintenanceType.getMaintenanceTypesAsMap());
        return ok(views.html.task_form.render(modelMap));
    }

    public Result add(){
        Map<String, Object> modelMap = new HashMap<>();
        Form<Task> taskForm = formFactory.form(Task.class).bindFromRequest();
        if(taskForm.hasErrors()){
            modelMap.put("vehicleTypes", VehicleType.getVehicleTypesAsMap());
            modelMap.put("maintenanceTypes", MaintenanceType.getMaintenanceTypesAsMap());
            modelMap.put("taskForm", taskForm);
            return badRequest(views.html.task_form.render(modelMap));
        }
        Task task = taskForm.get();
        ++currentIndex;
        task.id = currentIndex;
        taskList.add(task);
        return redirect(routes.AutoMobileMaintenanceTracker.index());
    }


    public Result remove(long taskId){
        Task requestedTask = null;
        for(Task t : taskList){
            if(t.id == taskId){
                requestedTask = t;
            }
        }
        taskList.remove(requestedTask);
        return redirect(routes.AutoMobileMaintenanceTracker.index());
    }

    public Result editTaskForm(long taskId){
        Map<String, Object> modelMap = new HashMap<>();
        Task task = null;
        for(Task t : taskList){
            if(t.id == taskId){
                task = t;
            }
        }
        Form<Task> taskForm = formFactory.form(Task.class);
        taskForm = taskForm.fill(task);
        modelMap.put("vehicleTypes", VehicleType.getVehicleTypesAsMap());
        modelMap.put("maintenanceTypes", MaintenanceType.getMaintenanceTypesAsMap());
        modelMap.put("taskForm", taskForm);
        return ok(views.html.task_form.render(modelMap));
    }

    public Result update(){
        Map<String, Object> modelMap = new HashMap<>();
        Form<Task> taskForm = formFactory.form(Task.class).bindFromRequest();
        if(taskForm.hasErrors()){
            modelMap.put("vehicleTypes", VehicleType.getVehicleTypesAsMap());
            modelMap.put("maintenanceTypes", MaintenanceType.getMaintenanceTypesAsMap());
            modelMap.put("taskForm", taskForm);
            return badRequest(views.html.task_form.render(modelMap));
        }
        Task task = taskForm.get();
        Task taskInList  = null;
        for(Task t : taskList){
            if(task.id == t.id){
               taskInList = t;
            }
        }
        taskList.remove(taskInList);
        taskList.add(task);
        return redirect(routes.AutoMobileMaintenanceTracker.index());
    }

}
