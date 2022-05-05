package fr.gixy.listeners;

import fr.gixy.Main;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener {

    private final Main main;

    public EntityDeath(Main main) {

        this.main = main;


    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        Entity entity = event.getEntity();


        if (main.getPetsEntity().get(0).equals(entity)) {
            main.getPetsEntity().clear();


        }
    }

}
