package games.moegirl.sinocraft.sinofoundation.data;

import com.mojang.serialization.JsonOps;
import games.moegirl.sinocraft.sinofoundation.SinoFoundation;
import games.moegirl.sinocraft.sinofoundation.biome.SFDBiomeTags;
import games.moegirl.sinocraft.sinofoundation.world.SFDFeatures;
import games.moegirl.sinocraft.sinocore.world.gen.TaggedBiomeFeatureModifier;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;

import java.util.HashMap;
import java.util.Map;


/**
 * 用于生成 BiomeModifier，应当在所有 {@link net.minecraft.data.DataProvider} 之后调用
 *
 * @author luqin2007
 */
class SFDBiomeModifierProvider extends JsonCodecProvider<BiomeModifier> {

    public SFDBiomeModifierProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, helper, SinoFoundation.MODID, JsonOps.INSTANCE, PackType.SERVER_DATA,
                "forge/biome_modifier", BiomeModifier.DIRECT_CODEC, buildModifiers());
    }

    private static Map<ResourceLocation, BiomeModifier> buildModifiers() {
        Map<ResourceLocation, BiomeModifier> map = new HashMap<>();
        try {
            map.put(SFDFeatures.Placements.JADE.location(), createOverworldOre(SFDDatapackProvider.placedJade));
            map.put(SFDFeatures.Placements.NITER.location(), createOverworldOre(SFDDatapackProvider.placedNiter));
            map.put(SFDFeatures.Placements.SULPHUR.location(), createOverworldOre(SFDDatapackProvider.placedSulphur));
            map.put(SFDFeatures.Placements.RICE.location(), createVegetal(SFDBiomeTags.SPAWN_RICE, SFDDatapackProvider.placedRice));
            map.put(SFDFeatures.Placements.REHMANNIA.location(), createVegetal(SFDBiomeTags.SPAWN_REHMANNIA, SFDDatapackProvider.placedRehmannia));
            map.put(SFDFeatures.Placements.DRAGONLIVER_MELON.location(), createVegetal(SFDBiomeTags.SPAWN_DRAGONLIVER_MELON, SFDDatapackProvider.placedDragonliverMelon));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    private static BiomeModifier createOverworldOre(Holder<PlacedFeature> feature) {
        return new TaggedBiomeFeatureModifier(BiomeTags.IS_OVERWORLD, HolderSet.direct(feature), GenerationStep.Decoration.UNDERGROUND_ORES);
    }

    private static BiomeModifier createVegetal(TagKey<Biome> tag, Holder<PlacedFeature> feature) {
        return new TaggedBiomeFeatureModifier(tag, HolderSet.direct(feature), GenerationStep.Decoration.VEGETAL_DECORATION);
    }
}
