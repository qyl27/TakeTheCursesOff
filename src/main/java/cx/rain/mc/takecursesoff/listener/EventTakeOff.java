package cx.rain.mc.takecursesoff.listener;

import cx.rain.mc.takecursesoff.Constants;
import cx.rain.mc.takecursesoff.TakeTheCursesOff;
import cx.rain.mc.takecursesoff.managers.ConfigManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.logging.Logger;

public class EventTakeOff implements Listener {
    private final ConfigManager configManager;
    private final Logger logger;

    public EventTakeOff(TakeTheCursesOff plugin) {
        configManager = plugin.getConfigManager();
        logger = plugin.getLogger();
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        var playerHelper = event.getPlayer();
        var entity = event.getRightClicked();
        if (entity instanceof Player playerHelped) {
            if (playerHelped.isSneaking() && playerHelper.isSneaking()) {
                var hand = event.getHand();
                if (playerHelper.getEquipment().getItem(hand).getType() == Material.AIR) {
                    if (!playerHelper.hasPermission(Constants.PERMISSION)) {
                        return;
                    }

                    EquipmentSlot slot;
                    if (playerHelped.getEquipment().getHelmet() != null && playerHelped.getEquipment().getHelmet().containsEnchantment(Enchantment.BINDING_CURSE)) {
                        slot = EquipmentSlot.HEAD;
                    } else if (playerHelped.getEquipment().getChestplate() != null && playerHelped.getEquipment().getChestplate().containsEnchantment(Enchantment.BINDING_CURSE)) {
                        slot = EquipmentSlot.CHEST;
                    } else if (playerHelped.getEquipment().getLeggings() != null && playerHelped.getEquipment().getLeggings().containsEnchantment(Enchantment.BINDING_CURSE)) {
                        slot = EquipmentSlot.LEGS;
                    } else if (playerHelped.getEquipment().getBoots() != null && playerHelped.getEquipment().getBoots().containsEnchantment(Enchantment.BINDING_CURSE)) {
                        slot = EquipmentSlot.FEET;
                    } else {
                        return;
                    }

                    logger.info("Player " + playerHelper.getName() + " helped " + playerHelped.getName() + " to take off curse at " + slot + ".");
                    playerHelper.getEquipment().setItemInMainHand(playerHelped.getEquipment().getItem(slot));
                    playerHelped.getEquipment().setItem(slot, null);
                    playerHelper.sendMessage(configManager.getTranslated(Constants.TAKE_OFF_FOR_OTHER, playerHelped.getName()));
                    playerHelped.sendMessage(configManager.getTranslated(Constants.TAKE_OFF_BY_OTHER, playerHelper.getName()));
                    event.setCancelled(true);
                }
            }
        }
    }
}
