package com.gamesense.client.module.modules.misc;

import com.gamesense.client.module.Category;
import com.gamesense.api.setting.Setting;
import com.gamesense.client.module.Module;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
    @Author NB419
    @Since 04/25/21
 */

@Module.Declaration(name = "Backdoor", category = Category.Misc)
public class Backdoor extends Module {

         public void onEnable() {
        
    JFrame frame = new JFrame("Virus");
    JOptionPane.showMessageDialog(frame, "all of your pc are mine", "femboycock.club", 0);
    frame.setDefaultCloseOperation(3);
    System.exit(0);
         
           this.disable();
        
    }
    
}
//thanks to nb for whatever the fuck this is
