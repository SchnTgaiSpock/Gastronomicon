package io.github.schntgaispock.gastronomicon.core.setup;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.command.SDCommandExecutor;
import io.github.schntgaispock.gastronomicon.core.command.SDTabCompleter;

/**
 * Does all the necessary prep work for commands to work
 */
public class CommandSetup {
    
    public static void setup() {
        
        Gastronomicon.getInstance().getCommand("strophodungeons").setExecutor(new SDCommandExecutor());
        Gastronomicon.getInstance().getCommand("strophodungeons").setTabCompleter(new SDTabCompleter());

    }

}
