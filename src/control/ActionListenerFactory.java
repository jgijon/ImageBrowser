package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerFactory {

    
   CommandMap map;
   
   public ActionListenerFactory(CommandMap map){
       this.map = map;
   }
   
   public ActionListener createActionListener(final String trigger){
       return new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               Command command = map.get(trigger);
               if (command == null) return;
               command.execute();
           }
       };
   }
}
