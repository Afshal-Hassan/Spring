package com.example.restapis.Repository;

import com.example.restapis.Model.ShareContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareContainerRepository extends JpaRepository<ShareContainer,Integer> {
}
