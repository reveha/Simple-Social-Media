package com.reveha.userpostcomment.Mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {

    private ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().
                setAmbiguityIgnored(true).
                setMatchingStrategy(MatchingStrategies.LOOSE);
        //Response a gore tum datalari alma diyor, LOOSE birakiyor yani gevsek
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().
                setAmbiguityIgnored(true).
                setMatchingStrategy(MatchingStrategies.STANDARD);
        //Response a gore tum datalari kullan diyor.
        return this.modelMapper;
    }
}
