package com.Tkk.job.config.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PathUtil {
	private static String seperator = System.getProperty("file.separator");

	private static String winPath;

	private static String linuxPath;

	private static String userPath;

	@Value("${win.base.path}")
	public void setWinPath(String winPath) {
		PathUtil.winPath = winPath;
	}

	@Value("${linux.base.path}")
	public void setLinuxPath(String linuxPath) {
		PathUtil.linuxPath = linuxPath;
	}

	@Value("${shop.relevant.path}")
	public void setShopPath(String userPath) {
		PathUtil.userPath = userPath;
	}

	public static String getImgBasePath() {

		String oString = System.getProperty("os.name");
		String basePath = "";
		if (oString.toLowerCase().startsWith("win")) {
			basePath =winPath;
		} else {
			basePath = linuxPath;
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	public static String getShopImagePath(Integer userId) {
		String imagePath = userPath + userId + "/";
		return imagePath.replace("/", seperator);
	}
}
