package com.example.mymod;


import net.fabricmc.api.ModInitializer;

public class MyMod implements ModInitializer {
	@Override
	public void onInitialize() {
		// No shared logic needed now, but good to have this here
		System.out.println("MyMod loaded!");
	}
}
