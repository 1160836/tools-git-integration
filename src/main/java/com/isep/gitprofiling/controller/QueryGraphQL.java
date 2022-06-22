package com.isep.gitprofiling.controller;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.isep.gitprofiling.model.*;
import com.isep.gitprofiling.utils.PythonExecutor;
import com.isep.gitprofiling.utils.SonarExecutor;
import com.isep.gitprofiling.utils.XMLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class QueryGraphQL extends Thread implements GraphQLQueryResolver{

    @Autowired
    private PythonExecutor pythonExecutor;

    @Autowired
    private XMLReader xmlReader;

    @Autowired
    private SonarExecutor sonarExecutor;

    @Value("${gitInspectorLocations}")
    private String gitInspectorLocations;

    private List<Report> reportsThreads = Collections.synchronizedList(new ArrayList<>());


    /*
    Configuration of a repository
    @param location
     */
    public String configureLocalRepository(String location){
        return sonarExecutor.configureLocalRepository(location);
    }

    public String getRepositoryBitBucket(String username,String password,String repository,String repositoryName){
        return sonarExecutor.getRepositoryBitBucket(username,password,repository,repositoryName);
    }

    public Report reportByAuthor(String author){
        String x = pythonExecutor.executeCommand("-x \"author:^(?!(" +author+"))\" ",gitInspectorLocations);
        return xmlReader.parseXML(x).get(0);
    }

    public List<Report> reportAllAuthorsMultipleInstances(List<String>authors) throws InterruptedException {
        reportsThreads = new ArrayList<>();
        List<NewThread> list = new LinkedList<>();
        for(String s :authors){
            NewThread t = new NewThread(s);
            list.add(t);
            t.start();
        }
        for (NewThread t1 : list)t1.join();
        return reportsThreads;

    }

    public List<Report> reportAllAuthors(){
        String x = pythonExecutor.executeCommand("" ,gitInspectorLocations);
        return xmlReader.parseXML(x);

    }

    public Report reportByAuthorTimeInterval(String author,String startDate, String endDate){
        String x = pythonExecutor.executeCommand("-x \"author:^(?!(" +author+"))\" --since="+startDate + " --until=" + endDate,gitInspectorLocations);
        return xmlReader.parseXML(x).get(0);
    }

    public List<Report> reportAllAuthorTimeInterval(String startDate, String endDate){
        String x = pythonExecutor.executeCommand("--since="+startDate + " --until=" + endDate,gitInspectorLocations);
        return xmlReader.parseXML(x);
    }

    public String createAccessTokenSonar(String nameToken){
        return sonarExecutor.createAccessTokenSonar(nameToken);
    }

    public String createProjectFromBitbucket(String clientId,String clientSecret,String key,String workspace){
        return sonarExecutor.createProjectFromBitbucket(clientId,clientSecret,key,workspace);
    }

    public Metric getMetricsSonar(){
        return sonarExecutor.getMetrics();
    }

    public TypeMetric getTypeMetricsSonar(){
        return sonarExecutor.getTypeMetrics();
    }

    public Issue getIssuesSonar(List<String>author){
        return sonarExecutor.getIssuesSonar(author);
    }

    public Measure getMeasuresSonar(String projectKey,List<String>metrics){
        return sonarExecutor.getMeasuresSonar(projectKey,metrics);
    }

    public class NewThread extends Thread {

        private String author;


        public NewThread(String author) {
            this.author = author;
        }


        public void run() {
            int i = 0;
                System.out.println(this.getName() + ": New Thread is running..." + i++);
                reportsThreads.add(reportByAuthor(author));
        }
    }





}
