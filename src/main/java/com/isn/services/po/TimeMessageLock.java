package com.isn.services.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TimeMessageLock extends MessageLock {

	private Date freeTime;
	
	public TimeMessageLock(Date freeTime){
		this.freeTime = freeTime;
	}
	
	@Override
	public boolean unlock() {

		if(freeTime != null){
			Date now = new Date();
			return now.getTime() > freeTime.getTime();
		}
		return false;
	}

	@Column
	public Date getFreeTime() {
		return freeTime;
	}
	
	protected void setFreeTime(Date freeTime) {
		this.freeTime = freeTime;
	}
}
