package control;

import java.util.HashMap;

public class CommandMap {
    
    private HashMap<String, Command> commandMap = new HashMap<>();
    
    public CommandMap(){
    }
    
    public void add(String trigger, Command command) {
        commandMap.put(trigger, command);
    }
    
    public Command get(String trigger) {
        return commandMap.get(trigger);
    }

}
