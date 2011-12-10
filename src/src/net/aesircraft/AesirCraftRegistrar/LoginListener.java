package net.aesircraft.AesirCraftRegistrar;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class LoginListener extends PlayerListener
{
	public static AesirCraftRegistrar plugin;

	public LoginListener(AesirCraftRegistrar instance)
	{
		plugin = instance;
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Check.run(event.getPlayer());
		return;
	}
}
