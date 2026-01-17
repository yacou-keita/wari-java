package com.wari.wari_java.app.core.domain.repositories;

import java.util.List;
import java.util.Optional;

public interface DomainRepository<Entity, ID>{
   void save(Entity entity);
   List<Entity> findAll();
   Optional<Entity> findByID(ID entityID);
   void delete(Entity entity);
}


