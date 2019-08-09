package com.example.boot_demo.core.service.serviceImp;

import com.example.boot_demo.core.repository.PersonRepository;
import com.example.boot_demo.core.entity.Person;
import com.example.boot_demo.core.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


/**
 * @description: ${description}
 * @author: jeloter
 * @create: 2019-08-06 11:24
 **/
@Service
@Transactional
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Person> getList() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(long id) {
        return personRepository.getOne(id);
    }

    @Override
    public Person getByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public Person add(String name, int age) {
        Person person = new Person();
        person.setAge(age);
        person.setName(name);
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public int delete(int id) {
        return personRepository.deleteByAge(id);
    }

    public Person updata(String name,Person person){
        String sql = "updata person where name ='"+name+"'";
        Query query = entityManager.createNativeQuery(sql,Person.class);
        query.executeUpdate();
        List<Person> list = query.getResultList();
        return list.get(0);
    }
}
