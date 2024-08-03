package ec.edu.espe.resgistropersona.registropersona.service;

import ec.edu.espe.resgistropersona.registropersona.model.Address;
import ec.edu.espe.resgistropersona.registropersona.model.Person;
import ec.edu.espe.resgistropersona.registropersona.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public static final Logger log = LoggerFactory.getLogger(PersonService.class);

    public Person savePerson(Person person){
        convertAttributesToUpperCase(person);
        log.warn("vamos a guardar una persona " );
        return personRepository.save(person);
    }

    private void convertAttributesToUpperCase(Person person) {
        person.setIdentification(person.getIdentification().toUpperCase());
        person.setFirst_name(person.getFirst_name().toUpperCase());
        person.setLast_name(person.getLast_name().toUpperCase());
        person.setEmail(person.getEmail().toUpperCase());
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    //delete person
    public void deletePerson(String identification){
        personRepository.delete(identification);
    }

    //search person
    public Person searchPerson(String identification){
        return personRepository.search(identification);
    }

//    public Address getHomeAddress(String identification) {
//    Person person = this.searchPerson(identification);
//    if (person != null) {
//        for (Address address : person.getAddresses()) {
//            if ("casa".equals(address.getAddressType())) {
//                return address;
//            }
//        }
//    }
//    return null;
//}

    //update person
    public Person updatePerson(String identification, Person person){
        Person person1 = personRepository.search(identification);
        person1.setFirst_name(person.getFirst_name());
        person1.setLast_name(person.getLast_name());
        person1.setEmail(person.getEmail());
        return personRepository.save(person1);
    }

    public List<Address> findListHouseAddressByIdentification(String identification){
        return personRepository.findHousesAddressByIdentification(identification);
    }

    public List<Person> findByEmailAndCity(String email, String city) {
        return personRepository.findByEmailAndCity(email, city);
    }

}