package com.existingeevee.moretcon.traits.modifiers;

import com.existingeevee.moretcon.other.Misc;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;

public class Crushing extends ModifierTrait {

	public Crushing() {
		super(Misc.createNonConflictiveName("modcrushing"), 0x555555);
		this.addItem(Item.getItemFromBlock(Blocks.IRON_BLOCK), 2, 1);
		this.addAspects(new ModifierAspect.SingleAspect(this));
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {
		DamageSource source = player instanceof EntityPlayer ? DamageSource.causePlayerDamage((EntityPlayer) player)
				: DamageSource.causeMobDamage(player);
		Misc.executeInNTicks(() -> Misc.trueDamage(target, newDamage * 0.1f, source, true), 1);
		return super.damage(tool, player, target, damage, newDamage * 0.9f, isCritical);
	}
}
