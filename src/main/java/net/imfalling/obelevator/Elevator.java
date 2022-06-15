package net.imfalling.obelevator;

import net.imfalling.obelevator.mixin.CooldownMixin;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;

public class Elevator extends Block {
    
    public Elevator(Settings settings){
        super(settings);
    }

    static int MAXIMUM_TELEPORT_HEIGHT = 32;
    int COOLDOWN = 0;

    static void playWoosh(PlayerEntity player){
        if (!player.world.isClient) {
            player.world.playSound(
                    null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                    new BlockPos(player.getPos()), // The position of where the sound will come from
                    ExampleMod.WOOSH_EVENT, // The sound that will play
                    SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                    1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                    1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
            );
        }
    }

    public static void onPlayerJump(LivingEntity living){
        if(living instanceof PlayerEntity player){
            //Find block under player
            Position playerPos = new Vec3d(living.getX(), living.getY() -1, living.getZ());
            Block underFeet = player.world.getBlockState(new BlockPos(playerPos)).getBlock();
            int jumpingCooldown = ((CooldownMixin) player).getJumpingCooldown();
            if(player.isOnGround() && jumpingCooldown == 0){
                //If block is an elevator
                if(underFeet instanceof Elevator elevator){
                    //player.sendMessage(new LiteralText("Elevator!"), false);
                    Block comparison;
                    Position compcoord;
                    //Find other elevator in range
                    for(int i = 2; i <= MAXIMUM_TELEPORT_HEIGHT; i++){
                        compcoord = new Vec3d(living.getX(), living.getY() + i, living.getZ());
                        comparison = player.world.getBlockState(new BlockPos(compcoord)).getBlock();
                        if(comparison.getClass() == underFeet.getClass()){
                            //player.sendMessage(new LiteralText("Teleport!"), false);
                            //Teleport!
                            player.requestTeleport(compcoord.getX(), compcoord.getY()+1, compcoord.getZ());
                            playWoosh(player);
                            ((CooldownMixin)player).setJumpingCooldown(10);

                            break;
                        }
                    }
                }
            }
        }  
    }
    public static void onPlayerSneak(LivingEntity living){
        if(living instanceof PlayerEntity player){
            if(player.isSneaking()){
                //Find block under player
                Position playerPos = new Vec3d(living.getX(), living.getY() -1, living.getZ());
                Block underFeet = player.world.getBlockState(new BlockPos(playerPos)).getBlock();
                //If block is an elevator
                if(underFeet instanceof Elevator elevator){
                    //player.sendMessage(new LiteralText("Elevator!"), false);
                    Block comparison;
                    Position compcoord;
                    //Find other elevator
                    for(int i = 4; i <= MAXIMUM_TELEPORT_HEIGHT; i++){
                        compcoord = new Vec3d(living.getX(), living.getY() - i, living.getZ());
                        comparison = player.world.getBlockState(new BlockPos(compcoord)).getBlock();
                        if(comparison.getClass() == underFeet.getClass()){
                            //player.sendMessage(new LiteralText("Teleport!"), false);
                            //Teleport
                            player.requestTeleport(compcoord.getX(), compcoord.getY() + 1, compcoord.getZ());
                            playWoosh(player);
                            break;
    
                        }
                    }
                }
            }
        }
    }
}
