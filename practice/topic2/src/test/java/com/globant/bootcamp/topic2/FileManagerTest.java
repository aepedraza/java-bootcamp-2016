package com.globant.bootcamp.topic2;

import static org.junit.Assert.*;
import static com.globant.bootcamp.topic2.FileManager.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileManagerTest {

	FileManager fileManager;
	
	@Before
	public void setUp() throws Exception {
		fileManager = new FileManager();
	}

	@After
	public void tearDown() throws Exception {
		fileManager = null;
	}

	@Test
	public void firstRunWithRecentFileListEmpty() {
		assertTrue(fileManager.getRecentFilesList().isEmpty());
	}
	
	@Test
	public void fileOpenedIsAddedToRecentFileList() {
		File added = new File("file1", 1.5f);
		fileManager.openFile(added);
		
		assertEquals(1, fileManager.getRecentFilesList().size());
		assertTrue(fileManager.getRecentFilesList().contains(added));
	}
	
	@Test
	public void ClosedFileRemovedFromOpenFilesList() {
		File file = new File("file1", 2.0f);
		fileManager.openFile(file);
		fileManager.closeFile(file);
		
		assertTrue(fileManager.getOpenFilesList().isEmpty());
		assertEquals(1, fileManager.getRecentFilesList().size());
		assertTrue(fileManager.getRecentFilesList().contains(file));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void AttemptToCloseInexistentFileThrowsException(){
		fileManager.closeFile(new File("xxx", 1f));
	}
	
	@Test
	public void FileReopenedBumpedToTopNotDuplicated() {
		File file1 = new File("file1", 2.3f);
		File file2 = new File("file2", 0.5f);
		
		fileManager.openFile(file1);
		fileManager.openFile(file2);
		fileManager.closeFile(file2);
		
		assertEquals(1, fileManager.getOpenFilesList().size());
		assertEquals(2, fileManager.getRecentFilesList().size());
		
		fileManager.openFile(file2);
		
		assertEquals(file2, fileManager.getRecentFilesList().get(0));
		assertEquals(2, fileManager.getRecentFilesList().size());
	}
	
	@Test
	public void fullRecentFileListRemovesLastElement() {
		// 11 files added, first opened should be removed
		addElevenFiles();
		
		assertEquals(MAX_RECENT_FILES + 1, fileManager.getOpenFilesList().size());
		assertEquals(MAX_RECENT_FILES, fileManager.getRecentFilesList().size());
		assertEquals("file11", fileManager.getRecentFilesList().get(0).getName());
		assertEquals("file2", fileManager.getRecentFilesList().get(MAX_RECENT_FILES - 1).getName());
	}

	
	
	@Test
	public void fileReopenedAddedToFullRecentFilesList() {
		addElevenFiles();
		
		File fileClosedReopened = fileManager.getOpenFilesList().get(1);
		assertEquals("file2", fileClosedReopened.getName());
		
		fileManager.closeFile(fileClosedReopened);
		fileManager.openFile(fileClosedReopened);
		
		assertEquals(MAX_RECENT_FILES + 1, fileManager.getOpenFilesList().size());
		assertEquals(MAX_RECENT_FILES, fileManager.getRecentFilesList().size());
		assertEquals("file2", fileManager.getRecentFilesList().get(0).getName());
		assertEquals("file3", fileManager.getRecentFilesList().get(MAX_RECENT_FILES - 1).getName());
		
	}
	
	private void addElevenFiles() {
		for(int i = 1; i <= MAX_RECENT_FILES + 1; i++) {
			fileManager.openFile(new File("file" + i, i));
		}
	}
}
