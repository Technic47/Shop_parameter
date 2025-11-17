package ru.kuznetsov.shop.parameter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.parameter.model.Parameter;

import java.util.Optional;

@Repository
public interface ParameterRepository extends CrudRepository<Parameter, Long> {

    Optional<Parameter> findByKey(String key);

    Optional<Parameter> findByValue(String value);
}
