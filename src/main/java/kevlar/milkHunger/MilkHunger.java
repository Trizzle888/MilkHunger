package kevlar.milkHunger;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MilkHunger extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Milk will now restore hunger.");
        // Register the event listener
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Milk will no longer restore hunger.");
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        // Check if the consumed item is a milk bucket
        if (event.getItem().getType() == Material.MILK_BUCKET) {
            Player player = event.getPlayer();

            // Restore hunger and saturation
            player.setFoodLevel(20); // Maximum hunger
            player.setSaturation(5.0f); // Set saturation to 5

            // Notify the player
            player.sendMessage("The milk bucket has quenched your thirst!");
        }
    }
}
