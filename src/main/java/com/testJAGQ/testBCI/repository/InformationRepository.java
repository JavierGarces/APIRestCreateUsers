package com.testJAGQ.testBCI.repository;

import com.testJAGQ.testBCI.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends CrudRepository<Usuario, String>{

}
