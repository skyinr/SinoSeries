package games.moegirl.sinocraft.sinofoundation.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

/**
 * 带有 Block 与 Item 之间的关系，但没有放置等相关功能的物品
 */
public class SimpleBlockItem extends Item {

    public final Block block;

    public SimpleBlockItem(Properties pProperties, Supplier<? extends Block> block) {
        super(pProperties);
        this.block = block.get();
        Item.BY_BLOCK.put(this.block, this);
    }

    public SimpleBlockItem(Supplier<? extends Block> block) {
        this(new Properties(), block);
    }

    public String getDescriptionId() {
        return block.getDescriptionId();
    }
}
