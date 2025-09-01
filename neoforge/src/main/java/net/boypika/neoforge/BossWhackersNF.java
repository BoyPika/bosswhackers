package net.boypika.neoforge;

import net.boypika.Constants;
import net.boypika.sword.DragonWhacker;
import net.boypika.sword.WardenWhacker;
import net.boypika.sword.WitherWhacker;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Constants.MOD_ID)
public class BossWhackersNF {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);
    public static final DeferredHolder<Item, WitherWhacker> WITHER = ITEMS.register("wither_whacker", () -> new WitherWhacker(ToolMaterial.DIAMOND, -3, -3.5f, new Item.Properties().rarity(Rarity.UNCOMMON).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "wither_whacker")))));
    public static final DeferredHolder<Item, DragonWhacker> DRAGON = ITEMS.register("dragon_whacker", () -> new DragonWhacker(ToolMaterial.NETHERITE, -4, -3.9f, new Item.Properties().fireResistant().rarity(Rarity.EPIC).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragon_whacker")))));
    public static final DeferredHolder<Item, WardenWhacker> WARDEN = ITEMS.register("warden_whacker", () -> new WardenWhacker(ToolMaterial.NETHERITE, -4, -3.6f, new Item.Properties().fireResistant().rarity(Rarity.RARE).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "warden_whacker")))));

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SWORDS = CREATIVE_MODE_TABS.register("swords",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(WITHER.get()))
                    .title(Component.translatable("creativetab.whackers"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(WITHER.get());
                        pOutput.accept(DRAGON.get());
                        pOutput.accept(WARDEN.get());
                    })
                    .build());

    public BossWhackersNF(IEventBus eventBus) {
        ITEMS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
    }
}