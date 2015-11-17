package se.cag.mongolab.usermanager;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Project:SpringBootTry
 * User: fredrik
 * Date: 15/11/15
 * Time: 15:51
 */

public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);

    @Query("{'email': ?0, 'password': ?1 }")
    User login(String email, String password);
}
