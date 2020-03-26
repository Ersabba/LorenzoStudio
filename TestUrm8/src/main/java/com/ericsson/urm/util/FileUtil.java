package com.ericsson.urm.util;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;


public class FileUtil {

	public static File createFile(String fileContent, String fullFileName) throws IOException {
		File file = new File(fullFileName);
		FileWriter fw = new FileWriter(file);
		fw.write(fileContent);
		fw.flush();
		fw.close();

		return file;
	}

	public static File[] findFilesByRegExpr(File dir, final String regExpr) {
		ArgumentsCheckerUtil.checkNull(dir);
		ArgumentsCheckerUtil.checkNull(regExpr);

		if (regExpr.length() == 0) {
			return dir.listFiles();
		}
		else {
			return dir.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					return Pattern.matches(regExpr, name);
				}
			});
		}
	}
}
