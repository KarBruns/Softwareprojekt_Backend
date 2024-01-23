package de.termin.awk.usecase.impl;

import de.termin.awk.dao.FotoDAO;
import de.termin.awk.entity.FotoTO;
import de.termin.awk.entity.impl.Foto;
import de.termin.awk.usecase.IFotosManagen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.GpsDirectory;

import java.util.Collection;
import java.util.logging.Logger;

@Stateless
public class FotosManagen implements IFotosManagen {
	
	@Inject
	FotoDAO fotoDAO;
	
	private static final Logger logger = Logger.getLogger(FotosManagen.class.getName());
	
	
    @Override
    public boolean deleteFoto(long id) {
        return fotoDAO.delete(id);
    }

    @Override
    public long createFoto(String imageString) {

    	double latitude = 0;
    	double longitude = 0;
    	String path = convertImage(imageString);
    	
    	if (path != null) {
    		
        	try {
                File imageFile = new File(path);
                Metadata metadata = ImageMetadataReader.readMetadata(imageFile);
                
//                logger.warning("###Moin###   " + metadata);

                
                GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
                
//                logger.warning("###Moin###   " + gpsDirectory);
//                logger.warning("###Moin###   " + gpsDirectory.getGeoLocation());
//                logger.warning("###Moin###   " + gpsDirectory.getGeoLocation().getLatitude());
//                
//                Iterator<Tag> tags = gpsDirectory.getTags().iterator();
//                
//                while (tags.hasNext()) {
//                    Tag tag = tags.next();
//                    logger.warning("###TAGS###   Tag: " + tag.getTagName() + ", Value: " + tag.getDescription());
//                }
       

                if (gpsDirectory != null && gpsDirectory.getGeoLocation() != null) {
                    latitude = gpsDirectory.getGeoLocation().getLatitude();
                    longitude = gpsDirectory.getGeoLocation().getLongitude();
                } 
                
            } catch (ImageProcessingException | IOException e) {
                e.printStackTrace();
            }
        	
        	Foto f = new Foto();
        	f.setDateipfad(path);
        	f.setLatitude(latitude);
        	f.setLongitude(longitude);
        	
        	if (fotoDAO.save(f)) {
            	return f.getFotoId();
            } else {
            	return 0;
            }
        	
    	} else {
    		return 0;
    	}
        
    }

    @Override
    public Collection<FotoTO> getAllFotos() {
        return null;
    }

    @Override
    public FotoTO findFoto(long id) {
        return null;
    }


	private String convertImage(String imageString) {
		
		try {
			
			String[] parts = imageString.split(",");
            String imageData = parts[1];
            imageData = imageData.substring(0, imageData.length() - 2);
            
            byte[] imageBytes = Base64.getDecoder().decode(imageData);

            String uniqueFileName = "image_" + System.currentTimeMillis(); 

            
            String outputPath = "/home/bruns/Bilder/";
            String outputFile = outputPath + uniqueFileName + ".jpeg"; 

            Files.createDirectories(Paths.get(outputPath));
            Files.write(Paths.get(outputFile), imageBytes);

            return outputFile;
            
            
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
}
