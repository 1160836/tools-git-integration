package com.isep.gitprofiling.utils;

import com.isep.gitprofiling.model.*;
import org.apache.tomcat.util.descriptor.web.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.jsf.FacesContextUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;;


@Service
public class SonarExecutor {

    @Value("${sonarQubeLocations}")
    private String sonarQubeLocation;

    @Value("${repositoryLocation}")
    private String repositoryLocation;

    @Value("${userSonar}")
    private String userSonar;

    @Value("${passSonar}")
    private String passSonar;

    @Autowired
    private ApplicationContext appContext;


    public void setRepositoryLocation(String repositoryLocation){
        this.repositoryLocation = repositoryLocation;
    }


    public String configureLocalRepository(String location){
        setRepositoryLocation(location);
        PythonExecutor pythonExec = (PythonExecutor)appContext.getBean("pythonExecutor");
        pythonExec.setRepositoryLocation(location);
        if(!pythonExec.getRepositoryLocation().equals(location) || !repositoryLocation.equals(location)) return "Error configuring repository location";
        return "Repository configured with success!";
    }

    public String getRepositoryBitBucket(String username,String appPassword,String repository,String projectName){
        String path = null;
        try{
            path = "git clone " + "https://" + username + ":" + appPassword + "@" + repository;
            Runtime.getRuntime().exec(path);
        } catch (IOException e) {
            return e.getMessage();
        }
        return configureLocalRepository(projectName);
    }

    public String createAccessTokenSonar(String nameToken) {
        Token token = null;
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
            map.add("name", nameToken);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(userSonar,passSonar));
            String resourceUrl = sonarQubeLocation + "/api/user_tokens/generate";
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
            token = restTemplate.postForObject(resourceUrl, request, Token.class);
        }catch (HttpClientErrorException e){
            return e.getResponseBodyAsString();
        }
        return token.getToken();
    }

    public String createProjectFromBitbucket(String clientId,String clientSecret,String key,String workspace){
        String s = null;
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
            map.add("clientId", clientId);
            map.add("clientSecret",clientSecret);
            map.add("key",key);
            map.add("workspace",workspace);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(userSonar,passSonar));
            String resourceUrl = sonarQubeLocation + "/api/alm_settings/create_bitbucketcloud";
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
            s = restTemplate.postForObject(resourceUrl, request, String.class);
        }catch (HttpClientErrorException e){
            return e.getResponseBodyAsString();
        }
        return s;

    }

    public Metric getMetrics(){
        Metric m = null;
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(userSonar,passSonar));
            String resourceUrl = sonarQubeLocation + "/api/metrics/search";
            m = restTemplate.getForObject(resourceUrl, Metric.class);
        }catch (HttpClientErrorException e){
           //
        }
        return m;

    }

    public TypeMetric getTypeMetrics(){
        TypeMetric m = null;
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(userSonar,passSonar));
            String resourceUrl = sonarQubeLocation + "/api/metrics/types";
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
            m = restTemplate.getForObject(resourceUrl, TypeMetric.class);
        }catch (HttpClientErrorException e){
            //
        }
        return m;

    }

    public Issue getIssuesSonar(List<String> author){
        Issue m = null;
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
            author.forEach(auth -> map.add("author",auth));

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(userSonar,passSonar));
            String resourceUrl = sonarQubeLocation + "/api/issues/search";
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(resourceUrl).queryParams(map);
            m = restTemplate.getForObject(builder.build().toUri(),Issue.class);
        }catch (HttpClientErrorException e){
            //
        }
        return m;
    }

    public Measure getMeasuresSonar(String projectKey, List<String> metrics){
        Measure m = null;
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
            map.add("component",projectKey);
            map.add("metricKeys",metrics.toString().substring(1,metrics.toString().length()-1));

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(userSonar,passSonar));
            String resourceUrl = sonarQubeLocation + "/api/measures/component";
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(resourceUrl).queryParams(map);
            m = restTemplate.getForObject(builder.build().toUri(),Measure.class);
        }catch (HttpClientErrorException e){
            e.printStackTrace();
        }
        return m;
    }



}

