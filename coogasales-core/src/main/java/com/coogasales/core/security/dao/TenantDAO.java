package com.coogasales.core.security.dao;

import java.util.Set;

import com.coogasales.core.PersistentObjectDAO;
import com.coogasales.core.security.Tenant;

public interface TenantDAO extends PersistentObjectDAO<Tenant> {

	/**
	 * Finds a tenant by name.
	 * 
	 * @param name name of wanted tenant
	 * 
	 * @return Wanted tenant or null.
	 */
	public Tenant findByName(String name);

	/**
	 * Retrieves all the tenant names
	 */
	public Set<String> findAllNames();

	/**
	 * Counts the total number of tenants
	 */
	public int count();
}