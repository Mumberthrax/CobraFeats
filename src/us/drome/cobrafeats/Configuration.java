package us.drome.cobrafeats;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;

public class Configuration {
    private final CobraFeats plugin;
    
    public boolean SILK_TOUCH_SPAWNERS;
    public boolean AESTHETIC_COMMAND_BLOCKS;
    public boolean RAIN_WATER_BUCKETS;
    
    public Configuration(CobraFeats instance) {
        plugin = instance;
    }
    
    public void save() {
        reload();
        
        plugin.saveConfig();
    }
    
    public void load() {
        plugin.reloadConfig();
        
        SILK_TOUCH_SPAWNERS = plugin.getConfig().getBoolean("silk-touch-spawners", false);
        AESTHETIC_COMMAND_BLOCKS = plugin.getConfig().getBoolean("aesthetic-command-blocks", false);
        RAIN_WATER_BUCKETS = plugin.getConfig().getBoolean("rain-water-buckets", false);
    }
    
    public void reload() {
        load();
    }
    
    public String[] printCurrentSettings() {
        List<String> settings = new ArrayList<>();
        settings.add(ChatColor.RED + "-=/" + ChatColor.RESET + "Current Cobra Feature Status" + ChatColor.RED + "\\=-");
        
        settings.add(ChatColor.GOLD + "Silk Touch Spawners: " + statusCheck(SILK_TOUCH_SPAWNERS));
        settings.add(ChatColor.GOLD + "Aesthetic Command Blocks: " + statusCheck(AESTHETIC_COMMAND_BLOCKS));
        settings.add(ChatColor.GOLD + "Rain Water Buckers: " + statusCheck(RAIN_WATER_BUCKETS));
        
        return settings.toArray(new String[settings.size()]);
    }
    
    public String statusCheck(Boolean toCheck) {
        if(toCheck)
            return (ChatColor.GREEN + "Enabled");
        else
            return (ChatColor.GRAY + "Disabled");
    }
}
