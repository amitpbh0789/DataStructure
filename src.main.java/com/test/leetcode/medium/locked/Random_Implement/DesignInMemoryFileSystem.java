package com.test.leetcode.medium.locked.Random_Implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-in-memory-file-system/description/
 * Implement the FileSystem class:

 FileSystem() Initializes the object of the system.

API1: List<String> ls(String path)
		If path is a file path, returns a list that only contains this file's name.
		If path is a directory path, returns the list of file and directory names in this directory. 
		The answer should in lexicographic order.

API2: void mkdir(String path)
API3: void addContentToFile(String filePath, String content)
String readContentFromFile(String filePath)

Time:
Space: 

 */
public class DesignInMemoryFileSystem {

}

class FileSystem{
	Dir root;

	public FileSystem() {
		root = new Dir();
	}

	// List down all the files in sorted order
	public List<String> ls(String path) {
		
		Dir temp = root;
		List<String> ans = new ArrayList<>();
		
		if(!path.equals("/")) {
			String[] pathDirs = path.split("/");
			
			for(int i=1; i<pathDirs.length-1; i++) {
				temp = temp.dirs.get(pathDirs[i]);
			}
			// if file found 
			if(temp.files.containsKey(pathDirs[pathDirs.length-1])) {
				// file matches hence returning path as required
				ans.add(pathDirs[pathDirs.length-1]);
				return ans;
			} else {
				temp = temp.dirs.get(pathDirs[pathDirs.length-1]);
			}
		}
		
		ans.addAll(new ArrayList<>(temp.dirs.keySet()));
		ans.addAll(new ArrayList<>(temp.files.keySet()));
		// sorting the result
		Collections.sort(ans);
		return ans;

	}

	public void mkdir(String path) {
		Dir temp = root;
		String[] pathDirs = path.split("/");
		
		for(int i=1; i<pathDirs.length-1; i++) {
			if(!temp.dirs.containsKey(pathDirs[i])) {
				temp.dirs.put((pathDirs[i]), new Dir());
			}
			temp = temp.dirs.get(pathDirs[i]);
		}
	}

	public void addContentToFile(String filePath, String content) {
		Dir temp = root;
		String[] pathDirs = filePath.split("/");
		
		for(int i=1; i<pathDirs.length-1; i++) {
			temp = temp.dirs.get(pathDirs[i]);
		}
		
		// Adding to existing file or creating new file and then adding content
		temp.files.put(pathDirs[pathDirs.length-1], temp.files.getOrDefault(pathDirs[pathDirs.length-1], "")+content);
	}

	public String readContentFromFile(String filePath) {
		Dir temp = root;
		String[] pathDirs = filePath.split("/");
		
		for(int i=1; i<pathDirs.length-1; i++) {
			temp = temp.dirs.get(pathDirs[i]);
		}
		
		return temp.files.get(pathDirs[pathDirs.length-1]);
	}
}

class Dir{
	Map<String, Dir> dirs = new HashMap<>();
	Map<String, String> files = new HashMap<>();
}