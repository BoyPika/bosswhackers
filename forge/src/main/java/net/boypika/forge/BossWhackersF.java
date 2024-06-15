package net.boypika.forge;

import net.boypika.Constants;
import net.boypika.sword.DragonWhacker;
import net.boypika.sword.WardenWhacker;
import net.boypika.sword.WitherWhacker;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Constants.MOD_ID)
public class BossWhackersF {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final RegistryObject<SwordItem> WITHER = ITEMS.register("wither_whacker", () -> new WitherWhacker(Tiers.DIAMOND, -3, -3.5f, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<SwordItem> DRAGON = ITEMS.register("dragon_whacker", () -> new DragonWhacker(Tiers.NETHERITE, -4, -3.9f, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<SwordItem> WARDEN = ITEMS.register("warden_whacker", () -> new WardenWhacker(Tiers.NETHERITE, -4, -3.6f, new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SWORDS = CREATIVE_MODE_TABS.register("swords",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(WITHER.get()))
                    .title(Component.translatable("creativetab.whackers"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(WITHER.get());
                        pOutput.accept(DRAGON.get());
                        pOutput.accept(WARDEN.get());
                    })
                    .build());
    
    public BossWhackersF() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}