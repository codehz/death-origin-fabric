package one.codehz.mcmod.deathorigin.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.apace100.origins.registry.ModItems;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.item.ItemStack;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;

@Mixin(PlayerManager.class)
public class PlayerManagerMxn {
    @Inject(method = "respawnPlayer", at = @At("TAIL"))
    public void respawnPlayer(ServerPlayerEntity _player, boolean alive,
            CallbackInfoReturnable<ServerPlayerEntity> info) {
        if (!alive) {
            ServerPlayerEntity player = info.getReturnValue();
            ItemStack stack = new ItemStack(ModItems.ORB_OF_ORIGIN);
            player.dropStack(stack);
        }
    }
}
