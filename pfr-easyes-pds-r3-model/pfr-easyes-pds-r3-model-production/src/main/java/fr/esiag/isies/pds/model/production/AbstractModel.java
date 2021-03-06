package fr.esiag.isies.pds.model.production;

import java.util.Date;

/**
 * 
 * @author PFR
 *
 */
public class AbstractModel {
	
	/**
	 * id of model which use to identify one entity
	 */
	private int id;

	/**
	 * updateDate
	 */
	private Date updateDate;

	/**
	 * createDate
	 */
	private Date createDate;

	/**
	 * updateUser
	 */
	private String updateUser;

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
