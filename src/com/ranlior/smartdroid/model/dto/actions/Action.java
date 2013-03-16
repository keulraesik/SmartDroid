/**
 * 
 */
package com.ranlior.smartdroid.model.dto.actions;

import com.j256.ormlite.field.DatabaseField;
import com.ranlior.smartdroid.model.dto.rules.Rule;

import android.content.Context;

/**
 * @author Ran Haveshush
 * Email:  ran.haveshush.shenkar@gmail.com
 *
 */
public abstract class Action {
	
	/**
	 * Holds the context that instantiate this action.
	 */
	protected Context mContext = null;
	
	/**
	 * Needed for Ormlite (many to one) relation.
	 */
	@DatabaseField(columnName="rule_id", foreign=true, foreignAutoRefresh=true, canBeNull=false)
	private Rule rule = null;
	
	/**
	 * Holds the action's identifier.
	 */
	@DatabaseField(generatedId=true)
	private long id = -1L;
	
	/**
	 * Holds the action's name.
	 */
	@DatabaseField(canBeNull=false)
	private String name = null;
	
	/**
	 * Holds the action's description.
	 */
	@DatabaseField(canBeNull=false)
	private String description = null;
	

	/**
	 * Default constractor.
	 * ORMLite needs a no-arg constructor.
	 */
	protected Action() {
		super();
	}
	
	/**
	 * Full constructor.
	 * 
	 * @param context
	 * @param rule
	 * @param name
	 * @param description
	 */
	public Action(Context context, Rule rule, String name, String description) {
		super();
		this.mContext = context;
		this.rule = rule;
		this.name = name;
		this.description = description;
	}

	/**
	 * @return the rule
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * @param rule the rule to set
	 */
	public void setRule(Rule rule) {
		this.rule = rule;
	}

	/**
	 * @return the identifier
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the identifier to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Performs the action.
	 * Every derived class should implemenet this method.
	 * This is where the action logic implemeneted.
	 */
	public abstract void perform();

}