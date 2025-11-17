package ru.kuznetsov.shop.parameter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.parameter.model.Parameter;
import ru.kuznetsov.shop.parameter.repository.ParameterRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParameterService {

    private final ParameterRepository parameterRepository;

    public boolean containsParameter(String key) {
        return parameterRepository.findByKey(key).isPresent();
    }

    public Iterable<Parameter> findAll() {
        return parameterRepository.findAll();
    }

    public Optional<Parameter> findById(Long id) {
        return parameterRepository.findById(id);
    }

    public Optional<Parameter> findByKey(String key) {
        return parameterRepository.findByKey(key);
    }

    public Optional<Parameter> findByValue(String value) {
        return parameterRepository.findByValue(value);
    }

    public Parameter save(String key, String value) {
        Parameter p = new Parameter();
        p.setKey(key);
        p.setValue(value);
        return parameterRepository.save(p);
    }

    public Parameter save(String key, String value, String comment) {
        Parameter p = new Parameter();
        p.setKey(key);
        p.setValue(value);
        p.setComment(comment);
        return parameterRepository.save(p);
    }

    public Parameter save(Parameter parameter) {
        return parameterRepository.save(parameter);
    }

    public Parameter update(String key, String value) {
        deleteByKey(key);
        return save(key, value);
    }

    public void deleteById(Long id) {
        parameterRepository.deleteById(id);
    }

    public void deleteByKey(String key) {
        findByKey(key).ifPresent(parameterRepository::delete);
    }

    public String getParameterValueString(String key) {
        return getParameterValue(key);
    }

    public Long getParameterValueLong(String key) {
        String parameterValue = getParameterValue(key);
        try {
            return Long.parseLong(parameterValue);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Parameter value parsing error. " + e.getMessage());
        }
    }

    private String getParameterValue(String key) {
        return findByKey(key).orElseThrow(() -> new RuntimeException("Parameter with key " + key + " not found")).getValue();
    }
}
