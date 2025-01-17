package com.existingeevee.moretcon.traits.traits;

import com.existingeevee.moretcon.other.Misc;
import com.existingeevee.moretcon.traits.traits.abst.DurabilityShieldTrait;

import net.minecraft.item.ItemStack;
import thebetweenlands.api.item.ICorrodible;

public class Oxide extends DurabilityShieldTrait {

	public Oxide() {
		super(Misc.createNonConflictiveName("oxide"), 0);
		this.showShieldRemaining = false;
	}

	@Override
	public int getShieldMax(ItemStack stack) {
		if (!(stack.getItem() instanceof ICorrodible)) {
			return 0;
		}
		ICorrodible corrodible = (ICorrodible) stack.getItem();
		return corrodible.getMaxCorrosion(stack);
	}

	@Override
	public int getShieldRemaining(ItemStack stack) {
		if (!(stack.getItem() instanceof ICorrodible)) {
			return 0;
		}
		ICorrodible corrodible = (ICorrodible) stack.getItem();
		return corrodible.getCorrosion(stack);
	}

	@Override
	public int setShieldRemaining(ItemStack stack, int amount) {
		if (!(stack.getItem() instanceof ICorrodible)) {
			return 0;
		}
		ICorrodible corrodible = (ICorrodible) stack.getItem();
		corrodible.setCorrosion(stack, amount);
		return amount;
	}

}
