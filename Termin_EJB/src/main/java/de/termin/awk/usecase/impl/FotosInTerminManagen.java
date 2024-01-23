package de.termin.awk.usecase.impl;

import de.termin.awk.dao.FotoDAO;
import de.termin.awk.dao.TerminDAO;
import de.termin.awk.entity.FotoTO;
import de.termin.awk.entity.TerminTO;
import de.termin.awk.entity.impl.Foto;
import de.termin.awk.entity.impl.Termin;
import de.termin.awk.usecase.IFotosInTerminManagen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.io.*;
import java.nio.file.*;
import java.util.Base64;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
public class FotosInTerminManagen implements IFotosInTerminManagen {

    @Inject
    FotoDAO fotoDAO;

    @Inject
    TerminDAO terminDAO;

    @Override
    public boolean addFoto(long fotoId, long terminId) {
        Termin t = terminDAO.find(terminId);
        Collection<Long> fotosInTermin = t.getFotos();

        if (fotosInTermin.contains(fotoId)) {
            return false;
        } else {
            t.addFoto(fotoId);
            terminDAO.update(t);
            return true;
        }
    }

    @Override
    public boolean removeFoto(long fotoId, long terminId) {
        Termin t = terminDAO.find(terminId);
        Collection<Long> fotosInTermin = t.getFotos();

        if (!(fotosInTermin.contains(fotoId))) {
            return false;
        } else {
            t.removeFoto(fotoId);
            terminDAO.update(t);
            return true;
        }
    }

    @Override
    public List<String> getAllFotosOfTermin(long terminId) {
        Termin t = terminDAO.find(terminId);
        List<Long> fotos = t.getFotos();
        
        System.out.println(t.getTerminId());
        
        List<String> images = new ArrayList<String>();
        
        
        
        for (long i : fotos) {
        	System.out.println(i);
        	Foto f = fotoDAO.find(i);
        	System.out.println();
        	images.add(imageToBase64(f.getDateipfad()));
        }
                
        return images;
    }

    @Override
    public Collection<TerminTO> getTerminOfFoto(long fotoId) {
        return null;
    }
    
    
    private static String imageToBase64(String imagePath) {
        String base64Image = "data:image/jpeg;base64,";
        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

            base64Image = base64Image + Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Image;
    }
    
}
