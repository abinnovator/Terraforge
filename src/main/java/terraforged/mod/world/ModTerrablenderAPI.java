package terraforged.mod.world;

import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;
import net.minecraft.util.Identifier;
import terraforged.mod.Terraforged;

public class ModTerrablenderAPI implements TerraBlenderApi {

    public void onInitialize()
    {

    }

    public void onTerraBenderInitialized() {
        // This adds our biome to the list of Overworld biomes
        Regions.register(new OverworldRegion(Identifier.of(Terraforged.MOD_ID, "overworld"), 5));

        // This is for advanced surface generation, which we don't need right now
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Terraforged.MOD_ID, ModSurfaceRuleData.makeRules());
    }
}