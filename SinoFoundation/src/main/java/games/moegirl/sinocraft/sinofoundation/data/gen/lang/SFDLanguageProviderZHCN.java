package games.moegirl.sinocraft.sinofoundation.data.gen.lang;

import games.moegirl.sinocraft.sinocore.data.gen.AbstractLanguageProvider;
import games.moegirl.sinocraft.sinofoundation.SFDConstants;
import games.moegirl.sinocraft.sinofoundation.block.SFDBlockItems;
import games.moegirl.sinocraft.sinofoundation.block.SFDBlocks;
import games.moegirl.sinocraft.sinofoundation.item.SFDItems;
import games.moegirl.sinocraft.sinofoundation.item.SinoSeriesTabs;
import net.minecraft.data.PackOutput;

public class SFDLanguageProviderZHCN extends AbstractLanguageProvider {
    public SFDLanguageProviderZHCN(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    public void translate() {
        addTab(SinoSeriesTabs.BUILDING_BLOCKS, "华夏系列 | 建筑方块");
        addTab(SinoSeriesTabs.FUNCTIONAL_BLOCKS, "华夏系列 | 功能性方块");
        addTab(SinoSeriesTabs.AGRICULTURE, "华夏系列 | 农业");
        addTab(SinoSeriesTabs.TOOLS, "华夏系列 | 工具与实用物品");
        addTab(SinoSeriesTabs.WEAPONS, "华夏系列 | 战斗用品");
        addTab(SinoSeriesTabs.MATERIALS, "华夏系列 | 原材料");
        addTab(SinoSeriesTabs.MISC, "华夏系列 | 杂项");

        addItem(SFDItems.IRON_KNIFE, "铁质小刀");
        addItem(SFDItems.GOLD_KNIFE, "金质小刀");
        addItem(SFDItems.DIAMOND_KNIFE, "钻石小刀");
        addItem(SFDItems.ASHES, "炉灰");
        addItem(SFDItems.TREE_BARK, "树皮");
        addItem(SFDItems.MILLET, "小米");
        addItem(SFDItems.CHILI_PEPPER, "辣椒");
        addItem(SFDItems.GREEN_PEPPER, "青椒");
        addItem(SFDItems.CABBAGE, "卷心菜");
        addItem(SFDItems.EGGPLANT, "茄子");
        addItem(SFDItems.BLACK_JADE, "墨玉");
        addItem(SFDItems.GREEN_JADE, "青玉");
        addItem(SFDItems.RED_JADE, "碧玉");
        addItem(SFDItems.WHITE_JADE, "白玉");
        addItem(SFDItems.YELLOW_JADE, "黄玉");
        addItem(SFDItems.NITER, "硝石");
        addItem(SFDItems.SULPHUR, "硫磺");
        addItem(SFDItems.JUJUBE, "枣");
        addItem(SFDItems.SEED_WORMWOOD, "艾草种子");
        addItem(SFDItems.WORMWOOD_LEAF, "艾草叶");
        addItem(SFDItems.RICE, "稻米");
        addItem(SFDItems.SEED_RICE, "糯稻种子");
        addItem(SFDItems.SESAME, "芝麻");
        addItem(SFDItems.SEED_SESAME, "巨胜种子");

        addBlock(SFDBlocks.STOVE, "灶台");
        addBlock(SFDBlocks.WOOD_DESK, "木桌子");
        addBlock(SFDBlocks.WOOD_CHAIRS, "木椅子");
        addBlock(SFDBlocks.WHITE_RADISH_PLANT, "白萝卜");
        addBlock(SFDBlocks.SUMMER_RADISH_PLANT, "水萝卜");
        addBlock(SFDBlocks.GREEN_RADISH_PLANT, "青萝卜");
        addBlock(SFDBlocks.CHILI_PEPPER_PLANT, "辣椒");
        addBlock(SFDBlocks.GREEN_PEPPER_PLANT, "青椒");
        addBlock(SFDBlocks.EGGPLANT_PLANT, "茄子");
        addBlock(SFDBlocks.CABBAGE_PLANT, "卷心菜");
        addBlock(SFDBlocks.MILLET_PLANT, "小米");
        addBlock(SFDBlocks.SOYBEAN_PLANT, "大豆");
        addBlock(SFDBlocks.GARLIC_PLANT, "大蒜");
        addBlock(SFDBlocks.MARBLE_BLOCK, "大理石");
        addBlock(SFDBlocks.SMOOTH_MARBLE, "平滑大理石");
        addBlock(SFDBlocks.MARBLE_PILLAR, "大理石柱");
        addBlock(SFDBlocks.CHISELED_MARBLE_BLOCK, "雕纹大理石");
        addBlock(SFDBlocks.MARBLE_SLAB, "大理石台阶");
        addBlock(SFDBlocks.MARBLE_STAIRS, "大理石楼梯");
        addBlock(SFDBlocks.MARBLE_WALLS, "大理石墙");
        addBlock(SFDBlocks.SMOOTH_MARBLE_SLAB, "平滑大理石台阶");
        addBlock(SFDBlocks.SMOOTH_MARBLE_STAIRS, "平滑大理石楼梯");
        addBlock(SFDBlocks.BLACK_JADE_ORE, "墨玉原石");
        addBlock(SFDBlocks.DEEPSLATE_BLACK_JADE_ORE, "深层墨玉原石");
        addBlock(SFDBlocks.GREEN_JADE_ORE, "青玉原石");
        addBlock(SFDBlocks.DEEPSLATE_GREEN_JADE_ORE, "深层青玉原石");
        addBlock(SFDBlocks.RED_JADE_ORE, "碧玉原石");
        addBlock(SFDBlocks.DEEPSLATE_RED_JADE_ORE, "深层碧玉原石");
        addBlock(SFDBlocks.WHITE_JADE_ORE, "白玉原石");
        addBlock(SFDBlocks.DEEPSLATE_WHITE_JADE_ORE, "深层白玉原石");
        addBlock(SFDBlocks.YELLOW_JADE_ORE, "黄玉原石");
        addBlock(SFDBlocks.DEEPSLATE_YELLOW_JADE_ORE, "深层黄玉原石");
        addBlock(SFDBlocks.NITER_ORE, "硝石矿石");
        addBlock(SFDBlocks.SULPHUR_ORE, "硫磺矿石");
        addBlock(SFDBlocks.NETHER_SULPHUR_ORE, "下界硫磺矿石");
        addBlock(SFDBlocks.DEEPSLATE_SULPHUR_ORE, "深层硫磺矿石");
        addBlock(SFDBlocks.JUJUBE_CHEST, "枣心木匣");
        addBlock(SFDBlocks.JUJUBE_TRAPPED_CHEST, "枣心木机关匣");
        addBlock(SFDBlocks.WORMWOOD, "艾草");
        addBlock(SFDBlocks.RICE, "糯稻");
        addBlock(SFDBlocks.SESAME, "巨胜");
        addBlock(SFDBlocks.LANTERN, "灯笼");
        addBlock(SFDBlocks.STONE_LANTERN, "石灯");

        addItem(SFDBlockItems.CHILI_PEPPER_SEED, "辣椒种子");
        addItem(SFDBlockItems.GREEN_PEPPER_SEED, "青椒种子");
        addItem(SFDBlockItems.EGGPLANT_SEED, "茄子种子");
        addItem(SFDBlockItems.CABBAGE_SEED, "卷心菜种子");
        addItem(SFDBlockItems.MILLET_SEED, "稻谷");

        add(SFDConstants.TRANSLATE_STOVE_FULL_OF_ASHES, "灶台被灰烬填满了。空手右键取出灰烬，空手 Shift + 右键清除全部灰烬。");
        add(SFDConstants.TRANSLATE_STOVE_NOT_A_FUEL, "你发现手中的物品不是燃料。");
        add(SFDConstants.TRANSLATE_STOVE_EMPTY_NOW, "灶台里面现在是空的。");
    }
}
