package net.boypika.sword;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class DragonWhacker extends SwordItem {

    public DragonWhacker(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        if (target instanceof EnderDragon){
            target.hurt(Objects.requireNonNull(target.getLastDamageSource()), 100000000000f);
        }
        else {
            attacker.sendSystemMessage(Component.translatable("text.item.bosswhackers.event_fail_message.dragon_whacker"));
            target.heal(1f);
        }
        return true;
    }
}