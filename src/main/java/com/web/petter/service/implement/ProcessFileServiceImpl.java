package com.web.petter.service.implement;

import com.web.petter.model.Pet;
import com.web.petter.service.api.FileService;
import com.web.petter.service.api.PetServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
class FileServiceImpl implements FileService {

    @Autowired
    private PetServiceAPI petServiceAPI;

    public void process(MultipartFile file){
        BufferedReader br;
        if (!file.isEmpty()) {
            try {
                String line;
                InputStream is = file.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    petServiceAPI.save(Pet.builder()
                            .petId(Integer.parseInt(data[0].trim()))
                            .petName(data[1])
                            .nitProvider(Long.parseLong(data[2].trim()))
                            .buyPrice(Double.parseDouble(data[3].trim()))
                            .ivaPrice(Double.parseDouble(data[4].trim()))
                            .salePrice(Double.parseDouble(data[5].trim()))
                            .build());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
