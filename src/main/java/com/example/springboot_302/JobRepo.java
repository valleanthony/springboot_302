package com.example.springboot_302;

import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<Job,Long> {
}
