package com.isep.gitprofiling.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class PythonExecutor{

    @Value("${repositoryLocation}")
    private String repositoryLocation;

    public String getRepositoryLocation() {
        return repositoryLocation;
    }

    public void setRepositoryLocation(String repositoryLocation){
        this.repositoryLocation = repositoryLocation;
    }



    public String executeCommand(String filters, String gitInspectorLocation) {
        if(repositoryLocation == null) return "Repository not configured";
        String line = "";
        StringBuilder xml = new StringBuilder();
        try{
        Process p = Runtime.getRuntime().exec("python " +  gitInspectorLocation + " " + filters + " " + repositoryLocation + " --format=xml");
            System.out.println("python " +  gitInspectorLocation + " " + filters + " " + repositoryLocation + " --format=xml");
         BufferedReader is =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = is.readLine()) != null)
            xml.append(line).append("\n");
        } catch(IOException e){
            System.out.println("Error reading file!");
        }

        return xml.toString();
    }
}