package net.boypika;

import net.boypika.config.ModConfig;
import net.boypika.sword.DragonWhacker;
import net.boypika.sword.WardenWhacker;
import net.boypika.sword.WitherWhacker;
import net.fabricmc.api.ModInitializer;
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
            WITHER_WHACKER = new WitherWhacker(Tiers.DIAMOND, new Item.Properties().rarity(Rarity.UNCOMMON).attributes(SwordItem.createAttributes(Tiers.DIAMOND, -3, -3.5f)));
        }
        if (config().DragonWhacker){
            DRAGON_WHACKER = new DragonWhacker(Tiers.NETHERITE, new Item.Properties().fireResistant().rarity(Rarity.EPIC).attributes(SwordItem.createAttributes(Tiers.NETHERITE, -4, -3.9f)));
        }
        if (config().WardenWhacker){
            WARDEN_WHACKER = new WardenWhacker(Tiers.NETHERITE, new Item.Properties().fireResistant().rarity(Rarity.RARE).attributes(SwordItem.createAttributes(Tiers.NETHERITE, -4, -3.6f)));
        }
    }

    @Override
    public void onInitialize() {
        ConfigManager.init(new ModConfig(), Constants.MOD_ID);
        registerItems();
        if (config().WitherWhacker){
            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, "wither_whacker"), WITHER_WHACKER);
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(Items.NETHERITE_SWORD, WITHER_WHACKER));
        }
        if (config().DragonWhacker) {
            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, "dragon_whacker"), DRAGON_WHACKER);
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(Items.NETHERITE_SWORD, DRAGON_WHACKER));
        }
        if (config().WardenWhacker) {
            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, "warden_whacker"), WARDEN_WHACKER);
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(Items.NETHERITE_SWORD, WARDEN_WHACKER));
        }
        System.out.println("[1.20.5] Boss Whackers Init");
    }
    public static ModConfig config() {
        return (ModConfig) ConfigManager.get(Constants.MOD_ID);
    }
}