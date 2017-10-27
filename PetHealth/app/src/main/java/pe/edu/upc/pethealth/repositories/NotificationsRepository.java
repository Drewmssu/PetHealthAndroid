package pe.edu.upc.pethealth.repositories;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pethealth.models.Notification;

/**
 * Created by genob on 29/09/2017.
 */

public class NotificationsRepository {
    public static List<Notification> getNotifications(){
        List<Notification> notifications=new ArrayList<>();
        notifications.add(new Notification("Tittle 1","Vacuna en dos dias"));
        notifications.add(new Notification("Tittle 2","Desparasitacion en dos dias"));
        notifications.add(new Notification("Tittle 3","Corte en dos dias"));
        notifications.add(new Notification("Tittle 4","Vacuna en dos dias"));
        notifications.add(new Notification("Tittle 5","Control en dos dias"));
        notifications.add(new Notification("Tittle 6","Vacuna en dos dias"));
        notifications.add(new Notification("Tittle 7","Vacuna en dos dias"));
        notifications.add(new Notification("Tittle 8","Vacuna en dos dias"));
        notifications.add(new Notification("Tittle 9","Vacuna en dos dias"));
        notifications.add(new Notification("Tittle 10","Vacuna en dos dias"));
        notifications.add(new Notification("Tittle 11","Vacuna en dos dias"));
        notifications.add(new Notification("Tittle 12","Vacuna en dos dias"));
        return notifications;
    }
}
