package net.boypika.sword;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WitherWhacker extends SwordItem {
    public WitherWhacker(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Properties properties){
        super(toolMaterial, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        if (target instanceof WitherBoss){
            target.hurt(Objects.requireNonNull(target.getLastDamageSource()), 100000000000f);
        }
        else {
            ((Player) attacker).displayClientMessage(Component.translatable("text.item.bosswhackers.event_fail_message.wither_whacker"), true);
            target.heal(1f);
        }
        return true;
    }
}