package springTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springTest.dao.MyDao;
import springTest.dao.PersonDao;
import springTest.model.Person;
import org.hibernate.Session;


@Service
public class PersonService implements MyService<Person> {

    @Autowired
    PersonDao personDao;


    public void initDb(Session session) {
        personDao.create(session, new Person("lol@bob.com", "Bob", "Crazy"));
        personDao.create(session, new Person("amazing@wahoo.com", "Wahoo", "Amazing"));
        personDao.create(session, new Person("something@something.com", "Something", "Something"));
    }

    public void createPerson(Session session, String email, String firstName, String lastName) {
        personDao.create(session, new Person(email, firstName, lastName));
    }

    public boolean personExists(Session session, String email) {
        return personDao.exists(session, Person.class, email);
    }

    @Override
    public MyDao<Person> getMainDao() {
        return personDao;
    }
}
