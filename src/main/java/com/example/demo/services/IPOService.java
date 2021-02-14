package com.example.demo.services;

import com.example.demo.dto.IpoDetailsDto;
import com.example.demo.exceptions.runtimeExceptions.BadRequestException;
import com.example.demo.exceptions.runtimeExceptions.EntityNotFoundException;
import com.example.demo.models.IPODetails;
import com.example.demo.repository.IPODetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created By : arshia on 06/02/21
 **/
@Service
public class IPOService {

    private static final Logger logger = LoggerFactory.getLogger(IPOService.class);

    @Autowired
    private IPODetailsRepository ipoDetailsRepository;

    public String createNewIPODetails(IpoDetailsDto ipoDetailsDto){
        IPODetails ipoDetails = ipoDetailsRepository.findByName(ipoDetailsDto.getName());

        if(Objects.nonNull(ipoDetails)){
            logger.error("IPO : {} already present. Try again!", ipoDetailsDto.getName());
            throw new BadRequestException("IPO : "+ipoDetailsDto.getName()+" already present. Try again!");
        }

        ipoDetails = new IPODetails();
        ipoDetails.setName(ipoDetailsDto.getName());
        ipoDetails.setLowerBandPrice(ipoDetailsDto.getLowerBandPrice());
        ipoDetails.setUpperBandPrice(ipoDetailsDto.getUpperBandPrice());
        ipoDetails.setExpiry(ipoDetailsDto.getExpiryDate());
        ipoDetailsRepository.save(ipoDetails);
        return "New ipo created!";
    }

    public IPODetails getIPODetailsByName(String ipoName){
        IPODetails ipoDetails = ipoDetailsRepository.findByName(ipoName);

        if(Objects.isNull(ipoDetails)){
            logger.error("No ipo details found for name : {}", ipoName);
            throw new BadRequestException("No ipo details found for name : "+ipoName);
        }

        return ipoDetails;
    }

    public List<IpoDetailsDto> getIPODetails(){
        List<IPODetails> ipoDetailsList = ipoDetailsRepository.findAll();

        if(CollectionUtils.isEmpty(ipoDetailsList)){
            logger.error("No ipo details found");
            throw new EntityNotFoundException("No ipo details found");
        }

        List<IpoDetailsDto> ipoDetailsDtos = new ArrayList<>();
        for(IPODetails ipoDetails : ipoDetailsList){
            IpoDetailsDto ipoDetailsDto = new IpoDetailsDto();
            ipoDetailsDto.setName(ipoDetails.getName());
            ipoDetailsDto.setExpiryDate(ipoDetails.getExpiry());
            ipoDetailsDto.setLowerBandPrice(ipoDetails.getLowerBandPrice());
            ipoDetailsDto.setUpperBandPrice(ipoDetails.getUpperBandPrice());
            ipoDetailsDtos.add(ipoDetailsDto);
        }

        return ipoDetailsDtos;
    }
}
