package cx.rain.mc.takecursesoff.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EventTakeOff implements Listener {
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        var playerHelper = event.getPlayer();
        var entity = event.getRightClicked();
        if (entity instanceof Player playerHelped) {
            if (playerHelped.isSneaking() && playerHelper.isSneaking()) {
                var hand = event.getHand();
                if (playerHelper.getEquipment().getItem(hand).getType() == Material.AIR) {
                    // Todo
                }
            }
        }
    }
}
