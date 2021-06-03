package com.example.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * This is immutable class
 * 
 * String, Integer, Boolean
 * 
 */
//The class must be declared as final 
public final class NetworkConfig {
	
	//Data members in the class must be declared as private & final
	private final String host;
	private final int port;
	private final List<String> properties;
	
	// A parameterized constructor should initialize all the fields performing a deep copy
	NetworkConfig(String host, int port, List<String> properties) {
		super();
		this.host = host;
		this.port = port;
		List<String> temp = new ArrayList<>();
		for(String property: properties) {
			temp.add(property);
		}
		this.properties = temp;
	}
	// No setters (To not have the option to change the value of the instance variable)
	
	public String getHost() {
		return new String(host);
	}
	
	public int getPort() {
		return port;
	}
	
	// Perform cloning of mutable objects while returning from getter method
	public ArrayList<String> getProperties(){
		return (ArrayList<String>) ((ArrayList) properties).clone();
	}
	
	public void printConfig() {
		System.out.print("List of config --> ");
		for(String property : properties) {
			System.out.print(property + " ");
		}
	}
	
	public static void main(String[] args) { 
		NetworkConfig netConfig = new NetworkConfig("localhost", 5252, Arrays.asList("config1","config2"));
		System.out.println("Hash code of netConfig instance " + netConfig.hashCode());
		netConfig.printConfig();
		
		// try to modify config
		netConfig.getProperties().add("config3");
		netConfig.getProperties().add(1 , "configNew");
		System.out.println("\nHash code of netConfig instance " + netConfig.hashCode());
		netConfig.printConfig();
		
		// this is reference to same instance , here state is preserved but cant modify
		NetworkConfig netConfig2 = netConfig;
		System.out.println("\nHash code of netConfig2 instance " + netConfig2.hashCode());
	}
}
