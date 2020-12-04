package cl.maindesktop.demo.repository;

import cl.maindesktop.demo.entity.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("linksRepository")
public interface LinksRepository extends JpaRepository<Links, Serializable> {

}
