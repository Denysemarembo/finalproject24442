package com.Denyse.Final.Project.repository;

import com.Denyse.Final.Project.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, UUID> {

}
