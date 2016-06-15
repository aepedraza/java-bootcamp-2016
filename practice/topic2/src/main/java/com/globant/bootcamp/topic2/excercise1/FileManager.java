package com.globant.bootcamp.topic2.excercise1;

import java.util.ArrayList;
import java.util.List;

public class FileManager {
	private List<File> recentFilesList;
	private List<File> openFilesList;
	static final int MAX_RECENT_FILES = 10;

	public FileManager() {
		recentFilesList = new ArrayList<>();
		openFilesList = new ArrayList<>();
	}

	public List<File> getRecentFilesList() {
		return recentFilesList;
	}

	public List<File> getOpenFilesList() {
		return openFilesList;
	}

	public void openFile(File file) {
		getOpenFilesList().add(file);
		if(recentFilesList.contains(file))	recentFilesList.remove(file);
		if(recentFilesList.size() == MAX_RECENT_FILES) recentFilesList.remove(MAX_RECENT_FILES - 1);
		recentFilesList.add(0, file);
	}

	public void closeFile(File file) {
		if(openFilesList.contains(file)) getOpenFilesList().remove(file);
		else throw new IllegalArgumentException("File not opened!");
	}
}
