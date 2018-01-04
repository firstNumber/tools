package com.lyz.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {
	
	/**
	 * 保存文件
	 * @param savePath	路径
	 * @param fileName	文件名
	 * @param fileData	文件
	 * @throws IOException
	 */
	public static void saveFile(String savePath, String fileName, MultipartFile fileData) throws IOException {
		File fileDir = new File(savePath);
		if (!fileDir.exists()) { // 先创建目录
			fileDir.mkdirs();
		}
		FileOutputStream out;
		try {
			out = new FileOutputStream(savePath + File.separator + fileName);
			out.write(fileData.getBytes());
			out.flush();
			out.close();
		} catch (IOException e) {
			throw e;
		}
	}
}
