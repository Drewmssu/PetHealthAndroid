package pe.edu.upc.pethealth.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by genob on 29/09/2017.
 */

public class ChatsRepository {
    public static List<Chat> getChats(){
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat(1,1,"Verinary 1","message"));
        chats.add(new Chat(1,2,"Verinary 2","message"));
        chats.add(new Chat(1,3,"Verinary 3","message"));
        chats.add(new Chat(1,4,"Verinary 4","message"));
        chats.add(new Chat(1,5,"Verinary 5","message"));
        chats.add(new Chat(1,6,"Verinary 6","message"));
        chats.add(new Chat(1,7,"Verinary 7","message"));
        chats.add(new Chat(1,8,"Verinary 8","message"));
        chats.add(new Chat(1,9,"Verinary 9","message"));
        return chats;
    }
}