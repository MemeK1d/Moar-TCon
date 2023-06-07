package com.existingeevee.moretcon.compat.jei;

import java.util.ArrayList;
import java.util.List;

import com.existingeevee.moretcon.inits.ModBlocks;
import com.existingeevee.moretcon.inits.ModFluids;
import com.existingeevee.moretcon.inits.ModItems;
import com.existingeevee.moretcon.other.utils.CompatManager;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IIngredientType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class JeiInit {

	public static final List<JeiCustomContainer> CUSTOM = new ArrayList<>();

	public static void init(IModRegistry registry) {
		IIngredientType<FluidStack> fluidstack = registry.getIngredientRegistry().getIngredientType(FluidStack.class);
		IIngredientType<ItemStack> itemstack = registry.getIngredientRegistry().getIngredientType(ItemStack.class);

		CUSTOM.add(new JeiHideBadToolparts());

		CUSTOM.add(new JeiBlacklistContainer<ItemStack>(new ItemStack(ModItems.iconLightning), () -> CompatManager.thebetweenlands));

		CUSTOM.add(new JeiInformationContainer<FluidStack>(fluidstack, new FluidStack(ModFluids.liquidMummySludge, 1000), "Obtained by melting down a Dreadful Peat Mummy.", () -> CompatManager.thebetweenlands));

		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreFusionite, 1), "Found extremely rarely in all stonebearing dimensions from y = 1 <-> 3.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreIrradium, 1), "Found more or less commonly in all stonebearing dimensions from y = 12 <-> 32.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreVoidSpar, 1), "Found rare-ish-ly in all stonebearing dimensions or bedrockbearing from y = 1 <-> 3.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreNaturalVoidSpar, 1), "Found rare-ish-ly commonly in all stonebearing or bedrockbearing dimensions from y = 12 <-> 32.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreEnderal, 1), "Found rare-ish-ly in all endstone-bearing dimensions from y = 12 <-> 32.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreGallium, 1), "Found very rarely in all stonebearing dimensions from y = 12 <-> 24.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreEchostone, 1), "Found rare-ish-ly in all endstone-bearing dimensions from y = 12 <-> 48.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreGarstone, 1), "Found extremely rarely in all stonebearing dimensions from y = 75 <-> 100.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreGravitonium, 1), "Found astronomically rarely in the end inside of floating asteroids. Asteroids are generated approx. one in 2500 chunks.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreGravitoniumDense, 1), "Found astronomically rarely in The End inside of floating asteroids. Asteroids are generated approx. one in 2500 chunks.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreIgniglomerate, 1), "Found rarely in The Nether within the lava lake.", () -> CompatManager.loadMain));
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreBloodstone, 1), "Found commonly in The Nether above the bedrock roof.", () -> CompatManager.loadMain));
		
		CUSTOM.add(new JeiInformationContainer<ItemStack>(itemstack, new ItemStack(ModBlocks.oreArkenium, 1), "Found rarely in all holystone-bearing dimensions from y = 5 <-> 250.", () -> CompatManager.aether_legacy));

	}

}