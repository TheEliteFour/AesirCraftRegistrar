/**          (C) Copyright 2011 Contex <contexmoh@gmail.com>
	
This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License. 
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/ 
or send a letter to Creative Commons, 171 Second Street, Suite 300, San Francisco, California, 94105, USA.

**/

package net.aesircraft.AesirCraftRegistrar;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class playerListener extends PlayerListener
{
  public static AesirCraftRegistrar plugin;

	public playerListener(AesirCraftRegistrar instance)
	{
		plugin = instance;
	}
 public static void send(Player player){
	 if (!AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.midguardian")){
		player.sendMessage("§4You need to register on §bhttp://aesircraft.net§4, login, go to Profile, Select Memberships, and activate your account under AesirCraft!"); 
		player.sendMessage("§eThis is why you cannot speak or build!");
	 }
 }
@Override
  public void onPlayerChat(PlayerChatEvent event)
  {
	 Player player=event.getPlayer(); 
	 send(player);
	 
  }
 @Override
	public void onPlayerInteract(PlayerInteractEvent event)
{
    Player player=event.getPlayer();
	send(player);
}
}