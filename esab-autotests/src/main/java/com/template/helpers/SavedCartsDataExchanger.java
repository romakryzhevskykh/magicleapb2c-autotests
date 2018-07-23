package com.template.helpers;

import org.springframework.stereotype.Component;

@Component
public class SavedCartsDataExchanger {
	private int savedCartsCount = 0;

	public int getSavedCartsCount() {
		return savedCartsCount;
	}

	public void setSavedCartsCount(int savedCartsCount) {
		this.savedCartsCount = savedCartsCount;
	}
}
