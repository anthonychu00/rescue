package com.petshop.rescue.models;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.Predicate;

@Repository
public interface PetDAO extends PagingAndSortingRepository<Pet, Long> {
    Page<Pet> findAll(Specification<Pet> pet, Pageable page);

    default Page<Pet> findAll(Pet pet, Pageable page){
        return findAll(search(pet), page);
    }

    static Specification<Pet> search(Pet p){
        return (root, cq, cb) -> {
            Predicate predicate = cb.isTrue(cb.literal(true));
            if(p.getAnimalType() != null && !p.getAnimalType().isBlank()){
                Predicate newPredicate = cb.equal(root.get("animalType"), p.getAnimalType());
                predicate = cb.and(predicate, newPredicate);
            }
            if(p.getAge() >= 0){
                Predicate newPredicate = cb.equal(root.get("age"), p.getAge());
                predicate = cb.and(predicate, newPredicate);
            }
            return predicate;
        };
    }
}