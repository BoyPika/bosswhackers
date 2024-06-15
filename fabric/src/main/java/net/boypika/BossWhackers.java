package net.boypika;

import net.boypika.config.ModConfig;
import net.boypika.sword.DragonWhacker;
import net.boypika.sword.WardenWhacker;
import net.boypika.sword.WitherWhacker;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import top.offsetmonkey538.monkeyconfig538.ConfigManager;

public class BossWhackers implements ModInitializer {

    public static SwordItem WITHER_WHACKER;
    public static SwordItem DRAGON_WHACKER;
    public static SwordItem WARDEN_WHACKER;

    public static void registerItems() {
        if (config().WitherWhacker){
            WITHER_WHACKER = new WitherWhacker(Tiers.DIAMOND, -3, -3.5f, new FabricItemSettings().rarity(Rarity.UNCOMMON));
        }
        if (config().DragonWhacker){
            DRAGON_WHACKER = new DragonWhacker(Tiers.NETHERITE, -4,-3.9f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
        }
        if (config().WardenWhacker){
            WARDEN_WHACKER = new WardenWhacker(Tiers.NETHERITE, -4, -3.6f, new FabricItemSettings().fireproof().rarity(Rarity.RARE));
        }
    }

    @Override
    public void onInitialize() {
        ConfigManager.init(new ModConfig(), Constants.MOD_ID);
        registerItems();
        if (config().WitherWhacker){
            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, "wither_whacker"), WITHER_WHACKER);
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.accept(WITHER_WHACKER));
        }
        if (config().DragonWhacker) {
            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, "dragon_whacker"), DRAGON_WHACKER);
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.accept(DRAGON_WHACKER));
        }
        if (config().WardenWhacker) {
            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, "warden_whacker"), WARDEN_WHACKER);
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.accept(WARDEN_WHACKER));
        }
        System.out.println("[1.19.3 - 1.20.4] Boss Whackers Init");
    }
    public static ModConfig config() {
        return (ModConfig) ConfigManager.get(Constants.MOD_ID);
    }
}
