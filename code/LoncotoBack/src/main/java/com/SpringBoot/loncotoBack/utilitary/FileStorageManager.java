package com.SpringBoot.loncotoBack.utilitary;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileStorageManager {
	@Value("${repertoire.stockage}")
	private File storagePath;

	private Random rd = new Random();

	public String saveFile(InputStream data) {
		if (storagePath == null || !storagePath.exists() || !storagePath.isDirectory())
			throw new RuntimeException("chemin invalide");
		String name = rd.nextLong() + "#" + LocalDateTime.now().getNano();
		String shaName = DigestUtils.sha1Hex(name);

		String sousRep = shaName.substring(0, 2);
		File rep = Paths.get(storagePath.getAbsolutePath(), sousRep).toFile();

		if (!rep.exists())
			rep.mkdirs();

		try {
			Files.copy(data, Paths.get(rep.getAbsolutePath(), shaName), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("sauvegarde impossible", e);
		}
		return shaName;
	}

	public Optional<File> readFile(String storageName) {
		if (storagePath == null || !storagePath.exists() || !storagePath.isDirectory())
			throw new RuntimeException("chemin invalide");
		String sousRep = storageName.substring(0, 2);
		File rep = Paths.get(storagePath.getAbsolutePath(), sousRep).toFile();
		if (rep.exists() && rep.isDirectory()) {
			File f = Paths.get(rep.getAbsolutePath(), storageName).toFile();
			if (f.exists() && f.isFile()) {
				return Optional.of(f);
			}
		}
		return Optional.empty();
	}

	public boolean deleteFile(String storageName) throws IOException {
		if (storagePath==null||!storagePath.exists()||!storagePath.isDirectory()) throw new RuntimeException("chemin invalide");
		String sousRep = storageName.substring(0,2);
		File rep = Paths.get(storagePath.getAbsolutePath(), sousRep).toFile();
		if(rep.exists()&&rep.isDirectory()) {
			File f = Paths.get(rep.getAbsolutePath(), storageName).toFile();
			if(f.exists()&&f.isFile()) {
				f.delete();
				DirectoryStream<Path> dirStream = Files.newDirectoryStream(rep.toPath());
				if(!dirStream.iterator().hasNext()) {
				        	rep.delete();
				        }
				 return true;
				    }
			}
	return false;
}

}
