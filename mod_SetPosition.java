package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class mod_SetPosition extends BaseMod
{
	public static int buildNumber = 1;
	private static final String set="key.set";
	private static final String go = "key.go";
	private KeyBinding key = new KeyBinding(set, 25);
	private KeyBinding keytwo=new KeyBinding(go,24);
	private static Minecraft mc = ModLoader.getMinecraftInstance();
    double X=0;
    double Y=70;
    double Z=0;
    float Pitch=0;
    float Yaw=0;
    float HYaw=0;
    long Time=0;
	@Override
	public String getVersion()
	{
		return String.format("125-%d", buildNumber);
	}

	@Override
	public void load()
	{
		ModLoader.registerKey(this, this.key, false);
		ModLoader.registerKey(this, this.keytwo, false);
		ModLoader.addLocalization(set, "set");
		ModLoader.addLocalization(go,"go");
	}

	@Override
	public void keyboardEvent(KeyBinding keybinding)
	{
		if ((keybinding == this.key) && (mc.currentScreen == null))
		{
			EntityPlayer player = mc.thePlayer;
		Minecraft minecraft=ModLoader.getMinecraftInstance();
		minecraft.ingameGUI.addChatMessage("set position!");
			X=player.posX;
			Y=player.posY;
			Z=player.posZ;
			Pitch= player.rotationPitch;
			Yaw= player.rotationYaw;
			HYaw=player.rotationYawHead;
			World world=player.worldObj;
			minecraft.ingameGUI.addChatMessage(""+world.getWorldTime());
Time=world.getWorldTime();
		}
		if((keybinding==this.keytwo)&&(mc.currentScreen==null)){
		    EntityPlayer player=mc.thePlayer;
		    player.setVelocity(0, 0, 0);
            player.rotationPitch=Pitch;
            player.rotationYaw=Yaw;
            player.rotationYawHead=HYaw;
		    player.setPosition(X,Y,Z);
		    World world=player.worldObj;
		    world.setWorldTime(Time);
		}
	}

}
