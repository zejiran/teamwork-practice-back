package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import co.edu.uniandes.dse.treeking.entities.BlogEntity;
import co.edu.uniandes.dse.treeking.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




/**
 * Clase que implementa los servicios de la lógica de la entidad Blog.Para esto, se conecta a la clase que maneja la persistencia BlogRepository. 
 *
 * @author ISIS2603
 */


@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    /**
     * Obtiene la lista de los registros de Blog.
     *
     * @return Colección de objetos de BlogEntity.
     */
    @Transactional
    public List<BlogEntity> getBlogs() {
        return blogRepository.findAll();
    }
}
