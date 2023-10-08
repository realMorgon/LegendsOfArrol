package de.morgon.LegendsOfArrol.Logs;

import de.morgon.LegendsOfArrol.configs.LogConfig;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Log implements Listener {

    @EventHandler
    public void onJoinEvent (PlayerJoinEvent e) {

        Player p = e.getPlayer();
        String local = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(Calendar.getInstance().getTime());
        double Y = p.getLocation().getY() + 1.5;

        LogConfig.get().set( "[" + local + "]" + p.getName() + " joined the game" , p.getLocation().getX() + ", " + Y + ", " + p.getLocation().getZ());
        LogConfig.save();

    }


    @EventHandler
    public void onleft (PlayerQuitEvent e) {
        Player p = e.getPlayer();
        String local = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(Calendar.getInstance().getTime());
        double Y = p.getLocation().getY() + 1.5;


        LogConfig.get().set( "[" + local + "]" + p.getName() + " left the game" , p.getLocation().getX() + ", " + Y + ", " + p.getLocation().getZ());
        LogConfig.save();
    }



}
