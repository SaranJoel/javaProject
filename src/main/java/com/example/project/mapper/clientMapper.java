package com.example.project.mapper;

import com.example.project.dto.clientDto;
import com.example.project.dto.projectDto;
import com.example.project.model.client;
import com.example.project.model.project;

import java.util.List;
import java.util.stream.Collectors;

public class clientMapper {

    public static clientDto mapToclientDto(client client){

        return new clientDto(
                client.getClient_id(),
                client.getClient_name(),
                client.getCompany_name(),
                client.getClient_email(),
                client.getAddress(),
                client.getPhone(),
                client.getIndustry()
        );
    }

    public static client mapToclient(clientDto dto){

        return new client(
                dto.getClient_id(),
                dto.getClient_name(),
                dto.getCompany_name(),
                dto.getClient_email(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getIndustry()
        );
    }
}
