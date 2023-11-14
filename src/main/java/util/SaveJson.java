package util;

import Launch.LaunchData;
import Launch.LaunchMC;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;

public class SaveJson {
    public void save(){
        LaunchData launchData = new LaunchData(LaunchMC.versions,LaunchMC.jreVersions,LaunchMC.Model,LaunchMC.authInfo,LaunchMC.jreDir,LaunchMC.windowSizeWidth,LaunchMC.windowSizeHeight,LaunchMC.playerFunc,LaunchMC.version,LaunchMC.username,LaunchMC.directory,LaunchMC.memory,LaunchMC.authenticator);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(launchData);
            File file = new File(new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()+"/SFMC.json");
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void load(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()+"/SFMC.json");
            LaunchData launchData = mapper.readValue(file,LaunchData.class);
            LaunchMC.versions = launchData.getVersions();
            LaunchMC.jreVersions = launchData.getJreVersions();
            LaunchMC.Model = launchData.getModel();
            LaunchMC.authInfo = launchData.getAuthInfo();
            LaunchMC.jreDir = launchData.getJreDir();
            LaunchMC.windowSizeWidth = launchData.getWindowSizeWidth();
            LaunchMC.windowSizeHeight = launchData.getWindowSizeHeight();
            LaunchMC.playerFunc = launchData.getPlayerFunc();
            LaunchMC.version = launchData.getVersion();
            LaunchMC.username = launchData.getUsername();
            LaunchMC.directory = launchData.getDirectory();
            LaunchMC.memory = launchData.getMemory();
            LaunchMC.authenticator = launchData.getAuthenticator();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean exist(){
        File file = new File(new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()+"/SFMC.json");
        return file.exists();
    }
}
