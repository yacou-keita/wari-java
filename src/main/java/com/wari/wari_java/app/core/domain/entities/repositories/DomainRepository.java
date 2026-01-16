package com.wari.wari_java.app.core.domain.entities.repositories;

import java.util.List;
import java.util.Optional;

public interface DomainRepository<Entity, ID>{
   void save(Entity entity);
   List<Entity> findAll();
   Optional<Entity> findByID(ID entityID);
   void delete(ID entityID);
   void update(ID entityID, Entity entity);
}


