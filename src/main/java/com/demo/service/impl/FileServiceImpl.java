package com.demo.service.impl;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		//File Name
		String name = file.getOriginalFilename();
		//abc.png
		
		//random name genreate
		String randomId = UUID.randomUUID().toString();
		String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));
		
		//full path 
		String filePath = path + File.separator +fileName1;
		
		//create if not created
		
		File f =new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		//file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath =path + File.separator +fileName;
		InputStream is = new FileInputStream(fullPath);
		return is;
	}
	
}
