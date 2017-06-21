package Model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Transactional
public interface UserRepository extends CrudRepository<User, Integer>, JpaRepository<User, Integer> {
	 @Modifying
	 @Query("UPDATE User u SET u.email = :email, u.name = :name WHERE u.id = :id")
	 void updateUser(@Param("id") Integer id, @Param("email") String email,  @Param("name") String name);
}
