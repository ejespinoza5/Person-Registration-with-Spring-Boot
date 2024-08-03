package ec.edu.espe.resgistropersona.registropersona.controller;

import ec.edu.espe.resgistropersona.registropersona.model.Address;
import ec.edu.espe.resgistropersona.registropersona.model.Person;
import ec.edu.espe.resgistropersona.registropersona.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //sirve para que spring sepa que es un controlador
//http://localhost:8080/person/v1/save
@RequestMapping("/person/v1/") //sirve para mapear la url
public class PersonController {

    @Autowired //sirve para inyectar la dependencia
    private PersonService personService;
    

    //savePerson
    @PostMapping(value = "/save") //sirve para mapear la url
    public Person savePerson(@RequestBody Person person){
        return personService.savePerson(person) ;
    }

    //consulta- obtener lista de personas guardadas
    @GetMapping(value = "/listPersons") //sirve para mapear la url
    public List <Person>listPersons(){
        return personService.findAll();
    }

    //delete de person por id
    @DeleteMapping(value = "/delete/{identification}") //sirve para mapear la url
    public void deletePerson(@PathVariable String identification){
        personService.deletePerson(identification);
    }

    //search by identification
    @GetMapping(value = "/search/{identification}")
    public Person searchPerson(@PathVariable String identification){
        return personService.searchPerson(identification);
    }


//    @GetMapping(value = "/homeAddress/{identification}")
//public Address getHomeAddress(@PathVariable String identification){
//    return personService.getHomeAddress(identification);
//}


    //update person by id
    @PutMapping(value = "/update/{identification}")
    public Person updatePerson(@PathVariable String identification, @RequestBody Person person){
        Person person1 = personService.searchPerson(identification);
        person1.setFirst_name(person.getFirst_name());
        person1.setLast_name(person.getLast_name());
        person1.setEmail(person.getEmail());
        return personService.savePerson(person1);
    }

    // Método para buscar la dirección de la casa de una persona
    //http://localhost:8080/person/v1/homeAddress/1111111111
    @GetMapping(value = "/homeAddress/{identification}")
    public List<Address> findHomeAddress(@PathVariable("identification") String identification) {
        return personService.findListHouseAddressByIdentification(identification);}


    // Metodo para filtrar por email y ciudad con path variable
    //http://localhost:8080/person/v1/emailAndCity/andres@gmail/com/quito

    @GetMapping(value = "/emailAndCity/{email}/{city}")
    public List<Person> findByEmailAndCity(@PathVariable("email") String email, @PathVariable("city") String city) {
        return personService.findByEmailAndCity(email, city);
    }

}
