package net.aesircraft.AesirCraftRegistrar;
import java.net.InetAddress;
import org.bukkit.entity.Player;


public class Check
{
    public static void run(Player player){
		if (!(Filer.exist(player)))
				{
					player.sendMessage("§4You need to register on §bhttp://aesircraft.net§4, login, go to Profile, Select Memberships, and activate your account under AesirCraft!");
					return;
				}
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.midguardian")&&Filer.exist(player))
				{
					Filer.setJoined(player);
					String rank=Filer.rank(player);
					String rank2=Filer.getRank(player);
					if (rank.equals("nopromote") 
							&& !rank2.toLowerCase().equals("avalice") 
							&& !rank2.toLowerCase().equals("avalice+")
							&& !rank2.toLowerCase().equals("kasavaer")
							&& !rank2.toLowerCase().equals("kasavaer+")
							&& !rank2.toLowerCase().equals("ambassador")
							&& !rank2.toLowerCase().equals("registrar")
							&& !rank2.toLowerCase().equals("norn")
							&& !rank2.toLowerCase().equals("aesir")
							&& !rank2.toLowerCase().equals("cookiemonster")
							&& !rank2.toLowerCase().equals("highaesir")
							&& !rank2.toLowerCase().equals("lordaesir")){
					rank="AvAlice or Higher";
					}
					if (!Filer.promote(player)){
						if (Filer.plus(player))
						Filer.setRankSafe(player, rank+"+");
						else
							Filer.setRankSafe(player, rank);
					}
					Filer.failDelete(player);
					runPromote(player);
				}
		if (!Filer.joined(player) && !Filer.promote(player)){
			return;
		}
		runJoined(player);		
		Filer.setOverride(player);
	}
	
	public static void runPromote(Player player){
		if (!Filer.promote(player))
			return;
		String rank=Filer.rank(player);
		String rank2=Filer.getRank(player);
		if (rank.equals("nopromote") || Filer.nextRank(rank2).toLowerCase().equals("nopromote")){
			if (!rank2.equals("AvAlice or Higher")&&Filer.override(player)){
				Filer.setPromote(player);
				Filer.setOverride(player);
				Filer.failDelete(player);
				Filer.setRank(player, rank2);
				player.sendMessage("§2You have been promoted!");
				return;
			}
			player.sendMessage("§4You are a non-promotable rank.");
			Filer.setPromote(player);
			Filer.setOverride(player);
			Filer.failDelete(player);
			return;
		}
		if (Filer.override(player)){
			rank=Filer.getRank(player);
			Filer.setPromote(player);
			Filer.setOverride(player);
			Filer.failDelete(player);
			Filer.setRank(player, rank);
			player.sendMessage("§2You have been promoted!");
			return;
			
		}
		if (Filer.warns(player) && !Filer.failExist(player)){
			player.sendMessage("§4You have warnings, submitting for Staff Approval.");
			if (Filer.plus(player))
				Filer.setRankSafe(player, Filer.nextRank(Filer.rank(player))+"+");
			else
				Filer.setRankSafe(player, Filer.nextRank(Filer.rank(player)));
			Filer.failedProxy(player);
			return;
		}
		rank=Filer.nextRank(rank);
		Filer.setPromote(player);
		Filer.setOverride(player);
		Filer.failDelete(player);
		if (Filer.plus(player))
		Filer.setRank(player, rank+"+");
		else
			Filer.setRank(player, rank);
		player.sendMessage("§2You have been promoted!");
		return;
		
	}
	public static void runJoined(Player player){
		if (!Filer.joined(player))
			return;	
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.midguardian")){
			Filer.setJoined(player);
			return;
		}
		InetAddress iAddress= player.getAddress().getAddress();
		String ip=iAddress.toString();
		String comp="/"+Filer.ip(player);
		if (!(comp.equals(ip))){
			if (Filer.override(player)){
				Filer.setJoined(player);
				Filer.setOverride(player);
				Filer.failDelete(player);
				Filer.setRank(player, "Midguardian");
				player.sendMessage("§2You have been promoted to Member, WELCOME TO AesirCraft!");	
				return;
			}
			Filer.failedProxy(player);
			player.sendMessage("§4Ip doesn't match registration. Proxies are not allowed. You have been submitted for Staff Approval.");
			return;
		}
		Filer.setJoined(player);
		Filer.setOverride(player);
		Filer.failDelete(player);
		Filer.setRank(player, "Midguardian");
		player.sendMessage("§2You have been promoted to Member, WELCOME TO AesirCraft!");	
		return;
	}
}
