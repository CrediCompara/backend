package com.finanza.cc_backend.service;

import com.finanza.cc_backend.domain.model.Rate;
import com.finanza.cc_backend.domain.model.Term;
import com.finanza.cc_backend.domain.model.Value;
import com.finanza.cc_backend.domain.repository.RateRepository;
import com.finanza.cc_backend.domain.repository.TermRepository;
import com.finanza.cc_backend.domain.repository.ValueRepository;
import com.finanza.cc_backend.domain.service.RateService;
import com.finanza.cc_backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private TermRepository termRepository;

    @Autowired
    private ValueRepository valueRepository;

    @Override
    public List<Rate> getRatesByTermAndValue(double term, double value, String currency) {
        List<Term> term2 = termRepository.getTermBasedOnTermValue(term);
        List<Value> value2 = valueRepository.getValueBasedOnPValue(value, currency);
        List<Rate> rateList = new ArrayList<Rate>();

        if (term2.size() == 0){
            throw new ResourceNotFoundException("Term", "value", term);
        }else{
            if (value2.size() == 0) {
                throw new ResourceNotFoundException("Property Value", "value", value);
            }
        }
        for(int i = 0; i < term2.size(); i++){
            for(int j = 0; j < value2.size(); j++){
              rateList = Stream.concat(rateList.stream(),
                      rateRepository.findByTermAndValue(term2.get(i), value2.get(j)).stream())
                      .collect(Collectors.toList());
            }
        }
        return rateList;
    }
}
