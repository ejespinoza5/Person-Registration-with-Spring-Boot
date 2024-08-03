package ec.edu.espe.resgistropersona.registropersona.repository;

import ec.edu.espe.resgistropersona.registropersona.model.Address;
import ec.edu.espe.resgistropersona.registropersona.model.Person;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    public static final String CASA = "casa";
    List<Person> persons = new ArrayList<Person>();

    public Person save(Person person) {
        persons.add(person);
        return person;
    }

    public List<Person> findAll() {
        return persons;
    }

    public void delete(String identification) {
        for (Person person : persons) {
            if (person.getIdentification().equals(identification)) {
                persons.remove(person);
                break;
            }
        }
    }

    public Person search(String identification) {
        for (Person person : persons) {
            if (person.getIdentification().equals(identification)) {
                return person;
            }
        }
        return null;
    }

    public List<Address> findHousesAddressByIdentification(String identification) {
        return persons.stream().filter(x ->
                        x.getIdentification().equals(identification))
                .findAny().get().getAddresses().stream()
                .filter(x -> x.getAddressType().equals(CASA)).toList();
    }

//    public List<Address> findByEmailAndCity(String email, String city) {
//        return persons.stream()
//                .filter(person -> person.getEmail().equals(email))
//                .flatMap(person -> person.getAddresses().stream())
//                .filter(address -> address.getCity().equals(city))
//                .collect(Collectors.toList());
//    }

public List<Person> findByEmailAndCity(String email, String city) {
    return persons.stream()
            .filter(person -> person.getEmail().equals(email) && person.getAddresses()
                    .stream().anyMatch(address -> city.equals(address.getCity())))
            .collect(Collectors.toList());
}


}





