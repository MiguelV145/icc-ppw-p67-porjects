package ups.icc.eva_developers.ModuloProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ups.icc.eva_developers.ModuloProject.Entities.Project;

@Repository
public interface projectRepository  extends JpaRepository<Project, Long>{
    
    
}
