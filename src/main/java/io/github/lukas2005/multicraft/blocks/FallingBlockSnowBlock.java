package io.github.lukas2005.multicraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class FallingBlockSnowBlock extends BlockFalling
{
    public FallingBlockSnowBlock()
    {
        super(Material.CRAFTED_SNOW);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setRegistryName(Blocks.SNOW.getRegistryName());
        this.setUnlocalizedName(Blocks.SNOW.getUnlocalizedName().substring(5));
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.SNOWBALL;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 4;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);

        if (worldIn.getLightFor(EnumSkyBlock.BLOCK, pos) > 11)
        {
            this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
            worldIn.setBlockToAir(pos);
        }
    }
}